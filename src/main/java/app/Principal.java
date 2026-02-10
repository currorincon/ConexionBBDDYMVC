package app;

import controller.BusController;
import controller.DriverController;
import controller.PrincipalController;
import controller.dao.DriverDAO;
import model.Conductor;
import view.BusView;
import view.DriverView;
import view.PrincipalView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {


    public static void main(String[] args) {

        ArrayList<Conductor> conductores = new ArrayList<>();
        DriverDAO driverDao = new DriverDAO();

         PrincipalView viewPrincipal = new PrincipalView();
         new PrincipalController(viewPrincipal);
         viewPrincipal.setVisible(true);



//        JFrame ventanaPrincipal = new JFrame("Aucorsa");
//        ventanaPrincipal.setBounds(100,100,800,800);
//
//
//        DriverView vistaConductor = new DriverView();
//        DriverController controladorConductor = new DriverController(vistaConductor);
//        controladorConductor.consultarCosas();
//
//        ventanaPrincipal.add(vistaConductor);
//        BusView vistaConductor = new BusView();
//        BusController controladorConductor = new BusController();




        //
//        JFrame miVentana = new JFrame("Curro es mi primera ventana");

//
//        miVentana.setTitle("Aucorsa");
//        miVentana.setBounds(200,200, 800,600);
//        miVentana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//
//        JPanel panelPrincipal = new JPanel();
//        JLabel numConductor = new JLabel("Numero conductor: ");
//        JTextField txtNumConductor = new JTextField(8);
//        JButton bntBuscar = new JButton("Buscar");
//        JLabel mostrarResultado = new JLabel();
//        mostrarResultado.setText("cargando...");
//
//            txtNumConductor.addKeyListener(new KeyListener() {
//                                               @Override
//                                               public void keyTyped(KeyEvent e) {
//                                                   if(e.getKeyChar() == 'Q'){
//                                                       System.out.println("VAS a salir");
//                                                       System.exit(0);
//                                                   }
//                                               }
//
//                                               @Override
//                                               public void keyPressed(KeyEvent e) {
//
//                                               }
//
//                                               @Override
//                                               public void keyReleased(KeyEvent e) {
//
//                                               }
//                                           }
//            );
//
//
//        bntBuscar.addActionListener(e -> {
//
//                String numDriver = txtNumConductor.getText();
//                    try {
//                        conductores.add(driverDao.consultarConductor(Integer.parseInt(numDriver)));
//                        mostrarResultado.setText(conductores.getFirst().getNombre() + " "
//                                + conductores.getFirst().getApellidos() + " " + conductores.getFirst().getNumeroConductor());
//
//
//                    } catch (NumberFormatException ex) {
//                              JOptionPane.showMessageDialog(null, "Error. Introduce un numero de conductor valido");
//                              mostrarResultado.setText("Error en la consulta");
//                    }
//
//             }
//        );
//
//        panelPrincipal.addKeyListener(new KeyListener() {
//            @Override
//            public void keyTyped(KeyEvent e) {
//                if(e.getKeyChar() == 'Q' || e.getKeyChar() == 'q'){
//                    System.out.println("VAS a salir");
//                    System.exit(0);
//                }
//            }
//
//            @Override
//            public void keyPressed(KeyEvent e) {
//
//            }
//
//            @Override
//            public void keyReleased(KeyEvent e) {
//
//            }
//        });
//
//
//        panelPrincipal.add(numConductor);
//        panelPrincipal.add(txtNumConductor);
//        panelPrincipal.add(bntBuscar);
//        panelPrincipal.add(mostrarResultado);
//        miVentana.add(panelPrincipal);
//
//        miVentana.setVisible(true);
//
//
//
//
//

//
//        JPanel panel = new JPanel();
//
//
//        JLabel etiqueta = new JLabel();
//        etiqueta.setText("Gestion de conductores");
//        JLabel conductor = new JLabel("Conductor:");
//
//        JTextField txtDriver = new JTextField(10);
//        txtDriver.setText("xxx");
//
//        JButton btnBuscar = new JButton("Buscar");
//
//        btnBuscar.addActionListener(e-> {
//            String texto = txtDriver.getText();
//            JOptionPane.showMessageDialog(null, "Has introducido: " + texto);
//        });
//
//
//        panel.add(etiqueta);
//        panel.add(conductor);
//        panel.add(txtDriver);
//        panel.add(btnBuscar);
//
//        //panel.setLayout(new FlowLayout());
//        panel.setLayout(new CardLayout());
//
//        miVentana.add(panel);
//
//
//
//
//        miVentana.setVisible(true);
//


       // BusView vistaBus = new BusView();

        int opcion = 0;

        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Bienvenido al sistema de AUCORSA.");
            System.out.println("Qué desea hacer?");
            System.out.println("\t1. Consultar conductores");
            System.out.println("\t2. Insertar conductores");
            System.out.println("\t3. Borrar conductores");
            System.out.println("\t0. Salir");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Dime numero conductor a consultar: ");
                    int numDriver = sc.nextInt();
                    conductores.add(driverDao.consultarConductor(numDriver));
                    System.out.println(conductores.getFirst());
                    break;
                case 2:

                    break;
                case 3:

                    break;
            }


        }while (opcion != 0 );

    }

}
