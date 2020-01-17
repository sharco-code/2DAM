package ej10;

import java.io.IOException;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.UtilesHibernate;

public class Main {

	public static void main(String[] args) {
		try {
			XMLReader p = XMLReaderFactory.createXMLReader();
			
			p.setErrorHandler(new Parser());
			p.setFeature("http://xml.org/sax/features/validation",true);
			
			p.setContentHandler(new Parser());
			p.parse("grupos.xml");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
