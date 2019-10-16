import java.io.*;
import java.util.*;


public class Ejercicio03 {

    public static void main(String[] args) throws IOException {

    	File dir = new File("E:\\eclipse-workspace\\Programacion_de_procesos\\bin");
		ProcessBuilder pb = new ProcessBuilder("CMD", "/E", "java Ejercicio2a");
		
		pb.directory(dir);
		
		System.out.println("Directiorio: "+pb.directory());
    	
		Process p = pb.start();;
        InputStream is = p.getInputStream();
        
        InputStreamReader isr = new InputStreamReader(is);
        int i;
        while ((i = isr.read()) != -1) {
            char c = (char) i;
            System.out.print(c);
        }
        
        isr.close();
    }
	
}



