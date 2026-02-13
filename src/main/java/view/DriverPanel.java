package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class DriverPanel extends  JPanel{


    JPanel panelDriver = new JPanel();

    JTable tablaVista = new JTable();
    DefaultTableModel modeloTabla = new DefaultTableModel();


    public DriverPanel(){

        setSize(300,300);
        setVisible(false);
        setLayout(new BorderLayout());


        panelDriver.setLayout(new FlowLayout());


        panelDriver.add(tablaVista, BorderLayout.CENTER);

        add(panelDriver);

    }

}
