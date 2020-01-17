package sax;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class Main {

	public static void main(String[] args) {
		try {
			XMLReader p = XMLReaderFactory.createXMLReader();
			p.setContentHandler(new CiclosHandler());
			p.setErrorHandler(new ErroresHandler());
			p.parse("Ciclos.xml");
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
