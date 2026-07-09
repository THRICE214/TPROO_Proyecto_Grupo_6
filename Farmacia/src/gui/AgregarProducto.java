package gui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JButton;

import javax.swing.JOptionPane;
import java.util.ArrayList;

import arrayList.ArrayCategoria;
import clase.Categoria;
import clase.Producto;
import java.awt.event.ActionEvent;

public class AgregarProducto extends JDialog implements java.awt.event.ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel_1;
	private JTextField txtNombre;
	private JLabel lblNewLabel_2;
	private JTextField txtPrinAct;
	private JLabel lblNewLabel_3;
	private JTextField txtMar;
	private JLabel lblNewLabel_4;
	private JTextField txtLab;
	private JLabel lblNewLabel_5;
	private JTextArea txtPresP;
	private JLabel lblNewLabel_8;
	private JTextArea txtDes;
	private JLabel lblNewLabel;
	private JComboBox cboCategoria;
	private JLabel lblNewLabel_9;
	private JComboBox cboReqRec;
	private JLabel lblNewLabel_10;
	private JComboBox cboActP;
	private JButton btnCancelar;
	private JButton btnConfirmar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarProducto frame = new AgregarProducto(null);
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
	public AgregarProducto(JFrame padre) {
		super(padre, true);
		
		setTitle("Agregar Nuevo Producto");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 657, 322);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(211, 211, 211));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel_1 = new JLabel("Nombre:");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_1.setBounds(10, 14, 46, 14);
			contentPane.add(lblNewLabel_1);
		}
		{
			txtNombre = new JTextField();
			txtNombre.setColumns(10);
			txtNombre.setBounds(114, 11, 199, 20);
			contentPane.add(txtNombre);
		}
		{
			lblNewLabel_2 = new JLabel("Principio Activo:");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_2.setBounds(10, 49, 82, 14);
			contentPane.add(lblNewLabel_2);
		}
		{
			txtPrinAct = new JTextField();
			txtPrinAct.setColumns(10);
			txtPrinAct.setBounds(114, 46, 199, 20);
			contentPane.add(txtPrinAct);
		}
		{
			lblNewLabel_3 = new JLabel("Marca:");
			lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_3.setBounds(10, 84, 82, 14);
			contentPane.add(lblNewLabel_3);
		}
		{
			txtMar = new JTextField();
			txtMar.setColumns(10);
			txtMar.setBounds(114, 80, 199, 20);
			contentPane.add(txtMar);
		}
		{
			lblNewLabel_4 = new JLabel("Laboratorio:");
			lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_4.setBounds(10, 119, 82, 14);
			contentPane.add(lblNewLabel_4);
		}
		{
			txtLab = new JTextField();
			txtLab.setColumns(10);
			txtLab.setBounds(114, 116, 199, 20);
			contentPane.add(txtLab);
		}
		{
			lblNewLabel_5 = new JLabel("Presentacion:");
			lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_5.setBounds(10, 154, 82, 14);
			contentPane.add(lblNewLabel_5);
		}
		{
			txtPresP = new JTextArea();
			txtPresP.setFont(new Font("Tahoma", Font.PLAIN, 11));
			txtPresP.setWrapStyleWord(true);
			txtPresP.setLineWrap(true);
			txtPresP.setBounds(114, 149, 199, 83);
			contentPane.add(txtPresP);
			txtPresP.setText("Producto registrado desde compra. Detallar luego en productos.");
		}
		{
			lblNewLabel_8 = new JLabel("Descripción Categoria:");
			lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_8.setBounds(323, 49, 119, 14);
			contentPane.add(lblNewLabel_8);
		}
		{
			txtDes = new JTextArea();
			txtDes.setFont(new Font("Tahoma", Font.PLAIN, 11));
			txtDes.setWrapStyleWord(true);
			txtDes.setLineWrap(true);
			txtDes.setBounds(323, 72, 307, 96);
			contentPane.add(txtDes);
			txtDes.setText("Categoría registrada desde compra. Detallar luego en productos.");
		}
		{
			lblNewLabel = new JLabel("Categoria:");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel.setBounds(323, 15, 82, 14);
			contentPane.add(lblNewLabel);
		}
		{
			cboCategoria = new JComboBox();
			cboCategoria.setEditable(true);
			cboCategoria.setBounds(427, 11, 199, 22);
			contentPane.add(cboCategoria);
			
			javax.swing.text.JTextComponent editorCategoria =
					(javax.swing.text.JTextComponent)
					cboCategoria.getEditor().getEditorComponent();

			editorCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
				@Override
				public void keyReleased(java.awt.event.KeyEvent e) {

					if (e.getKeyCode() == java.awt.event.KeyEvent.VK_UP ||
							e.getKeyCode() == java.awt.event.KeyEvent.VK_DOWN ||
							e.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
						return;
					}

					String texto = editorCategoria.getText();
					filtrarCategoriasEnCombo(texto);
				}
			});
		}
		{
			lblNewLabel_9 = new JLabel("Requiere Receta:");
			lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_9.setBounds(323, 183, 94, 14);
			contentPane.add(lblNewLabel_9);
		}
		{
			cboReqRec = new JComboBox();
			cboReqRec.setBounds(427, 179, 199, 22);
			contentPane.add(cboReqRec);
			
			//campos
			cboReqRec.addItem("true");
			cboReqRec.addItem("false");
		}
		{
			lblNewLabel_10 = new JLabel("Activo:");
			lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_10.setBounds(323, 218, 94, 14);
			contentPane.add(lblNewLabel_10);
		}
		{
			cboActP = new JComboBox();
			cboActP.setBounds(427, 214, 199, 22);
			contentPane.add(cboActP);
			
			cboActP.addItem("true");
			cboActP.addItem("false");

			cboActP.setSelectedItem("true");
			cboActP.setEnabled(false);
		}
		{
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(this);
			btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnCancelar.setBounds(10, 249, 89, 23);
			contentPane.add(btnCancelar);
		}
		{
			btnConfirmar = new JButton("Confirmar");
			btnConfirmar.addActionListener(this);
			btnConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnConfirmar.setBounds(541, 249, 89, 23);
			contentPane.add(btnConfirmar);
		}

		cargarCategorias();
		setLocationRelativeTo(padre);
		
	}
	
	private Producto productoCreado = null;
	private ArrayList<Categoria> listaCategorias = new ArrayList<Categoria>();
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnConfirmar) {
			do_btnConfirmar_actionPerformed(e);
		}
		if (e.getSource() == btnCancelar) {
			do_btnCancelar_actionPerformed(e);
		}
	}
	
	private void filtrarCategoriasEnCombo(String texto) {

		try {
			javax.swing.text.JTextComponent editor =
					(javax.swing.text.JTextComponent)
					cboCategoria.getEditor().getEditorComponent();

			int posicionCaret = editor.getCaretPosition();

			cboCategoria.removeAllItems();

			for (Categoria c : listaCategorias) {

				if (texto == null || texto.trim().isEmpty()) {
					cboCategoria.addItem(c.getNombre());
				}
				else if (c.getNombre().toLowerCase().contains(texto.toLowerCase())) {
					cboCategoria.addItem(c.getNombre());
				}
			}

			editor.setText(texto);

			if (posicionCaret <= texto.length()) {
				editor.setCaretPosition(posicionCaret);
			}

			if (cboCategoria.getItemCount() > 0) {
				cboCategoria.showPopup();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private Categoria obtenerCategoriaIngresada() {

		Object textoCombo = cboCategoria.getEditor().getItem();

		if (textoCombo == null || textoCombo.toString().trim().isEmpty()) {
			return null;
		}

		String nombreIngresado = textoCombo.toString().trim();

		for (Categoria c : listaCategorias) {
			if (c.getNombre().equalsIgnoreCase(nombreIngresado)) {
				return c; // categoría ya existe en BD
			}
		}

		// Si no existe, se crea una categoría temporal
		Categoria nueva = new Categoria();
		nueva.setId(0); // 0 = todavía no existe en BD
		nueva.setNombre(nombreIngresado);
		String descripcion = txtDes.getText().trim();

		if (descripcion.isEmpty()) {
			descripcion = "Categoría registrada desde compra. Detallar luego en productos.";
		}

		nueva.setDescripcion(descripcion);

		return nueva;
	}
	
	private void cargarCategorias() {

		cboCategoria.removeAllItems();

		listaCategorias = new ArrayCategoria().ListarCategoria();

		for (Categoria c : listaCategorias) {
			cboCategoria.addItem(c.getNombre());
		}
	}
	
	public Producto getProductoCreado() {
		return productoCreado;
	}
	
	protected void do_btnCancelar_actionPerformed(ActionEvent e) {
		productoCreado = null;
		dispose();
	}
	protected void do_btnConfirmar_actionPerformed(ActionEvent e) {
		String presentacion = txtPresP.getText().trim();

		if (presentacion.isEmpty()) {
			presentacion = "Producto registrado desde compra. Detallar luego en productos.";
		}
		
		if (txtNombre.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Ingrese el nombre del producto.");
			return;
		}
		
		ArrayList<Producto> productosExistentes =
				new arrayList.ArrayProducto().BuscarProductoNombre(txtNombre.getText().trim());

		for (Producto pro : productosExistentes) {
			if (pro.getNombre().equalsIgnoreCase(txtNombre.getText().trim())) {
				JOptionPane.showMessageDialog(
						this,
						"Ya existe un producto registrado con ese nombre."
				);
				return;
			}
		}

		if (txtPrinAct.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Ingrese el principio activo.");
			return;
		}

		if (txtMar.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Ingrese la marca.");
			return;
		}

		if (txtLab.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Ingrese el laboratorio.");
			return;
		}

		Categoria categoria = obtenerCategoriaIngresada();

		if (categoria == null) {
			JOptionPane.showMessageDialog(this, "Ingrese o seleccione una categoría.");
			return;
		}

		Producto p = new Producto();

		p.setId(0); // producto nuevo, todavía no existe en BD
		p.setNombre(txtNombre.getText().trim());
		p.setPrinAct(txtPrinAct.getText().trim());
		p.setMarca(txtMar.getText().trim());
		p.setLab(txtLab.getText().trim());
		p.setPresentacion(presentacion);

		// El precio se calculará luego desde compras
		p.setPrecio(0);

		p.setCategoria(categoria);

		p.setRequiereReceta(
				Boolean.parseBoolean(
						cboReqRec.getSelectedItem().toString()
				)
		);

		p.setActivo(true);

		productoCreado = p;

		dispose();
	}
}
