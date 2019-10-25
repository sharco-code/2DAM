package View;

public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        MainPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jlabelTitle = new javax.swing.JLabel();
        PanelCenter = new javax.swing.JPanel();
        PanelUsername = new javax.swing.JPanel();
        jLabelUsername = new javax.swing.JLabel();
        jTextFieldUsername = new javax.swing.JTextField();
        PanelPassword = new javax.swing.JPanel();
        jLabelPassword = new javax.swing.JLabel();
        jTextFieldPassword = new javax.swing.JPasswordField();
        PanelSouth = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 400, 300));
        setMaximumSize(new java.awt.Dimension(500, 400));
        setMinimumSize(new java.awt.Dimension(350, 250));
        setModalExclusionType(null);
        setName("login"); // NOI18N
        setPreferredSize(new java.awt.Dimension(445, 320));
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);

        MainPanel.setBackground(new java.awt.Color(255, 255, 255));
        MainPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        MainPanel.setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1, 45));

        jlabelTitle.setBackground(new java.awt.Color(204, 255, 255));
        jlabelTitle.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jlabelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlabelTitle.setText("Login");
        jlabelTitle.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jlabelTitle.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 10));
        jlabelTitle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jlabelTitle.setMaximumSize(new java.awt.Dimension(70, 30));
        jlabelTitle.setMinimumSize(new java.awt.Dimension(70, 30));
        jlabelTitle.setPreferredSize(new java.awt.Dimension(70, 30));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 456, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jlabelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jlabelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jlabelTitle.getAccessibleContext().setAccessibleName("jlabelTitle");

        MainPanel.add(jPanel1, java.awt.BorderLayout.NORTH);

        PanelCenter.setLayout(new java.awt.GridLayout(2, 1));

        PanelUsername.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        PanelUsername.setLayout(new java.awt.GridBagLayout());

        jLabelUsername.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabelUsername.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelUsername.setText("Username");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 4;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 19);
        PanelUsername.add(jLabelUsername, gridBagConstraints);

        jTextFieldUsername.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTextFieldUsername.setText("root");
        jTextFieldUsername.setMinimumSize(new java.awt.Dimension(150, 30));
        jTextFieldUsername.setPreferredSize(new java.awt.Dimension(150, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        PanelUsername.add(jTextFieldUsername, gridBagConstraints);

        PanelCenter.add(PanelUsername);

        PanelPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        PanelPassword.setLayout(new java.awt.GridBagLayout());

        jLabelPassword.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabelPassword.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPassword.setText("Passowrd");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 4;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 19);
        PanelPassword.add(jLabelPassword, gridBagConstraints);

        jTextFieldPassword.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTextFieldPassword.setText("root");
        jTextFieldPassword.setMinimumSize(new java.awt.Dimension(150, 30));
        jTextFieldPassword.setPreferredSize(new java.awt.Dimension(150, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        PanelPassword.add(jTextFieldPassword, gridBagConstraints);

        PanelCenter.add(PanelPassword);

        MainPanel.add(PanelCenter, java.awt.BorderLayout.CENTER);

        PanelSouth.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Entrar");
        jButton1.setMaximumSize(new java.awt.Dimension(80, 30));
        jButton1.setMinimumSize(new java.awt.Dimension(80, 30));
        jButton1.setPreferredSize(new java.awt.Dimension(180, 50));
        PanelSouth.add(jButton1);

        MainPanel.add(PanelSouth, java.awt.BorderLayout.SOUTH);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MainPanel;
    private javax.swing.JPanel PanelCenter;
    private javax.swing.JPanel PanelPassword;
    private javax.swing.JPanel PanelSouth;
    private javax.swing.JPanel PanelUsername;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JLabel jLabelUsername;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jTextFieldPassword;
    private javax.swing.JTextField jTextFieldUsername;
    private javax.swing.JLabel jlabelTitle;
    // End of variables declaration//GEN-END:variables
}
