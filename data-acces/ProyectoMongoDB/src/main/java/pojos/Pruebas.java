package pojos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.UtilesHibernate;

public class Pruebas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = UtilesHibernate.getSessionfactory();
		Session sesion = factory.getCurrentSession();
		
		sesion.beginTransaction();
		Cancion cancion = sesion.get(Cancion.class,1);
		Club club = sesion.get(Club.class,1);
		System.out.println(club.getNombre());
		sesion.getTransaction().commit();

	}

}
