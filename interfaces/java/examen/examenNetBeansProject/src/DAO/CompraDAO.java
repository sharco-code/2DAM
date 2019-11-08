package DAO;

import Controller.JDBCConnection;
import Exceptions.BusinessException;
import Model.Compra;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CompraDAO {

    private Connection con = null;
    private PreparedStatement pstmt = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    /**
    * Persiste el objeto dado.
    * Tras la inseción el objeto tendrá actualizado su identificador. 
    * @param compra Objeto a insertar.
    * @throws BussinessException si el objeto ya existia
    */
    public void insert(Compra compra) throws BusinessException {
        if(compra.getCantidad() == null &&
            compra.getFecha() == null &&
            compra.getIdProducto() == null &&
            compra.getIdProveedor() == null) throw new BusinessException("ninguna columna puede ser null");
        
        try {
            con = JDBCConnection.getConnection();
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("select * from compras");
            
            rs.moveToInsertRow();
            rs.updateInt("idProducto", compra.getIdProducto());
            rs.updateInt("idProveedor", compra.getIdProveedor());
            rs.updateDouble("Cantidad", compra.getCantidad());
            rs.updateString("fecha", compra.getFecha());
            
            rs.insertRow();
            
        } catch (SQLException e) {
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, "[insertar compra] Error al insertar", e);
        } finally {
            JDBCConnection.cerrar(stmt);
        }
    }
    
    /**
    * Actualiza los datos persistidos de un objeto ya existente en la BD con los datos 
    * contenidos en el pojo.
    * @param compra Objeto del que se toman los datos.
    * @throws BusinessException si el objeto no existe.
    */
    public void update(Compra compra) throws BusinessException {
        try {
            con = JDBCConnection.getConnection();
            pstmt = con.prepareStatement("select * from compras where idCompra like ?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pstmt.setInt(1, compra.getIdCompra());
            rs = pstmt.executeQuery();
            
            if(rs.next()) {
                rs.updateInt("idProducto", compra.getIdProducto());
                rs.updateInt("idProveedor", compra.getIdProveedor());
                rs.updateDouble("Cantidad", compra.getCantidad());
                rs.updateString("fecha", compra.getFecha());
                rs.updateRow();
            }

        } catch (SQLException e) {
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, "[actualizar compra] Error al actualizar", e);
        } finally {
            JDBCConnection.cerrar(stmt);
        }
    }
    
    /**
    * Elimina el objeto indicado de la BD
    * @param id Identificador del objeto a eliminar 
    * @throws BusinessException si el objeto no existe o no se puede eliminar o SQLException si hay un error de SQL
    */
    public void delete(Integer id) throws BusinessException {
        if(id == null) throw new BusinessException("[borrar compra] el id no puede ser null");
        try {
            con = JDBCConnection.getConnection();
            pstmt = con.prepareStatement("select * from compras where idCompra like ?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            if(rs.next()) {
                rs.deleteRow();
                return;
            }
            
        } catch (SQLException e) {
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, "[actualizar compra] Error al borrar", e);
        } finally {
            JDBCConnection.cerrar(stmt);
        }
    }
    /**
    * Devuelve una lista con todos los objetos de la base de datos
    * @return lista con todos los objetos o una null si no hay ninguno
    */
    public List<Compra> getAll() throws BusinessException {
        List<Compra> list = new ArrayList<Compra>();
        try {
            con = JDBCConnection.getConnection();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from compras");

            while (rs.next()) {
                list.add(new Compra(rs.getInt("idCompra"), rs.getInt("idProducto"), rs.getDouble("Cantidad"), rs.getString("fecha"), rs.getInt("IdProveedor")));
            }

            return list;
        } catch (SQLException e) {
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, "[TABLA departamento] Error al buscar por ID");
        } finally {
            JDBCConnection.cerrar(stmt);
        }
        return null;
    }
    
    public List<Compra> getAllFilter(String s) throws BusinessException {
        List<Compra> list = new ArrayList<Compra>();
        try {
            con = JDBCConnection.getConnection();
            stmt = con.createStatement();
            String sql = "select compras.idCompra, compras.idProducto, compras.Cantidad, compras.fecha, compras.idProveedor from compras, productos where productos.idProducto like compras.idProducto and productos.Nombre like \"%"+s+"%\"";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                list.add(new Compra(rs.getInt("idCompra"), rs.getInt("idProducto"), rs.getDouble("Cantidad"), rs.getString("fecha"), rs.getInt("IdProveedor")));
            }

            return list;
        } catch (SQLException e) {
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, "[TABLA departamento] Error al buscar por ID");
        } finally {
            JDBCConnection.cerrar(stmt);
        }
        return null;
    }

}
