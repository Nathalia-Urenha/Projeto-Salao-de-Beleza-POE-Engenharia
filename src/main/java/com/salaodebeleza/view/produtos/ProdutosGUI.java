package com.salaodebeleza.view.produtos;

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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.salaodebeleza.estrutura.util.VariaveisProjeto;
import com.salaodebeleza.model.modells.Produtos;
import com.salaodebeleza.model.modells.Usuario;
import com.salaodebeleza.model.service.ProdutosService;
import com.salaodebeleza.model.service.UsuarioService;
import com.salaodebeleza.view.usuario.BuscaCabeleireiro;

public class ProdutosGUI extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5366152444186322856L;
	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldValor;
	private JButton btnIncluir;
	private JButton btnAlterar;
	private JButton btnExcluir;

	private JButton btnSair;
	private JLabel lblCodigo;
	private JTextField textFieldCodigo;
	private JLabel lblNome;
	private JLabel lblQuantidade;

	private JLabel checkNome;
	private JLabel checkValor;
	private JLabel checkqtd;

	private boolean status = true; 

	private JTable tabelaProdutos;
	private TabelaProdutosModel tabelaProdutosModel;
	
	private int linha =0;
	private int acao = 0;
	private JTextField textFieldQuantidade;
	private JLabel lblCabeleireiro;
	private JTextField textFieldCabeleireiro;
	private JButton btnBuscarCabeleireiro;
	
	private Usuario cabeleireiro;
	
	/**
	 * Create the frame.
	 */
	public ProdutosGUI(JFrame frame, boolean modal, JTable tabelaProdutos, TabelaProdutosModel tabelaProdutosModel, int linha, int acao) {
		
		super(frame, modal);
		
		this.tabelaProdutos = tabelaProdutos;
		this.tabelaProdutosModel = tabelaProdutosModel;
		this.linha = linha;
		this.acao = acao;
	
		
		setTitle("Cadastro de Produtos");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 378);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		lblNome = new JLabel("Nome:");

		textFieldNome = new JTextField();


		textFieldNome.setColumns(10);

		JLabel lblValor = new JLabel("Valor:");

		textFieldValor = new JTextField();


		textFieldValor.setColumns(10);

		lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setHorizontalAlignment(SwingConstants.TRAILING);



		btnIncluir = new JButton("Incluir");
		btnIncluir.setIcon(new ImageIcon(ProdutosGUI.class.getResource("/com/salaodebeleza/estrutura/imagens/application_add.png")));

		btnAlterar = new JButton("Alterar");
		btnAlterar.setIcon(new ImageIcon(ProdutosGUI.class.getResource("/com/salaodebeleza/estrutura/imagens/application_edit.png")));


		btnExcluir = new JButton("Excluir");
		btnExcluir.setIcon(new ImageIcon(ProdutosGUI.class.getResource("/com/salaodebeleza/estrutura/imagens/application_delete.png")));


		btnSair = new JButton("Sair");
		btnSair.setIcon(new ImageIcon(ProdutosGUI.class.getResource("/com/salaodebeleza/estrutura/imagens/sair.png")));

		lblCodigo = new JLabel("C\u00F3digo: ");

		textFieldCodigo = new JTextField();
		textFieldCodigo.setEditable(false);



		textFieldCodigo.setColumns(10);

		checkNome = new JLabel("");
		checkNome.setIcon(new ImageIcon(ProdutosGUI.class.getResource("/com/salaodebeleza/estrutura/imagens/ok.png")));

		checkValor = new JLabel("");
		checkValor.setIcon(new ImageIcon(ProdutosGUI.class.getResource("/com/salaodebeleza/estrutura/imagens/ok.png")));

		checkqtd = new JLabel("");
		checkqtd.setIcon(new ImageIcon(ProdutosGUI.class.getResource("/com/salaodebeleza/estrutura/imagens/ok.png")));
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setMnemonic(KeyEvent.VK_D);
		btnNewButton.setToolTipText("Buscar produtos");
		btnNewButton.setIcon(new ImageIcon(ProdutosGUI.class.getResource("/com/salaodebeleza/estrutura/imagens/search.png")));
		
		textFieldQuantidade = new JTextField();
		
		
		textFieldQuantidade.setColumns(10);
		
		lblCabeleireiro = new JLabel("Cabeleireiro(a):");
		
		textFieldCabeleireiro = new JTextField();
		textFieldCabeleireiro.setColumns(10);
		textFieldCabeleireiro.setEditable(false);
		
		btnBuscarCabeleireiro = new JButton("");
		btnBuscarCabeleireiro.setIcon(new ImageIcon(ProdutosGUI.class.getResource("/com/salaodebeleza/estrutura/imagens/search.png")));
		
		btnBuscarCabeleireiro.setMnemonic(KeyEvent.VK_D);
		btnBuscarCabeleireiro.setToolTipText("Buscar Cabeleireiro");

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(75)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblCodigo)
								.addComponent(lblValor)
								.addComponent(lblNome)
								.addComponent(lblQuantidade)
								.addComponent(lblCabeleireiro))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textFieldCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(textFieldCabeleireiro, Alignment.LEADING)
										.addGroup(Alignment.LEADING, gl_contentPane.createParallelGroup(Alignment.LEADING, false)
											.addComponent(textFieldValor, GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
											.addComponent(textFieldNome, GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE))
										.addComponent(textFieldQuantidade, Alignment.LEADING, 315, 315, Short.MAX_VALUE))
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(26)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
												.addComponent(checkqtd)
												.addComponent(checkValor)
												.addComponent(checkNome)))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(18)
											.addComponent(btnBuscarCabeleireiro, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(112)
							.addComponent(btnIncluir)
							.addGap(18)
							.addComponent(btnAlterar)
							.addGap(18)
							.addComponent(btnExcluir)
							.addGap(18)
							.addComponent(btnSair)))
					.addContainerGap(85, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(62)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCodigo)
						.addComponent(textFieldCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome)
						.addComponent(textFieldNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(checkNome))
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblValor)
						.addComponent(textFieldValor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(checkValor))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(26)
							.addComponent(checkqtd)
							.addGap(18)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(29)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textFieldQuantidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblQuantidade))))
					.addPreferredGap(ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCabeleireiro)
						.addComponent(textFieldCabeleireiro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBuscarCabeleireiro))
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnIncluir)
						.addComponent(btnAlterar)
						.addComponent(btnExcluir)
						.addComponent(btnSair))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		createEvents();

		limpaTextoCampo();

		desabilitaCheckCampos();
		
		/*
		 * btnAlterar.setEnabled(false); btnIncluir.setEnabled(false);
		 * btnExcluir.setEnabled(false);
		 */
		
		configuraAcaoProdutos();
	}
	
	
	private void configuraAcaoProdutos() {
		
		if(this.acao == VariaveisProjeto.INCLUSAO) {
			btnIncluir.setEnabled(true);
			btnAlterar.setVisible(false);
			btnExcluir.setVisible(false);
		}
		
		if(this.acao == VariaveisProjeto.ALTERACAO) {
			btnAlterar.setEnabled(true);
			btnIncluir.setVisible(false);
			btnExcluir.setVisible(false);
			buscarProdutos();
		}
		
		if(this.acao == VariaveisProjeto.EXCLUSAO) {
			buscarProdutos();
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
		textFieldValor.requestFocus();
	}

	private boolean verificaDigitacaoDoValor() {
		if ( VariaveisProjeto.digitacaoCampo(textFieldValor.getText())) {
			status = false;
			mudaStatusCheckValor();
			return true; 
		}
		return false;
	}

	private void digitacaoValorValido() {
		status = true;
		mudaStatusCheckValor();
		checkValor.setVisible(true);	
		textFieldQuantidade.requestFocus();
	}

	private void digitacaoQtdValida() {
		status = true;
		mudaStatusCheckQtd();
		checkqtd.setVisible(true);	
	}


	@SuppressWarnings("deprecation")
	private boolean verificaDigitacaoQtd() {
		if ( VariaveisProjeto.digitacaoCampo(textFieldQuantidade.getText())) {
			status = false;
			mudaStatusCheckQtd();
			return true; 
		}
		return false;
	}

	//////////////////////////////////////////////////////////////////////////////
	private void mudaStatusCheckNome() {
		checkNome.setVisible(true);
		if (status == false ) {
			checkNome.setIcon(new ImageIcon(ProdutosGUI.class.getResource("/com/salaodebeleza/estrutura/imagens/iconFechar.png")));
		} else {
			checkNome.setIcon(new ImageIcon(ProdutosGUI.class.getResource("/com/salaodebeleza/estrutura/imagens/ok.png")));
		}
	}

	private void mudaStatusCheckValor() {
		checkValor.setVisible(true);
		if (status == false ) {
			checkValor.setIcon(new ImageIcon(ProdutosGUI.class.getResource("/com/salaodebeleza/estrutura/imagens/iconFechar.png")));
		} else {
			checkValor.setIcon(new ImageIcon(ProdutosGUI.class.getResource("/com/salaodebeleza/estrutura/imagens/ok.png")));
		}
	}

	private void mudaStatusCheckQtd() {
		checkqtd.setVisible(true);
		if (status == false ) {
			checkqtd.setIcon(new ImageIcon(ProdutosGUI.class.getResource("/com/salaodebeleza/estrutura/imagens/iconFechar.png")));
		} else {
			checkqtd.setIcon(new ImageIcon(ProdutosGUI.class.getResource("/com/salaodebeleza/estrutura/imagens/ok.png")));
		}
	}

	private void desabilitaCheckCampos() {
		checkNome.setVisible(false);
		checkValor.setVisible(false);
		checkqtd.setVisible(false);
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

		btnBuscarCabeleireiro.addActionListener(new ActionListener() {
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

		
		  textFieldValor.addFocusListener(new FocusAdapter() {
		  
		  @Override 
		  public void focusLost(FocusEvent e) { 
		  if (verificaDigitacaoDoValor() ) { 
		  		textFieldValor.requestFocus(); 
		  } 
		  else {
		  		digitacaoValorValido(); 
		  }
		  
		  } });
		  
		 
		  textFieldQuantidade.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
			if(verificaDigitacaoQtd()) {
				textFieldQuantidade.requestFocus();
			}
			else {
				digitacaoQtdValida();
			}
			}
			
			});

		////////////////KEY PRESSED///////////////////////////////
		
		  textFieldCodigo.addKeyListener(new KeyAdapter() {
		  
		  @Override 
		  public void keyPressed(KeyEvent e) { 
			  if ( e.getKeyCode() == KeyEvent.VK_ENTER) { 
				  buscarProdutos(); 
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

		textFieldValor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if ( e.getKeyCode() == KeyEvent.VK_ENTER) {
					if ( verificaDigitacaoDoValor() ) {
						textFieldValor.requestFocus();	
					} else {
						digitacaoValorValido();
					}	
					textFieldQuantidade.requestFocus();
				}
			}
		});
		
		textFieldQuantidade.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if ( verificaDigitacaoQtd() ) {
					textFieldQuantidade.requestFocus();	
				} else {
					digitacaoQtdValida();
				}	
				textFieldQuantidade.requestFocus();
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
		
		Produtos produtos = pegarDadosProdutos();
		
		produtos.setusuario(cabeleireiro);
		
		ProdutosService produtosService = new ProdutosService();
		
		toReturn = produtosService.save(produtos);
		
		erroDigitacao(toReturn);
		
		if ( toReturn == VariaveisProjeto.ERRO_INCLUSAO ) {
			showMensagem("Erro na Inclusão do Registro, verifique com seu administrador!",
					   	 "Erro",JOptionPane.ERROR_MESSAGE);
		}
		if ( toReturn == VariaveisProjeto.INCLUSAO_REALIZADA) {
			showMensagem("Inclusão do Registro realizada com sucesso!",
					     "OK",JOptionPane.OK_OPTION);
			limpaTextoCampo();
			tabelaProdutosModel.fireTableDataChanged();
			produtos = new Produtos();
		}

	}


	protected void excluir() {
		
		Integer toReturn = 0;
		
		Produtos produtos = pegarDadosProdutos();
		
		ProdutosService produtosService = new ProdutosService();
		
		toReturn = produtosService.delete(produtos);
		
		if ( toReturn == VariaveisProjeto.ERRO_EXCLUSAO ) {
			showMensagem("Erro na Exclusão do Registro, verifique com seu administrador!",
					   	 "Erro",JOptionPane.ERROR_MESSAGE);
		}
		if ( toReturn == VariaveisProjeto.EXCLUSAO_REALIZADA) {
			showMensagem("Exclusão do Registro realizada com sucesso!",
					     "OK",JOptionPane.OK_OPTION);
			limpaTextoCampo();
			produtos = new Produtos();
		}

	}

	protected void alterar() {
		
		Integer toReturn = 0;
		
	    Produtos produtos = pegarDadosProdutos();
	    
	    produtos.setusuario(cabeleireiro);
	    
	    ProdutosService produtosService = new ProdutosService();
		
		toReturn = produtosService.update(produtos);
		
		erroDigitacao(toReturn);
		
		if ( toReturn == VariaveisProjeto.ERRO_ALTERACAO ) {
			showMensagem("Erro na Alteração do Registro, verifique com seu administrador!",
					   	 "Erro",JOptionPane.ERROR_MESSAGE);
		}
		if ( toReturn == VariaveisProjeto.ALTERACAO_REALIZADA) {
			showMensagem("Alteração do Registro realizada com sucesso!",
					     "OK",JOptionPane.OK_OPTION);
			
			tabelaProdutosModel.fireTableDataChanged();
			limpaTextoCampo();
			produtos = new Produtos();
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
			 mudaStatusCheckValor(); // mudei aqui antes era mudaStatusCheckNome();
			 showMensagem("Erro na digitação do Valor, verifique!","Erro", JOptionPane.ERROR_MESSAGE);
		}
		if ( toReturn == VariaveisProjeto.CLIENTE_ANOTACOES ) {
			 status = false;
			 mudaStatusCheckQtd(); // mudei aqui antes era mudaStatusCheckNome();
			 showMensagem("Erro na digitação das Anotações, verifique!","Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void showMensagem(String mensagem, String status, int option)
	{
		JOptionPane.showMessageDialog(null, mensagem, status, option);
	}

	@SuppressWarnings("deprecation")
	public Produtos pegarDadosProdutos() {
		
		Produtos produtos = new Produtos();
		
		
		if (VariaveisProjeto.digitacaoCampo(textFieldCodigo.getText())){
		 textFieldCodigo.requestFocus(); 
		}
		
	    if (VariaveisProjeto.digitacaoCampo(textFieldCodigo.getText()) == false ) {
	    	produtos.setId(Integer.valueOf(textFieldCodigo.getText()));
	    }
	    
		produtos.setNome(textFieldNome.getText());
		produtos.setValor(Float.valueOf(textFieldValor.getText()));
		produtos.setQtd(Integer.valueOf(textFieldQuantidade.getText()));
		produtos.setusuario(cabeleireiro);
		
		
		
		return produtos;

	}

	private void buscarProdutos() {

		
		  Produtos produtos = new Produtos();
		 
		/* if (VariaveisProjeto.digitacaoCampo(textFieldCodigo.getText())){
		 * textFieldCodigo.requestFocus(); return;
		 * 
		 * }
		 * 
		 * Integer id = Integer.valueOf(textFieldCodigo.getText());
		 */
		
		produtos = tabelaProdutosModel.getProdutos(this.linha); 
		
		
		textFieldCodigo.setText(String.valueOf(produtos.getId()));
		textFieldNome.setText(produtos.getNome());
		textFieldValor.setText(String.valueOf(produtos.getValor()));
		textFieldQuantidade.setText(String.valueOf(produtos.getQtd()));
		
		textFieldCabeleireiro.setText(produtos.getusuario().getUsername());
		
	
	}

	private void limpaTextoCampo() {
		textFieldCodigo.setText(VariaveisProjeto.LIMPA_CAMPO);
		textFieldNome.setText(VariaveisProjeto.LIMPA_CAMPO);
		textFieldValor.setText(VariaveisProjeto.LIMPA_CAMPO);
		textFieldQuantidade.setText(VariaveisProjeto.LIMPA_CAMPO);
		textFieldCabeleireiro.setText(VariaveisProjeto.LIMPA_CAMPO);
	}

}
