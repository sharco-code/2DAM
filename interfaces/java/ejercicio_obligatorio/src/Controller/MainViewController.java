package Controller;

import DAO.FamiliaDAO;
import Exceptions.BusinessException;
import Model.Familia;
import View.InputFamilia;
import View.MainView;
import View.ProductoView;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

public class MainViewController {

    private MainView mainView;
    private InputFamilia inputFamilia;
    private List<Familia> list;

    private FamiliaDAO familiaDAO;

    private int actual_position = 0;
    private boolean isAdd = true;
    
    public MainViewController(MainView mainView) {
        this.mainView = mainView;
        inputFamilia = new InputFamilia(mainView, true);
        
        familiaDAO = new FamiliaDAO();

        mainView.getjButtonAdd().addActionListener(e -> add());
        mainView.getjButtonEdit().addActionListener(e -> edit());
        
        inputFamilia.getjBUTTON().addActionListener(e -> inputButton());
            
        mainView.getjButtonDelete().addActionListener(e -> delete());

        mainView.getjButtonSearch().addActionListener(e -> search());
        mainView.getjTextFieldSearch().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "clickButton");
        mainView.getjTextFieldSearch().getActionMap().put("clickButton", new AbstractAction() {
            public void actionPerformed(ActionEvent ae) {
                search();
            }
        });
        
        mainView.getjButtonEAST().addActionListener(e -> east());
        mainView.getjButtonWEST().addActionListener(e -> west());
        
