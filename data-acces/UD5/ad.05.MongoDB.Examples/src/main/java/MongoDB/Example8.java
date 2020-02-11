package MongoDB;


import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Sorts;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Projections.*;

public class Example8 {

	public static void main(String[] args) {
		MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
		
		MongoDatabase database = mongoClient.getDatabase("videoclub");
		
		MongoCollection<Document> collection = database.getCollection("peliculas");

		
		
		List<Document> lst = new ArrayList<>();
		
		collection.find(and(eq("year", 2000), all("genres", "Comedy")))
		.sort(Sorts.ascending("titile"))
		.projection(fields(include("title", "cast")))
		.into(lst);
		
		lst.forEach(e -> {
			System.out.println(e.toJson());
		});

		
	}

}