// FormularioConfiguraciones.java
package com.mycompany.GECULL.Display;

import javax.swing.*;

public class FormularioConfiguraciones extends JFrame {
    public FormularioConfiguraciones() {
        setTitle("Formulario de Configuraciones");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new FormularioConfiguraciones();
    }
}
