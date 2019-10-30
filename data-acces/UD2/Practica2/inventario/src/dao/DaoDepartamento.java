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
import pojos.Departamento;

public class DaoDepartamento extends DaoGenerico<Departamento, Integer> implements InterfaceDaoGenerico<Departamento, Integer> {

	private Connection con = null;
	private PreparedStatement pstmt = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	
	/**
	 * Este metodo está para comprobar si 'nombre' ya esta en la base de datos, ya que es UNIQUE y no se puede repetir
	 * @param nombre a comprobar
	 * @return devuelve el id si SI ESTÁ EN LA BASE DE DATOS, devuelve null si NO ESTÁ
	 */
	private Integer isNombre(String nombre) {
		try {
			con = ConexionJdbc.getConnection();
			
			pstmt = con.prepareStatement("select * from departamento where nombre like ?");
			pstmt.setString(1, nombre);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) return rs.getInt(1);
			
		} catch (SQLException e) {
			Logger.getLogger(ConexionJdbc.class.getName()) .log(Level.SEVERE, "[TABLA departamento] Error al buscar el nombre");
		} finally {
			ConexionJdbc.cerrar(pstmt);
		}
		return null;
	}
	
	/**
	 * Persiste el objeto dado.
	 * Tras la inseción el objeto tendrá actualizado su identificador. 
	 * @param objeto Objeto a insertar.
	 * @throws BussinessException si el objeto ya existia
	 */
	@Override
	public void grabar(Departamento objeto) throws BusinessException {
		
		
		try {
			con = ConexionJdbc.getConnection();
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = stmt.executeQuery("select * from departamento");
			if(objeto.getNombre() != null) {
					if(isNombre(objeto.getNombre()) == null) {
						if(objeto.getIddepartamento() == null) {
							
							rs.moveToInsertRow();
							rs.updateString(2, objeto.getNombre());
							rs.insertRow();
						
							objeto.setIddepartamento(isNombre(objeto.getNombre()));
							
						return;
					} else if(buscarPorId(objeto.getIddepartamento()) == null) {
						rs.moveToInsertRow();
						rs.updateInt(1, objeto.getIddepartamento());
						rs.updateString(2, objeto.getNombre());
						rs.insertRow();
						return;
					} 
				} else throw new BusinessException("[TABLA departamento] Valor de la columna 'nombre' ya esta en la base de datos");
			} else throw new BusinessException("[TABLA departamento] Valor de la columna 'nombre' no puede ser null");

		} catch (SQLException e) {
			Logger.getLogger(ConexionJdbc.class.getName()) .log(Level.SEVERE, "[TABLA departamento] Error al grabar fila", e);
		} finally {
			ConexionJdbc.cerrar(stmt);
		}
		super.grabar(objeto);
	}

	/**
	 * Actualiza los datos persistidos de un objeto ya existente en la BD con los datos 
	 * contenidos en el pojo.
	 * @param objeto Objeto del que se toman los datos.
	 * @throws BusinessException si el objeto no existe.
	 */
	@Override
	public void actualizar(Departamento objeto) throws BusinessException {
		try {
			con = ConexionJdbc.getConnection();
			if(objeto.getNombre() != null) {
				if(isNombre(objeto.getNombre()) == null) {
						if(objeto.getIddepartamento() != null) {
							pstmt = con.prepareStatement("select * from departamento where iddepartamento like ?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
								pstmt.setInt(1, objeto.getIddepartamento());
								rs = pstmt.executeQuery();
								
								if(rs.next()) {
									rs.updateString(2, objeto.getNombre());
									rs.updateRow();
									return;
								}
								throw new BusinessException("[TABLA departamento] No se encontro el id");
						}
						throw new BusinessException("[TABLA departamento] Valor de la columna 'iddepartamento' no puede ser null");
				} else throw new BusinessException("[TABLA departamento] Valor de la columna 'nombre' ya esta en la base de datos");
			} else throw new BusinessException("[TABLA departamento] Valor de la columna 'nombre' no puede ser null");
							
		} catch (SQLException e) {
			Logger.getLogger(ConexionJdbc.class.getName()) .log(Level.SEVERE, "[TABLA departamento] Error al actualizar fila",e);
		} finally {
			ConexionJdbc.cerrar(pstmt);
		}
		super.actualizar(objeto);
	}

	/**
	 * Graba o actualiza el objeto según convenga: Si existe lo actualiza y si 
	 * no existe lo graba.
	 * @param objeto Objeto del que se toman los datos
	 * @throws BusinessException
	 */
	@Override
	public void grabarOActualizar(Departamento objeto) throws BusinessException {
		if(objeto.getIddepartamento() == null || buscarPorId(objeto.getIddepartamento()) == null) {
			grabar(objeto);
		}
		else {
			actualizar(objeto);
		}
	}

	/**
	 * Elimina el objeto indicado de la BD
	 * @param objeto Objeto a eliminar 
	 * @throws BusinessException si el objeto no existe o no se puede eliminar
	 */
	@Override
	public void borrar(Departamento objeto) throws BusinessException {
		try {
			con = ConexionJdbc.getConnection();
			
			if(objeto.getIddepartamento() != null) {
					pstmt = con.prepareStatement("select * from departamento where iddepartamento like ?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
					pstmt.setInt(1, objeto.getIddepartamento());
					rs = pstmt.executeQuery();
					if(rs.next()) {
						rs.deleteRow();
						return;
					}
					throw new BusinessException("[TABLA departamento] No se encontro el id");
			}
			throw new BusinessException("[TABLA departamento] El id no puede ser null");
		} catch (SQLException e) {
			Logger.getLogger(ConexionJdbc.class.getName()) .log(Level.SEVERE, "[TABLA departamento] Error al borrar fila",e);
		} finally {
			ConexionJdbc.cerrar(stmt);
		}
		super.borrar(objeto);
	}

	/**
	 * Elimina el objeto indicado de la BD
	 * @param id Identificador del objeto a eliminar 
	 * @throws BusinessException si el objeto no existe o no se puede eliminar
	 */
	@Override
	public void borrar(Integer id) throws BusinessException {
		try {
			con = ConexionJdbc.getConnection();
			
			if(id != null) {
					pstmt = con.prepareStatement("select * from departamento where iddepartamento like ?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
					pstmt.setInt(1, id);
					rs = pstmt.executeQuery();
					if(rs.next()) {
						rs.deleteRow();
						return;
					}
					throw new BusinessException("[TABLA departamento] No se encontro el id");
			}
			throw new BusinessException("[TABLA departamento] El id no puede ser null");
		} catch (SQLException e) {
			Logger.getLogger(ConexionJdbc.class.getName()) .log(Level.SEVERE, "[TABLA departamento] Error al borrar fila",e);
		} finally {
			ConexionJdbc.cerrar(stmt);
		}
		super.borrar(id);
	}

	/**
	 * Devuelve el objeto cuyo id se indica-
	 * @param id identificador del objeto buscado
	 * @return el objeto buscado o null si no existe
	 */
	@Override
	public Departamento buscarPorId(Integer id) throws BusinessException {
		try {
			if(id == null) throw new BusinessException("[TABLA departamento] El id no puede ser null");
			con = ConexionJdbc.getConnection();
			
			pstmt = con.prepareStatement("select * from departamento where iddepartamento like ?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) return new Departamento(rs.getInt(1), rs.getString(2));
			else return null;
			
		} catch (SQLException e) {
			Logger.getLogger(ConexionJdbc.class.getName()) .log(Level.SEVERE, "[TABLA departamento] Error al buscar por ID");
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
	public List<Departamento> buscarTodos() throws BusinessException {
		List<Departamento> list = new ArrayList<Departamento>();
		try {
			con = ConexionJdbc.getConnection();
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from departamento");
			
			while(rs.next()) {
				list.add(new Departamento(rs.getInt(1), rs.getString(2)));
			}
			
			return list;
		} catch (SQLException e) {
			Logger.getLogger(ConexionJdbc.class.getName()) .log(Level.SEVERE, "[TABLA departamento] Error al buscar por ID");
		} finally {
			ConexionJdbc.cerrar(stmt);
		}
		return super.buscarTodos();
	}
	
}
  
