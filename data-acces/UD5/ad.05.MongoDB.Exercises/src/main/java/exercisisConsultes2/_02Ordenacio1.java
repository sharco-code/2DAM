package exercisisConsultes2;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Projections.fields;
import static com.mongodb.client.model.Projections.include;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Sorts;

public class _02Ordenacio1 {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");

		MongoDatabase database = mongoClient.getDatabase("videoclub");

		MongoCollection<Document> collection = database.getCollection("pelicules");
		
		System.out.print("Introduce nombre de actor:");
		String name = scanner.nextLine();
		
		List<Document> lst = new ArrayList<>();
		
		collection.find(all("cast", name))
		.sort(Sorts.ascending("year"))
		.into(lst);
		
		lst.forEach(e -> {
			System.out.println(e.toJson());
		});

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
