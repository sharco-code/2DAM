package hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import hibernate.UtilesHibernate;

public class Ejercicio9 {

	public static void main(String[] args) {
		SessionFactory factory = UtilesHibernate.getSessionfactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		System.out.println("9. Número de etapa, número de puertos en la etapa y media de altura de los puertos de todas las etapas.   \r\n");
		
		/* No tiene sentido pedir datos sobre unos registros en base a la etapa (Número de etapa, número de puertos en la etapa)
		 * y luego pedir UN dato sobre todos los registros (de los puertos de todas las etapas), ya que esto solo devolvera 1 fila
		 * 
		 * Voy a mostrar solo los numeros de etapas y numeros de puertos en esa etapa
		 */
		
		Query q = session.createQuery("SELECT e.etapa.netapa, count(e) FROM Puerto e group by e.etapa");
		List<Object[]> lst = (List<Object[]>) q.list();
		
		if(lst == null || lst.isEmpty()) {
			System.out.println("No hay etapas");
			return;
		}
		
		lst.forEach(e -> {
			System.out.println("Numero de etapa: "+e[0]);
			System.out.println("Numero de puertos en esa etapa: "+e[1]+"\n");
			//System.out.println("Media de altura de puertos de todas las etapas: "+e[3]);
		});
		
		session.getTransaction().commit();
		
	}

}