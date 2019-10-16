import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Ejercicio05b {

	private static Scanner input = new Scanner(System.in);
	
	private static String str;
	
	public static void main(String[] args) {
		
		System.out.print("Introduce argumentos para Ejercicio5a: ");
		str = input.next();
		
		File dir = new File("E:\\eclipse-workspace\\Programacion_de_procesos\\bin");
		ProcessBuilder pb = new ProcessBuilder("CMD", "/C", "java Ejercicio5a "+str);
		
		pb.directory(dir);
		
		System.out.println("Directiorio: "+pb.directory());
    	
        try {
        	Process process = pb.start();
    		
            InputStream is = process.getInputStream();
            
        	int i;
            while ((i = is.read()) != -1) {
                char c = (char) i;
                System.out.print(c);
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
