package gui01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;

public class GUI01 {

    GUI01() {
        JFrame frame = new JFrame("Nombre de ventana");
        
        final JTextField textfield = new JTextField("texto de jtextfield");
        final JButton button = new JButton("click");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(textfield.getText().equals("texto uno")) textfield.setText("texto dos");
                else textfield.setText("texto uno");
            }
        });
        
        final JButton button2 = new JButton("boton2");
        
        Toolkit screen = Toolkit.getDefaultToolkit();
        Dimension screenSize = screen.getScreenSize();
        
        Image icon = screen.getImage("src\\imgs\\icon.png");
        
        frame.setIconImage(icon);
        
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(screenSize.width/2, screenSize.height/2);
        frame.setLocation(screenSize.width/4, screenSize.height/4);
        
        Panel panel = new Panel();
        panel.setBackground(Color.DARK_GRAY);
        panel.setBounds(2, 2, frame.getWidth()-20, frame.getHeight()-43);
        
        panel.add(textfield);
        panel.add(button);
        panel.add(button2);
        
        frame.add(panel);
        frame.setResizable(false);
    }
    
    public static void main(String[] args) {
        new GUI01();
    }
    
}