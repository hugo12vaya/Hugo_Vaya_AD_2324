package com.mycompany.cepa3hibernate;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Autores")
public class Autor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "autorID")
    private int autorID;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "nacionalidad")
    private String nacionalidad;

    @OneToMany(mappedBy = "autor")
    private List<Libro> libros;

    public Autor() {
    }

    public Autor(String nombre, String nacionalidad) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }

    public int getAutorID() {
        return autorID;
    }

    public void setAutorID(int autorID) {
        this.autorID = autorID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    @Override
    public String toString() {
        return "Autor{" + "autorID=" + autorID + ", nombre=" + nombre + ", nacionalidad=" + nacionalidad + ", libros=" + libros + '}';
    }
}
