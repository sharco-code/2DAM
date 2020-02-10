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
import com.mongodb.client.result.UpdateResult;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Projections.*;
import static com.mongodb.client.model.Updates.*;

public class UpdateDocument {

	public static void main(String[] args) {
		MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
		
		MongoDatabase database = mongoClient.getDatabase("software");
		
		MongoCollection<Document> collection = database.getCollection("aplicaciones");


		//collection.updateOne(eq("contador",10), new Document("$set", new Document("contador", 110)));
		
		//lt less than y lo incrementa con inc en 50
		UpdateResult updateResult = collection.updateMany(lt("contador", 80), inc("contador", 50));
		System.out.println(updateResult.getModifiedCount());
	}

}