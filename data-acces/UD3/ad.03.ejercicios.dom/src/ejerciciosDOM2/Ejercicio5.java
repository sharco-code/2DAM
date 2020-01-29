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

public class Ejercicio5 {

	private static DocumentBuilderFactory factory = null;
	private static DocumentBuilder builder = null;

	private static Scanner scanner = new Scanner(System.in);
	private static String user_input;
	
	public static void main(String[] args) {
		try {
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();

			Document doc = builder.parse("grupos.xml");

			System.out.print("Introduce nombre de alumno: ");
			user_input = scanner.nextLine();
			
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

	private static boolean isNombrealu = false;
	private static boolean isNombre = false;
	
	private static String nombre = null;
	
	private static void showNodes(Node n) {
		switch (n.getNodeType()) {
			case Node.TEXT_NODE:
				if(isNombre) {
					nombre = n.getNodeValue();
					isNombre = false;
				}
				
				if(isNombrealu) {
					if(n.getNodeValue().equals(user_input)) System.out.println(nombre);
					isNombrealu = false;
				}
				
				break;
			case Node.ELEMENT_NODE:
			n.getNodeName().equals("expediente");
				isNombrealu = n.getNodeName().equals("nombrealu");
			n.getNodeName().equals("fechaingreso");
				isNombre = n.getNodeName().equals("nombre");
				break;
		}
	}

}
