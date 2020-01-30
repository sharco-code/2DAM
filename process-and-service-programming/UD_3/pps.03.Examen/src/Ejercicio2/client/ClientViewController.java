package Ejercicio2.client;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;

import javafx.scene.control.Label;

public class ClientViewController {
	@FXML
	private Label xLabelID;
	@FXML
	private Label xLabelJugadasRealizadas;
	@FXML
	private Label xLabelTEXTO;
	@FXML
	private Button xButtonEnviar;
	@FXML
	private TextField xTextField1;
	@FXML
	private Button xButtonConectar;

	private static final int PORT = 8000;
	
	private int ID;
	private int jugadasrestantes;
	
	private Socket cliente;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	
	private List<String> resultados = new ArrayList<>();
	
	@FXML
	public void xButtonEnviarCLICK(ActionEvent event) {
		
		
		if(Integer.parseInt(this.xTextField1.getText())>19 ||Integer.parseInt(this.xTextField1.getText())<1) {
			JOptionPane.showMessageDialog(null, "(Cliente) Tienes que intruducir un numero entre 1 y 20");
			return;
		}
		
		try {
			if(Integer.parseInt(this.xTextField1.getText())==-1) {
				oos = new ObjectOutputStream(cliente.getOutputStream());
				oos.writeObject(new Integer(this.xTextField1.getText()));
				
				System.exit(0);
			}
			
			oos = new ObjectOutputStream(cliente.getOutputStream());
			oos.writeObject(new Integer(this.xTextField1.getText()));
			
			ois = new ObjectInputStream(cliente.getInputStream());
            String resultado = (String) ois.readObject();
            resultados.add(resultado);
            
            this.xLabelTEXTO.setText(resultado);
            this.xLabelJugadasRealizadas.setText(Integer.toString(Integer.parseInt(this.xLabelJugadasRealizadas.getText())+1));
            
            if(this.xLabelJugadasRealizadas.getText().equals("2")) {
            	JOptionPane.showMessageDialog(null, "(Cliente) Has llegado al maximo de jugadas, cliente se cerrará\nResultados:\n-"+resultados.get(0)+"\n-"+resultados.get(1));
            	System.exit(0);
            }
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "(Cliente) Tienes que intruducir un NUMERO entre 1 y 20");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
            e.printStackTrace();
		}
		
		
	}

	@FXML
	public void xButtonConectarCLICK(ActionEvent event) {
		
		try {
			cliente = new Socket("localhost", PORT);

			ois = new ObjectInputStream(cliente.getInputStream());
            ID = (Integer) ois.readObject();
			
			this.xLabelID.setText(ID+"");
			this.xButtonConectar.setDisable(true);
			this.xButtonEnviar.setDisable(false);
			this.xTextField1.setDisable(false);
			
			oos = new ObjectOutputStream(cliente.getOutputStream());
			oos.writeObject(new Boolean(true));
			
			ois = new ObjectInputStream(cliente.getInputStream());
            jugadasrestantes = (Integer) ois.readObject();
		} catch (Exception e) {
            JOptionPane.showMessageDialog(null, "(Cliente) No se ha podido conectar con el servidor");
		}
		

		
	}
}
