package interfaz;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import dao.DaoDepartamento;
import dao.DaoGrupo;
import dao.DaoRol;
import dao.DaoUsuario;
import excepciones.BusinessException;
import jdbc.ConexionJdbc;
import pojos.Departamento;
import pojos.Grupo;
import pojos.Rol;
import pojos.Usuario;

public class TestConsultarDepartamentos extends javax.swing.JFrame {

	public TestConsultarDepartamentos() {
		initComponents();
		setLocationRelativeTo(null);

		// conectarse
		ConexionJdbc con = new ConexionJdbc("configuracion\\configuracion.txt");
		con.conectar();
	}

	@SuppressWarnings("unchecked")
	private void initComponents() {

		jPanel2 = new javax.swing.JPanel();
		jLabel3 = new javax.swing.JLabel();
		jPanel1 = new javax.swing.JPanel();
		jLabel2 = new javax.swing.JLabel();
		jTextField2 = new javax.swing.JTextField();
		jPanel5 = new javax.swing.JPanel();
		jButton3 = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setResizable(false);
		getContentPane().setLayout(new java.awt.GridLayout(3, 1));

		jPanel2.setBackground(new java.awt.Color(255, 255, 255));

		jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
		jLabel3.setText("TestConsultarDepartamentos");

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 584, Short.MAX_VALUE)
				.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel2Layout.createSequentialGroup().addGap(0, 138, Short.MAX_VALUE)
								.addComponent(jLabel3).addGap(0, 138, Short.MAX_VALUE))));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 66, Short.MAX_VALUE)
				.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel2Layout.createSequentialGroup().addGap(0, 18, Short.MAX_VALUE)
								.addComponent(jLabel3).addGap(0, 19, Short.MAX_VALUE))));

		getContentPane().add(jPanel2);

		jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
		jLabel2.setText("Nombre de departamento:    ");
		jPanel1.add(jLabel2);

		jTextField2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
		jTextField2.setPreferredSize(new java.awt.Dimension(160, 35));
		jPanel1.add(jTextField2);

		getContentPane().add(jPanel1);

		jPanel5.setBackground(new java.awt.Color(255, 255, 255));
		jPanel5.setLayout(new java.awt.GridBagLayout());

		jButton3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
		jButton3.setText("Consultar");
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});
		jPanel5.add(jButton3, new java.awt.GridBagConstraints());

		getContentPane().add(jPanel5);

		pack();
	}
	private String strx;
	private void setStrx(String strx) {
		this.strx = strx;
	}
	
	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
		strx = null;
		DaoDepartamento daoDepartamento = new DaoDepartamento();

		try {
			List<Departamento> list = daoDepartamento.buscarTodos();
			
			list.forEach((i) -> {
				if(i.getNombre().equals(this.jTextField2.getText())) {
					setStrx("<html><b><u>  - Departamento - </u><br></b><br><b>Nombre: </b>"+i.getNombre()+"<br><b>ID:</b> "+i.getIddepartamento()+"</html>");
					return;
				}
			});
			if(strx == null) messageERROR("No se encontro en la base de datos");
			else messageINFO(strx);
		}  catch (BusinessException e) {
			messageERROR(e.getMessage());
		}
		
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
			java.util.logging.Logger.getLogger(TestConsultarDepartamentos.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(TestConsultarDepartamentos.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(TestConsultarDepartamentos.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(TestConsultarDepartamentos.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		}

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new TestConsultarDepartamentos().setVisible(true);
			}
		});
	}

	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JPanel jPanel5;
	private javax.swing.JTextField jTextField2;
}
