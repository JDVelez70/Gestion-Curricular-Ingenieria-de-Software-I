package com.mycompany.GECULL.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectionRepository {
    private Connection conectar = null;

    private final String usuario = "postgres.snpyvsevnzvfxicnpjbw";
    private final String contrasena = "UB+f*W?K_#)4z&v";
    private final String bd = "postgres";
    private final String ip = "aws-0-us-east-1.pooler.supabase.com";
    private final String puerto = "6543"; 

    private final String url = "jdbc:postgresql://" + ip + ":" + puerto + "/" + bd;

    public Connection getConexion() {
        return conectar;
    }

    public void establecerConexion() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            conectar = DriverManager.getConnection(url, usuario, contrasena);
            System.out.println("✅ Conexión exitosa a la base de datos.");
        } catch (ClassNotFoundException e) {
            throw new SQLException("No se encontró el driver JDBC", e);
        } catch (SQLException e) {
            throw new SQLException("No se pudo conectar a la base de datos", e);
        }
    }

    public void cerrarConexion() {
        try {
            if (conectar != null && !conectar.isClosed()) {
                conectar.close();
                System.out.println("🔌 Conexión cerrada.");
            }
        } catch (SQLException e) {
            System.err.println("⚠️ Error al cerrar la conexión: " + e.getMessage());
        }
    }
}
