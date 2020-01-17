package ej5;

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
	
	private int suma = 0;
	private boolean isTitulo = false;

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if(qName.equals("titulo")) suma = 0;
		isTitulo = qName.equals("titulo");
		if(qName.equals("modulo")) suma += Integer.parseInt(attributes.getValue(0));
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if(isTitulo) System.out.print(new String(ch,start,length));
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(qName.equals("ciclo")) System.out.print(" "+suma+" horas\n-----------------------------------------------\n");
	}
}
