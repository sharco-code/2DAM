package hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import hibernate.UtilesHibernate;
import pojos.Ciclista;
import pojos.Equipo;

public class Ejercicio1 {

	public static void main(String[] args) {
		SessionFactory factory = UtilesHibernate.getSessionfactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		System.out.println("1. Dorsal, nombre y nombre del equipo de todos los ciclistas. \n");
		
		Query q = session.createQuery("SELECT e.dorsal, e.nombre, e.equipo.nomeq FROM Ciclista e");
		List<Object[]> lst = (List<Object[]>) q.list();
		
		if(lst == null || lst.isEmpty()) {
			System.out.println("No hay ciclistas");
			return;
		}
		
		lst.forEach(o -> {
			System.out.println("Dorsal: "+o[0]);
			System.out.println("Nombre: "+o[1]);
			System.out.println("Equipo: "+o[2]+"\n");
		});
		
		session.getTransaction().commit();
	}

}
