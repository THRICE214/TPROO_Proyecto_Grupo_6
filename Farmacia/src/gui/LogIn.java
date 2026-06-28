package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import arrayList.ArrayUsuario;
import clase.SesionUsuario;
import clase.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

public class LogIn extends JFrame implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField txtUsuario;
	private JPasswordField txtContra;
	private JButton btnIngresar;
	private JCheckBox ckbMosContra;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn frame = new LogIn();
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
	public LogIn() {
		setTitle("Log-In");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 321);
		setResizable(false); //evitar cambiar el tamaño de la ventana
		setLocationRelativeTo(null); //centra la posicion de la ventana al ejecutar
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel_3 = new JLabel("i");
			lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_3.addMouseListener(this);
			
			lblNewLabel_4 = new JLabel("");
			lblNewLabel_4.setBounds(164, 11, 106, 105);
			// CAMBIO: cargar la imagen
			ImageIcon icono2 = new ImageIcon(
			    LogIn.class.getResource("/Recursos/cruzH.png"));
			// CAMBIO: escalar usando el tamaño del label
			Image imagenEscalada2 = icono2.getImage().getScaledInstance(
			    106,  // mismo ancho del label
			    105,  // mismo alto del label
			    Image.SCALE_SMOOTH
			);
			lblNewLabel_4.setIcon(new ImageIcon(imagenEscalada2));

			contentPane.add(lblNewLabel_4);
			
			lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
			lblNewLabel_3.setBounds(401, 11, 23, 20);
			contentPane.add(lblNewLabel_3);
		}
		{
			lblNewLabel = new JLabel("E-mail:");
			lblNewLabel.setBounds(99, 130, 57, 14);
			contentPane.add(lblNewLabel);
		}
		{
			lblNewLabel_1 = new JLabel("Contraseña:");
			lblNewLabel_1.setBounds(99, 175, 73, 14);
			contentPane.add(lblNewLabel_1);
		}
		{
			txtUsuario = new JTextField();
			txtUsuario.setColumns(10);
			txtUsuario.setBounds(182, 127, 157, 20);
			contentPane.add(txtUsuario);
		}
		{
			txtContra = new JPasswordField();
			txtContra.setBounds(182, 172, 157, 17);
			contentPane.add(txtContra);
		}
		{
			btnIngresar = new JButton("Ingresar");
			btnIngresar.addActionListener(this);
			btnIngresar.setBounds(171, 248, 89, 23);
			contentPane.add(btnIngresar);
		}
		{
			ckbMosContra = new JCheckBox("Mostrar contraseña");
			ckbMosContra.addActionListener(this);
			ckbMosContra.setBounds(143, 218, 141, 23);
			ckbMosContra.setOpaque(false);
			contentPane.add(ckbMosContra);
		}
		ImageIcon icono = new ImageIcon(LogIn.class.getResource("/Recursos/FondoLogIn.png"));

		Image imagenEscalada = icono.getImage().getScaledInstance(
		    434,
		    282,
		    Image.SCALE_SMOOTH
		);

		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(imagenEscalada));
		lblNewLabel_2.setBounds(0, 0, 434, 282);

		contentPane.add(lblNewLabel_2);

		contentPane.setComponentZOrder(
		    lblNewLabel_2,
		    contentPane.getComponentCount() - 1
		);

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnIngresar) {
			do_btnIngresar_actionPerformed(e);
		}
		if (e.getSource() == ckbMosContra) {
			do_ckbMosContra_actionPerformed(e);
		}
	}
	protected void do_ckbMosContra_actionPerformed(ActionEvent e) {
		if (ckbMosContra.isSelected()) {
		    txtContra.setEchoChar((char) 0);
		} else {
		    txtContra.setEchoChar('•');
		}
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == lblNewLabel_3) {
			do_lblNewLabel_3_mouseClicked(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void do_lblNewLabel_3_mouseClicked(MouseEvent e) {
		JOptionPane.showMessageDialog(
			    this,
			    "Mensaje de informacion.",
			    "Información",
			    JOptionPane.INFORMATION_MESSAGE
			);
	}
	protected void do_btnIngresar_actionPerformed(ActionEvent e) {
		String correoIngresado = txtUsuario.getText().trim();
		String contraseniaIngresada = new String(txtContra.getPassword());

		ArrayUsuario objArrayUsuario = new ArrayUsuario();

		try {
		    // Garantizamos que la sesión empiece completamente vacía al intentar loguearse
		    SesionUsuario.getInstancia().cerrarSesion();

		    // 2. Buscamos al usuario en la base de datos usando el método nuevo que creaste
		    Usuario usu = objArrayUsuario.ConsultarUsuarioEmail(correoIngresado);

		    if (usu == null) {
		        // Alerta si el correo no existe en la BD
		        JOptionPane.showMessageDialog(this, "El correo electrónico no está registrado.", "Error de Login", JOptionPane.ERROR_MESSAGE);
		    } 
		    else if (!usu.getPassword().equals(contraseniaIngresada)) {
		        // 3. Alerta si la contraseña no coincide
		        JOptionPane.showMessageDialog(this, "Contraseña incorrecta.", "Error de Login", JOptionPane.ERROR_MESSAGE);
		    } 
		    else if (!usu.isEstado()) {
		        // 4. Alerta si el usuario está desactivado (estado = false)
		        JOptionPane.showMessageDialog(this, "Su usuario se encuentra desactivado. Contacte al administrador.", "Acceso Denegado", JOptionPane.WARNING_MESSAGE);
		    } 
		    else {
		        // ¡TODO CORRECTO! 
		        // Guardamos el objeto usuario completo en la sesión global (RAM)
		        SesionUsuario.getInstancia().iniciarSesion(usu);
		        
		        JOptionPane.showMessageDialog(this, "¡Bienvenido " + usu.getNombre() + "!", "Acceso Concedido", JOptionPane.INFORMATION_MESSAGE);
		        
		        // 5. Abrimos tu menú principal 
		        // (Asegúrate de cambiar 'MenuPrincipal' por el nombre real de tu clase de menú)
		        Menu ventanaMenu = new Menu();
		        ventanaMenu.setVisible(true);
		        
		        // Cerramos la ventana de Login actual para liberar memoria
		        this.dispose();
		    }
		} catch (Exception ex) {
		    ex.printStackTrace();
		    JOptionPane.showMessageDialog(this, "Error al procesar el inicio de sesión.", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
