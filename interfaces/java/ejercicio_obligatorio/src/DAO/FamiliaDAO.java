package DAO;

import Controller.JDBCConnection;
import Exceptions.BusinessException;
import Model.Familia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FamiliaDAO {

    private Connection con = null;
    private PreparedStatement pstmt = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    public FamiliaDAO() {

    }

    public Familia getFamilia(Integer id) throws BusinessException {
        try {
            if (id == null) {
                throw new BusinessException("[getFamilia] El id no puede ser null");
            }
            con = JDBCConnection.getConnection();

            pstmt = con.prepareStatement("select * from familiasproductos where idFamilia like ?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new Familia(rs.getInt("idFamilia"), rs.getString("Familia"), rs.getString("Foto"), rs.getInt("ver"), rs.getString("EsMenu").charAt(0));
            }

        } catch (SQLException e) {
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, "[getFamilia] Error al buscar por ID");
        } finally {
            JDBCConnection.cerrar(pstmt);
        }
        return null;
    }

    public void addFamilia(Familia familia) throws BusinessException {
        try {
            if (familia.getFamilia() == null) {
                throw new BusinessException("[addFamilia] Nombre de la familia no puede ser nulo");
            }
            con = JDBCConnection.getConnection();
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("select * from familiasproductos");
            rs.moveToInsertRow();
            rs.updateString("Familia", familia.getFamilia());
            rs.updateString("Foto", familia.getFoto());
            rs.updateString("EsMenu", familia.getEsMenu().toString());
            rs.updateInt("ver", familia.getVer());
            rs.insertRow();
        } catch (SQLException e) {
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, "[addFamilia] Error al grabar fila", e);
        } finally {
            JDBCConnection.cerrar(stmt);
        }
    }

    public void modifyFamilia(Familia familia) throws BusinessException {
        try {
            if (familia.getFamilia() == null) {
                throw new BusinessException("[modifyFamilia] Nombre de la familia no puede ser nulo");
            }
            if (familia.getIdFamilia() == null) {
                throw new BusinessException("[modifyFamilia] ID de la familia no puede ser nulo");
            }
            con = JDBCConnection.getConnection();
            pstmt = con.prepareStatement("select * from familiasproductos where idFamilia like ?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pstmt.setInt(1, familia.getIdFamilia());
            rs = pstmt.executeQuery();
            if (rs.next()) {
                rs.updateString("Familia", familia.getFamilia());
                rs.updateString("Foto", familia.getFoto());
                rs.updateString("EsMenu", familia.getEsMenu().toString());
                rs.updateInt("ver", familia.getVer());
                rs.updateRow();
                return;
            }
        } catch (SQLException e) {
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, "[addFamilia] Error al grabar fila", e);
        } finally {
            JDBCConnection.cerrar(stmt);
        }
    }

    public void deleteFamilia(Familia familia) throws BusinessException {
        try {
            con = JDBCConnection.getConnection();

            if (familia.getIdFamilia() != null) {
                pstmt = con.prepareStatement("select * from familiasproductos where idFamilia like ?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                pstmt.setInt(1, familia.getIdFamilia());
                rs = pstmt.executeQuery();
                if (rs.next()) {
                    rs.deleteRow();
                    return;
                }
                throw new BusinessException("[deleteFamilia] No se encontro el id");
            }
            throw new BusinessException("[deleteFamilia] El id no puede ser null");
        } catch (SQLException e) {
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, "[deleteFamilia] Error al borrar fila", e);
        } finally {
            JDBCConnection.cerrar(stmt);
        }
    }

    public void deleteFamilia(Integer id) throws BusinessException {
        try {
            con = JDBCConnection.getConnection();

            if (id != null) {
                pstmt = con.prepareStatement("select * from familiasproductos where idFamilia like ?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                pstmt.setInt(1, id);
                rs = pstmt.executeQuery();
                if (rs.next()) {
                    rs.deleteRow();
                    return;
                }
                throw new BusinessException("[deleteFamilia] No se encontro el id");
            }
            throw new BusinessException("[deleteFamilia] El id no puede ser null");
        } catch (SQLException e) {
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, "[deleteFamilia] Error al borrar fila", e);
        } finally {
            JDBCConnection.cerrar(stmt);
        }
    }

    public List<Familia> getAll() throws BusinessException {
        List<Familia> list = new ArrayList<Familia>();
        try {
            con = JDBCConnection.getConnection();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from familiasproductos");

            while (rs.next()) {
                list.add(new Familia(rs.getInt("idFamilia"), rs.getString("Familia"), rs.getString("Foto"), rs.getInt("ver"), rs.getString("EsMenu").charAt(0)));
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
