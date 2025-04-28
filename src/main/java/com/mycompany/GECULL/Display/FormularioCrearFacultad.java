package com.mycompany.GECULL.Display;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.mycompany.GECULL.Models.Facultad;
import com.mycompany.GECULL.Repository.CRUDRepository;
import com.mycompany.GECULL.Repository.IRepository;

public class FormularioCrearFacultad extends javax.swing.JFrame {

    private IRepository BDrepository;
    private DefaultTableModel model; 
    private JTextField txtNombre;
    private JTextField txtFecha;
    private JTextField txtDepartamento;
    private JButton btnGuardar;

  
    private String idFacultad;

   
    public FormularioCrearFacultad() {
        this.model = model;  // Recibe el modelo de la tabla
        initComponents();  
        BDrepository = new CRUDRepository();  // Instancia para manejar las consultas a la BD
    }

    // Constructor para edición
    public FormularioCrearFacultad(String idFacultad, String nombre, String fechaCreacion, String departamento, DefaultTableModel model) {
        this.model = model;  
        initComponents();  
        BDrepository = new CRUDRepository();  
        this.idFacultad = idFacultad;  

        
        txtNombre.setText(nombre);
        txtFecha.setText(fechaCreacion);
        txtDepartamento.setText(departamento);

        
        btnGuardar.setText("Editar Facultad");
    }

    private void initComponents() {
       
        JLabel nombreLabel = new JLabel("Nombre de la Facultad:");
        txtNombre = new JTextField(20);
        JLabel fechaLabel = new JLabel("Fecha de Creación:");
        txtFecha = new JTextField(20);
        JLabel deptoLabel = new JLabel("Departamento:");
        txtDepartamento = new JTextField(20);

        btnGuardar = new JButton("Crear Facultad");  
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText();
                String fechaCreacion = txtFecha.getText();
                String departamento = txtDepartamento.getText();

                Facultad nuevaFacultad = new Facultad(0, nombre, fechaCreacion, departamento);

                if (idFacultad != null) {

                    BDrepository.editarFacultad(Integer.parseInt(idFacultad), nombre, fechaCreacion, departamento);
                } else {
                    BDrepository.insertarFacultad(nuevaFacultad);
                }

                txtNombre.setText("");
                txtFecha.setText("");
                txtDepartamento.setText("");
                dispose();

                cargarFacultades();
            }
        });

        JButton btnActualizar = new JButton("Actualizar Facultades");
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cargarFacultades();  
            }
        });

        JPanel panel = new JPanel();
        panel.add(nombreLabel);
        panel.add(txtNombre);
        panel.add(fechaLabel);
        panel.add(txtFecha);
        panel.add(deptoLabel);
        panel.add(txtDepartamento);
        panel.add(btnGuardar);
        panel.add(btnActualizar); 

        this.add(panel);
        this.setSize(400, 250);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Crear o Editar Facultad");
        this.setLocationRelativeTo(null);
    }

    private void cargarFacultades() {
        try {
            String query = "SELECT * FROM facultades"; 
            ResultSet resultSet = BDrepository.consultarBD(query); 

            model.setRowCount(0);

            while (resultSet.next()) {
                String id = resultSet.getString("id_facultad"); 
                String nombre = resultSet.getString("nombre"); 
                String fechaCreacion = resultSet.getString("fecha_creacion"); 
                String departamento = resultSet.getString("departamento");

                model.addRow(new Object[]{id, nombre, fechaCreacion, departamento});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar las facultades: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new FormularioCrearFacultad().setVisible(true);
    }
}
