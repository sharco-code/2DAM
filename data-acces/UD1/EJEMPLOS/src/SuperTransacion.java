import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

public class SuperTransacion {

	private static Scanner scanner = new Scanner(System.in);
	
	private static Connection con;
	private static PreparedStatement pstmt = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	public static void main(String[] args) {

		//introducire etapa
		//introduicir 2 filas en llevar
		
		try {
			Properties propiedades = new Properties();
			propiedades.load(new FileInputStream("configuracion\\PropiedadesCiclismo"));
			
			BasicDataSource ds = BasicDataSourceFactory.createDataSource(propiedades);
			con = ds.getConnection();
			System.out.println("[LOG] Conxion realiazda");
			
			con.setAutoCommit(false);
			
			//insertar maillot
			pstmt = con.prepareStatement("INSERT INTO maillot VALUES (?, ?, ?, ?); ");
			
			pstmt.setString(1, "XXX");
			pstmt.setString(2, "TIPO XXX");
			pstmt.setString(3, "COLOR XXXX");
			pstmt.setInt(4, 10);
			
			pstmt.execute();
			
			pstmt = con.prepareStatement("insert into llevar VALUES (?, ?, ?)");
			
			stmt = con.createStatement();
			rs = stmt.executeQuery("select netapa from etapa");
			while(rs.next()) {
				pstmt.setInt(1, 10);
				pstmt.setInt(2, rs.getInt(1));
				pstmt.setString(3, "XXX");
				
				pstmt.execute();
			}

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