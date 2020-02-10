package MongoDB;

import static com.mongodb.client.model.Filters.regex;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.*;

public class Example6 {

	public static void main(String[] args) {
		MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
		
		MongoDatabase database = mongoClient.getDatabase("videoclub");
		
		MongoCollection<Document> collection = database.getCollection("peliculas");

		
		
		List<Document> lst = new ArrayList<>();
		collection.find(all("cast", "Danny Glover")).into(lst);
		
		lst.forEach(e -> {
			System.out.println(e.toJson());
		});
	}

}