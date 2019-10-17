import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.Connection;

public class _01ConectarConsDriverManager {

	static String DRIVER = "com.mysql.jdbc.Driver";
	static String URL = "jdbc:mysql://localhost:3306/ciclismo";
	static String USR = "root";
	static String PWD = "root";

	public static void main(String[] args) {
		Connection con = null;

		try {
			Class.forName(DRIVER).newInstance();

			System.out.println("Registrado");

			con = DriverManager.getConnection(URL, USR, PWD);

			System.out.println("Conectado");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
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
