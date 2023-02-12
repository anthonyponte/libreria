/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.anthonyponte.libreria.service;

import com.anthonyponte.libreria.pojo.Autor;
import com.anthonyponte.libreria.repository.AutorRepository;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * @author anthony
 */
@Service
public class AutorService {
  private final AutorRepository repository;

  public AutorService(AutorRepository repository) {
    this.repository = repository;
  }

  public List<Autor> readAll() {
    return repository.readAll();
  }

  public List<Autor> readAll(String autor) {
    return repository.readAll(autor);
  }

  public Autor read(int id) {
    return repository.read(id);
  }

  public Autor save(Autor autor) {
    return repository.save(autor);
  }

  public void delete(int id) {
    repository.deleteById(id);
  }
}
