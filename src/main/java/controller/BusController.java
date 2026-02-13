package controller;

import controller.dao.BusDAO;
import model.Bus;
import model.Conductor;
import view.BusPanel;
import view.BusView;

import java.util.ArrayList;

public class BusController {

    BusDAO busDAO;
    BusView busView;
    BusPanel busPanel;

    ArrayList<Bus> buses = new ArrayList<>();

    public BusController(BusPanel panel) {
        this.busPanel = panel;
        busDAO = new BusDAO();
        cargarBuses();
    }

    public void consultarConductor(int numDriver) {

    }

    public void cargarBuses(){

        buses = busDAO.obtenerBuses();

        busPanel.getModeloTabla().setRowCount(0);

        for( Bus b : buses){
            busPanel.getModeloTabla().addRow(new Object[] {b.getRegistrer(),
                    b.getType(), b.getLicense()});
        }
    }

    public void addBus() {

        busDAO.insertarAutobusRuta(2,2);

    }
}
