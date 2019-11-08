package DAO;

import Controller.JDBCConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginDAO {

    private Connection con = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    public boolean login(String empleado, String password) {
        try {
            con = JDBCConnection.getConnection();

            pstmt = con.prepareStatement("select * from empleados where Empleado like ? AND Clave like ?");
            pstmt.setString(1, empleado);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return true;
            }

        } catch (Exception e) {
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, "[ERROR] Error en el login",e);
        } finally {
            JDBCConnection.cerrar(pstmt);
        }
        return false;
    }
}
