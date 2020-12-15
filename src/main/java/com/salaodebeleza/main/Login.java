package com.salaodebeleza.main;



import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;

import com.salaodebeleza.main.Login;
import com.salaodebeleza.view.menu.Menu;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6500341020159998010L;

	private JPanel contentPane;
	private JTextField textFieldEmail;
	private JTextField textFieldSenha;
	private JLabel lblEmail;
	private JLabel lblSenha;
	private JButton btnAcesso;
	private JButton btnCancelar;
	private JButton btnSair;
	
	private static Login frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Login();
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
	
	public Login() {
		initComponents();
	}
	
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 676, 437);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(45)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 552, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(53, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(21)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 340, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(27, Short.MAX_VALUE))
		);
		
		lblEmail = new JLabel("E-mail:");
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		
		lblSenha = new JLabel("Senha:");
		
		textFieldSenha = new JTextField();
		textFieldSenha.setColumns(10);
		
		btnAcesso = new JButton("Acesso");
		
		
		btnAcesso.setIcon(new ImageIcon(Login.class.getResource("/com/salaodebeleza/estrutura/imagens/application_get.png")));
		
		btnCancelar = new JButton("Cancelar");
		
		btnCancelar.setIcon(new ImageIcon(Login.class.getResource("/com/salaodebeleza/estrutura/imagens/iconFechar.png")));
		
		btnSair = new JButton("Sair");
		
		btnSair.setIcon(new ImageIcon(Login.class.getResource("/com/salaodebeleza/estrutura/imagens/sair.png")));
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap(123, Short.MAX_VALUE)
							.addComponent(btnAcesso)
							.addGap(29)
							.addComponent(btnCancelar)
							.addGap(25)
							.addComponent(btnSair))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(117)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblSenha)
								.addComponent(lblEmail))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textFieldSenha)
								.addComponent(textFieldEmail, GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE))))
					.addContainerGap(75, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(88)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmail)
						.addComponent(textFieldEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(44)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSenha)
						.addComponent(textFieldSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAcesso)
						.addComponent(btnCancelar)
						.addComponent(btnSair))
					.addContainerGap(105, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		createEvents();
	}
	
	private void createEvents(){
		////////////ACTION LISTENER///////////////////////////////
		btnAcesso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginSistema();
			}
		});
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldEmail.requestFocus();
			}
		});
		
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		/////////////KEY PRESSED///////////////////////////////////
		btnAcesso.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
			}
		});
		
		btnCancelar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		
	}

	protected void loginSistema() {
		acessoMenu();
		
	}

	private void acessoMenu() {
		Menu menu = new Menu(frame);
		menu.setVisible(true);
		menu.setResizable(false);
		menu.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

}
