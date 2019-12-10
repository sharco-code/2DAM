package interfaz;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.UtilesHibernate;
import pojos.Ciclista;
import pojos.Equipo;

public class _02aCrearEquipo {

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
		
		Equipo e1 = new Equipo(promptString("Nombre equipo:"), promptString("Nombre director:"));
		
		try {
			session.save(e1);
			session.getTransaction().commit();
		} catch (javax.persistence.PersistenceException e) {
			System.out.println("[ERROR] Ya existe esa clave primaria");
		}
		
	}
	
	public static void main(String[] args) {
		SessionFactory factory = UtilesHibernate.getSessionfactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		_02aCrearEquipo p = new _02aCrearEquipo();
		p.programa(session);
	}

}
