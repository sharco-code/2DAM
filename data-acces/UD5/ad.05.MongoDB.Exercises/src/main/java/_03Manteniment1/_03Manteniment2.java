package _03Manteniment1;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Projections.*;
import static com.mongodb.client.model.Projections.include;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Sorts;

public class _03Manteniment2 {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");

		MongoDatabase database = mongoClient.getDatabase("videoclub");

		MongoCollection<Document> collection = database.getCollection("pelicules");
		int n;
		while(true) {
			try {
				System.out.print("Cuantas pelis quieres insertar:");
				n = Integer.parseInt(scanner.nextLine());
				break;
			} catch (Exception e) {
			}
		}
		
		
		for (int i = 0; i < n; i++) {
			String cast[] = new String[3];
			cast[0] = "Actor"+(i+1);
			cast[1] = "Actor"+(i+2);
			cast[2] = "Actor"+(i+3);
			
			String genres[] = new String[3];
			genres[0] = "Comedy";
			genres[1] = "Adventure";
			Document doc = new Document("title", "Pelicula"+(i+1))
					.append("year", 2019)
					.append("cast", Arrays.asList(cast))
					.append("genres", Arrays.asList(genres));
			
			collection.insertOne(doc);
		}
		
		
		for (Document d : collection.find(eq("year", 2019))) {
			System.out.println(d.toJson());
		}
	}


	private static boolean isNumber(String cadena) {
		try {
			int num = Integer.parseInt(cadena);
			return true;
		} catch (Exception e) {
			return false;
		}

	}
}
