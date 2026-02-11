package controller;

import controller.dao.DriverDAO;
import model.Conductor;
import view.AddDriverView;
import view.PrincipalView;

import javax.swing.*;
import java.util.ArrayList;

public class PrincipalController {

    private final PrincipalView view;
    private final DriverDAO driverDAO;

    ArrayList<Conductor> conductores = new ArrayList<>();

    public PrincipalController(PrincipalView view){
        this.view = view;
        this.driverDAO = new DriverDAO();

        view.getBtnRefrescar().addActionListener(e -> refrescarTabla());
        view.getBtnAdd().addActionListener(e -> addDriver());

        view.getBtnBorrar().addActionListener(e -> deteleDriver());

        refrescarTabla();

    }

    private void deteleDriver() {

        int filaSeleccionada = view.getVistaTabla().getSelectedRow();

        //String nombre = view.getModeloTabla().getValueAt(filaSeleccionada, 0).toString();

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
                    driverDAO.eliminarConductor(conductorEliminar.getNumeroConductor());
                    JOptionPane.showMessageDialog(view, "Conductor eliminado correctamente.");
                    refrescarTabla();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(view, "Error al eliminar el conductor: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();
                }
            }else {
                JOptionPane.showMessageDialog(view, "El conductor no ha sido eliminado.");
            }

    }

    private void addDriver() {

        AddDriverView addPanel = new AddDriverView();
        new AddDriverController(addPanel);

    }

    private void refrescarTabla() {


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
