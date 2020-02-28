package Ejercicio6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.bson.Document;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import hibernate.UtilesHibernate;
import pojos.Artista;
import pojos.Cancion;
import pojos.Club;
import pojos.Companyia;
import pojos.Disco;
import pojos.Esta;
import pojos.Grupo;
import pojos.Pertenece;

public class Main {

	private static Session session;
	private static MongoCollection<Document> collection;
	
	public static void main(String[] args) {
		
		session = connectMySQL();
		collection = connectMongoDB();
		
		List<Document> documentGrupos = new ArrayList<>();
		
		collection.find().into(documentGrupos);
		
		
		
		
		
		session.beginTransaction();
		
		
		insertarCompanyias(documentGrupos);
		
		insertarGrupos(documentGrupos);
		
		insertarDiscos(documentGrupos);
		
		insertarCanciones(documentGrupos);
		
		insertarEsta(documentGrupos);
		
		insertarArtistas(documentGrupos);
		
		insertarPertenece(documentGrupos);
		
		insertarClubs(documentGrupos);
		
		
		
		session.getTransaction().commit();
	}



	private static void insertarClubs(List<Document> documentGrupos) {
		HashSet<Club> listaClubs = new HashSet<>();
		for(Document docGrupo: documentGrupos) {
			int codGrupo = docGrupo.getInteger("cod");
			
			for(Document docClub: (List<Document>) docGrupo.get("clubs")) {
				Club club = new Club();
				club.setCod(docClub.getInteger("cod"));
				club.setNombre(docClub.getString("nombre"));
				club.setSede(docClub.getString("sede"));
				club.setNum(docClub.getInteger("num"));
				club.setGrupo(session.get(Grupo.class, codGrupo));
				listaClubs.add(club);
				
			}
		}
		
		Iterator<Club> it = listaClubs.iterator();
		while(it.hasNext()) {
			Club club = (Club) it.next();
			session.save(club);
		}
	}



	private static void insertarPertenece(List<Document> documentGrupos) {
		HashSet<Pertenece> listaPertenece = new HashSet<>();
		for(Document docGrupo: documentGrupos) {
			int codGrupo = docGrupo.getInteger("cod");
			
			for(Document docArtista: (List<Document>) docGrupo.get("artistas")) {
				Pertenece pertenece = new Pertenece();
				pertenece.setArtista(session.get(Artista.class, docArtista.getString("dni")));
				pertenece.setGrupo(session.get(Grupo.class, codGrupo));
				pertenece.setFuncion(docArtista.getString("funcion"));
				listaPertenece.add(pertenece);
				
			}
		}
		
		Iterator<Pertenece> it = listaPertenece.iterator();
		while(it.hasNext()) {
			Pertenece pertenece = (Pertenece) it.next();
			session.save(pertenece);
		}
	}



	private static void insertarArtistas(List<Document> documentGrupos) {
		HashSet<Artista> listaArtistas = new HashSet<>();
		for(Document docGrupo: documentGrupos) {
			
			
			for(Document docArtista: (List<Document>) docGrupo.get("artistas")) {
				Artista artista = new Artista();
				artista.setDni(docArtista.getString("dni"));
				artista.setNombre(docArtista.getString("nombre"));
				listaArtistas.add(artista);
				
			}
		}
		
		Iterator<Artista> it = listaArtistas.iterator();
		while(it.hasNext()) {
			Artista artista = (Artista) it.next();
			session.save(artista);
		}
	}



	private static void insertarEsta(List<Document> documentGrupos) {
		HashSet<Esta> listaEsta = new HashSet<>();
		for(Document docGrupo: documentGrupos) {
			
			
			for(Document disco: (List<Document>) docGrupo.get("discos")) {
				int codDisco = disco.getInteger("cod");
				
				for(Document docCancion : (List<Document>) disco.get("canciones")) {
					Esta esta = new Esta();
					
					esta.setCancion(session.get(Cancion.class, docCancion.getInteger("cod")));
					esta.setDisco(session.get(Disco.class, codDisco));
					listaEsta.add(esta);
				}
				
			}
		}
		Iterator<Esta> it = listaEsta.iterator();
		while(it.hasNext()) {
			Esta esta = (Esta) it.next();
			session.save(esta);
		}
	}



