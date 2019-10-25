package lambda_version;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

interface Code {
	String f(String s, int n);
}

public class Ejercicio2hijo {

	static Scanner scanner = new Scanner(System.in);

	static String[] getMsg(String str) {
		String[] x;
		x = str.split(":");
		return x;
	}

	public static void main(String[] args) {

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String str;
			do {
				str = br.readLine();
				String[] x = getMsg(str);
				
				Code code = x[2].equals("c") ? (s, n) -> {
					n = n % 26;
					StringBuilder sb = new StringBuilder();
					for (int i = 0; i < s.length(); i++) {
						if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
							if ((s.charAt(i) + n) > 'z') sb.append((char) (s.charAt(i) + n - 26));
							else sb.append((char) (s.charAt(i) + n));
						} else if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
							if ((s.charAt(i) + n) > 'Z') sb.append((char) (s.charAt(i) + n - 26));
							else sb.append((char) (s.charAt(i) + n));
						}
					}
					return sb.toString();
				} : (s, n) -> {
					n = n % 26;
					StringBuilder sb = new StringBuilder();
					for (int i = 0; i < s.length(); i++) {
						if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
							if ((s.charAt(i) - n) < 'a') sb.append((char) (s.charAt(i) - n + 26));
							else sb.append((char) (s.charAt(i) - n));
						} else if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
							if ((s.charAt(i) - n) < 'A') sb.append((char) (s.charAt(i) - n + 26));
							else sb.append((char) (s.charAt(i) - n));
						}
					}
					return sb.toString();
				};
				
				System.out.println("El resultado es: "+code.f(x[0], Integer.parseInt(x[1])));
				

			} while (!str.equals("#"));

			System.exit(0);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
