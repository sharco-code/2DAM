package examen.ud1.josegalansimo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

public class Ejercicio1 {

	private static Connection con = null;
	private static Scanner scanner = new Scanner(System.in);
	private static Statement stmt = null;
	
	public static void main(String[] args) {
		System.out.println("EJERCICIO 1");
		try {
			Properties propiedades = new Properties();
			propiedades.load(new FileInputStream("propiedades\\propiedades.txt"));
			BasicDataSource ds = new BasicDataSourceFactory().createDataSource(propiedades);
			
			con = ds.getConnection();
			System.out.println("- Conectado");
			
			DatabaseMetaData dbmd = con.getMetaData();
			
			System.out.println("\nPunto 1:");
			
				System.out.println("\ta. -");
				System.out.println("\t   - Nombre driver: "+dbmd.getDriverName());
				System.out.println("\t   - Version driver: "+dbmd.getDriverVersion());
				
	
				System.out.println("\tb. -");
				System.out.println("\t   - SGBD: "+dbmd.getDatabaseProductName());
				System.out.println("\t   - Usuario: "+dbmd.getUserName());
				
				System.out.println("\tc. -");
				System.out.print("\t   - Nombre de las tablas de jardineria: ");
				ResultSet rs = dbmd.getTables(null, null, null, new String[] {"TABLE", "SYSTEM_TABLE"});
				while(rs.next()) {
					System.out.print(rs.getString("TABLE_NAME"));
					if(!rs.isLast()) System.out.print(", ");
				}
				/*
				System.out.println("\td. -");
				System.out.println("\t   - Nombre y tipo de las columnas que nos indique el usuario - ");
				System.out.print("\td. - Introduce nombre de tabla:");
				String user_input = scanner.nextLine();
				stmt = con.createStatement();
				stmt.executeUpdate("SELECT * FROM "+user_input);
				
				stmt.close();
				*/

			System.out.println("\nPunto 2:");
			
				stmt = con.createStatement();
				stmt.executeQuery("select * from aaaa");
			
			System.out.println();
		} catch (SQLException e) {
			if(e.getErrorCode() == 1146) System.out.println("\tError, la tabla no existe\n\t"+e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(con!=null && !con.isClosed()) {
					con.close();
					System.out.println("- Desconetado");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
