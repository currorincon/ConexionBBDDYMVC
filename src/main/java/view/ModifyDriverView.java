package view;

import javax.swing.*;
import java.awt.*;

public class ModifyDriverView extends JFrame {

    private final JButton btnModify = new JButton("Modificar");
    private final JButton btnCancelar = new JButton("Cancelar");

    private final JLabel nombreLabel = new JLabel("Nombre: ");
    private final JLabel apellidosLabel = new JLabel("Apellidos: ");
    private final JLabel numDriverLabel = new JLabel("Numero: ");


    private  JTextField nombre = new JTextField(10);
    private  JTextField apellidos = new JTextField(10);
    private  JTextField numDriver = new JTextField(10);


    public ModifyDriverView(){
        setTitle("Modificar conductor");

        setSize(new Dimension(400,400));
        setBackground(new Color(215, 184, 104));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout());

        JPanel superior = new JPanel();

        superior.setLayout(new GridLayout(3,2,50,50));
        superior.setBorder(BorderFactory.createEmptyBorder(50,50,50,50));
        superior.add(nombreLabel);
        superior.add(nombre);
        superior.add(apellidosLabel);
        superior.add(apellidos);
        superior.add(numDriverLabel);
        superior.add(numDriver);


        panelPrincipal.add(superior, BorderLayout.CENTER);




        JPanel inferior = new JPanel();
        inferior.add(btnModify);
        inferior.add(btnCancelar);
        inferior.setBackground(new Color(195, 238, 182));
        panelPrincipal.add(inferior, BorderLayout.SOUTH);



        add(panelPrincipal);
        setVisible(true);

    }

    public void mostrarMensaje(String mensaje){

        JOptionPane.showMessageDialog(
                this,
                mensaje,
                "Aviso",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    public boolean preguntarMensaje(String pregunta){

       int respuesta =  JOptionPane.showConfirmDialog(
                this,
                pregunta,
                "Aviso",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
        );

        if(respuesta == JOptionPane.YES_OPTION)
            return true;
        else return false;
    }

    public JButton getBtnModify() {
        return btnModify;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    public JLabel getNombreLabel() {
        return nombreLabel;
    }

    public JLabel getApellidosLabel() {
        return apellidosLabel;
    }

    public JLabel getNumDriverLabel() {
        return numDriverLabel;
    }

    public JTextField getNombre() {
        return nombre;
    }

    public JTextField getApellidos() {
        return apellidos;
    }

    public JTextField getNumDriver() {
        return numDriver;
    }

    public void setNombre(JTextField nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(JTextField apellidos) {
        this.apellidos = apellidos;
    }

    public void setNumDriver(JTextField numDriver) {
        this.numDriver = numDriver;
    }
}
