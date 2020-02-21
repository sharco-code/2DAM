package Ejercicio03;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.bson.Document;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.*;

import hibernate.UtilesHibernate;
import pojos.*;

public class Main {

	private static Session session;
	private static MongoCollection<Document> collection;
	
	public static void main(String[] args) {
		
		session = connectMySQL();
		collection = connectMongoDB();
		
		Query q = session.createQuery("SELECT e FROM Grupo e");
		List<Grupo> listaGrupo = (List<Grupo>) q.list();

		for (Grupo grupo : listaGrupo) {
			
			Document mainDocument = getGrupo(grupo);
			
			collection.insertOne(mainDocument);
		}

	}

	private static Document getGrupo(Grupo grupo) {
		List<Document> clubArray = getClubs(grupo);
		
		List<Document> artistaArray = getArtistas(grupo);

		List<Document> discoArray = getDiscos(grupo);
		
		Document mainDocument = new Document("cod",grupo.getCod())
				.append("nombre", grupo.getNombre())
				.append("fecha", grupo.getFecha())
				.append("pais", grupo.getPais())
				.append("clubs", clubArray)
				.append("artistas", artistaArray)
				.append("discos", discoArray);
		return mainDocument;
	}

	private static List<Document> getDiscos(Grupo grupo) {
		List<Document> discoArray = new ArrayList<Document>();
		for (Disco disco : grupo.getDiscos()) {
			
			
			Document companyiaDocument = getCompanyia(disco);
			
			List<Document> cancionArray = getCanciones(disco);
			
			Document discoDocument = new Document("cod", disco.getCod())
					.append("nombre", disco.getNombre())
					.append("fecha", disco.getFecha())
					.append("companyia", companyiaDocument)
					.append("canciones", cancionArray);
			discoArray.add(discoDocument);
		}
		return discoArray;
	}

	private static List<Document> getCanciones(Disco disco) {
		List<Document> cancionArray = new ArrayList<Document>();
		for (Esta esta : disco.getEsta()) {
			Document cancionDocument = new Document("cod",esta.getCancion().getCod())
					.append("titulo", esta.getCancion().getTitulo())
					.append("duracion", esta.getCancion().getDuracion());
			cancionArray.add(cancionDocument);
		}
		return cancionArray;
	}

	private static Document getCompanyia(Disco disco) {
		Document companyiaDocument = new Document("cod", disco.getCompanyia().getCod())
				.append("nombre", disco.getCompanyia().getNombre())
				.append("dir", disco.getCompanyia().getDir())
				.append("fax", disco.getCompanyia().getFax())
				.append("tfno", disco.getCompanyia().getTfno());
		return companyiaDocument;
	}

	private static List<Document> getArtistas(Grupo grupo) {
		List<Document> artistaArray = new ArrayList<Document>();
		for (Pertenece pertenece : grupo.getPertenece()) {
			Document artistaDocument = new Document("dni",pertenece.getArtista().getDni())
					.append("nombre", pertenece.getArtista().getNombre())
					.append("funcion", pertenece.getFuncion());
			artistaArray.add(artistaDocument);
		}
		return artistaArray;
	}

	private static List<Document> getClubs(Grupo grupo) {
		List<Document> clubArray = new ArrayList<Document>();
		for (Club club : grupo.getClubs()) {
			Document clubDocument = new Document("cod",club.getCod())
					.append("nombre", club.getNombre())
					.append("sede", club.getSede())
					.append("num", club.getNum());
			clubArray.add(clubDocument);
		}
		return clubArray;
	}
	
	private static MongoCollection<Document> connectMongoDB() {
		MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
		
		MongoDatabase database = mongoClient.getDatabase("musica");
		
		return database.getCollection("grupos");
	}
	
	private static Session connectMySQL() {
		SessionFactory factory = UtilesHibernate.getSessionfactory();
		Session session = factory.getCurrentSession();
		
		session.beginTransaction();
		
		return session;
	}
	

}
