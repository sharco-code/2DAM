package _03Manteniment1;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Projections.*;
import static com.mongodb.client.model.Updates.inc;

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
import com.mongodb.client.result.UpdateResult;

public class _03Manteniment3 {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
		
		MongoDatabase database = mongoClient.getDatabase("videoclub");

		MongoCollection<Document> collection = database.getCollection("pelicules");

		UpdateResult updateResult = collection.updateMany(eq("year", 2019), inc("year", 1));
		
		List<Document> lst = new ArrayList<>();
		collection.find(all("year", 2020))
		.projection(fields(include("title"), excludeId()))
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
