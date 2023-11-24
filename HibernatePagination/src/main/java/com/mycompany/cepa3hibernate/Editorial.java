package com.mycompany.cepa3hibernate;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Editoriales")
public class Editorial implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "editorialID")
    private int editorialID;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "direccion")
    private String direccion;

    public Editorial() {
    }

    public Editorial(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public int getEditorialID() {
        return editorialID;
    }

    public void setEditorialID(int editorialID) {
        this.editorialID = editorialID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Editorial{" + "editorialID=" + editorialID + ", nombre=" + nombre + ", direccion=" + direccion + '}';
    }
}
