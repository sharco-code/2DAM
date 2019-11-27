package _02ejemplos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import hibernate.UtilesHibernate;
import pojos.Equipo;

public class ListarEquipos {

	public static void main(String[] args) {
		SessionFactory factory = UtilesHibernate.getSessionfactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		Query q = session.createQuery("SELECT e FROM Equipo e");
		List<Equipo> lst = (List<Equipo>) q.list();
		
		for (Equipo equipo : lst) {
			System.out.println(""+equipo.getNombre()+" - "+equipo.getDirector());
		}
	}

}
