package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import excepciones.BusinessException;
import jdbc.ConexionJdbc;
import pojos.TipoUsuario;

public class DaoTipoUsuario extends DaoGenerico<TipoUsuario, Integer> implements InterfaceDaoGenerico<TipoUsuario, Integer> {

	private Connection con = null;
	private PreparedStatement pstmt = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	
	final int PAS = 3;
	final int PROFESOR = 1;
	final int ALUMNO = 2;

	
	/**
	 * Devuelve el objeto cuyo id se indica-
	 * @param id identificador del objeto buscado
	 * @return el objeto buscado o null si no existe
	 */
	@Override
	public TipoUsuario buscarPorId(Integer id) throws BusinessException {
		try {
			if(id == null) throw new BusinessException("[TABLA TipoUsuario] El id no puede ser null");
			
			con = ConexionJdbc.getConnection();
			
			pstmt = con.prepareStatement("select * from tipousuario where idtipousuario like ?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) return new TipoUsuario(rs.getInt(1), rs.getString(2));
			else return null;
			
		} catch (SQLException e) {
			Logger.getLogger(ConexionJdbc.class.getName()) .log(Level.SEVERE, "[TABLA TipoUsuario] Error al buscar por ID");
		} finally {
			ConexionJdbc.cerrar(pstmt);
		}
		return super.buscarPorId(id);
	}

	/**
	 * Devuelve una lista con todos los objetos de la base de datos
	 * @return lista con todos los objetos o una lista vacía si no hay ninguno.
	 */
	@Override
	public List<TipoUsuario> buscarTodos() throws BusinessException {
		List<TipoUsuario> list = new ArrayList<TipoUsuario>();
		try {
			con = ConexionJdbc.getConnection();
			
			ResultSet rs = stmt.executeQuery("select * from tipousuario");
			
			while(rs.next()) {
				list.add(new TipoUsuario(rs.getInt(1), rs.getString(2)));
			}
			
			return list;
		} catch (SQLException e) {
			Logger.getLogger(ConexionJdbc.class.getName()) .log(Level.SEVERE, "[TABLA TipoUsuario] Error al buscar por ID");
		} finally {
			ConexionJdbc.cerrar(stmt);
		}
		return super.buscarTodos();
	}
	
}
  
