package controller;

import controller.dao.DriverDAO;
import model.Conductor;
import view.ModifyDriverView;

public class ModifyDriverController {

    PrincipalController controladorPrincipal;
    ModifyDriverView viewModify;
    DriverDAO driverDao = new DriverDAO();

    public ModifyDriverController(ModifyDriverView view, PrincipalController controladorPrincipal){
        this.viewModify = view;
        this.controladorPrincipal = controladorPrincipal;

        viewModify.getBtnModify().addActionListener(e -> modificar());
        viewModify.getBtnCancelar().addActionListener(e -> viewModify.dispose());

    }

    private void modificar() {

        if(viewModify.preguntarMensaje("Seguro que quieres guardar")){

            //LLAMADA A DAO
            String nombreNuevo = viewModify.getNombre().getText().trim();
            String apellidoNuevo = viewModify.getApellidos().getText().trim();
            String numeroDriverNuevo = viewModify.getNumDriver().getText().trim();

            if(nombreNuevo.isEmpty() || apellidoNuevo.isEmpty() || numeroDriverNuevo.isEmpty()){
                viewModify.mostrarMensaje("Los campos NO pueden estar vacios");
            }else {
                try {
                    if (Integer.parseInt(numeroDriverNuevo) < 0)
                        viewModify.mostrarMensaje("El numero de conductor tiene que ser positivo");
                    else {

                        try {
                            Conductor conductorModificar = new Conductor(nombreNuevo, apellidoNuevo, Integer.parseInt(numeroDriverNuevo));
                            if (driverDao.modificarConductor(conductorModificar)) {
                                viewModify.mostrarMensaje("Conductor modificado con éxito");
                                viewModify.dispose();

                                controladorPrincipal.refrescarTabla();
                            } else viewModify.mostrarMensaje("No se ha podido mofidicar el conductor");

                        } catch (Exception e) {
                            viewModify.mostrarMensaje("Error en la base de datos al modificar. Consulte administrador" + e.getMessage());
                            e.printStackTrace();
                            e.getMessage();
                        }


                    }
                } catch (NumberFormatException e) {
                    viewModify.mostrarMensaje("El numDriver debe ser un numero" + e.getMessage());
                }
            }



        }else viewModify.dispose();

    }

}
