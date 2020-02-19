package ex1Consultes;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Projections.*;

import static com.mongodb.client.model.Filters.*;
public class _01Consulta02 {

	
	public static void main(String[] args) {
		MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
		
		MongoDatabase database = mongoClient.getDatabase("premios");
		
		MongoCollection<Document> collection = database.getCollection("Nobel");
		
		List<Document> lst = new ArrayList<>();
		
		collection.find(eq("category","physics"))
		.projection(fields(include("laureates.firstname", "laureates.surname", "year"), excludeId()))
		.into(lst);
		
		lst.forEach(e -> {
			System.out.println(e.toJson());
		});

	}

}
