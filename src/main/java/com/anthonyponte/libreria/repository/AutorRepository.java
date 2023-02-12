/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.anthonyponte.libreria.repository;

import com.anthonyponte.libreria.pojo.Autor;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author anthony
 */
@Repository
public interface AutorRepository extends JpaRepository<Autor, Integer> {
  @Query("FROM Autor a ORDER BY a.id")
  public List<Autor> readAll();

  @Query("FROM Autor a WHERE a.nombre LIKE %?1% OR a.apellido LIKE %?1%")
  public List<Autor> readAll(String autor);

  @Query("FROM Autor a WHERE a.id = ?1")
  public Autor read(int id);
}
