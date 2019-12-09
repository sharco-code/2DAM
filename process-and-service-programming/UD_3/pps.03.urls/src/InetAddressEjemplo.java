import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InetAddressEjemplo {

	private static void infoInetAdress(InetAddress dir){
		System.out.println("Metodo getByNAme():" + dir);
		System.out.println("Metodo getHostName():  "+dir.getHostName());
		System.out.println("Metodo getHostAddress(): "+dir.getHostAddress());
		System.out.println("Metodo toString(): "+ dir.toString());
		System.out.println("Metodo getCanonicalHostName():"+ dir.getCanonicalHostName());
	}

	public static void main(String[] args) {
		InetAddress dir = null;
		System.out.println(".......................");
		System.out.println("SALIDA PARA LOCALHOST: ");
		try {
			dir = InetAddress.getByName("localhost");
			
			infoInetAdress(dir);
		} catch (UnknownHostException ex) {
			Logger.getLogger(InetAddressEjemplo.class.getName()).log(Level.SEVERE, null, ex);
		}
		System.out.println("===================================");
		System.out.println("SALIDA PARA \'www.google.es\': ");
		try {
			dir = InetAddress.getByName("www.google.es");
			infoInetAdress(dir);
			
			
			InetAddress [] direcciones = InetAddress.getAllByName("www.google.es");
			System.out.println("------");
			System.out.println("Listado de IP's");
			int cont = 1;
			for(InetAddress direccion:direcciones) {
				System.out.println("Indice "+cont+": "+direccion.getHostAddress());
				cont++;
			}
		} catch (UnknownHostException ex) {
			Logger.getLogger(InetAddressEjemplo.class.getName()).log(Level.SEVERE, null, ex);
		}
		

	}

}
