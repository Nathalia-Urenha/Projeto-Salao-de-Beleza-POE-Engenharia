package com.salaodebeleza.view.usuario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import com.salaodebeleza.estrutura.util.VariaveisProjeto;
import com.salaodebeleza.estrutura.util.imagem.ImageFilter;
import com.salaodebeleza.estrutura.util.imagem.ImagePreview;
import com.salaodebeleza.model.modells.Foto;
import com.salaodebeleza.model.modells.Produtos;
import com.salaodebeleza.model.modells.Usuario;
import com.salaodebeleza.model.service.LocalFotoStorageService;
import com.salaodebeleza.model.service.UsuarioService;

public class CabeleireiroGUI extends JDialog {

	private static final long serialVersionUID = 1867371822121507791L;
	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldEmail;
	private JButton btnIncluir;
	private JButton btnAlterar;
	private JButton btnExcluir;
	private JRadioButton rdbtnAtivo;
	private JButton btnRelatorio;

	private JButton btnSair;
	private JPasswordField passwordFieldSenha;
	private JLabel lblCodigo;
	private JTextField textFieldCodigo;
	private JLabel lblNome;
	private JLabel lblSenha;

	private JLabel checkNome;
	private JLabel checkEmail;
	private JLabel checkSenha;
	private JButton btnFoto;
	private JButton btnExcluirFoto;
	private JLabel lblFoto;
	private JPanel panel;

	private boolean status = true; 

	private JTable tabelaUsuario;
	private TabelaCabeleireiroModel tabelaUsuarioModel;
	
	private int linha =0;
	private int acao = 0;
	
	private String nomeFoto;
	
