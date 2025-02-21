import controller.GestorController;
import controller.Menu;
import model.Autor;
import model.Editorial;
import model.Libreria;
import model.Libro;


import java.time.LocalDate;


public class Entrada {
    public static void main(String[] args) {
        GestorController gestor = new GestorController();
        Menu menu = new Menu();
        menu.pintarMenu();

        // CARGAR BASE DE DATOS INICIAL


        // Añadimos diferentes Autores, decido crear el objeto Autor para después integrar el obejeto en otro constructor
/*
        Autor alejandro = new Autor("Alejandro","Jimenez", LocalDate.of(1995, 7, 16));
        Autor sara = new Autor("Sara","Acosta", LocalDate.of(1990, 7, 16));
        Autor victor = new Autor("Victor","Villalar", LocalDate.of(1995, 10, 10));
        Autor patricia = new Autor("Patricia","Lara", LocalDate.of(1992, 7, 5));

        gestor.agregarAutor(alejandro);
        gestor.agregarAutor(sara);
        gestor.agregarAutor(victor);
        gestor.agregarAutor(patricia);

        // Creo las editoriales del mismo modo
        Editorial akal = new Editorial("Akal","calle Bormujo");
        Editorial Aena = new Editorial("Aena","calle Feria");

        gestor.agregarEditorial(akal);
        gestor.agregarEditorial(Aena);

        // Creo los libros pasandole el objeto autor y objeto editorial.

        Libro libro1 = new Libro("La península de las casas vacías", 26 ,akal,alejandro);
        Libro libro2 = new Libro("La Supraconciencia existe",19,akal,alejandro);
        Libro libro3 = new Libro("La asistenta",17,akal,alejandro);
        Libro libro4 = new Libro("Invisible",23,akal,sara);
        Libro libro5 = new Libro("La vegetariana",30,akal,sara);
        Libro libro6 = new Libro("Las que no duermen NASH",15,Aena,sara);
        Libro libro7 = new Libro("Victoria",40,Aena,victor);
        Libro libro8 = new Libro("Cómo mandar a la mierda de forma educada",17,akal,victor);
        Libro libro9 = new Libro("Animales difíciles",23,Aena,victor);
        Libro libro10 = new Libro("La cartera",29,Aena,patricia);

        gestor.agregarLibro(libro1);
        gestor.agregarLibro(libro2);
        gestor.agregarLibro(libro3);
        gestor.agregarLibro(libro4);
        gestor.agregarLibro(libro5);
        gestor.agregarLibro(libro6);
        gestor.agregarLibro(libro7);
        gestor.agregarLibro(libro8);
        gestor.agregarLibro(libro9);
        gestor.agregarLibro(libro10);

        // Creo las librerias

        Libreria libreria1 = new Libreria("Libreria la O","Pedro","Calle Puerta Jerez");
        Libreria libreria2 = new Libreria("Libreria Forum","Isabel","Calle Ancha");

        gestor.agregarLibreria(libreria1);
        gestor.agregarLibreria(libreria2);


*/

        // CARGA BASE DE DATOS PRUEBAS



        // Asigno Librerias a libros y viceversa
//        gestor.asignarLibroALibreria(1,1);
//        gestor.asignarLibroALibreria(2,1);
//        gestor.asignarLibroALibreria(3,1);
//        gestor.asignarLibroALibreria(4,1);
//        gestor.asignarLibroALibreria(5,1);
//        gestor.asignarLibroALibreria(6,2);
//        gestor.asignarLibroALibreria(7,2);
//        gestor.asignarLibroALibreria(8,2);
//        gestor.asignarLibroALibreria(9,2);
//        gestor.asignarLibroALibreria(10,2);
//        gestor.asignarLibroALibreria(1,1);

//        gestor.agregarCantidad(1,1,4);

//        gestor.obtenerCantidadLibros(1,1);

    }
}
