package ejercicios2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.UtilesHibernate;
import pojos.Ciclista;
import pojos.Equipo;

public class Ej4 {

	public static void main(String[] args) {

		SessionFactory factory = UtilesHibernate.getSessionfactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		Equipo e = new Equipo();
		e.setNombre("equipo6");
		e.setDirector("direcotr2");
		
		session.save(e);
		
		Ciclista c = new Ciclista();
		c.setNombre("ciclista6");
		c.setNacimiento("1970-01-10");
		c.setEquipo(e);
		e.getCiclistas().add(c);
		
		session.save(c);
		
		session.getTransaction().commit();

	}

}
