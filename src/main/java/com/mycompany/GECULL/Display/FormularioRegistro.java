package com.mycompany.GECULL.Display;

import com.mycompany.GECULL.Models.Usuario;  // Importamos la clase Usuario
import com.mycompany.GECULL.Functions.IFunctions;
import com.mycompany.GECULL.Functions.LogicFunctions;
import com.mycompany.GECULL.Repository.CRUDRepository;
import com.mycompany.GECULL.Repository.IRepository;
import javax.swing.JOptionPane;

public class FormularioRegistro extends javax.swing.JFrame {

    IFunctions functions;
    IRepository BDrepository = new CRUDRepository();

    public FormularioRegistro() {
        initComponents();
        functions = new LogicFunctions(BDrepository);
    }

    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        BackGround = new javax.swing.JPanel();
        Nombre = new java.awt.Label();
        txtNombre = new java.awt.TextField();
        Usuario = new java.awt.Label();
        txtUsuario = new java.awt.TextField();
        Contrasena = new java.awt.Label();
        txtContrasena = new java.awt.TextField();
        Guardar = new java.awt.Button();
        Atras = new javax.swing.JButton();
        registro = new javax.swing.JLabel();
        RolLabel = new javax.swing.JLabel();
        RolComboBox = new javax.swing.JComboBox<>();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GECULL");

        BackGround.setBackground(new java.awt.Color(255, 255, 255));
        BackGround.setMaximumSize(new java.awt.Dimension(500, 400));
        BackGround.setMinimumSize(new java.awt.Dimension(500, 400));
        BackGround.setPreferredSize(new java.awt.Dimension(500, 400));

        Nombre.setName("Nombre");
        Nombre.setText("Nombre");

        Usuario.setName("Usuario");
        Usuario.setText("Usuario");

        Contrasena.setName("Contrasena");
        Contrasena.setText("Contraseña");

        RolLabel.setText("Rol");

        // Crear el JComboBox para elegir el rol
        RolComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Estudiante", "Profesor", "Decano", "Director de Programa", "Director de Escuela" }));

        Guardar.setBackground(new java.awt.Color(0, 153, 153));
        Guardar.setFont(new java.awt.Font("Cambria", 0, 12)); 
        Guardar.setForeground(new java.awt.Color(255, 255, 255));
        Guardar.setLabel("Guardar");
        Guardar.setName("Guardar");
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });

        Atras.setBackground(new java.awt.Color(0, 153, 153));
        Atras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FlechaAtras.png"))); 
        Atras.setMaximumSize(new java.awt.Dimension(50, 50));
        Atras.setMinimumSize(new java.awt.Dimension(50, 50));
        Atras.setPreferredSize(new java.awt.Dimension(50, 570));
        Atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtrasActionPerformed(evt);
            }
        });

        registro.setFont(new java.awt.Font("Cambria", 1, 36)); 
        registro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        registro.setText("REGISTRO");

        javax.swing.GroupLayout BackGroundLayout = new javax.swing.GroupLayout(BackGround);
        BackGround.setLayout(BackGroundLayout);
        BackGroundLayout.setHorizontalGroup(
            BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackGroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Atras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BackGroundLayout.createSequentialGroup()
                .addContainerGap(160, Short.MAX_VALUE)
                .addGroup(BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                        .addComponent(Contrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtContrasena, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                        .addComponent(registro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Guardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(RolLabel)
                        .addComponent(RolComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(152, 152, 152))
        );
        BackGroundLayout.setVerticalGroup(
            BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackGroundLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Atras, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(registro, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Contrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RolLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RolComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );

        Contrasena.getAccessibleContext().setAccessibleName("Contrasena");
        Atras.getAccessibleContext().setAccessibleName("Atras");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(BackGround, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(BackGround, javax.swing.GroupLayout.PREFERRED_SIZE, 394, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void AtrasActionPerformed(java.awt.event.ActionEvent evt) {
        FormularioLogin login = new FormularioLogin();
        login.setVisible(true);
        this.dispose();
    }

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {
        // Obtener los datos del formulario
        String nombre = txtNombre.getText();
        String usuario = txtUsuario.getText();
        String contrasena = txtContrasena.getText();
        String rolSeleccionado = (String) RolComboBox.getSelectedItem();

        // Crear una instancia de la clase Usuario
        Usuario nuevoUsuario = new Usuario(nombre, usuario, contrasena, rolSeleccionado);

        // Registrar al usuario utilizando la clase Usuario
        if(functions.registrarUsuario(nuevoUsuario)){
            JOptionPane.showMessageDialog(null, "Usuario creado correctamente");
            txtNombre.setText("");
            txtUsuario.setText("");
            txtContrasena.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Error al crear usuario");
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormularioRegistro().setVisible(true);
            }
        });
    }

    // Variables declaration
    private javax.swing.JButton Atras;
    private javax.swing.JPanel BackGround;
    private java.awt.Label Contrasena;
    private java.awt.Button Guardar;
    private java.awt.Label Nombre;
    private java.awt.Label Usuario;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JLabel registro;
    private java.awt.TextField txtContrasena;
    private java.awt.TextField txtNombre;
    private java.awt.TextField txtUsuario;
    private javax.swing.JLabel RolLabel;
    private javax.swing.JComboBox<String> RolComboBox;
    // End of variables declaration
}
