package hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import hibernate.UtilesHibernate;

public class Ejercicio14 {

	public static void main(String[] args) {
		SessionFactory factory = UtilesHibernate.getSessionfactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		System.out.println("14. El nombre de los ciclistas que han llevado más de 1 vez el maillot de tipo \"Montaña\".    \r\n");
		
		Query q = session.createQuery("SELECT e.ciclista.nombre FROM Llevar e WHERE e.maillot.tipo LIKE 'General' group by e.ciclista");
		List<String> lst = (List<String>) q.list();
		
		if(lst == null || lst.isEmpty()) {
			System.out.println("No hay ciclistas con estos requisitos");
			return;
		}
		
		lst.forEach(e -> {
			System.out.println("Ciclista: "+e);
		});
		
		session.getTransaction().commit();
		
	}

}

