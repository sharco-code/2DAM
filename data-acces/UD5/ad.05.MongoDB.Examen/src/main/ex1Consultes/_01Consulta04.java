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
public class _01Consulta04 {

	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
		
		MongoDatabase database = mongoClient.getDatabase("premios");
		
		MongoCollection<Document> collection = database.getCollection("Nobel");
		
		List<Document> lst = new ArrayList<>();
		
		System.out.println("Numero de años que se ha otorgado  cada uno de los premios nobel de 'fisica': "+
				collection.countDocuments(eq("category","physics")));
		System.out.println("Numero de años que se ha otorgado  cada uno de los premios nobel de 'medicina': "+
				collection.countDocuments(eq("category","medicine")));
		System.out.println("Numero de años que se ha otorgado  cada uno de los premios nobel de 'quimica': "+
				collection.countDocuments(eq("category","chemistry")));
		System.out.println("Numero de años que se ha otorgado  cada uno de los premios nobel de 'paz': "+
				collection.countDocuments(eq("category","peace")));
		System.out.println("Numero de años que se ha otorgado  cada uno de los premios nobel de 'literatura': "+
				collection.countDocuments(eq("category","literature")));
		System.out.println("Numero de años que se ha otorgado  cada uno de los premios nobel de 'economia': "+
				collection.countDocuments(eq("category","economics")));
		
		
	}

}
