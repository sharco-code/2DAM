package ej14.ej4;

import java.util.ArrayList;
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
			
			List<String> lst = getModulos(doc);
			
			lst.forEach(e -> System.out.println(e));
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static List<String> getModulos(Document doc) {
		List<String> lst = new ArrayList<String>();
		
		NodeList modulos = doc.getElementsByTagName("modulo");
		
		for (int i = 0; i < modulos.getLength(); i++) {
			Element e = (Element) (modulos.item(i));
			lst.add(modulos.item(i).getChildNodes().item(0).getNodeValue());
		}
		
		return lst;
	}
	

}
