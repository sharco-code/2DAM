import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ejercicio10hijo {

	public static void main(String[] args) {
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String str;
			
				str = br.readLine();
				System.out.println(str+((int) (Math.random() * 10) + 1));
			
			System.exit(0);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
