package ej7;

import java.util.List;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;


public class Main {

	public static void main(String[] args) {
		try {
			XMLReader p = XMLReaderFactory.createXMLReader();
			Parser parser = new Parser();
			p.setContentHandler(parser);
			p.parse("Ciclos.xml");
			
			List<CicloFormativo> lst = parser.getCicloFormativos();
			
			lst.forEach(e -> {
				System.out.println("Modulo: "+e.getNombre());
				System.out.println(" - Horas: "+e.getHoras());
				
				String grado = e.getGrado() == 1 ? "Medio" : "Superior";
				
				System.out.println(" - Grado: "+grado);
				
				System.out.println(" - Familia: "+e.getFamilia()+"\n---------------------------------------------");
			});
			
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
