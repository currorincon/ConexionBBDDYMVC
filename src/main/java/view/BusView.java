package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class BusView extends JPanel {
    private final JButton btnAdd = new JButton("Añadir");
    private final JButton btnBuscar = new JButton("Buscar");
    private final JButton btnBorrar = new JButton("Borrar");
    private final JButton btnRefrescar = new JButton("Refrescar");
    private final JButton btnModificar = new JButton("Modificar");


    private final JLabel lblEstado = new JLabel("Aucorsa");


    private DefaultTableModel modeloTabla;
    private JTable vistaTabla;


    public BusView(){

        setLayout(new BorderLayout(10,10));
        JPanel top = new JPanel(new FlowLayout(FlowLayout.CENTER,10,10));
        top.add(btnAdd);

        top.add(btnBorrar);
        top.add(btnRefrescar);
        top.add(btnModificar);
        top.add(btnBuscar);
        top.add(btnBorrar);
        add(top, BorderLayout.NORTH);


        JPanel bot = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bot.add(lblEstado);
        add(bot,BorderLayout.SOUTH);

        modeloTabla = new DefaultTableModel(new String[]{"Numero", "Nombre", "Apellidos"}, 0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        vistaTabla = new JTable(modeloTabla);
        vistaTabla.setFillsViewportHeight(true);
        vistaTabla.setRowSelectionAllowed(true);
        vistaTabla.setColumnSelectionAllowed(false);
        vistaTabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        add(new JScrollPane(vistaTabla),BorderLayout.CENTER);


    }

}
