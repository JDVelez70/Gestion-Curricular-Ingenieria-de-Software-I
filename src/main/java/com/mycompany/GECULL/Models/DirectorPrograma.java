package com.mycompany.GECULL.Models;

public class DirectorPrograma extends Usuario {

    private int idDirectorPrograma;
    private String especialidad;

    public DirectorPrograma(String nombre, String usuario, String contrasena, String rol, int idDirectorPrograma, String especialidad) {
        super(nombre, usuario, contrasena, rol);  
        this.idDirectorPrograma = idDirectorPrograma;
        this.especialidad = especialidad;
    }

    public int getIdDirectorPrograma() {
        return idDirectorPrograma;
    }

    public void setIdDirectorPrograma(int idDirectorPrograma) {
        this.idDirectorPrograma = idDirectorPrograma;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public void mostrarInfo() {
        System.out.println("Director de Programa: " + getNombre() + " - Usuario: " + getUsuario() + " - Especialidad: " + especialidad);
    }
}
