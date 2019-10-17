import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.pool2.*;
import org.apache.commons.logging.*;

public class _02ConectarConDataSource {

	static String DRIVER = "com.mysql.jdbc.Driver";
	static String URL = "jdbc:mysql://localhost:3306/ciclismo";
	static String USR = "root";
	static String PWD = "root";

	public static void main(String[] args) {
		Connection con = null;

		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(DRIVER);
		ds.setUrl(URL);
		ds.setUsername(USR);
		ds.setPassword(PWD);
		
		try {
			
			con = ds.getConnection();
			System.out.println("Conectado");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
