package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;
import java.util.ArrayList;
import arrayList.ArrayMovimiento;
import arrayList.ArrayProducto;
import arrayList.ArrayCategoria;
import clase.Producto;
import clase.Categoria;
import clase.Exportador;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class Movimientos extends JFrame implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JButton btnBuscarC;
	private JComboBox cboBuscarC;
	private JTextField txtBuscarC;
	private JComboBox cboBuscarProC;
	private JButton btnBuscarProC;
	private JComboBox cboBuscarCatC;
	private JButton btnBuscarCatC;
	private JLabel lblVentas;
	private JButton btnBuscarV;
	private JComboBox cboBuscarV;
	private JTextField txtBuscarV;
	private JComboBox cboBuscarProV;
	private JButton btnBuscarProV;
	private JComboBox cboBuscarCatV;
	private JButton btnBuscarCatV;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JButton btnListarTodoC;
	private JButton btnListarTodoV;
	private JButton btnRegresar;
	private JTable tblVen;
	private JTable tblCom;
	private JLabel lblNewLabel_1;
	private JTextField txtCosTotC;
	private JLabel lblNewLabel_2;
	private JTextField txtCosTotV;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Movimientos frame = new Movimientos();
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
	public Movimientos() {
		setTitle("Movimientos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 693);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(211, 211, 211));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel = new JLabel("Compras:");
			lblNewLabel.setBounds(10, 23, 59, 14);
			contentPane.add(lblNewLabel);
		}
		{
			btnBuscarC = new JButton("Buscar");
			btnBuscarC.addActionListener(this);
			btnBuscarC.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnBuscarC.setBounds(10, 48, 107, 23);
			contentPane.add(btnBuscarC);
		}
		{
			cboBuscarC = new JComboBox();
			cboBuscarC.setFont(new Font("Tahoma", Font.PLAIN, 11));
			cboBuscarC.setBounds(127, 48, 163, 22);
			contentPane.add(cboBuscarC);
		}
		{
			txtBuscarC = new JTextField();
			txtBuscarC.setFont(new Font("Tahoma", Font.PLAIN, 11));
			txtBuscarC.setBounds(10, 82, 280, 20);
			contentPane.add(txtBuscarC);
			txtBuscarC.setColumns(10);
		}
		{
			cboBuscarProC = new JComboBox();
			cboBuscarProC.setFont(new Font("Tahoma", Font.PLAIN, 11));
			cboBuscarProC.setBounds(10, 135, 280, 22);
			contentPane.add(cboBuscarProC);
		}
		{
			btnBuscarProC = new JButton("Buscar por Producto");
			btnBuscarProC.addActionListener(this);
			btnBuscarProC.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnBuscarProC.setBounds(10, 168, 140, 23);
			contentPane.add(btnBuscarProC);
		}
		{
			cboBuscarCatC = new JComboBox();
			cboBuscarCatC.setFont(new Font("Tahoma", Font.PLAIN, 11));
			cboBuscarCatC.setBounds(10, 221, 280, 22);
			contentPane.add(cboBuscarCatC);
		}
		{
			btnBuscarCatC = new JButton("Buscar por Categoria");
			btnBuscarCatC.addActionListener(this);
			btnBuscarCatC.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnBuscarCatC.setBounds(10, 254, 140, 23);
			contentPane.add(btnBuscarCatC);
		}
		{
			lblVentas = new JLabel("Ventas:");
			lblVentas.setBounds(10, 322, 59, 14);
			contentPane.add(lblVentas);
		}
		{
			btnBuscarV = new JButton("Buscar");
			btnBuscarV.addActionListener(this);
			btnBuscarV.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnBuscarV.setBounds(10, 347, 107, 23);
			contentPane.add(btnBuscarV);
		}
		{
			cboBuscarV = new JComboBox();
			cboBuscarV.setFont(new Font("Tahoma", Font.PLAIN, 11));
			cboBuscarV.setBounds(127, 347, 163, 22);
			contentPane.add(cboBuscarV);
		}
		{
			txtBuscarV = new JTextField();
			txtBuscarV.setFont(new Font("Tahoma", Font.PLAIN, 11));
			txtBuscarV.setColumns(10);
			txtBuscarV.setBounds(10, 381, 280, 20);
			contentPane.add(txtBuscarV);
		}
		{
			cboBuscarProV = new JComboBox();
			cboBuscarProV.setFont(new Font("Tahoma", Font.PLAIN, 11));
			cboBuscarProV.setBounds(10, 434, 280, 22);
			contentPane.add(cboBuscarProV);
		}
		{
			btnBuscarProV = new JButton("Buscar por Producto");
			btnBuscarProV.addActionListener(this);
			btnBuscarProV.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnBuscarProV.setBounds(10, 467, 140, 23);
			contentPane.add(btnBuscarProV);
		}
		{
			cboBuscarCatV = new JComboBox();
			cboBuscarCatV.setFont(new Font("Tahoma", Font.PLAIN, 11));
			cboBuscarCatV.setBounds(10, 520, 280, 22);
			contentPane.add(cboBuscarCatV);
		}
		{
			btnBuscarCatV = new JButton("Buscar por Categoria");
			btnBuscarCatV.addActionListener(this);
			btnBuscarCatV.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnBuscarCatV.setBounds(10, 553, 140, 23);
			contentPane.add(btnBuscarCatV);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(303, 23, 721, 254);
			contentPane.add(scrollPane);
			{
				modeloCompra = new DefaultTableModel(
						new Object[][] {},
						new String[] {
								"ID Compra",
								"Fecha",
								"Total Compra",
								"ID Detalle",
								"Cantidad",
								"Costo Uni.",
								"Subtotal",
								"ID Producto",
								"Producto",
								"Precio Act.",
								"Marca",
								"Laboratorio",
								"Categoría",
								"ID Lote",
								"N° Lote",
								"Vencimiento",
								"Stock Actual",
								"ID Usuario",
								"Usuario"
						}
				) {
					private static final long serialVersionUID = 1L;

					@Override
					public boolean isCellEditable(int row, int column) {
						return false;
					}
				};

				tblCom = new JTable();
				tblCom.setModel(modeloCompra);
				tblCom.setFillsViewportHeight(true);
				Color azulPalido = new Color(204, 229, 255);
				tblCom.getTableHeader().setBackground(azulPalido);
				tblCom.getTableHeader().setOpaque(true);
				scrollPane.setViewportView(tblCom);

				configurarAnchoColumnasCompra();
			}
		}
		{
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(303, 322, 721, 254);
			contentPane.add(scrollPane_1);
			{
				modeloVenta = new DefaultTableModel(
						new Object[][] {},
						new String[] {
								"ID Venta",
								"Fecha",
								"Total Venta",
								"ID Detalle",
								"Cantidad",
								"Precio Hist.",
								"Subtotal",
								"ID Producto",
								"Producto",
								"Precio Act.",
								"Marca",
								"Laboratorio",
								"Categoría",
								"ID Lote",
								"N° Lote",
								"Vencimiento",
								"Stock Actual",
								"ID Usuario",
								"Usuario"
						}
				) {
					private static final long serialVersionUID = 1L;

					@Override
					public boolean isCellEditable(int row, int column) {
						return false;
					}
				};

				tblVen = new JTable();
				tblVen.setModel(modeloVenta);
				tblVen.setFillsViewportHeight(true);
				Color azulPalido = new Color(204, 229, 255);
				tblVen.getTableHeader().setBackground(azulPalido);
				tblVen.getTableHeader().setOpaque(true);
				scrollPane_1.setViewportView(tblVen);

				configurarAnchoColumnasVenta();
			}
		}
		{
			btnListarTodoC = new JButton("Listar Todo");
			btnListarTodoC.addActionListener(this);
			btnListarTodoC.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnListarTodoC.setBounds(917, 288, 107, 23);
			contentPane.add(btnListarTodoC);
		}
		{
			btnListarTodoV = new JButton("Listar Todo");
			btnListarTodoV.addActionListener(this);
			btnListarTodoV.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnListarTodoV.setBounds(917, 587, 107, 23);
			contentPane.add(btnListarTodoV);
		}
		{
			btnRegresar = new JButton("Regresar");
			btnRegresar.addActionListener(this);
			btnRegresar.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnRegresar.setBounds(10, 620, 89, 23);
			contentPane.add(btnRegresar);
		}
		{
			lblNewLabel_1 = new JLabel("Total Filtrado:");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_1.setBounds(303, 292, 74, 14);
			contentPane.add(lblNewLabel_1);
		}
		{
			txtCosTotC = new JTextField();
			txtCosTotC.setBounds(387, 288, 86, 20);
			contentPane.add(txtCosTotC);
			txtCosTotC.setColumns(10);
		}
		{
			lblNewLabel_2 = new JLabel("Total Filtrado:");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_2.setBounds(303, 591, 74, 14);
			contentPane.add(lblNewLabel_2);
		}
		{
			txtCosTotV = new JTextField();
			txtCosTotV.setColumns(10);
			txtCosTotV.setBounds(387, 587, 86, 20);
			contentPane.add(txtCosTotV);
		}
		{
			lblNewLabel_3 = new JLabel("i");
			lblNewLabel_3.addMouseListener(this);
			lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
			lblNewLabel_3.setBounds(267, 11, 23, 20);
			contentPane.add(lblNewLabel_3);
		}
		{
			btnNewButton = new JButton("Exportar a Excel");
			btnNewButton.addActionListener(this);
			btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnNewButton.setBounds(884, 620, 140, 23);
			contentPane.add(btnNewButton);
		}

		cargarCombosBuscarPrincipales();
		prepararVentana();

		listarTodoCompras();
		listarTodoVentas();
		
		cargarCombosProductoCategoria();
	}
	
	private DefaultTableModel modeloCompra;
	private DefaultTableModel modeloVenta;
	
	private ArrayMovimiento arrMovimiento = new ArrayMovimiento();

	private ArrayList<Object[]> listaCompras = new ArrayList<>();
	private ArrayList<Object[]> listaVentas = new ArrayList<>();
	
	private ArrayProducto arrProducto = new ArrayProducto();
	private ArrayCategoria arrCategoria = new ArrayCategoria();

	private ArrayList<Producto> listaProductos = new ArrayList<Producto>();
	private ArrayList<Categoria> listaCategorias = new ArrayList<Categoria>();
	private JLabel lblNewLabel_3;
	private JButton btnNewButton;
	
	private void prepararVentana() {

		txtCosTotC.setEditable(false);
		txtCosTotV.setEditable(false);

		txtCosTotC.setHorizontalAlignment(SwingConstants.RIGHT);
		txtCosTotV.setHorizontalAlignment(SwingConstants.RIGHT);

		txtCosTotC.setText("0.00");
		txtCosTotV.setText("0.00");
	}
	
	private void llenarTablaCompras(ArrayList<Object[]> lista) {

		modeloCompra.setRowCount(0);

		for (Object[] fila : lista) {
			modeloCompra.addRow(fila);
		}

		calcularTotalComprasVisible();
	}
	
	private void calcularTotalComprasVisible() {

		double total = 0;

		for (int i = 0; i < modeloCompra.getRowCount(); i++) {

			Object valor = modeloCompra.getValueAt(i, 6);

			if (valor != null) {
				total += Double.parseDouble(valor.toString());
			}
		}

		txtCosTotC.setText(String.format("%.2f", total));
	}
	
	private void llenarTablaVentas(ArrayList<Object[]> lista) {

		modeloVenta.setRowCount(0);

		for (Object[] fila : lista) {
			modeloVenta.addRow(fila);
		}

		calcularTotalVentasVisible();
	}
	
	private void calcularTotalVentasVisible() {

		double total = 0;

		for (int i = 0; i < modeloVenta.getRowCount(); i++) {

			Object valor = modeloVenta.getValueAt(i, 6);

			if (valor != null) {
				total += Double.parseDouble(valor.toString());
			}
		}

		txtCosTotV.setText(String.format("%.2f", total));
	}
	
	private void listarTodoCompras() {

		listaCompras = arrMovimiento.listarMovimientosCompras();

		llenarTablaCompras(listaCompras);
	}
	
	private void listarTodoVentas() {

		listaVentas = arrMovimiento.listarMovimientosVentas();

		llenarTablaVentas(listaVentas);
	}
	
	private void cargarCombosBuscarPrincipales() {

		// Combo de búsqueda para compras
		cboBuscarC.removeAllItems();
		cboBuscarC.addItem("Seleccione...");
		cboBuscarC.addItem("Fecha");
		cboBuscarC.addItem("Lote");
		cboBuscarC.addItem("Usuario");
		cboBuscarC.addItem("ID Compra");

		// Combo de búsqueda para ventas
		cboBuscarV.removeAllItems();
		cboBuscarV.addItem("Seleccione...");
		cboBuscarV.addItem("Fecha");
		cboBuscarV.addItem("Lote");
		cboBuscarV.addItem("Usuario");
		cboBuscarV.addItem("ID Venta");
	}
	
	private void configurarAnchoColumnasCompra() {

		tblCom.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		tblCom.getColumnModel().getColumn(0).setPreferredWidth(80);   
		tblCom.getColumnModel().getColumn(1).setPreferredWidth(90);   
		tblCom.getColumnModel().getColumn(2).setPreferredWidth(90);   
		tblCom.getColumnModel().getColumn(3).setPreferredWidth(80);   
		tblCom.getColumnModel().getColumn(4).setPreferredWidth(70);   
		tblCom.getColumnModel().getColumn(5).setPreferredWidth(85);   
		tblCom.getColumnModel().getColumn(6).setPreferredWidth(85);   
		tblCom.getColumnModel().getColumn(7).setPreferredWidth(85);   
		tblCom.getColumnModel().getColumn(8).setPreferredWidth(180);  
		tblCom.getColumnModel().getColumn(9).setPreferredWidth(85);   
		tblCom.getColumnModel().getColumn(10).setPreferredWidth(120); 
		tblCom.getColumnModel().getColumn(11).setPreferredWidth(150); 
		tblCom.getColumnModel().getColumn(12).setPreferredWidth(130); 
		tblCom.getColumnModel().getColumn(13).setPreferredWidth(80);  
		tblCom.getColumnModel().getColumn(14).setPreferredWidth(160); 
		tblCom.getColumnModel().getColumn(15).setPreferredWidth(100); 
		tblCom.getColumnModel().getColumn(16).setPreferredWidth(90);  
		tblCom.getColumnModel().getColumn(17).setPreferredWidth(80);  
		tblCom.getColumnModel().getColumn(18).setPreferredWidth(180); 
	}
	
	private void configurarAnchoColumnasVenta() {

		tblVen.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		tblVen.getColumnModel().getColumn(0).setPreferredWidth(80);   
		tblVen.getColumnModel().getColumn(1).setPreferredWidth(90);   
		tblVen.getColumnModel().getColumn(2).setPreferredWidth(90);   
		tblVen.getColumnModel().getColumn(3).setPreferredWidth(80);   
		tblVen.getColumnModel().getColumn(4).setPreferredWidth(70);   
		tblVen.getColumnModel().getColumn(5).setPreferredWidth(85);   
		tblVen.getColumnModel().getColumn(6).setPreferredWidth(85);   
		tblVen.getColumnModel().getColumn(7).setPreferredWidth(85);   
		tblVen.getColumnModel().getColumn(8).setPreferredWidth(180);  
		tblVen.getColumnModel().getColumn(9).setPreferredWidth(85);   
		tblVen.getColumnModel().getColumn(10).setPreferredWidth(120); 
		tblVen.getColumnModel().getColumn(11).setPreferredWidth(150); 
		tblVen.getColumnModel().getColumn(12).setPreferredWidth(130); 
		tblVen.getColumnModel().getColumn(13).setPreferredWidth(80);  
		tblVen.getColumnModel().getColumn(14).setPreferredWidth(160); 
		tblVen.getColumnModel().getColumn(15).setPreferredWidth(100); 
		tblVen.getColumnModel().getColumn(16).setPreferredWidth(90);  
		tblVen.getColumnModel().getColumn(17).setPreferredWidth(80);  
		tblVen.getColumnModel().getColumn(18).setPreferredWidth(180); 
	}
	
	private void cargarCombosProductoCategoria() {

		cboBuscarProC.removeAllItems();
		cboBuscarProV.removeAllItems();

		cboBuscarProC.addItem("Seleccione producto...");
		cboBuscarProV.addItem("Seleccione producto...");

		listaProductos = arrProducto.ListarProducto();

		for (Producto p : listaProductos) {
			cboBuscarProC.addItem(p.getNombre());
			cboBuscarProV.addItem(p.getNombre());
		}

		cboBuscarCatC.removeAllItems();
		cboBuscarCatV.removeAllItems();

		cboBuscarCatC.addItem("Seleccione categoría...");
		cboBuscarCatV.addItem("Seleccione categoría...");

		listaCategorias = arrCategoria.ListarCategoria();

		for (Categoria c : listaCategorias) {
			cboBuscarCatC.addItem(c.getNombre());
			cboBuscarCatV.addItem(c.getNombre());
		}
	}
	
	private boolean productoSeleccionadoEstaDeshabilitado(JComboBox comboProducto) {

		Object seleccionado = comboProducto.getSelectedItem();

		if (seleccionado == null) {
			return false;
		}

		String nombreProducto = seleccionado.toString();

		if (nombreProducto.equals("Seleccione producto...")) {
			return false;
		}

		for (Producto p : listaProductos) {

			if (p.getNombre().equals(nombreProducto)) {

				if (!p.isActivo()) {
					return true;
				}
			}
		}

		return false;
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) {
			do_btnNewButton_actionPerformed(e);
		}
		if (e.getSource() == btnRegresar) {
			do_btnRegresar_actionPerformed(e);
		}
		if (e.getSource() == btnBuscarV) {
			do_btnBuscarV_actionPerformed(e);
		}
		if (e.getSource() == btnBuscarC) {
			do_btnBuscarC_actionPerformed(e);
		}
		if (e.getSource() == btnBuscarCatV) {
			do_btnBuscarCatV_actionPerformed(e);
		}
		if (e.getSource() == btnBuscarCatC) {
			do_btnBuscarCatC_actionPerformed(e);
		}
		if (e.getSource() == btnListarTodoC) {
			do_btnListarTodoC_actionPerformed(e);
		}
		if (e.getSource() == btnListarTodoV) {
			do_btnListarTodoV_actionPerformed(e);
		}
		if (e.getSource() == btnBuscarProV) {
			do_btnBuscarProV_actionPerformed(e);
		}
		if (e.getSource() == btnBuscarProC) {
			do_btnBuscarProC_actionPerformed(e);
		}
	}
	
	private void filtrarComprasPorProducto(String nombreProducto) {

		ArrayList<Object[]> listaFiltrada = new ArrayList<Object[]>();

		for (Object[] fila : listaCompras) {

			String productoTabla = fila[8].toString();

			if (productoTabla.equals(nombreProducto)) {
				listaFiltrada.add(fila);
			}
		}

		llenarTablaCompras(listaFiltrada);
	}
	
	protected void do_btnBuscarProC_actionPerformed(ActionEvent e) {
		Object seleccionado = cboBuscarProC.getSelectedItem();

		if (seleccionado == null ||
				seleccionado.toString().equals("Seleccione producto...")) {

			JOptionPane.showMessageDialog(
					this,
					"Seleccione un producto."
			);
			return;
		}

		String nombreProducto = seleccionado.toString();

		if (productoSeleccionadoEstaDeshabilitado(cboBuscarProC)) {
			JOptionPane.showMessageDialog(
					this,
					"Advertencia: el producto seleccionado está deshabilitado.\n" +
					"Se mostrarán movimientos históricos relacionados."
			);
		}

		filtrarComprasPorProducto(nombreProducto);
	}
	
	private void filtrarVentasPorProducto(String nombreProducto) {

		ArrayList<Object[]> listaFiltrada = new ArrayList<Object[]>();

		for (Object[] fila : listaVentas) {

			String productoTabla = fila[8].toString();

			if (productoTabla.equals(nombreProducto)) {
				listaFiltrada.add(fila);
			}
		}

		llenarTablaVentas(listaFiltrada);
	}
	
	protected void do_btnBuscarProV_actionPerformed(ActionEvent e) {
		Object seleccionado = cboBuscarProV.getSelectedItem();

		if (seleccionado == null ||
				seleccionado.toString().equals("Seleccione producto...")) {

			JOptionPane.showMessageDialog(
					this,
					"Seleccione un producto."
			);
			return;
		}

		String nombreProducto = seleccionado.toString();

		if (productoSeleccionadoEstaDeshabilitado(cboBuscarProV)) {
			JOptionPane.showMessageDialog(
					this,
					"Advertencia: el producto seleccionado está deshabilitado.\n" +
					"Se mostrarán movimientos históricos relacionados."
			);
		}

		filtrarVentasPorProducto(nombreProducto);

	}
	
	
	protected void do_btnListarTodoV_actionPerformed(ActionEvent e) {
		listarTodoVentas();
	}
	
	protected void do_btnListarTodoC_actionPerformed(ActionEvent e) {
		listarTodoCompras();
	}
	
	private void filtrarComprasPorCategoria(String nombreCategoria) {

		ArrayList<Object[]> listaFiltrada = new ArrayList<Object[]>();

		for (Object[] fila : listaCompras) {

			String categoriaTabla = fila[12].toString();

			if (categoriaTabla.equals(nombreCategoria)) {
				listaFiltrada.add(fila);
			}
		}

		llenarTablaCompras(listaFiltrada);
	}
	
	protected void do_btnBuscarCatC_actionPerformed(ActionEvent e) {
		Object seleccionado = cboBuscarCatC.getSelectedItem();

		if (seleccionado == null ||
				seleccionado.toString().equals("Seleccione categoría...")) {

			JOptionPane.showMessageDialog(
					this,
					"Seleccione una categoría."
			);
			return;
		}

		String nombreCategoria = seleccionado.toString();

		filtrarComprasPorCategoria(nombreCategoria);
	}
	
	private void filtrarVentasPorCategoria(String nombreCategoria) {

		ArrayList<Object[]> listaFiltrada = new ArrayList<Object[]>();

		for (Object[] fila : listaVentas) {

			String categoriaTabla = fila[12].toString();

			if (categoriaTabla.equals(nombreCategoria)) {
				listaFiltrada.add(fila);
			}
		}

		llenarTablaVentas(listaFiltrada);
	}
	
	protected void do_btnBuscarCatV_actionPerformed(ActionEvent e) {
		Object seleccionado = cboBuscarCatV.getSelectedItem();

		if (seleccionado == null ||
				seleccionado.toString().equals("Seleccione categoría...")) {

			JOptionPane.showMessageDialog(
					this,
					"Seleccione una categoría."
			);
			return;
		}

		String nombreCategoria = seleccionado.toString();

		filtrarVentasPorCategoria(nombreCategoria);
	}
	
	private void filtrarComprasPrincipal(String tipoBusqueda, String texto) {

		ArrayList<Object[]> listaFiltrada = new ArrayList<Object[]>();

		for (Object[] fila : listaCompras) {

			if (tipoBusqueda.equals("Fecha")) {

				String fechaTabla = fila[1].toString();

				if (fechaTabla.equals(texto)) {
					listaFiltrada.add(fila);
				}
			}

			else if (tipoBusqueda.equals("Lote")) {

				String loteTabla = fila[14].toString();

				if (loteTabla.toLowerCase().contains(texto.toLowerCase())) {
					listaFiltrada.add(fila);
				}
			}

			else if (tipoBusqueda.equals("Usuario")) {

				String usuarioTabla = fila[18].toString();

				if (usuarioTabla.toLowerCase().contains(texto.toLowerCase())) {
					listaFiltrada.add(fila);
				}
			}

			else if (tipoBusqueda.equals("ID Compra")) {

				String idCompraTabla = fila[0].toString();

				if (idCompraTabla.equals(texto)) {
					listaFiltrada.add(fila);
				}
			}
		}

		llenarTablaCompras(listaFiltrada);
	}
	
	protected void do_btnBuscarC_actionPerformed(ActionEvent e) {
		Object opcion = cboBuscarC.getSelectedItem();

		if (opcion == null || opcion.toString().equals("Seleccione...")) {
			JOptionPane.showMessageDialog(
					this,
					"Seleccione una opción de búsqueda."
			);
			return;
		}

		String texto = txtBuscarC.getText().trim();

		if (texto.isEmpty()) {
			JOptionPane.showMessageDialog(
					this,
					"Ingrese un valor para buscar."
			);
			return;
		}

		String tipoBusqueda = opcion.toString();

		if (tipoBusqueda.equals("Fecha")) {

			try {
				java.time.LocalDate.parse(texto);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(
						this,
						"Formato de fecha incorrecto.\nUse: AAAA-MM-DD"
				);
				return;
			}
		}

		filtrarComprasPrincipal(tipoBusqueda, texto);
	}
	
	private void filtrarVentasPrincipal(String tipoBusqueda, String texto) {

		ArrayList<Object[]> listaFiltrada = new ArrayList<Object[]>();

		for (Object[] fila : listaVentas) {

			if (tipoBusqueda.equals("Fecha")) {

				String fechaTabla = fila[1].toString();

				if (fechaTabla.equals(texto)) {
					listaFiltrada.add(fila);
				}
			}

			else if (tipoBusqueda.equals("Lote")) {

				String loteTabla = fila[14].toString();

				if (loteTabla.toLowerCase().contains(texto.toLowerCase())) {
					listaFiltrada.add(fila);
				}
			}

			else if (tipoBusqueda.equals("Usuario")) {

				String usuarioTabla = fila[18].toString();

				if (usuarioTabla.toLowerCase().contains(texto.toLowerCase())) {
					listaFiltrada.add(fila);
				}
			}

			else if (tipoBusqueda.equals("ID Venta")) {

				String idVentaTabla = fila[0].toString();

				if (idVentaTabla.equals(texto)) {
					listaFiltrada.add(fila);
				}
			}
		}

		llenarTablaVentas(listaFiltrada);
	}
	
	protected void do_btnBuscarV_actionPerformed(ActionEvent e) {
		Object opcion = cboBuscarV.getSelectedItem();

		if (opcion == null || opcion.toString().equals("Seleccione...")) {
			JOptionPane.showMessageDialog(
					this,
					"Seleccione una opción de búsqueda."
			);
			return;
		}

		String texto = txtBuscarV.getText().trim();

		if (texto.isEmpty()) {
			JOptionPane.showMessageDialog(
					this,
					"Ingrese un valor para buscar."
			);
			return;
		}

		String tipoBusqueda = opcion.toString();

		if (tipoBusqueda.equals("Fecha")) {

			try {
				java.time.LocalDate.parse(texto);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(
						this,
						"Formato de fecha incorrecto.\nUse: AAAA-MM-DD"
				);
				return;
			}
		}

		filtrarVentasPrincipal(tipoBusqueda, texto);
	}
	
	protected void do_btnRegresar_actionPerformed(ActionEvent e) {
		Menu ventanaMenu = new Menu();
	    ventanaMenu.setVisible(true);
	    this.dispose();
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
			    "Esta ventana es solo de consulta y esta diseñada para facilitar la"
			    + "\nvisualizacion de las compras o ventas por los filtros que se elijan."
			    + "\n"
			    + "\nLas secciones tanto de compras como ventas funcionan independientemente"
			    + "\nde la otra."
			    + "\n"
			    + "\nEn esta ventana se realiza la operacion automaticamente al presionar el"
			    + "\nboton y tomara su dato de su campo de texto o desplegable relacionado."
			    + "\n"
			    + "\nAparte de esto cada tabla calculara el total de cada elemento que lo"
			    + "\ncontenga devolviendo el total gastado o adquirido por producto o fecha"
			    + "\npor ejemplo.",
			    "Informacion.",
			    JOptionPane.INFORMATION_MESSAGE
			);
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		JFileChooser seleccionador = new JFileChooser();
		seleccionador.setDialogTitle("Guardar Reporte Excel de Movimientos");

		// Filtramos para que solo muestre y guarde en formato Excel
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos Excel (*.xlsx)", "xlsx");
		seleccionador.setFileFilter(filtro);

		int opcion = seleccionador.showSaveDialog(null);

		if (opcion == JFileChooser.APPROVE_OPTION) {
		    String ruta = seleccionador.getSelectedFile().getAbsolutePath();
		    
		    // Asegurarnos de que el archivo termine en .xlsx
		    if (!ruta.endsWith(".xlsx")) {
		        ruta += ".xlsx";
		    }
		    // Llamamos a nuestra clase Exportador, pasándole la tabla y la ruta
		    Exportador.exportarKardexAExcel(tblCom, tblVen, ruta);
		}
	}
}
