package ej8;

import java.util.List;
import java.util.TreeMap;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;


public class Main {

	public static void main(String[] args) {
		try {
			XMLReader p = XMLReaderFactory.createXMLReader();
			Parser parser = new Parser();
			p.setContentHandler(parser);
			p.parse("Ciclos.xml");
			
			TreeMap<String, CicloFormativo> tm = parser.getTreeMap();
			
			tm.forEach((key, value) -> System.out.println(value.toString()+"\n"));
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
