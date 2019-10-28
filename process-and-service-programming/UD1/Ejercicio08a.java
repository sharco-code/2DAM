import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ejercicio08a {

	public static boolean f(String str) {
		String strAlReves = "";
		for (int i = str.length()-1; i >= 0; i--) {
			strAlReves += str.charAt(i);
		}
		if(str.equals(strAlReves)) return true;
		return false;
	}

	public static void main(String[] args) {
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String str;
			
			str = br.readLine();
			if(str.length() == 0) System.exit(-1);
			else if(f(str)) System.out.println("Es palindromo");
			else System.out.println("No es palindromo");
			
			System.exit(0);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
