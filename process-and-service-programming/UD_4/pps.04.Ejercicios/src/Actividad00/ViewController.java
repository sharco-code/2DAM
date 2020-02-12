package Actividad00;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

import javafx.scene.control.TextArea;

import javafx.scene.control.PasswordField;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

public class ViewController {
	@FXML
	private Button xButtonConnectar;
	@FXML
	private Button xButtonSalir;
	@FXML
	private Label xLabelInfo;
	@FXML
	private TextField xTextFieldServidor;
	@FXML
	private TextField xTextFieldUsuario;
	@FXML
	private PasswordField xTextFieldPassword;
	@FXML
	private TextArea xTextAreaPrincipal;
	@FXML
	private Button xButtonSubirArchivo;
	@FXML
	private Label xLabelSTATUS;
	@FXML
	private Button xButtonDesconectar;

	private String URL;
	
	private final String TYPES[] = {"FILE", "DIR ", "LINK"};
	
	private FTPClient client = new FTPClient();
	
	
	
	private void login(FTPClient client) throws IOException {
		String username, password;
		if(xTextFieldUsuario.getText().isEmpty() || xTextFieldPassword.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Debes introducir un usuario y contraseña");
			return;
		}
		
		if(client.login(xTextFieldUsuario.getText(),  xTextFieldPassword.getText())) {
			log("Login correcto");
			this.xLabelSTATUS.setText("Conectado");
			this.xLabelSTATUS.setTextFill(Color.GREEN);
			this.xButtonDesconectar.setDisable(false);
			this.xButtonSubirArchivo.setDisable(false);
			this.xButtonConnectar.setDisable(true);
			this.xTextAreaPrincipal.setDisable(false);
			this.xTextFieldServidor.setDisable(true);
			this.xTextFieldPassword.setDisable(true);
			this.xTextFieldUsuario.setDisable(true);
		} else {
			error("Login incorrecto");
			client.disconnect();
			log("Desconectado");
			JOptionPane.showMessageDialog(null, "Usuario y contraseña mal introducidosl");
		}
	}
	
	@FXML
	public void xButtonConnectar(ActionEvent event) {
		if(xTextFieldServidor.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Debes introducir un servidor para poder conectarse");
			return;
		}
		try {
			client.connect(xTextFieldServidor.getText());
			client.enterLocalPassiveMode();
			login(client);
			
			fillTextArea(client);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se ha podido conectar al servidor");
			return;
		}
	}
	
	private void fillTextArea(FTPClient client) throws IOException {
		this.xTextAreaPrincipal.setText("Directorio actual: "+ client.printWorkingDirectory());
		FTPFile[] files = client.listFiles();
		String str = "\n";
		
		for (int i = 0; i < files.length; i++) {
			str += "  - ["+TYPES[files[i].getType()]+"] "+files[i].getName()+"\n";
		}
		
		
		
		this.xTextAreaPrincipal.setText(this.xTextAreaPrincipal.getText()+str);
	}
	@FXML
	public void xButtonSalir(ActionEvent event) {
		try {
			client.disconnect();
		} catch (Exception e) {
		}
		
		System.exit(0);
	}
	// Event Listener on Button[#xButtonSubirArchivo].onAction
	@FXML
	public void xButtonSubirArchivo(ActionEvent event) {
		JFileChooser ch = new JFileChooser();
		int s = ch.showOpenDialog(null);
		if(s==0) {
			File file = ch.getSelectedFile();
			String url = file.getAbsolutePath();

			try {
				BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(url));
				if(client.storeFile(file.getName(), bufferedInputStream)) {
					fillTextArea(client);
					JOptionPane.showMessageDialog(null, "Archivo subido correctamente");
				} else {
					JOptionPane.showMessageDialog(null, "Error al subir archivo");
					return;
				}
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Error al subir archivo");
				e.printStackTrace();
			}
		}
		
	}
	// Event Listener on Button[#xButtonDesconectar].onAction
	@FXML
	public void xButtonDesconectar(ActionEvent event) {
		try {
			client.disconnect();
		} catch (Exception e) {
		}
		this.xButtonConnectar.setDisable(false);
		this.xButtonDesconectar.setDisable(true);
		this.xButtonSubirArchivo.setDisable(true);
		this.xTextAreaPrincipal.setDisable(true);
		
		this.xTextFieldServidor.setDisable(false);
		this.xTextFieldPassword.setDisable(false);
		this.xTextFieldUsuario.setDisable(false);
		
		this.xLabelSTATUS.setText("No conectado");
		this.xLabelSTATUS.setTextFill(Color.RED);
	}
	
	private static void log(String msg) {
		System.out.println("[LOG] "+msg);
	}

	private static void error(String msg) {
		System.out.println("[ERROR] "+msg);
	}
}
