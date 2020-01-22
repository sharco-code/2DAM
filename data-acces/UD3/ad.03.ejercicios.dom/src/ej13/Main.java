package ej13;

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

public class Main {

	private static DocumentBuilderFactory factory = null;
	private static DocumentBuilder builder = null;
	
	public static void main(String[] args) {
		try {
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();
			
			Document doc = builder.parse("Ciclos.xml");
			
			Element root = doc.getDocumentElement();
			 
			NodeList modulos = doc.getElementsByTagName("modulo");
			
			int suma = 0;
			
			for (int i = 0; i < modulos.getLength(); i++) {
				NamedNodeMap a = modulos.item(i).getAttributes();
				suma += Integer.parseInt(a.item(0).getNodeValue());
			}
			
			System.out.println("Total de horas de los modulos: "+suma+" horas");
			
		} catch (ParserConfigurationException e) {
			System.out.println("Problema al crear el DocumentBuilder");
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	private static void showAttributes(Node n) {
		NamedNodeMap a = n.getAttributes();
		for (int i = 0; i < a.getLength(); i++) {
			Node attribute = a.item(i);
			System.out.print(" ("+attribute.getNodeName() + ": " + attribute.getNodeValue()+") ");
		}
	}
}
