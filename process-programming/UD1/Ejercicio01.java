import java.io.IOException;

public class Ejercicio01 {

        private static void process(String command) throws IOException, InterruptedException {
        
        ProcessBuilder pb = new ProcessBuilder(command);
        
        try {
            Process process = pb.start();
            int x = process.waitFor();
            System.out.println("Ejecución: "+x);
        } catch (IOException e) {
            throw new IOException("IOException");
        } catch (InterruptedException e) {
            throw new InterruptedException("Interrupted Exception");
        }
        
        
    }
    
    public static void main(String[] args) {
        
        try {
            process("notepad");
        } catch (Exception e) {
            System.out.println("Error");
        }
        
        
    }
    
}
