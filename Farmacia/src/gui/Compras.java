package gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import arrayList.ArrayCompra;
import arrayList.ArrayDetalleCompra;
import clase.DetalleCompra;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class Compras extends JFrame implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField txtCodCom;
	private JLabel lblNewLabel_2;
	private JTextField txtFechaCom;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JTextField txtUsuarioCom;
	private JTextField txtCosTotCom;
	private JLabel lblNewLabel_5;
	private JTextField txtCodDC;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JTextField txtCantDC;
	private JLabel lblNewLabel_8;
	private JTextField txtPreUniDC;
	private JLabel lblNewLabel_9;
	private JTextField txtSubTotDC;
	private JLabel lblProducto;
	private JLabel lblNewLabel_10;
	private JTextField txtCodP;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_12;
	private JTextField txtCatP;
	private JComboBox cboNomP;
	private JLabel lblNewLabel_13;
	private JTextArea txtPresP;
	private JLabel lblLote;
	private JLabel lblNewLabel_14;
	private JTextField txtCodLote;
	private javax.swing.JFormattedTextField txtFechaVenciLote;
	private JLabel lblNewLabel_15;
	private JTextField txtStockActLote;
	private JLabel lblNewLabel_16;
	private JLabel lblNewLabel_17;
	private JTextField txtEstCom;
	private JLabel lblNewLabel_18;
	private JTextField txtNroLote;
	private JButton btnRegresar;
	private JButton btnNueCom;
	private JButton btnAgreCom;
	private JButton btnCancelar;
	private JButton btnEliminarElemento;
	private JButton btnTerminarCompra;
	private JButton btnLimpiar;
	private JLabel lblComprando;
	private JButton btnLisTodo;
	private JScrollPane scrollPane;
	private JTable tblCom;
	private JButton btnBuscar;
	private JComboBox cboBuscar;
	private JTextField txtBuscar;
	
	private DefaultTableModel modeloTable;
	private arrayList.ArrayCategoria objCategoria = new arrayList.ArrayCategoria();
	private arrayList.ArrayProducto objProducto = new arrayList.ArrayProducto();
	private JLabel lblNewLabel_19;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Compras frame = new Compras();
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
	public Compras() {
		setTitle("Sección Compras");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1230, 772);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel = new JLabel("Compra:");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel.setBounds(10, 23, 57, 14);
			contentPane.add(lblNewLabel);
		}
		{
			lblNewLabel_1 = new JLabel("Codigo:");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_1.setBounds(10, 51, 46, 14);
			contentPane.add(lblNewLabel_1);
		}
		{
			txtCodCom = new JTextField();
			txtCodCom.setFont(new Font("Tahoma", Font.PLAIN, 11));
			txtCodCom.setBounds(66, 48, 86, 20);
			contentPane.add(txtCodCom);
			txtCodCom.setColumns(10);
		}
		{
			lblNewLabel_2 = new JLabel("Fecha:");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_2.setBounds(10, 82, 46, 14);
			contentPane.add(lblNewLabel_2);
		}
		{
			txtFechaCom = new JTextField();
			txtFechaCom.setHorizontalAlignment(SwingConstants.CENTER);
			txtFechaCom.setFont(new Font("Tahoma", Font.PLAIN, 11));
			txtFechaCom.setBounds(66, 79, 86, 20);
			contentPane.add(txtFechaCom);
			txtFechaCom.setColumns(10);
		}
		{
			lblNewLabel_3 = new JLabel("Usuario:");
			lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_3.setBounds(10, 110, 46, 14);
			contentPane.add(lblNewLabel_3);
		}
		{
			lblNewLabel_4 = new JLabel("Costo Total:");
			lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_4.setBounds(187, 85, 72, 14);
			contentPane.add(lblNewLabel_4);
		}
		{
			txtUsuarioCom = new JTextField();
			txtUsuarioCom.setFont(new Font("Tahoma", Font.PLAIN, 11));
			txtUsuarioCom.setBounds(66, 107, 282, 20);
			contentPane.add(txtUsuarioCom);
			txtUsuarioCom.setColumns(10);
		}
		{
			txtCosTotCom = new JTextField();
			txtCosTotCom.setHorizontalAlignment(SwingConstants.RIGHT);
			txtCosTotCom.setFont(new Font("Tahoma", Font.PLAIN, 11));
			txtCosTotCom.setBounds(262, 79, 86, 20);
			contentPane.add(txtCosTotCom);
			txtCosTotCom.setColumns(10);
		}
		{
			lblNewLabel_5 = new JLabel("Detalle de Compra:");
			lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel_5.setBounds(10, 146, 110, 14);
			contentPane.add(lblNewLabel_5);
		}
		{
			txtCodDC = new JTextField();
			txtCodDC.setHorizontalAlignment(SwingConstants.RIGHT);
			txtCodDC.setFont(new Font("Tahoma", Font.PLAIN, 11));
			txtCodDC.setBounds(99, 171, 86, 20);
			contentPane.add(txtCodDC);
			txtCodDC.setColumns(10);
		}
		{
			lblNewLabel_6 = new JLabel("Codigo:");
			lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_6.setBounds(10, 174, 46, 14);
			contentPane.add(lblNewLabel_6);
		}
		{
			lblNewLabel_7 = new JLabel("Cantidad:");
			lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_7.setBounds(195, 174, 57, 14);
			contentPane.add(lblNewLabel_7);
		}
		{
			txtCantDC = new JTextField();
			txtCantDC.setHorizontalAlignment(SwingConstants.RIGHT);
			txtCantDC.setFont(new Font("Tahoma", Font.PLAIN, 11));
			txtCantDC.setColumns(10);
			txtCantDC.setBounds(262, 171, 86, 20);
			contentPane.add(txtCantDC);
		}
		{
			lblNewLabel_8 = new JLabel("Precio/Unidad:");
			lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_8.setBounds(10, 205, 79, 14);
			contentPane.add(lblNewLabel_8);
		}
		{
			txtPreUniDC = new JTextField();
			txtPreUniDC.setHorizontalAlignment(SwingConstants.RIGHT);
			txtPreUniDC.setFont(new Font("Tahoma", Font.PLAIN, 11));
			txtPreUniDC.setBounds(99, 202, 86, 20);
			contentPane.add(txtPreUniDC);
			txtPreUniDC.setColumns(10);
		}
		{
			lblNewLabel_9 = new JLabel("SubTotal:");
			lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_9.setBounds(195, 205, 57, 14);
			contentPane.add(lblNewLabel_9);
		}
		{
			txtSubTotDC = new JTextField();
			txtSubTotDC.setHorizontalAlignment(SwingConstants.RIGHT);
			txtSubTotDC.setFont(new Font("Tahoma", Font.PLAIN, 11));
			txtSubTotDC.setColumns(10);
			txtSubTotDC.setBounds(262, 202, 86, 20);
			contentPane.add(txtSubTotDC);
		}
		{
			lblProducto = new JLabel("Producto:");
			lblProducto.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblProducto.setBounds(10, 238, 79, 14);
			contentPane.add(lblProducto);
		}
		{
			lblNewLabel_10 = new JLabel("Codigo:");
			lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_10.setBounds(10, 265, 46, 14);
			contentPane.add(lblNewLabel_10);
		}
		{
			txtCodP = new JTextField();
			txtCodP.setHorizontalAlignment(SwingConstants.RIGHT);
			txtCodP.setFont(new Font("Tahoma", Font.PLAIN, 11));
			txtCodP.setColumns(10);
			txtCodP.setBounds(77, 262, 108, 20);
			contentPane.add(txtCodP);
		}
		{
			lblNewLabel_11 = new JLabel("Nombre:");
			lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_11.setBounds(10, 296, 46, 14);
			contentPane.add(lblNewLabel_11);
		}
		{
			lblNewLabel_12 = new JLabel("Categoria:");
			lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_12.setBounds(10, 327, 57, 14);
			contentPane.add(lblNewLabel_12);
		}
		{
			txtCatP = new JTextField();
		    txtCatP.setFont(new Font("Tahoma", Font.PLAIN, 11));
		    txtCatP.setBounds(77, 323, 271, 22);
		    contentPane.add(txtCatP);
		    txtCatP.setColumns(10);
		}
		{
			cboNomP = new JComboBox();
			cboNomP.setFont(new Font("Tahoma", Font.PLAIN, 11));
			cboNomP.setEditable(true);
			cboNomP.setBounds(77, 292, 271, 22);
			contentPane.add(cboNomP);
			
			// ◄--- ÚNICO EVENTO DE ACCIÓN: Ejecuta el autocompletado y el lote cronológico
			cboNomP.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					sincronizarCamposDelProducto(); 
				}
			});
			
			// ◄--- ÚNICO KEY LISTENER: Captura la escritura inteligente sin duplicados
			javax.swing.text.JTextComponent editor = (javax.swing.text.JTextComponent) cboNomP.getEditor().getEditorComponent();
			editor.addKeyListener(new java.awt.event.KeyAdapter() {
				@Override
				public void keyReleased(java.awt.event.KeyEvent e) {
					if (e.getKeyCode() == java.awt.event.KeyEvent.VK_UP || 
						e.getKeyCode() == java.awt.event.KeyEvent.VK_DOWN || 
						e.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
						return;
					}
					String textoEscrito = editor.getText();
					filtrarProductosEnCombo(textoEscrito); 
				}
			});
		}
		{
			lblNewLabel_13 = new JLabel("Presentacion:");
			lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_13.setBounds(10, 358, 72, 14);
			contentPane.add(lblNewLabel_13);
		}
		{
			txtPresP = new JTextArea();
			txtPresP.setToolTipText("");
			txtPresP.setWrapStyleWord(true);
			txtPresP.setLineWrap(true);
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
			lblNewLabel_14 = new JLabel("Codigo:");
			lblNewLabel_14.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_14.setBounds(10, 511, 46, 14);
			contentPane.add(lblNewLabel_14);
		}
		{
			txtCodLote = new JTextField();
			txtCodLote.setHorizontalAlignment(SwingConstants.RIGHT);
			txtCodLote.setFont(new Font("Tahoma", Font.PLAIN, 11));
			txtCodLote.setColumns(10);
			txtCodLote.setBounds(130, 508, 122, 20);
			contentPane.add(txtCodLote);
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
			} catch (java.text.ParseException e) {
			    e.printStackTrace();
			}
		}
		{
			lblNewLabel_15 = new JLabel("Fecha de Vencimiento:");
			lblNewLabel_15.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_15.setBounds(10, 567, 110, 14);
			contentPane.add(lblNewLabel_15);
		}
		{
			txtStockActLote = new JTextField();
			txtStockActLote.setHorizontalAlignment(SwingConstants.RIGHT);
			txtStockActLote.setFont(new Font("Tahoma", Font.PLAIN, 11));
			txtStockActLote.setColumns(10);
			txtStockActLote.setBounds(130, 595, 122, 20);
			contentPane.add(txtStockActLote);
		}
		{
			lblNewLabel_16 = new JLabel("Stock Actual:");
			lblNewLabel_16.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_16.setBounds(10, 598, 110, 14);
			contentPane.add(lblNewLabel_16);
		}
		{
			lblNewLabel_17 = new JLabel("Estado:");
			lblNewLabel_17.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_17.setBounds(187, 51, 72, 14);
			contentPane.add(lblNewLabel_17);
		}
		{
			txtEstCom = new JTextField();
			txtEstCom.setHorizontalAlignment(SwingConstants.CENTER);
			txtEstCom.setFont(new Font("Tahoma", Font.PLAIN, 11));
			txtEstCom.setColumns(10);
			txtEstCom.setBounds(262, 48, 86, 20);
			contentPane.add(txtEstCom);
		}
		{
			lblNewLabel_18 = new JLabel("Numero de Lote:");
			lblNewLabel_18.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_18.setBounds(10, 539, 110, 14);
			contentPane.add(lblNewLabel_18);
		}
		{
			txtNroLote = new JTextField();
			txtNroLote.setHorizontalAlignment(SwingConstants.RIGHT);
			txtNroLote.setFont(new Font("Tahoma", Font.PLAIN, 11));
			txtNroLote.setColumns(10);
			txtNroLote.setBounds(130, 536, 218, 20);
			contentPane.add(txtNroLote);
		}
		{
			btnRegresar = new JButton("Regresar");
			btnRegresar.addActionListener(this);
			btnRegresar.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnRegresar.setBounds(1115, 699, 89, 23);
			contentPane.add(btnRegresar);
		}
		{
			btnNueCom = new JButton("Nueva Compra");
			btnNueCom.addActionListener(this);
			btnNueCom.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnNueCom.setBounds(10, 630, 110, 23);
			contentPane.add(btnNueCom);
		}
		{
			btnAgreCom = new JButton("Agregar a la Compra");
			btnAgreCom.addActionListener(this);
			btnAgreCom.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnAgreCom.setBounds(208, 630, 150, 23);
			contentPane.add(btnAgreCom);
		}
		{
			btnCancelar = new JButton("Cancelar Compra");
			btnCancelar.addActionListener(this);
			btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnCancelar.setBounds(10, 698, 121, 23);
			contentPane.add(btnCancelar);
		}
		{
			btnEliminarElemento = new JButton("Eliminar Elemento de  la Lista");
			btnEliminarElemento.addActionListener(this);
			btnEliminarElemento.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnEliminarElemento.setBounds(10, 664, 175, 23);
			contentPane.add(btnEliminarElemento);
		}
		{
			btnTerminarCompra = new JButton("Terminar Compra");
			btnTerminarCompra.addActionListener(this);
			btnTerminarCompra.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnTerminarCompra.setBounds(237, 664, 121, 23);
			contentPane.add(btnTerminarCompra);
		}
		{
			btnLimpiar = new JButton("Limpiar Campos");
			btnLimpiar.addActionListener(this);
			btnLimpiar.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnLimpiar.setBounds(227, 19, 121, 23);
			contentPane.add(btnLimpiar);
		}
		{
			lblComprando = new JLabel("*Comprando...");
			lblComprando.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblComprando.setBounds(99, 23, 110, 14);
			contentPane.add(lblComprando);
		}
		{
			btnLisTodo = new JButton("Listar Todo");
			btnLisTodo.addActionListener(this);
			btnLisTodo.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnLisTodo.setBounds(1078, 664, 126, 23);
			contentPane.add(btnLisTodo);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(370, 23, 834, 630);
			contentPane.add(scrollPane);
			{
				modeloTable = new DefaultTableModel(
					    new Object[][] {},
					    new String[] {
					        "ID Compra", "Fecha", "Usuario", "ID Producto", "Producto", "Cantidad", "Costo Uni.", "Subtotal", "N° Lote",
					        "ID Detalle"
					    }
					) {
					    private static final long serialVersionUID = 1L;
					    @Override
					    public boolean isCellEditable(int row, int column) {
					        return false;
					    }
					};

					tblCom = new JTable();
					tblCom.setModel(modeloTable);
					java.awt.Color amarilloPalido = new java.awt.Color(204, 204, 255); 
					tblCom.getTableHeader().setBackground(amarilloPalido);
					tblCom.getTableHeader().setOpaque(true); 
					tblCom.setFillsViewportHeight(true);
					scrollPane.setViewportView(tblCom);

					configurarAnchoColumnas();
					
					tblCom.addMouseListener(new java.awt.event.MouseAdapter() {
					    @Override
					    public void mouseClicked(java.awt.event.MouseEvent e) {
					        // Solo permite el clic si NO se está realizando una compra
					        if (!estadoComprando) {
					            int filaSeleccionada = tblCom.getSelectedRow();
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
			btnBuscar.setBounds(368, 664, 89, 23);
			contentPane.add(btnBuscar);
		}
		{
			cboBuscar = new JComboBox();
			cboBuscar.setBounds(467, 664, 131, 22);
			contentPane.add(cboBuscar);
			
			cboBuscar.addItem("Seleccione...");
			cboBuscar.addItem("Fecha");
		}
		{
			txtBuscar = new JTextField();
			txtBuscar.setBounds(608, 665, 131, 20);
			contentPane.add(txtBuscar);
			txtBuscar.setColumns(10);
		}
		{
			lblNewLabel_19 = new JLabel("(AAAA/MM/DD)");
			lblNewLabel_19.setBounds(262, 567, 86, 14);
			contentPane.add(lblNewLabel_19);
		}
		{
			lblNewLabel_20 = new JLabel("i");
			lblNewLabel_20.addMouseListener(this);
			lblNewLabel_20.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_20.setFont(new Font("Times New Roman", Font.BOLD, 16));
			lblNewLabel_20.setBounds(0, 0, 23, 20);
			contentPane.add(lblNewLabel_20);
		}
		
		//funciones al inicializar
		configurarEventosCalculo();
		estadoInicial();
		
		listarTodoEnTabla();
	}
	
	//variable global
	private clase.Producto productoSeleccionadoTemporal = null;
	private clase.Compra compraActual;
	private boolean estadoComprando = false;
	private JLabel lblNewLabel_20;
	
	private void configurarAnchoColumnas() {
	    tblCom.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	    tblCom.getColumnModel().getColumn(0).setPreferredWidth(80);  
	    tblCom.getColumnModel().getColumn(1).setPreferredWidth(90);  
	    tblCom.getColumnModel().getColumn(2).setPreferredWidth(180); 
	    tblCom.getColumnModel().getColumn(3).setPreferredWidth(85);  
	    tblCom.getColumnModel().getColumn(4).setPreferredWidth(200); 
	    tblCom.getColumnModel().getColumn(5).setPreferredWidth(70);  
	    tblCom.getColumnModel().getColumn(6).setPreferredWidth(85);  
	    tblCom.getColumnModel().getColumn(7).setPreferredWidth(85);  
	    tblCom.getColumnModel().getColumn(8).setPreferredWidth(200); 
	    tblCom.getColumnModel().getColumn(9).setWidth(0);
	}
	
	private void pasarDatosDeTablaACampos(int fila) {
	    try {

	        int idDetalle =
	                Integer.parseInt(
	                        tblCom.getValueAt(fila, 9).toString());

	        ArrayDetalleCompra adc =
	                new ArrayDetalleCompra();

	        DetalleCompra det =
	                adc.obtenerDetalleCompra(idDetalle);

	        if (det == null)
	            return;

	        int idCompra =
	                det.getCompra().getCod();

	        double total =
	                adc.obtenerTotalCompra(idCompra);

	        // COMPRA
	        txtCodCom.setText(
	                String.valueOf(idCompra));

	        txtFechaCom.setText(
	                det.getCompra().getFecha().toString());

	        txtUsuarioCom.setText(
	                det.getCompra().getUsuario().getNombre());

	        txtEstCom.setText(
	                det.getCompra().isEstado()
	                        ? "ACTIVO"
	                        : "ANULADO");

	        txtCosTotCom.setText(
	                String.format("%.2f", total));

	        // DETALLE
	        txtCodDC.setText(
	                String.valueOf(det.getCod()));

	        txtCantDC.setText(
	                String.valueOf(det.getCant()));

	        txtPreUniDC.setText(
	                String.format("%.2f",
	                        det.getCostoUni()));

	        txtSubTotDC.setText(
	                String.format("%.2f",
	                        det.getSubTotal()));

	        // PRODUCTO
	        txtCodP.setText(
	                String.valueOf(
	                        det.getPro().getId()));

	        cboNomP.removeAllItems();
	        cboNomP.addItem(det.getPro().getNombre());
	        cboNomP.setSelectedItem(det.getPro().getNombre());

	        if (det.getPro().getCategoria() != null) {
	            txtCatP.setText(
	                    det.getPro()
	                       .getCategoria()
	                       .getNombre());
	        } else {
	            txtCatP.setText("");
	        }

	        txtPresP.setText(
	                det.getPro()
	                   .getPresentacion());

	        // LOTE
	        txtCodLote.setText(
	                String.valueOf(
	                        det.getLote().getId()));

	        txtNroLote.setText(
	                det.getLote()
	                   .getNumeroLote());

	        txtFechaVenciLote.setText(
	                det.getLote()
	                   .getFechaVencimiento()
	                   .toString()
	                   .replace("-", "/"));

	        txtStockActLote.setText(
	                String.valueOf(
	                        det.getLote()
	                           .getStockActual()));

	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	}
	
	// ◄--- AQUÍ: CAMPOS BLOQUEADOS POR DEFECTO AL ABRIR LA VENTANA
	private void estadoInicial() {
		this.estadoComprando = false;
		
	    lblComprando.setVisible(false);
	    
	    txtCodCom.setEditable(false);
	    txtFechaCom.setEditable(false);
	    txtUsuarioCom.setEditable(false);
	    txtCosTotCom.setEditable(false);
	    txtEstCom.setEditable(false);
	    
	    txtCodDC.setEditable(false);
	    txtCantDC.setEditable(false);
	    txtPreUniDC.setEditable(false);
	    txtSubTotDC.setEditable(false);
	    
	    txtCodP.setEditable(false);
	    txtPresP.setEditable(false);
	    
	    txtCodLote.setEditable(false);
	    txtNroLote.setEditable(false);
	    txtFechaVenciLote.setEditable(false);
	    txtStockActLote.setEditable(false);
	    
	    txtCatP.setEditable(false);
	    cboNomP.setEditable(false);
	    
	    btnAgreCom.setEnabled(false);
	    btnEliminarElemento.setEnabled(false);
	    btnTerminarCompra.setEnabled(false);
	    btnCancelar.setEnabled(false);
	    btnLimpiar.setEnabled(false);
	    
	    btnNueCom.setEnabled(true);
	    btnBuscar.setEnabled(true);
	    btnLisTodo.setEnabled(true);
	    btnRegresar.setEnabled(true);
	    
	    //campos
	    txtCodCom.setText("");
	    txtEstCom.setText("");
	    txtFechaCom.setText("");
	    txtCosTotCom.setText("");
	    txtUsuarioCom.setText("");
	    
	    txtCodDC.setText("");
	    txtCantDC.setText("");
	    txtSubTotDC.setText("");
	    txtPreUniDC.setText("");
	    
	    txtCodP.setText("");
	    cboNomP.setSelectedIndex(-1);
	    txtCatP.setText("");
	    txtPresP.setText("");
	    
	    txtCodLote.setText("");
	    txtNroLote.setText("");
	    txtFechaVenciLote.setText("");
	    txtStockActLote.setText("");
	    
	    cboBuscar.setEnabled(true);
	    txtBuscar.setEnabled(true);
	}
	
	// ◄--- AQUÍ: SE DEFINE QUÉ SE HABILITA AL PRESIONAR "NUEVA COMPRA"
	private void estadoComprando() {
		this.estadoComprando = true;
		
	    lblComprando.setVisible(true);
	    
	    // Los campos de datos del producto se quedan congelados en setEditable(false)
	    // porque se rellenan solos mediante la selección del JComboBox.
	    txtCantDC.setEditable(true);       // El usuario escribe la cantidad comprada
	    txtPreUniDC.setEditable(true);     // El usuario digita el costo por unidad
	    txtFechaVenciLote.setEditable(true); // El usuario escribe el vencimiento del lote
	    
	    cboNomP.setEnabled(true);
	    
	    btnAgreCom.setEnabled(true);
	    btnEliminarElemento.setEnabled(true);
	    btnTerminarCompra.setEnabled(true);
	    btnCancelar.setEnabled(true);
	    btnLimpiar.setEnabled(true);
	    
	    cboBuscar.setEnabled(false);
	    txtBuscar.setEnabled(false);
	    
	    btnNueCom.setEnabled(false);
	    btnBuscar.setEnabled(false);
	    btnLisTodo.setEnabled(false);
	    
	    filtrarProductosEnCombo("");
	}
	
	// FEATURE 2: AUTOCOMPLETAR CAMPOS DEL PRODUCTO Y SUGERIR LOTE CRONOLÓGICO
	private void sincronizarCamposDelProducto() {
		if (!estadoComprando) {
	        return;
	    }
	    // 1. Obtenemos el nombre seleccionado en el combo
	    Object seleccionado = cboNomP.getSelectedItem();
	    if (seleccionado == null) return;
	    
	    String nombreProd = seleccionado.toString();
	    
	    // 2. Buscamos el objeto usando tu función ya existente
	    ArrayList<clase.Producto> lista = objProducto.BuscarProductoNombre(nombreProd);
	    
	    // 3. Si encontramos el producto, guardamos el OBJETO en la variable temporal
	    if (lista != null && !lista.isEmpty()) {
	        // Asumimos que el nombre es único, tomamos el primero
	        this.productoSeleccionadoTemporal = lista.get(0); 
	        
	        // 4. Llenamos los campos visuales usando el objeto temporal
	        txtCodP.setText(String.valueOf(productoSeleccionadoTemporal.getId()));
	        txtPresP.setText(productoSeleccionadoTemporal.getPresentacion());
	        txtCatP.setText(productoSeleccionadoTemporal.getCategoria().getNombre());
	        
	        // Lógica del lote (igual a como la tenías)
	        java.time.LocalDateTime ahora = java.time.LocalDateTime.now();
	        String loteSugerido = "LOT-" + ahora.format(java.time.format.DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss")) 
	                              + "-" + productoSeleccionadoTemporal.getId();
	        txtNroLote.setText(loteSugerido);
	    }
	}
	
	private void filtrarProductosEnCombo(String texto) {
		try {
			if (!cboNomP.isShowing()) return; // Escudo anticaídas si no es visible aún
			
			javax.swing.text.JTextComponent editor = (javax.swing.text.JTextComponent) cboNomP.getEditor().getEditorComponent();
			int posicionCaret = editor.getCaretPosition();

			ArrayList<clase.Producto> resultado;

			if (texto == null || texto.trim().isEmpty()) {
				resultado = objProducto.ListarProducto(); 
			} else {
				resultado = objProducto.BuscarProductoNombre(texto); 
			}

			cboNomP.removeAllItems();

			if (resultado != null && !resultado.isEmpty()) {
				for (clase.Producto pro : resultado) {
					cboNomP.addItem(pro.getNombre());
				}
				
				editor.setText(texto);
				
				if (texto != null && !texto.trim().isEmpty()) {
					editor.setCaretPosition(posicionCaret);
				}
				
				cboNomP.showPopup();
			} else {
				editor.setText(texto);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBuscar) {
			do_btnBuscar_actionPerformed(e);
		}
		if (e.getSource() == btnLisTodo) {
			do_btnLisTodo_actionPerformed(e);
		}
		if (e.getSource() == btnCancelar) {
			do_btnCancelar_actionPerformed(e);
		}
		if (e.getSource() == btnEliminarElemento) {
			do_btnEliminarElemento_actionPerformed(e);
		}
		if (e.getSource() == btnTerminarCompra) {
			do_btnTerminarCompra_actionPerformed(e);
		}
		if (e.getSource() == btnAgreCom) {
			do_btnAgreCom_actionPerformed(e);
		}
		if (e.getSource() == btnLimpiar) {
			do_btnLimpiar_actionPerformed(e);
		}
		if (e.getSource() == btnRegresar) {
			do_btnRegresar_actionPerformed(e);
		}
		if (e.getSource() == btnNueCom) {
			do_btnNueCom_actionPerformed(e);
		}
	}
	
	// Encapsula los eventos de escucha para no ensuciar el constructor
	private void configurarEventosCalculo() {
		// Definimos un KeyAdapter genérico para ambos
	    java.awt.event.KeyAdapter validadorNumeros = new java.awt.event.KeyAdapter() {
	        @Override
	        public void keyTyped(java.awt.event.KeyEvent e) {
	            char c = e.getKeyChar();
	            // Validar si es número o punto decimal
	            if (!(Character.isDigit(c) || c == '.')) {
	                e.consume(); // Ignora la tecla presionada
	                java.awt.Toolkit.getDefaultToolkit().beep(); // Sonido de error del sistema
	            }
	            
	            // Opcional: Impedir más de un punto decimal
	            if (c == '.' && ((javax.swing.JTextField)e.getSource()).getText().contains(".")) {
	                e.consume();
	                java.awt.Toolkit.getDefaultToolkit().beep();
	            }
	        }
	    };

	    // Aplicamos a cantidad (solo números)
	    txtCantDC.addKeyListener(new java.awt.event.KeyAdapter() {
	        @Override
	        public void keyTyped(java.awt.event.KeyEvent e) {
	            if (!Character.isDigit(e.getKeyChar())) {
	                e.consume();
	                java.awt.Toolkit.getDefaultToolkit().beep();
	            }
	        }
	    });

	    // Aplicamos a precio (números y punto)
	    txtPreUniDC.addKeyListener(validadorNumeros);
	    
	    txtCantDC.addKeyListener(new java.awt.event.KeyAdapter() {
	        @Override
	        public void keyReleased(java.awt.event.KeyEvent e) {
	            calcularSubtotalDetalle();
	        }
	    });

	    txtPreUniDC.addKeyListener(new java.awt.event.KeyAdapter() {
	        @Override
	        public void keyReleased(java.awt.event.KeyEvent e) {
	            calcularSubtotalDetalle();
	        }
	    });
	}

	// Método auxiliar que procesa la matemática del subtotal
	private void calcularSubtotalDetalle() {
	    try {
	        if (txtCantDC.getText().trim().isEmpty() || txtPreUniDC.getText().trim().isEmpty()) {
	            txtSubTotDC.setText("0.00");
	            return;
	        }
	        
	        int cantidad = Integer.parseInt(txtCantDC.getText().trim());
	        double precioUnitario = Double.parseDouble(txtPreUniDC.getText().trim());
	        double subtotal = cantidad * precioUnitario;
	        
	        txtSubTotDC.setText(String.format(java.util.Locale.US, "%.2f", subtotal));
	        
	    } catch (NumberFormatException ex) {
	        txtSubTotDC.setText("0.00");
	    }
	}
	
	// Método limpio para setear el usuario de la clase sesionusuario
	private void cargarUsuarioLogueado() {
	    clase.Usuario usuarioLogueado = clase.SesionUsuario.getInstancia().getUsuarioLogueado();
	    if (usuarioLogueado != null) {
	        // Ajusta .getNombre() al método real de tu clase Usuario (ej: getUsuario() o getLogin())
	        txtUsuarioCom.setText(usuarioLogueado.getNombre()); 
	    } else {
	        txtUsuarioCom.setText("Admin Temporal (Sin Sesión)");
	    }
	}
	
	protected void do_btnNueCom_actionPerformed(ActionEvent e) {
		//preparando la clase global compra
		compraActual = new clase.Compra();
	    compraActual.setDetCom(new java.util.ArrayList<clase.DetalleCompra>());
	    
		estadoComprando();
	    limpiarCampos(); 
	    
	    // Inicializaciones específicas de una NUEVA compra
	    txtCosTotCom.setText("0.00");
	    txtEstCom.setText("ACTIVO"); 
	    modeloTable.setRowCount(0);
	    
	    cargarUsuarioLogueado();
	    
	    java.time.LocalDate fechaActual = java.time.LocalDate.now();
	    java.time.format.DateTimeFormatter formato = java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    txtFechaCom.setText(fechaActual.format(formato));
	    
	    cboNomP.requestFocus();
	}
	
	protected void do_btnRegresar_actionPerformed(ActionEvent e) {
		Menu ventanaMenu = new Menu();
	    ventanaMenu.setVisible(true);
	    this.dispose();
	}
	
	private void limpiarCampos() {
	    txtCodCom.setText("");        
	    txtCodDC.setText("");
	    txtCantDC.setText("");
	    txtPreUniDC.setText("");
	    txtSubTotDC.setText("");
	    txtCodP.setText("");
	    txtCatP.setText("");
	    txtPresP.setText("");
	    txtCodLote.setText("");
	    txtNroLote.setText("");
	    txtStockActLote.setText("");
	    txtFechaVenciLote.setText(""); // El JFormattedTextField regresará a "__/__/__"
	    
	    if (cboNomP.getItemCount() > 0) {
	        cboNomP.setSelectedIndex(0);
	    }
	}
	
	protected void do_btnLimpiar_actionPerformed(ActionEvent e) {
		limpiarCampos();
	    
	    // Al limpiar en medio de una compra, recalculamos el lote por si acaso
	    sincronizarCamposDelProducto(); 
	    cboNomP.requestFocus();
	}
	
	private boolean esFormularioValido() {
	    // 1. Validar producto seleccionado
	    if (productoSeleccionadoTemporal == null) {
	        javax.swing.JOptionPane.showMessageDialog(this, "Seleccione un producto del buscador.");
	        return false;
	    }
	    
	    // 2. Validar campos numéricos
	    if (txtCantDC.getText().trim().isEmpty() || txtPreUniDC.getText().trim().isEmpty()) {
	        javax.swing.JOptionPane.showMessageDialog(this, "La cantidad y el precio son obligatorios.");
	        return false;
	    }
	    
	    // 3. Validar Fecha de Vencimiento (La máscara es "####/##/##")
	    // Esto verifica que no queden guiones bajos (placeholder) de la máscara
	    if (txtFechaVenciLote.getText().contains("_")) {
	        javax.swing.JOptionPane.showMessageDialog(this, "La fecha de vencimiento está incompleta.");
	        return false;
	    }

	    // 4. Validar que la cantidad sea mayor a cero
	    try {
	        int cant = Integer.parseInt(txtCantDC.getText().trim());
	        if (cant <= 0) {
	            javax.swing.JOptionPane.showMessageDialog(this, "La cantidad debe ser mayor a 0.");
	            return false;
	        }
	    } catch (NumberFormatException e) {
	        javax.swing.JOptionPane.showMessageDialog(this, "La cantidad debe ser un número entero.");
	        return false;
	    }

	    return true; // Si pasa todo esto, el formulario es seguro
	}
	
	private void agregarOActualizarProducto(clase.DetalleCompra nuevoDetalle) {
		// 1. Buscar si el producto existe
	    clase.DetalleCompra detalleExistente = null;
	    int indiceFila = -1;

	    for (int i = 0; i < compraActual.getDetCom().size(); i++) {
	        clase.DetalleCompra d = compraActual.getDetCom().get(i);
	        if (d.getPro().getId() == nuevoDetalle.getPro().getId()) {
	            detalleExistente = d;
	            indiceFila = i;
	            break;
	        }
	    }

	    if (detalleExistente != null) {
	        // --- AQUÍ LA PREGUNTA AL USUARIO ---
	        int confirm = javax.swing.JOptionPane.showConfirmDialog(this, 
	                "El producto ya está en la lista. ¿Desea sumar la cantidad al registro existente?"
	                + "\nEsta opcion no cambiara el resto de los datos ya establecidos en el prodcuto anterior."
	                + "\nRecomendamos eliminar de la lista el elemento y agregar otro para tener otros datos.", 
	                "Producto duplicado", javax.swing.JOptionPane.YES_NO_OPTION);

	        if (confirm == javax.swing.JOptionPane.YES_OPTION) {
	            // A) SUMAR CANTIDAD
	            int nuevaCantidad = detalleExistente.getCant() + nuevoDetalle.getCant();
	            detalleExistente.setCant(nuevaCantidad);
	            
	            modeloTable.setValueAt(nuevaCantidad, indiceFila, 5); // Fila 5: Cantidad
	            modeloTable.setValueAt(String.format("%.2f", detalleExistente.getSubTotal()), indiceFila, 7); // Fila 7: Subtotal
	            javax.swing.JOptionPane.showMessageDialog(this, "Cantidad actualizada.");
	        } else {
	            // B) EL USUARIO DIJO NO: No hacemos nada, o podrías decidir crear una fila nueva si quisieras.
	            javax.swing.JOptionPane.showMessageDialog(this, "Operación cancelada.");
	        }
	    } else {
	        // AGREGAR NUEVO (Sin preguntar)
	        compraActual.getDetCom().add(nuevoDetalle);
	        modeloTable.addRow(new Object[] {
	            "Pendiente", 
	            txtFechaCom.getText(), 
	            txtUsuarioCom.getText(),
	            nuevoDetalle.getPro().getId(), 
	            nuevoDetalle.getPro().getNombre(),
	            nuevoDetalle.getCant(), 
	            nuevoDetalle.getCostoUni(),
	            String.format("%.2f", nuevoDetalle.getSubTotal()),
	            nuevoDetalle.getLote().getNumeroLote()
	        });
	    }
	}
	
	private clase.DetalleCompra crearDetalleDesdeCampos() {
	    // 1. Recuperar valores de la vista
	    int cantidad = Integer.parseInt(txtCantDC.getText().trim());
	    double costoUni = Double.parseDouble(txtPreUniDC.getText().trim());

	    // 2. Construir objeto Lote
	    clase.Lote nuevoLote = new clase.Lote();
	    nuevoLote.setNumeroLote(txtNroLote.getText());
	    nuevoLote.setFechaVencimiento(java.time.LocalDate.parse(txtFechaVenciLote.getText().replace("/", "-")));
	    nuevoLote.setStockActual(cantidad);

	    // 3. Construir objeto Detalle
	    clase.DetalleCompra nuevoDetalle = new clase.DetalleCompra();
	    nuevoDetalle.setCant(cantidad);
	    nuevoDetalle.setCostoUni(costoUni);
	    nuevoDetalle.setPro(productoSeleccionadoTemporal);
	    nuevoDetalle.setLote(nuevoLote);

	    return nuevoDetalle;
	}
	
	protected void do_btnAgreCom_actionPerformed(ActionEvent e) {
		// 1. Filtro: Si no es válido, no hacemos nada.
	    if (!esFormularioValido()) {
	        return; 
	    }

	    try {
	        // 2. Preparar el objeto (Un solo lugar donde se crea el Detalle)
	        clase.DetalleCompra detalle = crearDetalleDesdeCampos();
	        
	        // 3. Gestionar la lógica (Agregar a lista O actualizar cantidad si ya existe)
	        agregarOActualizarProducto(detalle);

	        // 4. Actualizar totales y limpiar vista (Esto ocurre en ambos casos)
	        txtCosTotCom.setText(String.format("%.2f", compraActual.getCostoTotal()));
	        limpiarCamposDetalle();
	        
	    } catch (Exception ex) {
	        javax.swing.JOptionPane.showMessageDialog(this, "Error al procesar: " + ex.getMessage());
	    }
	}

	// Método pequeño para no limpiar todo, solo lo del detalle
	private void limpiarCamposDetalle() {
	    txtCantDC.setText("");
	    txtPreUniDC.setText("");
	    txtSubTotDC.setText("");
	    txtNroLote.setText("");
	    txtFechaVenciLote.setText("");
	}
	
	protected void do_btnTerminarCompra_actionPerformed(ActionEvent e) {
		// 1. Validación de existencia
	    if (compraActual == null || compraActual.getDetCom().isEmpty()) {
	        javax.swing.JOptionPane.showMessageDialog(this, "No hay productos en la lista.");
	        return;
	    }

	    // 2. Asegurar que el objeto tiene la fecha actual (vital para el INSERT)
	    compraActual.setFecha(java.time.LocalDate.now());

	    int opcion = javax.swing.JOptionPane.showConfirmDialog(this, "¿Finalizar compra?", "Confirmar", javax.swing.JOptionPane.YES_NO_OPTION);
	    if (opcion != javax.swing.JOptionPane.YES_OPTION) return;

	    try {
	        // 3. Ejecución del DAO
	        ArrayCompra dao = new ArrayCompra();
	        if (dao.registrarCompraCompleta(compraActual)) {
	            javax.swing.JOptionPane.showMessageDialog(this, "¡Compra registrada con éxito!");
	            
	            // 4. Resetear estado
	            estadoInicial(); // Asegúrate de que esto limpie tus campos de texto
	            limpiarCampos();
	            modeloTable.setRowCount(0);
	            compraActual = null; // Liberamos la memoria
	        } else {
	            javax.swing.JOptionPane.showMessageDialog(this, "Error: No se pudo guardar en la base de datos.");
	        }
	    } catch (Exception ex) {
	        javax.swing.JOptionPane.showMessageDialog(this, "Error crítico: " + ex.getMessage());
	    }
	    
	    estadoInicial();
	    listarTodoEnTabla();
	}
	
	protected void do_btnEliminarElemento_actionPerformed(ActionEvent e) {
		// 1. Obtener la fila seleccionada en la tabla
	    int filaSeleccionada = tblCom.getSelectedRow();
	    
	    if (filaSeleccionada == -1) {
	        javax.swing.JOptionPane.showMessageDialog(this, "Por favor, seleccione una fila de la tabla para eliminar.");
	        return;
	    }
	    
	    //confirmacion visual en syso del elemento seleccionado
	    Object idProducto = modeloTable.getValueAt(filaSeleccionada, 3);
	    System.out.println("DEBUG: Preparando para eliminar producto ID: " + idProducto + " en la fila: " + filaSeleccionada);
	    
	    // 2. Confirmación de seguridad
	    int confirm = javax.swing.JOptionPane.showConfirmDialog(this, 
	            "¿Desea eliminar este producto de la lista?", "Confirmar", javax.swing.JOptionPane.YES_NO_OPTION);
	    
	    if (confirm == javax.swing.JOptionPane.YES_OPTION) {
	        // 3. Eliminar del objeto en memoria (ArrayList)
	        compraActual.getDetCom().remove(filaSeleccionada);
	        
	        // 4. Eliminar de la vista (JTable)
	        modeloTable.removeRow(filaSeleccionada);
	        
	        // 5. Recalcular el costo total de la compra tras la eliminación
	        txtCosTotCom.setText(String.format("%.2f", compraActual.getCostoTotal()));
	        
	        javax.swing.JOptionPane.showMessageDialog(this, "Elemento eliminado correctamente.");
	    }
	    System.out.println("Elementos restantes en la lista: " + compraActual.getDetCom().size());
	    limpiarCampos();
	}
	
	protected void do_btnCancelar_actionPerformed(ActionEvent e) {
		// 1. Confirmación de seguridad (es una acción destructiva)
	    int confirm = javax.swing.JOptionPane.showConfirmDialog(this, 
	            "¿Está seguro de cancelar toda la compra? Se perderán los datos actuales.", 
	            "Cancelar Compra", javax.swing.JOptionPane.YES_NO_OPTION);
	    
	    if (confirm == javax.swing.JOptionPane.YES_OPTION) {
	        // 2. Limpiar la memoria (El objeto compraActual se vuelve nulo)
	        compraActual = null;
	        
	        // 3. Limpiar la vista
	        estadoInicial();
	        limpiarCampos();
	        modeloTable.setRowCount(0); // Vaciar la tabla visual
	        txtCosTotCom.setText("0.00");
	        
	        // 4. Regresar al estado inicial (bloquear botones y campos)
	        estadoInicial();
	        
	        javax.swing.JOptionPane.showMessageDialog(this, "Compra cancelada.");
	    }
	    
	    listarTodoEnTabla();
	}
	
	public void listarTodoEnTabla() {
	    // 1. Limpiamos la tabla antes de cargar los nuevos datos
	    // Esto asegura que si se le dio otro uso antes, no queden residuos
	    modeloTable.setRowCount(0); 
	    
	    // 2. Creamos la instancia de tu DAO (ArrayDetalleCompra)
	    ArrayDetalleCompra adc = new ArrayDetalleCompra();
	    
	    // 3. Obtenemos la lista desde la base de datos
	    ArrayList<DetalleCompra> lista = adc.ListarDetalles();
	    
	    // 4. Recorremos la lista y agregamos al modelo de la tabla
	    for (DetalleCompra d : lista) {
	        Object[] fila = {
	            d.getCompra().getCod(),                 // 1. ID Compra
	            d.getCompra().getFecha(),               // 2. Fecha
	            d.getCompra().getUsuario().getNombre(), // 3. Nombre Usuario
	            d.getPro().getId(),                     // 4. ID Producto
	            d.getPro().getNombre(),                 // 5. Producto
	            d.getCant(),                            // 6. Cantidad
	            d.getCostoUni(),                        // 7. Costo Uni
	            d.getSubTotal(),                        // 8. Subtotal (Método de tu clase)
	            d.getLote().getNumeroLote(),             // 9. N° Lote
	            d.getCod()   // ID DETALLE oculto
	        };
	        modeloTable.addRow(fila);
	    }
	}
	
	//listar por fecha
	public void listarPorFecha(
	        java.time.LocalDate fecha) {

	    modeloTable.setRowCount(0);

	    ArrayDetalleCompra adc =
	            new ArrayDetalleCompra();

	    ArrayList<DetalleCompra> lista =
	            adc.listarDetallesPorFecha(fecha);

	    for (DetalleCompra d : lista) {

	        Object[] fila = {
	            d.getCompra().getCod(),
	            d.getCompra().getFecha(),
	            d.getCompra().getUsuario().getNombre(),
	            d.getPro().getId(),
	            d.getPro().getNombre(),
	            d.getCant(),
	            d.getCostoUni(),
	            d.getSubTotal(),
	            d.getLote().getNumeroLote(),
	            d.getCod()
	        };

	        modeloTable.addRow(fila);
	    }
	}
	
	protected void do_btnLisTodo_actionPerformed(ActionEvent e) {
		// Deshabilitar botón mientras carga para evitar clics múltiples
	    btnLisTodo.setEnabled(false);
	    
	    listarTodoEnTabla();
	    
	    // Volver a habilitar
	    btnLisTodo.setEnabled(true);
	}
	protected void do_btnBuscar_actionPerformed(ActionEvent e) {
		if (cboBuscar.getSelectedItem().equals("Seleccione...")) {
			JOptionPane.showMessageDialog(this,"Por favor seleccione una opcion de filtrado.");
		}
		else if (cboBuscar.getSelectedItem().equals("Fecha")) {
			try {

			    String texto =
			            txtBuscar.getText().trim();

			    if (texto.isEmpty()) {
			        JOptionPane.showMessageDialog(
			                this,
			                "Ingrese una fecha.");
			        return;
			    }

			    LocalDate fecha =
			            LocalDate.parse(texto);

			    listarPorFecha(fecha);

			} catch (Exception ex) {

			    JOptionPane.showMessageDialog(
			            this,
			            "Formato incorrecto.\n"
			          + "Use: AAAA-MM-DD");
			}
		}
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == lblNewLabel_20) {
			do_lblNewLabel_20_mouseClicked(e);
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
	
	protected void do_lblNewLabel_20_mouseClicked(MouseEvent e) {
		JOptionPane.showMessageDialog(
			    this,
			    "Esta seccion permite al usuario poder armar y registrar una compra o adquisicion"
			    + "\nde producto/s esto registrara automaticamente el lote excepto por datos necesarios"
			    + "\ncomo fecha de vencimiento, cantidad, precio, etc.. previamente a esto, el producto"
			    + "\ndebera estar registrado."
			    + "\n"
			    + "\nEsta ventana tiene 2 usos: "
			    + "\n" 
			    + "\n-Mientras no se este efectuando una compra (boton nueva compra) el usuario puede "
			    + "\nrevisar las compras en la tabla y clickeandolos puede pasar sus datos a los"
			    + "\ncampos, agregando algunos detalles extra de esa compra."
			    + "\n"
			    + "\n-Tambien se pueden buscar las compras realizadas por fecha desde el boton 'Buscar'"
			    + "\nseleccionando previamente en el desplegable el campo a filtrar y en el cuadro de"
			    + "\ntexto el valor especifico del campo a filtrar."
			    + "\n\n"
			    + "\n-Por otro lado al presionar el boton 'Nueva compra' el programa limpiara la tabla"
			    + "\ny la utilizara para mostrar los datos de la nueva compra que se realizara, rellenando"
			    + "\nautomaticamente varios campos que no necesitan ser ingresados por el usuario, como el"
			    + "\nnombre de usuario, la fecha, entre otros."
			    + "\n"
			    + "\n-En este estado tambien se habilitara el ingreso de los campos necesarios para agregar"
			    + "\nun elemento a la compra, asi como los productos registrados se rellenaran en el"
			    + "\ndesplegable 'Nombre de Productos', tras esto puede agregar este elemento a la compra"
			    + "\npresionando sobre el boton 'Agregar a la Compra'"
			    + "\n"
			    + "\n-Solo se puede adquirir una vez una cantidad de prodcutos por operacion, en caso de"
			    + "\nquerer agregar mas unidades del producto a este lote, tiene que eliminar lo agregado"
			    + "\ny volver a agregarlo con la cantidad correcta (revisar seccion debajo para eliminar)."
			    + "\n"
			    + "\n-En caso de querer eliminar un elemento de la compra primero seleccione el elemento"
			    + "\nclickeando sobre este en la tabla, posteriormente presione el boton 'Eliminar Elemento'"
			    + "\ny confirme la accion para poder retirarlo de la lista."
			    + "\n"
			    + "\n-Para confirmar y efectuar la compra completa presione el boton 'Terminar Compra', tras"
			    + "\nesto la compra sera registrada en la base de datos asi como los lotes, los cuales"
			    + "\npodran ser de la misma forma consultados en la ventana 'Inventario' disponibe desde el 'Menu'."
			    + "\n"
			    + "\n-En cualquier momento de la compra puede cancelar la operacion por cualquier motivo"
			    + "\npresionando el boton 'Cancelar Compra', tras esto retornara a la vista general.",
			    "Informacion.",
			    JOptionPane.INFORMATION_MESSAGE
			);
	}
}