package ejercicios2;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.UtilesHibernate;
import interfaz._02bModificarEquipo;
import pojos.Ciclista;
import pojos.Equipo;

public class Ej6 {

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
		
		Equipo equipoE = null, equipoM = null;
		System.out.println("6. Eliminar equipo y mover todos sus ciclistas");
		do {
			equipoE = (Equipo) session.get(Equipo.class, promptString("Nombre equipo a eliminar:"));
			if(equipoE==null) System.out.println("[INFO] Equipo no existe");
		} while (equipoE == null);

		do {
			equipoM = (Equipo) session.get(Equipo.class, promptString("Nombre equipo a mover ciclistas:"));
			if(equipoM==null) System.out.println("[INFO] Equipo no existe");
		} while (equipoM == null);

		for (Ciclista c : equipoE.getCiclistas()) {
			c.setEquipo(equipoM);
			session.save(c);
		}
		equipoE.getCiclistas().clear();
		session.delete(equipoE);

		session.getTransaction().commit();
		
		System.out.println("[INFO] Equipo borrado y ciclistas movidos");
	}
	
	public static void main(String[] args) {
		SessionFactory factory = UtilesHibernate.getSessionfactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		Ej6 p = new Ej6();
		p.programa(session);
	}

}