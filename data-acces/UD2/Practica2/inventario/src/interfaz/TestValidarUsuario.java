package interfaz;

import javax.swing.JOptionPane;

import dao.DaoDepartamento;
import dao.DaoGrupo;
import dao.DaoUsuario;
import jdbc.ConexionJdbc;

public class TestValidarUsuario extends javax.swing.JFrame {

    public TestValidarUsuario() {
        initComponents();
        setLocationRelativeTo(null);
        
      //conectarse
  		ConexionJdbc con = new ConexionJdbc("configuracion\\configuracion.txt");
  		con.conectar();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabelUsuario = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabelPassowrd = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(4, 1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("TestValidarUsuario");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 672, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 237, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addGap(0, 237, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 47, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 9, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addGap(0, 9, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel2);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Usuario:   ");
        jPanel1.add(jLabel2);

        jLabelUsuario.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabelUsuario.setPreferredSize(new java.awt.Dimension(160, 35));
        jPanel1.add(jLabelUsuario);

        getContentPane().add(jPanel1);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Contraseña: ");
        jPanel4.add(jLabel4);

        jLabelPassowrd.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabelPassowrd.setPreferredSize(new java.awt.Dimension(160, 35));
        jPanel4.add(jLabelPassowrd);

        getContentPane().add(jPanel4);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton1.setText("Validar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);

        getContentPane().add(jPanel3);

        pack();
    }                        

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    	DaoUsuario daoUsuario = new DaoUsuario(new DaoDepartamento(), new DaoGrupo());
    	
		if(daoUsuario.validar(jLabelUsuario.getText(), jLabelPassowrd.getText())) messageINFO("Usuario validado correctamente");
		else messageERROR("No se ha podido validar");

    	
    }                                        

    public void messageERROR(String msg) {
        JOptionPane.showMessageDialog(
                null,
                msg,
                "ERROR",
                JOptionPane.ERROR_MESSAGE);
    }

    public void messageINFO(String msg) {
        JOptionPane.showMessageDialog(
                null,
                msg,
                "INFO",
                JOptionPane.INFORMATION_MESSAGE);
    }
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TestValidarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TestValidarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TestValidarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TestValidarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TestValidarUsuario().setVisible(true);
            }
        });
    }
                    
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jLabelPassowrd;
    private javax.swing.JTextField jLabelUsuario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;                 
}
