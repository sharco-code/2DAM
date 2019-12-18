package ejer2.josegalansimo;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import hibernate.UtilesHibernate;
import pojos.josegalansimo.Cancion;
import pojos.josegalansimo.Companyia;

public class A {

	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {

		SessionFactory factory = UtilesHibernate.getSessionfactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		Query<Cancion> q = session.createQuery("SELECT e FROM Cancion e WHERE duracion > 4");
		List<Cancion> lst = q.list();

		if(lst == null || lst.isEmpty()) {
			System.out.println("No se encontro canciones");
			return;
		}
		
		lst.forEach(e -> {
			System.out.println("-Titulo: "+e.getTitulo());
			System.out.println(" Discos en los que se encuentra:");
			e.getDiscos().forEach(i -> {
				System.out.println("  ----------------------");
				System.out.println("  |Disco: "+i.getNombre());
				System.out.println("  |Fecha: "+i.getFecha());
				System.out.println("  ----------------------\n\n");
			});
		});
		
		session.getTransaction().commit();
	}

}