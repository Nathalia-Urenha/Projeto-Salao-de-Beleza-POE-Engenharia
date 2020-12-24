package com.salaodebeleza.view.usuario;

import java.awt.BorderLayout;
import java.awt.EventQueue;
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

import com.salaodebeleza.model.modells.Usuario;
import com.salaodebeleza.model.service.UsuarioService;
import com.salaodebeleza.view.usuario.BuscaCabeleireiro;

public class BuscaCabeleireiro extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6096555850297096985L;
	private static final int CODIGO = 0;
	private static final int NOME = 1;

	private final JPanel contentPanel = new JPanel();
	private JLabel lblPesquisaUsuario;
	private JTextField textField;
	private JScrollPane scrollPane;
	private JTable tableUsuario;

	private TabelaCabeleireiroModel tabelaCabeleireiroModel;
	private TableRowSorter<TabelaCabeleireiroModel> sortTabelaCabeleireiro;
	private List<Usuario> listaUsuario;

	private Integer codigoUsuario;
	private String nomeUsuario;
	private boolean selectUsuario;
	
	private JButton btnInserirUsuario;


	public BuscaCabeleireiro(JFrame frame, boolean modal) {
		super(frame, modal);
		initComponents();
		setResizable(false);
		iniciarDados();
		
		
	}
	
	private void iniciarDados(){
		listaUsuario = new ArrayList<Usuario>();
	}
	

	private void initComponents() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 818, 511);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		lblPesquisaUsuario = new JLabel("Pesquisar Usuario:");

		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				 String filtro = textField.getText();
	             filtraNomeUsuario(filtro);
			}

			
		});
		
		textField.setColumns(10);

		scrollPane = new JScrollPane();

		btnInserirUsuario = new JButton("Cadastrar Usuario");
		btnInserirUsuario.setMnemonic(KeyEvent.VK_C);
		btnInserirUsuario.setIcon(new ImageIcon(
				BuscaCabeleireiro.class.getResource("/com/salaodebeleza/estrutura/imagens/application_form_add.png")));
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPanel.createSequentialGroup().addGap(38)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 744, Short.MAX_VALUE)
								.addComponent(btnInserirUsuario).addGroup(Alignment.TRAILING,
										gl_contentPanel.createSequentialGroup().addComponent(lblPesquisaUsuario)
												.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(textField,
														GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)))
						.addContainerGap()));
		gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPanel
				.createSequentialGroup().addGap(38)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblPesquisaUsuario)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(18).addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 283, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnInserirUsuario)
				.addContainerGap(34, Short.MAX_VALUE)));

		tableUsuario = new JTable();
	    tabelaCabeleireiroModel = new TabelaCabeleireiroModel();
		
		tabelaCabeleireiroModel.setListaUsuario(carregarListaUsuario());
		tableUsuario.setModel(tabelaCabeleireiroModel);
		scrollPane.setViewportView(tableUsuario);
	
		tableUsuario.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		sortTabelaCabeleireiro = new TableRowSorter<TabelaCabeleireiroModel>(tabelaCabeleireiroModel);
		tableUsuario.setRowSorter(sortTabelaCabeleireiro);
		tableUsuario.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
//		tableUsuario.getColumnModel().getColumn(CODIGO).setWidth(11);
//		tableUsuario.getColumnModel().getColumn(NOME).setWidth(100);
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
						selecionaUsuario();
						
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
						setSelectUsuario(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}

	}

	protected void selecionaUsuario() {
		if ( tableUsuario.getSelectedRow() != -1 && 
			 tableUsuario.getSelectedRow() < tabelaCabeleireiroModel.getRowCount() ) {
			 setCodigoUsuario(Integer.valueOf(tableUsuario.getValueAt(tableUsuario.getSelectedRow(), CODIGO).toString()));
			 setNomeUsuario(tableUsuario.getValueAt(tableUsuario.getSelectedRow(), NOME).toString());
			 setSelectUsuario(true);
			 dispose();
		} else {
			setSelectUsuario(false);	
		}
		
	}

	private List<Usuario> carregarListaUsuario() {
		UsuarioService usuarioService = new UsuarioService();
		return usuarioService.findAll();
	}
	
	
	private void filtraNomeUsuario(String filtro) {
		RowFilter<TabelaCabeleireiroModel, Object> rowFilter = null;
		try {
			rowFilter = RowFilter.regexFilter(filtro);
		} catch(PatternSyntaxException e) {
			return;
		}
		sortTabelaCabeleireiro.setRowFilter(rowFilter);
		
	}

	public Integer getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(Integer codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	
	public boolean isSelectUsuario() {
		return selectUsuario;
	}

	public void setSelectUsuario(boolean selectUsuario) {
		this.selectUsuario = selectUsuario;
	}


}
