package com.mycompany.GECULL.Models;

public class Estudiante extends Usuario {

    private int idEstudiante;
    private String programaEstudio;

    public Estudiante(String nombre, String usuario, String contrasena, String rol, int idEstudiante, String programaEstudio) {
        super(nombre, usuario, contrasena, rol);  
        this.idEstudiante = idEstudiante;
        this.programaEstudio = programaEstudio;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getProgramaEstudio() {
        return programaEstudio;
    }

    public void setProgramaEstudio(String programaEstudio) {
        this.programaEstudio = programaEstudio;
    }

    public void mostrarInfo() {
        System.out.println("Estudiante: " + getNombre() + " - Usuario: " + getUsuario() + " - Programa de Estudio: " + programaEstudio);
    }
}
