
package gui01;

import java.awt.*;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Panel extends JPanel {
    
    private int rect_x;
    private int rect_y;
    private int rect_width;
    private int rect_height;
    private Image img;
    
    Panel() {
        
        Toolkit screen = Toolkit.getDefaultToolkit();
        Dimension screenSize = screen.getScreenSize();
        
        rect_x = rect_y= 60;
        rect_width = rect_height = 300;
        
        img = screen.getImage("src\\imgs\\wow.jpg");
    }
    
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.green);
        g.fillOval(600, 20, 200, 200);
        
        g.setColor(Color.red);
        g.drawRect(rect_x,rect_y,rect_width,rect_height);
        g.setColor(Color.gray);
        g.fillRect(rect_x+2,rect_y+2,rect_width-3,rect_height-3); 
        
        try {
           img = ImageIO.read(new File("src\\imgs\\wow.jpg")); 
        } catch (Exception e) {
            System.out.println("Imagen no encontrada");
        }
        
        g.drawImage(img, rect_x+5, rect_y+5, rect_width-10,rect_height-10, this);
    }
    
}
