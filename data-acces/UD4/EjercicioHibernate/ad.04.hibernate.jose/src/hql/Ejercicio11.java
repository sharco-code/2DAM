package hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import hibernate.UtilesHibernate;

public class Ejercicio11 {

	public static void main(String[] args) {
		SessionFactory factory = UtilesHibernate.getSessionfactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		System.out.println("11. El número de veces que el ciclista \"Pedro Delgado\" ha llevado el maillot de tipo \"General\".  \r\n");
		
		Query q = session.createQuery("SELECT count(e) FROM Llevar e WHERE e.ciclista.nombre LIKE 'Pedro Delgado' and e.maillot.tipo LIKE 'General' group by e.ciclista");
		List<Long> lst = (List<Long>) q.list();
		
		if(lst == null || lst.isEmpty()) {
			System.out.println("No hay ciclistas con estos requisitos");
			return;
		}
		
		lst.forEach(e -> {
			System.out.println("Numero: "+e);
		});
		
		session.getTransaction().commit();
		
	}

}
