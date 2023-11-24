package com.mycompany.cepa3hibernate;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class LibroDAO {

    private Session laSesion;

    public LibroDAO() {
        laSesion = HibernateUtil.getSessionFactory().openSession();
    }

    // Insertar un libro
    public void insertLibro(Libro libro) {
        try {
            laSesion.getTransaction().begin();
            laSesion.save(libro);
            laSesion.getTransaction().commit();
            System.out.println("Libro insertado correctamente");
        } catch (Exception e) {
            if (laSesion.getTransaction() != null) {
                laSesion.getTransaction().rollback();
            }
            System.out.println("Error al insertar el libro. " + e.getMessage());
        } finally {
            laSesion.close();
        }
    }

    // Eliminar un libro
    public void deleteLibro(Libro libro) {
        try {
            laSesion.getTransaction().begin();
            laSesion.delete(libro);
            laSesion.getTransaction().commit();
            System.out.println("Libro eliminado correctamente");
        } catch (Exception e) {
            if (laSesion.getTransaction() != null) {
                laSesion.getTransaction().rollback();
            }
            System.out.println("Error al eliminar el libro. " + e.getMessage());
        } finally {
            laSesion.close();
        }
    }

    // Actualizar un libro
    public void updateLibro(int id) {
        try {
            laSesion.getTransaction().begin();

            Libro libroToUpdate = (Libro) laSesion.get(Libro.class, id);

            // Modificar cualquier atributo del libro
            libroToUpdate.setTitulo("Nuevo Titulo");

            laSesion.saveOrUpdate(libroToUpdate);

            laSesion.getTransaction().commit();

            System.out.println("Libro actualizado correctamente");
        } catch (Exception e) {
            if (laSesion.getTransaction() != null) {
                laSesion.getTransaction().rollback();
            }
            System.out.println("Error al actualizar el libro. " + e.getMessage());
        } finally {
            laSesion.close();
        }
    }

    // Obtener todos los libros
    public void selectAll() {
        try {
            laSesion.getTransaction().begin();

            // Consulta para obtener todos los libros
            Query query = (Query) laSesion.createQuery("from Libro");
            List<Libro> libros = query.list();

            for (Libro libro : libros) {
                System.out.println(libro);
            }

            laSesion.getTransaction().commit();

            System.out.println("Libros recuperados correctamente");
        } catch (Exception e) {
            if (laSesion.getTransaction() != null) {
                laSesion.getTransaction().rollback();
            }
            System.out.println("Error al recuperar los libros. " + e.getMessage());
        } finally {
            laSesion.close();
        }
    }
}
