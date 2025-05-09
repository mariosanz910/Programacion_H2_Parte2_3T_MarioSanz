package Menu;

import java.util.Scanner;
import Operaciones.*;

public class MenuCine {
    public static void iniciar() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENÚ CINE ---");
            System.out.println("1 - Ver películas");
            System.out.println("2 - Añadir película");
            System.out.println("3 - Eliminar película");
            System.out.println("4 - Modificar película");
            System.out.println("5 - Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            if (opcion == 1) {
                Mostrar.mostrarPeliculas();
            } else if (opcion == 2) {
                Añadir.añadirPelicula();
            } else if (opcion == 3) {
                Eliminar.eliminarPelicula();
            } else if (opcion == 4) {
                Modificar.modificarPelicula();
            } else if (opcion == 5) {
                System.out.println("Saliendo del sistema.");
            } else {
                System.out.println("Opción no válida.");
            }

        } while (opcion != 5); // Menú que se ejecuta al menos una vez al principio de la ejecución

        scanner.close(); // Cierre del escaner
    }
}
