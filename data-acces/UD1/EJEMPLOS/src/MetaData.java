import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;





public class MetaData {
	
	public static void infoProducto(DatabaseMetaData dbmd) throws SQLException {
		String producto = dbmd.getDatabaseProductName();
		String version = dbmd.getDatabaseProductVersion();
		String nombreUsr = dbmd.getUserName();
		String url = dbmd.getURL();
		
		System.out.println();
		System.out.println("---- INFORMACION SOBRE EL DBMS ------");
		System.out.println("producto: "+producto);
		System.out.println("version: "+version);
		System.out.println("nombreUsr: "+nombreUsr);
		System.out.println("url: "+url);
	}
	
	public static void infoDriver(DatabaseMetaData dbmd) throws SQLException {
		String driver = dbmd.getDriverName();
		String driverVersion = dbmd.getDriverVersion();
		
		System.out.println();
		System.out.println("---- INFORMACION SOBRE EL DRIVER ------");
		System.out.println("driver: "+driver);
		System.out.println("driverVersion: "+driverVersion);
	}
	
	public static void infoFunciones(DatabaseMetaData dbmd) throws SQLException {
		String funcionesCadenas = dbmd.getStringFunctions();
		String funcionesSistema = dbmd.getSystemFunctions();
		String funcionesTiempo = dbmd.getSystemFunctions();
		String funcionesNumericas = dbmd.getNumericFunctions();
		
		System.out.println();
		System.out.println("---- FUNCIONES QUE SOPORTA EL DBMS ------");
		System.out.println("funcionesCadenas: "+funcionesCadenas);
		System.out.println("funcionesSistema: "+funcionesSistema);
		System.out.println("funcionesTiempo: "+funcionesTiempo);
		System.out.println("funcionesNumericas:"+funcionesNumericas);
	}
	
	public static void infoTablas(DatabaseMetaData dbmd) throws SQLException {
		ResultSet rsTablas = dbmd.getTables(null, null, null, new String[]{"TABLE","SYSTEM_TABLE"});
		
		System.out.println();
		System.out.println("---- TABLAS ------");
		while (rsTablas.next()) {
			System.out.println(rsTablas.getString("TABLE_CAT"));
			System.out.println(rsTablas.getString("TABLE_SCHEM"));
			System.out.println(rsTablas.getString("TABLE_NAME"));
			System.out.println(rsTablas.getString("TABLE_TYPE"));
			System.out.println(rsTablas.getString("REMARKS"));
			System.out.println("--- ------");
		}
	}
	
	public static void infoProcedimientos(DatabaseMetaData dbmd) throws SQLException {
		ResultSet rsProced = dbmd.getProcedures(null, null, null);
		
		System.out.println();
		System.out.println("---- PROCEDIMIENTOS ------");
		while (rsProced.next()) {
			System.out.println(rsProced.getString("PROCEDURE_CAT"));
			System.out.println(rsProced.getString("PROCEDURE_SCHEM"));
			System.out.println(rsProced.getString("PROCEDURE_NAME"));
			System.out.println(rsProced.getString("PROCEDURE_TYPE"));
			System.out.println(rsProced.getString("REMARKS"));
			System.out.println("--- ------");
		}
	}
	
	public static void main(String[] args) {

		Connection con = null;
		
		try {
			Properties propiedades = new Properties();
			propiedades.load(new FileInputStream("configuracion\\PropiedadesCiclismo"));
			
			BasicDataSource ds = BasicDataSourceFactory.createDataSource(propiedades);
			con = ds.getConnection();
			
			System.out.println("Conexion realizada");
			
			DatabaseMetaData dbmd = con.getMetaData();
			
			infoProducto(dbmd);
			
			infoDriver(dbmd);
			
			infoFunciones(dbmd);
			
			infoTablas(dbmd);
			
			infoProcedimientos(dbmd);
				
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
