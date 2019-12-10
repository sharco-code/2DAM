package ejercicios2;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.UtilesHibernate;
import interfaz._02bModificarEquipo;
import pojos.Ciclista;
import pojos.Equipo;

public class Ej5 {

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
		System.out.println("5. Eliminar equipo con todos sus ciclistas");
		do {
			e = (Equipo) session.get(Equipo.class, promptString("Nombre equipo:"));
			if(e==null) System.out.println("[INFO] Equipo no existe");
		} while (e == null);

		session.delete(e);
		session.getTransaction().commit();
		
		
		System.out.println("[INFO] Equipo y ciclistas borrado");
	}
	
	public static void main(String[] args) {
		SessionFactory factory = UtilesHibernate.getSessionfactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		Ej5 p = new Ej5();
		p.programa(session);
	}

}