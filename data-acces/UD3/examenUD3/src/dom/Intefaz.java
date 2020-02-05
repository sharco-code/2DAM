package dom;


import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import pojos.CicloFormativo;

public class Intefaz {

	private static DocumentBuilderFactory factory = null;
	private static DocumentBuilder builder = null;
	
	private static Scanner scanner = new Scanner(System.in);
private static String user_input = null;
	public static void main(String[] args) {
		
		try {
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();

			System.out.print("Introduce nombre de ciclo:");
			user_input = scanner.nextLine();
			
			Document doc = builder.parse("ciclosExamen.xml");

			NodeList nodeList = doc.getElementsByTagName("cicle");

			for (int i = 0; i < nodeList.getLength(); i++) {
				showChilds(nodeList.item(i));
			}

			

		} catch (Exception e) {
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

	private static boolean nom = false; // familia
	private static boolean titol = false;
	private static boolean cicle = false;
	private static boolean modul = false;

	private static boolean isSpecified = false;
	
	private static String nom_str;
	private static String familia_str;
	private static int grau_int;
	private static int suma_hores = 0;

	private static void showNodes(Node n) {
		switch (n.getNodeType()) {
			case Node.TEXT_NODE:
				if (titol) {
					isSpecified = n.getNodeValue().equals(user_input);
					titol = false;
				}	
				if(isSpecified) {
					if(modul) {
						System.out.println(" - "+n.getNodeValue());
					}
				}
				break;
			case Node.ELEMENT_NODE:
				nom = n.getNodeName().equals("nom");
				titol = n.getNodeName().equals("titol");
				cicle = n.getNodeName().equals("cicle");
				modul = n.getNodeName().equals("modul");
	
				break;
		}
	}



}

