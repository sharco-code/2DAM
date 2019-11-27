package _02ejemplos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.UtilesHibernate;
import pojos.Equipo;

public class CargarEquipo {

	public static void main(String[] args) {
		SessionFactory factory = UtilesHibernate.getSessionfactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		Equipo e = (Equipo) session.get(Equipo.class, "Banesto");
		if(e != null)  System.out.println(e.getCiclistas().get(0));
		
		session.getTransaction().commit();

	}

}
