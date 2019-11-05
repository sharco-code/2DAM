import Controller.*;
import Model.Familia;
import View.Login;
import View.MainView;
import View.ProductoView;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

public class Main {

    private static JDBCConnection con;
    private static MainView mainView;
    private static MainViewController mainViewController;
    private static ProductoView productoView;
    private static ProductoViewController productoViewController;
    private static Login login;
    private static LoginController loginController;

    public static void main(String[] args) {

        mainView = new MainView();
        mainViewController = new MainViewController(mainView);

        login = new Login();
        login.getjButtonLogin().addActionListener(e -> loginClicked());
        
        //Si pulsas enter en el jtextfield password, es como si le dieras a login
        login.getjTextFieldPassword().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "clickButton");
        login.getjTextFieldPassword().getActionMap().put("clickButton", new AbstractAction() {
            public void actionPerformed(ActionEvent ae) {
                loginClicked();
            }
        });

        LoginController loginController = new LoginController(login, mainView, mainViewController);

    }

    public static void loginClicked() {
        try {
            con = new JDBCConnection(System.getProperty("user.dir") + "\\src\\db_data.json", login.getjTextFieldUsername().getText(), new String(login.getjTextFieldPassword().getPassword()));
            con.conectar();
        } catch (Exception x) {
            login.messageINFO("Usuario y contraseña incorrectos");
            return;
        }
        login.setVisible(false);
        mainView.setVisible(true);
        mainViewController.start();
    }

}
