import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

public class _03 {
	
	public static void a(DatabaseMetaData dbmd) throws SQLException {
		System.out.println("\na. (Qué versión de driver tienes instalado)");

		System.out.println("Version de driver: "+dbmd.getDriverVersion());
	}
	
	public static void b(DatabaseMetaData dbmd) throws SQLException {
		System.out.println("\nb. (Qué sistema gestor de base de datos estás conectado)");

		System.out.println("Sistema gestor de base de datos: "+dbmd.getDatabaseProductName());
	}
	
	public static void c(DatabaseMetaData dbmd) throws SQLException {
		System.out.println("\nc. (Qué tablas y vistas tiene tu base de datos)");
		
		ResultSet rsTablas = dbmd.getTables(null, null, null, new String[]{"TABLE","SYSTEM_TABLE"});
		
		System.out.print("Tablas: ");
		while (rsTablas.next()) {
			System.out.print(rsTablas.getString("TABLE_NAME"));
			if(!rsTablas.isLast()) System.out.print(", ");
		}

	    ResultSet tables = dbmd.getTables(null, null, null, new String[]{"VIEW"});
	    System.out.print("\nVistas: ");
	    while (tables.next()) {
	      System.out.print(tables.getString("TABLE_NAME"));
	      if(!tables.isLast()) System.out.print(", ");
	    }
	    System.out.println();
	}
	
	public static void d(Connection c) throws SQLException {
		System.out.println("\nd. (¿Cuántas columnas tiene la tabla puerto?)");
		Statement stmt = c.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM puerto");
		ResultSetMetaData rsmd = rs.getMetaData();
		
		System.out.println("Numero columnas: "+rsmd.getColumnCount());
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
			
			a(dbmd);
			
			b(dbmd);
			
			c(dbmd);
			
			d(con);
				
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(con!=null && !con.isClosed()) {
					con.setAutoCommit(true);
					con.close();
					System.out.println("[LOG] Desconetado");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

}
