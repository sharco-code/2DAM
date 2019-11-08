package DAO;

import Controller.JDBCConnection;
import Exceptions.BusinessException;
import Model.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductoDAO {
    
    private Connection con = null;
    private PreparedStatement pstmt = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    
    /**
    * Devuelve el string del nombre de producto cuyo id se indica-
    * @param id identificador del objeto buscado
    * @return el string buscado o null si no existe
    */
    public String getNombre(Integer id) throws BusinessException {
        if(id == null) throw new BusinessException("[getNombre] el id no puede ser null");
        try {
            con = JDBCConnection.getConnection();
            pstmt = con.prepareStatement("select Nombre from productos where idProducto like ?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            
            if(rs.next()) {
                return rs.getString(1);
            }

        } catch (SQLException e) {
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, "[getNombre] Error al borrar", e);
        } finally {
            JDBCConnection.cerrar(stmt);
        }
        return null;
    }
    
    public Integer getId(String nombre) throws BusinessException {
        if(nombre == null) throw new BusinessException("[getId] el nombre no puede ser null");
        try {
            con = JDBCConnection.getConnection();
            pstmt = con.prepareStatement("select idProducto from productos where Nombre like \""+nombre+"\"", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = pstmt.executeQuery();
            
            if(rs.next()) {
                return rs.getInt(1);
            }

        } catch (SQLException e) {
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, "[getId] Error al borrar", e);
        } finally {
            JDBCConnection.cerrar(stmt);
        }
        return null;
    }
    /**
    * Devuelve una lista con todos los objetos de la base de datos
    * @return lista con todos los objetos o una null si no hay ninguno
    */
    public List<Producto> getAll() throws BusinessException {
        List<Producto> list = new ArrayList<Producto>();
        try {
            con = JDBCConnection.getConnection();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select idProducto, Nombre from productos");

            while (rs.next()) {
                list.add(new Producto(rs.getInt(1), rs.getString(2)));
            }

            return list;
        } catch (SQLException e) {
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, "[getId] Error al buscar por ID");
        } finally {
            JDBCConnection.cerrar(stmt);
        }
        return null;
    }
    
}
