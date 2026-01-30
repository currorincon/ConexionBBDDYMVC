package controller;

import controller.dao.BusDAO;
import view.BusView;

public class BusController {

    BusDAO busDAO;
    BusView busView;

    BusController(BusView view) {
        this.busView = view;
        busDAO = new BusDAO();
    }

    public void consultarConductor(int numDriver) {

    }

}
