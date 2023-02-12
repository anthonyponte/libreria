/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.anthonyponte.libreria.controller;

import com.anthonyponte.libreria.pojo.Autor;
import com.anthonyponte.libreria.pojo.Libro;
import com.anthonyponte.libreria.service.BookService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author anthony
 */
@Controller
public class BookController {
  private final BookService service;

  public BookController(BookService service) {
    this.service = service;
  }

  @RequestMapping("/")
  public String readBooks(Model model) {
    List<Libro> libros = service.readAll();
    model.addAttribute("libros", libros);
    return "books";
  }

  @RequestMapping("/autor/link")
  public String linkAutor(int autorId, Model model) {
    List<Libro> libros = service.readAll(autorId);
    model.addAttribute("libros", libros);
    return "books";
  }

  @RequestMapping("/books/search")
  public String searchBooks(@RequestParam("q") String titulo, Model model) {
    List<Libro> libros = service.readAll(titulo);
    model.addAttribute("libros", libros);
    return "books";
  }

  @RequestMapping("/book/new")
  public String newBook(Model model) {
    List<Autor> autores = service.readAutors();
    model.addAttribute("autores", autores);
    model.addAttribute("libro", new Libro());
    return "book";
  }

  @PostMapping("/book/save")
  public String saveBook(Libro libro) {
    service.save(libro);
    return "redirect:/";
  }

  @RequestMapping("/book/edit")
  public String editBook(int id, Model model) {
    Libro libro = service.read(id);
    List<Autor> autores = service.readAutors();
    model.addAttribute("libro", libro);
    model.addAttribute("autores", autores);
    return "book";
  }

  @RequestMapping("/book/delete")
  public String deleteBook(int id, Model model) {
    service.delete(id);
    return "redirect:/";
  }
}
