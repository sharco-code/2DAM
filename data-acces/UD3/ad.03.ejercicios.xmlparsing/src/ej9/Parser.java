package ej9;

import java.io.IOException;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class Parser extends DefaultHandler {

	private boolean isInvalido = false;
	private boolean isMalFormado = false;
	
	@Override
	public void error(SAXParseException e) throws SAXException {
		if(!isInvalido) {
			isInvalido = true;
			System.out.println("documento invalido");
		}
	}

	@Override
	public void fatalError(SAXParseException e) throws SAXException {
		if(!isMalFormado) {
			isInvalido = true;
			System.out.println("documento mal formado");
		}
	}

	@Override
	public void endDocument() throws SAXException {
	}

}
