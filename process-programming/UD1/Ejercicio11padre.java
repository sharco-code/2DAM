import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Scanner;

public class Ejercicio11padre {
	
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		String str1,str2;
		
		try {
			File dir = new File("E:\\eclipse-workspace\\PROCESOS\\bin");
			ProcessBuilder pb = new ProcessBuilder("CMD", "/C", "java Ejercicio11hijo");
			
			pb.directory(dir);
	    	
	        	Process process = pb.start();
				
		    	OutputStream os = process.getOutputStream();
		    	InputStream is = process.getInputStream();
		    	InputStreamReader isr = new InputStreamReader(is);
		        BufferedReader br = new BufferedReader(isr);
		        
        		System.out.print("Introduce un valor numerico (base):");
        		str1 = scanner.nextLine()+"\n";
        		
        		os.write(str1.getBytes());
                os.flush();
                
        		System.out.print("Introduce un valor numerico (potencia):");
        		str2 = scanner.nextLine()+"\n";
        		
        		os.write(str2.getBytes());
                os.flush();
                
                System.out.println(br.readLine());
                    

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
