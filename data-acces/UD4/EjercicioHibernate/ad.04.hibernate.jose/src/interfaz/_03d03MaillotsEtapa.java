package interfaz;

import java.util.HashSet;
import java.util.Scanner;

import org.hibernate.Session;

import hibernate.UtilesHibernate;
import pojos.Ciclista;
import pojos.Etapa;
import pojos.Maillot;

public class _03d03MaillotsEtapa {

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
		
		Etapa etapa = null;
		do {
			etapa = session.get(Etapa.class, promptInt("Nº Etapa:"));
			if(etapa == null) System.out.println("[INFO] Etapa no existe");
		} while (etapa == null);
		
		
		etapa.getLlevar().forEach(e -> {
			System.out.println("- Ciclista: "+e.getCiclista().getNombre());
			System.out.println("  -------------------------");
			System.out.println("  | - Tipo: "+e.getMaillot().getTipo());
			System.out.println("  |- Color: "+e.getMaillot().getColor());
			System.out.println("  -------------------------\n");
		});
		
	}
	
	public static void main(String[] args) {
		UtilesHibernate.getSessionfactory().getCurrentSession().beginTransaction();
		
		_03d03MaillotsEtapa p = new _03d03MaillotsEtapa();
		p.programa(UtilesHibernate.getSessionfactory().getCurrentSession());
		
		UtilesHibernate.getSessionfactory().getCurrentSession().close();
	}

}