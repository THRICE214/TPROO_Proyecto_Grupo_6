package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNomUsu;
	private JButton btnAdministrador;
	private JButton btnCompra;
	private JButton btnVenta;
	private JButton btnProd;
	private JButton btnRegistro;
	private JButton btnSalir;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setTitle("Menú");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 343);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel = new JLabel("Bienvenid@");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblNewLabel.setBounds(10, 11, 120, 29);
			contentPane.add(lblNewLabel);
		}
		{
			lblNomUsu = new JLabel("\"Nombre de Usuario\"");
			lblNomUsu.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNomUsu.setBounds(10, 51, 414, 29);
			contentPane.add(lblNomUsu);
		}
		{
			btnAdministrador = new JButton("Administrar Usuarios");
			btnAdministrador.addActionListener(this);
			btnAdministrador.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnAdministrador.setBounds(293, 16, 131, 23);
			contentPane.add(btnAdministrador);
		}
		{
			btnCompra = new JButton("Compra");
			btnCompra.addActionListener(this);
			btnCompra.setBounds(65, 104, 105, 43);
			contentPane.add(btnCompra);
		}
		{
			btnVenta = new JButton("Venta");
			btnVenta.addActionListener(this);
			btnVenta.setBounds(255, 104, 105, 43);
			contentPane.add(btnVenta);
		}
		{
			btnProd = new JButton("Productos");
			btnProd.addActionListener(this);
			btnProd.setBounds(65, 195, 105, 43);
			contentPane.add(btnProd);
		}
		{
			btnRegistro = new JButton("Registro");
			btnRegistro.addActionListener(this);
			btnRegistro.setBounds(255, 195, 105, 43);
			contentPane.add(btnRegistro);
		}
		{
			btnSalir = new JButton("Salir");
			btnSalir.addActionListener(this);
			btnSalir.setBounds(10, 270, 89, 23);
			contentPane.add(btnSalir);
		}
		ImageIcon icono = new ImageIcon(LogIn.class.getResource("/Recursos/FonMenu.png"));

		Image imagenEscalada = icono.getImage().getScaledInstance(
		    434,
		    304,
		    Image.SCALE_SMOOTH
		);
		{
			lblNewLabel_2 = new JLabel("");
			lblNewLabel_2.setIcon(new ImageIcon(imagenEscalada));
			lblNewLabel_2.setBounds(0, 0, 434, 304);
			contentPane.add(lblNewLabel_2);

			contentPane.setComponentZOrder(
			    lblNewLabel_2,
			    contentPane.getComponentCount() - 1
			);
		}

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSalir) {
			do_btnSalir_actionPerformed(e);
		}
		if (e.getSource() == btnCompra) {
			do_btnCompra_actionPerformed(e);
		}
		if (e.getSource() == btnVenta) {
			do_btnVenta_actionPerformed(e);
		}
		if (e.getSource() == btnRegistro) {
			do_btnRegistro_actionPerformed(e);
		}
		if (e.getSource() == btnProd) {
			do_btnProd_actionPerformed(e);
		}
		if (e.getSource() == btnAdministrador) {
			do_btnAdministrador_actionPerformed(e);
		}
	}
	protected void do_btnAdministrador_actionPerformed(ActionEvent e) {
		Perfil ventanaPerfil = new Perfil();
		ventanaPerfil.setVisible(true);
		ventanaPerfil.setLocationRelativeTo(null);
	}
	protected void do_btnProd_actionPerformed(ActionEvent e) {
		Productos ventanaProductos = new Productos();
		ventanaProductos.setVisible(true);
		ventanaProductos.setLocationRelativeTo(null); 
	}
	protected void do_btnRegistro_actionPerformed(ActionEvent e) {
		V1 ventanaRegistro = new V1();
		ventanaRegistro.setVisible(true);
		ventanaRegistro.setLocationRelativeTo(null);
	}
	protected void do_btnVenta_actionPerformed(ActionEvent e) {
		Ventas ventanaVentas = new Ventas();
		ventanaVentas.setVisible(true);
		ventanaVentas.setLocationRelativeTo(null);
	}
	protected void do_btnCompra_actionPerformed(ActionEvent e) {
		Compras ventanaCompras = new Compras();
		ventanaCompras.setVisible(true);
		ventanaCompras.setLocationRelativeTo(null);
	}
	protected void do_btnSalir_actionPerformed(ActionEvent e) {
	    int opcion = JOptionPane.showConfirmDialog(this, 
	            "¿Está seguro de que desea cerrar la sesión actual?", 
	            "Cerrar Sesión", 
	            JOptionPane.YES_NO_OPTION, 
	            JOptionPane.QUESTION_MESSAGE);
	    
	    if (opcion == JOptionPane.YES_OPTION) {
	        LogIn ventanaLogin = new LogIn();
	        ventanaLogin.setVisible(true);
	        ventanaLogin.setLocationRelativeTo(null);
	        
	        this.dispose();
	    }
	}
}
