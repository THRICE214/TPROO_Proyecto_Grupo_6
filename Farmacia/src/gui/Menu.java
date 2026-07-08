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

import clase.SesionUsuario;
import clase.Usuario;
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
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JButton btnInvent;
	private JLabel lblNewLabel_6;

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
		setBounds(100, 100, 450, 535);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			btnInvent = new JButton("Inventario");
			btnInvent.addActionListener(this);
			btnInvent.setBounds(161, 421, 105, 23);
			contentPane.add(btnInvent);
		}
		ImageIcon iconoI = new ImageIcon(LogIn.class.getResource("/Recursos/InvIco.png"));

		Image imagenEscaladaI = iconoI.getImage().getScaledInstance(
		    72,
		    72,
		    Image.SCALE_SMOOTH
		);
		{
			lblNewLabel_6 = new JLabel("New label");
			lblNewLabel_6.setIcon(new ImageIcon(imagenEscaladaI));
			lblNewLabel_6.setBounds(178, 338, 72, 72);
			contentPane.add(lblNewLabel_6);
		}
		ImageIcon iconoV = new ImageIcon(LogIn.class.getResource("/Recursos/VenIco.png"));

		Image imagenEscaladaV = iconoV.getImage().getScaledInstance(
		    72,
		    72,
		    Image.SCALE_SMOOTH
		);
		{
			lblNewLabel_4 = new JLabel("New label");
			lblNewLabel_4.setIcon(new ImageIcon(imagenEscaladaV));
			lblNewLabel_4.setBounds(270, 91, 72, 72);
			contentPane.add(lblNewLabel_4);
		}
		ImageIcon iconoR = new ImageIcon(LogIn.class.getResource("/Recursos/RegIco.png"));

		Image imagenEscaladaR = iconoR.getImage().getScaledInstance(
		    72,
		    72,
		    Image.SCALE_SMOOTH
		);
		{
			lblNewLabel_5 = new JLabel("New label");
			lblNewLabel_5.setIcon(new ImageIcon(imagenEscaladaR));
			lblNewLabel_5.setBounds(270, 221, 72, 72);
			contentPane.add(lblNewLabel_5);
		}
		ImageIcon iconoP = new ImageIcon(LogIn.class.getResource("/Recursos/ProIco.png"));

		Image imagenEscaladaP = iconoP.getImage().getScaledInstance(
		    72,
		    72,
		    Image.SCALE_SMOOTH
		);
		{
			lblNewLabel_3 = new JLabel("New label");
			lblNewLabel_3.setIcon(new ImageIcon(imagenEscaladaP));
			lblNewLabel_3.setBounds(82, 221, 72, 72);
			contentPane.add(lblNewLabel_3);
		}
		ImageIcon iconoC = new ImageIcon(LogIn.class.getResource("/Recursos/ComIco.png"));

		Image imagenEscaladaC = iconoC.getImage().getScaledInstance(
		    80,
		    72,
		    Image.SCALE_SMOOTH
		);
		{
			lblNewLabel_1 = new JLabel("New label");
			lblNewLabel_1.setIcon(new ImageIcon(imagenEscaladaC));
			lblNewLabel_1.setBounds(74, 91, 80, 72);
			contentPane.add(lblNewLabel_1);
		}
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
			btnAdministrador.setBounds(287, 16, 137, 23);
			contentPane.add(btnAdministrador);
		}
		{
			btnCompra = new JButton("Compra");
			btnCompra.addActionListener(this);
			btnCompra.setBounds(65, 174, 105, 23);
			contentPane.add(btnCompra);
		}
		{
			btnVenta = new JButton("Venta");
			btnVenta.addActionListener(this);
			btnVenta.setBounds(255, 174, 105, 23);
			contentPane.add(btnVenta);
		}
		{
			btnProd = new JButton("Productos");
			btnProd.addActionListener(this);
			btnProd.setBounds(65, 304, 105, 23);
			contentPane.add(btnProd);
		}
		{
			btnRegistro = new JButton("Registro");
			btnRegistro.addActionListener(this);
			btnRegistro.setBounds(255, 304, 105, 23);
			contentPane.add(btnRegistro);
		}
		{
			btnSalir = new JButton("Cerrar Sesion");
			btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnSalir.addActionListener(this);
			btnSalir.setBounds(10, 462, 105, 23);
			contentPane.add(btnSalir);
		}
		ImageIcon icono = new ImageIcon(LogIn.class.getResource("/Recursos/FonMenu.png"));

		Image imagenEscalada = icono.getImage().getScaledInstance(
		    434,
		    496,
		    Image.SCALE_SMOOTH
		);
		{
			lblNewLabel_2 = new JLabel("");
			lblNewLabel_2.setIcon(new ImageIcon(imagenEscalada));
			lblNewLabel_2.setBounds(0, 0, 434, 496);
			contentPane.add(lblNewLabel_2);

			contentPane.setComponentZOrder(
			    lblNewLabel_2,
			    contentPane.getComponentCount() - 1
			);
		}

		// llamamos a SesionUsuario
				Usuario usuarioLogueado = SesionUsuario.getInstancia().getUsuarioLogueado();
				
				if (usuarioLogueado != null) {
					// cambiamos el texto del label por el nombre de usuario
					lblNomUsu.setText(usuarioLogueado.getNombre());
				}
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnInvent) {
			do_btnInvent_actionPerformed(e);
		}
		if (e.getSource() == btnRegistro) {
			do_btnRegistro_actionPerformed(e);
		}
		if (e.getSource() == btnVenta) {
			do_btnVenta_actionPerformed(e);
		}
		if (e.getSource() == btnCompra) {
			do_btnCompra_actionPerformed(e);
		}
		if (e.getSource() == btnSalir) {
			do_btnSalir_actionPerformed(e);
		}
		if (e.getSource() == btnProd) {
			do_btnProd_actionPerformed(e);
		}
		if (e.getSource() == btnAdministrador) {
			do_btnAdministrador_actionPerformed(e);
		}
	}
	
	protected void do_btnAdministrador_actionPerformed(ActionEvent e) {
		// 1. llamamos a SesionUsuario
	    Usuario usuarioActual = SesionUsuario.getInstancia().getUsuarioLogueado();
	    
	    // 2. Evaluamos si el usuario tiene permisos de Administrador
	    if (usuarioActual != null && usuarioActual.isAdmin()) {
	        
	        // ¡Acceso concedido! Abrimos la ventana Perfil
	        // (Cambia 'Perfil' por el nombre real de tu clase de gestión de usuarios si varía)
	        Perfil ventanaPerfil = new Perfil();
	        ventanaPerfil.setVisible(true);
	        
	        this.dispose();
	        
	        // Nota: Como es una ventana secundaria de gestión, no le hacemos dispose al Menú,
	        // así cuando cierres Perfil, el Menú Principal seguirá estando atrás listo.
	        
	    } else {
	        // ¡Acceso denegado! Mostramos advertencia en pantalla
	        JOptionPane.showMessageDialog(this, 
	            "Acceso restringido. Solo los usuarios con rol de Administrador pueden ingresar aquí.", 
	            "Permisos Insuficientes", 
	            JOptionPane.WARNING_MESSAGE);
	    }
	}
	
	protected void do_btnProd_actionPerformed(ActionEvent e) {
	    Productos ventanaProducto = new Productos();
	    ventanaProducto.setVisible(true);
	    
	    this.dispose();
	}
	
	protected void do_btnSalir_actionPerformed(ActionEvent e) {
		// 1. Preguntamos al usuario para confirmar (evita cierres por accidente)
	    int respuesta = JOptionPane.showConfirmDialog(this, 
	            "¿Estás seguro de que deseas cerrar sesión?", 
	            "Cerrar Sesión", 
	            JOptionPane.YES_NO_OPTION, 
	            JOptionPane.QUESTION_MESSAGE);
	            
	    if (respuesta == JOptionPane.YES_OPTION) {
	        
	        // 2. Limpiamos la sesión: dejamos el usuario en null 
	        // Esto es lo que emula que el programa se "cierre", borrando los datos de la RAM
	        SesionUsuario.getInstancia().cerrarSesion();
	        
	        // 3. Instanciamos y mostramos la ventana de LogIn desde cero
	        LogIn ventanaLogin = new LogIn();
	        ventanaLogin.setVisible(true);
	        
	        // 4. Destruimos por completo esta ventana de Menú
	        this.dispose();
	    }
	}
	
	protected void do_btnCompra_actionPerformed(ActionEvent e) {
		Compras ventanaCompra = new Compras();
	    ventanaCompra.setVisible(true);
	    
	    this.dispose();
	}
	
	protected void do_btnVenta_actionPerformed(ActionEvent e) {
		Ventas ventanaVenta = new Ventas();
	    ventanaVenta.setVisible(true);
	    
	    this.dispose();
	}
	
	protected void do_btnRegistro_actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this, 
	            "En Desarrollo.", 
	            "Acceso Restringido", 
	            JOptionPane.WARNING_MESSAGE);
	}
	
	protected void do_btnInvent_actionPerformed(ActionEvent e) {
		Inventario ventanaInventario = new Inventario();
	    ventanaInventario.setVisible(true);
	    
	    this.dispose();
	}
}
