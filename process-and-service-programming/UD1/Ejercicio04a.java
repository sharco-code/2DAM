import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejercicio04a {

	public static void main(String[] args) {

		try {
			if(!args[0].isEmpty()) {
				System.out.println(args[0]);
				System.exit(1);
			} else System.exit(-1);
		} catch (Exception e) {
			System.exit(-1);
		}
		
		

	}

}
