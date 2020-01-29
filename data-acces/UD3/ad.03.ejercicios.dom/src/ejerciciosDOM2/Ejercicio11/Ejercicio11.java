package ejerciciosDOM2.Ejercicio11;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Ejercicio11 {

	private static DocumentBuilderFactory factory = null;
	private static DocumentBuilder builder = null;

	private static List<String> nombres = new ArrayList<>();
	
	private static List<GrupoAlumno> lst = new ArrayList<>();
	
	public static void main(String[] args) {
		try {
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();

			Document doc = builder.parse("grupos.xml");

			NodeList nodeList = doc.getElementsByTagName("grupo");
			
			for (int i = 0; i < nodeList.getLength(); i++) {
				maxalumnos = 0;
				nombres = new ArrayList<>();
				showChilds(nodeList.item(i));
				GrupoAlumno g = new GrupoAlumno(codigo, nombre, maxalumnos, nombres);
				lst.add(g);
			}
			
			lst.forEach(e -> {
				System.out.println();
				System.out.println("Codigo: "+e.getCodigo());
				System.out.println("Nombre: "+e.getNombre());
				System.out.println("maxalumnos: "+e.getMaxAlumnos());
				System.out.println("Alumnos:");
				e.getNombreAlumnos().forEach(o -> {
					System.out.println(" - "+o);
				});
			});
		
		} catch (ParserConfigurationException e) {
			System.out.println("Problema al crear el DocumentBuilder");
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void showChilds(Node n) {
		showNodes(n);
		NodeList childs = n.getChildNodes();
		for (int i = 0; i < childs.getLength(); i++) {
			showChilds(childs.item(i));
		}
	}

	//flags
	private static boolean isNombrelu = false;
	private static boolean isNombre = false;
	private static boolean isGrupo = false;
	private static boolean isFechaingreso = false;
	
	private static int maxalumnos = -1;
	private static String codigo = null;
	private static String alumno = null;
	private static String nombre = null;
	
	
	private static int alumnos = 0;
	
	private static void showNodes(Node n) {
		switch (n.getNodeType()) {
			case Node.TEXT_NODE:
				
				if(isNombre) {
					nombre = n.getNodeValue().trim();
					
					isNombre = false;
				}

				if(isNombrelu) {
					alumno = n.getNodeValue().trim();
					isNombrelu = false;
				}
				if(isFechaingreso) {
					nombres.add(alumno);
					isFechaingreso = false;
				}
				break;
			case Node.ELEMENT_NODE:
				isNombrelu = n.getNodeName().equals("nombrealu");

				isNombre = n.getNodeName().equals("nombre");
				
				isFechaingreso = n.getNodeName().equals("fechaingreso");

				isGrupo = n.getNodeName().equals("grupo");
				if(isGrupo) {
					codigo = getAttribute(n, "codigo");
					maxalumnos = Integer.parseInt(getAttribute(n, "maxalumnos"));
				}
				break;
		}
	}
	
	private static String getAttribute(Node n, String atributo) {
		NamedNodeMap a = n.getAttributes();
		for (int i = 0; i < a.getLength(); i++) {
			Node attribute = a.item(i);
			if(attribute.getNodeName().equals(atributo)) return attribute.getNodeValue();
		}
		return null;
	}

}
