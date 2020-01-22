package ej14.ej5;

import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class Main {

	private static DocumentBuilderFactory factory = null;
	private static DocumentBuilder builder = null;

	public static void main(String[] args) {

		try {
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();
			Document doc = builder.parse("Ciclos.xml");

			programa(doc);

		} catch (SAXException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void programa(Document doc) {

		NodeList ciclos = doc.getElementsByTagName("ciclo");
		
		int[] suma = new int[ciclos.getLength()];
		
		for (int i = 0; i < ciclos.getLength(); i++) {
			suma[i] = 0;
			Node nNode = ciclos.item(i);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				NodeList setList = eElement.getElementsByTagName("titulo");
				
				System.out.println(setList.item(0).getChildNodes().item(0).getNodeValue());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement2 = (Element) nNode;
					NodeList modulos = eElement2.getElementsByTagName("modulo");
					for (int j = 0; j < modulos.getLength(); j++) {
						NamedNodeMap a = modulos.item(j).getAttributes();
						Node attribute = a.item(0);
						suma[i] += Integer.parseInt(attribute.getNodeValue());
					}

				}

			}
			System.out.println(" - Horas: "+suma[i]+"\n");
		}

	}
}
