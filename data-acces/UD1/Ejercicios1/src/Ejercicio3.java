import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

public class Ejercicio3 {

	private static Scanner scanner = new Scanner(System.in);
	
	private static Connection con;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	private static boolean isNumeric(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException excepcion) {
            return false;
        }
    }
	
	private static String askDate() {
		String d,m,y;
		
		do {
			System.out.print("Dia:");
			d = scanner.next();
		}while(!isNumeric(d) || Integer.parseInt(d) > 31 || Integer.parseInt(d) < 1);
		do {
			System.out.print("Mes:");
			m = scanner.next();
		}while(!isNumeric(m) || Integer.parseInt(m) > 12 || Integer.parseInt(m) < 1);
		do {
			System.out.print("Año:");
			y = scanner.next();
		}while(!isNumeric(y) || Integer.parseInt(y) > 2019 || Integer.parseInt(y) < 1930);
			
		return y+"-"+m+"-"+d;
	}
	
	private static void _1(Statement s) {
		try {
			rs = s.executeQuery("SELECT * FROM ciclista");
			
			String dorsal, nombre, nomeq, nacimiento;
			
			System.out.println("\nInsertar ciclista:");
			
			do {
				System.out.print("Dorsal:");
				dorsal = scanner.next();
			}while(!isNumeric(dorsal) || dorsal.length() > 5);
			
			do {
				System.out.print("nombre:");
				nombre = scanner.next();
			}while(nombre.length()>30);
			
			do {
				System.out.print("nomeq (Tiene que existir):");
				nomeq = scanner.next();
			}while(nomeq.length()>25);
			
			nacimiento = askDate();
			
			rs.moveToInsertRow();
			rs.updateInt(1, Integer.parseInt(dorsal));
			rs.updateString(2, nombre);
			rs.updateString(3, nomeq);
			rs.updateString(4, nacimiento);
			rs.insertRow();
			System.out.println("[LOG] Fila insertada");
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void _2(Statement s) {
		
		try {
			
			String dorsal, nomeq = "", director;
			
			System.out.println("\nModificar director del ciclista:");
			
			do {
				System.out.print("Dorsal:");
				dorsal = scanner.next();
			}while(!isNumeric(dorsal) || dorsal.length() > 5);
			
			rs = s.executeQuery("SELECT * FROM ciclista");
			rs.beforeFirst();
			while (rs.next()) {
				if(rs.getInt(1) == Integer.parseInt(dorsal)) {
					nomeq = rs.getString(3);
					break;
				}
			}
			rs.close();
			
			do {
				System.out.print("Nuevo director:");
				director = scanner.next();
			}while(director.length()>30);
			
			rs = s.executeQuery("SELECT * FROM equipo");
			rs.beforeFirst();
			while (rs.next()) {
				if(rs.getString(1).equals(nomeq)) break;
			}
			rs.updateString(2, director);
			rs.updateRow();
			System.out.println("[LOG] Fila modificada");
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
private static void _3(Statement s) {
		
		try {
			
			String dorsal, nomeq = "", director;
			
			System.out.println("\nBorrar ciclista:");
			
			do {
				System.out.print("Dorsal:");
				dorsal = scanner.next();
			}while(!isNumeric(dorsal) || dorsal.length() > 5);
			
			rs = s.executeQuery("SELECT * FROM ciclista");
			rs.beforeFirst();
			while (rs.next()) {
				if(rs.getInt(1) == Integer.parseInt(dorsal)) {
					rs.deleteRow();
					break;
				}
			}
			System.out.println("[LOG] Fila borrada");
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		
	try {
		Properties propiedades = new Properties();
		propiedades.load(new FileInputStream("configuracion\\PropiedadesCiclismo"));
		
		BasicDataSource ds = BasicDataSourceFactory.createDataSource(propiedades);
		con = ds.getConnection();
		System.out.println("[LOG] Conxion realiazda");
		
		stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		
		_1(stmt);
		
		_2(stmt);
		
		_3(stmt);

	} catch (Exception e) {
		e.printStackTrace();
	}
			

	}

}
