package ej3;

import java.io.IOException;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class Parser extends DefaultHandler {

	private String horas = null;

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if(qName.equals("modulo")) horas = attributes.getValue(0);
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		horas = null;
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if(horas != null) System.out.print(new String(ch,start,length)+" "+horas+" horas\n"); 

	}

}
