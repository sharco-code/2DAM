package View;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

/**
 *
 * @author lliurex
 */
public class MainView extends javax.swing.JFrame {

    public JComboBox<String> getjComboBoxEsMenu() {
        return jComboBoxEsMenu;
    }

    public JButton getjButtonAcceder() {
        return jButtonAcceder;
    }

    public JLabel getjLabelImagen() {
        return jLabelImagen;
    }

    public JTextField getjTextFieldFamilia() {
        return jTextFieldFamilia;
    }

    /**
     * Creates new form MainView
     */
    public MainView() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            initComponents();
            setLocationRelativeTo(null);
        } catch (Exception e) {
            initComponents();
            setLocationRelativeTo(null);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        MainPanel = new javax.swing.JPanel();
        PanelTitle = new javax.swing.JPanel();
        jlabelTitle = new javax.swing.JLabel();
        PanelSouth = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jButtonAcceder = new javax.swing.JButton();
        PanelCenter = new javax.swing.JPanel();
        PanelCenter_Main = new javax.swing.JPanel();
        Panel_buttonWEST = new javax.swing.JPanel();
        jButtonWEST = new javax.swing.JButton();
        Panel_buttonEAST = new javax.swing.JPanel();
        jButtonEAST = new javax.swing.JButton();
        PanelData = new javax.swing.JPanel();
        PanelDataLeft = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldFamilia = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxEsMenu = new javax.swing.JComboBox<String>();
        PanelDataRight = new javax.swing.JPanel();
        jLabelImagen = new javax.swing.JLabel();
        PanelFirst = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jButtonAdd = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jButtonEdit = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jTextFieldSearch = new javax.swing.JTextField();
        jButtonSearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 300));
        setResizable(false);

        MainPanel.setBackground(new java.awt.Color(255, 255, 255));
        MainPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        MainPanel.setLayout(new java.awt.BorderLayout());

        PanelTitle.setBackground(new java.awt.Color(255, 255, 255));
        PanelTitle.setPreferredSize(new java.awt.Dimension(1, 45));

        jlabelTitle.setBackground(new java.awt.Color(204, 255, 255));
        jlabelTitle.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jlabelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlabelTitle.setText("Familias");
        jlabelTitle.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jlabelTitle.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 10));
        jlabelTitle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jlabelTitle.setMaximumSize(new java.awt.Dimension(70, 30));
        jlabelTitle.setMinimumSize(new java.awt.Dimension(70, 30));
        jlabelTitle.setPreferredSize(new java.awt.Dimension(70, 30));

        javax.swing.GroupLayout PanelTitleLayout = new javax.swing.GroupLayout(PanelTitle);
        PanelTitle.setLayout(PanelTitleLayout);
        PanelTitleLayout.setHorizontalGroup(
            PanelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 636, Short.MAX_VALUE)
            .addGroup(PanelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelTitleLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jlabelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        PanelTitleLayout.setVerticalGroup(
            PanelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
            .addGroup(PanelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelTitleLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jlabelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        MainPanel.add(PanelTitle, java.awt.BorderLayout.NORTH);

        PanelSouth.setBackground(new java.awt.Color(255, 255, 255));

        jButtonAcceder.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonAcceder.setText("Acceder a los productos");
        jPanel4.add(jButtonAcceder);

        PanelSouth.add(jPanel4);

        MainPanel.add(PanelSouth, java.awt.BorderLayout.SOUTH);

        PanelCenter.setLayout(new java.awt.BorderLayout());

        PanelCenter_Main.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        PanelCenter_Main.setLayout(new java.awt.BorderLayout());

        Panel_buttonWEST.setLayout(new java.awt.GridBagLayout());

        jButtonWEST.setBackground(new java.awt.Color(255, 255, 255));
        jButtonWEST.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jButtonWEST.setText("<");
        jButtonWEST.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonWEST.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButtonWEST.setPreferredSize(new java.awt.Dimension(45, 50));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        Panel_buttonWEST.add(jButtonWEST, gridBagConstraints);

        PanelCenter_Main.add(Panel_buttonWEST, java.awt.BorderLayout.WEST);

        Panel_buttonEAST.setLayout(new java.awt.GridBagLayout());

        jButtonEAST.setBackground(new java.awt.Color(255, 255, 255));
        jButtonEAST.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jButtonEAST.setText(">");
        jButtonEAST.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonEAST.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButtonEAST.setPreferredSize(new java.awt.Dimension(45, 50));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        Panel_buttonEAST.add(jButtonEAST, gridBagConstraints);

        PanelCenter_Main.add(Panel_buttonEAST, java.awt.BorderLayout.EAST);

        PanelData.setLayout(new java.awt.GridLayout(1, 0));

        PanelDataLeft.setLayout(new java.awt.GridLayout(2, 1));

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setText("Familia:  ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        jPanel2.add(jLabel2, gridBagConstraints);

        jTextFieldFamilia.setEditable(false);
        jTextFieldFamilia.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTextFieldFamilia.setMinimumSize(new java.awt.Dimension(150, 35));
        jTextFieldFamilia.setPreferredSize(new java.awt.Dimension(150, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        jPanel2.add(jTextFieldFamilia, gridBagConstraints);

        PanelDataLeft.add(jPanel2);

        jPanel3.setLayout(new java.awt.GridBagLayout());

        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setText("EsMenu:          ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        jPanel3.add(jLabel3, gridBagConstraints);

        jComboBoxEsMenu.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jComboBoxEsMenu.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SI", "NO" }));
        jComboBoxEsMenu.setEnabled(false);
        jComboBoxEsMenu.setMinimumSize(new java.awt.Dimension(100, 35));
        jComboBoxEsMenu.setPreferredSize(new java.awt.Dimension(100, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        jPanel3.add(jComboBoxEsMenu, gridBagConstraints);

        PanelDataLeft.add(jPanel3);

        PanelData.add(PanelDataLeft);

        jLabelImagen.setMaximumSize(new java.awt.Dimension(180, 180));
        jLabelImagen.setPreferredSize(new java.awt.Dimension(180, 180));

        javax.swing.GroupLayout PanelDataRightLayout = new javax.swing.GroupLayout(PanelDataRight);
        PanelDataRight.setLayout(PanelDataRightLayout);
        PanelDataRightLayout.setHorizontalGroup(
            PanelDataRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(PanelDataRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelDataRightLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        PanelDataRightLayout.setVerticalGroup(
            PanelDataRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 232, Short.MAX_VALUE)
            .addGroup(PanelDataRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelDataRightLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        PanelData.add(PanelDataRight);

        PanelCenter_Main.add(PanelData, java.awt.BorderLayout.CENTER);

        PanelCenter.add(PanelCenter_Main, java.awt.BorderLayout.CENTER);

        PanelFirst.setBackground(new java.awt.Color(250, 250, 250));
        PanelFirst.setLayout(new javax.swing.BoxLayout(PanelFirst, javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setBackground(new java.awt.Color(245, 245, 245));

        jButtonAdd.setText("Añadir");
        jPanel1.add(jButtonAdd);

        jButtonDelete.setText("Eliminar");
        jPanel1.add(jButtonDelete);

        jButtonEdit.setText("Editar");
        jPanel1.add(jButtonEdit);

        PanelFirst.add(jPanel1);

        jPanel6.setPreferredSize(new java.awt.Dimension(1500, 1));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 193, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 33, Short.MAX_VALUE)
        );

        PanelFirst.add(jPanel6);

        jTextFieldSearch.setMinimumSize(new java.awt.Dimension(150, 20));
        jTextFieldSearch.setPreferredSize(new java.awt.Dimension(150, 20));
        jPanel5.add(jTextFieldSearch);

        jButtonSearch.setText("Buscar");
        jPanel5.add(jButtonSearch);

        PanelFirst.add(jPanel5);

        PanelCenter.add(PanelFirst, java.awt.BorderLayout.PAGE_START);

        MainPanel.add(PanelCenter, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainView().setVisible(true);
            }
        });
    }

    public void messageERROR(String msg) {
        JOptionPane.showMessageDialog(
                null,
                msg,
                "INFO",
                JOptionPane.ERROR_MESSAGE);
    }

    public void messageINFO(String msg) {
        JOptionPane.showMessageDialog(
                null,
                msg,
                "INFO",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public JButton getjButtonAdd() {
        return jButtonAdd;
    }

    public JButton getjButtonEAST() {
        return jButtonEAST;
    }

    public JButton getjButtonEdit() {
        return jButtonEdit;
    }

    public JButton getjButtonSearch() {
        return jButtonSearch;
    }

    public JButton getjButtonDelete() {
        return jButtonDelete;
    }

    public JButton getjButtonWEST() {
        return jButtonWEST;
    }

    public JTextField getjTextFieldSearch() {
        return jTextFieldSearch;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MainPanel;
    private javax.swing.JPanel PanelCenter;
    private javax.swing.JPanel PanelCenter_Main;
    private javax.swing.JPanel PanelData;
    private javax.swing.JPanel PanelDataLeft;
    private javax.swing.JPanel PanelDataRight;
    private javax.swing.JPanel PanelFirst;
    private javax.swing.JPanel PanelSouth;
    private javax.swing.JPanel PanelTitle;
    private javax.swing.JPanel Panel_buttonEAST;
    private javax.swing.JPanel Panel_buttonWEST;
    private javax.swing.JButton jButtonAcceder;
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonEAST;
    private javax.swing.JButton jButtonEdit;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JButton jButtonWEST;
    private javax.swing.JComboBox<String> jComboBoxEsMenu;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelImagen;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JTextField jTextFieldFamilia;
    private javax.swing.JTextField jTextFieldSearch;
    private javax.swing.JLabel jlabelTitle;
    // End of variables declaration//GEN-END:variables
}
