package examen.ud1.josegalansimo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ejercicio2 {

	private final static String DRIVER = "com.mysql.jdbc.Driver";
	private final static String URL = "jdbc:mysql://localhost:3306/jardineria";
	private final static String USR = "root";
	private final static String PSW = "root";
	
	private static Connection con = null;
	private static Scanner scanner = new Scanner(System.in);
	private static PreparedStatement pstmt = null;
	
	public static void main(String[] args) {
		
		try {
			Class.forName(DRIVER).newInstance();
			con = DriverManager.getConnection(URL, USR, PSW);
			System.out.println("- Conectado");
			
			System.out.println("a. -");
			System.out.println("   - Productos:");
			pstmt = con.prepareStatement("SELECT distinct Nombre from productos natural JOIN detallepedidos natural JOIN pedidos natural JOIN clientes where clientes.NombreCliente LIKE \"Naturagua\"");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println("    - "+rs.getString(1));
			}
			rs.close();
			
			System.out.println("b.  -");
			con.setAutoCommit(false);
			
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = stmt.executeQuery("SELECT * from productos");
			while(rs.next()) {
				if(rs.getDouble("PrecioVenta") > 100.0) {
					rs.updateDouble("PrecioVenta", (rs.getDouble("PrecioVenta")+5));
					rs.updateRow();
					rs.updateDouble("PrecioProveedor", (rs.getDouble("PrecioProveedor")+2));
					rs.updateRow();
				}
			}
			
			con.commit();
			
			con.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				con.setAutoCommit(true);
				if(con!=null && !con.isClosed()) {
					con.close();
					System.out.println("- Desconetado");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}
