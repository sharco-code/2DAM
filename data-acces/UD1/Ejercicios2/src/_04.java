import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

public class _04 {

	public static void main(String[] args) {
		Connection con = null;
		try {
			Properties propiedades = new Properties();
			propiedades.load(new FileInputStream("configuracion\\PropiedadesCiclismo"));
			
			BasicDataSource ds = BasicDataSourceFactory.createDataSource(propiedades);
			con = ds.getConnection();
			
			System.out.println("Conexion realizada");
			
			DatabaseMetaData dbmd = con.getMetaData();
			
			System.out.println("\n4. ( Lanza una consulta que obtenga todas las etapas de más de 100km\n"
					+ "a. Obtén los metadatos, numero de columnas devueltas, nombre de las columnas, tipo de las columnas.)\n");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * from etapa WHERE km > 100");
			ResultSetMetaData rsmd = rs.getMetaData();
			
			int columnas = rsmd.getColumnCount();
			System.out.println("Nº Columnas: "+columnas);
			System.out.print("Columnas: ");
			for(int i = 1; i<=columnas;i++) {
				System.out.print(rsmd.getColumnName(i));
				System.out.print(" ("+rsmd.getColumnTypeName(i)+")");
				if(i!=columnas) System.out.print(", ");
			}
			System.out.println("\n");
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
