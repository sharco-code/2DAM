package ejerciciosDOM2;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Ejercicio3 {

	private static DocumentBuilderFactory factory = null;
	private static DocumentBuilder builder = null;

	private static String grp_name;
	
	public static void main(String[] args) {
		try {
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();

			Document doc = builder.parse("grupos.xml");
			
			showChilds(doc.getDocumentElement());

		} catch (ParserConfigurationException e) {
			System.out.println("Problema al crear el DocumentBuilder");
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void showChilds(Node n) {
		showNodes(n);
		NodeList childs = n.getChildNodes();
		for (int i = 0; i < childs.getLength(); i++) {
			showChilds(childs.item(i));
		}
	}

	//flags
	private static boolean isExpediente = false;
	private static boolean isNombrealu = false;
	private static boolean isFechaIngreso = false;
	
	private static String expediente = null,nombrealu = null,fechaingreso = null;
	
	private static void showNodes(Node n) {
		switch (n.getNodeType()) {
			case Node.TEXT_NODE:
		
					if(isExpediente) {
						expediente = n.getNodeValue().trim();
						isExpediente = false;
					}
					if(isNombrealu) {
						nombrealu = n.getNodeValue().trim();
						isNombrealu = false;
					}
					if(isFechaIngreso) {
						fechaingreso = n.getNodeValue().trim();
						isFechaIngreso = false;
						 
						String currentYear = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
						
						String y[] = fechaingreso.split("/");

						if(y[2].equals(currentYear)) {
							System.out.println();
							System.out.println(expediente);
							System.out.println(nombrealu);
							System.out.println(fechaingreso);
						}
					}
				
				
				break;
			case Node.ELEMENT_NODE:
				isExpediente = n.getNodeName().equals("expediente");
				isNombrealu = n.getNodeName().equals("nombrealu");
				isFechaIngreso = n.getNodeName().equals("fechaingreso");
				break;
		}
	}

}