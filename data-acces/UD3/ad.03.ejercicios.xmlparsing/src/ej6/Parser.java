package ej6;

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

	private List<Modulo> lst = new ArrayList<Modulo>();
	
	private boolean XXXXXXXXXX = false;
	private Integer horas = null, curso = null;
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		XXXXXXXXXX = qName.equals("modulo");
		if(XXXXXXXXXX) horas = Integer.parseInt(attributes.getValue(0));
		if(qName.equals("curso")) curso = Integer.parseInt(attributes.getValue(0));
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if(XXXXXXXXXX) lst.add(new Modulo(new String(ch,start,length),horas,curso));

	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		XXXXXXXXXX = false;
	}
	
	public List<Modulo> getModulos() {
		return lst;
	}
}
