package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import arrayList.ArrayCategoria;
import arrayList.ArrayProducto;
import arrayList.ArrayUsuario;
import clase.Categoria;
import clase.Producto;
import clase.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import java.awt.event.MouseListener;

public class Productos extends JFrame implements ActionListener, MouseListener {

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
	private JTextField txtIdC;
	private JTextArea txtDesC;
	private JLabel lblNewLabel_8;
	private JButton btnAgregarP;
	private JButton btnBuscarP;
	private JButton btnModificarP;
	private JButton btnEliminarP;
	private JLabel lblNewLabel_9;
	private JButton btnAgregarC;
	private JButton btnBuscarC;
	private JButton btnEliminarC;
	private JButton btnModificarC;
	private JButton btnRegresar;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_12;
	private JLabel lblNewLabel_13;
	private JLabel lblNewLabel_14;
	private JLabel lblNewLabel_15;
	private JLabel lblNewLabel_16;
	private JTextField txtIdP;
	private JComboBox cboReqRec;
	private JTextField txtNomP;
	private JTextField txtPrinActP;
	private JTextField txtMarcaP;
	private JTextField txtLabP;
	private JTextField txtPreP;
	private JComboBox cboCategoria;
	private JComboBox cboActP;
	private JScrollPane scrollPaneC;
	private JTable table;
	private JScrollPane scrollPaneP;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Productos frame = new Productos();
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
	public Productos() {
		setTitle("Gestion Productos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1260, 667);
		setResizable(false); //evitar cambiar el tamaño de la ventana
		setLocationRelativeTo(null); //centra la posicion de la ventana al ejecutar
		contentPane = new JPanel();
		contentPane.setBackground(new Color(194, 204, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel = new JLabel("Id:");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel.setBounds(10, 45, 19, 14);
			contentPane.add(lblNewLabel);
		}
		{
			lblNewLabel_1 = new JLabel("Nombre:");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_1.setBounds(10, 80, 46, 14);
			contentPane.add(lblNewLabel_1);
		}
		{
			lblNewLabel_2 = new JLabel("Principio Activo:");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_2.setBounds(10, 115, 82, 14);
			contentPane.add(lblNewLabel_2);
		}
		{
			lblNewLabel_3 = new JLabel("Categoria:");
			lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_3.setBounds(333, 11, 66, 14);
			contentPane.add(lblNewLabel_3);
		}
		{
			lblNewLabel_4 = new JLabel("Id:");
			lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_4.setBounds(333, 48, 19, 14);
			contentPane.add(lblNewLabel_4);
		}
		{
			lblNewLabel_5 = new JLabel("Nombre:");
			lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_5.setBounds(333, 84, 46, 14);
			contentPane.add(lblNewLabel_5);
		}
		{
			lblNewLabel_6 = new JLabel("Producto:");
			lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_6.setBounds(10, 11, 60, 14);
			contentPane.add(lblNewLabel_6);
		}
		{
			lblNewLabel_7 = new JLabel("Descripción:");
			lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_7.setBounds(333, 121, 66, 14);
			contentPane.add(lblNewLabel_7);
		}
		{
			txtIdC = new JTextField();
			txtIdC.setEditable(false);
			txtIdC.setColumns(10);
			txtIdC.setBounds(400, 45, 206, 20);
			contentPane.add(txtIdC);
		}
		{
			txtDesC = new JTextArea();
			txtDesC.setWrapStyleWord(true);
			txtDesC.setLineWrap(true);
			txtDesC.setBounds(333, 144, 307, 96);
			contentPane.add(txtDesC);
		}
		{
			lblNewLabel_8 = new JLabel("Opciones de Producto:");
			lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_8.setBounds(10, 462, 172, 14);
			contentPane.add(lblNewLabel_8);
		}
		{
			btnAgregarP = new JButton("Agregar");
			btnAgregarP.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnAgregarP.addActionListener(this);
			btnAgregarP.setBounds(32, 487, 102, 23);
			contentPane.add(btnAgregarP);
		}
		{
			btnBuscarP = new JButton("Buscar");
			btnBuscarP.addActionListener(this);
			btnBuscarP.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnBuscarP.setBounds(32, 560, 102, 23);
			contentPane.add(btnBuscarP);
		}
		{
			btnModificarP = new JButton("Modificar");
			btnModificarP.addActionListener(this);
			btnModificarP.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnModificarP.setBounds(32, 521, 102, 23);
			contentPane.add(btnModificarP);
		}
		{
			btnEliminarP = new JButton("Deshabilitar");
			btnEliminarP.addActionListener(this);
			btnEliminarP.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnEliminarP.setBounds(194, 521, 102, 23);
			contentPane.add(btnEliminarP);
		}
		{
			lblNewLabel_9 = new JLabel("Opciones de Categoria:");
			lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_9.setBounds(333, 400, 172, 14);
			contentPane.add(lblNewLabel_9);
		}
		{
			btnAgregarC = new JButton("Agregar");
			btnAgregarC.addActionListener(this);
			btnAgregarC.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnAgregarC.setBounds(355, 425, 102, 23);
			contentPane.add(btnAgregarC);
		}
		{
			btnBuscarC = new JButton("Buscar");
			btnBuscarC.addActionListener(this);
			btnBuscarC.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnBuscarC.setBounds(355, 498, 102, 23);
			contentPane.add(btnBuscarC);
		}
		{
			btnEliminarC = new JButton("Eliminar");
			btnEliminarC.addActionListener(this);
			btnEliminarC.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnEliminarC.setBounds(517, 459, 102, 23);
			contentPane.add(btnEliminarC);
		}
		{
			btnModificarC = new JButton("Modificar");
			btnModificarC.addActionListener(this);
			btnModificarC.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnModificarC.setBounds(355, 459, 102, 23);
			contentPane.add(btnModificarC);
		}
		{
			btnRegresar = new JButton("Regresar");
			btnRegresar.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnRegresar.addActionListener(this);
			btnRegresar.setBounds(10, 594, 89, 23);
			contentPane.add(btnRegresar);
		}
		{
			lblNewLabel_10 = new JLabel("Marca:");
			lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_10.setBounds(10, 150, 82, 14);
			contentPane.add(lblNewLabel_10);
		}
		{
			lblNewLabel_11 = new JLabel("Laboratorio:");
			lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_11.setBounds(10, 185, 82, 14);
			contentPane.add(lblNewLabel_11);
		}
		{
			lblNewLabel_12 = new JLabel("Presentacion:");
			lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_12.setBounds(10, 220, 82, 14);
			contentPane.add(lblNewLabel_12);
		}
		{
			lblNewLabel_13 = new JLabel("Precio:");
			lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_13.setBounds(10, 317, 82, 14);
			contentPane.add(lblNewLabel_13);
		}
		{
			lblNewLabel_14 = new JLabel("Categoria:");
			lblNewLabel_14.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_14.setBounds(10, 352, 82, 14);
			contentPane.add(lblNewLabel_14);
		}
		{
			lblNewLabel_15 = new JLabel("Requiere Receta:");
			lblNewLabel_15.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_15.setBounds(10, 387, 94, 14);
			contentPane.add(lblNewLabel_15);
		}
		{
			lblNewLabel_16 = new JLabel("Activo:");
			lblNewLabel_16.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_16.setBounds(10, 422, 94, 14);
			contentPane.add(lblNewLabel_16);
		}
		{
			txtIdP = new JTextField();
			txtIdP.setEditable(false);
			txtIdP.setBounds(114, 42, 199, 20);
			contentPane.add(txtIdP);
			txtIdP.setColumns(10);
		}
		{
			cboReqRec = new JComboBox();
			cboReqRec.setBounds(114, 383, 199, 22);
			contentPane.add(cboReqRec);
			
			//campos
			cboReqRec.addItem("true");
			cboReqRec.addItem("false");
		}
		{
			txtNomP = new JTextField();
			txtNomP.setColumns(10);
			txtNomP.setBounds(114, 77, 199, 20);
			contentPane.add(txtNomP);
		}
		{
			txtPrinActP = new JTextField();
			txtPrinActP.setColumns(10);
			txtPrinActP.setBounds(114, 112, 199, 20);
			contentPane.add(txtPrinActP);
		}
		{
			txtMarcaP = new JTextField();
			txtMarcaP.setColumns(10);
			txtMarcaP.setBounds(114, 146, 199, 20);
			contentPane.add(txtMarcaP);
		}
		{
			txtLabP = new JTextField();
			txtLabP.setColumns(10);
			txtLabP.setBounds(114, 182, 199, 20);
			contentPane.add(txtLabP);
		}
		{
			txtPreP = new JTextField();
			txtPreP.setColumns(10);
			txtPreP.setBounds(114, 314, 199, 20);
			contentPane.add(txtPreP);
		}
		{
			cboCategoria = new JComboBox();
			cboCategoria.setBounds(114, 348, 199, 22);
			contentPane.add(cboCategoria);
		}
		{
			cboActP = new JComboBox();
			cboActP.setBounds(114, 418, 199, 22);
			contentPane.add(cboActP);
			
			//campos
			cboActP.addItem("true");
			cboActP.addItem("false");
		}
		{
			scrollPaneC = new JScrollPane();
			scrollPaneC.setBounds(333, 251, 310, 125);
			contentPane.add(scrollPaneC);
			{
				table = new JTable();
				scrollPaneC.setViewportView(table);
			}
			
			//creacion de columnas
			table.setModel(new DefaultTableModel(
				    new Object[][] {},
				    new String[] {
				        "ID",
				        "Nombre"
				    }
			));
			//funcion para obtener de la tabla
			table.addMouseListener(new MouseAdapter() {
			    @Override
			    public void mouseClicked(MouseEvent e) {
			        cargarDatosSeleccionados();
			    }
			});
			//estilo visual de la tabla
			table.getTableHeader().setFont(
				    new Font("Tahoma", Font.BOLD, 11)
				);
			table.getTableHeader().setBackground(
				    new Color(190, 220, 245)
				);
		}
		{
			scrollPaneP = new JScrollPane();
			scrollPaneP.setBounds(660, 23, 574, 459);
			contentPane.add(scrollPaneP);
			{
				table_1 = new JTable();
				scrollPaneP.setViewportView(table_1);
			}
			//creacion de columnas
			table_1.setModel(new DefaultTableModel(
				    new Object[][] {},
				    new String[] {
				        "ID",
				        "Nombre",
				        "Prin. Activo",
				        "Marca",
				        "Laboratorio",
				        "Presentacion",
				        "Precio",
				        "Categoria",
				        "Req. receta",
				        "Activo"
				    }
			));
			//funcion para obtener de la tabla
			table_1.addMouseListener(new MouseAdapter() {
			    @Override
			    public void mouseClicked(MouseEvent e) {
			        cargarDatosProductoSeleccionado();
			    }
			});
			//estilo visual de la tabla
			table_1.getTableHeader().setFont(
				    new Font("Tahoma", Font.BOLD, 11)
				);
			table_1.getTableHeader().setBackground(
				    new Color(190, 220, 245)
				);
			//ajuste de tamaños
			table_1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			table_1.getColumnModel().getColumn(1).setPreferredWidth(140);
			table_1.getColumnModel().getColumn(2).setPreferredWidth(140);
			table_1.getColumnModel().getColumn(3).setPreferredWidth(140);
			table_1.getColumnModel().getColumn(4).setPreferredWidth(140);
			table_1.getColumnModel().getColumn(5).setPreferredWidth(140);
			table_1.getColumnModel().getColumn(6).setPreferredWidth(90);
			table_1.getColumnModel().getColumn(7).setPreferredWidth(140);
			table_1.getColumnModel().getColumn(8).setPreferredWidth(140);
			table_1.setRowHeight(25);
		}
		{
			txtNomC = new JTextField();
			txtNomC.setColumns(10);
			txtNomC.setBounds(400, 81, 206, 20);
			contentPane.add(txtNomC);
		}
		{
			txtBuscarC = new JTextField();
			txtBuscarC.setBounds(467, 499, 173, 20);
			contentPane.add(txtBuscarC);
			txtBuscarC.setColumns(10);
		}
		{
			txtBuscarP = new JTextField();
			txtBuscarP.setColumns(10);
			txtBuscarP.setBounds(144, 561, 169, 20);
			contentPane.add(txtBuscarP);
		}
		{
			btnListarC = new JButton("Listar");
			btnListarC.addActionListener(this);
			btnListarC.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnListarC.setBounds(517, 425, 102, 23);
			contentPane.add(btnListarC);
		}
		{
			btnListarP = new JButton("Listar");
			btnListarP.addActionListener(this);
			btnListarP.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnListarP.setBounds(194, 487, 102, 23);
			contentPane.add(btnListarP);
		}
		{
			txtPresP = new JTextArea();
			txtPresP.setWrapStyleWord(true);
			txtPresP.setLineWrap(true);
			txtPresP.setBounds(114, 215, 199, 83);
			contentPane.add(txtPresP);
		}
		{
			lblNewLabel_17 = new JLabel("i");
			lblNewLabel_17.addMouseListener(this);
			lblNewLabel_17.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_17.setFont(new Font("Times New Roman", Font.BOLD, 16));
			lblNewLabel_17.setBounds(1221, 0, 23, 20);
			contentPane.add(lblNewLabel_17);
		}
		
		//funcion cargar tablas categoria al iniciar el frame
		cargarCategoriaTabla();
		cargarCategoriasCombo();
		cargarProductoTabla();
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRegresar) {
			do_btnRegresar_actionPerformed(e);
		}
		if (e.getSource() == btnEliminarP) {
			do_btnEliminarP_actionPerformed(e);
		}
		if (e.getSource() == btnModificarP) {
			do_btnModificarP_actionPerformed(e);
		}
		if (e.getSource() == btnBuscarP) {
			do_btnBuscarP_actionPerformed(e);
		}
		if (e.getSource() == btnListarP) {
			do_btnListarP_actionPerformed(e);
		}
		if (e.getSource() == btnEliminarC) {
			do_btnEliminarC_actionPerformed(e);
		}
		if (e.getSource() == btnListarC) {
			do_btnListarC_actionPerformed(e);
		}
		if (e.getSource() == btnBuscarC) {
			do_btnBuscarC_actionPerformed(e);
		}
		if (e.getSource() == btnModificarC) {
			do_btnModificarC_actionPerformed(e);
		}
		if (e.getSource() == btnAgregarC) {
			do_btnAgregarC_actionPerformed(e);
		}
		if (e.getSource() == btnAgregarP) {
			do_btnAgregarP_actionPerformed(e);
		}
	}
	
	//variable global
		private int idSeleccionado;
		private String nombreCatSeleccionado;
		private int idProductoSeleccionado;
		
		private JTextField txtNomC;
		private JTextField txtBuscarC;
		private JTextField txtBuscarP;
		private JButton btnListarC;
		private JButton btnListarP;
		private JTextArea txtPresP;
		private JLabel lblNewLabel_17;
	
	public void limpiarCampos() {
		//campos producto
		txtIdP.setText("");
		txtNomP.setText("");
		txtPrinActP.setText("");
		txtMarcaP.setText("");
		txtLabP.setText("");
		txtPresP.setText("");
		txtPreP.setText("");
		cboCategoria.setSelectedIndex(-1);
		cboReqRec.setSelectedIndex(0);
		cboActP.setSelectedIndex(0);
		//campos categoria
		txtIdC.setText("");
		txtNomC.setText("");
		txtDesC.setText("");
		//actualizar el cbo
		cargarCategoriasCombo();
	}
	
	private void cargarDatosProductoSeleccionado() {

	    int fila = table_1.getSelectedRow();

	    if (fila == -1)
	        return;
	    
	 // Guardar el ID del producto seleccionado
	    idProductoSeleccionado = Integer.parseInt(
	        table_1.getValueAt(fila, 0).toString()
	    );
	    
	    System.out.println("ID del producto seleccionada: " + idProductoSeleccionado);

	    txtIdP.setText(
	        table_1.getValueAt(fila, 0).toString()
	    );

	    txtNomP.setText(
	        table_1.getValueAt(fila, 1).toString()
	    );

	    txtPrinActP.setText(
	        table_1.getValueAt(fila, 2).toString()
	    );

	    txtMarcaP.setText(
	        table_1.getValueAt(fila, 3).toString()
	    );

	    txtLabP.setText(
	        table_1.getValueAt(fila, 4).toString()
	    );

	    txtPresP.setText(
	        table_1.getValueAt(fila, 5).toString()
	    );

	    txtPreP.setText(
	        table_1.getValueAt(fila, 6).toString()
	    );

	    cboCategoria.setSelectedItem(
	        table_1.getValueAt(fila, 7).toString()
	    );

	    cboReqRec.setSelectedItem(
	        table_1.getValueAt(fila, 8).toString()
	    );

	    cboActP.setSelectedItem(
	        table_1.getValueAt(fila, 9).toString()
	    );
	}
	
	//funcion para obtener datos de la tabla a los campos
	private void cargarDatosSeleccionados() {

	    int fila = table.getSelectedRow();

	    if(fila == -1)
	        return;

	    int id = Integer.parseInt(
	        table.getValueAt(fila, 0).toString()
	    );

	    idSeleccionado = Integer.parseInt(
		        table.getValueAt(fila, 0).toString()
		    );
	    nombreCatSeleccionado =
	    	    table.getValueAt(fila, 1).toString();
	    
	    System.out.println("ID de la categoria seleccionada: " + idSeleccionado);
	    System.out.println("Nombre seleccionado: " + nombreCatSeleccionado);
	    
	    ArrayList<Categoria> lista =
	        new ArrayCategoria().ListarCategoria();

	    for(Categoria c : lista) {
	        if(c.getId() == id) {

	            txtIdC.setText(String.valueOf(c.getId()));
	            
	            txtNomC.setText(
		                c.getNombre()
		            );

	            txtDesC.setText(
	                c.getDescripcion()
	            );

	            break;
	        }
	    }
	}
	
	public void habilitarComp(boolean p) {
		//campos producto
		txtIdP.setEnabled(p);
		txtNomP.setEnabled(p);
		txtPrinActP.setEnabled(p);
		txtMarcaP.setEnabled(p);
		txtLabP.setEnabled(p);
		txtPresP.setEnabled(p);
		txtPreP.setEnabled(p);
		cboCategoria.setEnabled(p);
		cboReqRec.setEnabled(p);
		cboActP.setEnabled(p);
		//botones producto
		btnAgregarP.setEnabled(p);
		btnListarP.setEnabled(p);
		btnBuscarP.setEnabled(p);
		btnModificarP.setEnabled(p);
		btnEliminarP.setEnabled(p);
		//campos categoria
		txtIdC.setEnabled(p);
		txtNomC.setEnabled(p);
		txtDesC.setEnabled(p);
		//botones categoria
		btnAgregarC.setEnabled(p);
		btnListarC.setEnabled(p);
		btnBuscarC.setEnabled(p);
		btnModificarC.setEnabled(p);
		btnEliminarC.setEnabled(p);
	}
	
	private void cargarProductoTabla() {

	    DefaultTableModel modelo =
	            (DefaultTableModel)
	            table_1.getModel();

	    modelo.setRowCount(0);

	    ArrayList<Producto> lista =
	            new ArrayProducto()
	            .ListarProducto();
	    
	    if (lista.isEmpty()) {
	        return;
	    }

	    for(Producto p : lista) {

	        modelo.addRow(
	                new Object[] {
	                        p.getId(),
	                        p.getNombre(),
	                        p.getPrinAct(),
	                        p.getMarca(),
	                        p.getLab(),
	                        p.getPresentacion(),
	                        p.getPrecio(),
	                        p.getCategoria().getNombre(),
	                        p.isRequiereReceta(),
	                        p.isActivo()
	                }
	        );
	    }
	}
	
	protected void do_btnAgregarP_actionPerformed(ActionEvent e) { //agregar producto
		if (btnAgregarP.getText().equals("Agregar")) {
			habilitarComp(false);
			//campos producto
			txtNomP.setEnabled(true);
			txtPrinActP.setEnabled(true);
			txtMarcaP.setEnabled(true);
			txtLabP.setEnabled(true);
			txtPresP.setEnabled(true);
			txtPreP.setEnabled(true);
			cboCategoria.setEnabled(true);
			cboReqRec.setEnabled(true);
			cboActP.setEnabled(true);
			btnAgregarP.setEnabled(true);
			btnAgregarP.setText("Confirmar");
		}
		else {
			Producto pro = new Producto();
			
			pro.setNombre(txtNomP.getText());
			pro.setPrinAct(txtPrinActP.getText());
			pro.setMarca(txtMarcaP.getText());
			pro.setLab(txtLabP.getText());
			pro.setPresentacion(txtPresP.getText());
			pro.setPrecio(Double.parseDouble(txtPreP.getText()));
			
			//verificacion de categoria
			if (cboCategoria.getItemCount() == 0) {
			    JOptionPane.showMessageDialog(
			        this,
			        "No hay categorías registradas. Registre una categoría primero."
			    );
			    return;
			}

			if (cboCategoria.getSelectedIndex() == -1) {
			    JOptionPane.showMessageDialog(
			        this,
			        "Seleccione una categoría."
			    );
			    return;
			}
			
			//obtener categoria
			String nombreCat =
				    cboCategoria.getSelectedItem().toString();

			Categoria cat = new ArrayCategoria().ConsultarCategoriaNombre(nombreCat);

			pro.setCategoria(cat);
			
			//datos bolleanos
			pro.setRequiereReceta(
				    Boolean.parseBoolean(
				        cboReqRec.getSelectedItem().toString()
				    )
			);

			pro.setActivo(
				    Boolean.parseBoolean(
				        cboActP.getSelectedItem().toString()
				    )
			);
			
			int filas =
				    new ArrayProducto()
				        .AgregarProducto(pro);
			
			if(filas > 0) {
			    JOptionPane.showMessageDialog(
			        this,
			        "Producto agregado correctamente."
			    );
			}
			//
			cargarProductoTabla();
			habilitarComp(true);
			btnAgregarP.setText("Agregar");
			limpiarCampos();
		}
	}
	
	private void cargarCategoriaTabla() {
		DefaultTableModel modelo =
		        (DefaultTableModel) table.getModel();

		modelo.setRowCount(0);
		
		ArrayList<Categoria> lista =
		        new ArrayCategoria().ListarCategoria();
		
		if (lista.isEmpty()) {
	        return;
	    }
		
		for(Categoria c : lista) {

	        modelo.addRow(new Object[] {
	            c.getId(),
	            c.getNombre(),
	        });
	    }
	}
	
	private void cargarCategoriasCombo() {

	    cboCategoria.removeAllItems();

	    ArrayList<Categoria> lista =
	            new ArrayCategoria().ListarCategoria();
	    
	    if (lista.isEmpty()) {
	        return;
	    }

	    for(Categoria c : lista) {
	        cboCategoria.addItem(c.getNombre());
	    }
	}
	
	protected void do_btnAgregarC_actionPerformed(ActionEvent e) { //agregar categoria
		if (btnAgregarC.getText().equals("Agregar")) {
			habilitarComp(false);
			//campos categoria
			txtNomC.setEnabled(true);
			txtDesC.setEnabled(true);
			btnAgregarC.setEnabled(true);
			txtNomC.setEditable(true);
			btnAgregarC.setText("Confirmar");
		}
		else {
			//funcion
			Categoria cate = new Categoria();
			
			cate.setNombre(txtNomC.getText());
			cate.setDescripcion(txtDesC.getText());
			
			int filas = new ArrayCategoria().AgregarCategoria(cate);

		    if(filas > 0) {
		    	JOptionPane.showMessageDialog(
			            this,
			            "Categoria agregada correctamente"
			        );
		    }
			
			//revirtiendo estado
			habilitarComp(true);
			btnAgregarC.setText("Agregar");
			limpiarCampos();
			cargarCategoriaTabla();
		}
	}
	
	
	protected void do_btnModificarC_actionPerformed(ActionEvent e) {
		if (btnModificarC.getText().equals("Modificar")) {
			habilitarComp(false);
			//campos categoria
			txtNomC.setEnabled(true);
			txtDesC.setEnabled(true);
			btnModificarC.setEnabled(true);
			txtNomC.setEditable(true);
			btnModificarC.setText("Confirmar");
		}
		else {
			//funcion
			Categoria cate = new Categoria();

			cate.setId(idSeleccionado);
			cate.setNombre(txtNomC.getText());
			cate.setDescripcion(txtDesC.getText());
			
			//test
			System.out.println("ID: " + idSeleccionado);

			int filas = new ArrayCategoria().EditarCategoria(cate);

			if(filas > 0) {
			    JOptionPane.showMessageDialog(
			        this,
			        "Categoria actualizada correctamente"
			    );
			}
			//revirtiendo estado
			habilitarComp(true);
			btnModificarC.setText("Modificar");
			limpiarCampos();
			cargarCategoriaTabla();
		}
	}
	protected void do_btnBuscarC_actionPerformed(ActionEvent e) {
		String nom = txtBuscarC.getText();
		
		Categoria cate = new ArrayCategoria().ConsultarCategoriaNombre(nom);
		
		DefaultTableModel modelo = (DefaultTableModel)table.getModel();
		modelo.setRowCount(0);
		
		if(cate != null) {

		    modelo.addRow(new Object[] {
		        cate.getId(),
		        cate.getNombre()
		    });
		    
		    txtBuscarC.setText("");
		}
		else {

		    JOptionPane.showMessageDialog(
		        this,
		        "No se encontró una categoria con ese nombre"
		    );

		}
	}
	protected void do_btnListarC_actionPerformed(ActionEvent e) {
		cargarCategoriaTabla();
	}
	protected void do_btnEliminarC_actionPerformed(ActionEvent e) {
		if(btnEliminarC.getText().equals("Eliminar")) {
			//confirmacion de objeto
			if(nombreCatSeleccionado == null) {

	            JOptionPane.showMessageDialog(
	                this,
	                "Seleccione primero una categoria de la tabla."
	            );

	            return;
	        }
			//mensaje de advertencia
			JOptionPane.showMessageDialog(
		            this,
		            "Esta opcion 'BORRARA' permanentemente la categoria de la base de datos,"
		            + "\nse recomienda evitar la elminacion de elementos de la base de datos a menos que sea necesario."
		            + "\nPara confirmar la eliminacion escriba nuevamente el nombre de la categoria."
		            + "\nPara cancelarla solo deje el nombre en blanco o si no ha escrito nada presione confirmar."
		        );
			//preparar confirmar
			habilitarComp(false);
			btnEliminarC.setText("Confirmar");
			btnEliminarC.setEnabled(true);
			txtNomC.setEnabled(true);
			txtNomC.setText("");
		} else {
			String nombre =
		    txtNomC.getText().trim();
		        
		    System.out.println("Nombre escrito: " + nombre);
		    System.out.println("Nombre seleccionado: " + nombreCatSeleccionado);

		    //verificacion de campo no vacio
		    if(nombre.isEmpty()) {

		    JOptionPane.showMessageDialog(
		                this,
		                "Eliminacion cancelada."
		            );

		    }
		  //verificacion del nombre
		    else if(!nombre.equals(nombreCatSeleccionado)) {

		            JOptionPane.showMessageDialog(
		                this,
		                "El nombre no coincide con la categoria seleccionado."
		            );

		    }
		    else {
		    	int filas =
		                new ArrayCategoria().EliminarCategoria(nombre);
		    	
		    	if(filas > 0) {
		    		JOptionPane.showMessageDialog(
		                    this,
		                    "Categoria eliminado correctamente."
		                );
		    		
		    		limpiarCampos();
	                cargarCategoriaTabla();
	                
	                nombreCatSeleccionado = null;
	                idSeleccionado = 0;
		    	}
		    	// ===>>> AQUÍ AGREGAMOS EL CAMBIO <<<===
		    	else if (filas == -1) {
		    		JOptionPane.showMessageDialog(
		                    this,
		                    "No se puede eliminar la categoría porque hay productos registrados en ella.\n"
		                    + "Primero cambie la categoría de esos productos o elimínelos.",
		                    "Error al eliminar",
		                    JOptionPane.ERROR_MESSAGE
		                );
		    	}
		    	else {
		    		JOptionPane.showMessageDialog(
		                    this,
		                    "No se pudo eliminar la categoría. Es posible que ya no exista."
		                );
		    	}
		    }
			//revirtiendo estado
			btnEliminarC.setText("Eliminar");
	        txtBuscarC.setText("");
	        habilitarComp(true);
		}
	}
	protected void do_btnListarP_actionPerformed(ActionEvent e) {
		cargarProductoTabla();
	}
	protected void do_btnBuscarP_actionPerformed(ActionEvent e) {
		String nombre = txtBuscarP.getText().trim();

	    if (nombre.isEmpty()) {
	        JOptionPane.showMessageDialog(
	                this,
	                "Ingrese un nombre de producto."
	        );
	        txtBuscarP.requestFocus();
	        return;
	    }

	    ArrayList<Producto> lista =
	            new ArrayProducto()
	            .BuscarProductoNombre(nombre);

	    if (lista.isEmpty()) {
	        JOptionPane.showMessageDialog(
	                this,
	                "No se encontraron productos."
	        );
	        return;
	    }

	    DefaultTableModel modelo =
	            (DefaultTableModel) table_1.getModel();

	    modelo.setRowCount(0);

	    for (Producto p : lista) {
	        modelo.addRow(new Object[] {
	                p.getId(),
	                p.getNombre(),
	                p.getPrinAct(),
	                p.getMarca(),
	                p.getLab(),
	                p.getPresentacion(),
	                p.getPrecio(),
	                p.getCategoria().getNombre(),
	                p.isRequiereReceta(),
	                p.isActivo()
	        });
	    }
	}
	protected void do_btnModificarP_actionPerformed(ActionEvent e) {
		if (btnModificarP.getText().equals("Modificar")) {
	        // Validar primero si seleccionó algo de la tabla
	        if (txtIdP.getText().isEmpty()) {
	            JOptionPane.showMessageDialog(this, "Seleccione primero un producto de la tabla.");
	            return;
	        }

	        habilitarComp(false);
	        // Habilitar campos del producto para edición
	        txtNomP.setEnabled(true);
	        txtPrinActP.setEnabled(true);
	        txtMarcaP.setEnabled(true);
	        txtLabP.setEnabled(true);
	        txtPresP.setEnabled(true);
	        txtPreP.setEnabled(true);
	        cboCategoria.setEnabled(true);
	        cboReqRec.setEnabled(true);
	        cboActP.setEnabled(true);
	        
	        btnModificarP.setEnabled(true);
	        btnModificarP.setText("Confirmar");
	    }
	    else {
	        // Validación de existencia de categorías antes de mapear
	        if (cboCategoria.getSelectedIndex() == -1) {
	            JOptionPane.showMessageDialog(this, "Seleccione una categoría válida.");
	            return;
	        }

	        // Crear el objeto Producto cargando los datos modificados
	        Producto pro = new Producto();
	        
	        pro.setId(idProductoSeleccionado); // Usamos tu variable global ya guardada en el MouseListener
	        pro.setNombre(txtNomP.getText());
	        pro.setPrinAct(txtPrinActP.getText());
	        pro.setMarca(txtMarcaP.getText());
	        pro.setLab(txtLabP.getText());
	        pro.setPresentacion(txtPresP.getText());
	        pro.setPrecio(Double.parseDouble(txtPreP.getText()));
	        
	        // Obtener objeto Categoría a través de su nombre seleccionado en el combo
	        String nombreCat = cboCategoria.getSelectedItem().toString();
	        Categoria cat = new ArrayCategoria().ConsultarCategoriaNombre(nombreCat);
	        pro.setCategoria(cat);
	        
	        // Datos booleanos desde los ComboBox
	        pro.setRequiereReceta(Boolean.parseBoolean(cboReqRec.getSelectedItem().toString()));
	        pro.setActivo(Boolean.parseBoolean(cboActP.getSelectedItem().toString()));
	        
	        // Ejecución en la base de datos
	        int filas = new ArrayProducto().EditarProducto(pro);

	        if (filas > 0) {
	            JOptionPane.showMessageDialog(this, "Producto actualizado correctamente.");
	        } else {
	            JOptionPane.showMessageDialog(this, "No se pudo actualizar el producto.");
	        }
	        
	        // Revertir estados visuales e interfaces (Idéntico a Categorías)
	        habilitarComp(true);
	        btnModificarP.setText("Modificar");
	        limpiarCampos();
	        cargarProductoTabla();
	    }
	}
	protected void do_btnEliminarP_actionPerformed(ActionEvent e) {
		// 1. Validar de inmediato si seleccionó un producto de la tabla
	    if (txtIdP.getText().isEmpty()) {
	        JOptionPane.showMessageDialog(this, "Seleccione primero un producto de la tabla.");
	        return;
	    }

	    // 2. Ejecutar directamente la deshabilitación usando la variable global
	    int filas = new ArrayProducto().DeshabilitarProducto(idProductoSeleccionado);

	    // 3. Mostrar mensaje de cumplimiento o error
	    if (filas > 0) {
	        JOptionPane.showMessageDialog(this, "Producto deshabilitado correctamente.");
	        limpiarCampos();
	        cargarProductoTabla();
	    } else {
	        JOptionPane.showMessageDialog(this, "No se logró deshabilitar el producto.");
	    }
	}
	protected void do_btnRegresar_actionPerformed(ActionEvent e) {
		Menu ventanaMenu = new Menu();
	    ventanaMenu.setVisible(true);
	    
	    this.dispose();
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == lblNewLabel_17) {
			do_lblNewLabel_17_mouseClicked(e);
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
	
	protected void do_lblNewLabel_17_mouseClicked(MouseEvent e) {
		JOptionPane.showMessageDialog(
			    this,
			    "Esta ventana permite al usuario registrar categorias y productos para poder utilizarlos"
			    + "\nen el registro de compras como en el de ventas, aunque este ultimo necesitara lotes."
			    + "\n"
			    + "\nLa seccion de producto y categoria estan separadas y funcionan independientemente con"
			    + "\nsus tablas, campos y botones por lo que pueden ser operados independientemente si se"
			    + "\nrequiere."
			    + "\n"
			    + "\nSi se requiere registrar un producto pero su categoria no esta disponible, es porque"
			    + "\nla categoria necesita estar registrada previamente, asi que debera registrar la"
			    + "\ncategoria desde su seccion en la ventana, una vez realizado podra seleccionarla"
			    + "\n para registrar su producto con esta categoria nueva.",
			    "Informacion.",
			    JOptionPane.INFORMATION_MESSAGE
			);
	}
}
