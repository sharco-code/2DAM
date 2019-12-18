package hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import hibernate.UtilesHibernate;

public class Ejercicio13 {

	public static void main(String[] args) {
		SessionFactory factory = UtilesHibernate.getSessionfactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		System.out.println("13. El nombre de los equipos y su director, de aquellos equipos que\r\n tengan más de 4 ciclistas.   \r\n");
		
		Query q = session.createQuery("SELECT e.nomeq, e.director from Equipo e WHERE size(e.ciclistas) > 4");
		List<Object[]> lst = (List<Object[]>) q.list();
		
		if(lst == null || lst.isEmpty()) {
			System.out.println("No hay puertos con estos requisitos");
			return;
		}
		
		lst.forEach(e -> {
			System.out.println("Equipo: "+e[0]);
			System.out.println("Director: "+e[1]+"\n");
		});
		
		session.getTransaction().commit();
		
	}

}
