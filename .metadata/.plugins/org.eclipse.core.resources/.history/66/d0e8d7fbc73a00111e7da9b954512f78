package gui;

import javax.swing.table.DefaultTableModel;
import clase.Medicamento;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;

public class V1 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField txtTipo;
	private JTextField txtCodigo;
	private JTextField txtPrecio;
	private JTextField txtProducto;
	private JButton btnAgregar;
	private JScrollPane scrollPane;
	private JTable tablaMedicamentos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					V1 frame = new V1();
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
	public V1() {
		setTitle("Medicamento (pre-Concepto)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REGISTRO DE MEDICAMENTOS A LA VENTA ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setBounds(27, 10, 445, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("USUARIO:");
		lblNewLabel_1.setBounds(36, 63, 68, 12);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("PRODUCTO:");
		lblNewLabel_2.setBounds(33, 96, 71, 12);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("TIPO:");
		lblNewLabel_2_1.setBounds(33, 118, 71, 12);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("CÓDIGO:");
		lblNewLabel_2_1_1.setBounds(33, 142, 71, 12);
		contentPane.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("PRECIO:");
		lblNewLabel_2_1_2.setBounds(33, 166, 71, 12);
		contentPane.add(lblNewLabel_2_1_2);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(this);
		btnAgregar.setBounds(289, 41, 84, 20);
		contentPane.add(btnAgregar);
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(119, 60, 137, 18);
		contentPane.add(txtUsuario);
		
		txtTipo = new JTextField();
		txtTipo.setColumns(10);
		txtTipo.setBounds(119, 115, 137, 18);
		contentPane.add(txtTipo);
		
		txtCodigo = new JTextField();
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(119, 139, 137, 18);
		contentPane.add(txtCodigo);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(119, 160, 137, 18);
		contentPane.add(txtPrecio);
		
		txtProducto = new JTextField();
		txtProducto.setColumns(10);
		txtProducto.setBounds(119, 93, 137, 18);
		contentPane.add(txtProducto);
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(260, 65, 164, 181);
			contentPane.add(scrollPane);
			{
				tablaMedicamentos = new JTable();
				scrollPane.setViewportView(tablaMedicamentos);
			}
		}
		String[] columnas = {"PRODUCTO", "CÓDIGO", "TIPO", "PRECIO", "USUARIO"};
		DefaultTableModel modelo = new DefaultTableModel(null, columnas);
		tablaMedicamentos.setModel(modelo);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAgregar) {
			gestionarRegistro();
			
		}
	}
	private void gestionarRegistro() {                                           
        try {

            String usuario = txtUsuario.getText();
            String producto = txtProducto.getText();
            String tipo = txtTipo.getText();
            String codigo = txtCodigo.getText();
            String precio = txtPrecio.getText();

            if (usuario.isEmpty() || producto.isEmpty() || codigo.isEmpty()) {
                javax.swing.JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos, Gracias.");
                return;
            }

            Medicamento med = new Medicamento(producto, codigo, tipo, precio, usuario);
            
            DefaultTableModel modelo = (DefaultTableModel) tablaMedicamentos.getModel();
            modelo.addRow(med.toFila());

            limpiarCampos();
            
        } catch (Exception ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    } 

    private void limpiarCampos() {
        txtUsuario.setText("");
        txtProducto.setText("");
        txtTipo.setText("");
        txtCodigo.setText("");
        txtPrecio.setText("");
        txtUsuario.requestFocus(); 
    }
}
