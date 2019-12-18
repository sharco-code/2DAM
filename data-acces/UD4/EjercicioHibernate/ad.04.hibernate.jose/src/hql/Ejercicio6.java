package hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import hibernate.UtilesHibernate;

public class Ejercicio6 {

	public static void main(String[] args) {
		SessionFactory factory = UtilesHibernate.getSessionfactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		System.out.println("6. Número de etapa y ciudad de salida de todas las etapas de más de 100 Kms. \r\n");
		
		Query q = session.createQuery("SELECT e.netapa, e.salida FROM Etapa e WHERE km > 100");
		List<Object[]> lst = (List<Object[]>) q.list();
		
		if(lst == null || lst.isEmpty()) {
			System.out.println("No hay etapas de mas de 100 kms");
			return;
		}
		
		lst.forEach(e -> {
			System.out.println("Numero de etapa: "+e[0]);
			System.out.println("Salida: "+e[1]+"\n");
		});
		
		session.getTransaction().commit();
		
	}

}
