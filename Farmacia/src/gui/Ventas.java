package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import arrayList.ArrayCategoria;
import arrayList.ArrayLote;
import arrayList.ArrayProducto;
import clase.Categoria;
import clase.DetalleVenta;
import clase.Lote;
import clase.Producto;
import clase.SesionUsuario;
import clase.Usuario;
import clase.Venta;
import arrayList.ArrayVenta;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class Ventas extends JFrame implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblVenta;
	private JLabel lblNewLabel_1;
	private JButton btnLimpiar;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JTextField txtCodVen;
	private JTextField txtFechaVen;
	private JTextField txtUsuario;
	private JLabel lblNewLabel_6;
	private JTextField txtCosTotVen;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JTextField txtCodDV;
	private JTextField txtPreFecDV;
	private JTextField txtCantDV;
	private JTextField txtSubTotDV;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_12;
	private JLabel lblNewLabel_13;
	private JLabel lblNewLabel_14;
	private JTextField txtCodP;
	private JComboBox cboNomP;
	private JLabel lblNewLabel_15;
	private JTextField txtPreP;
	private JComboBox cboCatP;
	private JLabel lblNewLabel_16;
	private JTextArea txtPresP;
	private JLabel lblLote;
	private JLabel lblNewLabel_17;
	private JLabel lblNewLabel_18;
	private JLabel lblNewLabel_19;
	private JLabel lblNewLabel_20;
	private JTextField txtNroLote;
	private JTextField txtCodLote;
	private JTextField txtStockActLote;
	private JLabel lblNewLabel_21;
	private JTextField txtFechaVenciLote;
	private JButton btnNueVen;
	private JButton btnAgreVen;
	private JButton btnTerminarVenta;
	private JButton btnEliminarElemento;
	private JButton btnCancelar;
	private JScrollPane scrollPane;
	private JButton btnBuscar;
	private JComboBox cboBuscar;
	private JTextField txtBuscar;
	private JButton btnLisTodo;
	private JButton btnRegresar;
	private JTable table;
	
	private DefaultTableModel modeloTable;
	private JTable tblVen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventas frame = new Ventas();
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
	public Ventas() {
		setTitle("Sección Ventas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1230, 772);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblVenta = new JLabel("Venta:");
			lblVenta.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblVenta.setBounds(10, 23, 57, 14);
			contentPane.add(lblVenta);
		}
		{
			lblNewLabel_1 = new JLabel("*Vendiendo...");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_1.setBounds(99, 23, 110, 14);
			contentPane.add(lblNewLabel_1);
		}
		{
			btnLimpiar = new JButton("Limpiar Campos");
			btnLimpiar.addActionListener(this);
			btnLimpiar.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnLimpiar.setBounds(227, 19, 121, 23);
			contentPane.add(btnLimpiar);
		}
		{
			lblNewLabel_2 = new JLabel("Codigo:");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_2.setBounds(10, 51, 46, 14);
			contentPane.add(lblNewLabel_2);
		}
		{
			lblNewLabel_3 = new JLabel("Fecha:");
			lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_3.setBounds(10, 82, 46, 14);
			contentPane.add(lblNewLabel_3);
		}
		{
			lblNewLabel_4 = new JLabel("Usuario:");
			lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_4.setBounds(10, 110, 46, 14);
			contentPane.add(lblNewLabel_4);
		}
		{
			txtCodVen = new JTextField();
			txtCodVen.setFont(new Font("Tahoma", Font.PLAIN, 11));
			txtCodVen.setBounds(66, 48, 86, 20);
			contentPane.add(txtCodVen);
			txtCodVen.setColumns(10);
		}
		{
			txtFechaVen = new JTextField();
			txtFechaVen.setHorizontalAlignment(SwingConstants.CENTER);
			txtFechaVen.setFont(new Font("Tahoma", Font.PLAIN, 11));
			txtFechaVen.setColumns(10);
			txtFechaVen.setBounds(66, 79, 86, 20);
			contentPane.add(txtFechaVen);
		}
		{
			txtUsuario = new JTextField();
			txtUsuario.setFont(new Font("Tahoma", Font.PLAIN, 11));
			txtUsuario.setColumns(10);
			txtUsuario.setBounds(66, 107, 282, 20);
			contentPane.add(txtUsuario);
		}
		{
			lblNewLabel_6 = new JLabel("Costo Total:");
			lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_6.setBounds(181, 82, 72, 14);
			contentPane.add(lblNewLabel_6);
		}
		{
			txtCosTotVen = new JTextField();
			txtCosTotVen.setHorizontalAlignment(SwingConstants.RIGHT);
			txtCosTotVen.setFont(new Font("Tahoma", Font.PLAIN, 11));
			txtCosTotVen.setColumns(10);
			txtCosTotVen.setBounds(262, 79, 86, 20);
			contentPane.add(txtCosTotVen);
		}
		{
			lblNewLabel_7 = new JLabel("Detalle de Venta:");
			lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel_7.setBounds(10, 146, 110, 14);
			contentPane.add(lblNewLabel_7);
		}
		{
			lblNewLabel_8 = new JLabel("Codigo:");
			lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_8.setBounds(10, 174, 46, 14);
			contentPane.add(lblNewLabel_8);
		}
		{
			lblNewLabel_9 = new JLabel("Precio/Fecha:");
			lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_9.setBounds(10, 205, 79, 14);
			contentPane.add(lblNewLabel_9);
		}
		{
			lblNewLabel_10 = new JLabel("SubTotal:");
			lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_10.setBounds(195, 205, 57, 14);
			contentPane.add(lblNewLabel_10);
		}
		{
			lblNewLabel_11 = new JLabel("Cantidad:");
			lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_11.setBounds(195, 174, 57, 14);
			contentPane.add(lblNewLabel_11);
		}
		{
			txtCodDV = new JTextField();
			txtCodDV.setText("");
			txtCodDV.setHorizontalAlignment(SwingConstants.RIGHT);
			txtCodDV.setFont(new Font("Tahoma", Font.PLAIN, 11));
			txtCodDV.setEditable(false);
			txtCodDV.setColumns(10);
			txtCodDV.setBounds(99, 171, 86, 20);
			contentPane.add(txtCodDV);
		}
		{
			txtPreFecDV = new JTextField();
			txtPreFecDV.setText("");
			txtPreFecDV.setHorizontalAlignment(SwingConstants.RIGHT);
			txtPreFecDV.setFont(new Font("Tahoma", Font.PLAIN, 11));
			txtPreFecDV.setEditable(false);
			txtPreFecDV.setColumns(10);
			txtPreFecDV.setBounds(99, 202, 86, 20);
			contentPane.add(txtPreFecDV);
		}
		{
			txtCantDV = new JTextField();
			txtCantDV.setText("");
			txtCantDV.setHorizontalAlignment(SwingConstants.RIGHT);
			txtCantDV.setFont(new Font("Tahoma", Font.PLAIN, 11));
			txtCantDV.setEditable(false);
			txtCantDV.setColumns(10);
			txtCantDV.setBounds(262, 171, 86, 20);
			contentPane.add(txtCantDV);
			
			txtCantDV.addKeyListener(new java.awt.event.KeyAdapter() {

			    @Override
			    public void keyTyped(java.awt.event.KeyEvent e) {
			        char c = e.getKeyChar();

			        // permitir solo números
			        if (!Character.isDigit(c)) {
			            e.consume();
			        }
			    }

			    @Override
			    public void keyReleased(java.awt.event.KeyEvent e) {
			        calcularSubtotal();
			    }
			});
		}
		{
			txtSubTotDV = new JTextField();
			txtSubTotDV.setText("");
			txtSubTotDV.setHorizontalAlignment(SwingConstants.RIGHT);
			txtSubTotDV.setFont(new Font("Tahoma", Font.PLAIN, 11));
			txtSubTotDV.setEditable(false);
			txtSubTotDV.setColumns(10);
			txtSubTotDV.setBounds(262, 202, 86, 20);
			contentPane.add(txtSubTotDV);
		}
		{
			lblNewLabel = new JLabel("Producto:");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel.setBounds(10, 238, 79, 14);
			contentPane.add(lblNewLabel);
		}
		{
			lblNewLabel_12 = new JLabel("Codigo:");
			lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_12.setBounds(10, 265, 46, 14);
			contentPane.add(lblNewLabel_12);
		}
		{
			lblNewLabel_13 = new JLabel("Nombre:");
			lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_13.setBounds(10, 296, 46, 14);
			contentPane.add(lblNewLabel_13);
		}
		{
			lblNewLabel_14 = new JLabel("Categoria:");
			lblNewLabel_14.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_14.setBounds(10, 327, 57, 14);
			contentPane.add(lblNewLabel_14);
		}
		{
			txtCodP = new JTextField();
			txtCodP.setText("");
			txtCodP.setHorizontalAlignment(SwingConstants.RIGHT);
			txtCodP.setFont(new Font("Tahoma", Font.PLAIN, 11));
			txtCodP.setEditable(false);
			txtCodP.setColumns(10);
			txtCodP.setBounds(77, 262, 108, 20);
			contentPane.add(txtCodP);
		}
		{
			cboNomP = new JComboBox();
			cboNomP.setFont(new Font("Tahoma", Font.PLAIN, 11));
			cboNomP.setSelectedIndex(-1);
			cboNomP.setEditable(true);
			cboNomP.setBounds(77, 292, 271, 22);
			contentPane.add(cboNomP);
			
			cboNomP.addItemListener(new ItemListener() {
			    @Override
			    public void itemStateChanged(ItemEvent e) {
			        cboProductoItemStateChanged(e);
			    }
			});
		}
		{
			lblNewLabel_15 = new JLabel("Precio Act.:");
			lblNewLabel_15.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_15.setBounds(195, 265, 57, 14);
			contentPane.add(lblNewLabel_15);
		}
		{
			txtPreP = new JTextField();
			txtPreP.setText("");
			txtPreP.setHorizontalAlignment(SwingConstants.RIGHT);
			txtPreP.setFont(new Font("Tahoma", Font.PLAIN, 11));
			txtPreP.setEditable(false);
			txtPreP.setColumns(10);
			txtPreP.setBounds(262, 262, 86, 20);
			contentPane.add(txtPreP);
		}
		{
			cboCatP = new JComboBox();
			cboCatP.setFont(new Font("Tahoma", Font.PLAIN, 11));
			cboCatP.setSelectedIndex(-1);
			cboCatP.setEditable(true);
			cboCatP.setBounds(77, 323, 271, 22);
			contentPane.add(cboCatP);
			
			cboCatP.addItemListener(new ItemListener() {
			    @Override
			    public void itemStateChanged(ItemEvent e) {
			        cboCategoriaItemStateChanged(e);
			    }
			});
		}
		{
			lblNewLabel_16 = new JLabel("Presentacion:");
			lblNewLabel_16.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_16.setBounds(10, 358, 72, 14);
			contentPane.add(lblNewLabel_16);
		}
		{
			txtPresP = new JTextArea();
			txtPresP.setFont(new Font("Monospaced", Font.PLAIN, 13));
			txtPresP.setWrapStyleWord(true);
			txtPresP.setToolTipText("");
			txtPresP.setText("");
			txtPresP.setLineWrap(true);
			txtPresP.setEditable(false);
			txtPresP.setBounds(10, 383, 338, 79);
			contentPane.add(txtPresP);
		}
		{
			lblLote = new JLabel("Lote:");
			lblLote.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblLote.setBounds(10, 483, 79, 14);
			contentPane.add(lblLote);
		}
		{
			lblNewLabel_17 = new JLabel("Codigo:");
			lblNewLabel_17.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_17.setBounds(10, 511, 46, 14);
			contentPane.add(lblNewLabel_17);
		}
		{
			lblNewLabel_18 = new JLabel("Numero de Lote:");
			lblNewLabel_18.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_18.setBounds(10, 539, 110, 14);
			contentPane.add(lblNewLabel_18);
		}
		{
			lblNewLabel_19 = new JLabel("Fecha de Vencimiento:");
			lblNewLabel_19.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_19.setBounds(10, 567, 110, 14);
			contentPane.add(lblNewLabel_19);
		}
		{
			lblNewLabel_20 = new JLabel("Stock Actual:");
			lblNewLabel_20.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_20.setBounds(10, 598, 110, 14);
			contentPane.add(lblNewLabel_20);
		}
		{
			txtNroLote = new JTextField();
			txtNroLote.setText("");
			txtNroLote.setHorizontalAlignment(SwingConstants.RIGHT);
			txtNroLote.setFont(new Font("Tahoma", Font.PLAIN, 11));
			txtNroLote.setEditable(false);
			txtNroLote.setColumns(10);
			txtNroLote.setBounds(130, 536, 218, 20);
			contentPane.add(txtNroLote);
		}
		{
			txtCodLote = new JTextField();
			txtCodLote.setText("");
			txtCodLote.setHorizontalAlignment(SwingConstants.RIGHT);
			txtCodLote.setFont(new Font("Tahoma", Font.PLAIN, 11));
			txtCodLote.setEditable(false);
			txtCodLote.setColumns(10);
			txtCodLote.setBounds(130, 508, 122, 20);
			contentPane.add(txtCodLote);
		}
		{
			txtStockActLote = new JTextField();
			txtStockActLote.setText("");
			txtStockActLote.setHorizontalAlignment(SwingConstants.RIGHT);
			txtStockActLote.setFont(new Font("Tahoma", Font.PLAIN, 11));
			txtStockActLote.setEditable(false);
			txtStockActLote.setColumns(10);
			txtStockActLote.setBounds(130, 595, 122, 20);
			contentPane.add(txtStockActLote);
		}
		{
			lblNewLabel_21 = new JLabel("(AAAA/MM/DD)");
			lblNewLabel_21.setBounds(262, 567, 86, 14);
			contentPane.add(lblNewLabel_21);
		}
		{
			try {
			    // Definimos la máscara rígida Año-Mes-Día para MySQL (AAAA-MM-DD)
			    javax.swing.text.MaskFormatter mascara = new javax.swing.text.MaskFormatter("####/##/##");
			    mascara.setPlaceholderCharacter('_'); // Muestra guiones bajos como guía visual
			    
			    txtFechaVenciLote = new javax.swing.JFormattedTextField(mascara);
			    txtFechaVenciLote.setHorizontalAlignment(SwingConstants.CENTER);
			    txtFechaVenciLote.setFont(new Font("Tahoma", Font.PLAIN, 11));
			    txtFechaVenciLote.setBounds(130, 564, 79, 20); // Mantiene la posición y tamaño exacto que ya tenías
			    contentPane.add(txtFechaVenciLote);
			    {
			    	btnNueVen = new JButton("Nueva Venta");
			    	btnNueVen.addActionListener(this);
			    	btnNueVen.setFont(new Font("Tahoma", Font.PLAIN, 11));
			    	btnNueVen.setEnabled(true);
			    	btnNueVen.setBounds(10, 631, 110, 23);
			    	contentPane.add(btnNueVen);
			    }
			    {
			    	btnAgreVen = new JButton("Agregar a la Venta");
			    	btnAgreVen.addActionListener(this);
			    	btnAgreVen.setFont(new Font("Tahoma", Font.PLAIN, 11));
			    	btnAgreVen.setEnabled(false);
			    	btnAgreVen.setBounds(208, 631, 150, 23);
			    	contentPane.add(btnAgreVen);
			    }
			    {
			    	btnTerminarVenta = new JButton("Terminar Venta");
			    	btnTerminarVenta.addActionListener(this);
			    	btnTerminarVenta.setFont(new Font("Tahoma", Font.PLAIN, 11));
			    	btnTerminarVenta.setEnabled(false);
			    	btnTerminarVenta.setBounds(237, 665, 121, 23);
			    	contentPane.add(btnTerminarVenta);
			    }
			    {
			    	btnEliminarElemento = new JButton("Eliminar Elemento de  la Lista");
			    	btnEliminarElemento.addActionListener(this);
			    	btnEliminarElemento.setFont(new Font("Tahoma", Font.PLAIN, 11));
			    	btnEliminarElemento.setEnabled(false);
			    	btnEliminarElemento.setBounds(10, 665, 175, 23);
			    	contentPane.add(btnEliminarElemento);
			    }
			    {
			    	btnCancelar = new JButton("Cancelar Venta");
			    	btnCancelar.addActionListener(this);
			    	btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 11));
			    	btnCancelar.setEnabled(false);
			    	btnCancelar.setBounds(10, 699, 121, 23);
			    	contentPane.add(btnCancelar);
			    }
			    {
			    	scrollPane = new JScrollPane();
			    	scrollPane.setBounds(370, 23, 834, 631);
			    	contentPane.add(scrollPane);
			    	{
			    		modeloTable = new DefaultTableModel(
							    new Object[][] {},
							    new String[] {
							        "ID Venta", "Fecha", "ID Producto", "Producto", "Cantidad", "Precio", "Subtotal",
							         "N° Lote", "Fecha Vencimiento", "ID Detalle", "Costo/Fecha", "Usuario"
							    }
							) {
							    private static final long serialVersionUID = 1L;
							    @Override
							    public boolean isCellEditable(int row, int column) {
							        return false;
							    }
							};
							
							tblVen = new JTable();
							tblVen.setModel(modeloTable);
							java.awt.Color amarilloPalido = new java.awt.Color(255, 250, 205); 
							tblVen.getTableHeader().setBackground(amarilloPalido);
							tblVen.getTableHeader().setOpaque(true); 
							tblVen.setFillsViewportHeight(true);
							scrollPane.setViewportView(tblVen);
							
							scrollPane.setViewportView(tblVen);
							
							configurarAnchoColumnas();
							
							tblVen.addMouseListener(new java.awt.event.MouseAdapter() {
								@Override
								public void mouseClicked(java.awt.event.MouseEvent e) {

									if (!estadoVendiendo) {

										int filaSeleccionada = tblVen.getSelectedRow();

										if (filaSeleccionada != -1) {
											pasarDatosDeTablaACampos(filaSeleccionada);
										}
									}
								}
							});
			    	}
			    }
			    {
			    	btnBuscar = new JButton("Buscar");
			    	btnBuscar.addActionListener(this);
			    	btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 11));
			    	btnBuscar.setEnabled(true);
			    	btnBuscar.setBounds(368, 665, 89, 23);
			    	contentPane.add(btnBuscar);
			    }
			    {
			    	cboBuscar = new JComboBox();
			    	cboBuscar.setEnabled(true);
			    	cboBuscar.setBounds(467, 665, 131, 22);
			    	contentPane.add(cboBuscar);
			    	
			    	cboBuscar.addItem("Seleccione...");
			    	cboBuscar.addItem("Fecha");
			    }
			    {
			    	txtBuscar = new JTextField();
			    	txtBuscar.setEnabled(true);
			    	txtBuscar.setColumns(10);
			    	txtBuscar.setBounds(608, 666, 131, 20);
			    	contentPane.add(txtBuscar);
			    }
			    {
			    	btnLisTodo = new JButton("Listar Todo");
			    	btnLisTodo.addActionListener(this);
			    	btnLisTodo.setFont(new Font("Tahoma", Font.PLAIN, 11));
			    	btnLisTodo.setEnabled(true);
			    	btnLisTodo.setBounds(1078, 665, 126, 23);
			    	contentPane.add(btnLisTodo);
			    }
			    {
			    	btnRegresar = new JButton("Regresar");
			    	btnRegresar.addActionListener(this);
			    	btnRegresar.setFont(new Font("Tahoma", Font.PLAIN, 11));
			    	btnRegresar.setEnabled(true);
			    	btnRegresar.setBounds(1115, 699, 89, 23);
			    	contentPane.add(btnRegresar);
			    }
			    {
			    	lblNewLabel_5 = new JLabel("i");
			    	lblNewLabel_5.addMouseListener(this);
			    	lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
			    	lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 16));
			    	lblNewLabel_5.setBounds(0, 0, 23, 20);
			    	contentPane.add(lblNewLabel_5);
			    }
			} catch (java.text.ParseException e) {
			    e.printStackTrace();
			}
		}

		cargarProductos();
		cargarCategorias();
		estadoInicial();
		listarTodoEnTabla();
		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBuscar) {
			do_btnBuscar_actionPerformed(e);
		}
		if (e.getSource() == btnLisTodo) {
			do_btnLisTodo_actionPerformed(e);
		}
		if (e.getSource() == btnRegresar) {
			do_btnRegresar_actionPerformed(e);
		}
		if (e.getSource() == btnTerminarVenta) {
			do_btnTerminarVenta_actionPerformed(e);
		}
		if (e.getSource() == btnCancelar) {
			do_btnCancelar_actionPerformed(e);
		}
		if (e.getSource() == btnEliminarElemento) {
			do_btnEliminarElemento_actionPerformed(e);
		}
		if (e.getSource() == btnAgreVen) {
			do_btnAgreVen_actionPerformed(e);
		}
		if (e.getSource() == btnLimpiar) {
			do_btnLimpiar_actionPerformed(e);
		}
		if (e.getSource() == btnNueVen) {
			do_btnNueVen_actionPerformed(e);
		}
	}
	
	//variables globales
	private ArrayProducto arrProducto = new ArrayProducto();
	private ArrayList<Producto> listaProductos = new ArrayList<>();
	private ArrayCategoria arrCategoria = new ArrayCategoria();
	private ArrayList<Categoria> listaCategorias = new ArrayList<>();
	private ArrayLote arrLote = new ArrayLote();
	private ArrayList<Lote> listaLotesProducto = new ArrayList<>();
	
	private clase.Producto productoSeleccionadoTemporal = null;
	private clase.Venta ventaActual;
	private ArrayVenta arrVenta = new ArrayVenta();
	
	private boolean estadoVendiendo = false;
	private boolean actualizandoCategoria = false;
	// NUEVA VARIABLE PARA EVITAR EVENTOS NO DESEADOS
	private boolean limpiandoCampos = false;
	private JLabel lblNewLabel_5;
	
	private void calcularSubtotal() {

	    if (productoSeleccionadoTemporal == null) return;

	    try {
	        String texto = txtCantDV.getText();

	        if (texto.isEmpty()) {
	            txtSubTotDV.setText("0.00");
	            return;
	        }

	        int cant = Integer.parseInt(texto);
	        double precio = productoSeleccionadoTemporal.getPrecio();

	        double subtotal = cant * precio;

	        txtPreFecDV.setText(String.format("%.2f", precio));
	        txtSubTotDV.setText(String.format("%.2f", subtotal));

	    } catch (Exception e) {
	        txtSubTotDV.setText("0.00");
	    }
	}
	
	private void actualizarTotalVenta() {

		double total = 0;

		for (DetalleVenta d : ventaActual.getDetVen()) {

			total += d.getSubTotal();
		}

		txtCosTotVen.setText(
				String.format("%.2f", total)
		);
	}
	
	private int cantidadYaAgregadaDelLote(int idLote) {

		int total = 0;

		if (ventaActual == null || ventaActual.getDetVen() == null) {
			return 0;
		}

		for (DetalleVenta d : ventaActual.getDetVen()) {

			if (d.getLote() != null && d.getLote().getId() == idLote) {
				total += d.getCant();
			}
		}

		return total;
	}
	
	private boolean productoYaAgregadoEnVenta(int idProducto) {

		if (ventaActual == null || ventaActual.getDetVen() == null) {
			return false;
		}

		for (DetalleVenta d : ventaActual.getDetVen()) {

			if (d.getPro() != null && d.getPro().getId() == idProducto) {
				return true;
			}
		}

		return false;
	}
	
	private void mostrarPrimerLote() {

	    if (listaLotesProducto.isEmpty()) {

	        txtCodLote.setText("");
	        txtNroLote.setText("");
	        txtFechaVenciLote.setText("");
	        txtStockActLote.setText("");

	        return;
	    }

	    Lote lote = listaLotesProducto.get(0);

	    txtCodLote.setText(String.valueOf(lote.getId()));
	    txtNroLote.setText(lote.getNumeroLote());
	    txtFechaVenciLote.setText(lote.getFechaVencimiento().toString().replace("-", "/"));
	    txtStockActLote.setText(String.valueOf(lote.getStockActual()));
	}
	
	public void configurarAnchoColumnas() {
		tblVen.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	    tblVen.getColumnModel().getColumn(0).setPreferredWidth(80);  
	    tblVen.getColumnModel().getColumn(1).setPreferredWidth(90);  
	    tblVen.getColumnModel().getColumn(2).setPreferredWidth(85);  
	    tblVen.getColumnModel().getColumn(3).setPreferredWidth(200); 
	    tblVen.getColumnModel().getColumn(7).setPreferredWidth(200); 
	    tblVen.getColumnModel().getColumn(8).setPreferredWidth(120); 
	    tblVen.getColumnModel().getColumn(10).setPreferredWidth(100); 
	    tblVen.getColumnModel().getColumn(11).setPreferredWidth(180);  
	}
	
	private void cargarProductos() {

	    cboNomP.removeAllItems();

	    listaProductos = arrProducto.ListarProductoActivo();

	    for (Producto p : listaProductos) {
	        cboNomP.addItem(p.getNombre());
	    }
	}
	
	private void cargarCategorias() {

	    cboCatP.removeAllItems();

	    // opción para mostrar todos
	    cboCatP.addItem("Todas");

	    listaCategorias = arrCategoria.ListarCategoria();

	    for (Categoria c : listaCategorias) {
	        cboCatP.addItem(c.getNombre());
	    }
	}
	
	private void cboCategoriaItemStateChanged(ItemEvent e) {

		if (e.getStateChange() != ItemEvent.SELECTED)
		    return;

		if (actualizandoCategoria || limpiandoCampos)
		    return;

	    String categoria =
	            cboCatP.getSelectedItem().toString();

	    cboNomP.removeAllItems();

	    for (Producto p : listaProductos) {

	        if (categoria.equals("Todas")
	            || p.getCategoria().getNombre().equals(categoria)) {

	            cboNomP.addItem(p.getNombre());
	        }
	    }
	}
	
	private void cboProductoItemStateChanged(ItemEvent e) {
		if (e.getStateChange() != ItemEvent.SELECTED)
		    return;

		if (limpiandoCampos)
		    return;
		

		    String nombre = cboNomP.getSelectedItem().toString();

		    for (Producto p : listaProductos) {

		        if (p.getNombre().equals(nombre)) {

		            actualizandoCategoria = true;

		            cboCatP.setSelectedItem(
		                    p.getCategoria().getNombre());

		            actualizandoCategoria = false;

		            // Guardamos el producto seleccionado
		            productoSeleccionadoTemporal = p;

		            // Llenamos los campos
		            txtCodP.setText(String.valueOf(p.getId()));
		            txtPreP.setText(String.format("%.2f", p.getPrecio()));
		            txtPresP.setText(p.getPresentacion());
		            
		            txtPreFecDV.setText(String.format("%.2f", p.getPrecio()));
		            calcularSubtotal();

		         // Obtener los lotes disponibles del producto
		            listaLotesProducto = arrLote.listarLotesProducto(p.getId());

		            // Mostrar el primer lote
		            mostrarPrimerLote();
		            
		            break;
		        }
		    }
	}
	
	public void estadoInicial() {
		this.estadoVendiendo = false;
		
		lblNewLabel_1.setVisible(false);
	    
	    txtCodVen.setEditable(false);
	    txtFechaVen.setEditable(false);
	    txtUsuario.setEditable(false);
	    txtCosTotVen.setEditable(false);
	    
	    txtCodDV.setEditable(false);
	    txtCantDV.setEditable(false);
	    txtPreFecDV.setEditable(false);
	    txtSubTotDV.setEditable(false);
	    
	    txtCodP.setEditable(false);
	    txtPreP.setEditable(false);
	    txtPresP.setEditable(false);
	    
	    txtCodLote.setEditable(false);
	    txtNroLote.setEditable(false);
	    txtFechaVenciLote.setEditable(false);
	    txtStockActLote.setEditable(false);
	    
	    cboCatP.setEditable(false);
	    cboCatP.setEnabled(false);
	    cboNomP.setEditable(false);
	    cboNomP.setEnabled(false);
	    
	    btnAgreVen.setEnabled(false);
	    btnEliminarElemento.setEnabled(false);
	    btnTerminarVenta.setEnabled(false);
	    btnCancelar.setEnabled(false);
	    btnLimpiar.setEnabled(false);
	    
	    btnNueVen.setEnabled(true);
	    btnBuscar.setEnabled(true);
	    btnLisTodo.setEnabled(true);
	    btnRegresar.setEnabled(true);
	    
	  //campos
	    txtCodVen.setText("");
	    txtFechaVen.setText("");
	    txtCosTotVen.setText("");
	    txtUsuario.setText("");
	    
	    txtCodDV.setText("");
	    txtCantDV.setText("");
	    txtSubTotDV.setText("");
	    txtPreFecDV.setText("");
	    
	    txtCodP.setText("");
	    txtPreP.setText("");
	    cboNomP.setSelectedIndex(-1);
	    cboCatP.setSelectedIndex(-1);
	    txtPresP.setText("");
	    
	    txtCodLote.setText("");
	    txtNroLote.setText("");
	    txtFechaVenciLote.setText("");
	    txtStockActLote.setText("");
	    
	    cboBuscar.setEnabled(true);
	    txtBuscar.setEnabled(true);
	}
	
	private void estadoVendiendo() {
		estadoVendiendo = true;

		lblNewLabel_1.setVisible(true);

	    cboNomP.setEnabled(true);
	    cboCatP.setEnabled(true);

	    txtCantDV.setEditable(true);

	    btnAgreVen.setEnabled(true);
	    btnEliminarElemento.setEnabled(true);
	    btnTerminarVenta.setEnabled(true);
	    btnCancelar.setEnabled(true);
	    btnLimpiar.setEnabled(true);

	    btnNueVen.setEnabled(false);
	    btnBuscar.setEnabled(false);
	    btnLisTodo.setEnabled(false);

	    cboBuscar.setEnabled(false);
	    txtBuscar.setEnabled(false);

	    cboCatP.setSelectedItem("Todas");
	}
	
	private void cargarUsuarioLogueado() {
	    Usuario usuario = SesionUsuario.getInstancia().getUsuarioLogueado();

	    if (usuario != null) {
	        txtUsuario.setText(usuario.getNombre());
	    } else {
	        txtUsuario.setText("Administrador");
	    }
	}
	
	protected void do_btnNueVen_actionPerformed(ActionEvent e) {
		cargarProductos();
		cargarCategorias();
		
		// Preparar objeto venta
	    ventaActual = new Venta();
	    ventaActual.setDetVen(new ArrayList<DetalleVenta>());

	    if (modeloTable != null) {
	    	modeloTable.setRowCount(0);
	    }

		estadoVendiendo();
		limpiarCampos();

	    txtFechaVen.setText(LocalDate.now().toString());
	    cargarUsuarioLogueado();
	    txtCosTotVen.setText("0.00");

	    LocalDate fechaActual = LocalDate.now();
	    DateTimeFormatter formato =
	            DateTimeFormatter.ofPattern("yyyy-MM-dd");

	    txtFechaVen.setText(fechaActual.format(formato));

	    cboNomP.requestFocus();
	}
	
	private void limpiarCampos() {   
		  limpiandoCampos = true;

		    txtCodDV.setText("");
		    txtCantDV.setText("");
		    txtPreFecDV.setText("");
		    txtSubTotDV.setText("");
		    txtCodP.setText("");
		    txtPreP.setText("");
		    txtPresP.setText("");
		    txtCodLote.setText("");
		    txtNroLote.setText("");
		    txtStockActLote.setText("");
		    txtFechaVenciLote.setText("");

		    productoSeleccionadoTemporal = null;
		    listaLotesProducto.clear();

		    cboNomP.setSelectedIndex(-1);
		    cboCatP.setSelectedIndex(-1);

		    limpiandoCampos = false;
	}
	
	protected void do_btnLimpiar_actionPerformed(ActionEvent e) {
		limpiarCampos();
	}
	
	protected void do_btnAgreVen_actionPerformed(ActionEvent e) {
		if (ventaActual == null) {
			JOptionPane.showMessageDialog(this, "Primero inicie una nueva venta");
			return;
		}
		
		if (productoSeleccionadoTemporal == null) {
			JOptionPane.showMessageDialog(this, "Seleccione un producto");
			return;
		}
		
		if (productoYaAgregadoEnVenta(productoSeleccionadoTemporal.getId())) {
			JOptionPane.showMessageDialog(
					this,
					"Este producto ya fue agregado a la venta.\n" +
					"Si desea cambiar la cantidad, elimine el detalle y agréguelo nuevamente."
			);
			return;
		}
		
		if (listaLotesProducto.isEmpty()) {
			JOptionPane.showMessageDialog(this, "El producto no tiene lotes disponibles");
			return;
		}
		
		if (txtCantDV.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Ingrese una cantidad");
			return;
		}
		
		int cantidadSolicitada = Integer.parseInt(txtCantDV.getText().trim());
		
		if (cantidadSolicitada <= 0) {
			JOptionPane.showMessageDialog(this, "Cantidad inválida");
			return;
		}
		
		
		// 1. Verificar stock total disponible entre todos los lotes
		int stockTotalDisponible = 0;
		
		for (Lote lote : listaLotesProducto) {
			
			int yaAgregado = cantidadYaAgregadaDelLote(lote.getId());
			int disponibleReal = lote.getStockActual() - yaAgregado;
			
			if (disponibleReal > 0) {
				stockTotalDisponible += disponibleReal;
			}
		}
		
		if (cantidadSolicitada > stockTotalDisponible) {
			JOptionPane.showMessageDialog(
					this,
					"Stock insuficiente.\nStock disponible: " + stockTotalDisponible
			);
			return;
		}
		
		
		// 2. Repartir la cantidad entre lotes FEFO
		int cantidadPendiente = cantidadSolicitada;
		
		for (Lote lote : listaLotesProducto) {
			
			if (cantidadPendiente == 0) {
				break;
			}
			
			int yaAgregado = cantidadYaAgregadaDelLote(lote.getId());
			int disponibleReal = lote.getStockActual() - yaAgregado;
			
			if (disponibleReal <= 0) {
				continue;
			}
			
			int cantidadUsada;
			
			if (cantidadPendiente <= disponibleReal) {
				cantidadUsada = cantidadPendiente;
			} else {
				cantidadUsada = disponibleReal;
			}
			
			
			DetalleVenta detalle = new DetalleVenta();
			detalle.setCant(cantidadUsada);
			detalle.setPrecioUni(productoSeleccionadoTemporal.getPrecio());
			detalle.setVenta(ventaActual);
			detalle.setPro(productoSeleccionadoTemporal);
			detalle.setLote(lote);
			
			ventaActual.getDetVen().add(detalle);
			
			
			modeloTable.addRow(new Object[] {
					"",
					txtFechaVen.getText(),
					productoSeleccionadoTemporal.getId(),
					productoSeleccionadoTemporal.getNombre(),
					cantidadUsada,
					detalle.getPrecioUni(),
					detalle.getSubTotal(),
					lote.getNumeroLote(),
					lote.getFechaVencimiento().toString(),
					"",
					detalle.getPrecioUni(),
					txtUsuario.getText()
			});
			
			
			cantidadPendiente -= cantidadUsada;
		}
		
		
		actualizarTotalVenta();
		limpiarCampos();
	}
	
	protected void do_btnEliminarElemento_actionPerformed(ActionEvent e) {
		int filaSeleccionada = tblVen.getSelectedRow();
		
		if (filaSeleccionada == -1) {
			JOptionPane.showMessageDialog(this, "Seleccione un producto de la tabla");
			return;
		}
		
		if (ventaActual == null || ventaActual.getDetVen() == null || ventaActual.getDetVen().isEmpty()) {
			JOptionPane.showMessageDialog(this, "No hay detalles para eliminar");
			return;
		}
		
		int filaModelo = tblVen.convertRowIndexToModel(filaSeleccionada);
		
		int idProducto = Integer.parseInt(
				modeloTable.getValueAt(filaModelo, 2).toString()
		);
		
		String nombreProducto = modeloTable.getValueAt(filaModelo, 3).toString();
		
		int respuesta = JOptionPane.showConfirmDialog(
				this,
				"¿Eliminar el producto '" + nombreProducto + "' de la venta?",
				"Confirmar eliminación",
				JOptionPane.YES_NO_OPTION
		);
		
		if (respuesta != JOptionPane.YES_OPTION) {
			return;
		}
		
		
		// 1. Eliminar del ArrayList de la venta
		for (int i = ventaActual.getDetVen().size() - 1; i >= 0; i--) {
			
			DetalleVenta d = ventaActual.getDetVen().get(i);
			
			if (d.getPro() != null && d.getPro().getId() == idProducto) {
				ventaActual.getDetVen().remove(i);
			}
		}
		
		
		// 2. Eliminar todas las filas de ese producto en la tabla
		for (int i = modeloTable.getRowCount() - 1; i >= 0; i--) {
			
			int idProductoTabla = Integer.parseInt(
					modeloTable.getValueAt(i, 2).toString()
			);
			
			if (idProductoTabla == idProducto) {
				modeloTable.removeRow(i);
			}
		}
		
		// 3. Actualizar total
		actualizarTotalVenta();
		
		// 4. Limpiar selección/campos
		limpiarCampos();
	}
	
	protected void do_btnCancelar_actionPerformed(ActionEvent e) {
		if (ventaActual == null) {
			estadoInicial();
			return;
		}
		
		int respuesta = JOptionPane.showConfirmDialog(
				this,
				"¿Está seguro de cancelar la venta actual?\n" +
				"Se perderán todos los productos agregados.",
				"Confirmar cancelación",
				JOptionPane.YES_NO_OPTION
		);
		
		if (respuesta != JOptionPane.YES_OPTION) {
			return;
		}
		
		ventaActual = null;
		
		if (modeloTable != null) {
			modeloTable.setRowCount(0);
		}
		
		limpiarCampos();
		estadoInicial();
		
		listarTodoEnTabla();
	}
	
	protected void do_btnTerminarVenta_actionPerformed(ActionEvent e) {

		if (ventaActual == null) {
			JOptionPane.showMessageDialog(this, "No hay una venta iniciada");
			return;
		}

		if (ventaActual.getDetVen() == null || ventaActual.getDetVen().isEmpty()) {
			JOptionPane.showMessageDialog(this, "No hay productos agregados a la venta");
			return;
		}

		int respuesta = JOptionPane.showConfirmDialog(
				this,
				"¿Desea terminar y guardar esta venta?",
				"Confirmar venta",
				JOptionPane.YES_NO_OPTION
		);

		if (respuesta != JOptionPane.YES_OPTION) {
			return;
		}

		Usuario usuario = SesionUsuario.getInstancia().getUsuarioLogueado();

		if (usuario == null) {
			JOptionPane.showMessageDialog(this, "No se encontró el usuario logueado");
			return;
		}

		ventaActual.setUsuario(usuario);
		ventaActual.setFecha(LocalDate.parse(txtFechaVen.getText()));

		int idVenta = arrVenta.registrarVentaCompleta(ventaActual);

		if (idVenta != -1) {

			JOptionPane.showMessageDialog(
					this,
					"Venta registrada correctamente.\nID Venta: " + idVenta
			);

			ventaActual = null;

			if (modeloTable != null) {
				modeloTable.setRowCount(0);
			}

			limpiarCampos();
			estadoInicial();
			listarTodoEnTabla();

		} else {
			JOptionPane.showMessageDialog(
					this,
					"No se pudo registrar la venta.\nRevise la consola para más detalles."
			);
		}
	}
	
	protected void do_btnRegresar_actionPerformed(ActionEvent e) {
		Menu ventanaMenu = new Menu();
	    ventanaMenu.setVisible(true);
	    this.dispose();
	}
	
	public void listarTodoEnTabla() {

		modeloTable.setRowCount(0);

		ArrayList<DetalleVenta> lista = arrVenta.listarDetallesVenta();

		for (DetalleVenta d : lista) {

			Object[] fila = {
					d.getVenta().getCod(),
					d.getVenta().getFecha(),
					d.getPro().getId(),
					d.getPro().getNombre(),
					d.getCant(),
					d.getPrecioUni(),
					d.getSubTotal(),
					d.getLote().getNumeroLote(),
					d.getLote().getFechaVencimiento(),
					d.getCod(),
					d.getPrecioUni(),
					d.getVenta().getUsuario().getNombre()
			};

			modeloTable.addRow(fila);
		}
	}
	
	protected void do_btnLisTodo_actionPerformed(ActionEvent e) {
		btnLisTodo.setEnabled(false);

		listarTodoEnTabla();

		btnLisTodo.setEnabled(true);
	}
	
	public void listarPorFecha(LocalDate fecha) {

		modeloTable.setRowCount(0);

		ArrayList<DetalleVenta> lista = arrVenta.listarDetallesVentaPorFecha(fecha);

		for (DetalleVenta d : lista) {

			Object[] fila = {
					d.getVenta().getCod(),
					d.getVenta().getFecha(),
					d.getPro().getId(),
					d.getPro().getNombre(),
					d.getCant(),
					d.getPrecioUni(),
					d.getSubTotal(),
					d.getLote().getNumeroLote(),
					d.getLote().getFechaVencimiento(),
					d.getCod(),
					d.getPrecioUni(),
					d.getVenta().getUsuario().getNombre()
			};

			modeloTable.addRow(fila);
		}
	}
	
	protected void do_btnBuscar_actionPerformed(ActionEvent e) {
		if (cboBuscar.getSelectedItem().equals("Seleccione...")) {
			JOptionPane.showMessageDialog(
					this,
					"Por favor seleccione una opción de filtrado."
			);
			return;
		}

		if (cboBuscar.getSelectedItem().equals("Fecha")) {

			try {
				String texto = txtBuscar.getText().trim();

				if (texto.isEmpty()) {
					JOptionPane.showMessageDialog(this, "Ingrese una fecha.");
					return;
				}

				LocalDate fecha = LocalDate.parse(texto);

				listarPorFecha(fecha);

			} catch (Exception ex) {
				JOptionPane.showMessageDialog(
						this,
						"Formato incorrecto.\nUse: AAAA-MM-DD"
				);
			}
		}
	}
	
	private boolean comboContiene(JComboBox combo, String texto) {

		for (int i = 0; i < combo.getItemCount(); i++) {

			Object item = combo.getItemAt(i);

			if (item != null && item.toString().equals(texto)) {
				return true;
			}
		}

		return false;
	}
	
	private void pasarDatosDeTablaACampos(int fila) {

		try {

			if (estadoVendiendo) {
				return;
			}

			int filaModelo = tblVen.convertRowIndexToModel(fila);

			Object valorIdDetalle = modeloTable.getValueAt(filaModelo, 9);

			if (valorIdDetalle == null || valorIdDetalle.toString().trim().isEmpty()) {
				return;
			}

			int idDetalle = Integer.parseInt(valorIdDetalle.toString());

			DetalleVenta det = arrVenta.obtenerDetalleVenta(idDetalle);

			if (det == null) {
				return;
			}

			int idVenta = det.getVenta().getCod();
			double totalVenta = arrVenta.obtenerTotalVenta(idVenta);

			limpiandoCampos = true;

			// VENTA
			txtCodVen.setText(String.valueOf(idVenta));
			txtFechaVen.setText(det.getVenta().getFecha().toString());
			txtUsuario.setText(det.getVenta().getUsuario().getNombre());
			txtCosTotVen.setText(String.format("%.2f", totalVenta));

			// DETALLE
			txtCodDV.setText(String.valueOf(det.getCod()));
			txtCantDV.setText(String.valueOf(det.getCant()));
			txtPreFecDV.setText(String.format("%.2f", det.getPrecioUni()));
			txtSubTotDV.setText(String.format("%.2f", det.getSubTotal()));

			// PRODUCTO
			txtCodP.setText(String.valueOf(det.getPro().getId()));
			txtPreP.setText(String.format("%.2f", det.getPro().getPrecio()));
			txtPresP.setText(det.getPro().getPresentacion());

			String nombreProducto = det.getPro().getNombre();

			if (!comboContiene(cboNomP, nombreProducto)) {
				cboNomP.addItem(nombreProducto);
			}

			cboNomP.setSelectedItem(nombreProducto);

			String nombreCategoria = det.getPro().getCategoria().getNombre();

			if (!comboContiene(cboCatP, nombreCategoria)) {
				cboCatP.addItem(nombreCategoria);
			}

			cboCatP.setSelectedItem(nombreCategoria);

			// LOTE
			txtCodLote.setText(String.valueOf(det.getLote().getId()));
			txtNroLote.setText(det.getLote().getNumeroLote());
			txtFechaVenciLote.setText(
					det.getLote()
					   .getFechaVencimiento()
					   .toString()
					   .replace("-", "/")
			);
			txtStockActLote.setText(String.valueOf(det.getLote().getStockActual()));

			limpiandoCampos = false;

		} catch (Exception ex) {
			limpiandoCampos = false;
			ex.printStackTrace();
		}
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == lblNewLabel_5) {
			do_lblNewLabel_5_mouseClicked(e);
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
	
	protected void do_lblNewLabel_5_mouseClicked(MouseEvent e) {
		JOptionPane.showMessageDialog(
			    this,
			    "Esta seccion permite al usuario poder armar y registrar una venta dirigida al cliente"
			    + "\nde producto/s, esta mostrara automaticamente los datos ya registrados en el sistema"
			    + "\nexcepto por datos manuales como cantidad, nombre de producto y/o categoria.."
			    + "\npreviamente a esto, el producto debera estar registrado asi como los lotes."
			    + "\n"
			    + "\nEsta ventana tiene 2 usos: "
			    + "\n" 
			    + "\n-Mientras no se este efectuando una venta (boton nueva venta) el usuario puede "
			    + "\nrevisar las ventas en la tabla y clickeandolos puede pasar sus datos a los"
			    + "\ncampos, agregando algunos detalles extra de esa venta."
			    + "\n"
			    + "\n-Tambien se pueden buscar las ventas realizadas por fecha desde el boton 'Buscar'"
			    + "\nseleccionando previamente en el desplegable el campo a filtrar y en el cuadro de"
			    + "\ntexto el valor especifico del campo a filtrar."
			    + "\n\n"
			    + "\n-Por otro lado al presionar el boton 'Nueva Venta' el programa limpiara la tabla"
			    + "\ny la utilizara para mostrar los datos de la nueva venta que se realizara, rellenando"
			    + "\nautomaticamente varios campos que no necesitan ser ingresados por el usuario, como el"
			    + "\nnombre de usuario, la fecha, entre otros."
			    + "\n"
			    + "\n-En este estado tambien se habilitara el ingreso de los campos necesarios para agregar"
			    + "\nun elemento a la compra, asi como los productos registrados se rellenaran en el"
			    + "\ndesplegable 'Nombre de Productos', tras esto puede agregar este elemento a la venta"
			    + "\npresionando sobre el boton 'Agregar a la Venta'"
			    + "\n"
			    + "\nAl seleccionar un producto se mostrara su lote con la fecha de vencimiento mas proxima,"
			    + "\nsin embargo es posible vender mas productos si este cuenta con mas lotes disponibles,"
			    + "\nal agregarlo confirmando esta adquisicion aparecera en la tabla por separado el"
			    + "\nproducto con su cantidad adquirida de cada lote diferente y este proceso es automatico"
			    + "\nmientras la cantidad total de stock lo permita."
			    + "\n"
			    + "\n-Solo se puede adquirir una vez una cantidad de prodcutos por operacion, en caso de"
			    + "\nquerer agregar mas unidades del producto, tiene que eliminar lo agregado"
			    + "\ny volver a agregarlo con la cantidad correcta (revisar seccion debajo para eliminar)."
			    + "\n"
			    + "\n-En caso de querer eliminar un elemento de la venta primero seleccione el elemento"
			    + "\nclickeando sobre este en la tabla, posteriormente presione el boton 'Eliminar Elemento'"
			    + "\ny confirme la accion para poder retirarlo de la lista."
			    + "\n"
			    + "\n-Para confirmar y efectuar la venta completa presione el boton 'Terminar Venta', tras"
			    + "\nesto la venta sera registrada en la base de datos asi como los lotes usados seran "
			    + "\ndescontados, los cuales podran ser de la misma forma consultados en "
			    + "\nla ventana 'Inventario' disponibe desde el 'Menu'."
			    + "\n"
			    + "\n-En cualquier momento de la venta puede cancelar la operacion por cualquier motivo"
			    + "\npresionando el boton 'Cancelar Venta', tras esto retornara a la vista general.",
			    "Informacion.",
			    JOptionPane.INFORMATION_MESSAGE
			);
	}
}
