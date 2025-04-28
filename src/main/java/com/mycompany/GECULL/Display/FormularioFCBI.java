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

import com.mycompany.GECULL.Repository.CRUDRepository;
import com.mycompany.GECULL.Repository.IRepository;

public class FormularioFCBI extends javax.swing.JFrame {

    private IRepository BDrepository;
    private DefaultTableModel model; // Modelo de la tabla
    private JTable escuelasTable; 

    public FormularioFCBI() {
        initComponents();
        BDrepository = new CRUDRepository(); 
        cargarEscuelas();  
    }

    private void initComponents() {
        setTitle("Formulario FCBI");
        setSize(800, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel BackGroundPanel = new JPanel(new BorderLayout());

        // PANEL LATERAL IZQUIERDO
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

        // PANEL CENTRAL DE FCBI CON TÍTULO
        JPanel CentroPanel = new JPanel();
        CentroPanel.setLayout(new BoxLayout(CentroPanel, BoxLayout.Y_AXIS));
        CentroPanel.setBackground(Color.WHITE);

        // TÍTULO PRINCIPAL
        JLabel tituloPrincipal = new JLabel("Escuelas FCBI", SwingConstants.CENTER);
        tituloPrincipal.setFont(new Font("Georgia", Font.BOLD, 26));
        tituloPrincipal.setAlignmentX(Component.CENTER_ALIGNMENT);
        tituloPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));

        // CREAR LA TABLA
        String[] columnNames = {"ID", "Nombre", "Descripción"};
        model = new DefaultTableModel(null, columnNames); // Modelo vacío inicialmente
        escuelasTable = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(escuelasTable);
        escuelasTable.setFillsViewportHeight(true); 

        // Botón para crear una nueva escuela
        JButton crearEscuelaButton = new JButton("Crear Escuela");
        crearEscuelaButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        crearEscuelaButton.setBackground(new Color(0, 153, 153));
        crearEscuelaButton.setForeground(Color.WHITE);
        crearEscuelaButton.addActionListener(e -> {
            new FormularioCrearEscuela(model).setVisible(true); 
        });

        // Botón para eliminar la escuela seleccionada
        JButton eliminarEscuelaButton = new JButton("Eliminar Escuela");
        eliminarEscuelaButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        eliminarEscuelaButton.setBackground(new Color(255, 0, 0));
        eliminarEscuelaButton.setForeground(Color.WHITE);
        eliminarEscuelaButton.addActionListener(e -> eliminarEscuela()); // Eliminar la escuela seleccionada

        // Botón para editar la escuela seleccionada
        JButton editarEscuelaButton = new JButton("Editar Escuela");
        editarEscuelaButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        editarEscuelaButton.setBackground(new Color(0, 153, 255));
        editarEscuelaButton.setForeground(Color.WHITE);
        editarEscuelaButton.addActionListener(e -> editarEscuela());

        // Panel con los botones de crear, editar y eliminar
        JPanel botonesPanel = new JPanel();
        botonesPanel.add(crearEscuelaButton);
        botonesPanel.add(editarEscuelaButton);
        botonesPanel.add(eliminarEscuelaButton);

        // Agregar título, tabla y botones al centro
        CentroPanel.add(tituloPrincipal);
        CentroPanel.add(scrollPane);
        CentroPanel.add(botonesPanel);

        // MENÚ SUPERIOR
        JMenuBar menuBar = new JMenuBar();
        JMenu menuOpciones = new JMenu("Opciones");
        menuOpciones.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        JMenuItem itemInfo = new JMenuItem("Información");
        JMenuItem itemConfig = new JMenuItem("Configuraciones");
        JMenuItem itemSalir = new JMenuItem("Salir");
        JMenuItem itemRegresar = new JMenuItem("Regresar");

        // Acción para "Información"
        itemInfo.addActionListener(evt -> {
            new FormularioInformacion().setVisible(true);
        });

