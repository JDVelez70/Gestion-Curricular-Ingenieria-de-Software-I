package com.mycompany.GECULL.Models;

public class Facultad {

    private int idFacultad;
    private String nombre;
    private String fechaCreacion;
    private String departamento;

    public Facultad(int idFacultad, String nombre, String fechaCreacion, String departamento) {
        this.idFacultad = idFacultad;
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
        this.departamento = departamento;
    }

    public int getIdFacultad() {
        return idFacultad;
    }

    public void setIdFacultad(int idFacultad) {
        this.idFacultad = idFacultad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public void mostrarInfo() {
        System.out.println("Facultad ID: " + idFacultad + " - Nombre: " + nombre + " - Fecha de Creación: " + fechaCreacion + " - Departamento: " + departamento);
    }
}
