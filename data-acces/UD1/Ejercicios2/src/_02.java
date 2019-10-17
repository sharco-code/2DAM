import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

public class _02 {

	private static Scanner scanner = new Scanner(System.in);
	
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
	
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Properties propiedades = new Properties();
			propiedades.load(new FileInputStream("configuracion\\PropiedadesCiclismo"));
			
			BasicDataSource ds = BasicDataSourceFactory.createDataSource(propiedades);
			con = ds.getConnection();
			System.out.println("[LOG] Conxion realiazda");
			
			con.setAutoCommit(false);
								
			System.out.println("-------------Crear tabla representante y modificar ciclista--------------------");
			
			pstmt = con.prepareStatement("CREATE TABLE IF NOT EXISTS representante (nomrep VARCHAR(20) PRIMARY KEY, pais VARCHAR(20));");
			pstmt.execute();
			
			pstmt = con.prepareStatement("ALTER TABLE ciclista ADD COLUMN nomrep VARCHAR(20), ADD FOREIGN KEY (nomrep) REFERENCES representante(nomrep)");
			pstmt.execute();
			
			con.commit();
								
			pstmt.close();
			System.out.println("[LOG] tabla creada");
								
			String nomrep, pais;
			System.out.println("\n-Insertar representante-------");
			
			do {
				System.out.print("nombre representante:");
				nomrep = scanner.nextLine();
			}while(nomrep.length()>20);
			do {
				System.out.print("pais:");
				pais = scanner.nextLine();
			}while(pais.length()>20);
			
			pstmt = con.prepareStatement("INSERT INTO representante VALUES (?, ?);");
			pstmt.setString(1, nomrep);
			pstmt.setString(2, pais);
			
			pstmt.execute();
			
			String dorsal, nombre, nomeq, nacimiento;
			System.out.println("\n-Insertar ciclista-------");
			
			do {
				System.out.print("Dorsal:");
				dorsal = scanner.nextLine();
			}while(!isNumeric(dorsal) || dorsal.length() > 5);
			
			do {
				System.out.print("nombre:");
				nombre = scanner.nextLine();
			}while(nombre.length()>30);
			
			do {
				System.out.print("nomeq (Tiene que existir):");
				nomeq = scanner.nextLine();
			}while(nomeq.length()>25);
			nacimiento = askDate();
			
			pstmt = con.prepareStatement("INSERT INTO ciclista VALUES (?, ?, ?, ?, ?);");
			pstmt.setInt(1, Integer.parseInt(dorsal));
			pstmt.setString(2, nombre);
			pstmt.setString(3, nomeq);
			pstmt.setString(4, nacimiento);
			pstmt.setString(5, nomrep);
			
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
