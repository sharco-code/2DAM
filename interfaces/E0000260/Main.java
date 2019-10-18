package E0000260;
//Jose Galan 2º DAM
public class Main {

	public static void main(String[] args) {

		Model model = new Model();
		View view = new View(model);
		Controller controlador = new Controller(model, view);
	}

}
