
package Controller;

import View.ComprasView;
import View.MenuView;
import View.ProveedorView;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class MenuViewController {

    private MenuView menuView;
    private LoginViewController loginViewController;
    
    private String user;
    
    public MenuViewController(MenuView menuView, LoginViewController loginViewController, String user) {
        this.menuView = menuView;
        this.loginViewController = loginViewController;
        this.user = user;
        
        this.menuView.getxLabelUsuario().setText(user);
        
        this.menuView.getxBotonCOMPRAS().addActionListener(e -> compras());
        this.menuView.getxBotonPROOVEDOR().addActionListener(e -> proveedor());
        this.menuView.getxBotonCREDITOS().addActionListener(e -> creditos());
        this.menuView.getxBotonLOGOUT().addActionListener(e -> logout());
    }
    
    private void compras() {
        menuView.setVisible(false);
        ComprasViewController comprasViewController = new ComprasViewController(new ComprasView(), this);
    }
    
    private void proveedor() {
        menuView.setVisible(false);
        ProveedoresViewController proveedoresViewController = new ProveedoresViewController(new ProveedorView(), this);
    }
    
    private void creditos() {
        JOptionPane.showMessageDialog(
                menuView,
                "Aplicación hecha por Jose Galán Simó para el examen de Interfaces de 2ºDAM",
                "Creditos",
                JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void logout() {
        menuView.dispose();
        loginViewController.setVisible(true);
    }
    
    public void setVisible(boolean b) {
        menuView.setVisible(b);
    }

}
