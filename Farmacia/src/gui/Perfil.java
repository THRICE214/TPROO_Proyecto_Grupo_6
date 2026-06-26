package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import arrayList.ArrayUsuario;
import clase.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JTable;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Perfil extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JTextField txtNom;
	private JComboBox cboTipDoc;
	private JTextField txtMail;
	private JTextField txtPass;
	private JTextField txtDocumento;
	private JTextField txtDireccion;
	private JTextField txtTelef;
	private JButton btnAgr;
	private JButton btnSalir;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel_7;
	private JButton btnMod;
	private JLabel lblNewLabel_8;
	private JTable table;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Perfil frame = new Perfil();
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
	public Perfil() {
		setTitle("Administrar Usuarios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 870, 438);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(211, 211, 211));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel = new JLabel("Nombre:");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel.setBounds(10, 22, 46, 14);
			contentPane.add(lblNewLabel);
		}
		{
			lblNewLabel_1 = new JLabel("E-mail:");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_1.setBounds(10, 61, 82, 14);
			contentPane.add(lblNewLabel_1);
		}
		{
			lblNewLabel_2 = new JLabel("Password:");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_2.setBounds(10, 99, 113, 14);
			contentPane.add(lblNewLabel_2);
		}
		{
			lblNewLabel_3 = new JLabel("Tipo de Documento:");
			lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_3.setBounds(10, 137, 102, 14);
			contentPane.add(lblNewLabel_3);
		}
		{
			lblNewLabel_4 = new JLabel("Documento:");
			lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_4.setBounds(10, 176, 82, 14);
			contentPane.add(lblNewLabel_4);
		}
		{
			lblNewLabel_5 = new JLabel("Direccion:");
			lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_5.setBounds(10, 214, 82, 14);
			contentPane.add(lblNewLabel_5);
		}
		{
			lblNewLabel_6 = new JLabel("Telefono:");
			lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_6.setBounds(10, 254, 46, 14);
			contentPane.add(lblNewLabel_6);
		}
		{
			txtNom = new JTextField();
			txtNom.setBounds(122, 19, 185, 20);
			contentPane.add(txtNom);
			txtNom.setColumns(10);
		}
		{
			cboTipDoc = new JComboBox();
			cboTipDoc.setBounds(122, 134, 185, 20);
			contentPane.add(cboTipDoc);
			
			//campos
			cboTipDoc.addItem("DNI");
			cboTipDoc.addItem("CE");
			cboTipDoc.addItem("Pasaporte");
		}
		{
			txtMail = new JTextField();
			txtMail.setColumns(10);
			txtMail.setBounds(122, 58, 185, 20);
			contentPane.add(txtMail);
		}
		{
			txtPass = new JTextField();
			txtPass.setColumns(10);
			txtPass.setBounds(122, 96, 185, 20);
			contentPane.add(txtPass);
		}
		{
			txtDocumento = new JTextField();
			txtDocumento.setColumns(10);
			txtDocumento.setBounds(122, 173, 185, 20);
			contentPane.add(txtDocumento);
		}
		{
			txtDireccion = new JTextField();
			txtDireccion.setColumns(10);
			txtDireccion.setBounds(122, 211, 185, 20);
			contentPane.add(txtDireccion);
		}
		{
			txtTelef = new JTextField();
			txtTelef.setColumns(10);
			txtTelef.setBounds(122, 251, 185, 20);
			contentPane.add(txtTelef);
		}
		{
			btnAgr = new JButton("Agregar");
			btnAgr.addActionListener(this);
			btnAgr.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnAgr.setBounds(325, 365, 89, 23);
			contentPane.add(btnAgr);
		}
		{
			btnSalir = new JButton("Salir");
			btnSalir.addActionListener(this);
			btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnSalir.setBounds(755, 365, 89, 23);
			contentPane.add(btnSalir);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(327, 11, 517, 337);
			contentPane.add(scrollPane);
			{
				table = new JTable();
				scrollPane.setViewportView(table);
			}
			//creacion de columnas
			table.setModel(new DefaultTableModel(
				    new Object[][] {},
				    new String[] {
				        "ID",
				        "Nombre",
				        "Email",
				        "Password",
				        "Tipo de Documento",
				        "Documento",
				        "Direccion",
				        "Telefono",
				        "Estado",
				        "Admin"
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
			//ajuste de tamaños
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			table.getColumnModel().getColumn(1).setPreferredWidth(140);
			table.getColumnModel().getColumn(2).setPreferredWidth(140);
			table.getColumnModel().getColumn(6).setPreferredWidth(140);
			table.getColumnModel().getColumn(7).setPreferredWidth(140);
			table.setRowHeight(25);
		}
		{
			lblNewLabel_7 = new JLabel("Estado:");
			lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_7.setBounds(10, 291, 82, 14);
			contentPane.add(lblNewLabel_7);
		}
		{
			btnMod = new JButton("Modificar");
			btnMod.addActionListener(this);
			btnMod.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnMod.setBounds(547, 365, 93, 23);
			contentPane.add(btnMod);
		}
		{
			lblNewLabel_8 = new JLabel("Administrador:");
			lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_8.setBounds(10, 328, 82, 14);
			contentPane.add(lblNewLabel_8);
		}
		{
			btnBus = new JButton("Buscar por Doc.");
			btnBus.addActionListener(this);
			btnBus.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnBus.setBounds(10, 365, 113, 23);
			contentPane.add(btnBus);
		}
		{
			btnEli = new JButton("Eliminar");
			btnEli.addActionListener(this);
			btnEli.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnEli.setBounds(650, 365, 95, 23);
			contentPane.add(btnEli);
		}
		{
			cboEstado = new JComboBox();
			cboEstado.setBounds(122, 287, 185, 20);
			contentPane.add(cboEstado);
			
			//campos
			cboEstado.addItem("true");
			cboEstado.addItem("false");
		}
		{
			cboAdmin = new JComboBox();
			cboAdmin.setBounds(122, 324, 185, 20);
			contentPane.add(cboAdmin);
			
			//campos
			cboAdmin.addItem("true");
			cboAdmin.addItem("false");
		}
		{
			btnMosLis = new JButton("Mostrar Lista");
			btnMosLis.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnMosLis.addActionListener(this);
			btnMosLis.setBounds(424, 365, 113, 23);
			contentPane.add(btnMosLis);
		}
		{
			txtBuscar = new JTextField();
			txtBuscar.setBounds(133, 366, 174, 20);
			contentPane.add(txtBuscar);
			txtBuscar.setColumns(10);
		}
		
		cargarUsuariosTabla();
	}
	
	
	private JButton btnBus;
	private JButton btnEli;
	private JComboBox cboEstado;
	private JComboBox cboAdmin;
	private JButton btnMosLis;
	private JTextField txtBuscar;
	
	//variable global
	private int idSeleccionado;
	private String documentoSeleccionado;
	
	//funcion para listar de la DB
	private void cargarUsuariosTabla() {

	    DefaultTableModel modelo =
	        (DefaultTableModel) table.getModel();

	    modelo.setRowCount(0);

	    ArrayList<Usuario> lista =
	        new ArrayUsuario().ListarUsuario();

	    for(Usuario u : lista) {

	        modelo.addRow(new Object[] {
	            u.getId(),
	            u.getNombre(),
	            u.getEmail(),
	            u.getPassword(),
	            u.getTipoDocumento(),
	            u.getDocumento(),
	            u.getDireccion(),
	            u.getTelefono(),
	            u.isEstado(),
	            u.isAdmin()
	        });
	    }
	}
	
	//funcion para obtener datos de la tabla a los campos
	private void cargarDatosSeleccionados() {

	    int fila = table.getSelectedRow();

	    if(fila == -1)
	        return;

	    // Guardar el ID de la fila seleccionada
	    idSeleccionado = Integer.parseInt(
	        table.getValueAt(fila, 0).toString()
	    );
	    
	    documentoSeleccionado =
	    	    table.getValueAt(fila, 5).toString();

	    System.out.println("ID seleccionado: " + idSeleccionado);
	    System.out.println("Documento seleccionado: " + documentoSeleccionado);

	    txtNom.setText(table.getValueAt(fila, 1).toString());
	    txtMail.setText(table.getValueAt(fila, 2).toString());
	    txtPass.setText(table.getValueAt(fila, 3).toString());

	    cboTipDoc.setSelectedItem(
	        table.getValueAt(fila, 4).toString()
	    );

	    txtDocumento.setText(table.getValueAt(fila, 5).toString());
	    txtDireccion.setText(table.getValueAt(fila, 6).toString());
	    txtTelef.setText(table.getValueAt(fila, 7).toString());

	    cboEstado.setSelectedItem(
	        table.getValueAt(fila, 8).toString()
	    );

	    cboAdmin.setSelectedItem(
	        table.getValueAt(fila, 9).toString()
	    );
	}
	
	private void limpiarCampos() {

	    txtNom.setText("");
	    txtMail.setText("");
	    txtPass.setText("");
	    txtDocumento.setText("");
	    txtDireccion.setText("");
	    txtTelef.setText("");

	    cboTipDoc.setSelectedIndex(0);
	    cboEstado.setSelectedIndex(0);
	    cboAdmin.setSelectedIndex(0);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSalir) {
			do_btnSalir_actionPerformed(e);
		}
		if (e.getSource() == btnEli) {
			do_btnEli_actionPerformed(e);
		}
		if (e.getSource() == btnBus) {
			do_btnBus_actionPerformed(e);
		}
		if (e.getSource() == btnMosLis) {
			do_btnMosLis_actionPerformed(e);
		}
		if (e.getSource() == btnAgr) {
			do_btnAgr_actionPerformed(e);
		}
		if (e.getSource() == btnMod) {
			do_btnMod_actionPerformed(e);
		}
	}
	
	protected void do_btnMod_actionPerformed(ActionEvent e) {
		Usuario usu = new Usuario();

		usu.setId(idSeleccionado);
		usu.setNombre(txtNom.getText());
		usu.setEmail(txtMail.getText());
		usu.setPassword(txtPass.getText());

		usu.setTipoDocumento(
		    cboTipDoc.getSelectedItem().toString()
		);

		usu.setDocumento(txtDocumento.getText());
		usu.setDireccion(txtDireccion.getText());
		usu.setTelefono(txtTelef.getText());

		usu.setEstado(
		    Boolean.parseBoolean(cboEstado.getSelectedItem().toString())
		);

		usu.setAdmin(
		    Boolean.parseBoolean(cboAdmin.getSelectedItem().toString())
		);
		
		//test
		System.out.println("ID: " + idSeleccionado);

		int filas = new ArrayUsuario().EditarUsuario(usu);

		if(filas > 0) {
		    JOptionPane.showMessageDialog(
		        this,
		        "Usuario actualizado correctamente"
		    );
		}
		
		cargarUsuariosTabla();
	}
	
	protected void do_btnAgr_actionPerformed(ActionEvent e) {
		Usuario usu = new Usuario();

	    usu.setNombre(txtNom.getText());
	    usu.setEmail(txtMail.getText());
	    usu.setPassword(txtPass.getText());

	    usu.setTipoDocumento(
	        cboTipDoc.getSelectedItem().toString()
	    );

	    usu.setDocumento(txtDocumento.getText());
	    usu.setDireccion(txtDireccion.getText());
	    usu.setTelefono(txtTelef.getText());

	    usu.setEstado(
	        Boolean.parseBoolean(
	            cboEstado.getSelectedItem().toString()
	        )
	    );

	    usu.setAdmin(
	        Boolean.parseBoolean(
	            cboAdmin.getSelectedItem().toString()
	        )
	    );

	    int filas = new ArrayUsuario().AgregarUsuario(usu);

	    if(filas > 0) {

	        JOptionPane.showMessageDialog(
	            this,
	            "Usuario agregado correctamente"
	        );

	        limpiarCampos();
	        cargarUsuariosTabla();
	    }
	}
	
	protected void do_btnMosLis_actionPerformed(ActionEvent e) {
		cargarUsuariosTabla();
	}
	
	protected void do_btnBus_actionPerformed(ActionEvent e) {
		String dni = txtBuscar.getText();

		Usuario usu = new ArrayUsuario().ConsultarUsuarioDNI(dni);
		
		DefaultTableModel modelo = (DefaultTableModel)table.getModel();
		modelo.setRowCount(0);
			
		if(usu != null) {

		    modelo.addRow(new Object[] {
		        usu.getId(),
		        usu.getNombre(),
		        usu.getEmail(),
		        usu.getPassword(),
		        usu.getTipoDocumento(),
		        usu.getDocumento(),
		        usu.getDireccion(),
		        usu.getTelefono(),
		        usu.isEstado(),
		        usu.isAdmin()
		    });

		}
		else {

		    JOptionPane.showMessageDialog(
		        this,
		        "No se encontró un usuario con ese DNI"
		    );

		}
	}
	protected void do_btnEli_actionPerformed(ActionEvent e) {
		if(btnEli.getText().equals("Eliminar")) {

			if(documentoSeleccionado == null) {

	            JOptionPane.showMessageDialog(
	                this,
	                "Seleccione primero un usuario de la tabla."
	            );

	            return;
	        }
			
	        JOptionPane.showMessageDialog(
	            this,
	            "Esta opcion 'BORRARA' permanentemente al usuario de la base de datos,"
	            + "\nse recomienda cambiar el estado a 'false' (inactivo) para no perder sus datos."
	            + "\nPara confirmar la eliminacion escriba nuevamente el documento del usuario."
	            + "\nPara cancelarla solo deje el documento en blanco o si no ha escrito nada presione confirmar."
	        );

	        btnEli.setText("Confirmar");

	        btnAgr.setEnabled(false);
	        btnBus.setEnabled(false);
	        btnMod.setEnabled(false);
	        btnMosLis.setEnabled(false);
	        btnSalir.setEnabled(false);

	        txtBuscar.setEnabled(false);
	        txtDireccion.setEnabled(false);
	        txtMail.setEnabled(false);
	        txtNom.setEnabled(false);
	        txtPass.setEnabled(false);
	        txtTelef.setEnabled(false);
	        
	        cboAdmin.setEnabled(false);
	        cboEstado.setEnabled(false);
	        cboTipDoc.setEnabled(false);
	        
	        txtDocumento.setText("");
	    }
	    else {

	        String documento =
	            txtDocumento.getText().trim();
	        
	        System.out.println("Documento escrito: " + documento);
	        System.out.println("Documento seleccionado: " + documentoSeleccionado);

	        if(documento.isEmpty()) {

	            JOptionPane.showMessageDialog(
	                this,
	                "Eliminacion cancelada."
	            );

	        }
	        else if(!documento.equals(documentoSeleccionado)) {

	            JOptionPane.showMessageDialog(
	                this,
	                "El documento no coincide con el usuario seleccionado."
	            );

	        }
	        else {

	            int filas =
	                new ArrayUsuario().EliminarUsuario(documento);

	            if(filas > 0) {

	                JOptionPane.showMessageDialog(
	                    this,
	                    "Usuario eliminado correctamente."
	                );

	                limpiarCampos();
	                cargarUsuariosTabla();

	                documentoSeleccionado = null;
	                idSeleccionado = 0;
	            }
	            else {

	                JOptionPane.showMessageDialog(
	                    this,
	                    "No se encontro el usuario."
	                );
	            }
	        }

	        btnEli.setText("Eliminar");
	        txtBuscar.setText("");

	        btnAgr.setEnabled(true);
	        btnBus.setEnabled(true);
	        btnMod.setEnabled(true);
	        btnMosLis.setEnabled(true);
	        btnSalir.setEnabled(true);

	        txtBuscar.setEnabled(true);
	        txtDireccion.setEnabled(true);
	        txtMail.setEnabled(true);
	        txtNom.setEnabled(true);
	        txtPass.setEnabled(true);
	        txtTelef.setEnabled(true);
	        
	        cboAdmin.setEnabled(true);
	        cboEstado.setEnabled(true);
	        cboTipDoc.setEnabled(true);
	    }
	}
	protected void do_btnSalir_actionPerformed(ActionEvent e) {

	    int opcion = JOptionPane.showConfirmDialog(this, 
	            "¿Está seguro de que desea regresar al menú principal?", 
	            "Regresar al Menú", 
	            JOptionPane.YES_NO_OPTION, 
	            JOptionPane.QUESTION_MESSAGE);
	    
	    if (opcion == JOptionPane.YES_OPTION) {
	   
	        Menu ventanaMenu = new Menu(); 
	        ventanaMenu.setVisible(true);
	        ventanaMenu.setLocationRelativeTo(null);
	      
	        this.dispose();
	    }
	}
}
