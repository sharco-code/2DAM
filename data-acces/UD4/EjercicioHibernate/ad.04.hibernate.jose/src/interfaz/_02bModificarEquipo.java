package interfaz;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.UtilesHibernate;
import pojos.Equipo;

public class _02bModificarEquipo {

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
		
		Equipo e = null;
		
		do {
			e = (Equipo) session.get(Equipo.class, promptString("Nombre equipo:"));
			if(e==null) System.out.println("[INFO] Equipo no existe");
		} while (e == null);

		
		String director = promptString("Nombre director:");
		e.setDirector(director);
		
		session.save(e);
		session.getTransaction().commit();
		
		System.out.println("[INFO] Nombre modificado");
	}
	
	public static void main(String[] args) {
		SessionFactory factory = UtilesHibernate.getSessionfactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		_02bModificarEquipo p = new _02bModificarEquipo();
		p.programa(session);
	}

}