        mainView.getjButtonAcceder().addActionListener(e -> {
            mainView.setVisible(false);
            ProductoView p = new ProductoView();
            ProductoViewController pc = new ProductoViewController(p, mainView,list.get(actual_position).getFamilia(), list.get(actual_position).getIdFamilia());
        });

    }

    private void east() {
        if (actual_position + 1 >= list.size()) {
            fill(0);
            actual_position = 0;
        } else {
            fill(actual_position + 1);
            actual_position += 1;
        }
    }
    private void west() {
        if (actual_position - 1 < 0) {
            fill(list.size() - 1);
            actual_position = list.size() - 1;
        } else {
            fill(actual_position - 1);
            actual_position -= 1;
        }
    }
    public void start() {
        try {
            this.list = familiaDAO.getAll();
        } catch (BusinessException e) {
            e.printStackTrace();
        }
        fill(actual_position);
    }
    public void start(int pos) {
        try {
            this.list = familiaDAO.getAll();
        } catch (BusinessException e) {
            e.printStackTrace();
        }
        fill(pos);
    }
    private void fill(int index) {
        mainView.getjTextFieldFamilia().setText(list.get(index).getFamilia());
        if (this.list.get(index).getEsMenu().equals('N')) {
            mainView.getjComboBoxEsMenu().setSelectedIndex(1);
        } else {
            mainView.getjComboBoxEsMenu().setSelectedIndex(0);
        }
        try {


            BufferedImage myPicture = ImageIO.read(new File("images\\" + this.list.get(index).getFoto()));
            
            Image image = new ImageIcon(myPicture).getImage();
            Image newimg = image.getScaledInstance(180, 180,  java.awt.Image.SCALE_SMOOTH);
            
            mainView.getjLabelImagen().setIcon(new ImageIcon(newimg));
        } catch (Exception e) {
            try {
                BufferedImage myPicture = ImageIO.read(new File("images\\default.png"));
                Image image = new ImageIcon(myPicture).getImage();
            Image newimg = image.getScaledInstance(180, 180,  java.awt.Image.SCALE_SMOOTH);
                mainView.getjLabelImagen().setIcon(new ImageIcon(newimg));
            } catch (IOException ex) {
                mainView.messageERROR("No se encuentra la imagen");
            }
        }

    }

    private void add() {
        isAdd = true;
        inputFamilia.editarVentana("Añadir");
        inputFamilia.setVisible(true);
        
        
    }

    private void edit() {
        isAdd = false;
        inputFamilia.editarVentana("Editar");
        
        inputFamilia.getjTextFieldFamilia().setText(list.get(actual_position).getFamilia());
        if (this.list.get(actual_position).getEsMenu().equals('N')) inputFamilia.getjComboBoxEsMenu().setSelectedIndex(1);
        else inputFamilia.getjComboBoxEsMenu().setSelectedIndex(0);
        inputFamilia.getjTextFieldFoto().setText(list.get(actual_position).getFoto());
        inputFamilia.getjTextFieldVer().setText(list.get(actual_position).getVer().toString());
        
        
        inputFamilia.setVisible(true);
        
        
    }

    private void inputButton() {
        if(inputFamilia.getjTextFieldFamilia().getText().isEmpty()) {
            inputFamilia.messageERROR("El campo 'Familia' no puede estar vacio");
            return;
        }
        if(inputFamilia.getjTextFieldFoto().getText().isEmpty()) {
            inputFamilia.messageERROR("El campo 'Foto' no puede estar vacio");
            return;
        }
        if(inputFamilia.getjTextFieldVer().getText().isEmpty()) {
            inputFamilia.messageERROR("El campo 'Ver' no puede estar vacio");
            return;
        }
        if(this.isAdd) {
            try {
                Familia f = new Familia();
                f.setFamilia(inputFamilia.getjTextFieldFamilia().getText());
                f.setFoto(inputFamilia.getjTextFieldFoto().getText());
                f.setVer(Integer.parseInt(inputFamilia.getjTextFieldVer().getText()));
                if(inputFamilia.getjComboBoxEsMenu().getSelectedItem().equals("SI")) {
                    f.setEsMenu('S');
                } else {
                    f.setEsMenu('N');
                }
                familiaDAO.addFamilia(f);
            } catch (BusinessException e) {
                inputFamilia.messageERROR(e.getMessage());
                return;
            } catch (java.lang.NumberFormatException e){
                inputFamilia.messageERROR("El campo 'ver' tiene que ser numerico");
                return;
            } catch (Exception e){
                inputFamilia.messageERROR("Error al insertar familia");
                return;
            }
            inputFamilia.messageINFO("Familia insertada");
            int aux = list.size();
            this.list.clear();
            start(aux);
            inputFamilia.setVisible(false);
        } else {
            try {
                Familia f = new Familia();
                f.setIdFamilia(list.get(actual_position).getIdFamilia());
                f.setFamilia(inputFamilia.getjTextFieldFamilia().getText());
                f.setFoto(inputFamilia.getjTextFieldFoto().getText());
                f.setVer(Integer.parseInt(inputFamilia.getjTextFieldVer().getText()));
                if(inputFamilia.getjComboBoxEsMenu().getSelectedItem().equals("SI")) {
                    f.setEsMenu('S');
                } else {
                    f.setEsMenu('N');
                }
                familiaDAO.modifyFamilia(f);
            } catch (BusinessException e) {
                inputFamilia.messageERROR(e.getMessage());
                return;
            } catch (java.lang.NumberFormatException e){
                inputFamilia.messageERROR("El campo 'ver' tiene que ser numerico");
                return;
            } catch (Exception e){
                inputFamilia.messageERROR("Error al editar familia");
                return;
            }
            inputFamilia.messageINFO("Familia editada");
            this.list.clear();
            start(actual_position);
            inputFamilia.setVisible(false);
        }
    }
    
    private void delete() {
        try {
            familiaDAO.deleteFamilia(list.get(actual_position));
            list.remove(actual_position);
            west();
            inputFamilia.messageINFO("Familia borrada");
        } catch (BusinessException ex) {
            mainView.messageERROR("Error al borrar familia");
        }
    }
    
    private void search() {
        for (int i = 0; i < list.size(); i++) {
            if(mainView.getjTextFieldSearch().getText().equals(list.get(i).getFamilia())) {
                fill(i);
                actual_position = i;
                return;
            }
        }
        mainView.messageINFO("No se ha encontrado esa familia");
    }   
    
    private Image getScaledImage(Image srcImg, int w, int h) {
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        return resizedImg;
    }
}
