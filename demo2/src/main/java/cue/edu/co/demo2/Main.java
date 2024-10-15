package cue.edu.co.demo2;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LibroRepository libroRepository = new LibroRepositoryImpl();
        LibroService libroService = new LibroServiceImpl(libroRepository);

        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("1. Agregar libro");
            System.out.println("2. Listar libros");
            System.out.println("3. Buscar libro por ID");
            System.out.println("4. Eliminar libro");
            System.out.println("5. Salir");
            System.out.print("Elija una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // limpiar buffer
                    System.out.print("Ingrese Título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Ingrese Autor: ");
                    String autor = scanner.nextLine();
                    libroService.agregarLibro(new Libro(id, titulo, autor));
                    break;
                case 2:
                    List<Libro> libros = libroService.listarLibros();
                    libros.forEach(System.out::println);
                    break;
                case 3:
                    System.out.print("Ingrese ID del libro: ");
                    int buscarId = scanner.nextInt();
                    Libro libro = libroService.obtenerLibroPorId(buscarId);
                    if (libro != null) {
                        System.out.println(libro);
                    } else {
                        System.out.println("Libro no encontrado");
                    }
                    break;
                case 4:
                    System.out.print("Ingrese ID del libro a eliminar: ");
                    int eliminarId = scanner.nextInt();
                    libroService.eliminarLibro(eliminarId);
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (opcion != 5);

        scanner.close();
    }
}
