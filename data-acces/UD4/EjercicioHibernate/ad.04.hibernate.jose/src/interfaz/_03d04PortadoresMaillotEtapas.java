package interfaz;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.query.Query;

import hibernate.UtilesHibernate;
import pojos.Etapa;
import pojos.Maillot;

public class _03d04PortadoresMaillotEtapas {

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
		
		System.out.println("_03d04PortadoresMaillotEtapas");
		
		List<Maillot> maillots;
		do {
			Query q = session.createQuery("SELECT m from Maillot m WHERE tipo LIKE :tipo");
			q.setParameter("tipo", promptString("Codigo Maillot:"));
			
			maillots = (List<Maillot>) q.list();
			if(maillots == null || maillots.isEmpty()) System.out.println("[INFO] Tipo de maillot no existe no existe");
		} while (maillots == null || maillots.isEmpty());
		
		maillots.forEach(e -> e.getLlevar().forEach(i -> {
				System.out.println("  ---------------------------------");
				System.out.println("  | - Nº etapa: "+i.getEtapa().getNetapa());
				System.out.println("  | - Ciclista: "+i.getCiclista().getNombre());
				System.out.println("  ---------------------------------\n");
			}));
		
		/*
		HashSet<Maillot> m = new HashSet<Maillot>();
		
		etapa.getLlevar().forEach(e -> m.add(e.getMaillot()));

		System.out.println("- Ciclista: "+etapa.getCiclista().getNombre());
		System.out.println("  Mallots de esa etapa:");
		System.out.println("  ---------------------");
		m.forEach(e -> {
			
			System.out.println("   - Tipo: "+e.getTipo());
			System.out.println("   - Color:   "+e.getColor());
			
			System.out.println("   ------------------------------");
			
		});
		*/
		
	}
	
	public static void main(String[] args) {
		UtilesHibernate.getSessionfactory().getCurrentSession().beginTransaction();
		
		_03d04PortadoresMaillotEtapas p = new _03d04PortadoresMaillotEtapas();
		p.programa(UtilesHibernate.getSessionfactory().getCurrentSession());
		
		UtilesHibernate.getSessionfactory().getCurrentSession().close();
	}

}