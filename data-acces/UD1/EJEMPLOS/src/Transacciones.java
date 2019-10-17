import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

public class Transacciones {

	private static Scanner scanner = new Scanner(System.in);
	
	private static Connection con;
	private static PreparedStatement pstmt = null;
	
	private static boolean isNumeric(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException excepcion) {
            return false;
        }
    }
	
	private static String promptInt(String msg, int size) {
		String x;
		do {
			System.out.print(msg);
			x = scanner.next();
		}while(!isNumeric(x) || x.length() > size|| Integer.parseInt(x) < 1);
		return x;
	}
	private static String promptStr(String msg, int size) {
		String x;
		do {
			System.out.print(msg);
			x = scanner.next();
		}while(x.length() > size);
		return x;
	}
	
	public static void main(String[] args) {

		//introducire etapa
		//introduicir 2 filas en llevar
		
		try {
			Properties propiedades = new Properties();
			propiedades.load(new FileInputStream("configuracion\\PropiedadesCiclismo"));
			
			BasicDataSource ds = BasicDataSourceFactory.createDataSource(propiedades);
			con = ds.getConnection();
			System.out.println("[LOG] Conxion realiazda");
			
			con.setAutoCommit(false);
			
			System.out.println("-------------Tabla Etapa---------------------------");
			
			pstmt = con.prepareStatement("INSERT INTO etapa VALUES (?, ?, ?, ?, ?); ");
			
			pstmt.setString(1, promptInt("Numero etapa: ", 5));
			pstmt.setString(2, promptInt("Km: ", 5));
			pstmt.setString(3, promptStr("Salida: ", 35));
			pstmt.setString(4, promptStr("llegada: ", 35));
			pstmt.setString(5, promptInt("Dorsal: ", 5));
			
			pstmt.execute();
			
			System.out.println("-------------Tabla LLevar---------------------------");
			System.out.println("--- Numero 1:");
			
			pstmt = con.prepareStatement("INSERT INTO llevar VALUES (?, ?, 'MGE')");
			pstmt.setString(1, promptInt("Dorsal (General): ", 5));
			pstmt.setString(2, promptInt("Numero etapa: ", 5));
			
			pstmt.execute();
			
			System.out.println("--- Numero 2:");
			
			pstmt = con.prepareStatement("INSERT INTO llevar VALUES (?, ?, 'MMO')");
			pstmt.setString(1, promptInt("Dorsal (Montaña): ", 5));
			pstmt.setString(2, promptInt("Numero etapa: ", 5));
			
			pstmt.execute();
			
			con.commit();
			System.out.println("[LOG] transaccion realiazda");
		} catch (Exception e) {
			e.printStackTrace();
			try {
				System.out.println("[ERROR] Rollback");
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				if(pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
					System.out.println("[LOG] stmt cerrado");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
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
