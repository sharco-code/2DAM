package validacion;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import ad.ud3.xml.jose.CiclosHandler;
import ad.ud3.xml.jose.ErroresHandler;

public class Main {

	public static void main(String[] args) {
		try {
			XMLReader p = XMLReaderFactory.createXMLReader();
			p.setContentHandler(new ContentHandlerSencillo());
			p.setErrorHandler(new ErroresHandler());
			p.setFeature("http://xml.org/sax/features/validation",true);
			p.parse("Ciclos.xml");
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
