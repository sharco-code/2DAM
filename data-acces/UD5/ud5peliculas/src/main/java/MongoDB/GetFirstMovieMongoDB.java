package MongoDB;

import java.util.Arrays;

import org.bson.Document;

import com.mongodb.*;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class GetFirstMovieMongoDB {

	public static void main(String[] args) {

		/*
		MongoClient mongoClient = MongoClients.create(
				MongoClientSettings.builder()
				.applyToClusterSettings(builder -> builder.hosts(Arrays.asList(new ServerAddress("localhost",27017))))
				.build());
		 */
		MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
		
		MongoDatabase database = mongoClient.getDatabase("videoclub");
		
		MongoCollection<Document> collection = database.getCollection("peliculas");
		
		Document firstMovie = collection.find().first();
		
		System.out.println(firstMovie.toJson());
	}

}
