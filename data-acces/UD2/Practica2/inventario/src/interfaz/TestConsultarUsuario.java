package interfaz;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import dao.DaoDepartamento;
import dao.DaoGrupo;
import dao.DaoRol;
import dao.DaoTipoUsuario;
import dao.DaoUsuario;
import excepciones.BusinessException;
import jdbc.ConexionJdbc;
import pojos.Departamento;
import pojos.Grupo;
import pojos.Rol;
import pojos.Usuario;

public class TestConsultarUsuario extends javax.swing.JFrame {

	public TestConsultarUsuario() {
		initComponents();
		setLocationRelativeTo(null);
		
		// conectarse
		ConexionJdbc con = new ConexionJdbc("configuracion\\configuracion.txt");
		con.conectar();
	}

	@SuppressWarnings("unchecked")
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jPanel2 = new javax.swing.JPanel();
		jLabel3 = new javax.swing.JLabel();
		jPanel4 = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTextArea1 = new javax.swing.JTextArea();
		jPanel3 = new javax.swing.JPanel();
		jLabel2 = new javax.swing.JLabel();
		jTextFieldID = new javax.swing.JTextField();
		jPanel5 = new javax.swing.JPanel();
		jButton1 = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jPanel1.setLayout(new java.awt.GridLayout(4, 1));

		jPanel2.setBackground(new java.awt.Color(255, 255, 255));

		jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
		jLabel3.setText("TestConsultarUsuario");

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 859, Short.MAX_VALUE)
				.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel2Layout.createSequentialGroup().addGap(0, 317, Short.MAX_VALUE)
								.addComponent(jLabel3).addGap(0, 317, Short.MAX_VALUE))));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 83, Short.MAX_VALUE)
				.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel2Layout.createSequentialGroup().addGap(0, 27, Short.MAX_VALUE)
								.addComponent(jLabel3).addGap(0, 27, Short.MAX_VALUE))));

		jPanel1.add(jPanel2);

		jPanel4.setLayout(new java.awt.BorderLayout());

		jTextArea1.setEditable(false);
		jTextArea1.setColumns(20);
		jTextArea1.setRows(5);
		jTextArea1.setText(
				"Se solicitará al usuario un id de usuario. Si\nel usuario no existe se mostrará un mensaje por pantalla indicándolo. Si el\nusuario existe se mostrará su información por pantalla y:\n\n- Si se trata de un PROFESOR se mostrará el nombre del departamento al\nque pertenece.\n- Si se trata de un ALUMNO se mostrará el nombre del grupo al que\npertenece.\n\n");
		jTextArea1.setMinimumSize(new java.awt.Dimension(100, 100));
		jTextArea1.setPreferredSize(new java.awt.Dimension(800, 800));
		jScrollPane1.setViewportView(jTextArea1);

		jPanel4.add(jScrollPane1, java.awt.BorderLayout.CENTER);

		jPanel1.add(jPanel4);

		jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
		jLabel2.setText("ID:");
		jPanel3.add(jLabel2);

		jTextFieldID.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
		jTextFieldID.setPreferredSize(new java.awt.Dimension(160, 35));
		jPanel3.add(jTextFieldID);

		jPanel1.add(jPanel3);

		jPanel5.setBackground(new java.awt.Color(255, 255, 255));

		jButton1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
		jButton1.setText("Consultar");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});
		jPanel5.add(jButton1);

		jPanel1.add(jPanel5);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 859, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
										.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 859,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(0, 0, Short.MAX_VALUE))));
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 333, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
										.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 333,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(0, 0, Short.MAX_VALUE))));

		pack();
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		DaoDepartamento daoDepartamento = new DaoDepartamento();
		DaoRol daoRol = new DaoRol();
		DaoGrupo daoGrupo = new DaoGrupo();
    	DaoUsuario daoUsuario = new DaoUsuario(daoDepartamento, daoGrupo);
		try {
			Usuario u = daoUsuario.buscarPorId(Integer.parseInt(jTextFieldID.getText()));
			if(u == null) {
				messageERROR("Usuario no esta en la base de datos");
				return;
			}
			else {
				
				if(u.getTipo() == 1) {
					String dep ="null", rol="null";
					if(u.getDepartamento() != null) {
						Departamento d = daoDepartamento.buscarPorId(u.getDepartamento());
						dep = d.getNombre();
					}
					if(u.getRol() != null) {
						Rol r = daoRol.buscarPorId(u.getRol());
						rol = r.getNombre();
					}
					messageINFO("<html><b><u>  - Profesor - </u><br>Departamento: </b>"+dep+"<br><br><b>Nombre: </b>"+u.getNombre()+"<br><b>Apellido: </b>"+u.getApellido1()+" "+u.getApellido2()+
							"<br><b>Codigo postal: </b>"+u.getCodpostal()+
							"<br><b>Domicilio: </b>"+u.getDomicilio()+
							"<br><b>Email: </b>"+u.getEmail()+
							"<br><b>Rol: </b>"+rol+
							"</html>");
				} else if(u.getTipo() == 2) {
					String gru = "null", rol="null";
					if(u.getGrupo() != null) {
						Grupo g = daoGrupo.buscarPorId(u.getGrupo());
						gru = g.getNombre();
					}
					if(u.getRol() != null) {
						Rol r = daoRol.buscarPorId(u.getRol());
						rol = r.getNombre();
					}
					messageINFO("<html><b><u>  - Alumno - </u><br>Grupo: </b>"+gru+"<br><br><b>Nombre: </b>"+u.getNombre()+"<br><b>Apellido: </b>"+u.getApellido1()+" "+u.getApellido2()+
							"<br><b>Codigo postal: </b>"+u.getCodpostal()+
							"<br><b>Domicilio: </b>"+u.getDomicilio()+
							"<br><b>Email: </b>"+u.getEmail()+
							"<br><b>Rol: </b>"+rol+
							"</html>");
				} else {
					String rol = "null";
					if(u.getRol() != null) {
						Rol r = daoRol.buscarPorId(u.getRol());
						rol = r.getNombre();
					}
					messageINFO("<html><b><br>Rol: </b>"+rol+"<br><br><b>Nombre: </b>"+u.getNombre()+"<br><b>Apellido: </b>"+u.getApellido1()+" "+u.getApellido2()+
							"<br><b>Codigo postal: </b>"+u.getCodpostal()+
							"<br><b>Domicilio: </b>"+u.getDomicilio()+
							"<br><b>Email: </b>"+u.getEmail()+
							"</html>");
				}
				
			}
		} catch (Exception e) {
			messageERROR("Usuario no esta en la base de datos");
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
    		        JLabel label = new JLabel(msg);
    		        label.setFont(new Font("Arial", Font.PLAIN, 16));
    		        JOptionPane.showMessageDialog(null, label);
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
			java.util.logging.Logger.getLogger(TestConsultarUsuario.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(TestConsultarUsuario.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(TestConsultarUsuario.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(TestConsultarUsuario.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		}

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new TestConsultarUsuario().setVisible(true);
			}
		});
	}

	private javax.swing.JButton jButton1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JPanel jPanel5;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTextArea jTextArea1;
	private javax.swing.JTextField jTextFieldID;
}
