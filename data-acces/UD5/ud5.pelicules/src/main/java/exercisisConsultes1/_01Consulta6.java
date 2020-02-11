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

public class _01Consulta6 {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");

		MongoDatabase database = mongoClient.getDatabase("videoclub");

		MongoCollection<Document> collection = database.getCollection("pelicules");
		
		String year1 = null;
		while(true) {
			System.out.print("Introduce año:");
			year1 = scanner.nextLine();
			if(year1!=null && isNumber(year1)) break;
			else System.out.println("Tinee que ser un numero");
		};
		
		
		long num = collection.countDocuments(eq("year", Integer.parseInt(year1)));
		System.out.println("Se ha encontrado "+num+" peliculas del año "+year1);
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
