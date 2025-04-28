package com.mycompany.GECULL.Models;

public class DirectorEscuela extends Usuario {

    private int idDirectorEscuela;
    private String especialidad;

    public DirectorEscuela(String nombre, String usuario, String contrasena, String rol, int idDirectorEscuela, String especialidad) {
        super(nombre, usuario, contrasena, rol);  
        this.idDirectorEscuela = idDirectorEscuela;
        this.especialidad = especialidad;
    }

    public int getIdDirectorEscuela() {
        return idDirectorEscuela;
    }

    public void setIdDirectorEscuela(int idDirectorEscuela) {
        this.idDirectorEscuela = idDirectorEscuela;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public void mostrarInfo() {
        System.out.println("Director de Escuela: " + getNombre() + " - Usuario: " + getUsuario() + " - Especialidad: " + especialidad);
    }
}
