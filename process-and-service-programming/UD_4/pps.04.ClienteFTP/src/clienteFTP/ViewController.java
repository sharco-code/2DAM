package clienteFTP;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

import javafx.scene.control.PasswordField;

import javafx.scene.control.TreeView;
import javafx.scene.paint.Color;

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
	private Button xButtonSubirArchivo;
	@FXML
	private Label xLabelSTATUS;
	@FXML
	private Button xButtonDesconectar;
	@FXML
	private TreeView xTreeView;
	@FXML
	private Button xButtonDescargarArchivo;
	@FXML
	private Button xButtonBorrarArchivo;
	@FXML
	private Button xButtonBorrarDirectorio;
	@FXML
	private Button xButtonCrearDirectorio;

	private String URL;

	private final String TYPES[] = { "FILE", "DIR ", "LINK" };

	private FTPClient client = new FTPClient();

	private TreeItem root;

	private void login(FTPClient client) throws IOException {
		String username, password;
		if (xTextFieldUsuario.getText().isEmpty() || xTextFieldPassword.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Debes introducir un usuario y contraseña");
			return;
		}

		if (client.login(xTextFieldUsuario.getText(), xTextFieldPassword.getText())) {
			log("Login correcto");
			this.xLabelSTATUS.setText("Conectado");
			this.xLabelSTATUS.setTextFill(Color.GREEN);
			this.xButtonDesconectar.setDisable(false);
			// this.xButtonSubirArchivo.setDisable(false);
			this.xButtonConnectar.setDisable(true);
			this.xTreeView.setDisable(false);
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
		if (xTextFieldServidor.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Debes introducir un servidor para poder conectarse");
			return;
		}
		try {
			client.connect(xTextFieldServidor.getText());
			client.enterLocalPassiveMode();
			login(client);

			root = new TreeItem<String>(client.printWorkingDirectory());

			fillTreeView(client);

			xTreeView.getSelectionModel().selectedItemProperty().addListener(this::SelectionListener);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se ha podido conectar al servidor");
			return;
		}
	}

	private Object SelectionListener(ObservableValue observableValue, Object oldObject, Object newValue) {
		if (newValue == null) {
			this.xButtonSubirArchivo.setDisable(true);
			this.xButtonDescargarArchivo.setDisable(true);
			this.xButtonBorrarArchivo.setDisable(true);
			this.xButtonCrearDirectorio.setDisable(true);
			this.xButtonBorrarDirectorio.setDisable(true);
			return null;
		}
			

		TreeItem newItem = (TreeItem) newValue;
		if (!newItem.isLeaf()) {
			this.xButtonSubirArchivo.setDisable(false);
			this.xButtonDescargarArchivo.setDisable(true);
			this.xButtonBorrarArchivo.setDisable(true);
			this.xButtonCrearDirectorio.setDisable(false);
			this.xButtonBorrarDirectorio.setDisable(false);
		} else {
			this.xButtonSubirArchivo.setDisable(true);
			this.xButtonDescargarArchivo.setDisable(false);
			this.xButtonBorrarArchivo.setDisable(false);
			this.xButtonCrearDirectorio.setDisable(true);
			this.xButtonBorrarDirectorio.setDisable(true);
		}

		return null;
	}

	private TreeItem recursive(String dir) {
		TreeItem treeItem = new TreeItem<String>(dir);
		try {
			client.changeWorkingDirectory(dir);
			FTPFile[] files = client.listFiles();
			if(files.length==0) {
				treeItem.getChildren().add(null);
			}
			for (int i = 0; i < files.length; i++) {
				if (files[i].getType() == 1) {

					client.changeWorkingDirectory(files[i].getName());
					FTPFile[] n = client.listFiles();
					if (n.length != 0)
						treeItem.getChildren().add(recursive(files[i].getName()));
					else {
						TreeItem dots = new TreeItem<String>(files[i].getName());
						dots.getChildren().add(null);
						treeItem.getChildren().add(dots);
					}
					client.changeWorkingDirectory(dir);

				} else {
					treeItem.getChildren().add(new TreeItem<>(files[i].getName()));
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return treeItem;
	}

	private void fillTreeView(FTPClient client) throws IOException {
		client.changeWorkingDirectory("/");
		TreeItem root = recursive(client.printWorkingDirectory());
		root.setExpanded(true);
		this.xTreeView.setRoot(root);
		client.changeWorkingDirectory("\\");
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
		try {
			TreeItem itemSelected = ((TreeItem) this.xTreeView.getSelectionModel().getSelectedItem());
			if (!itemSelected.getChildren().isEmpty()) {

				// client.changeWorkingDirectory(itemSelected.getValue().toString());
				client.changeWorkingDirectory(getFullPath(itemSelected));
				JFileChooser ch = new JFileChooser();
				int s = ch.showOpenDialog(null);
				if (s == 0) {
					File file = ch.getSelectedFile();
					String url = file.getAbsolutePath();
					try {
						BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(url));
						if (client.storeFile(file.getName(), bufferedInputStream)) {

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
			} else {
				JOptionPane.showMessageDialog(null, "Tienes que seleccionar un directorio para subir el archivo");
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				client.changeWorkingDirectory("\\");
				fillTreeView(client);
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

	}

	private String getFullPath(TreeItem itemSelected) {
		StringBuilder pathBuilder = new StringBuilder();
		for (TreeItem<String> item = itemSelected; item != null; item = item.getParent()) {
			pathBuilder.insert(0, item.getValue());
			pathBuilder.insert(0, "/");
		}
		String path = pathBuilder.toString();
		return path.substring(2, path.length());
	}

	// Event Listener on Button[#xButtonDescargarArchivo].onAction
	@FXML
	public void xButtonDescargarArchivo(ActionEvent event) {

		try {
			TreeItem itemSelected = ((TreeItem) this.xTreeView.getSelectionModel().getSelectedItem());

			InputStream inputStream = client.retrieveFileStream(getFullPath(itemSelected));
			int returnCode = client.getReplyCode();
			if (inputStream == null || returnCode == 550) {

			} else {
				client.completePendingCommand();
				byte[] buffer = new byte[inputStream.available()];
				inputStream.read(buffer);

				JFileChooser destination = new JFileChooser();
				if (selectFolder(destination) != JFileChooser.APPROVE_OPTION)
					return;
				File carpetaDestino = new File(
						destination.getSelectedFile().getAbsolutePath() + "\\" + (String) itemSelected.getValue());

				OutputStream outputStream = new FileOutputStream(carpetaDestino);
				outputStream.write(buffer);
			}
			inputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private int selectFolder(JFileChooser destination) {
		destination.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		destination.setDialogTitle("Selecciona el directorio donde Descargar el fichero");
		return destination.showDialog(null, "Descagar");
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
		this.xTreeView.setDisable(true);

		this.xTextFieldServidor.setDisable(false);
		this.xTextFieldPassword.setDisable(false);
		this.xTextFieldUsuario.setDisable(false);

		this.xButtonDescargarArchivo.setDisable(true);
		this.xLabelSTATUS.setText("No conectado");
		this.xLabelSTATUS.setTextFill(Color.RED);
	}

	private static void log(String msg) {
		System.out.println("[LOG] " + msg);
	}

	private static void error(String msg) {
		System.out.println("[ERROR] " + msg);
	}

	@FXML
	public void xButtonBorrarArchivo(ActionEvent event) {
		if (!client.isConnected())
			return;

		if (JOptionPane.showConfirmDialog(null, "¿Estas seguro?", "Borrar archivo",
				JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION)
			return;

		TreeItem itemSelected = ((TreeItem) this.xTreeView.getSelectionModel().getSelectedItem());
		String fullpath = getFullPath(itemSelected);

		try {
			if (client.deleteFile(fullpath)) {
				JOptionPane.showMessageDialog(null, "Fichero eliminado correctamente");
			} else {
				JOptionPane.showMessageDialog(null, "No se pudo eliminar el fichero");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fillTreeView(client);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@FXML
	public void xButtonBorrarDirectorio(ActionEvent event) {

		if (JOptionPane.showConfirmDialog(null, "Se borraran todos los archivos de dentr\n¿Estas seguro?",
				"Borrar directorio", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) {
			return;
		}

		try {
			TreeItem itemSelected = ((TreeItem) this.xTreeView.getSelectionModel().getSelectedItem());
			String fullpath = getFullPath(itemSelected);

			recursiveDelete(fullpath);
			

			if (client.removeDirectory(fullpath)) {
				JOptionPane.showMessageDialog(null, "Directorio eliminado correctamente");
				fillTreeView(client);
			} else {
				JOptionPane.showMessageDialog(null, "Error al eliminar el directorio");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fillTreeView(client);
				System.out.println("asd");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void recursiveDelete(String dir) {
		try {
			client.changeWorkingDirectory(dir);

			FTPFile[] files = client.listFiles();
			for (FTPFile file : files) {
				if (file.isDirectory()) {
					recursiveDelete(file.getName());
					client.removeDirectory(file.getName());
				} else {
					client.deleteFile(file.getName());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			client.changeToParentDirectory();
		} catch (Exception e) {
		}
	}

	@FXML
	public void xButtonCrearDirectorio(ActionEvent event) {
		if (!client.isConnected())
			return;

		String folderName = JOptionPane.showInputDialog(null, "Introduce el nombre del directorio");
		if (folderName == null)
			return;

		TreeItem itemSelected = ((TreeItem) this.xTreeView.getSelectionModel().getSelectedItem());
		String fullpath = getFullPath(itemSelected);

		try {
			if (client.makeDirectory(fullpath + "/" + folderName.trim()))
				JOptionPane.showMessageDialog(null, "Directorio creado correctamente");
			else
				JOptionPane.showMessageDialog(null, "No se pudo crear el directorio");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fillTreeView(client);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
