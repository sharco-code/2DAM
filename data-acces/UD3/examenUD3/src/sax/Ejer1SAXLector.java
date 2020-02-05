package sax;



import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class Ejer1SAXLector {

	public static void main(String[] args) {
		try {
			XMLReader p = XMLReaderFactory.createXMLReader();
			p.setContentHandler(new Ejer1SAXContentHandlerJOSEGALANSIMO());
			p.setFeature("http://xml.org/sax/features/validation", true);
			p.parse("ciclosExamen.xml");
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
