package interfaz;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.UtilesHibernate;
import pojos.Ciclista;
import pojos.Equipo;
import pojos.Puerto;

public class _01d01GanadorDePuerto {

	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {

		
		SessionFactory factory = UtilesHibernate.getSessionfactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();

		System.out.print("Introduce nombre de puerto:");
		String puerto = scanner.nextLine();
		
		Puerto p = (Puerto) session.get(Puerto.class, puerto);
		
		if(p != null) {
			System.out.println(p.getGanador().getNombre());
		} else System.out.println("No se ha encontrado");
		
		session.getTransaction().commit();
	}

}
