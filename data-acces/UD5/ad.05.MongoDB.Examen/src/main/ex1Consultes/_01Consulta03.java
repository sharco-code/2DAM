package ex1Consultes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Projections.*;

import static com.mongodb.client.model.Filters.*;
public class _01Consulta03 {

	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
		
		MongoDatabase database = mongoClient.getDatabase("premios");
		
		MongoCollection<Document> collection = database.getCollection("Nobel");
		
		List<Document> lst = new ArrayList<>();
		
		System.out.print("introduce año: ");
		String year = scanner.nextLine();
		
		collection.find(and(eq("category","peace"), eq("year",year)))
		.projection(fields(include("laureates.firstname", "laureates.surname"), excludeId()))
		.into(lst);
		
		if(lst.size()>0) {
			lst.forEach(e -> {
				System.out.println(e.toJson());
			});

		} else {
			System.out.println("El año XXXX no hubo ningún premiado con el nobel en medicina");
		}
		
	}

}
