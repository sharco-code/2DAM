import java.io.File;
import java.io.InputStream;
import java.lang.ProcessBuilder.Redirect;
import java.util.Scanner;

public class Ejercicio05c {

private static Scanner input = new Scanner(System.in);
	
	private static String str;
	
	public static void main(String[] args) {
		
		System.out.print("Introduce argumentos para Ejercicio5a: ");
		str = input.next();
		
		File dir = new File("C:\\Users\\god\\Documents\\code\\Java\\eclipse-workspace\\Procesos\\bin");
		ProcessBuilder pb = new ProcessBuilder("CMD", "/C", "java Ejercicio5a "+str);
		
		pb.redirectOutput(Redirect.appendTo(new File("C:\\Users\\god\\Documents\\code\\Java\\eclipse-workspace\\Procesos\\bin\\output.txt")));
		pb.directory(dir);
		
		System.out.println("Directiorio: "+pb.directory());
    	
        try {
        	Process process = pb.start();
    		
            InputStream is = process.getInputStream();
            
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
