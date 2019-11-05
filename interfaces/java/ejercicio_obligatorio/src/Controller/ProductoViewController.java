/*
 Jose Galán Simó
 2 - DAM
 */
package Controller;

import DAO.ProductoDAO;
import Exceptions.BusinessException;
import Model.Producto;
import View.InputProducto;
import View.MainView;
import View.ProductoView;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class ProductoViewController {

    private ProductoView productoView;
    private ProductoDAO productoDAO;
    private InputProducto inputProducto;
    private List<Producto> list;
    private MainView mainView;

    private Integer idFamilia;

    private boolean isAdd = true;
    private boolean isSearch = false;

    public ProductoViewController(ProductoView productoView, MainView mainView, String familia, Integer idFamilia) {
        this.productoView = productoView;
        this.mainView = mainView;
        this.idFamilia = idFamilia;

        this.inputProducto = new InputProducto(productoView, true);

        productoDAO = new ProductoDAO();

        productoView.setFamilia(familia);
        productoView.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                mainView.setVisible(true);
                productoView.dispose();
            }
        });
        productoView.getjButtonVolver().addActionListener(e -> {
            mainView.setVisible(true);
            productoView.dispose();
        });
        productoView.getjButtonAdd().addActionListener(e -> add());
        productoView.getjButtonEdit().addActionListener(e -> edit());

        inputProducto.getjBUTTON().addActionListener(e -> inputButton());

        productoView.getjButtonDelete().addActionListener(e -> delete());
        productoView.getjButtonSearch().addActionListener(e -> search());
        productoView.getjTextFieldSearch().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "clickButton");
        productoView.getjTextFieldSearch().getActionMap().put("clickButton", new AbstractAction() {
            public void actionPerformed(ActionEvent ae) {
                search();
            }
        });
        productoView.getjTable1().getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                productoView.getjButtonEdit().setEnabled(true);
                productoView.getjButtonDelete().setEnabled(true);
            }

        });
        start();
    }

    public void start() {
        try {
            this.list = productoDAO.getAllfromFamily(idFamilia);
        } catch (BusinessException e) {
            e.printStackTrace();
        }

        DefaultTableModel a = (DefaultTableModel) productoView.getjTable1().getModel();

        a.setRowCount(0);
        if (list == null || list.isEmpty()) {
            productoView.messageINFO("No hay productos de esta familia");
        }
        for (int i = 0; i < list.size(); i++) {
            a.addRow(new Object[]{list.get(i).getNombre(),
                list.get(i).getFoto(),
                list.get(i).getVer(),
                list.get(i).getPVP(),
                list.get(i).getCoste(),
                list.get(i).getDeCocina(),
                list.get(i).getEsMenu(),
                list.get(i).getEsPlantilla()
            });
        }
        productoView.getjTable1().setModel(a);
        productoView.getjTable1().updateUI();

    }

    private void add() {
        isAdd = true;
        inputProducto.editarVentana("Añadir");
        inputProducto.setVisible(true);
    }

    private void edit() {
        isAdd = false;
        isSearch = false;
        inputProducto.editarVentana("Editar");

        inputProducto.getjTextFieldNombre().setText(list.get(productoView.getjTable1().getSelectedRow()).getNombre());
        inputProducto.getjTextFieldFoto().setText(list.get(productoView.getjTable1().getSelectedRow()).getFoto());
        inputProducto.getjTextFieldVer().setText(Integer.toString(list.get(productoView.getjTable1().getSelectedRow()).getVer()));
        inputProducto.getjTextFieldPVP().setText(Double.toString(list.get(productoView.getjTable1().getSelectedRow()).getPVP()));
        inputProducto.getjTextFieldCoste().setText(Double.toString(list.get(productoView.getjTable1().getSelectedRow()).getCoste()));

        if (list.get(productoView.getjTable1().getSelectedRow()).getEsMenu().equals("no")) {
            inputProducto.getjComboBoxEsMenu1().setSelectedIndex(1);
        } else {
            inputProducto.getjComboBoxEsMenu1().setSelectedIndex(0);
        }

        if (list.get(productoView.getjTable1().getSelectedRow()).getDeCocina().equals("no")) {
            inputProducto.getjComboBoxDeCocina().setSelectedIndex(1);
        } else {
            inputProducto.getjComboBoxDeCocina().setSelectedIndex(0);
        }

        if (list.get(productoView.getjTable1().getSelectedRow()).getEsPlantilla().equals("No")) {
            inputProducto.getjComboBoxEsPlantilla().setSelectedIndex(1);
        } else {
            inputProducto.getjComboBoxEsPlantilla().setSelectedIndex(0);
        }

        inputProducto.setVisible(true);

    }

    private void inputButton() {
        if (inputProducto.getjTextFieldNombre().getText().isEmpty()) {
            inputProducto.messageERROR("El campo 'Nombre' no puede estar vacio");
            return;
        }
        if (inputProducto.getjTextFieldFoto().getText().isEmpty()) {
            inputProducto.messageERROR("El campo 'Foto' no puede estar vacio");
            return;
        }
        if (inputProducto.getjTextFieldVer().getText().isEmpty()) {
            inputProducto.messageERROR("El campo 'Ver' no puede estar vacio");
            return;
        }
        if (inputProducto.getjTextFieldPVP().getText().isEmpty()) {
            inputProducto.messageERROR("El campo 'pvp' no puede estar vacio");
            return;
        }
        if (inputProducto.getjTextFieldCoste().getText().isEmpty()) {
            inputProducto.messageERROR("El campo 'coste' no puede estar vacio");
            return;
        }
        if (this.isAdd) {
            try {
                Producto p = new Producto();

                p.setNombre(inputProducto.getjTextFieldNombre().getText());
                p.setFoto(inputProducto.getjTextFieldFoto().getText());
                p.setVer(Integer.parseInt(inputProducto.getjTextFieldVer().getText()));
                p.setPVP(Double.parseDouble(inputProducto.getjTextFieldPVP().getText()));
                p.setCoste(Double.parseDouble(inputProducto.getjTextFieldCoste().getText()));
                p.setIdFamilia(idFamilia);
                if (inputProducto.getjComboBoxEsMenu1().getSelectedItem().equals("SI")) {
                    p.setEsMenu("si");
                } else {
                    p.setEsMenu("no");
                }
                if (inputProducto.getjComboBoxDeCocina().getSelectedItem().equals("SI")) {
                    p.setDeCocina("si");
                } else {
                    p.setDeCocina("no");
                }
                if (inputProducto.getjComboBoxEsPlantilla().getSelectedItem().equals("NO")) {
                    p.setEsPlantilla("No");
                } else {
                    p.setEsPlantilla("SÍ");
                }
                productoDAO.addProducto(p);
            } catch (BusinessException e) {
                inputProducto.messageERROR(e.getMessage());
                return;
            } catch (java.lang.NumberFormatException e) {
                inputProducto.messageERROR("El campo 'ver', 'pvp' y 'coste' tiene que ser numerico");
                return;
            } catch (Exception e) {
                inputProducto.messageERROR("Error al insertar producto");
                return;
            }
            inputProducto.messageINFO("producto insertado");
            this.list.clear();
            start();
            inputProducto.setVisible(false);
        } else {
            try {
                Producto p = new Producto();
                if (isSearch) {
                    p.setIdProducto(productoDAO.isNombre(productoView.getjTextFieldSearch().getText()));
                } else {
                    p.setIdProducto(list.get(productoView.getjTable1().getSelectedRow()).getIdProducto());
                }
                p.setNombre(inputProducto.getjTextFieldNombre().getText());
                p.setFoto(inputProducto.getjTextFieldFoto().getText());
                p.setVer(Integer.parseInt(inputProducto.getjTextFieldVer().getText()));
                p.setPVP(Double.parseDouble(inputProducto.getjTextFieldPVP().getText()));
                p.setCoste(Double.parseDouble(inputProducto.getjTextFieldCoste().getText()));
                p.setIdFamilia(idFamilia);
                if (inputProducto.getjComboBoxEsMenu1().getSelectedItem().equals("SI")) {
                    p.setEsMenu("si");
                } else {
                    p.setEsMenu("no");
                }
                if (inputProducto.getjComboBoxDeCocina().getSelectedItem().equals("SI")) {
                    p.setDeCocina("si");
                } else {
                    p.setDeCocina("no");
                }
                if (inputProducto.getjComboBoxEsPlantilla().getSelectedItem().equals("NO")) {
                    p.setEsPlantilla("No");
                } else {
                    p.setEsPlantilla("SÍ");
                }
                productoDAO.modifyProducto(p);
            } catch (BusinessException e) {
                inputProducto.messageERROR(e.getMessage());
                return;
            } catch (java.lang.NumberFormatException e) {
                inputProducto.messageERROR("El campo 'ver', 'pvp' y 'coste' tiene que ser numerico");
                return;
            } catch (Exception e) {
                inputProducto.messageERROR("Error al editar producto");
                return;
            }
            inputProducto.messageINFO("producto editado");
            this.list.clear();
            start();
            inputProducto.setVisible(false);

        }

    }

    private void delete() {
        try {
            productoDAO.deleteProducto(list.get(productoView.getjTable1().getSelectedRow()).getIdProducto());
            list.remove(productoView.getjTable1().getSelectedRow());
            start();
            inputProducto.messageINFO("Familia borrada");
        } catch (BusinessException ex) {
            mainView.messageERROR("Error al borrar familia");
        }
    }

    private void search() {
        if (productoDAO.isNombre(productoView.getjTextFieldSearch().getText()) == null) {
            mainView.messageINFO("No se ha encontrado ese producto");
            return;
        }
        isAdd = false;
        isSearch = true;
        Integer x = productoDAO.isNombre(productoView.getjTextFieldSearch().getText());
        for (int i = 0; i < list.size(); i++) {
            if (x == list.get(i).getIdProducto()) {
                x = i;
            }
        }

        inputProducto.editarVentana("Editar");

        inputProducto.getjTextFieldNombre().setText(list.get(x).getNombre());
        inputProducto.getjTextFieldFoto().setText(list.get(x).getFoto());
        inputProducto.getjTextFieldVer().setText(Integer.toString(list.get(x).getVer()));
        inputProducto.getjTextFieldPVP().setText(Double.toString(list.get(x).getPVP()));
        inputProducto.getjTextFieldCoste().setText(Double.toString(list.get(x).getCoste()));

        if (list.get(x).getEsMenu().equals("no")) {
            inputProducto.getjComboBoxEsMenu1().setSelectedIndex(1);
        } else {
            inputProducto.getjComboBoxEsMenu1().setSelectedIndex(0);
        }

        if (list.get(x).getDeCocina().equals("no")) {
            inputProducto.getjComboBoxDeCocina().setSelectedIndex(1);
        } else {
            inputProducto.getjComboBoxDeCocina().setSelectedIndex(0);
        }

        if (list.get(x).getEsPlantilla().equals("No")) {
            inputProducto.getjComboBoxEsPlantilla().setSelectedIndex(1);
        } else {
            inputProducto.getjComboBoxEsPlantilla().setSelectedIndex(0);
        }

        inputProducto.setVisible(true);

    }

}
