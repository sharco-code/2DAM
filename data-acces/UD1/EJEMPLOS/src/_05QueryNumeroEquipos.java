import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

public class _05QueryNumeroEquipos {

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
			try {
			
			Properties propiedades = new Properties();
			propiedades.load(new FileInputStream("configuracion\\PropiedadesCiclismo"));
			
			BasicDataSource ds = BasicDataSourceFactory.createDataSource(propiedades);
			con = ds.getConnection();
			System.out.println("Conxion realiazda");
			
			//consulta
			stmt = con.createStatement();
			String sql = "SELECT count(*) FROM equipo";
			rs = stmt.executeQuery(sql);
			
			rs.first();
						
			System.out.println(rs.getInt(1));


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
					System.out.println("stmt cerrado");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(con!=null && !con.isClosed()) {
					con.close();
					System.out.println("Desconetado");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}

