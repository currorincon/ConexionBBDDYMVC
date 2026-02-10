package view;

import model.Conductor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class PrincipalView extends JFrame {

    private final JButton btnAdd = new JButton("Añadir");
    private final JButton btnBuscar = new JButton("Buscar");
    private final JButton btnBorrar = new JButton("Borrar");
    private final JButton btnRefrescar = new JButton("Refrescar");

    private final JLabel lblEstado = new JLabel("Aucorsa");

    private DefaultTableModel modeloTabla;
    private JTable vistaTabla;

    public PrincipalView(){
        this.setTitle("Acurosa - Ventana Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(850,450);
        // setBounds(100,100,850,450);
        //para centrar la ventana
        setLocationRelativeTo(null);

        setLayout(new BorderLayout(10,10));
        JPanel top = new JPanel(new FlowLayout(FlowLayout.CENTER,10,10));
        top.add(btnAdd);

        top.add(btnBorrar);
        top.add(btnRefrescar);
        add(top, BorderLayout.NORTH);


        JPanel west = new JPanel();
        west.setSize(5,80);
        west.add(btnBuscar);
        west.add(btnBorrar);
        add(west, BorderLayout.WEST);
        west.setLayout( new BoxLayout(west,BoxLayout.Y_AXIS));

        JPanel bot = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bot.add(lblEstado);
        add(bot,BorderLayout.SOUTH);

        modeloTabla = new DefaultTableModel(new String[]{"Numero", "Nombre", "Apellidos"}, 0);
        vistaTabla = new JTable(modeloTabla);

        add(new JScrollPane(vistaTabla),BorderLayout.CENTER);

    }

    public JButton getBtnAdd() {
        return btnAdd;
    }

    public JButton getBtnBuscar() {
        return btnBuscar;
    }

    public JButton getBtnBorrar() {
        return btnBorrar;
    }

    public JButton getBtnRefrescar() {
        return btnRefrescar;
    }

    public JLabel getLblEstado() {
        return lblEstado;
    }

    public void cargarConductores(ArrayList<Conductor> conductores) {

        modeloTabla.setRowCount(0);

        for( Conductor c : conductores){
            modeloTabla.addRow(new Object[] {c.getNumeroConductor(),
                  c.getNombre(), c.getApellidos()});
        }


    }
}
