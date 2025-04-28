package com.mycompany.GECULL.Models;

public class ComitePrograma extends Usuario {

    private int idComitePrograma;
    private String evaluador;

    // Constructor
    public ComitePrograma(String nombre, String usuario, String contrasena, String rol, int idComitePrograma, String evaluador) {
        super(nombre, usuario, contrasena, rol);
        this.idComitePrograma = idComitePrograma;
        this.evaluador = evaluador;
    }

    public int getIdComitePrograma() {
        return idComitePrograma;
    }

    public void setIdComitePrograma(int idComitePrograma) {
        this.idComitePrograma = idComitePrograma;
    }

    public String getEvaluador() {
        return evaluador;
    }

    public void setEvaluador(String evaluador) {
        this.evaluador = evaluador;
    }

    public void mostrarInfo() {
        System.out.println("Comité de Programa: " + getNombre() + " - Usuario: " + getUsuario() + " - Evaluador: " + evaluador);
    }
}
