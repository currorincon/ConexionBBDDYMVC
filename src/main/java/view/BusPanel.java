package view;

import model.Bus;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class BusPanel extends JPanel {

    private JPanel panelBus = new JPanel();

    private JTable tablaVista = new JTable();
    private DefaultTableModel modeloTabla;

    public JTable getTablaVista() {
        return tablaVista;
    }

    public void setTablaVista(JTable tablaVista) {
        this.tablaVista = tablaVista;
    }

    public DefaultTableModel getModeloTabla() {
        return modeloTabla;
    }

    public void setModeloTabla(DefaultTableModel modeloTabla) {
        this.modeloTabla = modeloTabla;
    }

    public BusPanel(){


        setLayout(new BorderLayout());

        panelBus.setLayout(new FlowLayout());

        modeloTabla = new DefaultTableModel(new String[]{"Registrer", "Type", "License"}, 0);


        tablaVista = new JTable(modeloTabla);
        tablaVista.setFillsViewportHeight(true);
        tablaVista.setRowSelectionAllowed(true);
        tablaVista.setColumnSelectionAllowed(false);
        tablaVista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        panelBus.add(new JScrollPane(tablaVista),BorderLayout.CENTER);
        add(panelBus);

    }

}
