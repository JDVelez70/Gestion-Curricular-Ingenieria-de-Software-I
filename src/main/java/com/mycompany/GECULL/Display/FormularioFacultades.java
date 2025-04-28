package com.mycompany.GECULL.Display;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.mycompany.GECULL.Models.Facultad;
import com.mycompany.GECULL.Repository.CRUDRepository;
import com.mycompany.GECULL.Repository.IRepository;

public class FormularioFacultades extends javax.swing.JFrame {

    private IRepository BDrepository;
    private DefaultTableModel model; // Modelo de la tabla
    private JTable facultadesTable; 

    private JButton crearFacultadButton;
    private JButton editarFacultadButton;
    private JButton eliminarFacultadButton;

    public FormularioFacultades() {
        initComponents();
        BDrepository = new CRUDRepository();  
        cargarFacultades(); 
        verificarRolYMostrarBotones();  
    }

    private void verificarRolYMostrarBotones() {
        // Obtén el rol del usuario
        String rolUsuario = obtenerRolUsuario();  

       
        if ("Decano".equals(rolUsuario)) {
          
            crearFacultadButton.setVisible(true);
            editarFacultadButton.setVisible(true);
            eliminarFacultadButton.setVisible(true);
        } else {
            
            crearFacultadButton.setVisible(false);
            editarFacultadButton.setVisible(false);
            eliminarFacultadButton.setVisible(false);
        }
    }

    private String obtenerRolUsuario() {
       
        return "Decano";  // Para este ejemplo, siempre devuelve "Decano". Cambia según tu lógica.
    }

    private void initComponents() {
        setTitle("Formulario Facultades");
        setSize(800, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel BackGroundPanel = new JPanel(new BorderLayout());

        Color rojoUnillanos = new Color(255, 0, 0); // color del logo
        JPanel SidePanel = new JPanel();
        SidePanel.setBackground(rojoUnillanos);
        SidePanel.setLayout(new BorderLayout());

        JPanel contenidoLateral = new JPanel();
        contenidoLateral.setLayout(new BoxLayout(contenidoLateral, BoxLayout.Y_AXIS));
        contenidoLateral.setBackground(rojoUnillanos);

        JLabel ShowPkalot = new JLabel("GECULL", SwingConstants.CENTER);
        ShowPkalot.setFont(new Font("Georgia", Font.BOLD, 34));
        ShowPkalot.setForeground(Color.WHITE);
        ShowPkalot.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel IconParking = new JLabel(new ImageIcon(getClass().getResource("/unillanos.png")));
        IconParking.setAlignmentX(Component.CENTER_ALIGNMENT);

        contenidoLateral.add(Box.createVerticalStrut(70));
        contenidoLateral.add(ShowPkalot);
        contenidoLateral.add(Box.createVerticalStrut(40));
        contenidoLateral.add(IconParking);

        SidePanel.add(contenidoLateral, BorderLayout.CENTER);

        // PANEL CENTRAL DE FACULTADES CON TÍTULO
        JPanel CentroPanel = new JPanel();
        CentroPanel.setLayout(new BoxLayout(CentroPanel, BoxLayout.Y_AXIS));
        CentroPanel.setBackground(Color.WHITE);

        // TÍTULO PRINCIPAL
        JLabel tituloPrincipal = new JLabel("Facultades", SwingConstants.CENTER);
        tituloPrincipal.setFont(new Font("Georgia", Font.BOLD, 26));
        tituloPrincipal.setAlignmentX(Component.CENTER_ALIGNMENT);
        tituloPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));

        // CREAR LA TABLA
        String[] columnNames = {"ID", "Nombre", "Fecha de Creación", "Departamento"};
        model = new DefaultTableModel(null, columnNames); // Modelo vacío inicialmente
        facultadesTable = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(facultadesTable);
        facultadesTable.setFillsViewportHeight(true); // Hace que la tabla ocupe toda la altura disponible

        // Botón para crear una nueva facultad
        crearFacultadButton = new JButton("Crear Facultad");
        crearFacultadButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        crearFacultadButton.setBackground(new Color(0, 153, 153));
        crearFacultadButton.setForeground(Color.WHITE);
        crearFacultadButton.addActionListener(e -> {
            new FormularioCrearFacultad().setVisible(true); // Abre el formulario para crear una facultad
        });

        eliminarFacultadButton = new JButton("Eliminar Facultad");
        eliminarFacultadButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        eliminarFacultadButton.setBackground(new Color(255, 0, 0));
        eliminarFacultadButton.setForeground(Color.WHITE);
        eliminarFacultadButton.addActionListener(e -> eliminarFacultad()); // Eliminar la facultad seleccionada

