package com.mycompany.GECULL.Models;

public class Decano extends Usuario {

    private int idDecano;

    public Decano(String nombre, String usuario, String contrasena, String rol, int idDecano) {
        super(nombre, usuario, contrasena, rol);  
        this.idDecano = idDecano;
    }

    public int getIdDecano() {
        return idDecano;
    }

    public void setIdDecano(int idDecano) {
        this.idDecano = idDecano;
    }

    public void mostrarInfo() {
        System.out.println("Decano: " + getNombre() + " - Usuario: " + getUsuario() + " - ID Decano: " + idDecano);
    }
}
