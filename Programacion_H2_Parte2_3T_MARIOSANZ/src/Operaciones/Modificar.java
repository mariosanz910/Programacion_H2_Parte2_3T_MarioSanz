package Operaciones;

import java.sql.*;
import java.util.Scanner;

public class Modificar {
    public static void modificarPelicula() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Código de la película a modificar: ");
        String codigo = scanner.nextLine();

        String url = "jdbc:mysql://localhost:3306/cine_mariosanz";
        String usuario = "root";
        String contraseña = "1234";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
             Statement stmt = conexion.createStatement()) {

            // Obtener los nuevos valores para los campos a modificar
            System.out.print("Nuevo título: ");
            String nuevoTitulo = scanner.nextLine();

            System.out.print("Nuevo género: ");
            String nuevoGenero = scanner.nextLine();

            System.out.print("Nueva duración (min): ");
            int nuevaDuracion = scanner.nextInt();
            scanner.nextLine(); 

            System.out.print("Nueva clasificación: ");
            String nuevaClasificacion = scanner.nextLine();

            // Sentencia SQL para actualizar los datos, excluyendo el id_director porque el director no suele cambiar en una peli.
            String actualizar = "UPDATE peliculas SET titulo = '" + nuevoTitulo + "', " +
                                "genero = '" + nuevoGenero + "', duracion = " + nuevaDuracion + ", " +
                                "clasificacion = '" + nuevaClasificacion + "' WHERE codigo = '" + codigo + "'"; // Variable que guarda la consulta
            stmt.executeUpdate(actualizar); // Ejecutamos la consulta en base a la variable con la consulta

            System.out.println("Película modificada correctamente.");

        } catch (SQLException e) {
            System.out.println("Error al modificar película: " + e.getMessage());
        }
    }
}
