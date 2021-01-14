package com.salaodebeleza.view.cliente;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.PatternSyntaxException;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableRowSorter;

import com.salaodebeleza.model.modells.Cliente;
import com.salaodebeleza.model.service.ClienteService;
import com.salaodebeleza.view.cliente.BuscaCliente;
import com.salaodebeleza.view.cliente.TabelaClienteModel;

public class BuscaCliente extends JDialog {

	private static final int CODIGO = 0;
	private static final int NOME = 1;

	private final JPanel contentPanel = new JPanel();
	private JLabel lblPesquisaCliente;
	private JTextField textField;
	private JScrollPane scrollPane;
	private JTable tableCliente;

	private TabelaClienteModel tabelaClienteModel;
	private TableRowSorter<TabelaClienteModel> sortTabelaCliente;
	private List<Cliente> listaCliente;

	private Integer codigoCliente;
	private String nomeCliente;
	private boolean selectCliente;
	
	private JButton btnInserirCliente;


	public BuscaCliente(JFrame frame, boolean modal) {
		super(frame, modal);
		initComponents();
		setResizable(false);
		iniciarDados();
		
		
	}
	
	private void iniciarDados(){
		listaCliente = new ArrayList<Cliente>();
	}
	

	private void initComponents() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 818, 511);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		lblPesquisaCliente = new JLabel("Pesquisar Cliente:");

		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				 String filtro = textField.getText();
	             filtraNomeCliente(filtro);
			}

			
		});
		
		textField.setColumns(10);

		scrollPane = new JScrollPane();

		btnInserirCliente = new JButton("Cadastrar Cliente");
		btnInserirCliente.setMnemonic(KeyEvent.VK_C);
		btnInserirCliente.setIcon(new ImageIcon(
				BuscaCliente.class.getResource("/com/salaodebeleza/estrutura/imagens/application_form_add.png")));
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPanel.createSequentialGroup().addGap(38)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 744, Short.MAX_VALUE)
								.addComponent(btnInserirCliente).addGroup(Alignment.TRAILING,
										gl_contentPanel.createSequentialGroup().addComponent(lblPesquisaCliente)
												.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(textField,
														GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)))
						.addContainerGap()));
		gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPanel
				.createSequentialGroup().addGap(38)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblPesquisaCliente)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(18).addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 283, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnInserirCliente)
				.addContainerGap(34, Short.MAX_VALUE)));

		tableCliente = new JTable();
	    tabelaClienteModel = new TabelaClienteModel();
		
		tabelaClienteModel.setListaCliente(carregarListaCliente());
		tableCliente.setModel(tabelaClienteModel);
		scrollPane.setViewportView(tableCliente);
	
		tableCliente.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		sortTabelaCliente = new TableRowSorter<TabelaClienteModel>(tabelaClienteModel);
		tableCliente.setRowSorter(sortTabelaCliente);
		tableCliente.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
//		tableCliente.getColumnModel().getColumn(CODIGO).setWidth(11);
//		tableCliente.getColumnModel().getColumn(NOME).setWidth(100);
//		
		
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						selecionaCliente();
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setSelectCliente(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}

	}

	protected void selecionaCliente() {
		if ( tableCliente.getSelectedRow() != -1 && 
			 tableCliente.getSelectedRow() < tabelaClienteModel.getRowCount() ) {
			 setCodigoCliente(Integer.valueOf(tableCliente.getValueAt(tableCliente.getSelectedRow(), CODIGO).toString()));
			 setNomeCliente(tableCliente.getValueAt(tableCliente.getSelectedRow(), NOME).toString());
			 setSelectCliente(true);
			 dispose();
		} else {
			setSelectCliente(false);	
		}
		
	}

	private List<Cliente> carregarListaCliente() {
		ClienteService clienteService = new ClienteService();
		return clienteService.findAll();
	}
	
	
	private void filtraNomeCliente(String filtro) {
		RowFilter<TabelaClienteModel, Object> rowFilter = null;
		try {
			rowFilter = RowFilter.regexFilter(filtro);
		} catch(PatternSyntaxException e) {
			return;
		}
		sortTabelaCliente.setRowFilter(rowFilter);
		
	}

	public Integer getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(Integer codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	
	public boolean isSelectCliente() {
		return selectCliente;
	}

	public void setSelectCliente(boolean selectCliente) {
		this.selectCliente = selectCliente;
	}

}
