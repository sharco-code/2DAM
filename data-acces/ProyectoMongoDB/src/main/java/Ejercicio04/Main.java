package Ejercicio04;

import org.bson.Document;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Projections.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Sorts;

public class Main {
	private static MongoCollection<Document> collection;
	
	private static MongoCollection<Document> connectMongoDB() {
		MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
		
		MongoDatabase database = mongoClient.getDatabase("musica");
		
		return database.getCollection("grupos");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		collection = connectMongoDB();
		Scanner teclado = new Scanner(System.in);
		
		ejercicioA(teclado);
		
		ejercicioB(teclado);
		
		ejercicioC(teclado);
		
		
		ejercicioD();
		
		ejercicioE();
		
		

	}

	private static void ejercicioE() {
		System.out.println("Ejercicio 04 - E");
		System.out.println("De cada grup, el nom del grup, nom dels discos que han publicat i nom companyia amb la que publicaren cada disc.");
		List<Document> lista = new ArrayList<>();
		collection.find()
		.projection(fields(include("nombre","discos.nombre","discos.companyia.nombre"),excludeId()))
		.into(lista);
		if(lista.isEmpty()) {
			System.out.println("No se encontro nada");
			return;
		}
		for(Document d:lista) {
			System.out.println("Nombre grupo: "+d.getString("nombre"));
			List<Document> discos = (List<Document>) d.get("discos");
			for(Document disco:discos) {
				System.out.println("Disco: "+disco.getString("nombre"));
				if(((Document)disco.get("companyia")) != null) {
					System.out.println("Companyia: "+((Document)disco.get("companyia")).getString("nombre"));
				}
				
			}
			
			System.out.println("-------");
		}
	}

	private static void ejercicioD() {
		System.out.println("Ejercicio 04 - D");
		System.out.println("De les canciones que duren més de 4 minuts, mostrar el títol, la duració, el nom del disc en el que es troben i la data en la que se lanzó el disco.");
		List<Document> lista = new ArrayList<>();
		collection.find(gt("discos.canciones.duracion",4.0))
		.projection(fields(include("discos.nombre","discos.fecha","discos.canciones.titulo","discos.canciones.duracion"),excludeId()))
		.into(lista);
		if(lista.isEmpty()) {
			System.out.println("No se encontro nada");
			return;
		}
		String nombre;
		String fecha;
		for(Document d:lista) {
			List<Document> discos = (List<Document>) d.get("discos");
			for(Document disco: discos) {
				nombre = disco.getString("nombre");
				fecha = disco.getString("fecha");
				List<Document> canciones = (ArrayList<Document>) disco.get("canciones");
				if(canciones == null) continue;
				for(Document cancion: canciones) {
					if(cancion.getDouble("duracion")>4) {
						System.out.println("Disco:"+ nombre);
						System.out.println("Fecha: "+fecha);
						System.out.println("Titulo: "+cancion.getString("titulo"));
						System.out.println("Duracion: "+cancion.getDouble("duracion"));
						System.out.println("----");
					}
					
				}
				System.out.println("---------------------------------");
			}
		}
	}

	private static void ejercicioC(Scanner teclado) {
		System.out.println("Ejercicio 04 - C");
		System.out.println("Llista de discos (nom del disc i data de llançament) que ha publicat una companyia donada per l'usuari." );
		String companyia;
		System.out.print("Introduce una companyia:");
		companyia = teclado.next();
		List<Document> lista = new ArrayList<>();
		collection.find(eq("discos.companyia.nombre",companyia)).projection(fields(include("discos.nombre","discos.fecha"),excludeId())).into(lista);
		if(lista.isEmpty()) {
			System.out.println("No se encontro nada");
			return;
		}
		for(Document d:lista) {
			System.out.println(d.toJson());
		}
	}

	private static void ejercicioB(Scanner teclado) {
		System.out.println("Ejercicio 04 - B");
		System.out.println("Títol i duració de totes les cançons d'un grup que indique l'usuari");
		String nombreGrupo;
		System.out.print("Introduce el nombre del grupo:");
		nombreGrupo = teclado.next();
		List<Document> lista = new ArrayList<>();
		collection.find(eq("nombre",nombreGrupo)).projection(fields(include("discos.canciones.duracion","discos.canciones.titulo"),excludeId())).into(lista);
		if(lista.isEmpty()) {
			System.out.println("No se encontro nada");
			return;
		}
		for(Document d:lista) {
			System.out.println(d.toJson());
		}
	}

	private static void ejercicioA(Scanner teclado) {
		System.out.println("Ejercicio 04 - A");
		System.out.println("Codi i nom de tots els grups d'un país que introduïsca l'usuari.");
		String pais;
		System.out.print("Introduce un pais:");
		pais = teclado.next();
		List<Document> lista = new ArrayList<>();
		collection.find(eq("pais",pais)).projection(fields(include("cod","nombre"),excludeId())).into(lista);
		if(lista.isEmpty()) {
			System.out.println("No se encontro nada");
			return;
		}
		for(Document d:lista) {
			System.out.println(d.toJson());
		}
	}

}
