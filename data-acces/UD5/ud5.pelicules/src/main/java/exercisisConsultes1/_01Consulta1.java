package exercisisConsultes1;

import static com.mongodb.client.model.Filters.gt;

import org.bson.Document;

import org.bson.Document;

import com.mongodb.Block;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import static com.mongodb.client.model.Filters.*;

public class _01Consulta1 {

	public static void main(String[] args) {
		MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
		
		MongoDatabase database = mongoClient.getDatabase("videoclub");
		
		MongoCollection<Document> collection = database.getCollection("pelicules");
		
		for (Document d : collection.find(eq("year", 1910))) {
			System.out.println(d.toJson());
		}
	}

}
