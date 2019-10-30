package interfaz;

import java.util.List;
import java.util.Scanner;

import dao.DAODepartamento;
import excepciones.BusinessException;
import jdbc.ConexionJdbc;
import pojos.Departamento;

public class ConsultarDepartamentosPorNombre {
	
	private static Scanner scanner = new Scanner(System.in);
	
	private static void consultar() {
		System.out.print("Introduce texto: ");
		String input = scanner.nextLine();
		try {
			List<Departamento> lista = DAODepartamento.getDepartamentoPorNombre(input);
			if(lista!=null) {
				for (int i = 0; i < lista.size(); i++) {
					System.out.println("--------------------");
					System.out.println("ID: "+lista.get(i).getIdDepartamento());
					System.out.println("Nombre: "+lista.get(i).getNombre());
				}
			}
		} catch (BusinessException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ConexionJdbc con = new ConexionJdbc("configuracion\\Propiedades");
		con.conectar();
		
		consultar();
		
		
	}
	
}
