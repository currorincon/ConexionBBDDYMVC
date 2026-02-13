package view;

import controller.BusController;

import javax.swing.*;
import java.awt.*;

public class AucorsaView extends JFrame {


    //atributos
    private JTabbedPane tabs = new JTabbedPane();
    private BusPanel busPanel = new BusPanel();
    private DriverPanel driverPanel = new DriverPanel();
    private JPanel routePanel = new JPanel();
    private JLabel etiquetaEstado = new JLabel("Estado...");

    JButton btnAdd = new JButton("Añadir");
    JButton btnDelete = new JButton("Borrar");
    JButton btnRefresh = new JButton("Refrescar");
    JButton btnModify = new JButton("Modificar");

    JPanel panelNorte = new JPanel();
    JPanel botoneriaPanel = new JPanel();

    public AucorsaView(){

        super("Aucorsa - Ventana principal");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(800,600);


        setLayout(new BorderLayout());

        tabs.add("Bus", busPanel);
        tabs.add("Drivers", driverPanel);
        tabs.add("Route", routePanel);

        //tabs.setEnabledAt(1,false);

        add(tabs, BorderLayout.CENTER);

        panelNorte.setLayout(new BorderLayout());

        botoneriaPanel.setLayout(new FlowLayout());
        botoneriaPanel.add(btnAdd);
        botoneriaPanel.add(btnDelete);
        botoneriaPanel.add(btnModify);
        botoneriaPanel.add(btnRefresh);

        panelNorte.add(botoneriaPanel, BorderLayout.NORTH);
        panelNorte.add(etiquetaEstado, BorderLayout.SOUTH);

        add(panelNorte, BorderLayout.NORTH);



    }

    public JTabbedPane getTabs() {
        return tabs;
    }

    public void setTabs(JTabbedPane tabs) {
        this.tabs = tabs;
    }

    public BusPanel getBusPanel() {
        return busPanel;
    }

    public void setBusPanel(BusPanel busPanel) {
        this.busPanel = busPanel;
    }

    public DriverPanel getDriverPanel() {
        return driverPanel;
    }

    public void setDriverPanel(DriverPanel driverPanel) {
        this.driverPanel = driverPanel;
    }

    public JPanel getRoutePanel() {
        return routePanel;
    }

    public void setRoutePanel(JPanel routePanel) {
        this.routePanel = routePanel;
    }

    public JLabel getEtiquetaEstado() {
        return etiquetaEstado;
    }

    public void setEtiquetaEstado(JLabel etiquetaEstado) {
        this.etiquetaEstado = etiquetaEstado;
    }

    public JButton getBtnAdd() {
        return btnAdd;
    }

    public void setBtnAdd(JButton btnAdd) {
        this.btnAdd = btnAdd;
    }

    public JButton getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(JButton btnDelete) {
        this.btnDelete = btnDelete;
    }

    public JButton getBtnRefresh() {
        return btnRefresh;
    }

    public void setBtnRefresh(JButton btnRefresh) {
        this.btnRefresh = btnRefresh;
    }

    public JButton getBtnModify() {
        return btnModify;
    }

    public void setBtnModify(JButton btnModify) {
        this.btnModify = btnModify;
    }

    public JPanel getPanelNorte() {
        return panelNorte;
    }

    public void setPanelNorte(JPanel panelNorte) {
        this.panelNorte = panelNorte;
    }

    public JPanel getBotoneriaPanel() {
        return botoneriaPanel;
    }

    public void setBotoneriaPanel(JPanel botoneriaPanel) {
        this.botoneriaPanel = botoneriaPanel;
    }
}
