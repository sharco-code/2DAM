/*
 Jose Galán Simó
 2 - DAM
 */
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

    public ProductoDAO() {

    }

    public Producto getProducto(Integer id) throws BusinessException {
        try {
            if (id == null) {
                throw new BusinessException("[getProducto] El id no puede ser null");
            }
            con = JDBCConnection.getConnection();

            pstmt = con.prepareStatement("select * from productos where idProducto like ?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                Producto p = new Producto(rs.getInt("idProducto"), rs.getString("Nombre"), rs.getString("Foto"), rs.getDouble("PVP"), rs.getDouble("Coste"), rs.getString("DeCocina"), rs.getString("EsMenu"), rs.getString("EsPlantilla"), rs.getInt("idProducto"));
                return p;
            }

        } catch (SQLException e) {
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, "[getProducto] Error al buscar por ID");
        } finally {
            JDBCConnection.cerrar(pstmt);
        }
        return null;
    }

    public void addProducto(Producto producto) throws BusinessException {
        try {
            if (producto.getNombre() == null) {
                throw new BusinessException("[addProducto] Nombre de la productos no puede ser nulo");
            }
            con = JDBCConnection.getConnection();
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("select * from productos");
            rs.moveToInsertRow();
            rs.updateString("Nombre", producto.getNombre());
            rs.updateString("Foto", producto.getFoto());
            rs.updateDouble("PVP", producto.getPVP());
            rs.updateDouble("Coste", producto.getCoste());
            rs.updateInt("ver", producto.getVer());
            rs.updateString("DeCocina", producto.getDeCocina());
            rs.updateString("EsMenu", producto.getEsMenu());
            rs.updateString("EsPlantilla", producto.getEsPlantilla());
            rs.updateInt("idFamilia", producto.getIdFamilia());
            rs.insertRow();
        } catch (SQLException e) {
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, "[addProducto] Error al grabar fila", e);
        } finally {
            JDBCConnection.cerrar(stmt);
        }
    }

    public Integer isNombre(String nombre) {
        try {
            con = JDBCConnection.getConnection();

            pstmt = con.prepareStatement("select * from productos where Nombre like ?");
            pstmt.setString(1, nombre);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (SQLException e) {
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, "[TABLA departamento] Error al buscar el nombre");
        } finally {
            JDBCConnection.cerrar(pstmt);
        }
        return null;
    }

    public void modifyProducto(Producto producto) throws BusinessException {
        try {
            if (producto.getNombre() == null) {
                throw new BusinessException("[modifyProducto] Nombre de la producto no puede ser nulo");
            }
            if (producto.getIdProducto() == null) {
                throw new BusinessException("[modifyProducto] ID de la producto no puede ser nulo");
            }
            con = JDBCConnection.getConnection();
            pstmt = con.prepareStatement("select * from productos where idProducto like ?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pstmt.setInt(1, producto.getIdProducto());
            rs = pstmt.executeQuery();
            if (rs.next()) {
                rs.updateString("Nombre", producto.getNombre());
                rs.updateString("Foto", producto.getFoto());
                rs.updateDouble("PVP", producto.getPVP());
                rs.updateDouble("Coste", producto.getCoste());
                rs.updateInt("ver", producto.getVer());
                rs.updateString("DeCocina", producto.getDeCocina());
                rs.updateString("EsMenu", producto.getEsMenu());
                rs.updateString("EsPlantilla", producto.getEsPlantilla());
                rs.updateInt("idFamilia", producto.getIdFamilia());
                rs.updateRow();
                return;
            }
        } catch (SQLException e) {
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, "[addProducto] Error al modificar fila", e);
        } finally {
            JDBCConnection.cerrar(stmt);
        }
    }

    public void deleteProducto(Producto producto) throws BusinessException {
        try {
            con = JDBCConnection.getConnection();

            if (producto.getIdProducto() != null) {
                pstmt = con.prepareStatement("select * from productos where idProducto like ?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                pstmt.setInt(1, producto.getIdProducto());
                rs = pstmt.executeQuery();
                if (rs.next()) {
                    rs.deleteRow();
                    return;
                }
                throw new BusinessException("[deleteProducto] No se encontro el id");
            }
            throw new BusinessException("[deleteProducto] El id no puede ser null");
        } catch (SQLException e) {
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, "[deleteProducto] Error al borrar fila", e);
        } finally {
            JDBCConnection.cerrar(stmt);
        }
    }

    public void deleteProducto(Integer id) throws BusinessException {
        try {
            con = JDBCConnection.getConnection();

            if (id != null) {
                pstmt = con.prepareStatement("select * from productos where idProducto like ?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                pstmt.setInt(1, id);
                rs = pstmt.executeQuery();
                if (rs.next()) {
                    rs.deleteRow();
                    return;
                }
                throw new BusinessException("[deleteProducto] No se encontro el id");
            }
            throw new BusinessException("[deleteProducto] El id no puede ser null");
        } catch (SQLException e) {
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, "[deleteProducto] Error al borrar fila", e);
        } finally {
            JDBCConnection.cerrar(stmt);
        }
    }

    public List<Producto> getAllfromFamily(Integer id) throws BusinessException {
        List<Producto> list = new ArrayList<Producto>();
        try {
            con = JDBCConnection.getConnection();
            if (id != null) {
                pstmt = con.prepareStatement("select * from productos where idFamilia like ?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                pstmt.setInt(1, id);
                rs = pstmt.executeQuery();

                while (rs.next()) {
                    list.add(new Producto(rs.getInt("idProducto"), rs.getString("Nombre"), rs.getString("Foto"), rs.getDouble("PVP"), rs.getDouble("Coste"), rs.getString("DeCocina"), rs.getString("EsMenu"), rs.getString("EsPlantilla"), rs.getInt("idProducto")));
                }

                return list;
            }
        } catch (SQLException e) {
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, "[getAllfromFamily] Error al buscar por ID");
        } finally {
            JDBCConnection.cerrar(stmt);
        }
        return null;
    }

    public List<Producto> getAll() throws BusinessException {
        List<Producto> list = new ArrayList<Producto>();
        try {
            con = JDBCConnection.getConnection();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from productos");

            while (rs.next()) {
                list.add(new Producto(rs.getInt("idProducto"), rs.getString("Nombre"), rs.getString("Foto"), rs.getDouble("PVP"), rs.getDouble("Coste"), rs.getString("DeCocina"), rs.getString("EsMenu"), rs.getString("EsPlantilla"), rs.getInt("idProducto")));
            }

            return list;
        } catch (SQLException e) {
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, "[getAll] Error al buscar por ID");
        } finally {
            JDBCConnection.cerrar(stmt);
        }
        return null;
    }
}