        editarFacultadButton = new JButton("Editar Facultad");
        editarFacultadButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        editarFacultadButton.setBackground(new Color(0, 153, 255));
        editarFacultadButton.setForeground(Color.WHITE);
        editarFacultadButton.addActionListener(e -> editarFacultad()); // Editar la facultad seleccionada

        JPanel botonesPanel = new JPanel();
        botonesPanel.add(crearFacultadButton);
        botonesPanel.add(editarFacultadButton);
        botonesPanel.add(eliminarFacultadButton);

        CentroPanel.add(tituloPrincipal);
        CentroPanel.add(scrollPane);
        CentroPanel.add(botonesPanel);

        JMenuBar menuBar = new JMenuBar();
        JMenu menuOpciones = new JMenu("Opciones");
        menuOpciones.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        JMenuItem itemInfo = new JMenuItem("Información");
        JMenuItem itemConfig = new JMenuItem("Configuraciones");
        JMenuItem itemSalir = new JMenuItem("Salir");

        itemInfo.addActionListener(evt -> {
            new FormularioInformacion().setVisible(true); // Abre el FormularioInformacion
            dispose(); // Cierra la ventana actual
        });

        itemConfig.addActionListener(evt -> {
            new FormularioConfiguraciones().setVisible(true); // Abre el FormularioConfiguraciones
            dispose(); // Cierra la ventana actual
        });

        itemSalir.addActionListener(evt -> System.exit(0)); // Sale de la aplicación


        menuOpciones.add(itemInfo);
        menuOpciones.add(itemConfig);
        menuOpciones.add(itemSalir); 
        menuBar.add(menuOpciones);
        setJMenuBar(menuBar);

        //--------------------------------------------------------------------------------------------------------------------------

        // ENSAMBLAR TODO
        BackGroundPanel.setLayout(new BorderLayout());
        BackGroundPanel.add(SidePanel, BorderLayout.WEST);
        BackGroundPanel.add(CentroPanel, BorderLayout.CENTER);

        add(BackGroundPanel);
        setVisible(true);

        facultadesTable.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = facultadesTable.getSelectedRow();
                if (selectedRow != -1) {
                    // Verifica si es la primera fila (índice 0)
                    if (selectedRow == 0) {
                        new FormularioFCBI().setVisible(true);
                        dispose(); 
                    } else {
                        String idFacultad = (String) facultadesTable.getValueAt(selectedRow, 0);
                        String nombre = (String) facultadesTable.getValueAt(selectedRow, 1);
                        String fechaCreacion = (String) facultadesTable.getValueAt(selectedRow, 2);
                        String departamento = (String) facultadesTable.getValueAt(selectedRow, 3);

                        new FormularioDetalleFacultad(idFacultad, nombre, fechaCreacion, departamento).setVisible(true);
                    }
                }
            }
        });
    }

    // Método para crear una facultad
    private void crearFacultad() {
        String nombre = JOptionPane.showInputDialog(this, "Introduce el nombre de la facultad:");
        String fechaCreacion = JOptionPane.showInputDialog(this, "Introduce la fecha de creación:");
        String departamento = JOptionPane.showInputDialog(this, "Introduce el departamento:");

        if (nombre != null && fechaCreacion != null && departamento != null) {
            Facultad nuevaFacultad = new Facultad(0, nombre, fechaCreacion, departamento);

            BDrepository.insertarFacultad(nuevaFacultad);

            cargarFacultades();  
        }
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

    private void eliminarFacultad() {
        int row = facultadesTable.getSelectedRow(); 
        if (row != -1) {
            try {
                // Convertir el ID a Integer
                int idFacultad = Integer.parseInt(facultadesTable.getValueAt(row, 0).toString()); // Convierte el valor del ID a Integer
                BDrepository.eliminarFacultad(idFacultad); 
                cargarFacultades(); 
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Error al eliminar la facultad: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona una facultad para eliminar.");
        }
    }

    private void editarFacultad() {
        int row = facultadesTable.getSelectedRow(); 
        if (row != -1) {
            String idFacultad = (String) facultadesTable.getValueAt(row, 0); 
            String nombre = (String) facultadesTable.getValueAt(row, 1); 
            String fechaCreacion = (String) facultadesTable.getValueAt(row, 2); 
            String departamento = (String) facultadesTable.getValueAt(row, 3); 

            FormularioCrearFacultad formularioEditar = new FormularioCrearFacultad(idFacultad, nombre, fechaCreacion, departamento, model);
            formularioEditar.setVisible(true);

            formularioEditar.addWindowListener(new java.awt.event.WindowAdapter() {
                public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                    cargarFacultades(); 
                }
            });
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona una facultad para editar.");
        }
    }

    public static void main(String[] args) {
        new FormularioFacultades();
    }
}
