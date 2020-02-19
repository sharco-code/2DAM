package ex2Modificacions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Projections.*;
import static com.mongodb.client.model.Projections.include;
import static com.mongodb.client.model.Updates.*;

public class _02Modificacio02 {
	
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
		
		MongoDatabase database = mongoClient.getDatabase("premios");
		
		MongoCollection<Document> collection = database.getCollection("Nobel");
		
		UpdateResult updateResult = collection.updateMany(eq("year", "2010"), set("year", "2019"));
		
		for (Document d : collection.find(eq("year", "2019"))) {
			System.out.println(d.toJson());
		}
	}
	
}
