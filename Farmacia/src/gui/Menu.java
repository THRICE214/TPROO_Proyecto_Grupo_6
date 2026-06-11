package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Menu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNomUsu;
	private JButton btnPerfil;
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
			btnPerfil = new JButton("Perfil");
			btnPerfil.setBounds(335, 16, 89, 23);
			contentPane.add(btnPerfil);
		}
		{
			btnCompra = new JButton("Compra");
			btnCompra.setBounds(65, 104, 105, 43);
			contentPane.add(btnCompra);
		}
		{
			btnVenta = new JButton("Venta");
			btnVenta.setBounds(255, 104, 105, 43);
			contentPane.add(btnVenta);
		}
		{
			btnProd = new JButton("Productos");
			btnProd.setBounds(65, 195, 105, 43);
			contentPane.add(btnProd);
		}
		{
			btnRegistro = new JButton("Registro");
			btnRegistro.setBounds(255, 195, 105, 43);
			contentPane.add(btnRegistro);
		}
		{
			btnSalir = new JButton("Salir");
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
}
