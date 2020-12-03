package com.salaodebeleza.view;

import java.awt.BorderLayout;




import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.salaodebeleza.view.CabeleireiroGUI;
import com.salaodebeleza.model.modells.Departamento;
import com.salaodebeleza.estrutura.util.VariaveisProjeto;
import com.salaodebeleza.model.modells.Usuario;
import com.salaodebeleza.model.service.UsuarioService;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CabeleireiroGUI extends JFrame {

	private static final long serialVersionUID = 1867371822121507791L;
	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldEmail;
	private JButton btnIncluir;
	private JButton btnAlterar;
	private JButton btnExcluir;
	private JRadioButton rdbtnAtivo;
	private JButton btnSair;
	private JPasswordField passwordFieldSenha;
	private JLabel lblCodigo;
	private JTextField textFieldCodigo;

	private JLabel checkNome;
	private JLabel checkEmail;
	private JLabel checkSenha;

	private boolean status = true; 


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CabeleireiroGUI frame = new CabeleireiroGUI();
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
	public CabeleireiroGUI() {
		setTitle("Cadastro de Usu\u00E1rios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNome = new JLabel("Nome:");

		textFieldNome = new JTextField();


		textFieldNome.setColumns(10);

		JLabel lblEmail = new JLabel("E-mail:");

		textFieldEmail = new JTextField();


		textFieldEmail.setColumns(10);

		JLabel lblSenha = new JLabel("Senha:");
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



		textFieldCodigo.setColumns(10);

		checkNome = new JLabel("");
		checkNome.setIcon(new ImageIcon(CabeleireiroGUI.class.getResource("/com/salaodebeleza/estrutura/imagens/ok.png")));

		checkEmail = new JLabel("");
		checkEmail.setIcon(new ImageIcon(CabeleireiroGUI.class.getResource("/com/salaodebeleza/estrutura/imagens/ok.png")));

		checkSenha = new JLabel("");
		checkSenha.setIcon(new ImageIcon(CabeleireiroGUI.class.getResource("/com/salaodebeleza/estrutura/imagens/ok.png")));


		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(74)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblCodigo)
								.addComponent(lblSenha)
								.addComponent(lblEmail)
								.addComponent(lblNome))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
												.addGroup(gl_contentPane.createSequentialGroup()
														.addComponent(btnIncluir)
														.addGap(18)
														.addComponent(btnAlterar)
														.addGap(18)
														.addComponent(btnExcluir)
														.addGap(18)
														.addComponent(btnSair))
												.addGroup(gl_contentPane.createSequentialGroup()
														.addComponent(rdbtnAtivo)
														.addGap(18))
												.addComponent(textFieldEmail, GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
												.addComponent(textFieldNome, GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
												.addComponent(passwordFieldSenha))
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(checkSenha)
												.addComponent(checkEmail)
												.addComponent(checkNome)))
								.addComponent(textFieldCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(116, Short.MAX_VALUE))
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
								.addComponent(lblEmail)
								.addComponent(textFieldEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(checkEmail))
						.addGap(26)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSenha)
								.addComponent(passwordFieldSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(checkSenha))
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(rdbtnAtivo))
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnIncluir)
								.addComponent(btnAlterar)
								.addComponent(btnExcluir)
								.addComponent(btnSair))
						.addContainerGap(71, Short.MAX_VALUE))
				);
		contentPane.setLayout(gl_contentPane);
		createEvents();

		limpaTextoCampo();

		desabilitaCheckCampos();
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

		/*
		 * textFieldEmail.addFocusListener(new FocusAdapter() {
		 * 
		 * @Override public void focusLost(FocusEvent e) { if (
		 * verificaDigitacaoDoEmail() ) { textFieldEmail.requestFocus(); } else {
		 * digitacaoEmailValido(); }
		 * 
		 * } });
		 */

		/*
		 * passwordFieldSenha.addFocusListener(new FocusAdapter() {
		 * 
		 * @Override public void focusLost(FocusEvent e) { if ( verificaDigitacaoSenha()
		 * ) { passwordFieldSenha.requestFocus(); } else { digitacaoSenhaValida(); } }
		 * });
		 */

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
		
		Departamento departamento = new Departamento();

		toReturn = usuarioService.save(usuario);
		
		if(toReturn == VariaveisProjeto.NOME_CAMPO_VAZIO)
		{
			status = false;
			mudaStatusCheckNome();
			showMensagem("O campo Nome deve ser informado", "Erro", JOptionPane.ERROR_MESSAGE);
		}
		
		if(toReturn == VariaveisProjeto.ERRO_INCLUSAO)
		{
			showMensagem("Erro na inclusão do registro, verifique com seu administrador!!", "Erro", JOptionPane.ERROR_MESSAGE);
		}
		
		if(toReturn == VariaveisProjeto.INCLUSAO_REALIZADA)
		{
			showMensagem("Inclusão realizada com sucesso!!", "OK", JOptionPane.YES_OPTION);
			
			limpaTextoCampo();
			
			usuario = new Usuario();
			
		}
	

	}


	protected void excluir() {
		
		Integer toReturn = 0;
		Usuario usuario = pegarDadosUsuario();

		UsuarioService usuarioService = new UsuarioService();

		toReturn = usuarioService.delete(usuario);
		
		if(toReturn == VariaveisProjeto.ERRO_EXCLUSAO)
		{
			showMensagem("Erro na exclusão do registro, verifique com seu administrador!!", "Erro", JOptionPane.ERROR_MESSAGE);
		}
		
		if(toReturn == VariaveisProjeto.EXCLUSAO_REALIZADA)
		{
			showMensagem("Exclusão realizada com sucesso!!", "OK", JOptionPane.OK_OPTION);
			
			limpaTextoCampo();
			
			usuario = new Usuario();
		}

	}

	protected void alterar() {
		
		Integer toReturn = 0;
		Usuario usuario = pegarDadosUsuario();

		UsuarioService usuarioService = new UsuarioService();

		toReturn = usuarioService.update(usuario);
		
		
		if(toReturn == VariaveisProjeto.ERRO_ALTERACAO)
		{
			showMensagem("Erro na alteração do registro, verifique com seu administrador!!", "Erro", JOptionPane.ERROR_MESSAGE);
		}
		
		if(toReturn == VariaveisProjeto.ALTERACAO_REALIZADA)
		{
			showMensagem("Alteração realizada com sucesso!!", "OK", JOptionPane.OK_OPTION);
			
			limpaTextoCampo();
			
			usuario = new Usuario();
		}
		
		
	}
	
	private void showMensagem(String mensagem, String status, int option)
	{
		JOptionPane.showMessageDialog(null, mensagem, status, option);
	}

	@SuppressWarnings("deprecation")
	public Usuario pegarDadosUsuario() {
		Usuario usuario = new Usuario();

		if (!"".equals(textFieldCodigo.getText())){
			usuario.setId( Integer.valueOf(textFieldCodigo.getText()));
		}

		usuario.setUsername(textFieldNome.getText());
		usuario.setEmail(textFieldEmail.getText());
		usuario.setPassword(passwordFieldSenha.getText());

		if (rdbtnAtivo.isSelected()) {
			usuario.setAtivo(true);
		} else  {
			usuario.setAtivo(false);
		}

		return usuario;

	}

	private void buscarUsuario() {

		Usuario usuario = new Usuario();

		if (VariaveisProjeto.digitacaoCampo(textFieldCodigo.getText())){
			textFieldCodigo.requestFocus(); return; }

		Integer id = Integer.valueOf(textFieldCodigo.getText());

		UsuarioService usuarioService = new UsuarioService();

		usuario = usuarioService.findById(id);

		textFieldNome.setText(usuario.getUsername());
		textFieldEmail.setText(usuario.getEmail());
		passwordFieldSenha.setText(usuario.getPassword());


		if ( usuario.isAtivo()) rdbtnAtivo.setSelected(true); 

	}

	private void limpaTextoCampo() {
		textFieldCodigo.setText(VariaveisProjeto.LIMPA_CAMPO);
		textFieldNome.setText(VariaveisProjeto.LIMPA_CAMPO);
		textFieldEmail.setText(VariaveisProjeto.LIMPA_CAMPO);
		passwordFieldSenha.setText(VariaveisProjeto.LIMPA_CAMPO);
		rdbtnAtivo.setSelected(false);
	}
}
