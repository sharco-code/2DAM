import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ejercicio1hijo {

	private static int sumDigits(String num) {
		int x = 0;
		for (int i = 0; i < num.length(); i++) {
			x += Character.getNumericValue(num.charAt(i));
		}
		return x;
	}
	
	public static void main(String[] args) {

		String numero;
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String str;
			
				numero = br.readLine();
				System.out.println("(PROCESO HIJO): "+sumDigits(numero));
			
			System.exit(0);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
