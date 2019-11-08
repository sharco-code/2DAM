package Controller;

import DAO.ProveedorDAO;
import Exceptions.BusinessException;
import Model.Proveedor;
import View.ProveedorView;
import View.InputProveedorView;
import java.util.List;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class ProveedoresViewController {
    
    private ProveedorView proveedorView;

    private MenuViewController menuViewController;

    private List<Proveedor> list;

    private ProveedorDAO proveedorDAO = new ProveedorDAO();

    public ProveedoresViewController(ProveedorView proveedorView, MenuViewController menuViewController) {
        this.proveedorView = proveedorView;
        this.menuViewController = menuViewController;

        this.proveedorView.getxBotonAdd().addActionListener(e -> add());
        this.proveedorView.getxBotonDelete().addActionListener(e -> delete());
        this.proveedorView.getxBotonEdit().addActionListener(e -> edit());

        this.proveedorView.getxBotonSEARCH().addActionListener(e -> search());
        
        this.proveedorView.getxBotonVOLVER().addActionListener(e -> back());
        
        this.proveedorView.getxTABLA().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                proveedorView.getxBotonEdit().setEnabled(true);
                proveedorView.getxBotonDelete().setEnabled(true);
            }
        });
        
        fill();
    }

    private void fill() {
        //conseguir datos de la bbdd y rellenarlos
        try {
            this.list = proveedorDAO.getAll();

            if (list == null || list.isEmpty()) {
                proveedorView.showInfo("No hay proveedores en la base de datos");
            } else {
                DefaultTableModel dtm = (DefaultTableModel) proveedorView.getxTABLA().getModel();
                dtm.setRowCount(0);
                for (int i = 0; i < list.size(); i++) {
                    dtm.addRow(new Object[]{list.get(i).getNombre(),
                        list.get(i).getDir(),
                        list.get(i).getPob(),
                        list.get(i).getCp(),
                        list.get(i).getCIF(),
                        list.get(i).getProv(),
                        list.get(i).getTel()
                    });
                }
                proveedorView.getxTABLA().setModel(dtm);
                proveedorView.getxTABLA().updateUI();
            }
        } catch (BusinessException e) {
            proveedorView.showError("Error al obtener datos de la base de datos");
            e.printStackTrace();
        }
    }
    
    private void add() {
        InputProveedorView inputProveedorView = new InputProveedorView(proveedorView, true);
        inputProveedorView.editarVentana("Añadir");
       
        
        inputProveedorView.getxBotonACEPTAR().addActionListener(e -> inputAceptarClicked(inputProveedorView, true));

        inputProveedorView.setVisible(true);
    }

    private void delete() {
        if(proveedorView.getxTABLA().getSelectionModel().isSelectionEmpty()) {
            proveedorView.showInfo("Debes seleccionar una fila para editar o eliminar");
            return;
        }
        try {
            proveedorDAO.delete(list.get(proveedorView.getxTABLA().getSelectedRow()).getIdProveedor());
            fill();
            proveedorView.showInfo("Proveedor borrada");
        } catch (BusinessException ex) {
            proveedorView.showError("Error al borrar proveedor");
        }
    }

    private void edit() {
        if(proveedorView.getxTABLA().getSelectionModel().isSelectionEmpty()) {
            proveedorView.showInfo("Debes seleccionar una fila para editar o eliminar");
            return;
        }
        
        InputProveedorView inputProveedorView = new InputProveedorView(proveedorView, true);
        inputProveedorView.editarVentana("Editar");
       
        inputProveedorView.getxTextFieldNOMBRE().setText(list.get(proveedorView.getxTABLA().getSelectedRow()).getNombre());
        inputProveedorView.getxTextFieldCIF().setText(list.get(proveedorView.getxTABLA().getSelectedRow()).getCIF());
        inputProveedorView.getxTextFieldCP().setText(list.get(proveedorView.getxTABLA().getSelectedRow()).getCp());
        inputProveedorView.getxTextFieldDIR().setText(list.get(proveedorView.getxTABLA().getSelectedRow()).getDir());
        inputProveedorView.getxTextFieldPOB().setText(list.get(proveedorView.getxTABLA().getSelectedRow()).getPob());
        inputProveedorView.getxTextFieldPROV().setText(list.get(proveedorView.getxTABLA().getSelectedRow()).getProv());
        inputProveedorView.getxTextFieldTEL().setText(list.get(proveedorView.getxTABLA().getSelectedRow()).getTel());

        inputProveedorView.getxBotonACEPTAR().addActionListener(e -> inputAceptarClicked(inputProveedorView, false));

        inputProveedorView.setVisible(true);
    }

    private void inputAceptarClicked(InputProveedorView inputProveedorView, boolean isAdd) {
        if (inputProveedorView.getxTextFieldNOMBRE().getText().isEmpty()) {
            inputProveedorView.showInfo("El campo 'nombre' no puede estar vacio");
            return;
        }
        if (inputProveedorView.getxTextFieldCIF().getText().isEmpty()) {
            inputProveedorView.showInfo("El campo 'cif' no puede estar vacio");
            return;
        }
        if (inputProveedorView.getxTextFieldCP().getText().isEmpty()) {
            inputProveedorView.showInfo("El campo 'codigo postal' no puede estar vacio");
            return;
        }
        if (inputProveedorView.getxTextFieldDIR().getText().isEmpty()) {
            inputProveedorView.showInfo("El campo 'dir' no puede estar vacio");
            return;
        }
        if (inputProveedorView.getxTextFieldPOB().getText().isEmpty()) {
            inputProveedorView.showInfo("El campo 'poblacion' no puede estar vacio");
            return;
        }
        if (inputProveedorView.getxTextFieldPROV().getText().isEmpty()) {
            inputProveedorView.showInfo("El campo 'provincia' no puede estar vacio");
            return;
        }
        if (inputProveedorView.getxTextFieldTEL().getText().isEmpty()) {
            inputProveedorView.showInfo("El campo 'telefono' no puede estar vacio");
            return;
        }
        if (isAdd) {
            try {
                Proveedor p = new Proveedor();
                p.setCIF(inputProveedorView.getxTextFieldCIF().getText());
                p.setCp(inputProveedorView.getxTextFieldCP().getText());
                p.setDir(inputProveedorView.getxTextFieldDIR().getText());
                p.setNombre(inputProveedorView.getxTextFieldNOMBRE().getText());
                p.setPob(inputProveedorView.getxTextFieldPOB().getText());
                p.setProv(inputProveedorView.getxTextFieldPROV().getText());
                p.setTel(inputProveedorView.getxTextFieldTEL().getText());
                
                proveedorDAO.insert(p);
            } catch (BusinessException e) {
                inputProveedorView.showInfo(e.getMessage());
                return;
            }catch (Exception e) {
                inputProveedorView.showInfo("Error al insertar producto");
                return;
            }
        } else { //si no es añadir es editar
             try {
                Proveedor p = new Proveedor();
                
                p.setIdProveedor(list.get(proveedorView.getxTABLA().getSelectedRow()).getIdProveedor());

                p.setCIF(inputProveedorView.getxTextFieldCIF().getText());
                p.setCp(inputProveedorView.getxTextFieldCP().getText());
                p.setDir(inputProveedorView.getxTextFieldDIR().getText());
                p.setNombre(inputProveedorView.getxTextFieldNOMBRE().getText());
                p.setPob(inputProveedorView.getxTextFieldPOB().getText());
                p.setProv(inputProveedorView.getxTextFieldPROV().getText());
                p.setTel(inputProveedorView.getxTextFieldTEL().getText());
                
                proveedorDAO.update(p);
                
            } catch (BusinessException e) {
                inputProveedorView.showInfo(e.getMessage());
                return;
            } catch (Exception e) {
                inputProveedorView.showInfo("Error al insertar producto");
                return;
            }
        }
        inputProveedorView.dispose();
        fill();
    }

    private void search() {
        try {
            this.list = proveedorDAO.getAllFilter(proveedorView.getxTextFieldBUSCAR().getText());

            if (list == null || list.isEmpty()) {
                proveedorView.showInfo("No hay proveedores en la base de datos");
            } else {
                DefaultTableModel dtm = (DefaultTableModel) proveedorView.getxTABLA().getModel();
                dtm.setRowCount(0);
                for (int i = 0; i < list.size(); i++) {
                    dtm.addRow(new Object[]{list.get(i).getNombre(),
                        list.get(i).getDir(),
                        list.get(i).getPob(),
                        list.get(i).getCp(),
                        list.get(i).getCIF(),
                        list.get(i).getProv(),
                        list.get(i).getTel()
                    });
                }
                proveedorView.getxTABLA().setModel(dtm);
                proveedorView.getxTABLA().updateUI();
            }
        } catch (BusinessException e) {
            proveedorView.showError("Error al obtener datos de la base de datos");
            e.printStackTrace();
        }
        
    }
    
    /*
    * Esta funcion es para volver al menu
     */
    private void back() {
        proveedorView.dispose();
        menuViewController.setVisible(true);
    }
}
