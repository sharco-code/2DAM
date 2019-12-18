package hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import hibernate.UtilesHibernate;
import pojos.Ciclista;

public class Ejercicio5 {

	public static void main(String[] args) {
		SessionFactory factory = UtilesHibernate.getSessionfactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		System.out.println("5. Nombre y equipo de todos los ciclistas que hayan ganado al menos una etapa. \r\n");
		
		Query q = session.createQuery("SELECT e.ciclista.nombre, e.ciclista.equipo.nomeq FROM Etapa e");
		List<Object[]> lst = (List<Object[]>) q.list();
		
		if(lst == null || lst.isEmpty()) {
			System.out.println("No hay ciclistas que han ganado etapas");
			return;
		}
		
		lst.forEach(e -> {
			System.out.println("Nombre: "+e[0]);
			System.out.println("Equipo: "+e[1]+"\n");
		});
		
		session.getTransaction().commit();
		
	}

}
