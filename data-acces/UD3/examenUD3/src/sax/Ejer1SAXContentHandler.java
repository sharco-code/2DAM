package sax;



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class Ejer1SAXContentHandler extends DefaultHandler {

	@Override
	public void warning(SAXParseException e) throws SAXException {
		System.out.println("WARNING: " + e.toString());
	}

	@Override
	public void error(SAXParseException e) throws SAXException {
		System.out.println("ERROR: " + e.toString());
	}

	@Override
	public void fatalError(SAXParseException e) throws SAXException {
		System.out.println("FATAL ERROR: " + e.toString());
	}

	//FLAGS
	private boolean modul = false;
	private boolean titol = false;
	private boolean curs = false;
	
	private String hores = null;
	private String codi = null;
	private int hores_suma = 0;
	
	private List<String> moduls = new ArrayList<>();
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		modul = qName.equals("modul");
		titol = qName.equals("titol");
		curs = qName.equals("curs");
		if(modul) {
			hores = attributes.getValue(0);
			hores_suma += Integer.parseInt(attributes.getValue(0));
		}
		if(curs) {
			codi = attributes.getValue(0);
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if(titol) {
			System.out.println("---------------------------------------");
			System.out.println(new String(ch,start,length));
		}
		
		if(modul) {
			moduls.add(" - "+new String(ch,start,length)+" ["+hores+" horas]");
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(localName.equals("curs")) {
			System.out.println("-Curso: "+codi+" ["+hores_suma+" horas]");
			hores_suma = 0;
			moduls.forEach(e -> {
				System.out.println(e);
			});
			moduls.clear();
			System.out.println();
		}
	}
}