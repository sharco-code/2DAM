package DAO;

import Controller.JDBCConnection;
import Exceptions.BusinessException;
import Model.Proveedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ProveedorDAO {

    private Connection con = null;
    private PreparedStatement pstmt = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    /**
    * Persiste el objeto dado.
    * Tras la inseción el objeto tendrá actualizado su identificador. 
    * @param proveedor Objeto a insertar.
    * @throws BussinessException si el objeto ya existia
    */
    public void insert(Proveedor proveedor) throws BusinessException {
        if(proveedor.getCIF()== null &&
            proveedor.getCp()== null &&
            proveedor.getDir()== null &&
            proveedor.getNombre()== null &&
            proveedor.getPob()== null &&
            proveedor.getProv()== null &&
            proveedor.getTel()== null) throw new BusinessException("ninguna columna puede ser null");
        
        try {
            con = JDBCConnection.getConnection();
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("select * from proveedor");
            
            rs.moveToInsertRow();
            rs.updateString("Nombre", proveedor.getNombre());
            rs.updateString("Dir", proveedor.getDir());
            rs.updateString("Pob", proveedor.getPob());
            rs.updateString("cp", proveedor.getCp());
            rs.updateString("CIF", proveedor.getCIF());
            rs.updateString("Prov", proveedor.getProv());
            rs.updateString("Tel", proveedor.getTel());
            
            rs.insertRow();
            
        } catch (SQLException e) {
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, "[insertar proveedor] Error al insertar", e);
        } finally {
            JDBCConnection.cerrar(stmt);
        }
    }
    
    /**
    * Actualiza los datos persistidos de un objeto ya existente en la BD con los datos 
    * contenidos en el pojo.
    * @param proveedor Objeto del que se toman los datos.
    * @throws BusinessException si el objeto no existe.
    */
    public void update(Proveedor proveedor) throws BusinessException {
        try {
            con = JDBCConnection.getConnection();
            pstmt = con.prepareStatement("select * from proveedor where idProveedor like ?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pstmt.setInt(1, proveedor.getIdProveedor());
            rs = pstmt.executeQuery();
            
            if(rs.next()) {
                rs.updateString("Nombre", proveedor.getNombre());
                rs.updateString("Dir", proveedor.getDir());
                rs.updateString("Pob", proveedor.getPob());
                rs.updateString("cp", proveedor.getCp());
                rs.updateString("CIF", proveedor.getCIF());
                rs.updateString("Prov", proveedor.getProv());
                rs.updateString("Tel", proveedor.getTel());
                rs.updateRow();
            }

        } catch (SQLException e) {
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, "[actualizar proveedor] Error al insertar", e);
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
        if(id == null) throw new BusinessException("[borrar proveedor] el id no puede ser null");
        try {
            con = JDBCConnection.getConnection();
            pstmt = con.prepareStatement("select * from proveedor where idProveedor like ?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            
            if(rs.next()) {
                rs.deleteRow();
            }

        } catch (SQLException e) {
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, "[actualizar proveedor] Error al borrar", e);
        } finally {
            JDBCConnection.cerrar(stmt);
        }
    }
    /**
    * Devuelve una lista con todos los objetos de la base de datos
    * @return lista con todos los objetos o una null si no hay ninguno
    */
    public List<Proveedor> getAll() throws BusinessException {
        List<Proveedor> list = new ArrayList<Proveedor>();
        try {
            con = JDBCConnection.getConnection();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from proveedor");

            while (rs.next()) {
                list.add(new Proveedor(rs.getInt("idProveedor"), 
                        rs.getString("Nombre"),
                        rs.getString("Dir"), 
                        rs.getString("Pob"),
                        rs.getString("cp"),
                        rs.getString("CIF"),
                        rs.getString("Prov"),
                        rs.getString("Tel")));
            }

            return list;
        } catch (SQLException e) {
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, "[TABLA departamento] Error al buscar por ID");
        } finally {
            JDBCConnection.cerrar(stmt);
        }
        return null;
    }
    
    public List<Proveedor> getAllFilter(String s) throws BusinessException {
        List<Proveedor> list = new ArrayList<Proveedor>();
        try {
            con = JDBCConnection.getConnection();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from proveedor where Nombre like \"%"+s+"%\"");

            while (rs.next()) {
                list.add(new Proveedor(rs.getInt("idProveedor"), 
                        rs.getString("Nombre"),
                        rs.getString("Dir"), 
                        rs.getString("Pob"),
                        rs.getString("cp"),
                        rs.getString("CIF"),
                        rs.getString("Prov"),
                        rs.getString("Tel")));
            }

            return list;
        } catch (SQLException e) {
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, "[TABLA departamento] Error al buscar por ID");
        } finally {
            JDBCConnection.cerrar(stmt);
        }
        return null;
    }
    
    /**
    * Devuelve el objeto cuyo id se indica-
    * @param id identificador del objeto buscado
    * @return el objeto buscado o null si no existe
    */
    public Proveedor searchById(Integer id) throws BusinessException {
        if(id == null) throw new BusinessException("[borrar proveedor] el id no puede ser null");
        try {
            con = JDBCConnection.getConnection();
            pstmt = con.prepareStatement("select * from proveedor where idProveedor like ?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            
            if(rs.next()) {
                return new Proveedor(rs.getInt("idProveedor"), 
                        rs.getString("Nombre"),
                        rs.getString("Dir"), 
                        rs.getString("Pob"),
                        rs.getString("cp"),
                        rs.getString("CIF"),
                        rs.getString("Prov"),
                        rs.getString("Tel"));
            }

        } catch (SQLException e) {
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, "[actualizar proveedor] Error al borrar", e);
        } finally {
            JDBCConnection.cerrar(stmt);
        }
        return null;
    }
}
