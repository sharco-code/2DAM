package ej14.ej8;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;


public class Main {

	private static TreeMap<String, CicloFormativo> treeMap = new TreeMap<>();

	public static void main(String[] args) {
		try {
			
			cargarTreeMap();

			treeMap.forEach((key, value) -> System.out.println(value.toString()+"\n"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	private static void cargarTreeMap() {
		List<CicloFormativo> ciclos = new ArrayList<CicloFormativo>();
		List<Modulo> modulos = new ArrayList<>(); 
		
		
		CicloFormativo c = new CicloFormativo(this.titulo, this.familia, this.grado, suma, this.modulos);
		treeMap.put(titulo, c);
		modulos = new ArrayList<>();
	}
	
	

}
