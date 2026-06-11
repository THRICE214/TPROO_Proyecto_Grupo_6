package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

public class Perfil extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JTextField txtNom;
	private JComboBox cboTipDoc;
	private JTextField txtCon;
	private JTextField txtDoc;
	private JTextField txtDir;
	private JTextField txtEmail;
	private JTextField txtTelef;
	private JButton btnMod;
	private JButton btnAdminC;
	private JButton btnSalir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Perfil frame = new Perfil();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Perfil() {
		setTitle("Perfil");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 354, 398);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(211, 211, 211));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel = new JLabel("Nombre:");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel.setBounds(10, 22, 46, 14);
			contentPane.add(lblNewLabel);
		}
		{
			lblNewLabel_1 = new JLabel("Contraseña:");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_1.setBounds(10, 61, 82, 14);
			contentPane.add(lblNewLabel_1);
		}
		{
			lblNewLabel_2 = new JLabel("Tipo de Documento:");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_2.setBounds(10, 99, 113, 14);
			contentPane.add(lblNewLabel_2);
		}
		{
			lblNewLabel_3 = new JLabel("Documento:");
			lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_3.setBounds(10, 137, 82, 14);
			contentPane.add(lblNewLabel_3);
		}
		{
			lblNewLabel_4 = new JLabel("Dirección:");
			lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_4.setBounds(10, 176, 82, 14);
			contentPane.add(lblNewLabel_4);
		}
		{
			lblNewLabel_5 = new JLabel("E-mail: ");
			lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_5.setBounds(10, 214, 46, 14);
			contentPane.add(lblNewLabel_5);
		}
		{
			lblNewLabel_6 = new JLabel("Telefono:");
			lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_6.setBounds(10, 254, 46, 14);
			contentPane.add(lblNewLabel_6);
		}
		{
			txtNom = new JTextField();
			txtNom.setBounds(122, 19, 185, 20);
			contentPane.add(txtNom);
			txtNom.setColumns(10);
		}
		{
			cboTipDoc = new JComboBox();
			cboTipDoc.setBounds(122, 96, 185, 20);
			contentPane.add(cboTipDoc);
		}
		{
			txtCon = new JTextField();
			txtCon.setColumns(10);
			txtCon.setBounds(122, 58, 185, 20);
			contentPane.add(txtCon);
		}
		{
			txtDoc = new JTextField();
			txtDoc.setColumns(10);
			txtDoc.setBounds(122, 134, 185, 20);
			contentPane.add(txtDoc);
		}
		{
			txtDir = new JTextField();
			txtDir.setColumns(10);
			txtDir.setBounds(122, 173, 185, 20);
			contentPane.add(txtDir);
		}
		{
			txtEmail = new JTextField();
			txtEmail.setColumns(10);
			txtEmail.setBounds(122, 211, 185, 20);
			contentPane.add(txtEmail);
		}
		{
			txtTelef = new JTextField();
			txtTelef.setColumns(10);
			txtTelef.setBounds(122, 251, 185, 20);
			contentPane.add(txtTelef);
		}
		{
			btnMod = new JButton("Modificar");
			btnMod.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnMod.setBounds(48, 287, 89, 23);
			contentPane.add(btnMod);
		}
		{
			btnAdminC = new JButton("Administrar Cuentas");
			btnAdminC.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnAdminC.setBounds(158, 287, 141, 23);
			contentPane.add(btnAdminC);
		}
		{
			btnSalir = new JButton("Salir");
			btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnSalir.setBounds(10, 325, 89, 23);
			contentPane.add(btnSalir);
		}

	}
}
