package view;

import javax.swing.*;
import java.awt.*;

public class AddDriverView extends JFrame {

    private final JButton btnAdd = new JButton("Añadir");
    private final JButton btnCancelar = new JButton("Cancelar");

    private final JTextField nombre = new JTextField(10);
    private final JTextField apellidos = new JTextField(10);

    public JTextField getNumDriver() {
        return numDriver;
    }

    public JTextField getApellidos() {
        return apellidos;
    }

    public JTextField getNombre() {
        return nombre;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    public JButton getBtnAdd() {
        return btnAdd;
    }

    private final JTextField numDriver = new JTextField(10);


   public AddDriverView(){

       this.setTitle("Acurosa - Ventana Principal");


       setSize(200,200);
       // setBounds(100,100,850,450);
       //para centrar la ventana
       setLocationRelativeTo(null);
       JPanel center = new JPanel(new FlowLayout(FlowLayout.CENTER,10,10));
       center.add(nombre);
       center.add(apellidos);
       center.add(numDriver);
       center.add(btnAdd);
       center.add(btnCancelar);

       this.add(center);
       setVisible(true);
   }

}