        // Acción para "Configuraciones"
        itemConfig.addActionListener(evt -> {
            new FormularioConfiguraciones().setVisible(true); 
        });
        itemRegresar.addActionListener(evt -> {
            new FormularioFacultades().setVisible(true); 
            dispose(); // Cierra la ventana actual
        });

        // Acción para salir
        itemSalir.addActionListener(evt -> System.exit(0));

        menuOpciones.add(itemInfo);
        menuOpciones.add(itemConfig);
        menuOpciones.add(itemSalir);
        menuOpciones.add(itemRegresar); 
        menuBar.add(menuOpciones);
        setJMenuBar(menuBar);

        //--------------------------------------------------------------------------------------------------------------------------

        // ENSAMBLAR TODO
        BackGroundPanel.setLayout(new BorderLayout());
        BackGroundPanel.add(SidePanel, BorderLayout.WEST);
        BackGroundPanel.add(CentroPanel, BorderLayout.CENTER);

        add(BackGroundPanel);
        setVisible(true);


        escuelasTable.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = escuelasTable.getSelectedRow();
                if (selectedRow != -1) {
                    // Abre una nueva ventana con la información de la escuela seleccionada
                    String idEscuela = (String) escuelasTable.getValueAt(selectedRow, 0);
                    String nombre = (String) escuelasTable.getValueAt(selectedRow, 1);
                    String descripcion = (String) escuelasTable.getValueAt(selectedRow, 2);

                    // Verifica si la escuela seleccionada es Ingeniería de Sistemas (ID 1)
                    if (idEscuela.equals("1")) {
                        new FormularioIngSistemas().setVisible(true); // Abre el formulario de Plan Curricular de Ingeniería de Sistemas
                    } else {
                        new FormularioDetalleEscuela(idEscuela, nombre, descripcion).setVisible(true);
                    }
                }
            }
        });
    }

    // Método para crear una escuela
    private void crearEscuela() {
        String nombre = JOptionPane.showInputDialog(this, "Introduce el nombre de la escuela:");
        String descripcion = JOptionPane.showInputDialog(this, "Introduce la descripción de la escuela:");

        if (nombre != null && descripcion != null) {
            BDrepository.insertarEscuela(nombre, 1, descripcion); 
            cargarEscuelas(); 
        }
    }

    // Método para cargar las escuelas desde la base de datos
    private void cargarEscuelas() {
        try {
            String query = "SELECT * FROM escuelas WHERE id_facultad = 1"; 
            ResultSet resultSet = BDrepository.consultarBD(query);

            model.setRowCount(0);

            while (resultSet.next()) {
                String id = resultSet.getString("id_escuela");
                String nombre = resultSet.getString("nombre");
                String descripcion = resultSet.getString("descripcion");

                model.addRow(new Object[]{id, nombre, descripcion});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar las escuelas: " + e.getMessage());
        }
    }

    // Método para eliminar la escuela seleccionada
    private void eliminarEscuela() {
        int row = escuelasTable.getSelectedRow();
        if (row != -1) {
            try {
                int idEscuela = Integer.parseInt(escuelasTable.getValueAt(row, 0).toString());
                BDrepository.eliminarEscuela(idEscuela); // Eliminar escuela
                cargarEscuelas(); 
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Error al eliminar la escuela: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona una escuela para eliminar.");
        }
    }

    // Método para editar la escuela seleccionada
    private void editarEscuela() {
        int row = escuelasTable.getSelectedRow();
        if (row != -1) {
            String idEscuela = (String) escuelasTable.getValueAt(row, 0);
            String nombre = (String) escuelasTable.getValueAt(row, 1);
            String descripcion = (String) escuelasTable.getValueAt(row, 2);

            FormularioCrearEscuela formularioEditar = new FormularioCrearEscuela(idEscuela, nombre, descripcion, model);
            formularioEditar.setVisible(true);

            formularioEditar.addWindowListener(new java.awt.event.WindowAdapter() {
                public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                    cargarEscuelas();  // Recarga la tabla
                }
            });
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona una escuela para editar.");
        }
    }

    public static void main(String[] args) {
        new FormularioFCBI();
    }
}
