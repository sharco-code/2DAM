import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Scanner;

public class Ejercicio07b {

	static Scanner scanner = new Scanner(System.in);
	static String str, line;
	
	public static void main(String[] args) {
		File dir = new File("E:\\eclipse-workspace\\Programacion_de_procesos\\bin");
		ProcessBuilder pb = new ProcessBuilder("CMD", "/C", "java Ejercicio7a");
		
		pb.directory(dir);
		
        try {
        	Process process = pb.start();
    		
        	OutputStream os = process.getOutputStream();
        	InputStream is = process.getInputStream();
        	InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
        	String str;
        	do {
        		System.out.print("(PROCESO PADRE) Introduce una cadena de texto:");
        		str = scanner.next();
        		str+="\n";
                os.write(str.getBytes());
                os.flush();
          
                    System.out.println(br.readLine());
                    
        	}while(!str.equals("*\n"));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
