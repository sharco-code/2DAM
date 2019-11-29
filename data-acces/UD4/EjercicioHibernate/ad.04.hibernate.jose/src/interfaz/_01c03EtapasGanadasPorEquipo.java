package interfaz;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.UtilesHibernate;
import pojos.Ciclista;
import pojos.Equipo;
import pojos.Etapa;

public class _01c03EtapasGanadasPorEquipo {

	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {

		
		SessionFactory factory = UtilesHibernate.getSessionfactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();

		System.out.print("Introduce nombre de equipo:");
		String equipo = scanner.nextLine();
		
		Equipo e = (Equipo) session.get(Equipo.class, "Banesto");
		if(e != null) {
			for (Ciclista c : e.getCiclistas()) {
				System.out.println(c.getNombre());
				if(c.getEtapasGanadas().size() == 0) System.out.println("No tiene etapas ganadas");
				else System.out.println("Etapas ganadas: "+c.getEtapasGanadas().size());
				System.out.println("----------------------");
			}
		} else System.out.println("No se ha encontrado");
		
		session.getTransaction().commit();
	}

}
