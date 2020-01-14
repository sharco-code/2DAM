package ad.ud3.xml.jose;

import java.io.FileWriter;
import java.io.IOException;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class ErroresHandlerLog extends DefaultHandler {
	
	private FileWriter f = null;
	
	@Override
	public void warning(SAXParseException e) throws SAXException {
		try {
			f = new FileWriter("ParsingCiclos.log",true);
			f.write("WARNING: "+e.toString());
		} catch (IOException e1) {
			throw new SAXException("Error al escribir el log");
		} finally {
			if(f!=null) {
				try {
					f.close();
				} catch (IOException e2) {
					throw new SAXException("Error al cerrar el log");
				}
			}
		}
	}

	@Override
	public void error(SAXParseException e) throws SAXException {
		try {
			f = new FileWriter("ParsingCiclos.log",true);
			System.out.println("ERROR: "+e.toString());
		} catch (IOException e1) {
			throw new SAXException("Error al escribir el log");
		} finally {
			if(f!=null) {
				try {
					f.close();
				} catch (IOException e2) {
					throw new SAXException("Error al cerrar el log");
				}
			}
		}
	}

	@Override
	public void fatalError(SAXParseException e) throws SAXException {
		try {
			f = new FileWriter("ParsingCiclos.log",true);
			System.out.println("FATAL ERROR: "+e.toString());
		} catch (IOException e1) {
			throw new SAXException("Error al escribir el log");
		} finally {
			if(f!=null) {
				try {
					f.close();
				} catch (IOException e2) {
					throw new SAXException("Error al cerrar el log");
				}
			}
		}
	}

}
