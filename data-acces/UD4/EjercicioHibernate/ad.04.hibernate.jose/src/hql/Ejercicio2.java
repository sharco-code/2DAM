package hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import hibernate.UtilesHibernate;

public class Ejercicio2 {

	public static void main(String[] args) {
		SessionFactory factory = UtilesHibernate.getSessionfactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		System.out.println("2. Nombre y edad de todos los ciclistas del equipo \"Banesto\". \r\n");
		
		Query q = session.createQuery("SELECT e.nombre, e.nacimiento FROM Ciclista e WHERE equipo.nomeq LIKE 'Banesto'");
		List<Object[]> lst = (List<Object[]>) q.list();
		
		if(lst == null || lst.isEmpty()) {
			System.out.println("No hay ciclistas de banesto");
			return;
		}
		
		lst.forEach(o -> {
			System.out.println("Nombre: "+o[0]);
			System.out.println("Edad: "+o[1]+"\n");
		});
		
		session.getTransaction().commit();
	}

}
