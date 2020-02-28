package Ejercicio5;

import static com.mongodb.client.model.Filters.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;

public class EjercicioB {
	
private static MongoCollection<Document> collection;
	
	private static MongoCollection<Document> connectMongoDB() {
		MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
		
		MongoDatabase database = mongoClient.getDatabase("musica");
		
		return database.getCollection("grupos");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		collection = connectMongoDB();
		System.out.println("Ejercicio 5 - B");
		System.out.println("Actualitza la funció d'un artista en un grup per la de \"dolçainer\" L'usuari ens donarà un codi de grup i el dni d'un artista.");
		
		Scanner teclado = new Scanner(System.in);
		int codigo;
		String dni;
		
		
		System.out.println("Introduce el codigo del grupo");
		codigo = teclado.nextInt();
		
		System.out.println("Introduce el dni del artista");
		dni = teclado.next();
		
		buscarGrupo(codigo);
		
		List<Document> artistas = buscarArtista(codigo, dni);
		
		int posicion = posicionArtista(dni, artistas);
		
		
		actualizarArtista(codigo, dni, posicion);
		

	}

	private static void buscarGrupo(int codigo) {
		List<Document> grupos = new ArrayList<>();
		collection.find(eq("cod",codigo)).into(grupos);
		
		if(grupos.size() <= 0) {
			System.out.println("No se encontro al grupo");
			System.exit(-1);
		}
	}

	private static List<Document> buscarArtista(int codigo, String dni) {
		List<Document> artistas = new ArrayList<>();
		collection.find(and(eq("cod",codigo),all("artistas.dni",dni))).into(artistas);
		
		if(artistas.size() <= 0) {
			System.out.println("No se encontro al artista");
			System.exit(-1);
		}
		return artistas;
	}

	private static void actualizarArtista(int codigo, String dni, int posicion) {
		UpdateResult updateResult = collection.updateOne(and(eq("cod",codigo),all("artistas.dni",dni)), new Document("$set", new Document("artistas."+posicion+".funcion","dolçainer")));
		
		if(updateResult.getModifiedCount() == 1) {
			System.out.println("El artista se actualizo correctamente");
		}else {
			System.out.println("No se pudo actualizar el artista");
		}
	}

	private static int posicionArtista(String dni, List<Document> artistas) {
		int posicion = -1;
		for(Document document: artistas) {
			List<Document> listado = (List<Document>) document.get("artistas");
			posicion = -1;
			for(Document doc: listado) {
				
				posicion ++;
				if(doc.get("dni").equals(dni)) {
					System.out.println(doc.toJson());
					return posicion;
				}
			}
			
		}
		return posicion;
	}

}
