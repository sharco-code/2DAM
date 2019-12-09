
import java.net.InetAddress;
import java.util.Scanner;

public class Ejercicio02 {
	
	private static Scanner scanner = new Scanner(System.in);
	
	private static void pruebaMetodos(InetAddress ia){
		System.out.println("Metodo getByNAme():" + ia);
		System.out.println("Metodo getHostName():  "+ia.getHostName());
		System.out.println("Metodo getHostAddress(): "+ia.getHostAddress());
		System.out.println("Metodo toString(): "+ ia.toString());
		System.out.println("Metodo getCanonicalHostName():"+ ia.getCanonicalHostName());
	}

	public static void main(String[] args) {
		InetAddress dir = null;
		int option;
		String ip, host;
		System.out.println("1) IP");
		System.out.println("2) HOST\nSelecciona opcion:");
		option = scanner.nextInt();
		
		switch(option) {
			case 1:
				System.out.print("Introduce IP:");
				ip = scanner.next();
				try {
					dir = InetAddress.getByName(ip);
					pruebaMetodos(dir);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 2:
				System.out.print("Introduce HOST:");
				host = scanner.next();
				try {
					dir = InetAddress.getByName(host);
					pruebaMetodos(dir);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;

		}
	}

}
