package view;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame{

    private JTabbedPane tabs;

    public MainView(){
        super("Aucorsa - GESTIÓN");
        setSize(900,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        tabs = new JTabbedPane();
        //tabs = new JTabbedPane(JTabbedPane.TOP);

        BusView busTab = new BusView();
        DriverView driverTab = new DriverView();

        tabs.add("Buses",busTab);
        tabs.add("Conductores", driverTab);

        add(tabs, BorderLayout.CENTER);
        setVisible(true);
    }

}
