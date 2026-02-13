package controller;

import view.AddDriverView;
import view.AucorsaView;

import javax.swing.*;
import javax.xml.transform.Source;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MainController {

    AucorsaView aucorsaView;

    public MainController(AucorsaView view){
        this.aucorsaView = view;
        new BusController(aucorsaView.getBusPanel());

        aucorsaView.getBtnAdd().addActionListener(e -> addDriver());

        aucorsaView.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {

                int resultado = JOptionPane.showConfirmDialog(
                        aucorsaView,
                        "Estas seguro de que te marchas ya????",
                        "SEguro",
                        JOptionPane.YES_NO_OPTION
                );

                if(resultado == JOptionPane.YES_OPTION){
                    System.exit(0);
                }else System.out.println("Mevoyu");

            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });

    }

    private void addDriver() {

       int tabSelected =  aucorsaView.getTabs().getSelectedIndex();
       String tab =  aucorsaView.getTabs().getTitleAt(tabSelected);

       switch (tab){
           case "Bus":
               BusController busController = new BusController(aucorsaView.getBusPanel());
               busController.addBus();
               break;
           case "Drivers":
               JOptionPane.showMessageDialog(aucorsaView,"estas en: " + tab);

               break;
           case "Route":
               JOptionPane.showMessageDialog(aucorsaView,"estas en: " + tab);

               break;
       }

        AddDriverView addPanel = new AddDriverView();
        new AddDriverController(addPanel);

    }
}
