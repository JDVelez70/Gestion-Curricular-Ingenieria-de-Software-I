package com.mycompany.GECULL.Display;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class FormularioDetalleFacultad extends JFrame {

    private JLabel lblID, lblNombre, lblFecha, lblDepartamento;
    private String idFacultad, nombre, fechaCreacion, departamento;

    public FormularioDetalleFacultad(String idFacultad, String nombre, String fechaCreacion, String departamento) {
        this.idFacultad = idFacultad;
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
        this.departamento = departamento;
        
        initComponents();
    }

    private void initComponents() {
        setTitle("Detalle de Facultad");
        setSize(400, 300);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        lblID = new JLabel("ID: " + idFacultad);
        lblNombre = new JLabel("Nombre: " + nombre);
        lblFecha = new JLabel("Fecha de Creación: " + fechaCreacion);
        lblDepartamento = new JLabel("Departamento: " + departamento);

        setLayout(new GridLayout(4, 1));

        add(lblID);
        add(lblNombre);
        add(lblFecha);
        add(lblDepartamento);

        setVisible(true);
    }

    public static void main(String[] args) {
        new FormularioDetalleFacultad("1", "Facultad de Ciencias", "2020-01-01", "Ciencias Básicas");
    }
}

