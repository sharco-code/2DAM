package interfaz;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.UtilesHibernate;
import pojos.Etapa;
import pojos.Puerto;

public class _01d03GanadoresDeEtapayPuerto {

	private static <T> List<T> loadAllData(Class<T> type, Session session) {
	    CriteriaBuilder builder = session.getCriteriaBuilder();
	    CriteriaQuery<T> criteria = builder.createQuery(type);
	    criteria.from(type);
	    List<T> data = session.createQuery(criteria).getResultList();
	    return data;
	  }
	
	public static void main(String[] args) {
		SessionFactory factory = UtilesHibernate.getSessionfactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		List<Etapa> e = loadAllData(Etapa.class, session);
		
		System.out.println("_Ciclistas que han ganado alguna etapa_");
		System.out.println("_______________________________________");
		if(e != null) {
			for (Etapa etapa : e) {
				System.out.println("Ciclista: "+etapa.getCiclista().getNombre());
				for (Puerto puerto : etapa.getPuertos()) {
					System.out.println(" - Puerto: "+puerto.getNompuerto());
				}
				System.out.println("------------------------------------------");
			}
		}
		else System.out.println("No se ha encontrado");
		
		session.getTransaction().commit();

	}

}
