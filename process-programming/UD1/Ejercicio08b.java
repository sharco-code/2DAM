import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Scanner;

public class Ejercicio08b {

	static Scanner scanner = new Scanner(System.in);
	static String str, line;
	
	public static void main(String[] args) {
		
		File dir = new File("E:\\eclipse-workspace\\PROCESOS\\bin");
		ProcessBuilder pb = new ProcessBuilder("CMD", "/C", "java Ejercicio8a");
		
		pb.redirectError(new File("E:\\output.txt"));
		pb.directory(dir);
		
        try {
        	Process process = pb.start();
    		
        	OutputStream os = process.getOutputStream();
        	InputStream is = process.getInputStream();
        	InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
        	String str;
        	
    		System.out.print("(PROCESO PADRE) texto:");
    		str = scanner.next();
    		str+="\n";
            os.write(str.getBytes());
            os.flush();
      
            System.out.println(br.readLine());
            

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
