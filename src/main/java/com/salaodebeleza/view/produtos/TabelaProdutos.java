package com.salaodebeleza.view.produtos;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.PatternSyntaxException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
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

import com.salaodebeleza.estrutura.util.VariaveisProjeto;
import com.salaodebeleza.model.modells.Produtos;
import com.salaodebeleza.model.service.ProdutosService;
import com.salaodebeleza.view.cliente.ClienteGUI;


public class TabelaProdutos extends JInternalFrame {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8495752025286824911L;
	private JPanel contentPane;
	private JTable tabelaProdutos;
	private JTextField textFielPesquisar;
	private JScrollPane scrollPane;
	private JButton btnIncluir;
	private JButton btnAlterar;
	private JButton btnExcluir;
	private JButton btnSair;
	private JPanel panel; 
	private JLabel lblPagina;
	private JComboBox<String> comboBox;
	private JLabel lblPesquisar;
	private JButton btnPesquisar;
	private JLabel lblPaginaDe;
	private JLabel lblInicio;
	private JLabel lblt;
	private JLabel lblfinal;
	private JButton btnPrimeiro; 
	private JButton btnAnterior;
	private JButton btnProximo;
	private JButton btnUltimo;
	

	private static final int CODIGO = 0;
	private static final int NOME = 1;
	private static final int EMAIL = 2;
	
	private TabelaProdutosModel tabelaProdutosModel;
	private TableRowSorter<TabelaProdutosModel> sortTabelaProdutos;
	
	
	private Integer totalData = 0;
	private Integer defaultPagina = 5;
	private Integer totalPagina = 1;
	private Integer numeroPagina = 1;
	private JLabel lblde;
	private JLabel totalRegistros;
	
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TabelaProdutos frame = new TabelaProdutos();
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
	
