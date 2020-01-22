package dom;

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

public class MostrarRecursivoConNodeListYAtributos {

	private static DocumentBuilderFactory factory = null;
	private static DocumentBuilder builder = null;

	public static void main(String[] args) {
		try {
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();

			Document doc = builder.parse("Ciclos.xml");

			Element root = doc.getDocumentElement();

			showChilds(root, 0);

		} catch (ParserConfigurationException e) {
			System.out.println("Problema al crear el DocumentBuilder");
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void showChilds(Node n, int ident) {
		ident(ident);
		showNodes(n);
		NodeList childs = n.getChildNodes();
		for (int i = 0; i < childs.getLength(); i++) {
			showChilds(childs.item(i), ident + 1);
		}
	}

	private static void showNodes(Node n) {
		switch (n.getNodeType()) {
		case Node.TEXT_NODE:
			System.out.println(n.getNodeValue().trim());
			break;
		case Node.COMMENT_NODE:
			System.out.println("Comentario: " + n.getNodeValue().trim());
			break;
		case Node.ELEMENT_NODE:
			if (n.hasAttributes()) {
				showAttributes(n);
			}
		default:
			System.out.println(n.getNodeName());
		}
	}

	private static void showAttributes(Node n) {
		NamedNodeMap a = n.getAttributes();
		for (int i = 0; i < a.getLength(); i++) {
			Node attribute = a.item(i);
			System.out.print(" ("+attribute.getNodeName() + ": " + attribute.getNodeValue()+") ");
		}

	}

	private static void ident(int n) {
		for (int i = 0; i < n; i++) {
			System.out.print("\t");
		}
	}

}
