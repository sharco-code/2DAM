import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ejercicio11hijo {
	
	public static void main(String[] args) {

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String str1, str2;

				str1 = br.readLine();
				str2 = br.readLine();
				
				System.out.println(str1+"^"+str2+"="+Math.pow(Double.parseDouble(str1), Double.parseDouble(str2)));
				
			System.exit(0);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
