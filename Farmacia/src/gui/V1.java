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

import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

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
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnEliminar;

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
		setForeground(new Color(204, 255, 204));
		setBackground(new Color(153, 255, 153));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Lenovo\\Pictures\\Screenshots\\Captura de pantalla 2026-04-18 185356.png"));
		setTitle("Medicamentos ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 599, 374);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REGISTRO DE MEDICAMENTOS A LA VENTA ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBackground(new Color(240, 255, 240));
		lblNewLabel.setBounds(86, 11, 493, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("USUARIO:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_1.setBounds(36, 63, 68, 12);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("PRODUCTO:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_2.setBounds(33, 96, 71, 12);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("TIPO:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_2_1.setBounds(33, 118, 71, 12);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("CÓDIGO:");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_2_1_1.setBounds(33, 142, 71, 12);
		contentPane.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("PRECIO:");
		lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_2_1_2.setBounds(33, 166, 71, 12);
		contentPane.add(lblNewLabel_2_1_2);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnAgregar.setBackground(new Color(46, 139, 87));
		btnAgregar.setForeground(new Color(0, 0, 0));
		btnAgregar.addActionListener(this);
		btnAgregar.setBounds(27, 189, 89, 23);
		contentPane.add(btnAgregar);
		
		txtUsuario = new JTextField();
		txtUsuario.setBackground(new Color(240, 255, 240));
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(119, 60, 137, 18);
		contentPane.add(txtUsuario);
		
		txtTipo = new JTextField();
		txtTipo.setBackground(new Color(240, 255, 240));
		txtTipo.setColumns(10);
		txtTipo.setBounds(119, 115, 137, 18);
		contentPane.add(txtTipo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBackground(new Color(240, 255, 240));
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(119, 139, 137, 18);
		contentPane.add(txtCodigo);
		
		txtPrecio = new JTextField();
		txtPrecio.setBackground(new Color(240, 255, 240));
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(119, 160, 137, 18);
		contentPane.add(txtPrecio);
		
		txtProducto = new JTextField();
		txtProducto.setBackground(new Color(240, 255, 240));
		txtProducto.setColumns(10);
		txtProducto.setBounds(119, 93, 137, 18);
		contentPane.add(txtProducto);
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(266, 55, 313, 206);
			contentPane.add(scrollPane);
			{
				tablaMedicamentos = new JTable();
				scrollPane.setViewportView(tablaMedicamentos);
			}
		}
		String[] columnas = {"PRODUCTO", "CÓDIGO", "TIPO", "PRECIO", "USUARIO"};
		DefaultTableModel modelo = new DefaultTableModel(null, columnas);
		tablaMedicamentos.setModel(modelo);
		{
			btnNewButton = new JButton("Modificar");
			btnNewButton.setBackground(new Color(0, 100, 0));
			btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
			btnNewButton.setForeground(new Color(0, 0, 0));
			btnNewButton.setBounds(126, 189, 89, 23);
			contentPane.add(btnNewButton);
		}
		{
			btnNewButton_1 = new JButton("Reportar");
			btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 10));
			btnNewButton_1.setForeground(new Color(0, 0, 0));
			btnNewButton_1.setBackground(new Color(46, 139, 87));
			btnNewButton_1.addActionListener(this);
			btnNewButton_1.setBounds(27, 223, 89, 23);
			contentPane.add(btnNewButton_1);
		}
		{
			btnNewButton_2 = new JButton("Buscar");
			btnNewButton_2.setBackground(new Color(34, 139, 34));
			btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 10));
			btnNewButton_2.addActionListener(this);
			btnNewButton_2.setBounds(268, 279, 89, 23);
			contentPane.add(btnNewButton_2);
		}
		{
			btnEliminar = new JButton("Eliminar");
			btnEliminar.addActionListener(this);
			btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 10));
			btnEliminar.setBackground(new Color(34, 139, 34));
			btnEliminar.setBounds(126, 223, 89, 23);
			contentPane.add(btnEliminar);
		}
		{
			txtBusqueda = new JTextField();
			txtBusqueda.setBackground(new Color(240, 255, 240));
			txtBusqueda.setBounds(367, 281, 208, 20);
			contentPane.add(txtBusqueda);
			txtBusqueda.setColumns(10);
		}
	}
	
	private List<Medicamento> listaMedicamentos = new ArrayList<>();
	private JTextField txtBusqueda;
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEliminar) {
			do_btnEliminar_actionPerformed(e);
		}
		if (e.getSource() == btnNewButton_2) {
			do_btnNewButton_2_actionPerformed(e);
		}
		if (e.getSource() == btnNewButton_1) {
			do_btnNewButton_1_actionPerformed(e);
		}
		if (e.getSource() == btnAgregar) {
			gestionarRegistro();
			
		}
	}
	private void gestionarRegistro() {                                           
		try {
		    String usuario = txtUsuario.getText().trim();
		    String producto = txtProducto.getText().trim();
		    String tipo = txtTipo.getText().trim();
		    String codigo = txtCodigo.getText().trim();
		    String precioTexto = txtPrecio.getText().trim();

		        if (usuario.isEmpty() || producto.isEmpty() || tipo.isEmpty() || codigo.isEmpty() || precioTexto.isEmpty()) {
		        javax.swing.JOptionPane.showMessageDialog(this, "Complete todos los campos");
		        return;
		    }

	
		    if (!usuario.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
		        javax.swing.JOptionPane.showMessageDialog(this, "El usuario solo debe contener letras");
		        txtUsuario.requestFocus();
		        return;
		    }

		    
		    double precio;
		    try {
		        precio = Double.parseDouble(precioTexto);
		    } catch (NumberFormatException e) {
		        javax.swing.JOptionPane.showMessageDialog(this, "Ingrese un precio válido");
		        txtPrecio.requestFocus();
		        return;
		    }

		    if (precio <= 0) {
		        javax.swing.JOptionPane.showMessageDialog(this, "El precio debe ser mayor a 0");
		        txtPrecio.requestFocus();
		        return;
		    }

		   
		    Medicamento med = new Medicamento (producto, codigo , tipo,  precio, usuario);
		
		   
		    DefaultTableModel modelo = (DefaultTableModel) tablaMedicamentos.getModel();
		    modelo.addRow(med.toFila());

		    listaMedicamentos.add(med);
		    
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
	protected void do_btnNewButton_1_actionPerformed(ActionEvent e) {
		try {
			DefaultTableModel modelo = (DefaultTableModel) tablaMedicamentos.getModel();
			modelo.setRowCount(0);
			
			for (Medicamento m : listaMedicamentos) {
		        modelo.addRow(m.toFila());
		    }
			
			limpiarCampos();
            
        } catch (Exception ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
	}
	protected void do_btnNewButton_2_actionPerformed(ActionEvent e) {

		String textoBuscado = txtBusqueda.getText().trim();

		
		if (textoBuscado.isEmpty()) {
			javax.swing.JOptionPane.showMessageDialog(this, "Por favor, ingresa un código para buscar.");
		    return; 
		}

		DefaultTableModel modelo = (DefaultTableModel) tablaMedicamentos.getModel();
		modelo.setRowCount(0); 

		boolean encontrado = false;
		for (Medicamento m : listaMedicamentos) {
		    if (m.getCod().equalsIgnoreCase(textoBuscado)) {
		        modelo.addRow(m.toFila()); 
		        encontrado = true;
		        break; 
		    }
		}

		if (!encontrado) {
		    javax.swing.JOptionPane.showMessageDialog(this, "No se encontró el medicamento con código: " + textoBuscado);
		}
	}
	protected void do_btnEliminar_actionPerformed(ActionEvent e) {
		
		    int filaSeleccionada = tablaMedicamentos.getSelectedRow();

		    if (filaSeleccionada == -1) {
		        javax.swing.JOptionPane.showMessageDialog(this, "Selecciona un registro para eliminar");
		        return;
		    }

		    DefaultTableModel modelo = (DefaultTableModel) tablaMedicamentos.getModel();

		    String codigo = modelo.getValueAt(filaSeleccionada, 1).toString();

		    boolean eliminado = false;
		    for (int i = 0; i < listaMedicamentos.size(); i++) {
		        if (listaMedicamentos.get(i).getCod().equalsIgnoreCase(codigo)) {
		            listaMedicamentos.remove(i);
		            eliminado = true;
		            break;
		        }
		    }

		    modelo.removeRow(filaSeleccionada);

		    if (eliminado) {
		        javax.swing.JOptionPane.showMessageDialog(this, "Medicamento eliminado correctamente");
		    } else {
		        javax.swing.JOptionPane.showMessageDialog(this, "Se eliminó de la tabla, pero el medicamento no estaba en la lista");
		    }
		
	}
}
