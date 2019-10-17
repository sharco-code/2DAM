import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

public class _01 {
	
	private static Scanner scanner = new Scanner(System.in);
	
	public static void a(Statement s) {
		System.out.println("\na. (Actualiza el valor de los maillot de tipo \"Regularidad\" incrementa el valor del premio en 100 €)");
		try {
			
			ResultSet rs = s.executeQuery("select * FROM maillot WHERE tipo LIKE \"Regularidad\"");
			rs.beforeFirst();
			while (rs.next()) {
				rs.updateInt("premio", (rs.getInt("premio")+100));
				rs.updateRow();
				System.out.println("[LOG] Fila modificada");
			}
			rs.close();
			System.out.println("[LOG] ResultSet cerrado");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void b(Statement s) {
		System.out.println("\nb. (Muestra el valor del último registro de la tabla ETAPA )");
		try {
			
			ResultSet rs = s.executeQuery("select * FROM etapa");
			rs.last();
			System.out.println("NETAPA\tKM\tSALIDA\tLLEGADA\tDORSAL");
			System.out.println(rs.getInt("netapa")+"\t"+rs.getInt("km")+"\t"+rs.getString("salida")+"\t"+rs.getString("llegada")+"\t"+rs.getInt("dorsal"));
			
			
			rs.close();
			System.out.println("[LOG] ResultSet cerrado");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void c(Statement s) {
		System.out.println("\nc. (Cuáles  son  las  ciudades  de  salida  y  llegada  de  la  etapa  que  se encuentra en el registro)");
		try {
			
			ResultSet rs = s.executeQuery("select * FROM etapa");

			System.out.println("ETAPA\tSALIDA\t\tLLEGADA");
			while (rs.next()) {
				System.out.println(rs.getInt("netapa")+"\t"+rs.getString("salida")+"\t\t"+rs.getString("llegada"));
			}
	
			rs.close();
			System.out.println("[LOG] ResultSet cerrado");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void d(Statement s) {
		System.out.println("\nd. ( Modifica su valor por una ciudad de salida que introduzca el usuario)");
		String etapa, salida = "";
		try {
			do {
				System.out.print("ETAPA:");
				etapa = scanner.next();
			}while(!isNumeric(etapa) || etapa.length() > 5);
			do {
				System.out.print("salida:");
				salida = scanner.next();
			}while(salida.length()>35);
			
			ResultSet rs = s.executeQuery("select * FROM etapa");
			
			while (rs.next()) {
				if(rs.getInt("netapa")==Integer.parseInt(etapa)) {
					rs.updateString("salida", salida);
					rs.updateRow();
					System.out.println("[LOG] Fila modificada");
					break;
				}
			}
			
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		Connection con = null;
		Statement stmt = null;
		try {
			Properties propiedades = new Properties();
			propiedades.load(new FileInputStream("configuracion\\PropiedadesCiclismo"));
			
			BasicDataSource ds = BasicDataSourceFactory.createDataSource(propiedades);
			con = ds.getConnection();
			
			System.out.println("[LOG] Conexion realizada");
			
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			a(stmt);
			
			b(stmt);
			
			c(stmt);
			
			d(stmt);
			
			
				
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	private static boolean isNumeric(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException excepcion) {
            return false;
        }
    }

}
