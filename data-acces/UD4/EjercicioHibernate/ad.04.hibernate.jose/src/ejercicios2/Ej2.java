package ejercicios2;

import java.text.SimpleDateFormat;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.UtilesHibernate;
import interfaz._02dCrearCiclista;
import pojos.Ciclista;
import pojos.Equipo;

public class Ej2 {
	
	public static void main(String[] args) {
		SessionFactory factory = UtilesHibernate.getSessionfactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		Equipo e = new Equipo();
		e.setNombre("equipo2");
		e.setDirector("direcotr2");
		
		Ciclista c = new Ciclista();
		c.setNombre("ciclista2");
		c.setNacimiento("1970-01-10");
		c.setEquipo(e);
		e.getCiclistas().add(c);
		
		session.save(c);
		
		session.getTransaction().commit();
	}

}