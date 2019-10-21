import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Scanner;

public class Ejercicio1padre {

	static Scanner scanner = new Scanner(System.in);
	
	private static boolean isNumeric(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException excepcion) {
            return false;
        }
    }
	
	public static void main(String[] args) {
		String str;
		
		try {
			File dir = new File("E:\\eclipse-workspace\\examen-procesos\\bin");
			ProcessBuilder pb = new ProcessBuilder("CMD", "/C", "java Ejercicio1hijo");
			
			pb.directory(dir);
	    	
	        do {
	        	Process process = pb.start();
				
		    	OutputStream os = process.getOutputStream();
		    	InputStream is = process.getInputStream();
		    	InputStreamReader isr = new InputStreamReader(is);
		        BufferedReader br = new BufferedReader(isr);
	        	
		        System.out.print("(PROCESO PADRE): Introduce un valor numerico de 5 cifras:");
        		str = scanner.next();
        		if(str.length()!=5) continue;
        		if(str.equals("99999")) break;
        		str+="\n";
                os.write(str.getBytes());
                os.flush();
          
                System.out.println(br.readLine());
                
                System.out.println("El estado de finalizción del hijo es: "+process.waitFor());
                
        	}while(!str.equals("99999\n"));

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
