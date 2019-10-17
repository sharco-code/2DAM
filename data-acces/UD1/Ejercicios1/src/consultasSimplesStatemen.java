import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

public class consultasSimplesStatemen {

	private static Scanner scanner = new Scanner(System.in);
	
	private static Connection con;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	private static String sql;
	private static String _input;
	private static String _input2;
	
	public static void main(String[] args) {
		
		try {
			
			Properties propiedades = new Properties();
			propiedades.load(new FileInputStream("configuracion\\PropiedadesCiclismo"));
			
			BasicDataSource ds = BasicDataSourceFactory.createDataSource(propiedades);
			con = ds.getConnection();
			System.out.println("[LOG] Conxion realiazda");
			
			
			
			//consulta 1 (A)
			System.out.println("\nAPARTADO A\n");
			System.out.println("DORSAL\t- NOMBRE\t\t- EQUIPO");
			System.out.println("---------------------------------------");
			
			stmt = con.createStatement();
			sql = "SELECT ciclista.dorsal, ciclista.nombre, equipo.nomeq FROM ciclista NATURAL JOIN equipo";
			rs = stmt.executeQuery(sql);
			rs.beforeFirst();
			while (rs.next()) {
				System.out.println(rs.getInt(1)+"\t- "+rs.getString(2)+"   \t- "+rs.getString(3));
			}
			
			//consulta 2 (B)
			System.out.println("\nAPARTADO B\n");
			System.out.println("DORSAL\t- NOMBRE\t\t- DIRECTOR");
			System.out.println("---------------------------------------");
			
			stmt = con.createStatement();
			sql = "SELECT ciclista.dorsal, ciclista.nombre, equipo.director FROM ciclista NATURAL JOIN equipo";
			rs = stmt.executeQuery(sql);
			rs.beforeFirst();
			while (rs.next()) {
				System.out.println(rs.getInt(1)+"\t- "+rs.getString(2)+"   \t- "+rs.getString(3));
			}
			
			//consulta 3 (C)
			System.out.println("\nAPARTADO C\n");
			System.out.println("DORSAL\t- NOMBRE\t\t- DIRECTOR");
			System.out.println("---------------------------------------");
			
			stmt = con.createStatement();
			sql = "SELECT ciclista.dorsal, ciclista.nombre, equipo.director\r\n" + 
					"FROM ciclista NATURAL JOIN equipo\r\n" + 
					"WHERE equipo.nomeq LIKE \"ONCE\"";
			rs = stmt.executeQuery(sql);
			rs.beforeFirst();
			while (rs.next()) {
				System.out.println(rs.getInt(1)+"\t- "+rs.getString(2)+"   \t- "+rs.getString(3));
			}
			
			//consulta 4 (D)
			System.out.println("\nAPARTADO D\n");
			while(true) {
				System.out.print("Introduzca equipo: ");
				_input = scanner.next();
				if(_input.length()<=25) break;
			}
			System.out.println("DORSAL\t- NOMBRE\t\t- EQUIPO");
			System.out.println("---------------------------------------");
			stmt = con.createStatement();
			sql = "SELECT ciclista.dorsal, ciclista.nombre, equipo.nomeq\r\n" + 
					"FROM ciclista NATURAL JOIN equipo\r\n" + 
					"WHERE equipo.nomeq LIKE \""+_input+"\"";
			rs = stmt.executeQuery(sql);
			rs.beforeFirst();
			while (rs.next()) {
				System.out.println(rs.getInt(1)+"\t- "+rs.getString(2)+"   \t- "+rs.getString(3));
			}
			_input = null;
			
			//consulta 5 (E)
			System.out.println("\nAPARTADO E\n");
			
			while(true) {
				System.out.print("Introduzca equipo: ");
				_input = scanner.next();
				if(_input.length()<=25) break;
			}
			while(true) {
				System.out.print("Introduzca texto que contenga nombre de ciclista: ");
				_input2 = scanner.next();
				if(_input2.length()<=25) break;
			}
		
			System.out.println("DORSAL\t- NOMBRE\t\t- EQUIPO");
			System.out.println("---------------------------------------");
			stmt = con.createStatement();
			sql = "SELECT ciclista.dorsal, ciclista.nombre, equipo.nomeq\r\n" + 
					"FROM ciclista NATURAL JOIN equipo\r\n" + 
					"WHERE equipo.nomeq LIKE \""+_input+"\" &&" +
					"ciclista.nombre LIKE \"%"+_input2+"%\"";
			rs = stmt.executeQuery(sql);
			rs.beforeFirst();
			while (rs.next()) {
				System.out.println(rs.getInt(1)+"\t- "+rs.getString(2)+"   \t- "+rs.getString(3));
			}
			_input = _input2 = null;
			
			
			System.out.println();
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
