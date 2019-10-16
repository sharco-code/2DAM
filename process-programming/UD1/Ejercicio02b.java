/*
Jose Galán Simó
2 - DAM
 */
import java.io.*;
import java.util.*;

public class Ejercicio02b {

    private static String line;
    
    public static void main(String[] args) throws IOException {
        
        Process p = new ProcessBuilder("CMD","/C","DIR").start();
        InputStream is = p.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        
        
    }

}
