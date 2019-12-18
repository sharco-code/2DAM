package hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import hibernate.UtilesHibernate;

public class Ejercicio3 {

	public static void main(String[] args) {
		SessionFactory factory = UtilesHibernate.getSessionfactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		Query q = session.createQuery("SELECT e.nombre, e.nacimiento, e.equipo.director FROM Ciclista e");
		List<Object[]> lst = (List<Object[]>) q.list();
		
		System.out.println("3. Nombre, edad y director de todos los ciclistas. \n");
		
		if(lst == null || lst.isEmpty()) {
			System.out.println("No hay ciclistas");
			return;
		}
		
		lst.forEach(o -> {
			System.out.println("Dorsal: "+o[0]);
			System.out.println("Edad: "+o[1]);
			System.out.println("Director: "+o[2]+"\n");
		});
		
		session.getTransaction().commit();
	}

}
