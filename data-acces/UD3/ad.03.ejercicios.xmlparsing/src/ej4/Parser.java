package ej4;

import java.util.List;
import java.io.IOException;
import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class Parser extends DefaultHandler {

	private List<String> lst = new ArrayList<String>();
	private boolean isModule = false;
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		isModule = qName.equals("modulo");
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		isModule = false;
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if(isModule) lst.add(new String(ch,start,length));

	}

	public List<String> getModulos() {
		return lst;
	}
}
