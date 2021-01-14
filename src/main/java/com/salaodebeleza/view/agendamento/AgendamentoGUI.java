package com.salaodebeleza.view.agendamento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.salaodebeleza.estrutura.util.VariaveisProjeto;
import com.salaodebeleza.model.modells.Agendamento;
import com.salaodebeleza.model.modells.Cliente;
import com.salaodebeleza.model.modells.Usuario;
import com.salaodebeleza.model.service.AgendamentoService;
import com.salaodebeleza.model.service.ClienteService;
import com.salaodebeleza.model.service.UsuarioService;
import com.salaodebeleza.view.agendamento.AgendamentoGUI;
import com.salaodebeleza.view.agendamento.TabelaAgendamentoModel;
import com.salaodebeleza.view.cliente.BuscaCliente;
import com.salaodebeleza.view.usuario.BuscaCabeleireiro;
import com.toedter.calendar.JDayChooser;
import com.toedter.components.JLocaleChooser;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import com.toedter.components.JSpinField;
import javax.swing.JSpinner;

public class AgendamentoGUI extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6628919384128946371L;
	private JPanel contentPane;
	private JButton btnAgendar;
	private JButton btnAlterar;
	private JButton btnExcluir;

	private JButton btnSair;
	private JLabel lblCodigo;
	private JTextField textFieldCodigo;

	private boolean status = true; 

	private JTable tabelaAgendamento;
	private TabelaAgendamentoModel tabelaAgendamentoModel;
	
	private int linha =0;
	private int acao = 0;
	private JLabel lblCabeleireiro;
	private JTextField textFieldCabeleireiro;
	private JButton btnBuscarCabeleireiro;
	
	private Usuario cabeleireiro;
	private Cliente cliente;
	private JLabel lblCliente;
	private JTextField textFieldCliente;
	private JTextField textFieldProcedimentos;
	private JLabel lblTotal;
	private JLabel lblData;
	private JTextField textField_5;
	private JButton btnProcedimentos;
	private JButton btnProdutos;
	private JTextField textFieldProdutos;
	private JTextField textFieldTotal;
	private JButton btnBuscarCliente;
	private JDateChooser data;
	private JLabel lblHora;
	private JTextField textFieldHora;
	
	/**
	 * Create the frame.
	 */
	public AgendamentoGUI(JFrame frame, boolean modal, JTable tabelaAgendamento, TabelaAgendamentoModel tabelaAgendamentoModel, int linha, int acao) {
		
		super(frame, modal);
		
		this.tabelaAgendamento = tabelaAgendamento;
		this.tabelaAgendamentoModel = tabelaAgendamentoModel;
		this.linha = linha;
		this.acao = acao;
	
		
		setTitle("Cadastro de Agendamento");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);



		btnAgendar = new JButton("Agendar");
		btnAgendar.setIcon(new ImageIcon(AgendamentoGUI.class.getResource("/com/salaodebeleza/estrutura/imagens/application_add.png")));

		btnAlterar = new JButton("Alterar");
		btnAlterar.setIcon(new ImageIcon(AgendamentoGUI.class.getResource("/com/salaodebeleza/estrutura/imagens/application_edit.png")));


		btnExcluir = new JButton("Excluir");
		btnExcluir.setIcon(new ImageIcon(AgendamentoGUI.class.getResource("/com/salaodebeleza/estrutura/imagens/application_delete.png")));


		btnSair = new JButton("Sair");
		btnSair.setIcon(new ImageIcon(AgendamentoGUI.class.getResource("/com/salaodebeleza/estrutura/imagens/sair.png")));

		lblCodigo = new JLabel("C\u00F3digo: ");

		textFieldCodigo = new JTextField();
		textFieldCodigo.setEditable(false);



		textFieldCodigo.setColumns(10);
		
		lblCabeleireiro = new JLabel("Cabeleireiro(a):");
		
		textFieldCabeleireiro = new JTextField();
		textFieldCabeleireiro.setColumns(10);
		textFieldCabeleireiro.setEditable(false);
		
		btnBuscarCabeleireiro = new JButton("");
		btnBuscarCabeleireiro.setIcon(new ImageIcon(AgendamentoGUI.class.getResource("/com/salaodebeleza/estrutura/imagens/search.png")));
		
		btnBuscarCabeleireiro.setMnemonic(KeyEvent.VK_D);
		btnBuscarCabeleireiro.setToolTipText("Buscar Cabeleireiro");
		
		lblCliente = new JLabel("Cliente:");
		
		textFieldCliente = new JTextField();
		textFieldCliente.setEditable(false);
		textFieldCliente.setColumns(10);
		
		textFieldProcedimentos = new JTextField();
		textFieldProcedimentos.setEditable(false);
		textFieldProcedimentos.setToolTipText("Valor Total de Procedimentos Realizados");
		textFieldProcedimentos.setColumns(10);
		
		lblTotal = new JLabel("Total:");
		
		btnBuscarCliente = new JButton("");
		
		btnBuscarCliente.setIcon(new ImageIcon(AgendamentoGUI.class.getResource("/com/salaodebeleza/estrutura/imagens/search.png")));
		btnBuscarCliente.setToolTipText("Buscar Cabeleireiro");
		btnBuscarCliente.setMnemonic(KeyEvent.VK_D);
		
		lblData = new JLabel("Data:");
		
		data = new JDateChooser();
		
		lblHora = new JLabel("Hora: ");
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		btnProcedimentos = new JButton("Procedimentos");
		
		btnProdutos = new JButton("Produtos");
		
		textFieldProdutos = new JTextField();
		textFieldProdutos.setEditable(false);
		textFieldProdutos.setToolTipText("Valor Total de Produtos Vendidos");
		textFieldProdutos.setColumns(10);
		
		textFieldTotal = new JTextField();
		textFieldTotal.setEditable(false);
		textFieldTotal.setToolTipText("Valor Total");
		textFieldTotal.setColumns(10);
		
		textFieldHora = new JTextField();
		textFieldHora.setColumns(10);
		
	
		
	

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(93)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(29)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblCodigo)
								.addComponent(lblData)
								.addComponent(lblCabeleireiro)
								.addComponent(lblCliente))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(textFieldCliente)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(data, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(lblHora)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(textFieldHora, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addComponent(textFieldCabeleireiro))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(btnBuscarCabeleireiro, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnBuscarCliente, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
								.addComponent(textFieldCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(btnProcedimentos)
										.addComponent(btnProdutos)
										.addComponent(lblTotal))
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(textFieldTotal, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
											.addComponent(textFieldProcedimentos, 0, 0, Short.MAX_VALUE)
											.addComponent(textFieldProdutos, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)))))
							.addGap(81)
							.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(25)
							.addComponent(btnAgendar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAlterar)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnExcluir)
							.addGap(18)
							.addComponent(btnSair)))
					.addContainerGap(50, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(48, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblCodigo)
							.addGap(24)
							.addComponent(lblData))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(textFieldCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(data, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(Alignment.TRAILING, gl_contentPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblHora)
									.addComponent(textFieldHora, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnBuscarCabeleireiro, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(textFieldCabeleireiro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblCabeleireiro)))
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(textFieldCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblCliente))
								.addComponent(btnBuscarCliente, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.UNRELATED, 12, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnProcedimentos)
									.addGap(9)
									.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(textFieldProcedimentos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnProdutos)
										.addComponent(textFieldProdutos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTotal)
								.addComponent(textFieldTotal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(129))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnAgendar)
								.addComponent(btnAlterar)
								.addComponent(btnExcluir)
								.addComponent(btnSair))
							.addGap(75))))
		);
		contentPane.setLayout(gl_contentPane);
		createEvents();

		limpaTextoCampo();
		
		/*
		 * btnAlterar.setEnabled(false); btnIncluir.setEnabled(false);
		 * btnExcluir.setEnabled(false);
		 */
		
		configuraAcaoAgendamento();
	}
	
	
	private void configuraAcaoAgendamento() {
		
		if(this.acao == VariaveisProjeto.INCLUSAO) {
			btnAgendar.setEnabled(true);
			btnAlterar.setVisible(false);
			btnExcluir.setVisible(false);
		}
		
		if(this.acao == VariaveisProjeto.ALTERACAO) {
			btnAlterar.setEnabled(true);
			btnAgendar.setVisible(false);
			btnExcluir.setVisible(false);
			buscarAgendamento();
		}
		
		if(this.acao == VariaveisProjeto.EXCLUSAO) {
			buscarAgendamento();
			btnExcluir.setEnabled(true);
			btnAlterar.setVisible(false);
			btnAgendar.setVisible(false);
		}
	}
	
	private void erroDigitacao(Integer toReturn) {
		if ( toReturn == VariaveisProjeto.AGENDAMENTO_DATA) {
			 status = false;
			 showMensagem("Erro ao selecionar data!","Erro", JOptionPane.ERROR_MESSAGE);
		}
		if ( toReturn == VariaveisProjeto.AGENDAMENTO_HORA) {
			 status = false;
			 showMensagem("Erro ao selecionar hora, verifique!","Erro", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	

/////////////////////////EVENTOS//////////////////////////////////////


	private void createEvents() {

		/////////////////////ACTION LISTENER///////////////
		btnAgendar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				incluir();
			}
		});

		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterar();
			}
		});

		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluir();
			}
		});

		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		btnBuscarCabeleireiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscaCabeleireiro();
			}
		});
		
		btnBuscarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscaCliente();
			}
		});

		////////////////KEY PRESSED///////////////////////////////
		
		  textFieldCodigo.addKeyListener(new KeyAdapter() {
		  
		  @Override 
		  public void keyPressed(KeyEvent e) { 
			  if ( e.getKeyCode() == KeyEvent.VK_ENTER) { 
				  buscarAgendamento(); 
				  } 
			  } 
		  });

	}


	////////////////////////////////////////////////////////////////////
	