	public TabelaProdutos() {

		initComponents();
		iniciaPaginacao();
	}
	
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 656, 438);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		scrollPane = new JScrollPane();
		
		btnIncluir = new JButton("Incluir");
		
		btnIncluir.setMnemonic(KeyEvent.VK_I);
		btnIncluir.setIcon(new ImageIcon(TabelaProdutos.class.getResource("/com/salaodebeleza/estrutura/imagens/book_add.png")));
		
		btnAlterar = new JButton("Alterar");
		
		btnAlterar.setMnemonic(KeyEvent.VK_A);
		btnAlterar.setIcon(new ImageIcon(TabelaProdutos.class.getResource("/com/salaodebeleza/estrutura/imagens/book_edit.png")));
		
		btnExcluir = new JButton("Excluir");
		
		btnExcluir.setMnemonic(KeyEvent.VK_E);
		btnExcluir.setIcon(new ImageIcon(TabelaProdutos.class.getResource("/com/salaodebeleza/estrutura/imagens/book_delete.png")));
		
		btnSair = new JButton("Sair");
		btnSair.setMnemonic(KeyEvent.VK_S);
		
		btnSair.setIcon(new ImageIcon(TabelaProdutos.class.getResource("/com/salaodebeleza/estrutura/imagens/sair.png")));
		
		panel = new JPanel();
		
		lblPagina = new JLabel("P\u00E1gina");
		
		comboBox = new JComboBox<String>();
		
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"5", "10", "15", "20"}));
		
		lblPesquisar = new JLabel("Pesquisar:");
		
		textFielPesquisar = new JTextField();
		
		textFielPesquisar.setColumns(10);
		
		btnPesquisar = new JButton("");
		
		btnPesquisar.setMnemonic(KeyEvent.VK_P);
		btnPesquisar.setToolTipText("Pesquisar produto cadastrado\r\n");
		btnPesquisar.setIcon(new ImageIcon(TabelaProdutos.class.getResource("/com/salaodebeleza/estrutura/imagens/search.png")));
		
		lblPaginaDe = new JLabel("P\u00E1gina");
		
		lblInicio = new JLabel("10");
		
		lblt = new JLabel("Total de Registros:");
		
		lblfinal = new JLabel("50");
		
		lblde = new JLabel("de");
		
		totalRegistros = new JLabel(" ");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblPaginaDe)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblPagina)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(55)
									.addComponent(panel, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblInicio)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblde)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblfinal)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblt)
							.addPreferredGap(ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
							.addComponent(totalRegistros)
							.addGap(12))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(107)
									.addComponent(btnIncluir)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnAlterar)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnExcluir)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnSair))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(64)
									.addComponent(lblPesquisar)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textFielPesquisar, GroupLayout.PREFERRED_SIZE, 314, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnPesquisar, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED, 153, Short.MAX_VALUE))
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE))
					.addGap(37))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPesquisar)
						.addComponent(textFielPesquisar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnPesquisar, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblPagina)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(totalRegistros)
						.addComponent(lblPaginaDe)
						.addComponent(lblInicio)
						.addComponent(lblde)
						.addComponent(lblfinal, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblt))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnIncluir)
						.addComponent(btnAlterar)
						.addComponent(btnExcluir)
						.addComponent(btnSair)))
		);
		
		btnPrimeiro = new JButton("");
		
		btnPrimeiro.setToolTipText("Primeiro\r\n");
		btnPrimeiro.setIcon(new ImageIcon(TabelaProdutos.class.getResource("/com/salaodebeleza/estrutura/imagens/go-first.png")));
		
		btnAnterior = new JButton("");
		
		btnAnterior.setToolTipText("Anterior");
		btnAnterior.setIcon(new ImageIcon(TabelaProdutos.class.getResource("/com/salaodebeleza/estrutura/imagens/go-previous.png")));
		
		btnProximo = new JButton("");
		
		btnProximo.setIcon(new ImageIcon(TabelaProdutos.class.getResource("/com/salaodebeleza/estrutura/imagens/go-next.png")));
		btnProximo.setToolTipText("Pr\u00F3ximo");
		
		btnUltimo = new JButton("");
		
		btnUltimo.setIcon(new ImageIcon(TabelaProdutos.class.getResource("/com/salaodebeleza/estrutura/imagens/go-last.png")));
		btnUltimo.setToolTipText("Ultimo");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addGap(18)
					.addComponent(btnPrimeiro)
					.addGap(18)
					.addComponent(btnAnterior)
					.addPreferredGap(ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
					.addComponent(btnProximo)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnUltimo)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnUltimo)
						.addComponent(btnProximo)
						.addComponent(btnPrimeiro)
						.addComponent(btnAnterior))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		tabelaProdutos = new JTable();
		scrollPane.setViewportView(tabelaProdutos);
		contentPane.setLayout(gl_contentPane);
		createEvents();
	}
	
	//EVENTOS
	private void createEvents() {
		/////////////////////ACTION PERFORMED/////////////////////////////
		btnPrimeiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numeroPagina = 1;
				iniciaPaginacao();
			}
		});
		
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (numeroPagina > 1) {
					numeroPagina = numeroPagina - 1;
					iniciaPaginacao();
				}
			}
		});
		
		btnProximo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ( numeroPagina < totalPagina ) {
					numeroPagina = numeroPagina + 1;
					iniciaPaginacao();
				}
			}
		});
		
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numeroPagina = totalPagina;
				iniciaPaginacao();
			}
		});
		
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				incluirProdutos();
				iniciaPaginacao();
			}

		});
		
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterarProdutos();
				iniciaPaginacao();
			}

		});
		
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirProduto();
				iniciaPaginacao();
			}
		});
		
		/////////////////// ITEM STATE CHANGED ////////////////////////
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				iniciaPaginacao();
			}
		});
		//////////////////////KEY//////////////////////////
		textFielPesquisar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String filtro = textFielPesquisar.getText();
				fitraNomeUsuario(filtro);
			}

		});
	}
	
	private void fitraNomeUsuario(String filtro) {
		RowFilter<TabelaProdutosModel, Object> rowFilter = null;
		try {
			rowFilter = RowFilter.regexFilter(filtro);
			
		}catch(PatternSyntaxException e) {
			return;
		}
		sortTabelaProdutos.setRowFilter(rowFilter);
	}
	
	private void incluirProdutos() {
		ProdutosGUI usuario = new ProdutosGUI(new JFrame(), true, tabelaProdutos, tabelaProdutosModel, 0, VariaveisProjeto.INCLUSAO);
		usuario.setLocationRelativeTo(null);
		usuario.setResizable(false);
		usuario.setVisible(true);
	}
	
	private void alterarProdutos() {
		if(tabelaProdutos.getSelectedRow()!= -1 && tabelaProdutos.getSelectedRow() < tabelaProdutosModel.getRowCount()) {
			int linha = tabelaProdutos.getSelectedRow();
			ProdutosGUI usuario = new ProdutosGUI(new JFrame(), true, tabelaProdutos, tabelaProdutosModel, linha, VariaveisProjeto.ALTERACAO);
			usuario.setLocationRelativeTo(null);
			usuario.setVisible(true);
		}
		
	}
	
	private void excluirProduto() {
		if(tabelaProdutos.getSelectedRow()!= -1 && tabelaProdutos.getSelectedRow() < tabelaProdutosModel.getRowCount()) {
			int linha = tabelaProdutos.getSelectedRow();
			ProdutosGUI usuario = new ProdutosGUI(new JFrame(), true, tabelaProdutos, tabelaProdutosModel, linha, VariaveisProjeto.EXCLUSAO);
			usuario.setLocationRelativeTo(null);
			usuario.setVisible(true);
		}
		
	}
	
	protected void iniciaPaginacao() {
	      
	   
			totalData = buscaTotalRegistroUsuario();
			
			defaultPagina = Integer.valueOf(comboBox.getSelectedItem().toString());
			
			Double totalPaginasExistenes = Math.ceil(totalData.doubleValue() / defaultPagina.doubleValue());
		
			totalPagina = totalPaginasExistenes.intValue();
			
			if ( numeroPagina.equals(1)) {
				btnPrimeiro.setEnabled(false);
				btnProximo.setEnabled(false);
			} else {
				btnPrimeiro.setEnabled(true);
				btnProximo.setEnabled(true);
			}
			
			if ( numeroPagina.equals(totalPagina)) {
				btnUltimo.setEnabled(false);
				btnProximo.setEnabled(false);
			} else {
				btnUltimo.setEnabled(true);
				btnProximo.setEnabled(true);
			}
			
			if (numeroPagina > totalPagina ) {
				numeroPagina = 1;
			}
				
			tabelaProdutosModel = new TabelaProdutosModel();
			
			tabelaProdutosModel.setListaProdutos(carregaListaProdutos(numeroPagina, defaultPagina));
			
			tabelaProdutos.setModel(tabelaProdutosModel);
			
			tabelaProdutos.setFillsViewportHeight(true);
			
			tabelaProdutos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			
			tabelaProdutosModel.fireTableDataChanged();
			
			sortTabelaProdutos = new TableRowSorter<TabelaProdutosModel>(tabelaProdutosModel);
			
			tabelaProdutos.setRowSorter(sortTabelaProdutos);
			
				
			tabelaProdutos.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			
			
			tabelaProdutos.getColumnModel().getColumn(CODIGO).setWidth(11);
			tabelaProdutos.getColumnModel().getColumn(NOME).setWidth(100);
			tabelaProdutos.getColumnModel().getColumn(EMAIL).setWidth(100);
			
			lblInicio.setText(String.valueOf(numeroPagina));
			lblfinal.setText(String.valueOf(totalPagina));
			totalRegistros.setText(String.valueOf(totalData));
		
	}

	
	
	
	private List<Produtos> carregaListaProdutos(Integer numeroPagina, Integer defaultPagina) {

		ProdutosService produtosService = new ProdutosService();

		List<Produtos> listaProdutos  = new ArrayList<Produtos>();
		
		listaProdutos = produtosService.listProdutosPaginacao( ( defaultPagina * (numeroPagina - 1 )), defaultPagina);
		
		return listaProdutos;
	}

	private Integer buscaTotalRegistroUsuario() {
		
		Integer totalRegistro = 0;
		
		ProdutosService produtosService = new ProdutosService();
		
		totalRegistro = produtosService.countTotalRegister();
		
		return totalRegistro;
	}

	
	
	public JTable getTable() {
		return tabelaProdutos;
	}

}
