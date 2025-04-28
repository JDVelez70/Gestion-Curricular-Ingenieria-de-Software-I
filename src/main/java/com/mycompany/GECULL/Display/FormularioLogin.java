package com.mycompany.GECULL.Display;

import com.mycompany.GECULL.Functions.IFunctions;
import com.mycompany.GECULL.Functions.LogicFunctions;
import com.mycompany.GECULL.Repository.CRUDRepository;
import com.mycompany.GECULL.Repository.IRepository;
import javax.swing.JOptionPane;

public class FormularioLogin extends javax.swing.JFrame {

    IFunctions functions;
    IRepository BDrepository = new CRUDRepository();

    public FormularioLogin() {
        initComponents();
        functions = new LogicFunctions(BDrepository);
    }

    private void initComponents() {

        BackGroundPanel = new javax.swing.JPanel();
        SidePanel = new javax.swing.JPanel();
        ShowPkalot = new javax.swing.JLabel();
        IconParking = new javax.swing.JLabel();
        ShowUsuario = new javax.swing.JLabel();
        ShowContrasena = new javax.swing.JLabel();
        ShowLogin = new javax.swing.JLabel();
        iconUser = new javax.swing.JLabel();
        IniciarSesion = new javax.swing.JButton();
        Registro = new javax.swing.JButton();
        Usuario = new javax.swing.JTextField();
        Contrasena = new javax.swing.JPasswordField();
        RolLabel = new javax.swing.JLabel();
        RolComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GECULL");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        BackGroundPanel.setBackground(new java.awt.Color(255, 255, 255));  // Blanco
        BackGroundPanel.setPreferredSize(new java.awt.Dimension(750, 450));

        SidePanel.setBackground(new java.awt.Color(255, 0, 0));

        ShowPkalot.setFont(new java.awt.Font("Cambria", 1, 36)); // NOI18N
        ShowPkalot.setText("GECULL");

        IconParking.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unillanos.png"))); // Cambio a "unillanos.png"

        javax.swing.GroupLayout SidePanelLayout = new javax.swing.GroupLayout(SidePanel);
        SidePanel.setLayout(SidePanelLayout);
        SidePanelLayout.setHorizontalGroup(
            SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SidePanelLayout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addGroup(SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(IconParking)
                    .addComponent(ShowPkalot))
                .addContainerGap(112, Short.MAX_VALUE))
        );
        SidePanelLayout.setVerticalGroup(
            SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SidePanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(ShowPkalot, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(IconParking, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ShowUsuario.setText("Usuario");

        ShowContrasena.setText("Contraseña");

        ShowLogin.setText("LOGIN");

        iconUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/login.png"))); // NOI18N

        // Crear el JComboBox para elegir el rol
        RolLabel.setText("Rol");
        RolComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Estudiante", "Profesor", "Decano", "Director de Programa", "Director de Escuela" }));

        IniciarSesion.setBackground(new java.awt.Color(255, 0, 0));
        IniciarSesion.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        IniciarSesion.setForeground(new java.awt.Color(255, 255, 255));
        IniciarSesion.setText("Iniciar Sesion");
        IniciarSesion.setFocusPainted(false);
        IniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IniciarSesionActionPerformed(evt);
            }
        });

        Registro.setBackground(new java.awt.Color(255, 0, 0));
        Registro.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        Registro.setForeground(new java.awt.Color(255, 255, 255));
        Registro.setText("Registrarse");
        Registro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistroActionPerformed(evt);
            }
        });

        Usuario.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        javax.swing.GroupLayout BackGroundPanelLayout = new javax.swing.GroupLayout(BackGroundPanel);
        BackGroundPanel.setLayout(BackGroundPanelLayout);
        BackGroundPanelLayout.setHorizontalGroup(
            BackGroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackGroundPanelLayout.createSequentialGroup()
                .addComponent(SidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(BackGroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BackGroundPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(BackGroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(BackGroundPanelLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(ShowLogin))
                            .addComponent(iconUser, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(141, 141, 141))
                    .addGroup(BackGroundPanelLayout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addGroup(BackGroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(BackGroundPanelLayout.createSequentialGroup()
                                .addGroup(BackGroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Registro)
                                    .addComponent(IniciarSesion)
                                    .addComponent(ShowUsuario)
                                    .addComponent(ShowContrasena)
                                    .addComponent(Contrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(RolLabel)
                                    .addComponent(RolComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(33, Short.MAX_VALUE))
                            .addGroup(BackGroundPanelLayout.createSequentialGroup()
                                .addComponent(Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))))

        );
        BackGroundPanelLayout.setVerticalGroup(
            BackGroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SidePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(BackGroundPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iconUser, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ShowLogin)
                .addGap(29, 29, 29)
                .addComponent(ShowUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(ShowContrasena)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Contrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(RolLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RolComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(IniciarSesion)
                .addGap(31, 31, 31)
                .addComponent(Registro)
                .addContainerGap(109, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackGroundPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 748, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackGroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void IniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {
        String contrasena = new String(Contrasena.getPassword());
        String rolSeleccionado = (String) RolComboBox.getSelectedItem();

        if (functions.iniciarSesion(Usuario.getText(), contrasena, rolSeleccionado)) {
            // Mostrar la ventana intermedia (FormularioFacultades) después de login exitoso
            FormularioFacultades facultadesWindow = new FormularioFacultades();
            facultadesWindow.setVisible(true);

            // Mensaje de sesión iniciada
            JOptionPane.showMessageDialog(null, "Sesión Iniciada");

            // Cerrar la ventana de login
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Usuario o Contraseña incorrectos");
        }
    }

    private void RegistroActionPerformed(java.awt.event.ActionEvent evt) {
        FormularioRegistro user = new FormularioRegistro();
        user.setVisible(true);
        this.dispose();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormularioLogin().setVisible(true);
            }
        });
    }

    // Variables declaration
    private javax.swing.JPanel BackGroundPanel;
    private javax.swing.JPasswordField Contrasena;
    private javax.swing.JLabel IconParking;
    private javax.swing.JButton IniciarSesion;
    private javax.swing.JButton Registro;
    private javax.swing.JLabel ShowContrasena;
    private javax.swing.JLabel ShowLogin;
    private javax.swing.JLabel ShowPkalot;
    private javax.swing.JLabel ShowUsuario;
    private javax.swing.JPanel SidePanel;
    private javax.swing.JTextField Usuario;
    private javax.swing.JLabel iconUser;
    private javax.swing.JLabel RolLabel;
    private javax.swing.JComboBox<String> RolComboBox;
    // End of variables declaration
}
