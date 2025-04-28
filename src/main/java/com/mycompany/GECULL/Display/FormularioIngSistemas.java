package com.mycompany.GECULL.Display;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
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

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.mycompany.GECULL.Repository.CRUDRepository;

public class FormularioIngSistemas extends JFrame {

    private JTable table;
    private DefaultTableModel model;
    private CRUDRepository BDrepository;

    public FormularioIngSistemas() {
        initComponents();
        BDrepository = new CRUDRepository(); // Instancia para manejar las consultas a la BD
    }

    private void initComponents() {
        setTitle("Plan Curricular de Ingeniería de Sistemas");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel backPanel = new JPanel(new BorderLayout());

        // PANEL LATERAL IZQUIERDO (Franja Roja con Imagen)
        Color rojoUnillanos = new Color(255, 0, 0); // color del logo
        JPanel sidePanel = new JPanel();
        sidePanel.setBackground(rojoUnillanos);
        sidePanel.setLayout(new BorderLayout());

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

        sidePanel.add(contenidoLateral, BorderLayout.CENTER);

        // PANEL CENTRAL CON TABLA Y BOTÓN PARA SUBIR EXCEL
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBackground(Color.WHITE);

        // TÍTULO PRINCIPAL
        JLabel titleLabel = new JLabel("Plan Curricular de Ingeniería de Sistemas", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Georgia", Font.BOLD, 26));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));

        // CREAR LA TABLA
        String[] columnNames = {"ID", "Código", "Nombre del Curso", "Créditos", "Semestre", "Fecha de Creación"};
        model = new DefaultTableModel(null, columnNames);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true); 
        // Botón para subir el Excel
        JButton uploadButton = new JButton("Subir Plan Curricular");
        uploadButton.addActionListener(e -> uploadExcelFile());

        // Panel de botones (Subir archivo Excel)
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(uploadButton);

        // Agregar título, tabla y botones al centro
        centerPanel.add(titleLabel);
        centerPanel.add(scrollPane);
        centerPanel.add(buttonPanel);

    
        JMenuBar menuBar = new JMenuBar();
        JMenu menuOpciones = new JMenu("Opciones");
        menuOpciones.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        JMenuItem itemConfig = new JMenuItem("Configuraciones");
        JMenuItem itemInfo = new JMenuItem("Información");
        JMenuItem itemSalir = new JMenuItem("Salir");
        JMenuItem itemRegresar = new JMenuItem("Regresar");

        // Acción para "Configuraciones"
        itemConfig.addActionListener(evt -> {
            new FormularioConfiguraciones().setVisible(true); 
        });

        // Acción para "Información"
        itemInfo.addActionListener(evt -> {
            new FormularioInformacion().setVisible(true); 
        });

        itemRegresar.addActionListener(evt -> {
            new FormularioFCBI().setVisible(true); 
            dispose(); // Cierra la ventana actual
        });

        // Acción para salir
        itemSalir.addActionListener(evt -> System.exit(0));

        menuOpciones.add(itemConfig);
        menuOpciones.add(itemInfo);
        menuOpciones.add(itemSalir); 
        menuOpciones.add(itemRegresar); 
        menuBar.add(menuOpciones);
        setJMenuBar(menuBar);

        //--------------------------------------------------------------------------------------------------------------------------

        // ENSAMBLAR TODO
        backPanel.setLayout(new BorderLayout());
        backPanel.add(sidePanel, BorderLayout.WEST);
        backPanel.add(centerPanel, BorderLayout.CENTER);

        add(backPanel);
        setVisible(true);
    }

   private void uploadExcelFile() {
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setDialogTitle("Selecciona el archivo Excel");
    int result = fileChooser.showOpenDialog(this);
    if (result == JFileChooser.APPROVE_OPTION) {
        File file = fileChooser.getSelectedFile();
        try (FileInputStream fis = new FileInputStream(file)) {
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();

            model.setRowCount(0);  // Limpiar datos existentes

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                
                // Obtener datos de cada columna
                int id = 0;
                try {
                    id = (int) row.getCell(0).getNumericCellValue();  
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "❌ Error al obtener ID: " + e.getMessage());
                    continue;  
                }

                String codigo = getCellValue(row.getCell(1));
                String nombreCurso = getCellValue(row.getCell(2));
                String creditos = getCellValue(row.getCell(3));  
                String semestre = getCellValue(row.getCell(4));
                String fechaCreacion = getCellValue(row.getCell(5));

          
                new CRUDRepository().insertarPlanCurricular(id, codigo, nombreCurso, creditos, semestre, fechaCreacion);

              
                model.addRow(new Object[]{id, codigo, nombreCurso, creditos, semestre, fechaCreacion});
            }

            workbook.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error al cargar el archivo Excel: " + ex.getMessage());
        }
    }
}





// Método para manejar celdas de diferentes tipos
private String getCellValue(Cell cell) {
    if (cell == null) return "";
    
    switch (cell.getCellType()) {
        case STRING:
            return cell.getStringCellValue();
        case NUMERIC:
            if (DateUtil.isCellDateFormatted(cell)) {
                return cell.getDateCellValue().toString(); // Si es fecha, convierte a String
            } else {
                return String.valueOf(cell.getNumericCellValue()); // Si es número, lo convierte a String
            }
        case BOOLEAN:
            return String.valueOf(cell.getBooleanCellValue());
        default:
            return "";
    }
}

    public static void main(String[] args) {
        new FormularioIngSistemas();
    }
}
