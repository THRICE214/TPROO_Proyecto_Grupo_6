package gui;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DevTeam extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JButton btnNewButton;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_12;
	private JLabel lblNewLabel_13;
	private JLabel lblNewLabel_14;
	private JLabel lblNewLabel_15;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DevTeam frame = new DevTeam();
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
	public DevTeam() {
		setTitle("DEV Team");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 852, 440);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			ImageIcon iconoAm = new ImageIcon(LogIn.class.getResource("/Recursos/Ambar.png"));

			Image imagenEscaladaAm = iconoAm.getImage().getScaledInstance(
			    129,
			    184,
			    Image.SCALE_SMOOTH
			);
			
			lblNewLabel = new JLabel("Ambar");
			lblNewLabel.setIcon(new ImageIcon(imagenEscaladaAm));
			lblNewLabel.setBounds(53, 60, 129, 184);

			contentPane.add(lblNewLabel);

			contentPane.setComponentZOrder(
			    lblNewLabel,
			    contentPane.getComponentCount() - 1
			);
		}
		{
			ImageIcon iconoAn = new ImageIcon(LogIn.class.getResource("/Recursos/Angela.png"));

			Image imagenEscaladaAn = iconoAn.getImage().getScaledInstance(
			    129,
			    184,
			    Image.SCALE_SMOOTH
			);
			
			lblNewLabel_1 = new JLabel("Angela");
			lblNewLabel_1.setIcon(new ImageIcon(imagenEscaladaAn));
			lblNewLabel_1.setBounds(252, 60, 129, 184);

			contentPane.add(lblNewLabel_1);

			contentPane.setComponentZOrder(
			    lblNewLabel_1,
			    contentPane.getComponentCount() - 1
			);
		}
		{
			ImageIcon iconoNi = new ImageIcon(LogIn.class.getResource("/Recursos/Nikolas.png"));

			Image imagenEscaladaNi = iconoNi.getImage().getScaledInstance(
			    129,
			    184,
			    Image.SCALE_SMOOTH
			);
			
			lblNewLabel_2 = new JLabel("Nikolas");
			lblNewLabel_2.setIcon(new ImageIcon(imagenEscaladaNi));
			lblNewLabel_2.setBounds(455, 60, 129, 184);

			contentPane.add(lblNewLabel_2);

			contentPane.setComponentZOrder(
			    lblNewLabel_2,
			    contentPane.getComponentCount() - 1
			);
		}
		{
			lblNewLabel_3 = new JLabel("Ambar Nalleli Isabel");
			lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_3.setBounds(53, 265, 129, 14);
			contentPane.add(lblNewLabel_3);
		}
		{
			lblNewLabel_4 = new JLabel("Ramos Alderete");
			lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_4.setBounds(53, 284, 129, 14);
			contentPane.add(lblNewLabel_4);
		}
		{
			lblNewLabel_5 = new JLabel("Vilchez Gutierrez");
			lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_5.setBounds(252, 284, 129, 14);
			contentPane.add(lblNewLabel_5);
		}
		{
			lblNewLabel_6 = new JLabel("Angela Celeste");
			lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_6.setBounds(252, 265, 129, 14);
			contentPane.add(lblNewLabel_6);
		}
		{
			lblNewLabel_7 = new JLabel("Figueroa Beas");
			lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_7.setBounds(455, 284, 129, 14);
			contentPane.add(lblNewLabel_7);
		}
		{
			lblNewLabel_8 = new JLabel("Nikolas Andre");
			lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_8.setBounds(455, 265, 129, 14);
			contentPane.add(lblNewLabel_8);
		}
		{
			ImageIcon iconoNic = new ImageIcon(LogIn.class.getResource("/Recursos/Nicolas.png"));

			Image imagenEscaladaNic = iconoNic.getImage().getScaledInstance(
			    129,
			    184,
			    Image.SCALE_SMOOTH
			);
			
			lblNewLabel_9 = new JLabel("Nicolas");
			lblNewLabel_9.setIcon(new ImageIcon(imagenEscaladaNic));
			lblNewLabel_9.setBounds(645, 60, 129, 184);

			contentPane.add(lblNewLabel_9);

			contentPane.setComponentZOrder(
			    lblNewLabel_9,
			    contentPane.getComponentCount() - 1
			);
		}
		{
			btnNewButton = new JButton("Regresar");
			btnNewButton.addActionListener(this);
			btnNewButton.setBounds(10, 367, 89, 23);
			contentPane.add(btnNewButton);
		}
		{
			lblNewLabel_10 = new JLabel("Alejan_garcia101@outlook.es");
			lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_10.setBounds(640, 305, 143, 14);
			contentPane.add(lblNewLabel_10);
		}
		{
			lblNewLabel_11 = new JLabel("ambaramos667@gmail.com");
			lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_11.setBounds(49, 305, 143, 14);
			contentPane.add(lblNewLabel_11);
		}
		{
			lblNewLabel_12 = new JLabel("avilchezgutierrez@gmail.com");
			lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_12.setBounds(245, 305, 138, 14);
			contentPane.add(lblNewLabel_12);
		}
		{
			lblNewLabel_13 = new JLabel("nikolasandrefb@outlook.com");
			lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_13.setBounds(452, 305, 143, 14);
			contentPane.add(lblNewLabel_13);
		}
		{
			lblNewLabel_14 = new JLabel("Nicolas Alejandro");
			lblNewLabel_14.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_14.setBounds(645, 265, 129, 14);
			contentPane.add(lblNewLabel_14);
		}
		{
			lblNewLabel_15 = new JLabel("Garcia Huallanca");
			lblNewLabel_15.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_15.setBounds(645, 284, 129, 14);
			contentPane.add(lblNewLabel_15);
		}

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) {
			do_btnNewButton_actionPerformed(e);
		}
	}
	
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		Menu ventanaMenu = new Menu();
	    ventanaMenu.setVisible(true);
	    this.dispose();
	}
}
