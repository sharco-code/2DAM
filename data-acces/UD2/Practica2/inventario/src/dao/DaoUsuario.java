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
import pojos.Usuario;

public class DaoUsuario extends DaoGenerico<Usuario, Integer> implements InterfaceDaoGenerico<Usuario, Integer> {

	private Connection con = null;
	private PreparedStatement pstmt = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	
	private DaoDepartamento daoDepartamento;
	private DaoGrupo daoGrupo;
	
	public DaoUsuario(DaoDepartamento daoDepartamento, DaoGrupo daoGrupo) {
		this.daoDepartamento = daoDepartamento;
		this.daoGrupo = daoGrupo;
	}
	
	public boolean validar(String username, String password) {
		try {
			con = ConexionJdbc.getConnection();

			pstmt = con.prepareStatement("select * from usuario where username like ? AND password like ?");
			pstmt.setString(1, username);
			pstmt.setString(2, password);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next())
				return true;

		} catch (Exception e) {
			Logger.getLogger(ConexionJdbc.class.getName()).log(Level.SEVERE,
					"[TABLA usuario] Error al buscar el nombre");
		} finally {
			ConexionJdbc.cerrar(pstmt);
		}
		return false;
	}
	
	/**
	 * Este metodo está para comprobar si 'username' ya esta en la base de datos, ya
	 * que es UNIQUE y no se puede repetir
	 * 
	 * @param username a comprobar
	 * @return devuelve el id si SI ESTÁ EN LA BASE DE DATOS, devuelve null si NO
	 *         ESTÁ
	 */
	private Integer isUsername(String username) {
		try {
			con = ConexionJdbc.getConnection();

			pstmt = con.prepareStatement("select * from usuario where username like ?");
			pstmt.setString(1, username);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next())
				return rs.getInt(1);

		} catch (Exception e) {
			Logger.getLogger(ConexionJdbc.class.getName()).log(Level.SEVERE,
					"[TABLA usuario] Error al buscar el nombre");
		} finally {
			ConexionJdbc.cerrar(pstmt);
		}
		return null;
	}

	/**
	 * Persiste el objeto dado. Tras la inseción el objeto tendrá actualizado su
	 * identificador.
	 * 
	 * @param objeto Objeto a insertar.
	 * @throws BussinessException si el objeto ya existia
	 */
	@Override
	public void grabar(Usuario objeto) throws BusinessException {
		//not null: username, password, tipo, rolñ
		//unique:username, idusuario
		try {
			con = ConexionJdbc.getConnection();
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = stmt.executeQuery("select * from usuario");
			
			//Comprobaciones de tipo profesor '1'
			if(objeto.getTipo() == 1 && objeto.getGrupo() != null) throw new BusinessException("[TABLA usuario] Un profesor no pouede tener relacion con un grupo");
			if(objeto.getTipo() == 1 && objeto.getDepartamento() == null) throw new BusinessException("[TABLA usuario] Un profesor tiene que estar en un departamento");
			if(objeto.getTipo() == 1 && daoDepartamento.buscarPorId(objeto.getDepartamento()) == null) throw new BusinessException("[TABLA usuario] Departamento no existe");
			
			//comprobaciones de tipo alumno '2'
			if(objeto.getTipo() == 2 && objeto.getGrupo() == null) throw new BusinessException("[TABLA usuario] Un alumno debe estar en un grupo");
			if(objeto.getTipo() == 2 && objeto.getDepartamento() != null) throw new BusinessException("[TABLA usuario] Un profesor no tiene que estar en ninun departamento");
			if(objeto.getTipo() == 2 && daoGrupo.buscarPorId(objeto.getGrupo()) == null) throw new BusinessException("[TABLA usuario] Grupo no existe");
			
			//comprobaciones de tipo alumno '3'
			if(objeto.getTipo() == 3 && objeto.getGrupo() != null) throw new BusinessException("[TABLA usuario] Un pass no tiene que estar en ningun grupo");
			if(objeto.getTipo() == 3 && objeto.getDepartamento() != null) throw new BusinessException("[TABLA usuario] Un pass no tiene que estar en ningun departamento");
			
			
					if (objeto.getNombre() != null) {
						if (isUsername(objeto.getNombre()) == null) {
							rs.moveToInsertRow();
							rs.updateInt("tipo", objeto.getTipo());
							rs.updateInt("rol", objeto.getRol());
							rs.updateInt("departamento", objeto.getDepartamento());
							rs.updateString("username", objeto.getUsername());
							rs.updateString("password", objeto.getPassword());
							rs.updateString("grupo", objeto.getGrupo());
							rs.updateString("nombre", objeto.getNombre());
							rs.updateString("apellido1", objeto.getApellido1());
							rs.updateString("apellido2", objeto.getApellido2());
							rs.updateString("domicilio", objeto.getDomicilio());
							rs.updateString("poblacion", objeto.getPoblacion());
							rs.updateString("codpostal", objeto.getCodpostal());
							rs.updateString("email", objeto.getEmail());
							rs.updateString("telefono", objeto.getTelefono());
							if (objeto.getIdusuario() == null) {
								rs.insertRow();
								objeto.setIdusuario(isUsername(objeto.getNombre()));
								return;
							} else if (buscarPorId(objeto.getIdusuario()) == null) {
								rs.updateInt("idusuario", objeto.getIdusuario());
								rs.insertRow();
								return;
							}
						} else
							throw new BusinessException("[TABLA usuario] Valor de la columna 'username' ya esta en la base de datos");
					} else
						throw new BusinessException("[TABLA usuario] Valor de la columna 'username' no puede ser null");

		} catch (SQLException e) {
			Logger.getLogger(ConexionJdbc.class.getName()).log(Level.SEVERE, "[Error] al grabar departamento", e);
			System.out.println("[Error] al grabar departamento");
		} finally {
			ConexionJdbc.cerrar(stmt);
		}
		super.grabar(objeto);
	}

	/**
	 * Actualiza los datos persistidos de un objeto ya existente en la BD con los
	 * datos contenidos en el pojo.
	 * 
	 * @param objeto Objeto del que se toman los datos.
	 * @throws BusinessException si el objeto no existe.
	 */
	@Override
	public void actualizar(Usuario objeto) throws BusinessException {
		try {
			con = ConexionJdbc.getConnection();
			
			//Comprobaciones de tipo profesor '1'
			if(objeto.getTipo() == 1 && objeto.getGrupo() != null) throw new BusinessException("[TABLA usuario] Un profesor no pouede tener relacion con un grupo");
			if(objeto.getTipo() == 1 && objeto.getDepartamento() == null) throw new BusinessException("[TABLA usuario] Un profesor tiene que estar en un departamento");
			if(objeto.getTipo() == 1 && daoDepartamento.buscarPorId(objeto.getDepartamento()) == null) throw new BusinessException("[TABLA usuario] Departamento no existe");
			
			//comprobaciones de tipo alumno '2'
			if(objeto.getTipo() == 2 && objeto.getGrupo() == null) throw new BusinessException("[TABLA usuario] Un alumno debe estar en un grupo");
			if(objeto.getTipo() == 2 && objeto.getDepartamento() != null) throw new BusinessException("[TABLA usuario] Un profesor no tiene que estar en ninun departamento");
			if(objeto.getTipo() == 2 && daoGrupo.buscarPorId(objeto.getGrupo()) == null) throw new BusinessException("[TABLA usuario] Grupo no existe");
			
			//comprobaciones de tipo alumno '3'
			if(objeto.getTipo() == 3 && objeto.getGrupo() != null) throw new BusinessException("[TABLA usuario] Un pass no tiene que estar en ningun grupo");
			if(objeto.getTipo() == 3 && objeto.getDepartamento() != null) throw new BusinessException("[TABLA usuario] Un pass no tiene que estar en ningun departamento");
			
			if (objeto.getUsername() != null) {
				if (isUsername(objeto.getUsername()) == null) {
					if (objeto.getIdusuario() != null) {
						pstmt = con.prepareStatement("select * from usuario where idusuario like ?",
								ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
						pstmt.setInt(1, objeto.getIdusuario());
						rs = pstmt.executeQuery();

						if (rs.next()) {

							rs.updateInt("idusuario", objeto.getIdusuario());
							rs.updateInt("tipo", objeto.getTipo());
							rs.updateInt("rol", objeto.getRol());
							rs.updateInt("departamento", objeto.getDepartamento());
							rs.updateString("username", objeto.getUsername());
							rs.updateString("password", objeto.getPassword());
							rs.updateString("grupo", objeto.getGrupo());
							rs.updateString("nombre", objeto.getNombre());
							rs.updateString("apellido1", objeto.getApellido1());
							rs.updateString("apellido2", objeto.getApellido2());
							rs.updateString("domicilio", objeto.getDomicilio());
							rs.updateString("poblacion", objeto.getPoblacion());
							rs.updateString("codpostal", objeto.getCodpostal());
							rs.updateString("email", objeto.getEmail());
							rs.updateString("telefono", objeto.getTelefono());

							rs.updateRow();
							return;
						}
						throw new BusinessException("[TABLA usuario] No se encontro el id");
					}
					throw new BusinessException("[TABLA usuario] Valor de la columna 'idusuario' no puede ser null");
				} else
					throw new BusinessException("[TABLA usuario] Valor de la columna 'username' ya esta en la base de datos");
			} else
				throw new BusinessException("[TABLA usuario] Valor de la columna 'username' no puede ser null");

		} catch (SQLException e) {
			Logger.getLogger(ConexionJdbc.class.getName()).log(Level.SEVERE, "[TABLA usuario] Erroral actualizar fila",
					e);
			System.out.println("[TABLA usuario] Error al actualizar fila");
		} finally {
			ConexionJdbc.cerrar(pstmt);
		}
		super.actualizar(objeto);
	}

	/**
	 * Graba o actualiza el objeto según convenga: Si existe lo actualiza y si no
	 * existe lo graba.
	 * 
	 * @param objeto Objeto del que se toman los datos
	 * @throws BusinessException
	 */
	@Override
	public void grabarOActualizar(Usuario objeto) throws BusinessException {
			if (objeto.getIdusuario() == null || buscarPorId(objeto.getIdusuario()) == null) {
				grabar(objeto);
			} else {
				actualizar(objeto);
			}
		super.grabarOActualizar(objeto);
	}

	/**
	 * Elimina el objeto indicado de la BD
	 * 
	 * @param objeto Objeto a eliminar
	 * @throws BusinessException si el objeto no existe o no se puede eliminar
	 */
	@Override
	public void borrar(Usuario objeto) throws BusinessException {
		try {
			con = ConexionJdbc.getConnection();

			if (objeto.getIdusuario() != null) {
				pstmt = con.prepareStatement("select * from usuario where idusuario like ?");
				pstmt.setInt(1, objeto.getIdusuario());

				if (rs.next()) {
					rs.deleteRow();
					return;
				}
				throw new BusinessException("[TABLA usuario] No se encontro el id");
			}
			throw new BusinessException("[TABLA usuario] El id no puede ser null");
		} catch (SQLException e) {
			Logger.getLogger(ConexionJdbc.class.getName()).log(Level.SEVERE, "[TABLA usuario] Error al borrar fila", e);
			System.out.println("[TABLA usuario] Error al borrar fila");
		} finally {
			ConexionJdbc.cerrar(stmt);
		}
		super.borrar(objeto);
	}

	/**
	 * Elimina el objeto indicado de la BD
	 * 
	 * @param id Identificador del objeto a eliminar
	 * @throws BusinessException si el objeto no existe o no se puede eliminar
	 */
	@Override
	public void borrar(Integer id) throws BusinessException {
		try {
			con = ConexionJdbc.getConnection();

			if (id != null) {
				pstmt = con.prepareStatement("select * from usuario where idusuario like ?");
				pstmt.setInt(1, id);

				if (rs.next()) {
					rs.deleteRow();
					return;
				}
				throw new BusinessException("[TABLA usuario] No se encontro el id");
			}
			throw new BusinessException("[TABLA usuario] El id no puede ser null");
		} catch (SQLException e) {
			Logger.getLogger(ConexionJdbc.class.getName()).log(Level.SEVERE, "[TABLA usuario] Error al borrar fila", e);
			System.out.println("[TABLA usuario] Error al borrar fila");
		} finally {
			ConexionJdbc.cerrar(stmt);
		}
		super.borrar(id);
	}

	/**
	 * Devuelve el objeto cuyo id se indica-
	 * 
	 * @param id identificador del objeto buscado
	 * @return el objeto buscado o null si no existe
	 */
	@Override
	public Usuario buscarPorId(Integer id) throws BusinessException {
		try {
			if(id == null) throw new BusinessException("[TABLA Usuario] El id no puede ser null");
			
			con = ConexionJdbc.getConnection();

			pstmt = con.prepareStatement("select * from usuario where idusuario like ?");
			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next())
				return new Usuario(rs.getInt("idusuario"), rs.getInt("tipo"), rs.getInt("rol"),
						rs.getInt("departamento"), rs.getString("username"), rs.getString("password"),
						rs.getString("grupo"), rs.getString("nombre"), rs.getString("apellido1"),
						rs.getString("apellido2"), rs.getString("domicilio"), rs.getString("poblacion"),
						rs.getString("codpostal"), rs.getString("email"), rs.getString("telefono"));
			else
				return null;

		} catch (Exception e) {
			Logger.getLogger(ConexionJdbc.class.getName()).log(Level.SEVERE, "[TABLA usuario] Error al buscar por ID");
		} finally {
			ConexionJdbc.cerrar(pstmt);
		}
		return super.buscarPorId(id);
	}

	/**
	 * Devuelve una lista con todos los objetos de la base de datos
	 * 
	 * @return lista con todos los objetos o una lista vacía si no hay ninguno.
	 */
	@Override
	public List<Usuario> buscarTodos() throws BusinessException {
		List<Usuario> list = new ArrayList<Usuario>();
		try {
			con = ConexionJdbc.getConnection();

			ResultSet rs = stmt.executeQuery("select * from usuario");

			while (rs.next()) {
				list.add(new Usuario(rs.getInt("idusuario"), rs.getInt("tipo"), rs.getInt("rol"),
						rs.getInt("departamento"), rs.getString("username"), rs.getString("password"),
						rs.getString("grupo"), rs.getString("nombre"), rs.getString("apellido1"),
						rs.getString("apellido2"), rs.getString("domicilio"), rs.getString("poblacion"),
						rs.getString("codpostal"), rs.getString("email"), rs.getString("telefono")));
			}

			return list;
		} catch (SQLException e) {
			Logger.getLogger(ConexionJdbc.class.getName()).log(Level.SEVERE, "[TABLA usuario] Error al buscar por ID");
		} finally {
			ConexionJdbc.cerrar(stmt);
		}
		return super.buscarTodos();
	}

}
