package Controlador;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    private Connection conn;
    private Statement instruc;
    private String database = "bbdd_torres_toro";
    private String user = "root";
    private String pass = "";

    public Conexion() {
        try {
            String conex = "jdbc:mysql://localhost:3306/" + database;
            conn = DriverManager.getConnection(conex, user, pass);
            instruc = conn.createStatement();
            System.out.println("Conexión establecida");
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error en la conexión: " + ex);
        }
    }

    public Connection getConn() {
        if (conn == null) {
            try {
                String conex = "jdbc:mysql://localhost:3306/" + database;
                conn = DriverManager.getConnection(conex, user, pass);
                instruc = conn.createStatement();
                System.out.println("Conexión establecida");
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Error en la conexión: " + ex);
            }
        }
        return conn;
    }

    public void exec(String sql) {
        try {
            instruc.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet consulta(String sql) {
        ResultSet res = null;
        try {
            res = instruc.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    public void close() {
        try {
            if (instruc != null) {
                instruc.close();
            }
            if (conn != null) {
                conn.close();
                System.out.println("Conexión cerrada");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
