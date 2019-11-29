package interfaz;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.UtilesHibernate;
import pojos.Ciclista;
import pojos.Equipo;
import pojos.Etapa;

public class _01c02EtapasGanadasPorCiclista {

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
		
		if(c != null) {
			for (Etapa e : c.getEtapasGanadas()) {
				System.out.println("Etapa: "+e.getNetapa());
				System.out.println("Ciudad Salida: "+e.getSalida());
				System.out.println("Ciudad Lkegada: "+e.getLlegada());
				System.out.println("--------------------------------");
			}
		}
		else System.out.println("No se ha encontrado");
		
		session.getTransaction().commit();
	}

}