package Operaciones;

import java.sql.*;
import java.util.Scanner;

public class Añadir {
    public static void añadirPelicula() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Código de la película: ");
        String codigo = scanner.nextLine();

        System.out.print("Título: ");
        String titulo = scanner.nextLine();

        System.out.print("Género: ");
        String genero = scanner.nextLine();

        System.out.print("Duración (minutos): ");
        int duracion = scanner.nextInt();
        scanner.nextLine(); // limpiar buffer, explicada la necesidad de esto en la anterior instancia del hito

        System.out.print("Clasificación: ");
        String clasificacion = scanner.nextLine();

        System.out.print("ID del director: ");
        int id_director = scanner.nextInt();

        String url = "jdbc:mysql://localhost:3306/cine_mariosanz";
        String usuario = "root";
        String contraseña = "1234";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
                Statement stmt = conexion.createStatement()) {

               String insertar = "INSERT INTO peliculas (codigo, titulo, genero, duracion, clasificacion, id_director) " + "VALUES ('" + codigo + "', '" + titulo + "', '" + genero + "', " + duracion + ", '" + clasificacion + "', " + id_director + ")";
               stmt.executeUpdate(insertar);

               System.out.println("Película añadida correctamente.");

           } catch (SQLException e) {
               System.out.println("Error al añadir película: " + e.getMessage());
           }
    }
}
