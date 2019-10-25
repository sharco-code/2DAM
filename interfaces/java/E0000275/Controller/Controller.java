package E0000275.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import E0000275.Model.Coche;
import E0000275.Model.TableModel;

import E0000275.View.Marcianito;;

public class Controller implements ActionListener {

	private TableModel model;
	private JFrame view;
	
	public Controller(TableModel model, JFrame view) {
		super();
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			new Marcianito(view);
		} catch (MalformedURLException e1) {
			JOptionPane option = new JOptionPane("Error, no se ha podido cargar la imagen", JOptionPane.ERROR_MESSAGE);
		}
	}

}