	/**
	 * Create the frame.
	 */
	public CabeleireiroGUI(JFrame frame, boolean modal, JTable tabelaUsuario, TabelaCabeleireiroModel tabelaUsuarioModel, int linha, int acao) {
		
		super(frame, modal);
		
		this.tabelaUsuario = tabelaUsuario;
		this.tabelaUsuarioModel = tabelaUsuarioModel;
		this.linha = linha;
		this.acao = acao;
	
		
		setTitle("Cadastro de Cabeleireiro(a)");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 767, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		lblNome = new JLabel("Nome:");

		textFieldNome = new JTextField();


		textFieldNome.setColumns(10);

		JLabel lblEmail = new JLabel("E-mail:");

		textFieldEmail = new JTextField();


		textFieldEmail.setColumns(10);

		lblSenha = new JLabel("Senha:");
		lblSenha.setHorizontalAlignment(SwingConstants.TRAILING);

		rdbtnAtivo = new JRadioButton("Ativo");



		btnIncluir = new JButton("Incluir");
		btnIncluir.setIcon(new ImageIcon(CabeleireiroGUI.class.getResource("/com/salaodebeleza/estrutura/imagens/application_add.png")));

		btnAlterar = new JButton("Alterar");
		btnAlterar.setIcon(new ImageIcon(CabeleireiroGUI.class.getResource("/com/salaodebeleza/estrutura/imagens/application_edit.png")));


		btnExcluir = new JButton("Excluir");
		btnExcluir.setIcon(new ImageIcon(CabeleireiroGUI.class.getResource("/com/salaodebeleza/estrutura/imagens/application_delete.png")));


		btnSair = new JButton("Sair");
		btnSair.setIcon(new ImageIcon(CabeleireiroGUI.class.getResource("/com/salaodebeleza/estrutura/imagens/sair.png")));

		passwordFieldSenha = new JPasswordField();

		lblCodigo = new JLabel("C\u00F3digo: ");

		textFieldCodigo = new JTextField();
		textFieldCodigo.setEditable(false);



		textFieldCodigo.setColumns(10);

		checkNome = new JLabel("");
		checkNome.setIcon(new ImageIcon(CabeleireiroGUI.class.getResource("/com/salaodebeleza/estrutura/imagens/ok.png")));

		checkEmail = new JLabel("");
		checkEmail.setIcon(new ImageIcon(CabeleireiroGUI.class.getResource("/com/salaodebeleza/estrutura/imagens/ok.png")));

		checkSenha = new JLabel("");
		checkSenha.setIcon(new ImageIcon(CabeleireiroGUI.class.getResource("/com/salaodebeleza/estrutura/imagens/ok.png")));
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setMnemonic(KeyEvent.VK_D);
		btnNewButton.setToolTipText("Buscar produtos");
		btnNewButton.setIcon(new ImageIcon(CabeleireiroGUI.class.getResource("/com/salaodebeleza/estrutura/imagens/search.png")));
		
		panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		
		lblFoto = new JLabel("");
		lblFoto.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		
		btnFoto = new JButton("");
		
		btnFoto.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnFoto.setIcon(new ImageIcon(CabeleireiroGUI.class.getResource("/com/salaodebeleza/estrutura/imagens/camera-dslr.png")));
		
		btnExcluirFoto = new JButton("");
		
		btnExcluirFoto.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnExcluirFoto.setIcon(new ImageIcon(CabeleireiroGUI.class.getResource("/com/salaodebeleza/estrutura/imagens/iconFechar.png")));


		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(32)
							.addComponent(btnIncluir)
							.addGap(18)
							.addComponent(btnAlterar)
							.addGap(18)
							.addComponent(btnExcluir)
							.addGap(18)
							.addComponent(btnSair)
							.addGap(18)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(75)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblCodigo)
								.addComponent(lblSenha)
								.addComponent(lblEmail)
								.addComponent(lblNome))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textFieldCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(rdbtnAtivo)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
											.addComponent(textFieldEmail, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
											.addComponent(textFieldNome, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
											.addComponent(passwordFieldSenha, Alignment.LEADING))
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
											.addComponent(checkSenha)
											.addComponent(checkEmail)
											.addComponent(checkNome)))))
							.addGap(60)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnFoto, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
									.addGap(31)
									.addComponent(btnExcluirFoto, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addComponent(lblFoto, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(48, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
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
								.addComponent(lblEmail)
								.addComponent(textFieldEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(checkEmail))
							.addGap(26)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSenha)
								.addComponent(passwordFieldSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(checkSenha))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE)
								.addComponent(rdbtnAtivo)))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblFoto, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnExcluirFoto, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnFoto, GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))
							.addGap(23)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnIncluir)
								.addComponent(btnAlterar)
								.addComponent(btnExcluir)
								.addComponent(btnSair)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(9)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(57, Short.MAX_VALUE))
		);
		panel.setLayout(null);
		
		btnRelatorio = new JButton("Relat\u00F3rio");
		
		btnRelatorio.setIcon(new ImageIcon(CabeleireiroGUI.class.getResource("/com/salaodebeleza/estrutura/imagens/pdf.png")));
		btnRelatorio.setBounds(7, 7, 99, 28);
		btnRelatorio.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.add(btnRelatorio);
		contentPane.setLayout(gl_contentPane);
		createEvents();

		limpaTextoCampo();

		desabilitaCheckCampos();
		
		/*
		 * btnAlterar.setEnabled(false); btnIncluir.setEnabled(false);
		 * btnExcluir.setEnabled(false);
		 */
		
		configuraAcaoUsuario();
	}
	
	
	


	private void configuraAcaoUsuario() {
		
		if(this.acao == VariaveisProjeto.INCLUSAO) {
			btnIncluir.setEnabled(true);
			btnAlterar.setVisible(false);
			btnExcluir.setVisible(false);
		}
		
		if(this.acao == VariaveisProjeto.ALTERACAO) {
			btnAlterar.setEnabled(true);
			btnIncluir.setVisible(false);
			btnExcluir.setVisible(false);
			buscarUsuario();
		}
		
		if(this.acao == VariaveisProjeto.EXCLUSAO) {
			buscarUsuario();
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
		textFieldEmail.requestFocus();
	}

	private boolean verificaDigitacaoDoEmail() {
		if ( VariaveisProjeto.digitacaoCampo(textFieldEmail.getText())) {
			status = false;
			mudaStatusCheckEmail();
			return true; 
		}
		return false;
	}

	private void digitacaoEmailValido() {
		status = true;
		mudaStatusCheckEmail();
		checkEmail.setVisible(true);	
		passwordFieldSenha.requestFocus();
	}

	private void digitacaoSenhaValida() {
		status = true;
		mudaStatusCheckSenha();
		checkSenha.setVisible(true);	
		rdbtnAtivo.requestFocus();
	}


	@SuppressWarnings("deprecation")
	private boolean verificaDigitacaoSenha() {
		if ( VariaveisProjeto.digitacaoCampo(passwordFieldSenha.getText())) {
			status = false;
			mudaStatusCheckSenha();
			return true; 
		}
		return false;
	}

	//////////////////////////////////////////////////////////////////////////////
	private void mudaStatusCheckNome() {
		checkNome.setVisible(true);
		if (status == false ) {
			checkNome.setIcon(new ImageIcon(CabeleireiroGUI.class.getResource("/com/salaodebeleza/estrutura/imagens/iconFechar.png")));
		} else {
			checkNome.setIcon(new ImageIcon(CabeleireiroGUI.class.getResource("/com/salaodebeleza/estrutura/imagens/ok.png")));
		}
	}

	private void mudaStatusCheckEmail() {
		checkEmail.setVisible(true);
		if (status == false ) {
			checkEmail.setIcon(new ImageIcon(CabeleireiroGUI.class.getResource("/com/salaodebeleza/estrutura/imagens/iconFechar.png")));
		} else {
			checkEmail.setIcon(new ImageIcon(CabeleireiroGUI.class.getResource("/com/salaodebeleza/estrutura/imagens/ok.png")));
		}
	}

	private void mudaStatusCheckSenha() {
		checkSenha.setVisible(true);
		if (status == false ) {
			checkSenha.setIcon(new ImageIcon(CabeleireiroGUI.class.getResource("/com/salaodebeleza/estrutura/imagens/iconFechar.png")));
		} else {
			checkSenha.setIcon(new ImageIcon(CabeleireiroGUI.class.getResource("/com/salaodebeleza/estrutura/imagens/ok.png")));
		}
	}

	private void desabilitaCheckCampos() {
		checkNome.setVisible(false);
		checkEmail.setVisible(false);
		checkSenha.setVisible(false);
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
		
		btnRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imprimeRelatorio();
			}
		});
		
		btnFoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				carregaImagem();
			}
		});
		
		btnExcluirFoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirFoto();
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

		
		  textFieldEmail.addFocusListener(new FocusAdapter() {
		  
		  @Override 
		  public void focusLost(FocusEvent e) { 
		  if (verificaDigitacaoDoEmail() ) { 
		  		textFieldEmail.requestFocus(); 
		  } 
		  else {
		  		digitacaoEmailValido(); 
		  }
		  
		  } });
		 

		
		  passwordFieldSenha.addFocusListener(new FocusAdapter() {
		  
		  @Override public void focusLost(FocusEvent e) { 
		  if ( verificaDigitacaoSenha())  { 
		  	passwordFieldSenha.requestFocus(); 
		  } 
		  else { 
		  		digitacaoSenhaValida(); 
		  } 
		  }
		  });
		 

		////////////////KEY PRESSED///////////////////////////////
		
		  textFieldCodigo.addKeyListener(new KeyAdapter() {
		  
		  @Override 
		  public void keyPressed(KeyEvent e) { 
			  if ( e.getKeyCode() == KeyEvent.VK_ENTER) { 
				  buscarUsuario(); 
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

		textFieldEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if ( e.getKeyCode() == KeyEvent.VK_ENTER) {
					if ( verificaDigitacaoDoEmail() ) {
						textFieldEmail.requestFocus();	
					} else {
						digitacaoEmailValido();
					}	
					passwordFieldSenha.requestFocus();
				}
			}
		});

		passwordFieldSenha.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if ( e.getKeyCode() == KeyEvent.VK_ENTER) {

					if ( verificaDigitacaoSenha() ) {
						passwordFieldSenha.requestFocus();	
					} else {
						digitacaoSenhaValida();
					}	
				}
			}
		});

	}






	////////////////////////////////////////////////////////////////////
	private void incluir() {
		
		Integer toReturn = 0;
		
		Usuario usuario = pegarDadosUsuario();
		
		UsuarioService usuarioService = new UsuarioService();
		
		toReturn = usuarioService.save(usuario);
		
		
		erroDigitacao(toReturn);
		
		if ( toReturn == VariaveisProjeto.ERRO_INCLUSAO ) {
			showMensagem("Erro na Inclusão do Registro, verifique com seu administrador!",
					   	 "Erro",JOptionPane.ERROR_MESSAGE);
		}
		if ( toReturn == VariaveisProjeto.INCLUSAO_REALIZADA) {
			showMensagem("Inclusão do Registro realizada com sucesso!",
					     "OK",JOptionPane.OK_OPTION);
			limpaTextoCampo();
			tabelaUsuarioModel.fireTableDataChanged();
			usuario = new Usuario();
		}

	}


	protected void excluir() {
		
		Integer toReturn = 0;
		
		Usuario usuario = pegarDadosUsuario();
		
		Produtos produtos = new Produtos();
		
		produtos.setId(1);
		produtos.setNome("Vendas");
		
		UsuarioService usuarioService = new UsuarioService();
		
		toReturn = usuarioService.delete(usuario);
		
		if ( toReturn == VariaveisProjeto.ERRO_EXCLUSAO ) {
			showMensagem("Erro na Exclusão do Registro, verifique com seu administrador!",
					   	 "Erro",JOptionPane.ERROR_MESSAGE);
		}
		if ( toReturn == VariaveisProjeto.EXCLUSAO_REALIZADA) {
			showMensagem("Exclusão do Registro realizada com sucesso!",
					     "OK",JOptionPane.OK_OPTION);
			limpaTextoCampo();
			usuario = new Usuario();
		}

	}

	protected void alterar() {
		
		Integer toReturn = 0;
		
	    Usuario usuario = pegarDadosUsuario();
	    
	    
	    UsuarioService usuarioService = new UsuarioService();
		
		toReturn = usuarioService.update(usuario);
		
		erroDigitacao(toReturn);
		
		if ( toReturn == VariaveisProjeto.ERRO_ALTERACAO ) {
			showMensagem("Erro na Alteração do Registro, verifique com seu administrador!",
					   	 "Erro",JOptionPane.ERROR_MESSAGE);
		}
		if ( toReturn == VariaveisProjeto.ALTERACAO_REALIZADA) {
			showMensagem("Alteração do Registro realizada com sucesso!",
					     "OK",JOptionPane.OK_OPTION);
			
			tabelaUsuarioModel.fireTableDataChanged();
			limpaTextoCampo();
			usuario = new Usuario();
		}
		
		
	}
	
	private void erroDigitacao(Integer toReturn) {
		if ( toReturn == VariaveisProjeto.USUARIO_USER_NAME ) {
			 status = false;
			 mudaStatusCheckNome();
			 showMensagem("Erro na digitação do Nome, verifique!","Erro", JOptionPane.ERROR_MESSAGE);
		}
		if ( toReturn == VariaveisProjeto.USUARIO_EMAIL ) {
			 status = false;
			 mudaStatusCheckNome();
			 showMensagem("Erro na digitação do E-mail, verifique!","Erro", JOptionPane.ERROR_MESSAGE);
		}
		if ( toReturn == VariaveisProjeto.USUARIO_PASSWORD ) {
			 status = false;
			 mudaStatusCheckNome();
			 showMensagem("Erro na digitação da Senha, verifique!","Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void showMensagem(String mensagem, String status, int option)
	{
		JOptionPane.showMessageDialog(null, mensagem, status, option);
	}

	@SuppressWarnings("deprecation")
	public Usuario pegarDadosUsuario() {
		
		Usuario usuario = new Usuario();
		
		
		if (VariaveisProjeto.digitacaoCampo(textFieldCodigo.getText())){
		 textFieldCodigo.requestFocus(); 
		}
		
	    if (VariaveisProjeto.digitacaoCampo(textFieldCodigo.getText()) == false ) {
	    	usuario.setId(Integer.valueOf(textFieldCodigo.getText()));
	    }
	    
		usuario.setUsername(textFieldNome.getText());
		usuario.setEmail(textFieldEmail.getText());
		usuario.setPassword(passwordFieldSenha.getText());
		usuario.setFoto(nomeFoto);
		
		if (rdbtnAtivo.isSelected()) {
			usuario.setAtivo(true);
		} else  {
			usuario.setAtivo(false);
		}
		
		return usuario;

	}

	private void buscarUsuario() {

		
		  Usuario usuario = new Usuario();
		 
		/* if (VariaveisProjeto.digitacaoCampo(textFieldCodigo.getText())){
		 * textFieldCodigo.requestFocus(); return;
		 * 
		 * }
		 * 
		 * Integer id = Integer.valueOf(textFieldCodigo.getText());
		 */
		
		usuario = tabelaUsuarioModel.getUsuario(this.linha);
		
		
		textFieldCodigo.setText(String.valueOf(usuario.getId()));
		textFieldNome.setText(usuario.getUsername());
		textFieldEmail.setText(usuario.getEmail());
		passwordFieldSenha.setText(usuario.getPassword());
		nomeFoto = usuario.getFoto();
		
		if(!Objects.isNull(nomeFoto)) {
			
			LocalFotoStorageService localFotoStorageService = new LocalFotoStorageService();
			
			String fileInput = localFotoStorageService.recuperar(nomeFoto);
			
			File file = new File(fileInput);
			
			FileInputStream fis;
			try {
				fis = new FileInputStream(file);
				BufferedImage img = ImageIO.read(fis);
				ImageIcon imagem = new ImageIcon(img);
				lblFoto.setIcon(imagem);
				lblFoto.setHorizontalAlignment(SwingConstants.CENTER);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		
		
		if ( usuario.isAtivo()) 
			rdbtnAtivo.setSelected(true); 
	

	}

	private void limpaTextoCampo() {
		textFieldCodigo.setText(VariaveisProjeto.LIMPA_CAMPO);
		textFieldNome.setText(VariaveisProjeto.LIMPA_CAMPO);
		textFieldEmail.setText(VariaveisProjeto.LIMPA_CAMPO);
		passwordFieldSenha.setText(VariaveisProjeto.LIMPA_CAMPO);
		rdbtnAtivo.setSelected(false);
	
	}
	
	protected void imprimeRelatorio() {
		
		RelUsuario relUsuario = new RelUsuario(new JFrame(), true);
		relUsuario.setLocationRelativeTo(null);
		setVisible(false);
		relUsuario.setVisible(true);
		
	}
	
	protected void carregaImagem() {
		JFileChooser fc = new JFileChooser();
		fc.addChoosableFileFilter(new ImageFilter());
		fc.setAcceptAllFileFilterUsed(false);
		fc.setAccessory(new ImagePreview(fc));
		int returnVal = fc.showDialog(lblFoto, "Anexar");
		
		if(lblFoto.getIcon() != null)
		{
			excluirFoto();
		}
		
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			
			try {
				File file = fc.getSelectedFile();
				FileInputStream fin = new FileInputStream(file);
				BufferedImage img = ImageIO.read(fin);
				ImageIcon icon = new ImageIcon(img);
				lblFoto.setIcon(icon);
				lblFoto.setHorizontalAlignment(SwingConstants.CENTER);
				LocalFotoStorageService localFotoStorageService = new LocalFotoStorageService();
				
				Foto foto = new Foto();
				
				foto.setNomeArquivo(file.getName());
				foto.setInputStraeam(fin);
				foto.setFile(file);
				
				nomeFoto = localFotoStorageService.armazenar(foto);
				
			} catch (IOException e) {
	
				e.printStackTrace();
			}
		}
		
	}
	
	protected void excluirFoto() {
		Usuario usuario = tabelaUsuarioModel.getUsuario(this.linha);
		nomeFoto = usuario.getFoto();
		LocalFotoStorageService localFotoStorageService = new LocalFotoStorageService();
		//erro no remover ou no nome da foto
		localFotoStorageService.remover(nomeFoto);
		lblFoto.setIcon(null);
		lblFoto.revalidate();
		
	}
}
