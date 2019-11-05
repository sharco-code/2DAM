package Controller;

import Model.*;
import View.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;

public class LoginController {

    private Login loginView;
    private MainView mainView;
    private MainViewController mainViewController;
    
    private static JDBCConnection connection;

    public LoginController(Login loginView, MainView mainView, MainViewController mainViewController) {
        this.loginView = loginView;
        this.mainView = mainView;

        this.mainViewController = mainViewController;
        
        //Si pulsas enter en el jtextfield username, pasa a jtextfueld password
        loginView.getjTextFieldUsername().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "clickButton");
        loginView.getjTextFieldUsername().getActionMap().put("clickButton", new AbstractAction() {public void actionPerformed(ActionEvent ae) {loginView.getjTextFieldUsername().transferFocus();}});


    }


}
