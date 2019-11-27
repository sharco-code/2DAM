package _02ejemplos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.UtilesHibernate;
import pojos.Equipo;

public class AnyadirEquipo {

	public static void main(String[] args) {
		SessionFactory factory = UtilesHibernate.getSessionfactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		Equipo e1 = new Equipo("dam1", "Javier Garcia");
		session.save(e1);
		
		session.getTransaction().commit();
	}

}
