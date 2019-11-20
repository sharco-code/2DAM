import java.io.*;
import java.util.*;

public class Ejercicio04b {
	
	private static String line;
	
	private static int conValor(String valor) throws IOException, InterruptedException {

		Process p = new ProcessBuilder("CMD", "/C", "C:\\Users\\god\\Documents\\code\\Java\\eclipse-workspace\\Procesos\\src\\java Ejercicio4a "+ valor).start();
		InputStream is = p.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
		
        try {
			return p.waitFor();
		} catch (InterruptedException e) {
			throw new InterruptedException("error");
		}
	}
	
	private static int sinValor() throws IOException, InterruptedException {
		Process p = new ProcessBuilder("CMD", "/C", "C:\\Users\\god\\Documents\\code\\Java\\eclipse-workspace\\Procesos\\src\\java Ejercicio4a").start();
		InputStream is = p.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
		
        try {
			return p.waitFor();
		} catch (InterruptedException e) {
			throw new InterruptedException("error");
		}
	}
	
	public static void main(String[] args) {
		
		try {
			System.out.println("Con Valor: "+conValor("hola"));
			System.out.println("Sin Valor: "+sinValor());
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
