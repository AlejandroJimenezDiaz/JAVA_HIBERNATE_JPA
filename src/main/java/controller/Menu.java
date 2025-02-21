package controller;

import java.util.Scanner;

public class Menu {

    GestorController gestorController = new GestorController();

    public void pintarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        // Bucle principal del menú
        do {
            // Mostrar el menú
            System.out.println("----- MENÚ -----");
            System.out.println("1. Mostrar todos los libros dados de alta, con su editorial y su autor.");
            System.out.println("2. Mostrar todos los autores dados de alta, con sus libros asociados.");
            System.out.println("3. Mostrar todas las librerías, con solamente sus libros asociados.");
            System.out.println("4. Mostrar todos los libros dados de alta, y en la librería en la que están.");
            System.out.println("5. Finalizar programa");
            System.out.print("Seleccione una opción: ");

            // Leer la opción del usuario
            opcion = scanner.nextInt();

            // Procesar la opción seleccionada
            switch (opcion) {
                case 1:
                    System.out.println("Mostrar todos los libros dados de alta, con su editorial y su autor.");
                    gestorController.obtenerLibrosEditorialAutor();
                    break;
                case 2:
                    System.out.println("Mostrar todos los autores dados de alta, con sus libros asociados.");
                    gestorController.obtenerLibrosPorAutor();
                    break;
                case 3:
                    System.out.println("Mostrar todas las librerías, con solamente sus libros asociados.");
                    gestorController.obtenerLibreriasLibrosAsociados();
                    break;
                case 4:
                    System.out.println("Mostrar todos los libros dados de alta, y en la librería en la que están.");
                    gestorController.obtenerLibrosYLibreria();
                    break;
                case 5:
                    System.out.println("Fin del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        } while (opcion != 5);  // El bucle sigue hasta que elija la opción 5 (salir)
        scanner.close();
    }
}

