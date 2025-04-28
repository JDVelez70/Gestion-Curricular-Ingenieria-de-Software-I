package com.mycompany.GECULL.Models;

public class Profesor extends Usuario {

    private int idProfesor;
    private String especialidad;

    // Constructor
    public Profesor(String nombre, String usuario, String contrasena, String rol, int idProfesor, String especialidad) {
        super(nombre, usuario, contrasena, rol);  
        this.idProfesor = idProfesor;
        this.especialidad = especialidad;
    }

    public int getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }


    public void mostrarInfo() {
        System.out.println("Profesor: " + getNombre() + " - Usuario: " + getUsuario() + " - Especialidad: " + especialidad);
    }
}
