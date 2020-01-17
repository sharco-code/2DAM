package ej9;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;


public class Main {

	public static void main(String[] args) {
		try {
			XMLReader p = XMLReaderFactory.createXMLReader();
			p.setErrorHandler(new Parser());
			p.setFeature("http://xml.org/sax/features/validation",true);
			p.parse("Ciclos.xml");
			
		} catch (Exception e) {;
		}
		
	}

}
