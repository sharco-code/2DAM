package ejerciciosDOM2.Ejercicio10;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Ejercicio10 {

	private static DocumentBuilderFactory factory = null;
	private static DocumentBuilder builder = null;
	
	private static List<Modulo> lst = new ArrayList<>();
	
	public static void main(String[] args) {
		try {
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();

			Document doc = builder.parse("Ciclos.xml");

			
			NodeList nodeList = doc.getElementsByTagName("familia");
			
			for (int i = 0; i < nodeList.getLength(); i++) {
				System.out.println();
				showChilds(nodeList.item(i));
				Modulo m = new Modulo(nombre, Integer.parseInt(horas), Integer.parseInt(curso));
				lst.add(m);
			}
					
			lst.forEach(e -> {
				System.out.println("Modulo: "+e.getNombre());
				System.out.println(" - Horas: "+e.getHoras());
				System.out.println(" - Curso: "+e.getCurso()+"\n---------------------------------------------");
			});
			
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
	private static boolean isNombre = false;
	private static boolean isTitulo = false;
	private static boolean isCurso = false;

	private static String nombre = null;
	private static String modulo = null;
	private static String titulo = null;
	private static String curso = null;
	
	private static String horas = null;
	
	private static void showNodes(Node n) {
		switch (n.getNodeType()) {
			case Node.TEXT_NODE:
				
				if(isModulo) {
					modulo = n.getNodeValue();
					isModulo = false;
				}
				if(isNombre) {
					nombre = n.getNodeValue().trim();
					isNombre = false;
				}
				if(isTitulo) {
					titulo = n.getNodeValue().trim();
					isTitulo = false;
				}
				break;
			case Node.ELEMENT_NODE:
				isModulo = n.getNodeName().equals("modulo");
				if(isModulo) {
					horas = getAttribute(n, "horas");
				}
				isNombre = n.getNodeName().equals("nombre");
				isTitulo = n.getNodeName().equals("titulo");
				isCurso = n.getNodeName().equals("curso");
				if(isCurso) {
					curso = getAttribute(n, "numero");
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
