package ejer3.josegalansimo;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.UtilesHibernate;
import pojos.josegalansimo.Artista;
import pojos.josegalansimo.Cancion;
import pojos.josegalansimo.Disco;
import pojos.josegalansimo.Grupo;
import pojos.josegalansimo.Pertenece;

public class B {

	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {

		SessionFactory factory = UtilesHibernate.getSessionfactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		
		
		
		Grupo grupo = null;
		do {
			System.out.print("Codigo de grupo:");
			String codgrupo = scanner.nextLine();
			try {
				grupo = session.get(Grupo.class, Integer.parseInt(codgrupo));
			} catch (Exception e) {
				System.out.println("Grupo no existe, introduce otro");
				continue;
			}
			
			
			if(grupo==null) {
				System.out.println("Grupo no existe, introduce otro");
				continue;
			}
		}while(grupo==null);
		
		
		
		Artista artista = null;
		do {
			System.out.print("DNI Artista:");
			String dniartista = scanner.nextLine();
			artista = session.get(Artista.class, dniartista);
			if(artista==null) {
				System.out.println("Artista no existe no existe, introduce otro");
				continue;
			}
		}while(artista==null);
		
		for (Pertenece p : artista.getPertenece()) {
			if(p.getGrupo().getCod() == grupo.getCod()) {
				p.setFuncion("guitarrista");
				System.out.println("Funcion cambiada");
				break;
			}
		}
		
		
		
		session.getTransaction().commit();
	}

}