
public class Ejercicio05a {

	public static void main(String[] args) {
		
		if(args.length == 0) {
			System.out.println("No se ha enviado ningun argumento");
			System.exit(1);
		} else if (args.length == 1) {
			for (int i = 0; i < 5; i++) {
				System.out.println(args[0]);
			}
		} else {
			System.out.println("Se ha enviado mas de un argumento");
			System.exit(1);
		}

		
	}

}
