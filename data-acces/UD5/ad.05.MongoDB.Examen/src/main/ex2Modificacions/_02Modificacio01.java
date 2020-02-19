package ex2Modificacions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Projections.*;
import static com.mongodb.client.model.Projections.include;

public class _02Modificacio01 {
	
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
		
		MongoDatabase database = mongoClient.getDatabase("premios");
		
		MongoCollection<Document> collection = database.getCollection("Nobel");
		
		System.out.print("Añadir nuevo premiado en el nobel en el año 2020\n");
		
		collection.insertOne(nuevoPremiado());
		
		for (Document d : collection.find(eq("year", "2020"))) {
			System.out.println(d.toJson());
		}
	}
	
	private static Document nuevoPremiado() {
		
		String category = "", firstname,surname,motivation;
		//Document laureate[] = new Document[1];
		List<Document> laureates = new ArrayList<Document>();
		
		System.out.print("Categoria:");
		category = scanner.nextLine();
		System.out.print("nombre:");
		firstname = scanner.nextLine();
		System.out.print("apellido:");
		surname = scanner.nextLine();
		System.out.print("motivacion:");
		motivation = scanner.nextLine();
		
		laureates.add(new Document("id",null).append("firstname",firstname).append("surname", surname).append("motivation", motivation).append("share", 1));
		Document doc = new Document("year", "2020").append("category", category).append("laureates", Arrays.asList(laureates));
		
		return doc;
	}
}
