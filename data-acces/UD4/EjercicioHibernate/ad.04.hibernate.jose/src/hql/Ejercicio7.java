package hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import hibernate.UtilesHibernate;

public class Ejercicio7 {

	public static void main(String[] args) {
		SessionFactory factory = UtilesHibernate.getSessionfactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		System.out.println("7. Número de puertos de más de 800metros de altura. \r\n");
		
		Query q = session.createQuery("SELECT count(e.nompuerto) FROM Puerto e WHERE altura > 800");
		List<Long> lst = (List<Long>) q.list();
		
		if(lst == null || lst.isEmpty()) {
			System.out.println("No hay puertos de mas de mas de 800 metros");
			return;
		}
		
		lst.forEach(e -> {
			System.out.println("Numero: "+e+"\n");
		});
		
		session.getTransaction().commit();
		
	}

}