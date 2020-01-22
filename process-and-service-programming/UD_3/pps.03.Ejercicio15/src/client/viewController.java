package client;

import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Numero;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javafx.event.ActionEvent;

public class viewController {
	@FXML
	private Button xButtonConnectar;
	@FXML
	private Button xButtonCalcular;
	@FXML
	private TextField xTextFieldNumero;
	@FXML
	private TextField xTextFieldCubo;
	@FXML
	private TextField xTextFieldCuadrado;
	@FXML
	private Button xButtonSalir;
	@FXML
	private Label xLabelInfo;

	private static final int PORT = 9876;

	private static Socket socket = null;
	private static ObjectOutputStream objetOutputStream = null;
	private static ObjectInputStream objetInputStream = null;
	
	// Event Listener on Button[#xButtonConnectar].onAction
	@FXML
	public void xButtonConnectar(ActionEvent event) {
		try {
			socket = new Socket("localhost", PORT);
			xButtonConnectar.setDisable(true);
			xButtonCalcular.setDisable(false);
			xLabelInfo.setVisible(true);
			System.out.println("Conectado al servidor");
		} catch (Exception e) {
			System.out.println("No se ha podido conectar");
		}
		
	}
	// Event Listener on Button[#xButtonCalcular].onAction
	@FXML
	public void xButtonCalcular(ActionEvent event) {
		
		Numero n = new Numero();
        if(xTextFieldNumero.getText().isEmpty()) {
			System.out.println("Esta vacio");
			return;
		}
        if(xTextFieldNumero.getText().equals("0")) {
			xButtonSalir.setDisable(false);
			return;
		}
        n.setNumero(Integer.parseInt(xTextFieldNumero.getText()));

		try {
			objetOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objetOutputStream.writeObject(n);

            objetInputStream = new ObjectInputStream(socket.getInputStream());
            
            n = (Numero) objetInputStream.readObject();
            xTextFieldCuadrado.setText(""+n.getCuadrado());
            xTextFieldCubo.setText(""+n.getCubo());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void xButtonSalir(ActionEvent event) {
		
	}
}
