package controller;

import dao.AutorDAO;
import dao.EditorialDAO;
import dao.LibreriaDAO;
import dao.LibroDAO;
import model.Autor;
import model.Editorial;
import model.Libreria;
import model.Libro;

import java.util.List;

public class GestorController {

    private AutorDAO autorDAO;
    private EditorialDAO editorialDAO;
    private LibreriaDAO libreriaDAO;
    private LibroDAO libroDAO;

    public GestorController() {
        autorDAO = new AutorDAO();
        editorialDAO = new EditorialDAO();
        libreriaDAO = new LibreriaDAO();
        libroDAO = new LibroDAO();
    }

    public void agregarAutor(Autor autor) {
        autorDAO.agregarAutor(autor);
    }

    public void agregarEditorial(Editorial editorial) {
        editorialDAO.agregarEditorial(editorial);
    }

    public void agregarLibro(Libro libro) {
        libroDAO.agregarLibro(libro);
    }

    public void agregarLibreria(Libreria libreria) {
        libreriaDAO.agregarLibreria(libreria);
    }

    public void obtenerLibrosEditorialAutor() {
        List<Libro> libros = libroDAO.buscarLibros();
        for (Libro libro : libros) {
            System.out.println("Título: " + libro.getTitulo() +
                    ", Autor: " + libro.getAutor().getNombre() + " " + libro.getAutor().getApellido() +
                    ", Editorial: " + libro.getEditorial().getNombre());
        }
    }

    public void obtenerLibrosPorAutor() {
        List<Autor> autores = autorDAO.getAutoresQuery();
        for (Autor autor : autores) {
            System.out.println("Autor: " + autor.getNombre() + " " + autor.getApellido());
            for (Libro libro : autor.getLibros()) {
                System.out.println("   - " + libro.getTitulo());
            }
        }
    }

    public void obtenerLibreriasLibrosAsociados() {
        List<Libreria> librerias = libreriaDAO.obtenerLibrerias();
        for (Libreria libreria : librerias) {
            System.out.println("Librería: " + libreria.getNombre());
            for (Libro libro : libreria.getLibros()) {
                System.out.println("   - " + libro.getTitulo());
            }
        }
    }

    public void obtenerLibrosYLibreria() {
        List<Libro> libros = libroDAO.buscarLibros();
        for (Libro libro : libros) {
            System.out.println("Libro: " + libro.getTitulo());
            for (Libreria libreria : libro.getLibrerias()) {
                System.out.println("   - " + libreria.getNombre());
            }
        }
    }

    public void asignarLibroALibreria(int idLibro, int idLibreria) {
        libroDAO.asignarLibroALibreria(idLibro, idLibreria);
    }

    public void agregarCantidad(int idlibro,int idLibreri , int cantidad){
        libroDAO.agregarLibroALibreria(idlibro,idLibreri,cantidad);
    }

    public void obtenerCantidadLibros (int idLibro , int idLibreria){
        System.out.println("Tenemos del libro : " + libroDAO.buscarLibro(idLibro).getTitulo() + " En la libreria : " + libreriaDAO.obtenerLibreria(idLibreria).getNombre()
                + " una cantidad de -> " + libroDAO.obtenerCantidadLibroEnLibreria(idLibro,idLibreria) );


    }

}
