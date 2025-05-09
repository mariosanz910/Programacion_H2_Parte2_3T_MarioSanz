package Operaciones;

import java.sql.*;
import java.util.Scanner;

public class Eliminar {
    public static void eliminarPelicula() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el código de la película a eliminar: ");
        String codigo = scanner.nextLine();

        String url = "jdbc:mysql://localhost:3306/cine_mariosanz";
        String usuario = "root";
        String contraseña = "1234";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
             Statement stmt = conexion.createStatement()) {

            // Sentencia SQL para eliminar película por código
            String eliminar = "DELETE FROM peliculas WHERE codigo = '" + codigo + "'";
            stmt.executeUpdate(eliminar);

            System.out.println("Película eliminada correctamente.");

        } catch (SQLException e) {
            System.out.println("Error al eliminar película: " + e.getMessage());
        }
    }
}
