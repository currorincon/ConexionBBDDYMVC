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

    public PrincipalController(PrincipalView view){
        this.view = view;
        this.driverDAO = new DriverDAO();

        view.getBtnRefrescar().addActionListener(e -> refrescarTabla());
        view.getBtnAdd().addActionListener(e -> addDriver());

        refrescarTabla();

    }

    private void addDriver() {

        AddDriverView addPanel = new AddDriverView();
        new AddDriverController(addPanel);

    }

    private void refrescarTabla() {


        try{
            ArrayList<Conductor> conductores = driverDAO.consultarConductores();

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
