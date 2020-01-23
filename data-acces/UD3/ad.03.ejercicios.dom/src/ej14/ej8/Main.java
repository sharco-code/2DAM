package ej14.ej8;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

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
			
			TreeMap<String, CicloFormativo> treeMap = getTreeMap(doc);
			treeMap.forEach((key, value) -> System.out.println(value.toString()+"\n"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static TreeMap<String, CicloFormativo> getTreeMap(Document doc) {
		TreeMap<String, CicloFormativo> treeMap = new TreeMap<>();
		
		NodeList ciclos = doc.getElementsByTagName("ciclo");
		
		int[] suma = new int[ciclos.getLength()];
		
		for (int i = 0; i < ciclos.getLength(); i++) {
			suma[i] = 0;
			if (ciclos.item(i).getNodeType() == Node.ELEMENT_NODE) {
				
				for (int j = 0; j < ((Element) ciclos.item(i)).getElementsByTagName("modulo").getLength(); j++) suma[i] += Integer.parseInt(((Element) ciclos.item(i)).getElementsByTagName("modulo").item(j).getAttributes().item(0).getNodeValue());

				List<Modulo> modulosLST = getModulosByCiclo(doc, ((Element)ciclos.item(i)).getElementsByTagName("titulo").item(0).getChildNodes().item(0).getNodeValue());
				
				CicloFormativo ci = new CicloFormativo(((Element)ciclos.item(i)).getElementsByTagName("titulo").item(0).getChildNodes().item(0).getNodeValue(), ciclos.item(i).getParentNode().getChildNodes().item(1).getChildNodes().item(0).getNodeValue(), ciclos.item(i).getParentNode().getChildNodes().item(3).getAttributes().item(0).getNodeValue().equals("medio") ? 1  : 2, suma[i], modulosLST);
				treeMap.put(((Element)ciclos.item(i)).getElementsByTagName("titulo").item(0).getChildNodes().item(0).getNodeValue(), ci);
			}
		}
		return treeMap;
	}
	
	public static List<Modulo> getModulosByCiclo(Document doc, String nombre) {
		List<Modulo> lst = new ArrayList<Modulo>();

		NodeList modulos = doc.getElementsByTagName("modulo");

		for (int i = 0; i < modulos.getLength(); i++) {
			Element e = (Element) (modulos.item(i));
			
			NodeList setList = ((Element)modulos.item(i).getParentNode().getParentNode()).getElementsByTagName("titulo");
			if(setList.item(0).getChildNodes().item(0).getNodeValue().equals(nombre)) {
				lst.add(new Modulo(modulos.item(i).getChildNodes().item(0).getNodeValue(), Integer.parseInt(modulos.item(i).getAttributes().item(0).getNodeValue()), Integer.parseInt(modulos.item(i).getParentNode().getAttributes().item(0).getNodeValue())));
			}
		}
		return lst;
	}
}
