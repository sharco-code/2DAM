import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

public class consultasSimplesPreparedStatement {

private static Scanner scanner = new Scanner(System.in);
	
	private static Connection con;
	private static PreparedStatement pstmt = null;
	private static ResultSet rs = null;
	
	private static String sql;
	
	private static String prompt(String s, int i) throws Exception {
		String _x = scanner.next();
		System.out.print(s);
		if(_x.length()>i) {
			throw new Exception("No puede tener mas de "+i+" digitos");
		} else return _x;
	}
	
	public static void apartadoA(Connection con) throws Exception {
		
		String s1, s2, s3, s4 = "";
		
		try {
			System.out.println("\nAPARTADO a (Inserta los valores de un nuevo maillot que introduzca el usuario)\n");

			while(true) {
				System.out.print("Introduzca codigo: ");
				s1 = scanner.next();
				if(s1.length()<=3) break;
			}
			while(true) {
				System.out.print("Introduzca tipo: ");
				s2 = scanner.next();
				if(s1.length()<=30) break;
			}
			while(true) {
				System.out.print("Introduzca color: ");
				s3 = scanner.next();
				if(s1.length()<=20) break;
			}
			while(true) {
				try {
					System.out.print("Introduzca premio: ");
					s4 = scanner.next();
				} catch (Exception e) {}
				if(s4.length()<=10) break;
			}
			
			
			pstmt = con.prepareStatement("INSERT INTO maillot VALUES (?, ?, ?, ?); ");
			pstmt.setString(1, s1);
			pstmt.setString(2, s2);
			pstmt.setString(3, s3);
			pstmt.setString(4, s4);
			
			System.out.println("[LOG] Filas añadidas: " + pstmt.executeUpdate());
			
		} catch (Exception e) {
			throw new Exception("Error al insertar filas");
		} finally {
			try {
				if(pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
					System.out.println("[LOG] pstmt cerrado");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void apartadoB(Connection con) throws Exception {
		System.out.println("\nAPARTADO b (Consulta en primer lugar los ciclistas del equipo BANESTO de más de 30 años.)\n");
		try {

			sql = "SELECT * FROM ciclista WHERE nomeq LIKE ? && timestampdiff(YEAR, nacimiento, CURDATE()) > ?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, "BANESTO");
			pstmt.setInt(2, 30);
			
			rs = pstmt.executeQuery();
			rs.beforeFirst();
			System.out.println("EQUIPO\t- MAILLOT\t- NOMBRE\t- NACIMIENTO");
			System.out.println("----------------------------------------------------");
			while (rs.next()) {
				System.out.println(rs.getString(1)+"\t- "+rs.getString(2)+"   \t- "+rs.getString(3)+"   \t- "+rs.getDate(4));
			}
			
		} catch (Exception e) {
			throw new Exception("Error al ejecutar query");
		}
		pstmt.close();
	}
	
	public static void apartadoC(Connection con) throws Exception {
		System.out.println("\nAPARTADO c (Consulta en segundo lugar los ciclista del equipo ONCE de más de 35 años.)\n");
		try {

			sql = "SELECT *\r\n" + 
					"FROM ciclista NATURAL JOIN equipo\r\n" + 
					"WHERE equipo.nomeq LIKE ? &&\r\n" + 
					"timestampdiff(YEAR, nacimiento, CURDATE()) > ?;";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, "ONCE");
			pstmt.setInt(2, 35);
			
			rs = pstmt.executeQuery();
			rs.beforeFirst();
			System.out.println("EQUIPO\t- MAILLOT\t- NOMBRE\t- NACIMIENTO");
			System.out.println("----------------------------------------------------");
			while (rs.next()) {
				System.out.println(rs.getString(1)+"\t- "+rs.getString(2)+"   \t- "+rs.getString(3)+"   \t- "+rs.getDate(4));
			}
			
		} catch (Exception e) {
			throw new Exception("Error al ejecutar query");
		}
		pstmt.close();
	}
	
	public static void apartadoD(Connection con) throws Exception {
		
		try {
			System.out.println("\nAPARTADO d (Actualizar el premio del maillot AMARILLO en 100 €  )\n");
			
			pstmt = con.prepareStatement("UPDATE maillot\r\n" + 
					"SET maillot.premio = ?\r\n" + 
					"WHERE maillot.color LIKE ?; ");
			
			pstmt.setInt(1, 100);
			pstmt.setString(2, "AMARILLO");
			
			System.out.println("[LOG] Filas actualizadas: " + pstmt.executeUpdate());
			
		} catch (Exception e) {
			throw new Exception("Error al insertar filas");
		} finally {
			try {
				if(pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
					System.out.println("[LOG] pstmt cerrado");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
public static void apartadoE(Connection con) throws Exception {
		String s1;

		try {
			System.out.println("\nAPARTADO e (Actualizar  el  premio  del  maillots  del  tipo  que  indique  el  usuario  en 50€)\n");
			
			System.out.print("Tipo: ");
			s1 = scanner.next();
			
			while(true) {
				System.out.print("Introduzca tipo: ");
				s1 = scanner.next();
				if(s1.length()<=30) break;
			}
			
			pstmt = con.prepareStatement("UPDATE maillot\r\n" + 
					"SET maillot.premio = 100\r\n" + 
					"WHERE maillot.tipo LIKE ?; ");
			
			pstmt.setString(1, s1);
			
			System.out.println("[LOG] Filas actualizadas: " + pstmt.executeUpdate());
			
		} catch (Exception e) {
			throw new Exception("Error al insertar filas");
		} finally {
			try {
				if(pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
					System.out.println("[LOG] pstmt cerrado");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {

		try {
			
			Properties propiedades = new Properties();
			propiedades.load(new FileInputStream("configuracion\\PropiedadesCiclismo"));
			
			BasicDataSource ds = BasicDataSourceFactory.createDataSource(propiedades);
			con = ds.getConnection();
			System.out.println("[LOG] Conxion realiazda");
			
			apartadoA(con);
			
			apartadoB(con);
			
			apartadoC(con);
			
			apartadoD(con);
			
			apartadoE(con);
			
			
			System.out.println();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
