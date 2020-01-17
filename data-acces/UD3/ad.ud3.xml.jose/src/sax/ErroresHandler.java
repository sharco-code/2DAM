package sax;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class ErroresHandler extends DefaultHandler {

	@Override
	public void warning(SAXParseException e) throws SAXException {
		System.out.println("WARNING: "+e.toString());
	}

	@Override
	public void error(SAXParseException e) throws SAXException {
		System.out.println("ERROR: "+e.toString());
	}

	@Override
	public void fatalError(SAXParseException e) throws SAXException {
		System.out.println("FATAL ERROR: "+e.toString());
	}

}
