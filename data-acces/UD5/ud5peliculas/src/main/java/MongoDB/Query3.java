package MongoDB;

import static com.mongodb.client.model.Filters.gt;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.Block;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.*;

public class Query3 {

	public static void main(String[] args) {
		MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
		
		MongoDatabase database = mongoClient.getDatabase("videoclub");
		
		MongoCollection<Document> collection = database.getCollection("peliculas");

		
		//gt = greather than...
		List<Document> lst = new ArrayList<>();
		collection.find().into(lst);
		
		lst.forEach(e -> {
			
		});

	}

}
