package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import arrayList.ArrayDetalleCompra;
import clase.DetalleCompra;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class Inventario extends JFrame implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnBuscarNroLote;
	private JTextField txtBuscar;
	private JButton btnBuscarCate;
	private JButton btnBuscarFechaVenci;
	private JButton btnBuscarFechaAdqui;
	private JButton btnBuscarUsuario;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JButton btnBuscarPro;
	private JButton btnRegresar;
	private JScrollPane scrollPane;
	private JComboBox cboProducto;
	private JComboBox cboCategoria;
	private JTable tblTabla;
	
	private ArrayDetalleCompra adc = new ArrayDetalleCompra();
	private ArrayList<DetalleCompra> listaInventario =
	        new ArrayList<>();
	private DefaultTableModel modeloTable;
	private JButton btnListarTodo;
	private JLabel lblNewLabel_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inventario frame = new Inventario();
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
	public Inventario() {
		setTitle("Inventario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 539);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(216, 216, 216));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			btnBuscarNroLote = new JButton("Buscar por Nro. de Lote");
			btnBuscarNroLote.addActionListener(this);
			btnBuscarNroLote.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnBuscarNroLote.setBounds(10, 78, 182, 23);
			contentPane.add(btnBuscarNroLote);
		}
		{
			txtBuscar = new JTextField();
			txtBuscar.setFont(new Font("Tahoma", Font.PLAIN, 11));
			txtBuscar.setBounds(111, 23, 218, 20);
			contentPane.add(txtBuscar);
			txtBuscar.setColumns(10);
		}
		{
			btnBuscarCate = new JButton("Buscar por Categoria");
			btnBuscarCate.addActionListener(this);
			btnBuscarCate.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnBuscarCate.setBounds(10, 339, 182, 23);
			contentPane.add(btnBuscarCate);
		}
		{
			btnBuscarFechaVenci = new JButton("Buscar por Fecha Vencimiento");
			btnBuscarFechaVenci.addActionListener(this);
			btnBuscarFechaVenci.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnBuscarFechaVenci.setBounds(10, 112, 182, 23);
			contentPane.add(btnBuscarFechaVenci);
		}
		{
			btnBuscarFechaAdqui = new JButton("Buscar por Fecha Adquisición");
			btnBuscarFechaAdqui.addActionListener(this);
			btnBuscarFechaAdqui.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnBuscarFechaAdqui.setBounds(10, 146, 182, 23);
			contentPane.add(btnBuscarFechaAdqui);
		}
		{
			btnBuscarUsuario = new JButton("Buscar por Usuario");
			btnBuscarUsuario.addActionListener(this);
			btnBuscarUsuario.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnBuscarUsuario.setBounds(10, 180, 182, 23);
			contentPane.add(btnBuscarUsuario);
		}
		{
			lblNewLabel = new JLabel("Ingrese el campo:");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel.setBounds(10, 26, 91, 14);
			contentPane.add(lblNewLabel);
		}
		{
			lblNewLabel_1 = new JLabel("(AAAA-MM-DD)");
			lblNewLabel_1.setBounds(214, 116, 86, 14);
			contentPane.add(lblNewLabel_1);
		}
		{
			lblNewLabel_2 = new JLabel("(AAAA-MM-DD)");
			lblNewLabel_2.setBounds(214, 150, 86, 14);
			contentPane.add(lblNewLabel_2);
		}
		{
			btnBuscarPro = new JButton("Buscar por Producto");
			btnBuscarPro.addActionListener(this);
			btnBuscarPro.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnBuscarPro.setBounds(10, 272, 182, 23);
			contentPane.add(btnBuscarPro);
		}
		{
			btnRegresar = new JButton("Regresar");
			btnRegresar.addActionListener(this);
			btnRegresar.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnRegresar.setBounds(10, 466, 89, 23);
			contentPane.add(btnRegresar);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(351, 23, 673, 466);
			contentPane.add(scrollPane);
			{
				modeloTable = new DefaultTableModel(
					    new Object[][] {},
					    new String[] {
					        "ID Lote", "Nro. Lote", "Producto", "Stock", "Fecha Vencimiento", "Stock Inicial", "Costo Lote", "Fecha Adquisición", "Usuario",
					        "ID Producto", "ID Detalle","ID Compra"
					    }
					) {
					    private static final long serialVersionUID = 1L;
					    @Override
					    public boolean isCellEditable(int row, int column) {
					        return false;
					    }
					};
				
				tblTabla = new JTable();
				tblTabla.setModel(modeloTable);
				tblTabla.setFillsViewportHeight(true);
				java.awt.Color amarilloPalido = new java.awt.Color(255, 255, 204); 
				tblTabla.getTableHeader().setBackground(amarilloPalido);
				tblTabla.getTableHeader().setOpaque(true); 
				tblTabla.setFillsViewportHeight(true);
				scrollPane.setViewportView(tblTabla);
				
				configurarAnchoColumnas();
			}
		}
		{
			cboProducto = new JComboBox();
			cboProducto.setBounds(10, 239, 283, 22);
			contentPane.add(cboProducto);
		}
		{
			cboCategoria = new JComboBox();
			cboCategoria.setBounds(10, 306, 283, 22);
			contentPane.add(cboCategoria);
		}
		{
			btnListarTodo = new JButton("Listar Todo");
			btnListarTodo.addActionListener(this);
			btnListarTodo.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnListarTodo.setBounds(240, 466, 89, 23);
			contentPane.add(btnListarTodo);
		}
		{
			lblNewLabel_3 = new JLabel("i");
			lblNewLabel_3.addMouseListener(this);
			lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
			lblNewLabel_3.setBounds(0, 0, 23, 20);
			contentPane.add(lblNewLabel_3);
		}

		cargarInventario();
		cargarCombos();
		mostrarInventario(listaInventario);
		
	}
	
	private void configurarAnchoColumnas() {
	    tblTabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	    tblTabla.getColumnModel().getColumn(0).setPreferredWidth(80);  
	    tblTabla.getColumnModel().getColumn(1).setPreferredWidth(200);  
	    tblTabla.getColumnModel().getColumn(2).setPreferredWidth(200); 
	    tblTabla.getColumnModel().getColumn(3).setPreferredWidth(85);  
	    tblTabla.getColumnModel().getColumn(4).setPreferredWidth(200); 
	    tblTabla.getColumnModel().getColumn(5).setPreferredWidth(80);  
	    tblTabla.getColumnModel().getColumn(6).setPreferredWidth(80);  
	    tblTabla.getColumnModel().getColumn(7).setPreferredWidth(200);  
	    tblTabla.getColumnModel().getColumn(8).setPreferredWidth(200); 
	    tblTabla.getColumnModel().getColumn(9).setPreferredWidth(80);
	    tblTabla.getColumnModel().getColumn(10).setPreferredWidth(80);
	    tblTabla.getColumnModel().getColumn(11).setPreferredWidth(80);
	}
	
	public void cargarInventario() {
	    listaInventario = adc.listarInventario();
	}
	
	private void cargarCombos() {
	    // Limpiar combos por si se vuelve a ejecutar
	    cboProducto.removeAllItems();
	    cboCategoria.removeAllItems();
	    
	    // Listas auxiliares para evitar duplicados
	    java.util.HashSet<String> productosSet = new java.util.HashSet<>();
	    java.util.HashSet<String> categoriasSet = new java.util.HashSet<>();

	    for (DetalleCompra d : listaInventario) {
	        // Asumiendo que DetalleCompra tiene acceso a Producto y su Categoria
	        if (d.getPro() != null) {
	            String nombreProd = d.getPro().getNombre();
	            String nombreCat = d.getPro().getCategoria().getNombre(); // Ajusta según tu método real

	            if (productosSet.add(nombreProd)) {
	                cboProducto.addItem(nombreProd);
	            }
	            if (categoriasSet.add(nombreCat)) {
	                cboCategoria.addItem(nombreCat);
	            }
	        }
	    }
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBuscarCate) {
			do_btnBuscarCate_actionPerformed(e);
		}
		if (e.getSource() == btnBuscarPro) {
			do_btnBuscarPro_actionPerformed(e);
		}
		if (e.getSource() == btnBuscarFechaAdqui) {
			do_btnBuscarFechaAdqui_actionPerformed(e);
		}
		if (e.getSource() == btnBuscarFechaVenci) {
			do_btnBuscarFechaVenci_actionPerformed(e);
		}
		if (e.getSource() == btnBuscarUsuario) {
			do_btnBuscarUsuario_actionPerformed(e);
		}
		if (e.getSource() == btnBuscarNroLote) {
			do_btnBuscarNroLote_actionPerformed(e);
		}
		if (e.getSource() == btnListarTodo) {
			do_btnListarTodo_actionPerformed(e);
		}
		if (e.getSource() == btnRegresar) {
			do_btnNewButton_2_actionPerformed(e);
		}
	}
	protected void do_btnNewButton_2_actionPerformed(ActionEvent e) {
		Menu ventanaMenu = new Menu();
	    ventanaMenu.setVisible(true);
	    this.dispose();
	}
	
	private void mostrarInventario(
	        ArrayList<DetalleCompra> lista) {

	    modeloTable.setRowCount(0);

	    for (DetalleCompra d : lista) {

	        modeloTable.addRow(new Object[] {
	            d.getLote().getId(),
	            d.getLote().getNumeroLote(),
	            d.getPro().getNombre(),
	            d.getLote().getStockActual(),
	            d.getLote().getFechaVencimiento(),
	            d.getCant(),
	            d.getSubTotal(),
	            d.getCompra().getFecha(),
	            d.getCompra().getUsuario().getNombre(),
	            d.getPro().getId(),
	            d.getCod(),
	            d.getCompra().getCod()
	        });
	    }
	}
	
	private void agregarFila(DetalleCompra d) {

	    modeloTable.addRow(new Object[] {
	        d.getLote().getId(),
	        d.getLote().getNumeroLote(),
	        d.getPro().getNombre(),
	        d.getLote().getStockActual(),
	        d.getLote().getFechaVencimiento(),
	        d.getCant(),
	        d.getSubTotal(),
	        d.getCompra().getFecha(),
	        d.getCompra().getUsuario().getNombre(),
	        d.getPro().getId(),
	        d.getCod(),
	        d.getCompra().getCod()
	    });
	}
	
	protected void do_btnListarTodo_actionPerformed(ActionEvent e) {
		mostrarInventario(listaInventario);
	}
	
	protected void do_btnBuscarNroLote_actionPerformed(ActionEvent e) {
		String nro = txtBuscar.getText().trim();

	    modeloTable.setRowCount(0);

	    for (DetalleCompra d : listaInventario) {

	        if (d.getLote()
	             .getNumeroLote()
	             .toLowerCase()
	             .contains(nro.toLowerCase())) {

	            agregarFila(d);
	        }
	    }
	}
	
	protected void do_btnBuscarUsuario_actionPerformed(ActionEvent e) {
		String usuario =
	            txtBuscar.getText().trim();

	    modeloTable.setRowCount(0);

	    for (DetalleCompra d : listaInventario) {

	        if (d.getCompra()
	             .getUsuario()
	             .getNombre()
	             .toLowerCase()
	             .contains(usuario.toLowerCase())) {

	            agregarFila(d);
	        }
	    }
	}
	
	protected void do_btnBuscarFechaVenci_actionPerformed(ActionEvent e) {
		String usuario =
	            txtBuscar.getText().trim();

	    modeloTable.setRowCount(0);

	    for (DetalleCompra d : listaInventario) {

	        if (d.getLote()
	        	 .getFechaVencimiento()
	        	 .toString()
	             .contains(usuario.toLowerCase())) {

	            agregarFila(d);
	        }
	    }
	}
	
	protected void do_btnBuscarFechaAdqui_actionPerformed(ActionEvent e) {
		String usuario =
	            txtBuscar.getText().trim();

	    modeloTable.setRowCount(0);

	    for (DetalleCompra d : listaInventario) {

	        if (d.getCompra()
	        	 .getFecha()
	        	 .toString()
	             .contains(usuario.toLowerCase())) {

	            agregarFila(d);
	        }
	    }
	}
	
	protected void do_btnBuscarPro_actionPerformed(ActionEvent e) {
		String usuario =
	            cboProducto.getSelectedItem().toString().trim();

	    modeloTable.setRowCount(0);

	    for (DetalleCompra d : listaInventario) {

	        if (d.getPro()
	        	 .getNombre()
	        	 .toString()
	        	 .toLowerCase()
	             .contains(usuario.toLowerCase())) {

	            agregarFila(d);
	        }
	    }
	}
	protected void do_btnBuscarCate_actionPerformed(ActionEvent e) {
		String usuario =
	            cboCategoria.getSelectedItem().toString().trim();

	    modeloTable.setRowCount(0);

	    for (DetalleCompra d : listaInventario) {

	        if (d.getPro()
	        	 .getCategoria()
	        	 .getNombre()
	        	 .toString()
	        	 .toLowerCase()
	             .contains(usuario.toLowerCase())) {

	            agregarFila(d);
	        }
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
			    "Esta ventana es solo de consulta, esta permite revisar por diversos filtros de"
			    + "\nbusqueda los lotes con sus productos y otros entes relacionados como el usuario"
			    + "\nque los registro o en que compra se adquirieron."
			    + "\n"
			    + "\nAl ser esta una ventana de consulta no se pueden modificar ni eliminar los"
			    + "lotes ni su informacion disponible."
			    + "\n"
			    + "\nA excepcion de producto o categoria debera llenar el campo de texto superior y"
			    + "\ndsps usar el boton correspondiente al dato ingresado, cada boton necesitara su"
			    + "\ntipo de dato, evite usar botones que no requieran la informacion a consultar.",
			    "Informacion.",
			    JOptionPane.INFORMATION_MESSAGE
			);
	}
}
