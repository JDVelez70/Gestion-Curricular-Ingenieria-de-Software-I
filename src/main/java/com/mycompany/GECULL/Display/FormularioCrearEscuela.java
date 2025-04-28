package com.mycompany.GECULL.Display;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.mycompany.GECULL.Repository.CRUDRepository;
import com.mycompany.GECULL.Repository.IRepository;

public class FormularioCrearEscuela extends javax.swing.JFrame {

    private IRepository BDrepository;
    private DefaultTableModel model; // Modelo de la tabla
    private JTextField txtNombre;
    private JTextField txtDescripcion;
    private JButton btnGuardar;

    private String idEscuela;

    public FormularioCrearEscuela(DefaultTableModel model) {
        this.model = model;
        initComponents();  // Inicializa los componentes
        BDrepository = new CRUDRepository();  // Instancia para manejar las consultas a la BD
    }

    public FormularioCrearEscuela(String idEscuela, String nombre, String descripcion, DefaultTableModel model) {
        this(model);  // Llama al constructor para crear la interfaz
        this.idEscuela = idEscuela;  // Guardar el ID para edición

        txtNombre.setText(nombre);
        txtDescripcion.setText(descripcion);

        btnGuardar.setText("Editar Escuela");
    }

    private void initComponents() {
        JLabel nombreLabel = new JLabel("Nombre de la Escuela:");
        txtNombre = new JTextField(20);
        JLabel descripcionLabel = new JLabel("Descripción:");
        txtDescripcion = new JTextField(20);

        btnGuardar = new JButton("Crear Escuela");  // Inicialmente "Crear Escuela"
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText();
                String descripcion = txtDescripcion.getText();

                if (idEscuela != null) {
                    BDrepository.editarEscuela(Integer.parseInt(idEscuela), nombre, descripcion);
                } else {
                    BDrepository.insertarEscuela(nombre, 1, descripcion); // Inserta en la base de datos con id_facultad = 1
                }

                txtNombre.setText("");
                txtDescripcion.setText("");
                dispose();
            }
        });

        JPanel panel = new JPanel();
        panel.add(nombreLabel);
        panel.add(txtNombre);
        panel.add(descripcionLabel);
        panel.add(txtDescripcion);
        panel.add(btnGuardar);  

        this.add(panel);
        this.setSize(400, 250);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Crear o Editar Escuela");
        this.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        DefaultTableModel model = new DefaultTableModel();
        new FormularioCrearEscuela(model).setVisible(true);
    }
}
