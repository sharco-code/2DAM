package interfaz;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.UtilesHibernate;
import pojos.Ciclista;
import pojos.Etapa;

public class _01c01GanadorDeEtapa {

	private static Scanner scanner = new Scanner(System.in);
	
	private static int prompt() {
		System.out.print("Introduce numero de etapa:");
		String netapa = scanner.nextLine();
		int x = -1;
		try {
			x = Integer.parseInt(netapa);
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
		
		Etapa e = session.get(Etapa.class, prompt());
		
		if(e != null) System.out.println(e.getCiclista().getNombre());
		else System.out.println("No se ha encontrado");
		
		session.getTransaction().commit();
	}

}