package controller;

import controller.dao.BusDAO;
import model.Bus;

public class BusController {

    BusDAO driverDao = new BusDAO();

    BusController(){

    }

    public void consultarConductor(int numDriver){
        driverDao.consultarConductor(Integer.parseInt(numDriver));

    }

}
