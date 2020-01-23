package ej14.ej7;

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
			
			List<CicloFormativo> lst = getCicloFormativos(doc);
			
			lst.forEach(e -> {
				System.out.println("Modulo: "+e.getNombre());
				System.out.println(" - Horas: "+e.getHoras());
				
				String grado = e.getGrado() == 1 ? "Medio" : "Superior";
				
				System.out.println(" - Grado: "+grado);
				
				System.out.println(" - Familia: "+e.getFamilia()+"\n---------------------------------------------");
			});
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static List<CicloFormativo> getCicloFormativos(Document doc) {
		List<CicloFormativo> lst = new ArrayList<CicloFormativo>();

		NodeList ciclos = doc.getElementsByTagName("ciclo");
		
		int[] suma = new int[ciclos.getLength()];
		
		for (int i = 0; i < ciclos.getLength(); i++) {
			suma[i] = 0;
			Node nNode = ciclos.item(i);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				NodeList modulos = ((Element) nNode).getElementsByTagName("modulo");
					for (int j = 0; j < modulos.getLength(); j++) {
						NamedNodeMap a = modulos.item(j).getAttributes();
						Node attribute = a.item(0);
						suma[i] += Integer.parseInt(attribute.getNodeValue());
					}

				Node attribute = ciclos.item(i).getParentNode().getChildNodes().item(3).getAttributes().item(0);
				
				lst.add(new CicloFormativo(((Element) nNode).getElementsByTagName("titulo").item(0).getChildNodes().item(0).getNodeValue(), ciclos.item(i).getParentNode().getChildNodes().item(1).getChildNodes().item(0).getNodeValue(), attribute.getNodeValue().equals("medio") ? 1  : 2, suma[i]));
			}
		}
		return lst;
	}

}
