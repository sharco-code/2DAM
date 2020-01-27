package client;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Numero;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import javafx.event.ActionEvent;

import javafx.scene.control.Label;

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
	private Label xLabelInfo;
	@FXML
	private Label xLabelID;
	
	private static Integer idClient;
	
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
			
			//recibir id
			objetInputStream = new ObjectInputStream(socket.getInputStream());
			this.idClient = (Integer) objetInputStream.readObject();
			System.out.println("(CLIENTE) cliente conectado [ID asignada: "+idClient+"]");
			this.xLabelID.setText(idClient+"");
			
			//enviar confirmacion
			objetOutputStream = new ObjectOutputStream(socket.getOutputStream());
			objetOutputStream.writeObject(new Boolean(true));
			
			
		} catch (Exception e) {
			System.out.println("(CLIENTE) No se ha podido conectar");
		}
	}
	
	// Event Listener on Button[#xButtonCalcular].onAction
	@FXML
	public void xButtonCalcular(ActionEvent event) {
		
		Numero n = new Numero();
        if(xTextFieldNumero.getText().isEmpty()) {
			System.out.println("(CLIENTE) Esta vacio");
			return;
		}

        n.setNumero(Integer.parseInt(xTextFieldNumero.getText()));

		try {
			objetOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objetOutputStream.writeObject(n);

            if(!xTextFieldNumero.getText().equals("0")) {
            	 objetInputStream = new ObjectInputStream(socket.getInputStream());
                 
                 n = (Numero) objetInputStream.readObject();
                 xTextFieldCuadrado.setText(""+n.getCuadrado());
                 xTextFieldCubo.setText(""+n.getCubo());
    		}
           
		}catch(Exception e) {
			e.printStackTrace();
		}
		if(xTextFieldNumero.getText().equals("0")) {
			System.exit(0);
		}
	}
	
}