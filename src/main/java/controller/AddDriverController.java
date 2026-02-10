package controller;

import controller.dao.DriverDAO;
import model.Conductor;
import view.AddDriverView;

import javax.swing.*;

public class AddDriverController {

    private final AddDriverView view;
    private final DriverDAO driverDAO;

    public AddDriverController(AddDriverView view) {
        this.view = view;
        this.driverDAO = new DriverDAO();

        view.getBtnCancelar().addActionListener(e -> view.dispose());
        view.getBtnAdd().addActionListener(e -> confirmarGuardado());
    }


    private void confirmarGuardado() {

        boolean addSuccess = false;
        Conductor conductor = new Conductor();

        String sNum = view.getNumDriver().getText().trim();
        String nombre = view.getNombre().getText().trim();
        String apellidos = view.getApellidos().getText().trim();

        if (sNum.isEmpty() || nombre.isEmpty() || apellidos.isEmpty()) {
            JOptionPane.showMessageDialog(
                    view,
                    "Deben estar todos los campos completos.",
                    "Error de validación",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }
        conductor.setNombre(view.getNombre().getText());
        conductor.setApellidos(view.getApellidos().getText());

        try {
            int numDriver = Integer.parseInt(view.getNumDriver().getText());

            if (numDriver <= 0) {
                JOptionPane.showMessageDialog(
                        view,
                        "Debe ser un número de conductor positivo.",
                        "Error de validación",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            conductor.setNumeroConductor(Integer.parseInt(view.getNumDriver().getText()));

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                    view,
                    "Numero debe ser en formato numérico válido.",
                    "Error de formato",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        // Cuadro de confirmación
        int opcion = JOptionPane.showConfirmDialog(
                view,
                "¿Estás seguro de que quieres guardar el conductor?",
                "Confirmar guardado",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        //Si pulsa no, no hacemos nada y cerramos el cuadro de diálogo.
        if (opcion != JOptionPane.YES_OPTION) {
            view.dispose();
            return;
        }

        try{
            addSuccess  = driverDAO.addDriver(conductor);
        } catch (Exception err) {
            throw new RuntimeException(err);
        }

        if(addSuccess){
            JOptionPane.showMessageDialog(
                    view,
                    "Conductor guardado correctamente",
                    "Información",
                    JOptionPane.INFORMATION_MESSAGE
            );

        }else {
            JOptionPane.showMessageDialog(
                    view,
                    "Error al guardar el conductor. Inténtalo de nuevo.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }

        // Cerramos la ventana tras guardar
        view.dispose();
    }

}
