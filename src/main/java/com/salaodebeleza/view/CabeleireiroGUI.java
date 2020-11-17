package com.salaodebeleza.view;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.salaodebeleza.estrutura.util.VariaveisProjeto;
import com.salaodebeleza.model.modells.Usuario;
import com.salaodebeleza.model.service.UsuarioService;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JRadioButton;

public class CabeleireiroGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldEmail;
	private JPasswordField passwordFieldSenha;
	private JButton btnIncluir;
	private JButton btnAlterar;
	private JButton btnExcluir;
	private JButton btnSair;
	private JLabel lblCodigo;
	private JTextField textFieldCodigo;
	private JRadioButton rdbtnAtivo;

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
		setTitle("Cadastro de Cabeleireiro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 559, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNome = new JLabel("Nome: ");
		
		textFieldNome = new JTextField();
		textFieldNome.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail: ");
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha: ");
		
		passwordFieldSenha = new JPasswordField();
		
		btnIncluir = new JButton("Incluir");
	
		btnAlterar = new JButton("Alterar");
		
		
		btnExcluir = new JButton("Excluir");
		
		btnSair = new JButton("Sair");
		
		lblCodigo = new JLabel("Codigo: ");
		
		textFieldCodigo = new JTextField();
		
		textFieldCodigo.setColumns(10);
		
		rdbtnAtivo = new JRadioButton("Ativo");
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(114, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblEmail)
						.addComponent(lblNome)
						.addComponent(lblSenha)
						.addComponent(lblCodigo))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(rdbtnAtivo)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnIncluir)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAlterar)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnExcluir)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnSair))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addComponent(textFieldEmail, GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
							.addComponent(textFieldNome)
							.addComponent(passwordFieldSenha))
						.addComponent(textFieldCodigo, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(103, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(32, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCodigo))
					.addGap(16)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome)
						.addComponent(textFieldNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmail)
						.addComponent(textFieldEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordFieldSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSenha))
					.addGap(27)
					.addComponent(rdbtnAtivo)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnIncluir)
						.addComponent(btnAlterar)
						.addComponent(btnExcluir)
						.addComponent(btnSair))
					.addContainerGap(118, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		createEvents();
	}
	
	private void createEvents() {
		
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				incluirCab();
			}
		});
		
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterarCab();
			}
		});
		
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirCab();
			}
		});
		
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		
		  textFieldCodigo.addFocusListener(new FocusAdapter() {
		  
		  @Override public void focusLost(FocusEvent e){
			  buscarUsuario();
			  } 
		  });
		 
	}
	
	private void incluirCab() {
		Usuario usuario = pegarDadosUsuario();

		UsuarioService usuarioService = new UsuarioService();
		
		usuarioService.save(usuario);
		
	}
	
	
	protected void excluirCab() {
		Usuario usuario = pegarDadosUsuario();
		
		UsuarioService usuarioService = new UsuarioService();
		
		usuarioService.delete(usuario);
		
	}
	
	protected void alterarCab() {
	    Usuario usuario = pegarDadosUsuario();
	    
	    UsuarioService usuarioService = new UsuarioService();
		
		usuarioService.update(usuario);
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
	 
}
