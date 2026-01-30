package view;

import javax.swing.*;

public class DriverView extends JFrame {

    public JButton bntBuscar;
    public JTextField txtNumDriver;
    public JLabel etiquetaDriver;

    public DriverView(){
        //super("Vista Conductor");
        setTitle("Vista Conductor");
        setBounds(600,600,800,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        bntBuscar = new JButton("Buscar");
        bntBuscar.setSize(100,50);


        txtNumDriver = new JTextField(10);
        etiquetaDriver = new JLabel("Introduzca el conductor a buscar");

        JPanel panelConductor = new JPanel();

        panelConductor.add(etiquetaDriver);
        panelConductor.add(txtNumDriver);
        panelConductor.add(bntBuscar);

        this.add(panelConductor);

        setVisible(true);
    }

}