protected void buscaCabeleireiro() {
		
		cabeleireiro = new Usuario();
		
		BuscaCabeleireiro buscaCabeleireiro= new BuscaCabeleireiro(new JFrame(), true);
		buscaCabeleireiro.setLocationRelativeTo(null);
		buscaCabeleireiro.setVisible(true);
		
		if (buscaCabeleireiro.isSelectUsuario()) {
			UsuarioService cabeleireiroService = new UsuarioService();
			cabeleireiro = cabeleireiroService.findById(buscaCabeleireiro.getCodigoUsuario());
			textFieldCabeleireiro.setText(cabeleireiro.getUsername());
		}
		
	}

protected void buscaCliente() {
	
	cliente = new Cliente();
	
	BuscaCliente buscaCliente= new BuscaCliente(new JFrame(), true);
	buscaCliente.setLocationRelativeTo(null);
	buscaCliente.setVisible(true);
	
	if (buscaCliente.isSelectCliente()) {
		ClienteService clienteService = new ClienteService();
		cliente = clienteService.findById(buscaCliente.getCodigoCliente());
		textFieldCliente.setText(cliente.getNome());
	}
	
}



//DATA
//HORA
//PROCEDIMENTOS
//VALOR PROCEDIMENTOS
//PRODUTOS
//VALOR PRODUTOS
//TOTAL

	private void incluir() {
		
		Integer toReturn = 0;
		
		Agendamento agendamento = pegarDadosAgendamento();
		
		//SETAR: CLIENTE, PROCEDIMENTOS, PRODUTOS, VALORES
		
		//manipulando data
		
		java.util.Date date = data.getDate();
		
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		
		agendamento.setData(sqlDate);
		
		//
		
		agendamento.setHora(String.valueOf(textFieldHora));
		agendamento.setUsuario(cabeleireiro);
		
		
		AgendamentoService agendamentoService = new AgendamentoService();
		
		toReturn = agendamentoService.save(agendamento);
		
		erroDigitacao(toReturn);
		
		
		if ( toReturn == VariaveisProjeto.ERRO_INCLUSAO ) {
			showMensagem("Erro na Inclusão do Registro, verifique com seu administrador!",
					   	 "Erro",JOptionPane.ERROR_MESSAGE);
		}
		if ( toReturn == VariaveisProjeto.INCLUSAO_REALIZADA) {
			showMensagem("Inclusão do Registro realizada com sucesso!",
					     "OK",JOptionPane.OK_OPTION);
			limpaTextoCampo();
			tabelaAgendamentoModel.fireTableDataChanged();
			agendamento = new Agendamento();
		}

	}


	protected void excluir() {
		
		Integer toReturn = 0;
		
		Agendamento agendamento = pegarDadosAgendamento();
		
		AgendamentoService agendamentoService = new AgendamentoService();
		
		toReturn = agendamentoService.delete(agendamento);
		
		if ( toReturn == VariaveisProjeto.ERRO_EXCLUSAO ) {
			showMensagem("Erro na Exclusão do Registro, verifique com seu administrador!",
					   	 "Erro",JOptionPane.ERROR_MESSAGE);
		}
		if ( toReturn == VariaveisProjeto.EXCLUSAO_REALIZADA) {
			showMensagem("Exclusão do Registro realizada com sucesso!",
					     "OK",JOptionPane.OK_OPTION);
			limpaTextoCampo();
			agendamento = new Agendamento();
		}

	}

	protected void alterar() {
		
		Integer toReturn = 0;
		
	    Agendamento agendamento = pegarDadosAgendamento();
	    
    //SETAR: CLIENTE, PROCEDIMENTOS, PRODUTOS, VALORES
    
    	//manipulando data
	
  		java.util.Date date = data.getDate();
  		
  		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
  		
  		agendamento.setData(sqlDate);
  		
  		//
  		
  		agendamento.setHora(String.valueOf(textFieldHora));
  		agendamento.setUsuario(cabeleireiro);
  
	    
	    AgendamentoService agendamentoService = new AgendamentoService();
		
		toReturn = agendamentoService.update(agendamento);
		
		
		if ( toReturn == VariaveisProjeto.ERRO_ALTERACAO ) {
			showMensagem("Erro na Alteração do Registro, verifique com seu administrador!",
					   	 "Erro",JOptionPane.ERROR_MESSAGE);
		}
		if ( toReturn == VariaveisProjeto.ALTERACAO_REALIZADA) {
			showMensagem("Alteração do Registro realizada com sucesso!",
					     "OK",JOptionPane.OK_OPTION);
			
			tabelaAgendamentoModel.fireTableDataChanged();
			limpaTextoCampo();
			agendamento = new Agendamento();
		}
		
		
	}
	
	
	private void showMensagem(String mensagem, String status, int option)
	{
		JOptionPane.showMessageDialog(null, mensagem, status, option);
	}

	@SuppressWarnings("deprecation")
	public Agendamento pegarDadosAgendamento() {
		
		Agendamento agendamento = new Agendamento();
		
		
		if (VariaveisProjeto.digitacaoCampo(textFieldCodigo.getText())){
		 textFieldCodigo.requestFocus(); 
		}
		
	    if (VariaveisProjeto.digitacaoCampo(textFieldCodigo.getText()) == false ) {
	    	agendamento.setId(Integer.valueOf(textFieldCodigo.getText()));
	    }
	    
	    
	  //SETAR: CLIENTE, PROCEDIMENTOS, PRODUTOS, VALORES
		
	  //manipulando data
		
  		java.util.Date date = data.getDate();
  		
  		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
  		
  		agendamento.setData(sqlDate);
  		
  		//
  		
  		agendamento.setHora(String.valueOf(textFieldHora));
		agendamento.setUsuario(cabeleireiro);
		
		
		
		return agendamento;

	}

	private void buscarAgendamento() {

		
		Agendamento agendamento = new Agendamento();
		 
		
		agendamento = tabelaAgendamentoModel.getAgendamento(this.linha); 
		
		
		textFieldCodigo.setText(String.valueOf(agendamento.getId()));
		
		//GET:CLIENTE, PROCEDIMENTOS, PRODUTOS, VALORES
		
		
		//
				
	
		textFieldHora.setText(agendamento.getHora());
		textFieldCabeleireiro.setText(agendamento.getUsuario().getUsername());
		
	
	}

	private void limpaTextoCampo() {
		textFieldCodigo.setText(VariaveisProjeto.LIMPA_CAMPO);
		textFieldCabeleireiro.setText(VariaveisProjeto.LIMPA_CAMPO);
		data.setToolTipText(VariaveisProjeto.LIMPA_CAMPO);
		textFieldCliente.setText(VariaveisProjeto.LIMPA_CAMPO);
		textFieldProcedimentos.setText(VariaveisProjeto.LIMPA_CAMPO);
		textFieldProdutos.setText(VariaveisProjeto.LIMPA_CAMPO);
		textFieldTotal.setText(VariaveisProjeto.LIMPA_CAMPO);
	}
}
