package Controller;

import DAO.LoginDAO;
import Model.*;
import View.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;

public class LoginViewController {

    private LoginView loginView;
    private MenuViewController MenuViewController;

    private JDBCConnection con;
    
    public LoginViewController(LoginView loginView) {
        this.loginView = loginView;

        loginView.getxTextFieldEMPLEADO().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "clickButton");
        loginView.getxTextFieldEMPLEADO().getActionMap().put("clickButton", new AbstractAction() {public void actionPerformed(ActionEvent ae) {loginView.getxTextFieldEMPLEADO().transferFocus();}});

        loginView.getxTextFieldPASSWORD().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "clickButton");
        loginView.getxTextFieldPASSWORD().getActionMap().put("clickButton", new AbstractAction() {public void actionPerformed(ActionEvent ae) {entrarClicked();}});
        
        loginView.getxBotonENTRAR().addActionListener(e -> entrarClicked());
        loginView.getxBotonCONFIG().addActionListener(e -> configClicked());
        loginView.getxBotonCONECTAR().addActionListener(e -> conectarClicked());
    }
    
    private void entrarClicked() {
        LoginDAO loginDAO = new LoginDAO();

        if(loginDAO.login(loginView.getxTextFieldEMPLEADO().getText(), new String(loginView.getxTextFieldPASSWORD().getPassword()))) {
            loginView.setVisible(false);
            MenuViewController = new MenuViewController(new MenuView(), this, loginView.getxTextFieldEMPLEADO().getText());
        } else {
            loginView.showError("Empleado y contraseña incorrectos");
        }
        
    }
    
    public void setVisible(boolean b) {
        loginView.setVisible(b);
        loginView.getxTextFieldEMPLEADO().setText("");
        loginView.getxTextFieldPASSWORD().setText("");
    }

    private void configClicked(){
        try {
            process("notepad " + System.getProperty("user.dir") + "\\config\\database.json");
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(MenuViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void conectarClicked(){
        loginView.getxLabelESTADO().setText("Conectando...");
        loginView.getxTextFieldEMPLEADO().setEnabled(false);
            loginView.getxTextFieldPASSWORD().setEnabled(false);
            loginView.getxBotonENTRAR().setEnabled(false);
        try {
            con = new JDBCConnection(System.getProperty("user.dir") + "\\config\\database.json", "root", "root");
            con.conectar();
        } catch (SQLException e) {
            loginView.getxLabelESTADO().setText("Error de Conexión");
            return;
            //loginView.showError("No se ha podido conectar (SQLException)");
            //e.printStackTrace();
        } catch (FileNotFoundException e) {
            loginView.getxLabelESTADO().setText("json no encontrado");
            
            return;
            //loginView.showError("No se ha encontrado el .json (FileNotFoundException)");
            //e.printStackTrace();
        } catch (Exception e) {
            loginView.getxLabelESTADO().setText("Error de Conexión");
            return;
            //loginView.showError("No se ha podido conectar (Exception)");
            //e.printStackTrace();
        }
        loginView.getxLabelESTADO().setText("Conectado");
        Color aColor = Color.decode("#317f43");
        loginView.getxLabelESTADO().setForeground(aColor);
        loginView.getxTextFieldEMPLEADO().setEnabled(true);
        loginView.getxTextFieldPASSWORD().setEnabled(true);
        loginView.getxBotonENTRAR().setEnabled(true);
    }
     private void process(String command) throws IOException, InterruptedException {
        
        ProcessBuilder pb = new ProcessBuilder("CMD", "/C", command);
        try {
            Process process = pb.start();
            int x = process.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new InterruptedException("Interrupted Exception");
        }
    }
}
