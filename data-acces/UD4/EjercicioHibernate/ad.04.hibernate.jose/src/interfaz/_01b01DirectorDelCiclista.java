package interfaz;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.UtilesHibernate;
import pojos.Ciclista;
import pojos.Equipo;

public class _01b01DirectorDelCiclista {

	private static Scanner scanner = new Scanner(System.in);
	
	private static int prompt() {
		System.out.print("Introduce dorsal:");
		String dorsal = scanner.nextLine();
		int x = -1;
		try {
			x = Integer.parseInt(dorsal);
		} catch (Exception e) {
			System.out.println(" [ERROR] Tienes que introducir un numero");
			prompt();
		}
		return x;
	}
	
	public static void main(String[] args) {

		SessionFactory factory = UtilesHibernate.getSessionfactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		Ciclista c = (Ciclista) session.get(Ciclista.class, prompt());
		
		if(c != null) System.out.println(c.getEquipo().getDirector());
		else System.out.println("No se ha encontrado");
		
		session.getTransaction().commit();
	}

}
