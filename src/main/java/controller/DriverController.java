package controller;

import controller.dao.DriverDAO;
import model.Conductor;
import view.DriverView;

public class DriverController {

    DriverView vistaConductor;
    DriverDAO daoConductor;
    Conductor driver;

    public DriverController(DriverView view){
        this.vistaConductor = view;
        daoConductor = new DriverDAO();
        driver = new Conductor();
    }

    public void consultarCosas(){

        vistaConductor.bntBuscar.addActionListener(e -> {

            driver = daoConductor.consultarConductor(Integer.parseInt(vistaConductor.txtNumDriver.getText()));
            vistaConductor.etiquetaDriver.setText(driver.getNombre());

        });


    }

}
