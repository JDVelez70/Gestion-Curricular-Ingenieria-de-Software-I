/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.GECULL.Display;

/**
 *
 * @author crism
 */
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class estiloColumnaEstado extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                   boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        

        if (value != null && value.toString().equalsIgnoreCase("activo")) {
            setBackground(Color.GREEN);
            setForeground(Color.BLACK);
        } else if (value != null && value.toString().equalsIgnoreCase("salio")) {
            setBackground(Color.RED);
            setForeground(Color.BLACK);
        } else {
            setBackground(table.getBackground());
            setForeground(table.getForeground());
        }

        return this;
    }
}