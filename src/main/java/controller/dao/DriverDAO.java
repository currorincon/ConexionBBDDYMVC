package controller.dao;

import com.mysql.cj.conf.ConnectionPropertiesTransform;
import controller.db.ConexionDB;
import model.Conductor;

import java.sql.*;
import java.util.ArrayList;

public class DriverDAO {

    public ArrayList<Conductor> consultarConductores(){


        String sql = "select numdriver, name, surname from Driver";

        ArrayList<Conductor> conductores = new ArrayList<>();

        try (Connection con = ConexionDB.getConexion()) {

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();


            while(rs.next()){
                Conductor conductorConsultado = new Conductor();
                conductorConsultado.setNombre(rs.getString("name"));
                conductorConsultado.setApellidos(rs.getString("surname"));
                conductorConsultado.setNumeroConductor(rs.getInt("numdriver"));
                conductores.add(conductorConsultado);
            }

            return conductores;


        } catch (SQLException e) {
            System.out.println("Error al cargar la BBDD consulte con el administrador");
            throw new RuntimeException(e);
        }

    }

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

    public boolean addDriver(Conductor conductor) {

        String sql = "INSERT INTO Driver VALUES (?,?,?)";

        try (Connection con = ConexionDB.getConexion()) {

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,conductor.getNumeroConductor());
            ps.setString(2, conductor.getNombre());
            ps.setString(3,conductor.getApellidos());


            int rowAffected = ps.executeUpdate();

            if(rowAffected > 0 )
                return true;
            else return false;


        } catch (SQLException e) {
            System.out.println("Error al cargar la BBDD consulte con el administrador");
            throw new RuntimeException(e);
        }

    }

    public boolean eliminarConductor(int numeroConductor) throws SQLException {

        String sql = "DELETE FROM Driver WHERE numDriver = ?";

        try (Connection con = ConexionDB.getConexion()) {

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, numeroConductor);

            int rowAffected = ps.executeUpdate();

            if(rowAffected > 0 )
                return true;
            else return false;
        }
        catch (SQLException e) {
            System.out.println("Error al cargar la BBDD consulte con el administrador");
            throw new SQLException(e);
        }

    }

    public boolean modificarConductor(Conductor conductorModificar) throws SQLException {

            Connection con = ConexionDB.getConexion();
            String sql = "UPDATE Driver SET name = ?, surname = ? " +
                    "WHERE numdriver = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,conductorModificar.getNombre());
            ps.setString(2,conductorModificar.getApellidos());
            ps.setInt(3, conductorModificar.getNumeroConductor());

            int rowAffected = ps.executeUpdate();

            if(rowAffected == 0)
                return false;
            else return true;


    }
}
