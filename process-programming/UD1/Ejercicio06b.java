import java.io.BufferedWriter;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Ejercicio06b {

	public static void main(String[] args) {
			
		File dir = new File("E:\\eclipse-workspace\\Programacion_de_procesos\\bin");
		ProcessBuilder pb = new ProcessBuilder("CMD", "/C", "java Ejercicio6a ");
		
		pb.directory(dir);
		
		System.out.println("[Ejercicio6b] Directiorio: "+pb.directory());
    	
        try {
        	Process process = pb.start();
    		
        	OutputStream os = process.getOutputStream();
            os.write("hola\n".getBytes());
            os.flush();
        	
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
