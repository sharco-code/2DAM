package interfaz;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.UtilesHibernate;
import pojos.Ciclista;
import pojos.Equipo;

public class _02cCambiarDeEquipo {

	private Scanner scanner = new Scanner(System.in);
	
	private int promptInt(String msg) {
		System.out.print(msg);
		String dorsal = scanner.nextLine();
		int x = -1;
		try {
			x = Integer.parseInt(dorsal);
		} catch (Exception e) {
			System.out.println(" [ERROR] Tienes que introducir un numero");
			promptInt(msg);
		}
		return x;
	}
	
	private String promptString(String msg) {
		System.out.print(msg);
		return scanner.nextLine();
	}
	
	private void programa(Session session) {
		
		Ciclista c = null;
		do {
			c = session.get(Ciclista.class, promptInt("Introduce dorsal:"));
			if(c==null) System.out.println("[INFO] Ciclista no existe");
		} while (c == null);
		System.out.println(" - Ciclista: "+c.getNombre());
		System.out.println(" - Equipo: "+c.getEquipo().getNombre());
		
		Equipo e = null;
		do {
			e = (Equipo) session.get(Equipo.class, promptString("Nuevo equipo:"));
			if(e==null) {
				System.out.println("[INFO] Equipo no existe");
				continue;
			}
			if(e.equals(c.getEquipo())) System.out.println("[INFO] Ya es de ese equipo");
		} while (e == null);

		
		c.setEquipo(e);
		e.getCiclistas().add(c);
		
		session.save(e);
		session.getTransaction().commit();
		
		System.out.println("[INFO] Equipo modificado");
		System.out.println(" - Ciclista: "+c.getNombre());
		System.out.println(" - Equipo: "+c.getEquipo().getNombre());
	}
	
	public static void main(String[] args) {
		SessionFactory factory = UtilesHibernate.getSessionfactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		_02cCambiarDeEquipo p = new _02cCambiarDeEquipo();
		p.programa(session);
	}

}