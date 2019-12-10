package interfaz;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.query.Query;

import hibernate.UtilesHibernate;
import pojos.Ciclista;
import pojos.Maillot;

public class _03d02MaillotsCiclista {

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
		
		System.out.println("_03d02MaillotsCiclista");
		
		Ciclista c = null;
		do {
			c = session.get(Ciclista.class, promptInt("Dorsal:"));
			if(c == null) System.out.println("[INFO] Ciclista no existe");
		} while (c == null);
		
		HashSet<Maillot> m = new HashSet<Maillot>();
		
		c.getLlevar().forEach(e -> m.add(e.getMaillot()));
		
		m.forEach(e -> {
			System.out.println("------------------------------");
			System.out.println(" - Tipo: "+e.getTipo());
			System.out.println(" - Color:   "+e.getColor());
		});
		
	}
	
	public static void main(String[] args) {
		UtilesHibernate.getSessionfactory().getCurrentSession().beginTransaction();
		
		_03d02MaillotsCiclista p = new _03d02MaillotsCiclista();
		p.programa(UtilesHibernate.getSessionfactory().getCurrentSession());
		
		UtilesHibernate.getSessionfactory().getCurrentSession().close();
	}

}