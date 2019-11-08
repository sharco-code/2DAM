
import Controller.*;
import Model.*;
import View.*;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Main {
    
    //private static JDBCConnection con;
    
    private static LoginView loginView;
    private static LoginViewController loginViewController;
   
    public static void main(String[] args) {
        
        loginView = new LoginView();
        loginViewController = new LoginViewController(loginView);
    }
    
    private static void showError(String msg) {
        JOptionPane.showMessageDialog(null, msg,"Error",JOptionPane.ERROR_MESSAGE);
    }
}
