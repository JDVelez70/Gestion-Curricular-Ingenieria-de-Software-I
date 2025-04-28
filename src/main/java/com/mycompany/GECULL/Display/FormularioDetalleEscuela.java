package com.mycompany.GECULL.Display;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class FormularioDetalleEscuela extends JFrame {

    private JLabel lblID, lblNombre, lblDescripcion;
    private String idEscuela, nombre, descripcion;

    public FormularioDetalleEscuela(String idEscuela, String nombre, String descripcion) {
        this.idEscuela = idEscuela;
        this.nombre = nombre;
        this.descripcion = descripcion;

        initComponents();
    }

    private void initComponents() {
        setTitle("Detalle de Escuela");
        setSize(400, 300);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        lblID = new JLabel("ID: " + idEscuela);
        lblNombre = new JLabel("Nombre: " + nombre);
        lblDescripcion = new JLabel("Descripción: " + descripcion);

        setLayout(new GridLayout(3, 1));
        add(lblID);
        add(lblNombre);
        add(lblDescripcion);

        setVisible(true);
    }

    public static void main(String[] args) {
        new FormularioDetalleEscuela("1", "Escuela de Sistemas", "Formación en desarrollo y programación.");
    }
}
