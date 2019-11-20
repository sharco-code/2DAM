import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Ejercicio2hijo {

	static Scanner scanner = new Scanner(System.in);

	static String c(String str, int n) {
		StringBuilder sb = new StringBuilder();
		String resultado;
		n = n % 26;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
				if ((str.charAt(i) + n) > 'z') sb.append((char) (str.charAt(i) + n - 26));
				else sb.append((char) (str.charAt(i) + n));
				
			} else if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
				if ((str.charAt(i) + n) > 'Z') sb.append((char) (str.charAt(i) + n - 26));
				else sb.append((char) (str.charAt(i) + n));
			}
		}
		resultado = sb.toString();
		return resultado;
	}

	static String d(String str, int n) {
		StringBuilder sb = new StringBuilder();
		String resultado;
		n = n % 26;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
				if ((str.charAt(i) - n) < 'a') sb.append((char) (str.charAt(i) - n + 26));
				else sb.append((char) (str.charAt(i) - n));
			} else if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
				if ((str.charAt(i) - n) < 'A') sb.append((char) (str.charAt(i) - n + 26));
				else sb.append((char) (str.charAt(i) - n));
			}
		}
		resultado = sb.toString();
		return resultado;
	}

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

				if (x[2].equals("c")) System.out.println("El resultado es: "+c(x[0], Integer.parseInt(x[1]))); 
				else System.out.println("El resultado es: "+d(x[0], Integer.parseInt(x[1])));

			} while (!str.equals("#"));

			System.exit(0);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
