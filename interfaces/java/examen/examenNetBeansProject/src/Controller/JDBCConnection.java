package Controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

public class JDBCConnection {

    private static Connection con;

    private String driver;
    private String url;

    private String usr;
    private String pwd;

    private String jsonfile;

    public JDBCConnection(String jsonfile, String usr, String pwd) {
        this.jsonfile = jsonfile;
        this.usr = usr;
        this.pwd = pwd;
    }

    private void conectar(String jsonfile, String usr, String pwd) throws FileNotFoundException, IOException, Exception {
        Object object = new JSONParser().parse(new FileReader(jsonfile));
        JSONObject jo = (JSONObject) object;
        JSONArray ja = (JSONArray) jo.get("DataBase");
        JSONObject jsonObj = (JSONObject) ja.get(0);

        String driver = (String) jsonObj.get("driverClassName");
        String url = (String) jsonObj.get("url");

        BasicDataSource ds = new BasicDataSource();

        ds.setDriverClassName(driver);
        ds.setUrl(url);

        ds.setUsername(usr);
        ds.setPassword(pwd);

        con = ds.getConnection();

    }

    public void conectar() throws FileNotFoundException, IOException, Exception {

        conectar(jsonfile, usr, pwd);
        /*
         try {
         if (jsonfile != null) {
         conectar(jsonfile, usr, pwd);
         } else {
         conectar(driver, url, usr, pwd);
         }
         } catch (FileNotFoundException e) {
         Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, "[ERROR] no se encuentra archivo ", e);
         throw new FileNotFoundException();
         } catch (IOException e) {
         Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, "[ERROR] IO exception al establecer la conexion", e);
         throw new IOException();
         } catch (Exception e) {
         Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, "[ERROR] al establecer la conexion", e);
         throw new Exception();
         }
         */

    }

    public static Connection getConnection() {
        return con;
    }

    public void desconectar() {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (SQLException e) {
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, "[ERROR] al cerrar la conexión", e);
        }

    }

    public static void cerrar(ResultSet rs) {
        try {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
        } catch (SQLException e) {
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, "[ERROR] al cerrar ResultSet", e);
        }

    }

    public static void cerrar(Statement stmt) {
        try {
            if (stmt != null && !stmt.isClosed()) {
                stmt.close();
            }
        } catch (SQLException e) {
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, "[ERROR] al cerrar Statement", e);
        }

    }
}
