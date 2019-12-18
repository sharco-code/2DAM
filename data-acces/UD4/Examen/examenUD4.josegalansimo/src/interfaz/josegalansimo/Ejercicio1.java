package interfaz.josegalansimo;

import java.util.List;
import java.util.Scanner;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import hibernate.UtilesHibernate;
import pojos.josegalansimo.Companyia;

public class Ejercicio1 {

	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {

		SessionFactory factory = UtilesHibernate.getSessionfactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		System.out.print("Introduce nombre de compañia:");
		String nombre = scanner.nextLine();
		Query<Companyia> q = session.createQuery("SELECT e FROM Companyia e WHERE nombre LIKE :nombre");
		q.setParameter("nombre", nombre);
		List<Companyia> lst = q.list();

		if(lst == null || lst.isEmpty()) {
			System.out.println("No se encontro la compañia");
			return;
		}
		
		System.out.println(" - Discos - ");
		lst.get(0).getDiscos().forEach(e -> {
			System.out.println("-------------------");
			System.out.println(e.getNombre()+" - "+e.getFecha());
		});
		
		session.getTransaction().commit();
	}

}
