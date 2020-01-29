package ejerciciosDOM2;

import java.io.IOException;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Ejercicio2 {

	private static DocumentBuilderFactory factory = null;
	private static DocumentBuilder builder = null;

	private static Scanner scanner = new Scanner(System.in);
	private static String grp_name;
	
	public static void main(String[] args) {
		try {
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();

			Document doc = builder.parse("grupos.xml");

			System.out.print("Introduce nombre de grupo: ");
			grp_name = scanner.nextLine();
			
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
	private static boolean isNombre = false;
	
	private static boolean isGroupIndicated = false; //si es el grupo indicado por el usuario
	
	private static void showNodes(Node n) {
		switch (n.getNodeType()) {
			case Node.TEXT_NODE:
				//para comprobar el nombre introducido por el usuario con el del XML
				if(isNombre) {
					isGroupIndicated = n.getNodeValue().equals(grp_name);
					isNombre = false;
				}
				
				//si el flag del grupo indicado por el usuario es true
				if(isGroupIndicated) {
					if(isExpediente) {
						System.out.println("\nExpediente: "+n.getNodeValue().trim());
						isExpediente = false;
					}
					if(isNombrealu) {
						System.out.println("Nombre: "+n.getNodeValue().trim());
						isNombrealu = false;
					}
					if(isFechaIngreso) {
						System.out.println("FechaIngreso: "+n.getNodeValue().trim());
						isFechaIngreso = false;
					}
				}
				
				break;
			case Node.ELEMENT_NODE:
				isExpediente = n.getNodeName().equals("expediente");
				isNombrealu = n.getNodeName().equals("nombrealu");
				isFechaIngreso = n.getNodeName().equals("fechaingreso");
				isNombre = n.getNodeName().equals("nombre");
				break;
		}
	}

}
