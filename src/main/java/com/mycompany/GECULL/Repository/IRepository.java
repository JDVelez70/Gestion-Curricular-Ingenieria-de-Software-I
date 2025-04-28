package com.mycompany.GECULL.Repository;
import java.sql.ResultSet;

import com.mycompany.GECULL.Models.Facultad;

public interface IRepository {
    
    public abstract ResultSet consultarBD(String consulta) throws Exception;
    
    public abstract void ejecutarSql(String sql);
    
    public abstract void enviarDatosUsuario(String nombre, String user, String contrasena, String rol);
    

    public void insertarFacultad(Facultad facultad);
    public abstract void editarFacultad(int idFacultad, String nombre, String fechaCreacion, String departamento);
    public abstract void eliminarFacultad(int idFacultad);


    public abstract void insertarEscuela(String nombre, int idFacultad, String descripcion);
    public abstract void editarEscuela(int idEscuela, String nombre, String descripcion);
    public abstract void eliminarEscuela(int idEscuela);

    
    public abstract ResultSet consultarEscuelas();


    public abstract void insertarPlanCurricular(int id, String codigo, String nombreCurso, String creditos, String semestre, String fechaCreacion);
}

