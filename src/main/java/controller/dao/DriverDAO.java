package controller.dao;

import controller.db.ConexionDB;
import model.Conductor;

import java.sql.*;

public class DriverDAO {


    public Conductor consultarConductor(int numDriver) {

        String sql = "select name, surname from Driver where numDriver = ?";


        Conductor conductorConsultado = new Conductor();
        try (Connection con = ConexionDB.getConexion()) {


            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1,numDriver);
            ResultSet rs = ps.executeQuery();


            while(rs.next()){
               conductorConsultado.setNombre(rs.getString(1));
               conductorConsultado.setApellidos(rs.getString("surname"));
               conductorConsultado.setNumeroConductor(numDriver);
            }

            return conductorConsultado;


        } catch (SQLException e) {
            System.out.println("Error al cargar la BBDD consulte con el administrador");
            throw new RuntimeException(e);
        }




    }

}
