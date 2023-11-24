package com.mycompany.cepa3hibernate;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Libros")
public class Libro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "libroID")
    private int libroID;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "isbn")
    private String isbn;

    @ManyToOne
    private Autor autor;

    @ManyToOne
    private Editorial editorial;

    public Libro() {
    }

    public Libro(String titulo, String isbn, Autor autor, Editorial editorial) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
        this.editorial = editorial;
    }

    public int getLibroID() {
        return libroID;
    }

    public void setLibroID(int libroID) {
        this.libroID = libroID;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    @Override
    public String toString() {
        return "Libro{" + "libroID=" + libroID + ", titulo=" + titulo + ", isbn=" + isbn + ", autor=" + autor + ", editorial=" + editorial + '}';
    }
}
