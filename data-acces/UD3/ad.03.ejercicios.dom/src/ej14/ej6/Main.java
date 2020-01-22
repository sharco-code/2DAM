package ej14.ej6;

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
			
			List<Modulo> lst = getModulos(doc);
			
			lst.forEach(e -> {
				System.out.println("Modulo: "+e.getNombre());
				System.out.println(" - Horas: "+e.getHoras());
				System.out.println(" - Curso: "+e.getCurso()+"\n---------------------------------------------");
			});
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static List<Modulo> getModulos(Document doc) {
		List<Modulo> lst = new ArrayList<Modulo>();

		NodeList modulos = doc.getElementsByTagName("modulo");

		for (int i = 0; i < modulos.getLength(); i++) {
			Element e = (Element) (modulos.item(i));
			
			NamedNodeMap curso = modulos.item(i).getParentNode().getAttributes();
			Node cursoAtributo = curso.item(0);
			
			NamedNodeMap a = modulos.item(i).getAttributes();
			Node attribute = a.item(0);
			lst.add(new Modulo(modulos.item(i).getChildNodes().item(0).getNodeValue(), Integer.parseInt(attribute.getNodeValue()), Integer.parseInt(cursoAtributo.getNodeValue())));
		}

		return lst;
	}

}
