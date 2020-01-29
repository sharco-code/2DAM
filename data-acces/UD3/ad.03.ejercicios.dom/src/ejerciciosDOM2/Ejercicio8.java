package ejerciciosDOM2;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Ejercicio8 {

	private static DocumentBuilderFactory factory = null;
	private static DocumentBuilder builder = null;

	public static void main(String[] args) {
		try {
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();

			Document doc = builder.parse("Ciclos.xml");

			NodeList nodeList = doc.getElementsByTagName("modulo");
			
			for (int i = 0; i < nodeList.getLength(); i++) {
				System.out.println();
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
	private static boolean isModulo = false;
	
	private static String horas = null;

	private static void showNodes(Node n) {
		switch (n.getNodeType()) {
			case Node.TEXT_NODE:
				
				if(isModulo) {
					System.out.println("Nombre: "+n.getNodeValue().trim());
					System.out.println("Horas: "+horas);
				}
				
				break;
			case Node.ELEMENT_NODE:
				isModulo = n.getNodeName().equals("modulo");
				if(isModulo) {
					horas = getAttribute(n, "horas");
				}
				break;
		}
	}
	
	private static String getAttribute(Node n, String atributo) {
		NamedNodeMap a = n.getAttributes();
		for (int i = 0; i < a.getLength(); i++) {
			Node attribute = a.item(i);
			if(attribute.getNodeName().equals(atributo)) return attribute.getNodeValue();
		}
		return null;
	}

}
