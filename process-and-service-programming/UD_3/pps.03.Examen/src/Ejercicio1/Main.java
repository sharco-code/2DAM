package Ejercicio1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {

	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		try {
			System.out.println("Direccion IP local: "+Inet4Address.getLocalHost().getHostAddress());
			String string = "";
			do {
				
				
				System.out.print("Introduce una URL:");
				string = scanner.nextLine();
				if(string.equals("*")) break;
				
				if(!string.contains("http")) string = "http://" + string;
				URL url = new URL(string);
				
				InetAddress inetAddress = InetAddress.getByName(url.getHost());
				System.out.println("\nIP de la URL de "+url.getHost()+" es: "+inetAddress.getHostAddress()+"\n");
				
				URLConnection urlConnection = url.openConnection();
				
				BufferedReader bf = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
				
				for (int i = 1; i < 4; i++) {
					System.out.println("Linea "+i+" -> "+bf.readLine());
				}
				
				System.out.println("\nProtocolo: "+url.getProtocol()+"\n");
			}while(!string.equals("*"));
			
			System.out.println("\nFin de la ejecucion");
			
		} catch (Exception e) {
			System.out.println("No se ha podido conectar a la url");
		}
	}
}
