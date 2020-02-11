package exercisisConsultes1;

import static com.mongodb.client.model.Filters.all;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.regex;
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

public class _01Consulta7 {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
		
		MongoDatabase database = mongoClient.getDatabase("videoclub");
		
		MongoCollection<Document> collection = database.getCollection("pelicules");
		
		List<Document> lst = new ArrayList<>();
		collection.find(and(all("cast", "Liam Neeson"),all("cast", "Ralph Fiennes"))).into(lst);
		
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
