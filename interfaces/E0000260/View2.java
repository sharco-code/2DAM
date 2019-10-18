package E0000260;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


public class View2 extends JDialog{
	private JButton buttonAdd = new JButton("Añadir");
	private JTextField id = new JTextField();
	private JTextField marca = new JTextField();
	private JTextField modelo = new JTextField();
	private JTextField precio = new JTextField();
	
	View2(JFrame frame){
		super(frame,"Ventana Modal Insertar coche" ,Dialog.ModalityType.APPLICATION_MODAL);
		super.setLocationRelativeTo(frame);
        JPanel totDialeg = new JPanel(new BorderLayout());
        
        JLabel textTitul=new JLabel("Coche", SwingConstants.CENTER); 

        totDialeg.add(textTitul,BorderLayout.NORTH);
        
        totDialeg.add(buttonAdd,BorderLayout.SOUTH);
        JPanel form = new JPanel();
       
        form.setLayout(new GridBagLayout());
        FormUtility formUtility = new FormUtility();

        formUtility.addLabel("ID: ", form);
        formUtility.addLastField(id, form);

        formUtility.addLabel("Marca: ", form);
        formUtility.addLastField(marca, form);
        
       
        formUtility.addLabel("Modelo", form);
        formUtility.addLastField(modelo, form);

     
        formUtility.addLabel("Precio: ", form);
        formUtility.addMiddleField(precio, form);
        formUtility.addLastField(new JPanel(), form);
        form.setBorder(new EmptyBorder(2, 2, 2, 2));

        totDialeg.add(form,BorderLayout.CENTER);
         
        this.add(totDialeg);
        
        this.pack();
        
       
        this.setBounds(350, 350, 600, 200);
        this.setVisible(false);
        
       
	}
	View2(View ventana,Object[] row){
		super(ventana,Dialog.ModalityType.APPLICATION_MODAL);
		buttonAdd.setText("Modificar");
		id.setText((String)row[0]);
		marca.setText((String)row[1]);
		modelo.setText((String)row[2]);
		precio.setText(""+row[3]);
        JPanel totDialeg = new JPanel(new BorderLayout());
        
        JLabel textTitul=new JLabel("Coche", SwingConstants.CENTER); 

        totDialeg.add(textTitul,BorderLayout.NORTH);
        
        totDialeg.add(buttonAdd,BorderLayout.SOUTH);
        JPanel form = new JPanel();
       
        form.setLayout(new GridBagLayout());
        FormUtility formUtility = new FormUtility();

        formUtility.addLabel("ID: ", form);
        formUtility.addLastField(id, form);

        formUtility.addLabel("Marca: ", form);
        formUtility.addLastField(marca, form);
        
       
        formUtility.addLabel("Modelo", form);
        formUtility.addLastField(modelo, form);

     
        formUtility.addLabel("Precio: ", form);
        formUtility.addMiddleField(precio, form);
        formUtility.addLastField(new JPanel(), form);
        form.setBorder(new EmptyBorder(2, 2, 2, 2));

        totDialeg.add(form,BorderLayout.CENTER);
         
        this.add(totDialeg);
        
        this.pack();
        
       
        this.setBounds(350, 350, 600, 200);
        this.setVisible(false);
        
       
	}
	public Object[] getFruta() {
		return new Object[] {id.getText(),marca.getText(),modelo.getText(),Double.parseDouble(precio.getText())};
	}
	
	public JButton getButtonAñadir() {
		return buttonAdd;
	}



	
	
	

}
