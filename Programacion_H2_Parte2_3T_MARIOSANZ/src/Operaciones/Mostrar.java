package Operaciones;

import java.sql.*;

public class Mostrar {
    public static void mostrarPeliculas() {
        String url = "jdbc:mysql://localhost:3306/cine_mariosanz";
        String usuario = "root";
        String contraseña = "1234";

        String consulta = "SELECT p.codigo, p.titulo, p.genero, p.duracion, p.clasificacion, d.nombre AS director "
                        + "FROM peliculas p JOIN directores d ON p.id_director = d.id";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
             Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(consulta)) {

            while (rs.next()) {
                String codigo = rs.getString("codigo");
                String titulo = rs.getString("titulo");
                String genero = rs.getString("genero");
                int duracion = rs.getInt("duracion");
                String clasificacion = rs.getString("clasificacion");
                String director = rs.getString("director");

                System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("Código: " + codigo + " | Título: " + titulo + " | Género: " + genero + " | Duración: " + duracion + " min | Clasificación: " + clasificacion + " | Director: " + director);
                System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
            }
        } catch (SQLException e) {
            System.out.println("Error al mostrar películas: " + e.getMessage());
        }
    }
}
