import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Scanner;

public class Ejercicio09padre {
	
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		String str;
		
		try {
			File dir = new File("E:\\eclipse-workspace\\PROCESOS\\bin");
			ProcessBuilder pb = new ProcessBuilder("CMD", "/C", "java Ejercicio9hijo");
			
			pb.directory(dir);
			
			Process process = pb.start();
			
	    	OutputStream os = process.getOutputStream();
	    	InputStream is = process.getInputStream();
	    	InputStreamReader isr = new InputStreamReader(is);
	        BufferedReader br = new BufferedReader(isr);
	    	
	        do {
        		System.out.print("(PROCESO PADRE) Introduce una cadena de texto:");
        		str = scanner.next()+"\n";
                os.write(str.getBytes());
                os.flush();
          
                System.out.println(br.readLine());
                    
        	}while(!str.equals("fin\n"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
