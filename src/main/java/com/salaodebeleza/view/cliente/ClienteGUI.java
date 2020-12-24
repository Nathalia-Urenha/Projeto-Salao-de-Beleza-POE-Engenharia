package com.salaodebeleza.view.cliente;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.salaodebeleza.estrutura.util.VariaveisProjeto;
import com.salaodebeleza.model.modells.Cliente;
import com.salaodebeleza.model.modells.Usuario;
import com.salaodebeleza.model.service.ClienteService;
import com.salaodebeleza.model.service.UsuarioService;
import com.salaodebeleza.view.usuario.BuscaCabeleireiro;


public class ClienteGUI extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9151682255921515895L;

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldTelefone;
	private JButton btnIncluir;
	private JButton btnAlterar;
	private JButton btnExcluir;
	private JRadioButton rdbtnAtivo;

	private JButton btnSair;
	private JLabel lblCodigo;
	private JTextField textFieldCodigo;
	private JLabel lblNome;
	private JLabel lblAnotacoes;

	private JLabel checkNome;
	private JLabel checkTelefone;
	private JLabel checkAnotacoes;

	private boolean status = true; 

	private JTable tabelaCliente;
	private TabelaClienteModel tabelaClienteModel;
	
	private int linha =0;
	private int acao = 0;
	private JTextField textFieldCabeleireiro;
	private JLabel lblCabeleireiro;
	private JButton btnBuscaCabeleireiro;
	
	private Usuario cabeleireiro;
	private JTextField textFieldAnotacoes;
	
	/**
	 * Create the frame.
	 */
	public ClienteGUI(JFrame frame, boolean modal, JTable tabelaCliente, TabelaClienteModel tabelaClienteModel, int linha, int acao) {
		
		super(frame, modal);
		
		this.tabelaCliente = tabelaCliente;
		this.tabelaClienteModel = tabelaClienteModel;
		this.linha = linha;
		this.acao = acao;
	
		
		setTitle("Cadastro de Cliente");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 374);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		lblNome = new JLabel("Nome:");

		textFieldNome = new JTextField();


		textFieldNome.setColumns(10);

		JLabel lblTelefone = new JLabel("Telefone:");

		textFieldTelefone = new JTextField();


		textFieldTelefone.setColumns(10);

		lblAnotacoes = new JLabel("Anota\u00E7\u00F5es:");
		lblAnotacoes.setHorizontalAlignment(SwingConstants.TRAILING);

		rdbtnAtivo = new JRadioButton("Ativo");



		btnIncluir = new JButton("Incluir");
		btnIncluir.setIcon(new ImageIcon(ClienteGUI.class.getResource("/com/salaodebeleza/estrutura/imagens/application_add.png")));

		btnAlterar = new JButton("Alterar");
		btnAlterar.setIcon(new ImageIcon(ClienteGUI.class.getResource("/com/salaodebeleza/estrutura/imagens/application_edit.png")));


		btnExcluir = new JButton("Excluir");
		btnExcluir.setIcon(new ImageIcon(ClienteGUI.class.getResource("/com/salaodebeleza/estrutura/imagens/application_delete.png")));


		btnSair = new JButton("Sair");
		btnSair.setIcon(new ImageIcon(ClienteGUI.class.getResource("/com/salaodebeleza/estrutura/imagens/sair.png")));

		lblCodigo = new JLabel("C\u00F3digo: ");

		textFieldCodigo = new JTextField();
		textFieldCodigo.setEditable(false);



		textFieldCodigo.setColumns(10);

		checkNome = new JLabel("");
		checkNome.setIcon(new ImageIcon(ClienteGUI.class.getResource("/com/salaodebeleza/estrutura/imagens/ok.png")));

		checkTelefone = new JLabel("");
		checkTelefone.setIcon(new ImageIcon(ClienteGUI.class.getResource("/com/salaodebeleza/estrutura/imagens/ok.png")));

		checkAnotacoes = new JLabel("");
		checkAnotacoes.setIcon(new ImageIcon(ClienteGUI.class.getResource("/com/salaodebeleza/estrutura/imagens/ok.png")));
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setMnemonic(KeyEvent.VK_D);
		btnNewButton.setToolTipText("Buscar produtos");
		btnNewButton.setIcon(new ImageIcon(ClienteGUI.class.getResource("/com/salaodebeleza/estrutura/imagens/search.png")));
		
		lblCabeleireiro = new JLabel("Cabeleireiro(a):");
		
		textFieldCabeleireiro = new JTextField();
		textFieldCabeleireiro.setEditable(false);
		textFieldCabeleireiro.setColumns(10);
		
		btnBuscaCabeleireiro = new JButton("");
		btnBuscaCabeleireiro.setIcon(new ImageIcon(ClienteGUI.class.getResource("/com/salaodebeleza/estrutura/imagens/search.png")));
		
		btnBuscaCabeleireiro.setMnemonic(KeyEvent.VK_D);
		btnBuscaCabeleireiro.setToolTipText("Buscar Cabeleireiro");
		
		textFieldAnotacoes = new JTextField();
		
		textFieldAnotacoes.setColumns(10);


		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(103)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblTelefone)
						.addComponent(lblNome)
						.addComponent(lblCodigo)
						.addComponent(lblCabeleireiro)
						.addComponent(lblAnotacoes))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(rdbtnAtivo)
							.addContainerGap())
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(392)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(54, Short.MAX_VALUE))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(textFieldCabeleireiro, GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
									.addComponent(textFieldAnotacoes, GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
									.addComponent(textFieldTelefone, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
									.addComponent(textFieldCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(textFieldNome, GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(checkAnotacoes)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(checkNome, Alignment.TRAILING)
										.addComponent(checkTelefone, Alignment.TRAILING))
									.addComponent(btnBuscaCabeleireiro, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
								.addGap(79)))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(137)
					.addComponent(btnIncluir)
					.addGap(18)
					.addComponent(btnAlterar)
					.addGap(18)
					.addComponent(btnExcluir)
					.addGap(18)
					.addComponent(btnSair)
					.addContainerGap(147, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textFieldCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCodigo))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNome)
								.addComponent(textFieldNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(checkNome))
					.addGap(15)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblTelefone)
							.addGap(6))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addComponent(textFieldTelefone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(checkTelefone)))
					.addGap(8)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblAnotacoes)
							.addComponent(textFieldAnotacoes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(checkAnotacoes))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnBuscaCabeleireiro, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(25)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblCabeleireiro)
							.addComponent(textFieldCabeleireiro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(7)
					.addComponent(rdbtnAtivo)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnIncluir)
						.addComponent(btnAlterar)
						.addComponent(btnExcluir)
						.addComponent(btnSair))
					.addContainerGap(31, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		createEvents();

		limpaTextoCampo();

		desabilitaCheckCampos();
		
		/*
		 * btnAlterar.setEnabled(false); btnIncluir.setEnabled(false);
		 * btnExcluir.setEnabled(false);
		 */
		
		configuraAcaoCliente();
	}
	
	
	private void configuraAcaoCliente() {
		
		if(this.acao == VariaveisProjeto.INCLUSAO) {
			btnIncluir.setEnabled(true);
			btnAlterar.setVisible(false);
			btnExcluir.setVisible(false);
		}
		
		if(this.acao == VariaveisProjeto.ALTERACAO) {
			btnAlterar.setEnabled(true);
			btnIncluir.setVisible(false);
			btnExcluir.setVisible(false);
			buscarCliente();
		}
		
		if(this.acao == VariaveisProjeto.EXCLUSAO) {
			buscarCliente();
			btnExcluir.setEnabled(true);
			btnAlterar.setVisible(false);
			btnIncluir.setVisible(false);
		}
	}


	/////////////////////////////////////////////
	private boolean verificaDigitacaoDoNome() {
		if ( VariaveisProjeto.digitacaoCampo(textFieldNome.getText())) {
			status = false;
			mudaStatusCheckNome();
			return true; 
		}

		return false;

	}

	private void digitacaoNomeValido() {
		status = true;
		mudaStatusCheckNome();
		checkNome.setVisible(true);	
		textFieldTelefone.requestFocus();
	}

	private boolean verificaDigitacaoDoTelefone() {
		if ( VariaveisProjeto.digitacaoCampo(textFieldTelefone.getText())) {
			status = false;
			mudaStatusCheckTelefone();
			return true; 
		}
		return false;
	}

	private void digitacaoTelefoneValido() {
		status = true;
		mudaStatusCheckTelefone();
		checkTelefone.setVisible(true);	
		textFieldAnotacoes.requestFocus();
	}

	private void digitacaoAnotacaoValida() {
		status = true;
		mudaStatusCheckAnotacoes();
		checkAnotacoes.setVisible(true);	
		rdbtnAtivo.requestFocus();
	}


	@SuppressWarnings("deprecation")
	private boolean verificaDigitacaoAnotacoes() {
		if ( VariaveisProjeto.digitacaoCampo(textFieldAnotacoes.getText())) {
			status = false;
			mudaStatusCheckAnotacoes();
			return true; 
		}
		return false;
	}

	//////////////////////////////////////////////////////////////////////////////
	private void mudaStatusCheckNome() {
		checkNome.setVisible(true);
		if (status == false ) {
			checkNome.setIcon(new ImageIcon(ClienteGUI.class.getResource("/com/salaodebeleza/estrutura/imagens/iconFechar.png")));
		} else {
			checkNome.setIcon(new ImageIcon(ClienteGUI.class.getResource("/com/salaodebeleza/estrutura/imagens/ok.png")));
		}
	}

	private void mudaStatusCheckTelefone() {
		checkTelefone.setVisible(true);
		if (status == false ) {
			checkTelefone.setIcon(new ImageIcon(ClienteGUI.class.getResource("/com/salaodebeleza/estrutura/imagens/iconFechar.png")));
		} else {
			checkTelefone.setIcon(new ImageIcon(ClienteGUI.class.getResource("/com/salaodebeleza/estrutura/imagens/ok.png")));
		}
	}

	private void mudaStatusCheckAnotacoes() {
		checkAnotacoes.setVisible(true);
		if (status == false ) {
			checkAnotacoes.setIcon(new ImageIcon(ClienteGUI.class.getResource("/com/salaodebeleza/estrutura/imagens/iconFechar.png")));
		} else {
			checkAnotacoes.setIcon(new ImageIcon(ClienteGUI.class.getResource("/com/salaodebeleza/estrutura/imagens/ok.png")));
		}
	}

	private void desabilitaCheckCampos() {
		checkNome.setVisible(false);
		checkTelefone.setVisible(false);
		checkAnotacoes.setVisible(false);
	}
	///////////////////////////////////////////////////////////////////



	private void createEvents() {

		/////////////////////ACTION LISTENER///////////////
		btnIncluir.addActionListener(new ActionListener() {
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
		
		btnBuscaCabeleireiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscaCabeleireiro();
			}
		});

		///////////////////FOCUS////////////////////////////////

		
		
		/*
		 * textFieldCodigo.addFocusListener(new FocusAdapter() {
		 * 
		 * @Override public void focusLost(FocusEvent e){ buscarUsuario(); } });
		 */
		  
		 
		textFieldNome.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if ( verificaDigitacaoDoNome() ) {
					textFieldNome.requestFocus();	
				} else {
					digitacaoNomeValido();
				}
			}
		});

		
		  textFieldTelefone.addFocusListener(new FocusAdapter() {
		  
		  @Override 
		  public void focusLost(FocusEvent e) { 
		  if (verificaDigitacaoDoTelefone() ) { 
		  		textFieldTelefone.requestFocus(); 
		  } 
		  else {
		  		digitacaoTelefoneValido(); 
		  }
		  
		  } });
		  
		  textFieldAnotacoes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					 if (verificaDigitacaoAnotacoes() ) { 
					  		textFieldAnotacoes.requestFocus(); 
					  } 
					  else {
						  digitacaoAnotacaoValida(); 
					  }
				}
			});

		////////////////KEY PRESSED///////////////////////////////
		
		  textFieldCodigo.addKeyListener(new KeyAdapter() {
		  
		  @Override 
		  public void keyPressed(KeyEvent e) { 
			  if ( e.getKeyCode() == KeyEvent.VK_ENTER) { 
				  buscarCliente(); 
				  textFieldNome.requestFocus(); 
				  } 
			  } 
		  });
		 

		textFieldNome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if ( e.getKeyCode() == KeyEvent.VK_ENTER) {
					if ( verificaDigitacaoDoNome() ) {
						textFieldNome.requestFocus();	
					} else {
						digitacaoNomeValido();
					}	
				}
			}
		});

		textFieldTelefone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if ( e.getKeyCode() == KeyEvent.VK_ENTER) {
					if ( verificaDigitacaoDoTelefone() ) {
						textFieldTelefone.requestFocus();	
					} else {
						digitacaoTelefoneValido();
					}	
					textFieldAnotacoes.requestFocus();
				}
			}
		});
		
		textFieldAnotacoes.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if ( e.getKeyCode() == KeyEvent.VK_ENTER) {
					if ( verificaDigitacaoAnotacoes() ) {
						textFieldAnotacoes.requestFocus();	
					} else {
						digitacaoAnotacaoValida();
					}	
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
	private void incluir() {
		
		Integer toReturn = 0;
		
		Cliente cliente = pegarDadosCliente();
		
		cliente.setUsuario(cabeleireiro);
		
		ClienteService clienteService = new ClienteService();
		
		toReturn = clienteService.save(cliente);
		
		erroDigitacao(toReturn);
		
		if ( toReturn == VariaveisProjeto.ERRO_INCLUSAO ) {
			showMensagem("Erro na Inclusão do Registro, verifique com seu administrador!",
					   	 "Erro",JOptionPane.ERROR_MESSAGE);
		}
		if ( toReturn == VariaveisProjeto.INCLUSAO_REALIZADA) {
			showMensagem("Inclusão do Registro realizada com sucesso!",
					     "OK",JOptionPane.OK_OPTION);
			limpaTextoCampo();
			tabelaClienteModel.fireTableDataChanged();
			cliente = new Cliente();
		}

	}


	protected void excluir() {
		
		Integer toReturn = 0;
		
		Cliente cliente = pegarDadosCliente();
		
		ClienteService clienteService = new ClienteService();
		
		toReturn = clienteService.delete(cliente);
		
		if ( toReturn == VariaveisProjeto.ERRO_EXCLUSAO ) {
			showMensagem("Erro na Exclusão do Registro, verifique com seu administrador!",
					   	 "Erro",JOptionPane.ERROR_MESSAGE);
		}
		if ( toReturn == VariaveisProjeto.EXCLUSAO_REALIZADA) {
			showMensagem("Exclusão do Registro realizada com sucesso!",
					     "OK",JOptionPane.OK_OPTION);
			limpaTextoCampo();
			cliente = new Cliente();
		}

	}

	protected void alterar() {
		
		Integer toReturn = 0;
		
	    Cliente cliente = pegarDadosCliente();
	    
	    cliente.setUsuario(cabeleireiro);
	    
	    ClienteService clienteService = new ClienteService();
		
		toReturn = clienteService.update(cliente);
		
		erroDigitacao(toReturn);
		
		if ( toReturn == VariaveisProjeto.ERRO_ALTERACAO ) {
			showMensagem("Erro na Alteração do Registro, verifique com seu administrador!",
					   	 "Erro",JOptionPane.ERROR_MESSAGE);
		}
		if ( toReturn == VariaveisProjeto.ALTERACAO_REALIZADA) {
			showMensagem("Alteração do Registro realizada com sucesso!",
					     "OK",JOptionPane.OK_OPTION);
			
			tabelaClienteModel.fireTableDataChanged();
			limpaTextoCampo();
			cliente = new Cliente();
		}
		
		
	}
	
	private void erroDigitacao(Integer toReturn) {
		if ( toReturn == VariaveisProjeto.CLIENTE_NOME) {
			 status = false;
			 mudaStatusCheckNome();
			 showMensagem("Erro na digitação do Nome, verifique!","Erro", JOptionPane.ERROR_MESSAGE);
		}
		if ( toReturn == VariaveisProjeto.CLIENTE_TELEFONE ) {
			 status = false;
			 mudaStatusCheckTelefone(); // mudei aqui antes era mudaStatusCheckNome();
			 showMensagem("Erro na digitação do Telefone, verifique!","Erro", JOptionPane.ERROR_MESSAGE);
		}
		if ( toReturn == VariaveisProjeto.CLIENTE_ANOTACOES ) {
			 status = false;
			 mudaStatusCheckAnotacoes(); // mudei aqui antes era mudaStatusCheckNome();
			 showMensagem("Erro na digitação das Anotações, verifique!","Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void showMensagem(String mensagem, String status, int option)
	{
		JOptionPane.showMessageDialog(null, mensagem, status, option);
	}

	@SuppressWarnings("deprecation")
	public Cliente pegarDadosCliente() {
		
		Cliente cliente = new Cliente();
		
		
		if (VariaveisProjeto.digitacaoCampo(textFieldCodigo.getText())){
		 textFieldCodigo.requestFocus(); 
		}
		
	    if (VariaveisProjeto.digitacaoCampo(textFieldCodigo.getText()) == false ) {
	    	cliente.setId(Integer.valueOf(textFieldCodigo.getText()));
	    }
	    
		cliente.setNome(textFieldNome.getText());
		cliente.setTelefone(textFieldTelefone.getText());
		cliente.setAnotacoes(textFieldAnotacoes.getText());
		cliente.setUsuario(cabeleireiro);
		
		if (rdbtnAtivo.isSelected()) {
			cliente.setAtivo(true);
		} else  {
			cliente.setAtivo(false);
		}
		
		return cliente;

	}

	private void buscarCliente() {

		
		  Cliente cliente = new Cliente();
		 
		/* if (VariaveisProjeto.digitacaoCampo(textFieldCodigo.getText())){
		 * textFieldCodigo.requestFocus(); return;
		 * 
		 * }
		 * 
		 * Integer id = Integer.valueOf(textFieldCodigo.getText());
		 */
		
		cliente = tabelaClienteModel.getCliente(this.linha); 
		
		
		textFieldCodigo.setText(String.valueOf(cliente.getId()));
		textFieldNome.setText(cliente.getNome());
		textFieldTelefone.setText(cliente.getTelefone());
		textFieldAnotacoes.setText(cliente.getAnotacoes());
		
		textFieldCabeleireiro.setText(cliente.getUsuario().getUsername());
		
		

		if ( cliente.isAtivo()) 
			rdbtnAtivo.setSelected(true); 
	

	}

	private void limpaTextoCampo() {
		textFieldCodigo.setText(VariaveisProjeto.LIMPA_CAMPO);
		textFieldNome.setText(VariaveisProjeto.LIMPA_CAMPO);
		textFieldTelefone.setText(VariaveisProjeto.LIMPA_CAMPO);
		textFieldAnotacoes.setText(VariaveisProjeto.LIMPA_CAMPO);
		textFieldCabeleireiro.setText(VariaveisProjeto.LIMPA_CAMPO);
		rdbtnAtivo.setSelected(false);
	}
}


