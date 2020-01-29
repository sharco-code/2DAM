package ejerciciosDOM2;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Ejercicio1 {

	private static DocumentBuilderFactory factory = null;
	private static DocumentBuilder builder = null;

	public static void main(String[] args) {
		try {
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();

			Document doc = builder.parse("grupos.xml");

			NodeList nodeList = doc.getElementsByTagName("alumno");
			
			for (int i = 0; i < nodeList.getLength(); i++) {
				showChilds(nodeList.item(i));
			}
					
		
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
	private static boolean isNombre = false;
	private static boolean isFechaIngreso = false;
	
	private static void showNodes(Node n) {
		switch (n.getNodeType()) {
			case Node.TEXT_NODE:
				if(isExpediente) {
					System.out.println("\nExpediente: "+n.getNodeValue().trim());
					isExpediente = false;
				}
				if(isNombre) {
					System.out.println("Nombre: "+n.getNodeValue().trim());
					isNombre = false;
				}
				if(isFechaIngreso) {
					System.out.println("FechaIngreso: "+n.getNodeValue().trim());
					isFechaIngreso = false;
				}
				break;
			case Node.ELEMENT_NODE:
				isExpediente = n.getNodeName().equals("expediente");
				isNombre = n.getNodeName().equals("nombrealu");
				isFechaIngreso = n.getNodeName().equals("fechaingreso");
				break;
		}
	}

}
