/*
Jose Galán Simó
2 - DAM
 */
import java.io.*;
import java.util.*;

public class Ejercicio02a {

    private static int i;

    public static void main(String[] args) throws IOException {

        Process p = new ProcessBuilder("CMD", "/C", "DIR").start();
        InputStream is = p.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);

        while ((i = isr.read()) != -1) {
            char c = (char) i;
            System.out.print(c);
        }

    }

}
