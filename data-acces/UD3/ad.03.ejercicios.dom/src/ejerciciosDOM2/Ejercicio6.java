package ejerciciosDOM2;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Ejercicio6 {

	private static DocumentBuilderFactory factory = null;
	private static DocumentBuilder builder = null;
	
	public static void main(String[] args) {
		try {
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();

			Document doc = builder.parse("Ciclos.xml");

			NodeList nodeList = doc.getElementsByTagName("familia");
			
			for (int i = 0; i < nodeList.getLength(); i++) {
				System.out.println();
				numCiclos = 0;
				showChilds(nodeList.item(i));
				System.out.println("Alumnos: "+numCiclos);
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
	private static boolean isCiclo = false;
	private static boolean isNombre = false;
	
	private static int numCiclos = 0;
	
	private static void showNodes(Node n) {
		switch (n.getNodeType()) {
			case Node.TEXT_NODE:
				
				if(isNombre) {
					System.out.println(n.getNodeValue());
					isNombre = false;
				}
				
				if(isCiclo) {
					numCiclos++;
					isCiclo = false;
				}
				
				break;
			case Node.ELEMENT_NODE:
				isCiclo = n.getNodeName().equals("ciclo");
				isNombre = n.getNodeName().equals("nombre");
				break;
		}
	}

}