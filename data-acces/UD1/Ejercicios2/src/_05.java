import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

public class _05 {

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		try {
			
			Properties propiedades = new Properties();
			propiedades.load(new FileInputStream("configuracion\\PropiedadesCiclismo"));
			
			BasicDataSource ds = BasicDataSourceFactory.createDataSource(propiedades);
			con = ds.getConnection();
			System.out.println("[LOG] Conxion realiazda");

			
			stmt = con.createStatement();

			stmt.executeQuery("SELECT campoquenoexiste FROM ciclisa");
			
			System.out.println();
		} catch (SQLException e) {
			if(e.getErrorCode() == 1146) System.out.println("SQLException: "+e.getMessage());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt != null && !stmt.isClosed()) {
					stmt.close();
					System.out.println("[LOG] stmt cerrado");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(con!=null && !con.isClosed()) {
					con.close();
					System.out.println("[LOG] Desconetado");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		

	}

}
