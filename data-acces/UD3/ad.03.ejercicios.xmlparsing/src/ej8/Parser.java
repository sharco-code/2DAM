package ej8;

import java.util.List;
import java.util.TreeMap;
import java.io.IOException;
import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;


public class Parser extends DefaultHandler {

	private TreeMap<String, CicloFormativo> treeMap = new TreeMap<>();

	private List<CicloFormativo> ciclos = new ArrayList<CicloFormativo>();
	private List<Modulo> modulos = new ArrayList<>(); 
	
	private Integer horas = null, curso = null;
	
	private boolean isTitulo = false;
	private boolean isModulo = false;
	private boolean isNombre = false;
	
	private String titulo, familia;
	private Integer grado = null;
	private int suma = 0;
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		isTitulo = qName.equals("titulo");
		isNombre = qName.equals("nombre");
		isModulo = qName.equals("modulo");
		
		if(qName.equals("ciclo")) {
			if(attributes.getValue(0).equals("medio")) grado = 1;
			else grado = 2;
		}
		
		//para conseguir la suma de horas
		if(qName.equals("titulo")) suma = 0;
		if(qName.equals("modulo")) suma += Integer.parseInt(attributes.getValue(0));
		
		if(isModulo) horas = Integer.parseInt(attributes.getValue(0));
		if(qName.equals("curso")) curso = Integer.parseInt(attributes.getValue(0));
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {		
		if(isTitulo) this.titulo = new String(ch,start,length);
		if(isNombre) this.familia = new String(ch,start,length);
		if(isModulo) modulos.add(new Modulo(new String(ch,start,length),horas,curso));
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		isModulo = false;
		
		if(qName.equals("ciclo")) {
			CicloFormativo c = new CicloFormativo(this.titulo, this.familia, this.grado, suma, this.modulos);
			treeMap.put(titulo, c);
			modulos = new ArrayList<>();
		}
		
	}

	public TreeMap<String, CicloFormativo> getTreeMap() {
		return treeMap;
	}


}

