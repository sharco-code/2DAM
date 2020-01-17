package dom;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class LeerXML {
	
	private static DocumentBuilderFactory factory = null;
	private static DocumentBuilder builder = null;
	
	public static void main(String[] args) {
		try {
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();
			
			Document doc = builder.parse("ciclos.xml");
			doc.normalize();
			
			Element root = doc.getDocumentElement();
			System.out.println("Elementou raíz: " + root.getNodeName());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
