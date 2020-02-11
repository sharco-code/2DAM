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

public class _03Manteniment1 {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");

		MongoDatabase database = mongoClient.getDatabase("videoclub");

		MongoCollection<Document> collection = database.getCollection("pelicules");

		collection.insertOne(askMovie());
		
		for (Document d : collection.find(eq("year", 2019))) {
			System.out.println(d.toJson());
		}
	}

	private static Document askMovie() {
		
		String title = null, cast[] = null, genres[] = null;
		try {
			

			System.out.print("Titulo:");
			title = scanner.nextLine();
			
			System.out.print("cuantos actores?");
			int i = Integer.parseInt(scanner.nextLine());
			if(i != 0) {
				cast = new String[i];
				for (int j = 0; j < i; j++) {
					System.out.print("Actor nº" + (j + 1) + ": ");
					cast[j] = scanner.nextLine();
				}
			} else {
				cast = new String[0];
			}
			
		
			System.out.print("cuantos generos?");
			int u = Integer.parseInt(scanner.nextLine());
			if(u != 0) {
				genres = new String[u];
				for (int j = 0; j < u; j++) {
					System.out.print("genero nº" + (j + 1) + ": ");
					genres[j] = scanner.nextLine();
				}
			} else {
				genres = new String[0];
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			askMovie();
		}
		

		Document doc = new Document("title", title).append("year", 2019).append("cast", Arrays.asList(cast))
				.append("genres", Arrays.asList(genres));

		return doc;
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
