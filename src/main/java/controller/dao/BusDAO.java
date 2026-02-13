package controller.dao;

import controller.db.ConexionDB;
import model.Bus;
import model.Conductor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BusDAO {

    public boolean insertarAutobusRuta(int numBus, int numRuta){


        try(Connection con = ConexionDB.getConexion()){
            try {
                con.setAutoCommit(false);

                String sql = "INSERT INTO BUS VALUES ?,?,?";
                PreparedStatement ps = con.prepareStatement(sql);

                ps.setString(1, "B011");
                ps.setString(2, "Urbano");
                ps.setString(3, "LIC011");

                ps.executeUpdate();

                sql = "INSERT INTO BDP VALUES ?,?,?,?";

                ps.setString(1, "B011");
                ps.setString(2, "Urbano");
                ps.setString(3, "LIC011");

                ps.executeUpdate();

                con.commit();
                return true;
            } catch (Exception e) {
                con.rollback();
                throw new RuntimeException(e);
            }finally {
                con.setAutoCommit(true);
                return false;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    public ArrayList<Bus> obtenerBuses() {

        String sql = "select register, type, license from Bus";

        ArrayList<Bus> autobuses = new ArrayList<>();

        try (Connection con = ConexionDB.getConexion()) {

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Bus busConsultado = new Bus();
                busConsultado.setRegistrer(rs.getString("register"));
                busConsultado.setType(rs.getString("type"));
                busConsultado.setLicense(rs.getString("license"));
                autobuses.add(busConsultado);
            }

            return autobuses;


        } catch (SQLException e) {
            System.out.println("Error al cargar la BBDD consulte con el administrador");
            throw new RuntimeException(e);
        }


    }
}
