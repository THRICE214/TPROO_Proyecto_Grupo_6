package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Productos extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField txtNomP;
	private JTextField txtIdP;
	private JTextField txtPreP;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JTextField txtIdC;
	private JTextArea txtDesC;
	private JComboBox cboNomC;
	private JLabel lblNewLabel_8;
	private JButton btnAgregarP;
	private JButton btnBuscarP;
	private JButton btnModificarP;
	private JButton btnEliminarP;
	private JLabel lblNewLabel_9;
	private JButton btnAgregarC;
	private JButton btnBuscarC;
	private JButton btnEliminarC;
	private JButton btnModificarC;
	private JButton btnSalir;
	private JScrollPane scrollPane;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Productos frame = new Productos();
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
	public Productos() {
		setTitle("Gestion Productos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 666, 719);
		setResizable(false); //evitar cambiar el tamaño de la ventana
		setLocationRelativeTo(null); //centra la posicion de la ventana al ejecutar
		contentPane = new JPanel();
		contentPane.setBackground(new Color(194, 204, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel = new JLabel("Id:");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel.setBounds(10, 45, 19, 14);
			contentPane.add(lblNewLabel);
		}
		{
			lblNewLabel_1 = new JLabel("Nombre:");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_1.setBounds(10, 82, 46, 14);
			contentPane.add(lblNewLabel_1);
		}
		{
			lblNewLabel_2 = new JLabel("Precio:");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_2.setBounds(10, 118, 46, 14);
			contentPane.add(lblNewLabel_2);
		}
		{
			txtNomP = new JTextField();
			txtNomP.setEnabled(false);
			txtNomP.setBounds(77, 82, 206, 20);
			contentPane.add(txtNomP);
			txtNomP.setColumns(10);
		}
		{
			txtIdP = new JTextField();
			txtIdP.setEnabled(false);
			txtIdP.setColumns(10);
			txtIdP.setBounds(77, 45, 206, 20);
			contentPane.add(txtIdP);
		}
		{
			txtPreP = new JTextField();
			txtPreP.setEnabled(false);
			txtPreP.setColumns(10);
			txtPreP.setBounds(77, 118, 206, 20);
			contentPane.add(txtPreP);
		}
		{
			lblNewLabel_3 = new JLabel("Categoria:");
			lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_3.setBounds(333, 11, 66, 14);
			contentPane.add(lblNewLabel_3);
		}
		{
			lblNewLabel_4 = new JLabel("Id:");
			lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_4.setBounds(333, 48, 19, 14);
			contentPane.add(lblNewLabel_4);
		}
		{
			lblNewLabel_5 = new JLabel("Nombre:");
			lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_5.setBounds(333, 84, 46, 14);
			contentPane.add(lblNewLabel_5);
		}
		{
			lblNewLabel_6 = new JLabel("Producto:");
			lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_6.setBounds(10, 11, 60, 14);
			contentPane.add(lblNewLabel_6);
		}
		{
			lblNewLabel_7 = new JLabel("Descripción:");
			lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_7.setBounds(333, 121, 66, 14);
			contentPane.add(lblNewLabel_7);
		}
		{
			txtIdC = new JTextField();
			txtIdC.setEnabled(false);
			txtIdC.setColumns(10);
			txtIdC.setBounds(400, 45, 206, 20);
			contentPane.add(txtIdC);
		}
		{
			txtDesC = new JTextArea();
			txtDesC.setEnabled(false);
			txtDesC.setBounds(333, 144, 307, 186);
			contentPane.add(txtDesC);
		}
		{
			cboNomC = new JComboBox();
			cboNomC.setEnabled(false);
			cboNomC.setBounds(400, 80, 206, 22);
			contentPane.add(cboNomC);
		}
		{
			lblNewLabel_8 = new JLabel("Opciones de Producto:");
			lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_8.setBounds(10, 149, 172, 14);
			contentPane.add(lblNewLabel_8);
		}
		{
			btnAgregarP = new JButton("Agregar");
			btnAgregarP.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnAgregarP.addActionListener(this);
			btnAgregarP.setBounds(32, 174, 102, 23);
			contentPane.add(btnAgregarP);
		}
		{
			btnBuscarP = new JButton("Buscar");
			btnBuscarP.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnBuscarP.setBounds(194, 174, 102, 23);
			contentPane.add(btnBuscarP);
		}
		{
			btnModificarP = new JButton("Modificar");
			btnModificarP.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnModificarP.setBounds(32, 208, 102, 23);
			contentPane.add(btnModificarP);
		}
		{
			btnEliminarP = new JButton("Eliminar");
			btnEliminarP.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnEliminarP.setBounds(194, 208, 102, 23);
			contentPane.add(btnEliminarP);
		}
		{
			lblNewLabel_9 = new JLabel("Opciones de Categoria:");
			lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_9.setBounds(10, 242, 172, 14);
			contentPane.add(lblNewLabel_9);
		}
		{
			btnAgregarC = new JButton("Agregar");
			btnAgregarC.addActionListener(this);
			btnAgregarC.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnAgregarC.setBounds(32, 267, 102, 23);
			contentPane.add(btnAgregarC);
		}
		{
			btnBuscarC = new JButton("Buscar");
			btnBuscarC.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnBuscarC.setBounds(194, 267, 102, 23);
			contentPane.add(btnBuscarC);
		}
		{
			btnEliminarC = new JButton("Eliminar");
			btnEliminarC.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnEliminarC.setBounds(194, 301, 102, 23);
			contentPane.add(btnEliminarC);
		}
		{
			btnModificarC = new JButton("Modificar");
			btnModificarC.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnModificarC.setBounds(32, 301, 102, 23);
			contentPane.add(btnModificarC);
		}
		{
			btnSalir = new JButton("Salir");
			btnSalir.setBounds(10, 646, 89, 23);
			contentPane.add(btnSalir);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 347, 630, 288);
			contentPane.add(scrollPane);
			{
				panel = new JPanel();
				scrollPane.setViewportView(panel);
				GridBagLayout gbl_panel = new GridBagLayout();
				gbl_panel.columnWidths = new int[]{0};
				gbl_panel.rowHeights = new int[]{0};
				gbl_panel.columnWeights = new double[]{Double.MIN_VALUE};
				gbl_panel.rowWeights = new double[]{Double.MIN_VALUE};
				panel.setLayout(gbl_panel);
			}
		}

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAgregarC) {
			do_btnAgregarC_actionPerformed(e);
		}
		if (e.getSource() == btnAgregarP) {
			do_btnAgregarP_actionPerformed(e);
		}
	}
	
	public void limpiarCampos() {
		txtIdP.setText("");
		txtNomP.setText("");
		txtPreP.setText("");
		txtIdC.setText("");
		cboNomC.setSelectedItem("");
		txtDesC.setText("");
	}
	
	protected void do_btnAgregarP_actionPerformed(ActionEvent e) {
		if (btnAgregarP.getText() == "Agregar") {
			txtIdP.setEnabled(true);
			txtNomP.setEnabled(true);
			txtPreP.setEnabled(true);
			cboNomC.setEnabled(true);
			btnBuscarP.setEnabled(false);
			btnModificarP.setEnabled(false);
			btnEliminarP.setEnabled(false);
			btnAgregarC.setEnabled(false);
			btnBuscarC.setEnabled(false);
			btnModificarC.setEnabled(false);
			btnEliminarC.setEnabled(false);
			btnSalir.setEnabled(false);
			btnAgregarP.setText("Confirmar");
		}
		else {
			txtIdP.setEnabled(false);
			txtNomP.setEnabled(false);
			txtPreP.setEnabled(false);
			cboNomC.setEnabled(false);
			btnBuscarP.setEnabled(true);
			btnModificarP.setEnabled(true);
			btnEliminarP.setEnabled(true);
			btnAgregarC.setEnabled(true);
			btnBuscarC.setEnabled(true);
			btnModificarC.setEnabled(true);
			btnEliminarC.setEnabled(true);
			btnSalir.setEnabled(true);
			limpiarCampos();
			btnAgregarP.setText("Agregar");
		}
	}
	protected void do_btnAgregarC_actionPerformed(ActionEvent e) {
		if (btnAgregarC.getText() == "Agregar") {
			txtIdC.setEnabled(true);
			cboNomC.setEnabled(true);
			txtDesC.setEnabled(true);
			cboNomC.setEditable(true);
			btnBuscarP.setEnabled(false);
			btnModificarP.setEnabled(false);
			btnEliminarP.setEnabled(false);
			btnAgregarP.setEnabled(false);
			btnBuscarC.setEnabled(false);
			btnModificarC.setEnabled(false);
			btnEliminarC.setEnabled(false);
			btnSalir.setEnabled(false);
			btnAgregarC.setText("Confirmar");
		}
		else {
			txtIdC.setEnabled(false);
			cboNomC.setEnabled(false);
			txtDesC.setEnabled(false);
			cboNomC.setEditable(false);
			btnBuscarP.setEnabled(true);
			btnModificarP.setEnabled(true);
			btnEliminarP.setEnabled(true);
			btnAgregarP.setEnabled(true);
			btnBuscarC.setEnabled(true);
			btnModificarC.setEnabled(true);
			btnEliminarC.setEnabled(true);
			btnSalir.setEnabled(true);
			limpiarCampos();
			btnAgregarC.setText("Agregar");
		}
	}
}
