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

public class _01Consulta5 {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");

		MongoDatabase database = mongoClient.getDatabase("videoclub");

		MongoCollection<Document> collection = database.getCollection("pelicules");

		String year1 = null, year2 = null, letter;
		while(true) {
			System.out.print("Introduce año 1:");
			year1 = scanner.nextLine();
			System.out.print("Introduce año 2:");
			year2 = scanner.nextLine();
			System.out.print("Introduce letra:");
			letter = scanner.nextLine();
			if(year1!=null && year2 != null && isNumber(year1) && isNumber(year2) &&
					letter.length()==1) break;
			else {
				System.out.println("Los años solo pueden ser numeros, y la letra solo puede ser 1 caracter");
			}
		};
		
		
		List<Document> lst = new ArrayList<>();
		collection.find(and(gt("year", (Integer.parseInt(year1)-1)), lt("year", (Integer.parseInt(year2)+1)),regex("title", "^"+letter)))
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
