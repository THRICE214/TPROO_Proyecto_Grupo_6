package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class Menu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton;
	private JButton btnCompra;
	private JButton btnVenta;
	private JButton btnCompra_1;
	private JButton btnVenta_1;
	private JButton btnSalir;

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
			lblNewLabel_1 = new JLabel("\"Nombre de Usuario\"");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel_1.setBounds(10, 51, 414, 29);
			contentPane.add(lblNewLabel_1);
		}
		{
			btnNewButton = new JButton("Perfil");
			btnNewButton.setBounds(335, 16, 89, 23);
			contentPane.add(btnNewButton);
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
			btnCompra_1 = new JButton("Productos");
			btnCompra_1.setBounds(65, 195, 105, 43);
			contentPane.add(btnCompra_1);
		}
		{
			btnVenta_1 = new JButton("Registro");
			btnVenta_1.setBounds(255, 195, 105, 43);
			contentPane.add(btnVenta_1);
		}
		{
			btnSalir = new JButton("Salir");
			btnSalir.setBounds(10, 270, 89, 23);
			contentPane.add(btnSalir);
		}

	}
}
