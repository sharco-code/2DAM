package Controller;

import DAO.*;
import Exceptions.BusinessException;
import Model.Compra;
import Model.Producto;
import Model.Proveedor;
import View.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class ComprasViewController {

    private ComprasView comprasView;

    private MenuViewController menuViewController;

    private List<Compra> list;

    private CompraDAO compraDAO = new CompraDAO();
    private ProveedorDAO proveedorDAO = new ProveedorDAO();
    private ProductoDAO productoDAO = new ProductoDAO();

    public ComprasViewController(ComprasView comprasView, MenuViewController menuViewController) {
        this.comprasView = comprasView;
        this.menuViewController = menuViewController;

        this.comprasView.getxBotonAdd().addActionListener(e -> add());
        this.comprasView.getxBotonDelete().addActionListener(e -> delete());
        this.comprasView.getxBotonEdit().addActionListener(e -> edit());

        this.comprasView.getxBotonSEARCH().addActionListener(e -> search());
        
        this.comprasView.getxBotonVOLVER().addActionListener(e -> back());
        
        this.comprasView.getxTABLA().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                comprasView.getxBotonEdit().setEnabled(true);
                comprasView.getxBotonDelete().setEnabled(true);
            }
        });
        
        fill();
    }

    private void fill() {
        //conseguir datos de la bbdd y rellenarlos
        try {
            this.list = compraDAO.getAll();

            if (list == null || list.isEmpty()) {
                comprasView.showInfo("No hay compras en la base de datos");
            } else {
                DefaultTableModel dtm = (DefaultTableModel) comprasView.getxTABLA().getModel();
                dtm.setRowCount(0);
                for (int i = 0; i < list.size(); i++) {
                    dtm.addRow(new Object[]{productoDAO.getNombre(list.get(i).getIdProducto()),
                        list.get(i).getCantidad(),
                        list.get(i).getFecha(),
                        (proveedorDAO.searchById(list.get(i).getIdProveedor()).getNombre())
                    });
                }
                comprasView.getxTABLA().setModel(dtm);
                comprasView.getxTABLA().updateUI();
            }
        } catch (BusinessException e) {
            comprasView.showError("Error al obtener datos de la base de datos");
            e.printStackTrace();
        }
    }
    
    private void add() {
        InputCompraView inputCompraView = new InputCompraView(comprasView, true);
        inputCompraView.editarVentana("Añadir");
       
        try {
            final List<Proveedor> listProveedor = proveedorDAO.getAll();
            if (listProveedor == null) {
                throw new BusinessException("No hay proveedores");
            }
            for (int i = 0; i < listProveedor.size(); i++) {
                inputCompraView.getxComboBoxPROVEEDOR().addItem(listProveedor.get(i).getNombre());
            }
            
            final List<Producto> listProducto = productoDAO.getAll();
            if (listProducto == null) {
                throw new BusinessException("No hay productos");
            }
            for (int i = 0; i < listProducto.size(); i++) {
                inputCompraView.getxComboBoxPRODUCTO().addItem(listProducto.get(i).getNombre());
            }
            
            inputCompraView.getxBotonACEPTAR().addActionListener(e -> inputAceptarClicked(inputCompraView, true, listProveedor, listProducto));
        } catch (BusinessException ex) {
            inputCompraView.showError(ex.getMessage());
        }

        inputCompraView.setVisible(true);
    }

    private void delete() {
        if(comprasView.getxTABLA().getSelectionModel().isSelectionEmpty()) {
            comprasView.showInfo("Debes seleccionar una fila para editar o eliminar");
            return;
        }
        try {
            compraDAO.delete(list.get(comprasView.getxTABLA().getSelectedRow()).getIdCompra());
            fill();
            comprasView.showInfo("Compra borrada");
        } catch (BusinessException ex) {
            comprasView.showError("Error al borrar compra");
            ex.printStackTrace();
        }
    }

    private void edit() {
        if(comprasView.getxTABLA().getSelectionModel().isSelectionEmpty()) {
            comprasView.showInfo("Debes seleccionar una fila para editar o eliminar");
            return;
        }
        
        InputCompraView inputCompraView = new InputCompraView(comprasView, true);
        inputCompraView.editarVentana("Editar");
       
        try {
            final List<Proveedor> listProveedor = proveedorDAO.getAll();
            if (listProveedor == null) {
                throw new BusinessException("No hay proveedores");
            }
            for (int i = 0; i < listProveedor.size(); i++) {
                inputCompraView.getxComboBoxPROVEEDOR().addItem(listProveedor.get(i).getNombre());
                if(listProveedor.get(i).getIdProveedor() == list.get(comprasView.getxTABLA().getSelectedRow()).getIdProveedor()) inputCompraView.getxComboBoxPROVEEDOR().setSelectedIndex(i);
            }
            
            final List<Producto> listProducto = productoDAO.getAll();
            if (listProducto == null) {
                throw new BusinessException("No hay productos");
            }
            for (int i = 0; i < listProducto.size(); i++) {
                inputCompraView.getxComboBoxPRODUCTO().addItem(listProducto.get(i).getNombre());
                 if(listProducto.get(i).getIdProducto() == list.get(comprasView.getxTABLA().getSelectedRow()).getIdProducto()) inputCompraView.getxComboBoxPRODUCTO().setSelectedIndex(i);
            }
            
            inputCompraView.getxTextFieldCANTIDAD().setText(Double.toString(list.get(comprasView.getxTABLA().getSelectedRow()).getCantidad()));
            
            inputCompraView.getxBotonACEPTAR().addActionListener(e -> inputAceptarClicked(inputCompraView, false, listProveedor, listProducto));
        } catch (BusinessException ex) {
            inputCompraView.showError(ex.getMessage());
        }

        inputCompraView.setVisible(true);
    }

    private void inputAceptarClicked(InputCompraView inputCompraView, boolean isAdd, List<Proveedor> listProveedor, List<Producto> listProducto) {
        if (inputCompraView.getxTextFieldCANTIDAD().getText().isEmpty()) {
            inputCompraView.showInfo("El campo 'cantidad' no puede estar vacio");
            return;
        }
        if (isAdd) {
            try {
                Compra c = new Compra();
                c.setCantidad(Double.parseDouble(inputCompraView.getxTextFieldCANTIDAD().getText()));
                c.setIdProducto(listProducto.get(inputCompraView.getxComboBoxPRODUCTO().getSelectedIndex()).getIdProducto());
                c.setIdProveedor(listProveedor.get(inputCompraView.getxComboBoxPROVEEDOR().getSelectedIndex()).getIdProveedor());
                
                Calendar f = new GregorianCalendar();
                c.setFecha(new String(Integer.toString(f.get(Calendar.YEAR))+"-"+Integer.toString(f.get(Calendar.MONTH))+"-"+Integer.toString(f.get(Calendar.DATE))));
                
                compraDAO.insert(c);
            } catch (BusinessException e) {
                inputCompraView.showInfo(e.getMessage());
                return;
            } catch (java.lang.NumberFormatException e) {
                inputCompraView.showInfo("El campo 'cosantidad' tiene que ser numerico");
                return;
            } catch (Exception e) {
                inputCompraView.showInfo("Error al insertar producto");
                return;
            }
        } else { //si no es añadir es editar
             try {
                Compra c = new Compra();
                c.setIdCompras(list.get(comprasView.getxTABLA().getSelectedRow()).getIdCompra());
                c.setCantidad(Double.parseDouble(inputCompraView.getxTextFieldCANTIDAD().getText()));
                c.setIdProducto(listProducto.get(inputCompraView.getxComboBoxPRODUCTO().getSelectedIndex()).getIdProducto());
                c.setIdProveedor(listProveedor.get(inputCompraView.getxComboBoxPROVEEDOR().getSelectedIndex()).getIdProveedor());
                
                Calendar f = new GregorianCalendar();
                c.setFecha(new String(Integer.toString(f.get(Calendar.YEAR))+"-"+Integer.toString(f.get(Calendar.MONTH))+"-"+Integer.toString(f.get(Calendar.DATE))));
                
                compraDAO.update(c);
                
            } catch (BusinessException e) {
                inputCompraView.showInfo(e.getMessage());
                return;
            } catch (java.lang.NumberFormatException e) {
                inputCompraView.showInfo("El campo 'cosantidad' tiene que ser numerico");
                return;
            } catch (Exception e) {
                inputCompraView.showInfo("Error al insertar producto");
                return;
            }
        }
        inputCompraView.dispose();
        fill();
    }

    private void search() {
        try {
            this.list = compraDAO.getAllFilter(comprasView.getxTextFieldBUSCAR().getText());

            if (list == null || list.isEmpty()) {
                comprasView.showInfo("No hay compras en la base de datos");
            } else {
                DefaultTableModel dtm = (DefaultTableModel) comprasView.getxTABLA().getModel();
                dtm.setRowCount(0);
                for (int i = 0; i < list.size(); i++) {
                    dtm.addRow(new Object[]{productoDAO.getNombre(list.get(i).getIdProducto()),
                        list.get(i).getCantidad(),
                        list.get(i).getFecha(),
                        (proveedorDAO.searchById(list.get(i).getIdProveedor()).getNombre())
                    });
                }
                comprasView.getxTABLA().setModel(dtm);
                comprasView.getxTABLA().updateUI();
            }
        } catch (BusinessException e) {
            comprasView.showError("Error al obtener datos de la base de datos");
            e.printStackTrace();
        }
        
    }
    
    /*
    * Esta funcion es para volver al menu
     */
    private void back() {
        comprasView.dispose();
        menuViewController.setVisible(true);
    }
}
