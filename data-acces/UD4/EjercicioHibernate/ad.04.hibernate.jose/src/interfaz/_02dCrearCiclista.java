package interfaz;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.UtilesHibernate;
import pojos.Ciclista;
import pojos.Equipo;

public class _02dCrearCiclista {

	private Scanner scanner = new Scanner(System.in);
	
	private static boolean isNumeric(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException excepcion) {
            return false;
        }
    }
	
	private String askDate(String msg) {
		String d,m,y;
		System.out.println(msg);
		do {
			System.out.print("Dia:");
			d = scanner.nextLine();
		}while(!isNumeric(d) || Integer.parseInt(d) > 31 || Integer.parseInt(d) < 1);
		do {
			System.out.print("Mes:");
			m = scanner.nextLine();
		}while(!isNumeric(m) || Integer.parseInt(m) > 12 || Integer.parseInt(m) < 1);
		do {
			System.out.print("Año:");
			y = scanner.nextLine();
		}while(!isNumeric(y));
		return y+"-"+m+"-"+d;
	}
	
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
		
		
		Ciclista c = new Ciclista();
		
		Ciclista x = null;
		do {
			c.setDorsal(promptInt("Dorsal:"));
			x = session.get(Ciclista.class, c.getDorsal());
			if(x != null) System.out.println("[INFO] Ciclista ya existe");
		} while (x != null);
		
		c.setNombre(promptString("Nombre:"));
		c.setNacimiento(askDate("Introduce fecha de nacimiento:"));
		
		Equipo e = null;
		do {
			e = (Equipo) session.get(Equipo.class, promptString("Nuevo equipo:"));
			if(e==null) System.out.println("[INFO] Equipo no existe");
		} while (e == null);
		c.setEquipo(e);
		e.getCiclistas().add(c);
		
		
		session.save(e);
		session.getTransaction().commit();
		
		System.out.println("[INFO] Ciclista insertado");
		System.out.println(" - Ciclista: "+c.getNombre());
		System.out.println(" - Equipo: "+c.getEquipo().getNombre());
	}
	
	public static void main(String[] args) {
		SessionFactory factory = UtilesHibernate.getSessionfactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		_02dCrearCiclista p = new _02dCrearCiclista();
		p.programa(session);
	}

}