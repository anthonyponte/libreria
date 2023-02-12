/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.anthonyponte.libreria.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

/**
 * @author anthony
 */
@Entity
public class Libro {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String titulo;
  private String resumen;
  private String url;

  @ManyToOne
  private Autor autor;

  public Libro() {
  }

  public Libro(String titulo, String resumen, String url, Autor autor) {
    this.titulo = titulo;
    this.resumen = resumen;
    this.url = url;
    this.autor = autor;
  }

  public Libro(Integer id, String titulo, String resumen, String url, Autor autor) {
    this.id = id;
    this.titulo = titulo;
    this.resumen = resumen;
    this.url = url;
    this.autor = autor;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getResumen() {
    return resumen;
  }

  public void setResumen(String resumen) {
    this.resumen = resumen;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public Autor getAutor() {
    return autor;
  }

  public void setAutor(Autor autor) {
    this.autor = autor;
  }

  @Override
  public String toString() {
    return "Libro{"
        + "id="
        + id
        + ", titulo="
        + titulo
        + ", resumen="
        + resumen
        + ", url="
        + url
        + ", autor="
        + autor
        + '}';
  }
}
