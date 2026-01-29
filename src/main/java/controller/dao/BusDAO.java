package controller.dao;

import controller.db.ConexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
}
