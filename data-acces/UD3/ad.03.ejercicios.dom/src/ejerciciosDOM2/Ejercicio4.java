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

public class Ejercicio4 {

	private static DocumentBuilderFactory factory = null;
	private static DocumentBuilder builder = null;
	
	public static void main(String[] args) {
		try {
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();

			Document doc = builder.parse("grupos.xml");

			NodeList nodeList = doc.getElementsByTagName("grupo");
			
			for (int i = 0; i < nodeList.getLength(); i++) {
				alumnos = 0;
				System.out.println();
				showChilds(nodeList.item(i));
				System.out.println("Alumnos: "+alumnos);
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
	private static boolean isAlumno = false;
	private static boolean isNombre = false;
	
	private static int alumnos = 0;
	
	private static void showNodes(Node n) {
		switch (n.getNodeType()) {
			case Node.TEXT_NODE:
				
				if(isNombre) {
					System.out.println(n.getNodeValue());
					isNombre = false;
				}
				
				if(isAlumno) {
					alumnos++;
					isAlumno = false;
				}
				
				break;
			case Node.ELEMENT_NODE:
				isAlumno = n.getNodeName().equals("alumno");
				isNombre = n.getNodeName().equals("nombre");
				break;
		}
	}

}
