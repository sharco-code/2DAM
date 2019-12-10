package interfaz;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.UtilesHibernate;
import pojos.Ciclista;
import pojos.Equipo;
import pojos.Llevar;
import pojos.Maillot;

public class _03d01PortadoresMaillot {

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
		
		System.out.println("_03d01PortadoresMaillot");
		List<Maillot> maillots;
		do {
			Query q = session.createQuery("SELECT m from Maillot m WHERE tipo LIKE :tipo");
			q.setParameter("tipo", promptString("Codigo Maillot:"));
			
			maillots = (List<Maillot>) q.list();
			if(maillots == null || maillots.isEmpty()) System.out.println("[INFO] Tipo de maillot no existe no existe");
		} while (maillots == null || maillots.isEmpty());
		
		HashSet<Ciclista> ciclistas = new HashSet<Ciclista>();
		
		maillots.forEach(e -> e.getLlevar().forEach(i -> ciclistas.add(i.getCiclista())));
		
		ciclistas.forEach(e -> {
			System.out.println("------------------------------");
			System.out.println(" - Ciclista: "+e.getNombre());
			System.out.println(" - Equipo:   "+e.getEquipo().getNombre());
		});
		
	}
	
	public static void main(String[] args) {
		UtilesHibernate.getSessionfactory().getCurrentSession().beginTransaction();
		
		_03d01PortadoresMaillot p = new _03d01PortadoresMaillot();
		p.programa(UtilesHibernate.getSessionfactory().getCurrentSession());
		
		UtilesHibernate.getSessionfactory().getCurrentSession().close();
	}

}