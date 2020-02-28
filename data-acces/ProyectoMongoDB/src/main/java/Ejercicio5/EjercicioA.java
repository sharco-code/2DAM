package Ejercicio5;


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
import com.mongodb.client.result.UpdateResult;
public class EjercicioA {
	private static MongoCollection<Document> collection;
	
	private static MongoCollection<Document> connectMongoDB() {
		MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
		
		MongoDatabase database = mongoClient.getDatabase("musica");
		
		return database.getCollection("grupos");
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		collection = connectMongoDB();
		
		System.out.println("Ejercicio 5 - A");
		System.out.println("Inserix un disc i una cançó. La nova cançó pertanyerà al nou disc. El disc serà d'un grup i una companyia ja existent");
		
		Document companyia = new Document("cod",5)
				.append("nombre", "ATLANTIC")
				.append("dir", "12, E St")
				.append("fax", "545454")
				.append("tfno", "5454545");
		
		Document cancion = new Document("cod",5)
				.append("titulo", "Nombre cancion")
				.append("duracion", 6);
		
		List<Document> canciones = new ArrayList<>();
		canciones.add(cancion);
		
		Document disco = new Document("cod",1)
				.append("nombre", "Nombre disco")
				.append("fecha", "16/05/1990")
				.append("companyia", companyia)
				.append("canciones", canciones)	;
		
		
		List<Document> companyias = new ArrayList<>();
		collection.find(eq("discos.companyia.nombre","ATLANTIC")).into(companyias);
		
		if(companyias.size() <= 0) {
			System.out.println("No se encontro la companyia");
			System.exit(-1);
		}
		
		String grupo = "U2";
		
		List<Document> grupos = new ArrayList<>();
		collection.find(eq("nombre",grupo)).into(grupos);
		
		if(grupos.size() <= 0) {
			System.out.println("No se encontro al grupo");
			System.exit(-1);
		}
		
		

		UpdateResult updateResult = collection.updateOne(eq("nombre",grupo), new Document("$push", new Document("discos",disco)));
		if(updateResult.getModifiedCount() == 0) {
			System.out.println("No se pudo añadir el disco");
		} else {
			System.out.println("Se ha añadido el disco correctamente");
		}

	}

}
