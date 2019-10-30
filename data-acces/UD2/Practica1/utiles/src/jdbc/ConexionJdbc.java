package jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

import excepciones.ConnectionException;

public class ConexionJdbc {
	private static Connection con;
	
	private String driver;
	private String url;
	private String usr;
	private String pwd;
	
	private String ficheroConfiguracion;
	
	public ConexionJdbc(String driver, String url, String usr, String pwd) {
		this.driver = driver;
		this.url = url;
		this.usr = usr;
		this.pwd = pwd;
	}
	
	public ConexionJdbc(String ficheroConfiguracion) {
		this.ficheroConfiguracion = ficheroConfiguracion;
	}
	
	private void conectar(String ficheroConfiguracion) throws ConnectionException, FileNotFoundException, IOException, Exception {
		Properties propiedades = new Properties();
		propiedades.load(new FileInputStream(ficheroConfiguracion));
		
		BasicDataSource ds = BasicDataSourceFactory.createDataSource(propiedades);
		con = ds.getConnection();

	}
	private void conectar(String driver, String url, String usr, String pwd) throws ConnectionException, SQLException {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(this.driver);
		ds.setUrl(this.url);
		ds.setUsername(this.usr);
		ds.setPassword(this.pwd);

		con = ds.getConnection();
	}
	
	public void conectar() {
		try {
			if(ficheroConfiguracion != null) conectar(ficheroConfiguracion);
			else conectar(driver, url, usr, pwd);
		} catch (ConnectionException e) {
			Logger.getLogger(ConexionJdbc.class.getName()) .log(Level.SEVERE, "[ERROR] al conectar", e);
		} catch (FileNotFoundException e) {
			Logger.getLogger(ConexionJdbc.class.getName()) .log(Level.SEVERE, "[ERROR] no se encuentra archivo ", e);
		} catch (IOException e) {
			Logger.getLogger(ConexionJdbc.class.getName()) .log(Level.SEVERE, "[ERROR] IO exception al establecer la conexion", e);
		} catch (Exception e) {
			Logger.getLogger(ConexionJdbc.class.getName()) .log(Level.SEVERE, "[ERROR] al establecer la conexion", e);
		}
		
	}
	
	public static Connection getConnection() {
		return con;
	}
	
	public void desconectar() {
		try {
			if(con != null && !con.isClosed()) con.close();
		} catch (SQLException e) {
			Logger.getLogger(ConexionJdbc.class.getName()) .log(Level.SEVERE, "[ERROR] al cerrar la conexión", e);
		}
		
	}
	
	public static void cerrar(ResultSet rs) {
		try {
			if(rs != null && !rs.isClosed()) rs.close();
		} catch (SQLException e) {
			Logger.getLogger(ConexionJdbc.class.getName()) .log(Level.SEVERE, "[ERROR] al cerrar ResultSet", e);
		}
		
	}
	
	public static void cerrar(Statement stmt) {
		try {
			if(stmt != null && !stmt.isClosed()) stmt.close();
		} catch (SQLException e) {
			Logger.getLogger(ConexionJdbc.class.getName()) .log(Level.SEVERE, "[ERROR] al cerrar Statement", e);
		}
		
	}
}
