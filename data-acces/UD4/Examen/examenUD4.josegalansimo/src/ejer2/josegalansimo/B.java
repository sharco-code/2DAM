package ejer2.josegalansimo;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import hibernate.UtilesHibernate;
import pojos.josegalansimo.Cancion;
import pojos.josegalansimo.Grupo;

public class B {

	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {

		SessionFactory factory = UtilesHibernate.getSessionfactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		Query<Grupo> q = session.createQuery("SELECT e FROM Grupo e");
		List<Grupo> lst = q.list();

		if(lst == null || lst.isEmpty()) {
			System.out.println("No se encontro grupos");
			return;
		}
		
		lst.forEach(e -> {
			System.out.println("-Grupo: "+e.getNombre());
			System.out.println(" Discos que ha publicado:");
			
			e.getDiscos().forEach(i -> {
				System.out.println("  ----------------------");
				System.out.println("  |Disco: "+i.getNombre());
				System.out.println("  |Compañia: "+i.getCompanyia().getNombre());
				System.out.println("  ----------------------");
			});
			System.out.println("------------------------------------------------------");
		});
		
		session.getTransaction().commit();
	}

}