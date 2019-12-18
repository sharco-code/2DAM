package hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import hibernate.UtilesHibernate;

public class Ejercicio8 {

	public static void main(String[] args) {
		SessionFactory factory = UtilesHibernate.getSessionfactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		System.out.println("8. Nombre, pendiente y altura de todos los puertos de más de 1.200 metros de altura de categoría especial (\"E\").  \r\n");
		
		Query q = session.createQuery("SELECT e.nompuerto, e.pendiente, e.altura FROM Puerto e WHERE altura > 800 and categoria LIKE 'E'");
		List<Object[]> lst = (List<Object[]>) q.list();
		
		if(lst == null || lst.isEmpty()) {
			System.out.println("No hay puertos de mas de mas de 1200 metros de categoria E");
			return;
		}
		
		lst.forEach(e -> {
			System.out.println("Numero: "+e[0]);
			System.out.println("Pendiente: "+e[1]);
			System.out.println("Altura: "+e[2]+"\n");
		});
		
		session.getTransaction().commit();
		
	}

}