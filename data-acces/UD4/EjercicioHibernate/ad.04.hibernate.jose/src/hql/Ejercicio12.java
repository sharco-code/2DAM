package hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import hibernate.UtilesHibernate;

public class Ejercicio12 {

	public static void main(String[] args) {
		SessionFactory factory = UtilesHibernate.getSessionfactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		System.out.println("12. El nombre de los puertos de categoría \"1\" que han ganado los ciclistas del equipo \"Banesto\".  \r\n");
		
		Query q = session.createQuery("SELECT e.nompuerto FROM Puerto e WHERE e.ganador.equipo.nomeq LIKE 'Banesto' and e.categoria LIKE '1'");
		List<String> lst = (List<String>) q.list();
		
		if(lst == null || lst.isEmpty()) {
			System.out.println("No hay puertos con estos requisitos");
			return;
		}
		
		lst.forEach(e -> {
			System.out.println("Puerto: "+e);
		});
		
		session.getTransaction().commit();
		
	}

}
