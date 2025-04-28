package com.mycompany.GECULL.Repository;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.mycompany.GECULL.Models.Facultad;

public class CRUDRepository implements IRepository {

    @Override
    public ResultSet consultarBD(String consulta) throws Exception {
        ConectionRepository conexion = new ConectionRepository();
        ResultSet resultado;

        try {
            conexion.establecerConexion();
            Statement ps = conexion.getConexion().createStatement();
            resultado = ps.executeQuery(consulta);
            return resultado;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("❌ Error al consultar base de datos: " + e.getMessage(), e);
        } finally {
            conexion.cerrarConexion();
        }
    }

    @Override
    public void ejecutarSql(String sql) {
        ConectionRepository conexion = new ConectionRepository();
        PreparedStatement ps = null;

        try {
            conexion.establecerConexion();
            ps = conexion.getConexion().prepareStatement(sql);
            ps.execute();
            System.out.println("✅ SQL ejecutado con éxito.");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al ejecutar SQL: " + e.getMessage());
        } finally {
            try {
                if (ps != null) ps.close();
                conexion.cerrarConexion();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void enviarDatosUsuario(String nombre, String user, String contrasena, String rol) {
        ConectionRepository conexion = new ConectionRepository();
        PreparedStatement ps = null;

        try {
            conexion.establecerConexion();
            String sql = "INSERT INTO \"usuarios\" (\"usanombre\", \"usauser\", \"usacontrasenia\", \"usarol\") VALUES (?, ?, ?, ?)";
            ps = conexion.getConexion().prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, user);
            ps.setString(3, contrasena);
            ps.setString(4, rol);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "✅ Usuario creado exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "❌ Error al crear el usuario: " + e.getMessage());
        } finally {
            try {
                if (ps != null) ps.close();
                conexion.cerrarConexion();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

   @Override
public void insertarFacultad(Facultad facultad) {
    ConectionRepository conexion = new ConectionRepository();
    PreparedStatement ps = null;

    try {
        conexion.establecerConexion();
        String sql = "INSERT INTO \"facultades\" (\"nombre\", \"fecha_creacion\", \"departamento\") VALUES (?, ?, ?)";
        ps = conexion.getConexion().prepareStatement(sql);

        // Utilizar los métodos de la clase Facultad para obtener los valores
        ps.setString(1, facultad.getNombre());
        ps.setString(2, facultad.getFechaCreacion());
        ps.setString(3, facultad.getDepartamento());

        ps.executeUpdate();  // Ejecutar la consulta de inserción
        JOptionPane.showMessageDialog(null, "✅ Facultad creada exitosamente.");
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "❌ Error al crear la facultad: " + e.getMessage());
    } finally {
        try {
            if (ps != null) ps.close();
            conexion.cerrarConexion();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


    @Override
    public void editarFacultad(int idFacultad, String nombre, String fechaCreacion, String departamento) {
        ConectionRepository conexion = new ConectionRepository();
        PreparedStatement stmt = null;

        try {
            conexion.establecerConexion();
            String query = "UPDATE facultades SET nombre = ?, fecha_creacion = ?, departamento = ? WHERE id_facultad = ?";
            stmt = conexion.getConexion().prepareStatement(query);
            stmt.setString(1, nombre);  
            stmt.setString(2, fechaCreacion);  
            stmt.setString(3, departamento);  
            stmt.setInt(4, idFacultad);  
            stmt.executeUpdate();  
            JOptionPane.showMessageDialog(null, "✅ Facultad actualizada con éxito.");
        } catch (SQLException e) {
            System.out.println("Error al editar la facultad: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
                conexion.cerrarConexion();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void eliminarFacultad(int idFacultad) {
        ConectionRepository conexion = new ConectionRepository();
        PreparedStatement stmt = null;

        try {
            conexion.establecerConexion();
            String query = "DELETE FROM facultades WHERE id_facultad = ?";
            stmt = conexion.getConexion().prepareStatement(query);
            stmt.setInt(1, idFacultad);  
            stmt.executeUpdate(); 
            JOptionPane.showMessageDialog(null, "✅ Facultad eliminada con éxito.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar la facultad: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
                conexion.cerrarConexion();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void insertarEscuela(String nombre, int idFacultad, String descripcion) {
        ConectionRepository conexion = new ConectionRepository();
        PreparedStatement ps = null;

        try {
            conexion.establecerConexion();
            String sql = "INSERT INTO \"escuelas\" (\"nombre\", \"id_facultad\", \"descripcion\") VALUES (?, ?, ?)";
            ps = conexion.getConexion().prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setInt(2, idFacultad); 
            ps.setString(3, descripcion);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "✅ Escuela creada exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "❌ Error al crear la escuela: " + e.getMessage());
        } finally {
            try {
                if (ps != null) ps.close();
                conexion.cerrarConexion();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void editarEscuela(int idEscuela, String nombre, String descripcion) {
        ConectionRepository conexion = new ConectionRepository();
        PreparedStatement stmt = null;

        try {
            conexion.establecerConexion();
            String query = "UPDATE escuelas SET nombre = ?, descripcion = ? WHERE id_escuela = ?";
            stmt = conexion.getConexion().prepareStatement(query);
            stmt.setString(1, nombre); 
            stmt.setString(2, descripcion);  
            stmt.setInt(3, idEscuela);  
            stmt.executeUpdate(); 
            JOptionPane.showMessageDialog(null, "✅ Escuela actualizada con éxito.");
        } catch (SQLException e) {
            System.out.println("Error al editar la escuela: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
                conexion.cerrarConexion();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void eliminarEscuela(int idEscuela) {
        ConectionRepository conexion = new ConectionRepository();
        PreparedStatement stmt = null;

        try {
            conexion.establecerConexion();
            String query = "DELETE FROM escuelas WHERE id_escuela = ?";
            stmt = conexion.getConexion().prepareStatement(query);
            stmt.setInt(1, idEscuela);  // Pasamos el ID como un número entero
            stmt.executeUpdate();  // Ejecutamos la eliminación
            JOptionPane.showMessageDialog(null, "✅ Escuela eliminada con éxito.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar la escuela: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
                conexion.cerrarConexion();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void insertarPlanCurricular(int id, String codigo, String nombreCurso, String creditos, String semestre, String fechaCreacion) {
        ConectionRepository conexion = new ConectionRepository();
        PreparedStatement ps = null;

        try {
            conexion.establecerConexion();
            String sql = "INSERT INTO \"planescurriculares\" (\"id_plan_curricular\", \"id_escuela\", \"codigo\", \"nombrecurso\", \"creditos\", \"semestre\", \"fecha\") VALUES (?, ?, ?, ?, ?, ?, ?)";
            ps = conexion.getConexion().prepareStatement(sql);
            ps.setInt(1, id); 
            ps.setInt(2, 1);   
            ps.setString(3, codigo); 
            ps.setString(4, nombreCurso);  
            ps.setString(5, creditos);  
            ps.setString(6, semestre); 
            ps.setString(7, fechaCreacion); 
            ps.executeUpdate();  // Ejecutar la inserción
            JOptionPane.showMessageDialog(null, "✅ Plan Curricular insertado exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "❌ Error al insertar el plan curricular: " + e.getMessage());
        } finally {
            try {
                if (ps != null) ps.close();
                conexion.cerrarConexion(); 
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    

   
    public ResultSet consultarEscuelas() {
        ConectionRepository conexion = new ConectionRepository();
        ResultSet resultSet = null;
        PreparedStatement ps = null;

        try {
            conexion.establecerConexion();
            String query = "SELECT * FROM escuelas WHERE id_facultad = 1"; 
            ps = conexion.getConexion().prepareStatement(query);
            resultSet = ps.executeQuery();  
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "❌ Error al consultar las escuelas: " + e.getMessage());
        }
        return resultSet; 
    }
}
