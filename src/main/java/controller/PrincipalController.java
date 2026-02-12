package controller;

import controller.dao.DriverDAO;
import model.Conductor;
import view.AddDriverView;
import view.ModifyDriverView;
import view.PrincipalView;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class PrincipalController {

    private final PrincipalView view;
    private final DriverDAO driverDAO;

    ArrayList<Conductor> conductores = new ArrayList<>();

    public PrincipalController(PrincipalView view){
        this.view = view;
        this.driverDAO = new DriverDAO();

        view.getBtnRefrescar().addActionListener(e -> refrescarTabla());
        view.getBtnModificar().addActionListener(e -> modificarDriver());
        view.getBtnAdd().addActionListener(e -> addDriver());

        view.getBtnBorrar().addActionListener(e -> deteleDriver());

        view.getVistaTabla().addMouseListener(new MouseInputListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });

        view.getVistaTabla().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int clickCount = e.getClickCount();
                if(clickCount == 2)
                    JOptionPane.showMessageDialog(view,"No se puede editar: ","Error al editar",JOptionPane.ERROR_MESSAGE);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        refrescarTabla();

    }

    private void modificarDriver() {

       int filaSeleccionada = view.getVistaTabla().getSelectedRow();

       if(filaSeleccionada == -1){
//           JOptionPane.showMessageDialog(view,
//                   "Debes seleccioar un conductor",
//                   "Aviso",
//                   JOptionPane.WARNING_MESSAGE
//           );

           ModifyDriverView viewModify = new ModifyDriverView();
           new ModifyDriverController(viewModify, this);
       }else {

           String numDriver = view.getVistaTabla().getValueAt(filaSeleccionada,0).toString();
           String nombre = "";
           if( view.getVistaTabla().getValueAt(filaSeleccionada,1) == null)
               nombre ="";
          else view.getVistaTabla().getValueAt(filaSeleccionada,1).toString();
          String apellido = "";
          if (view.getVistaTabla().getValueAt(filaSeleccionada,2) == null)
              apellido = "";
          else view.getVistaTabla().getValueAt(filaSeleccionada,2).toString();


           ModifyDriverView viewModify = new ModifyDriverView();
           viewModify.getNombre().setText(nombre);
           viewModify.getApellidos().setText(apellido);
           viewModify.getNumDriver().setText(numDriver);
           viewModify.getNumDriver().setEnabled(false);
            new ModifyDriverController(viewModify, this);

       }
    }

    private void deteleDriver() {

        int filaSeleccionada = view.getVistaTabla().getSelectedRow();



        //String nombre = view.getModeloTabla().getValueAt(filaSeleccionada, 0).toString();
        if(filaSeleccionada != -1){
            Conductor conductorEliminar = conductores.get(filaSeleccionada);



        System.out.println(conductorEliminar.getNumeroConductor());
            int confirmacion = JOptionPane.showConfirmDialog(
                    view,
                    "¿Estás seguro de que deseas eliminar al conductor " + conductorEliminar.getNombre() + " " + conductorEliminar.getApellidos() + "?",
                    "Confirmar eliminación",
                    JOptionPane.YES_NO_OPTION
            );

            if (confirmacion == JOptionPane.YES_OPTION) {
                try {
                    boolean succes = driverDAO.eliminarConductor(conductorEliminar.getNumeroConductor());
                    if(succes){
                        JOptionPane.showMessageDialog(view, "Conductor eliminado correctamente.");
                        refrescarTabla();
                    }
                    else
                        JOptionPane.showMessageDialog(view, "Error al eliminar el conductor: ", "Error", JOptionPane.ERROR_MESSAGE);

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(view, "Error al eliminar el conductor: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();
                }
            }else {
                JOptionPane.showMessageDialog(view, "El conductor no ha sido eliminado.");
            }
        }else {
            JOptionPane.showMessageDialog(view, "Debe seleccionar un conductor");

        }
    }

    private void addDriver() {

        AddDriverView addPanel = new AddDriverView();
        new AddDriverController(addPanel);

    }

    public void refrescarTabla() {


        try{
            conductores = driverDAO.consultarConductores();

            if(conductores.isEmpty())
                view.getLblEstado().setText("No hay datos que mostrar");
            else {
                view.cargarConductores(conductores);
            }

        } catch (Exception e) {
            view.getLblEstado().setText("Error al cargar en la base de datos " + e.getMessage());
            e.printStackTrace();
            e.getMessage();
        }

    }

}
