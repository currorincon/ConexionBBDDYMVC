package controller.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {

    public static final String USER = "root";
    public static final String PASSWORD = "1234";
    public static final String URL = "jdbc:mysql://127.0.0.1:3306/Aucorsa";

    public static Connection getConexion() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
