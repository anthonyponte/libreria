/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.anthonyponte.libreria.repository;

import com.anthonyponte.libreria.pojo.Autor;
import com.anthonyponte.libreria.pojo.Libro;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author anthony
 */
@Repository
public interface BookRepository extends JpaRepository<Libro, Integer> {
  @Query("FROM Libro l ORDER BY l.titulo")
  public List<Libro> readAll();

  @Query("FROM Libro l WHERE l.autor.id = ?1 ORDER BY l.titulo")
  public List<Libro> readAll(int autorId);

  @Query("FROM Libro l WHERE l.titulo LIKE %?1% ORDER BY l.titulo")
  public List<Libro> readAll(String titulo);

  @Query("FROM Libro l WHERE l.id = ?1")
  public Libro read(int id);

  @Query("FROM Autor a ORDER BY a.apellido")
  public List<Autor> readAutors();
}
