package com.mycompany.GECULL.Models;

public class Escuela {
    private int idEscuela;
    private String nombre;
    private int idFacultad;
    private String descripcion;

    public Escuela(int idEscuela, String nombre, int idFacultad, String descripcion) {
        this.idEscuela = idEscuela;
        this.nombre = nombre;
        this.idFacultad = idFacultad;
        this.descripcion = descripcion;
    }

    public int getIdEscuela() {
        return idEscuela;
    }

    public void setIdEscuela(int idEscuela) {
        this.idEscuela = idEscuela;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdFacultad() {
        return idFacultad;
    }

    public void setIdFacultad(int idFacultad) {
        this.idFacultad = idFacultad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
