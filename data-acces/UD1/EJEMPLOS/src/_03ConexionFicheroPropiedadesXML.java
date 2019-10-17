import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import java.io.*;

public class _03ConexionFicheroPropiedadesXML {

	public static void main(String[] args) {
		Connection con = null;
		
		try {
			Properties propiedades = new Properties();
			propiedades.loadFromXML(new FileInputStream("configuracion\\PropiedadesCiclismo.xml"));
			
			BasicDataSource ds = BasicDataSourceFactory.createDataSource(propiedades);
			con = ds.getConnection();
			System.out.println("Conectado");
			

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
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

