package MongoDB;

import static com.mongodb.client.model.Filters.eq;

import org.bson.Document;

import com.mongodb.Block;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import static com.mongodb.client.model.Filters.*;

public class Query2 {

	public static void main(String[] args) {
		MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
		
		MongoDatabase database = mongoClient.getDatabase("videoclub");
		
		MongoCollection<Document> collection = database.getCollection("peliculas");
		
		/*
		DEPRECATED

		Block<Document> printBlock = new Block<Document>() {
			@Override
			public void apply(final Document document) {
				System.out.println(document.toJson());
			}	
		};
		
		collection.find(gt("year", 2017)).forEach(printBlock);
		*/
		
		//gt = greather than...
		
		for (Document d : collection.find(gt("year", 2017))) {
			System.out.println(d.toJson());
		}
	}

}