	private static void insertarCanciones(List<Document> documentGrupos) {
		HashSet<Cancion> listaCanciones = new HashSet<>();
		for(Document docGrupo: documentGrupos) {
			
			
			for(Document disco: (List<Document>) docGrupo.get("discos")) {
				for(Document docCancion : (List<Document>) disco.get("canciones")) {
					Cancion cancion  = new Cancion();
					cancion.setCod(docCancion.getInteger("cod"));
					cancion.setDuracion((Double)docCancion.get("duracion"));
					
					cancion.setTitulo(docCancion.getString("titulo"));
					
					listaCanciones.add(cancion);
				}
				
			}
		}
		
		Iterator<Cancion> it = listaCanciones.iterator();
		while(it.hasNext()) {
			Cancion cancion = (Cancion) it.next();
			session.save(cancion);
		}
	}



	private static void insertarDiscos(List<Document> documentGrupos) {
		HashSet<Disco> listaDiscos = new HashSet<>();
		for(Document docGrupo: documentGrupos) {
			
			int codGrupo = docGrupo.getInteger("cod");
			
			for(Document docDisco: (List<Document>) docGrupo.get("discos")) {
				Document docCompanyia = (Document) docDisco.get("companyia");
				
				Disco disco = new Disco();
				disco.setCod(docDisco.getInteger("cod"));
				disco.setFecha(docDisco.getString("fecha"));
				disco.setNombre(docDisco.getString("nombre"));
				disco.setCompanyia(session.get(Companyia.class, docCompanyia.getInteger("cod")));
				disco.setGrupo(session.get(Grupo.class, codGrupo));
				
				listaDiscos.add(disco);
				
			}
			
			
			
		}
		Iterator<Disco> it = listaDiscos.iterator();
		while(it.hasNext()) {
			Disco disco = (Disco) it.next();
			session.save(disco);
		}
	}



	private static void insertarGrupos(List<Document> documentGrupos) {
		HashSet<Grupo> listaGrupos = new HashSet<>();
		for(Document docGrupo: documentGrupos) {
			
			Grupo grupo = new Grupo();
			grupo.setCod(docGrupo.getInteger("cod"));
			grupo.setFecha(docGrupo.getString("fecha"));
			grupo.setNombre(docGrupo.getString("nombre"));
			grupo.setPais(docGrupo.getString("pais"));
			
			listaGrupos.add(grupo);
			
		}
		Iterator<Grupo> it = listaGrupos.iterator();
		while(it.hasNext()) {
			Grupo grupo = (Grupo) it.next();
			session.save(grupo);
		}
	}



	private static void insertarCompanyias(List<Document> documentGrupos) {
		HashSet<Companyia> listaCompanyias = new HashSet<>();
		for(Document docGrupo: documentGrupos) {
			
			for(Document disco: (List<Document>) docGrupo.get("discos")) {
				Document docCompanyia = (Document) disco.get("companyia");
				
				Companyia companyia = new Companyia();
				companyia.setCod(docCompanyia.getInteger("cod"));
				companyia.setDir(docCompanyia.getString("dir"));
				companyia.setFax(docCompanyia.getString("fax"));
				companyia.setNombre(docCompanyia.getString("nombre"));
				companyia.setTfno(docCompanyia.getString("tfno"));
				listaCompanyias.add(companyia);
				
			}
			
		}
		Iterator<Companyia> it = listaCompanyias.iterator();
		while(it.hasNext()) {
			Companyia compa = (Companyia)it.next();
			session.save(compa);
		}
	}



	private static MongoCollection<Document> connectMongoDB() {
		MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
		
		MongoDatabase database = mongoClient.getDatabase("musica");
		
		return database.getCollection("grupos");
	}
	
	private static Session connectMySQL() {
		SessionFactory factory = UtilesHibernate.getSessionfactory();
		Session session = factory.getCurrentSession();
		
		
		
		return session;
	}
	

}
