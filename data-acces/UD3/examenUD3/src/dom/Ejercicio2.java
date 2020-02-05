package dom;


import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import pojos.CicloFormativo;

public class Ejercicio2 {

	private static DocumentBuilderFactory factory = null;
	private static DocumentBuilder builder = null;

	private static List<CicloFormativo> cicloFormativo_lst = new ArrayList<>();

	public static List<CicloFormativo> getCicloFormativo_lst() {
		return cicloFormativo_lst;
	}

	public static void main(String[] args) {
		try {
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();

			Document doc = builder.parse("ciclosExamen.xml");

			NodeList nodeList = doc.getElementsByTagName("familia");

			for (int i = 0; i < nodeList.getLength(); i++) {
				showChilds(nodeList.item(i));
				cicloFormativo_lst.add(new CicloFormativo(nom_str, familia_str, grau_int, suma_hores));
			}

			cicloFormativo_lst.forEach(e -> {
				System.out.println(e.toString());
			});

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

	private static String nom_str;
	private static String familia_str;
	private static int grau_int;
	private static int suma_hores = 0;

	private static void showNodes(Node n) {
		switch (n.getNodeType()) {
			case Node.TEXT_NODE:
				if (titol) {
					nom_str = n.getNodeValue();
					titol = false;
				}
				if (nom) {
					familia_str = n.getNodeValue();
					nom	 = false;
				}		
				break;
			case Node.ELEMENT_NODE:
				nom = n.getNodeName().equals("nom");
				titol = n.getNodeName().equals("titol");
				cicle = n.getNodeName().equals("cicle");
				modul = n.getNodeName().equals("modul");
				
				//para conseguir datos de atributos
				if (cicle) grau_int = getAttribute(n, "grau").equals("superior") ? 2 : 1;
				if (modul) suma_hores += Integer.parseInt(getAttribute(n, "hores"));
	
				break;
		}
	}

	private static String getAttribute(Node n, String nombre) {
		for (int i = 0; i < n.getAttributes().getLength(); i++) {
			if (n.getAttributes().item(i).getNodeName().equals(nombre)) return n.getAttributes().item(i).getNodeValue();
		}
		return null;
	}

}
