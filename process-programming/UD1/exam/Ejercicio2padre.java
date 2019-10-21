import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Scanner;

public class Ejercicio2padre {

static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		String str;
		
		try {
			File dir = new File("E:\\eclipse-workspace\\examen-procesos\\bin");
			ProcessBuilder pb = new ProcessBuilder("CMD", "/C", "java Ejercicio2hijo");
			
			pb.directory(dir);
			
			Process process = pb.start();
			
	    	OutputStream os = process.getOutputStream();
	    	InputStream is = process.getInputStream();
	    	InputStreamReader isr = new InputStreamReader(is);
	        BufferedReader br = new BufferedReader(isr);
	    	
	        do {
	        	System.out.println("Introduce la cadena a codificar:");
	    		str = scanner.nextLine();
	    		if(str.equals("#")) {
	    			os.write(("#\n").getBytes());
	                os.flush();
	    			break;
	    		}
	    		System.out.println("Introduce el numero de posiciones codificar:");
	    		String posiciones = scanner.nextLine();
	    		str += ":"+posiciones;
	    		
	    		System.out.println("Introduce la tarea a realizar: Codificar (c o C) / decodificar(d o D);");
	    		String opcion = scanner.nextLine();
	    		if(opcion.equals("c") || opcion.equals("C")) {
	    			str += ":"+"c";
	    		} else if(opcion.equals("d") || opcion.equals("D")) {
	    			str += ":"+"d";
	    		}
                os.write((str+"\n").getBytes());
                os.flush();
          
                System.out.println(br.readLine());
                    
        	}while(!str.equals("#\n"));
	        System.out.println("El estado de finalizción del hijo es: "+process.waitFor());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Excepcion");
		}
	}
}
