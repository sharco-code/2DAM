package ejer3.josegalansimo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import hibernate.UtilesHibernate;
import pojos.josegalansimo.Cancion;
import pojos.josegalansimo.Companyia;
import pojos.josegalansimo.Disco;
import pojos.josegalansimo.Grupo;

public class A {

	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {

		SessionFactory factory = UtilesHibernate.getSessionfactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		
		//crear disco
		System.out.print("Crear disco\nNombre:");
		String nomnbre = scanner.nextLine();
		System.out.print("Fecha (Ej: 1981-10-12 00:00:00):");
		String fecha = scanner.nextLine();
		
				List<Grupo> lstGrupo;
				do {
					System.out.print("Grupo:");
					String grupo = scanner.nextLine();
					Query<Grupo> q = session.createQuery("SELECT e FROM Grupo e WHERE nombre LIKE :nombre");
					q.setParameter("nombre", grupo);
					lstGrupo = q.list();
					if(lstGrupo == null || lstGrupo.isEmpty()) System.out.println("Ese grupo no existe, introduce otro");
				}while(lstGrupo == null || lstGrupo.isEmpty());
				
				List<Companyia> lstCompanyia;
				do {
					System.out.print("Companyia:");
					String companyia = scanner.nextLine();
					Query<Companyia> q = session.createQuery("SELECT e FROM Companyia e WHERE nombre LIKE :nombre");
					q.setParameter("nombre", companyia);
					lstCompanyia = q.list();
					if(lstCompanyia == null || lstCompanyia.isEmpty()) System.out.println("Esa compañia no existe, introduce otro");
				}while(lstCompanyia == null || lstCompanyia.isEmpty());
		
		
		
		Disco d = new Disco();
		d.setNombre(nomnbre);
		d.setGrupo(lstGrupo.get(0));
		d.setCompanyia(lstCompanyia.get(0));
		d.setFecha(fecha);
		//crear cancion
		System.out.print("Crear cancion\nTitulo:");
		String titulo = scanner.nextLine();
		System.out.print("Duracion:");
		String duracion = scanner.nextLine();
		
		Cancion c = new Cancion();
		c.setTitulo(titulo);
		c.setDuracion(Double.parseDouble(duracion));
		List<Disco> listDiscos = new ArrayList<>();
		listDiscos.add(d);
		c.setDiscos(listDiscos);
		c.setCod(1000);
		
		List<Cancion> listCanciones = new ArrayList<>();
		listCanciones.add(c);
		d.setCancions(listCanciones);
		
		
		session.save(d);
		session.save(c);
		
		
		
		
		session.getTransaction().commit();
	}

}