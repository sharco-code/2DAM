package E0000275.View;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Marcianito extends JDialog {
	
	private JFrame frame;
	
	public Marcianito(JFrame view) throws MalformedURLException {
		super(view, true);
		this.setModal(true);
		JLabel label_titulo = new JLabel("HOLA, soy una ventana modal");label_titulo.setFont(new Font("Arial", Font.PLAIN, 12));
		JPanel panelTop = new JPanel();
		panelTop.add(label_titulo);
		JPanel panelGIF = new JPanel();

		URL url = new URL("https://i.kym-cdn.com/entries/icons/original/000/021/273/200w.gif");
        Icon icon = new ImageIcon(url);
        JLabel label = new JLabel(icon);
		
		panelGIF.add(label);
		
		frame = new JFrame("Ventana modal");

		frame.getContentPane().add(panelTop, BorderLayout.NORTH);
		frame.getContentPane().add(panelGIF, BorderLayout.CENTER);
		frame.setSize(420, 400);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
