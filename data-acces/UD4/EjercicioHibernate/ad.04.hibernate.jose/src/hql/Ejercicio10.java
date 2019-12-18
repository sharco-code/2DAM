package hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import hibernate.UtilesHibernate;

public class Ejercicio10 {

	public static void main(String[] args) {
		SessionFactory factory = UtilesHibernate.getSessionfactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		System.out.println("10. El nombre y el equipo de los ciclistas que han ganado más de 1 etapa. \r\n");
		
		Query q = session.createQuery("SELECT e.ciclista.nombre, e.ciclista.equipo.nomeq FROM Etapa e group by e.ciclista");
		List<Object[]> lst = (List<Object[]>) q.list();
		
		if(lst == null || lst.isEmpty()) {
			System.out.println("No hay ciclistas con estos requisitos");
			return;
		}
		
		lst.forEach(e -> {
			System.out.println("Numero: "+e[0]);
			System.out.println("Equipo: "+e[1]+"\n");
		});
		
		session.getTransaction().commit();
		
	}

}
