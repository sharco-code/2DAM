package ej10;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import hibernate.UtilesHibernate;

public class Parser extends DefaultHandler {
	
	@Override
	public void error(SAXParseException e) throws SAXException {
		System.out.println("[ERROR] documento XML invalido");
	}
	
	//Datos y flags de grupo
	private boolean isNombre = false;
	
	private String nombre = null;
	private String codigo = null;
	private String maxalumnos = null;
	
	//Datos y flags de alumno
	private boolean isexpediente = false;
	private boolean isnombrealu = false;
	private boolean isfechaingreso = false;
	

	private String expediente = null;
	private String nombrealu = null;
	private String fechaingreso = null;
	
	//otros datos
	private List<Alumno> alumnos = new ArrayList<>();
	private List<Grupo> grupos = new ArrayList<>();
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {		

		//asignar valor a los flags
		isNombre = qName.equals("nombre");
		
		isexpediente = qName.equals("expediente");
		isnombrealu = qName.equals("nombrealu");
		isfechaingreso = qName.equals("fechaingreso");
		
		if(qName.equals("grupo")) {
			
			alumnos = new ArrayList<>();
			
			codigo = attributes.getValue(0);
			maxalumnos = attributes.getValue(1);
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {		
		if(isNombre) nombre = new String(ch,start,length);
		
		if(isexpediente) expediente = new String(ch,start,length);
		if(isnombrealu) nombrealu = new String(ch,start,length);
		if(isfechaingreso) fechaingreso = new String(ch,start,length);
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		
		if(qName.equals("alumno")) {
			Alumno a = new Alumno();
			a.setExpediente(Integer.parseInt(expediente));
			a.setNombrealu(nombrealu);
			a.setFechaingreso(fechaingreso);
			
			alumnos.add(a);
			
		}
		
		if(qName.equals("grupo")) {
			
			Grupo g = new Grupo(nombre, codigo, Integer.parseInt(maxalumnos), alumnos);
			
			alumnos.forEach(e -> {
				e.setGrupo(g);
				
			});
			
			grupos.add(g);
			
		}
		
		if(qName.equals("colegio")) {
			SessionFactory factory = UtilesHibernate.getSessionfactory();
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			
			grupos.forEach(g -> {
				g.getAlumnos().forEach(a -> {
					session.save(a);
				});
				session.save(g);
			});
			
			
			session.getTransaction().commit();
			//System.out.println("Datos insertados en la base de datos");
		}
		
	}

	
}
