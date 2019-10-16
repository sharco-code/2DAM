import java.io.File;
import java.io.InputStream;

public class Ejercicio05d {
	
	public static void main(String[] args) {
		
		ProcessBuilder pb = new ProcessBuilder("java");
		
		pb.redirectInput(new File("E:\\input.txt"));
		
    	
        try {
        	Process process = pb.start();
    		
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
