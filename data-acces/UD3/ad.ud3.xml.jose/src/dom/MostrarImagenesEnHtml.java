package dom;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class MostrarImagenesEnHtml {

	public static void main(String[] args) {

		DocumentBuilderFactory factory = null;
		DocumentBuilder builder = null;
		
		try {
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();
			Document doc = builder.parse("index.html");
			
			NodeList imagenes = doc.getElementsByTagName("img");
			for (int i = 0; i < imagenes.getLength(); i++) {
				Element e = (Element) (imagenes.item(i));
				System.out.println(e.getAttribute("src"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
