// FormularioInformacion.java
package com.mycompany.GECULL.Display;

import javax.swing.JFrame;

public class FormularioInformacion extends JFrame {
    public FormularioInformacion() {
        setTitle("Formulario de Información");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new FormularioInformacion();
    }
}
