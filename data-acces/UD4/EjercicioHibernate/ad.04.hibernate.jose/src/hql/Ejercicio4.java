package hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import hibernate.UtilesHibernate;
import pojos.Ciclista;

public class Ejercicio4 {

	public static void main(String[] args) {
		SessionFactory factory = UtilesHibernate.getSessionfactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		System.out.println("4. Todos los ciclistas del equipo \"TVM\". \n");
		
		Query q = session.createQuery("SELECT e FROM Ciclista e WHERE e.equipo.nomeq LIKE 'TVM'");
		List<Ciclista> lst = (List<Ciclista>) q.list();
		
		if(lst == null || lst.isEmpty()) {
			System.out.println("No hay ciclistas de TVM");
			return;
		}
		
		lst.forEach(e -> {
			System.out.println("Dorsal: "+e.getDorsal());
			System.out.println("Nombre: "+e.getNombre());
			System.out.println("Nacimiento: "+e.getNacimiento()+"\n");
		});
		
	}

}
