package MongoDB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Sorts;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Projections.*;

public class CreateDocument {

	public static void main(String[] args) {
		MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
		
		MongoDatabase database = mongoClient.getDatabase("software");
		
		MongoCollection<Document> collection = database.getCollection("aplicaciones");


		Document doc = new Document("nom", "MongoDB")
				.append("tipus", "database")
				.append("conte", 1)
				.append("conte", 1)
				.append("versions", Arrays.asList("v3.2", "v3.0", "v2.6"))
				.append("info", new Document("x", 203).append("y", 102));
		
		collection.insertOne(doc);

		
	}

}