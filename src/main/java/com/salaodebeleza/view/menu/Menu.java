package com.salaodebeleza.view.menu;



import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;

import com.salaodebeleza.main.Login;
import com.salaodebeleza.view.cliente.TabelaCliente;
import com.salaodebeleza.view.produtos.TabelaProdutos;
import com.salaodebeleza.view.usuario.TabelaCabeleireiro;

public class Menu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5293985892829290141L;

	private JMenuBar menuBar;
	private JMenu mnArquivo;
	private JMenuItem mntmUsuario;
	private JMenuItem mntmLogout;
	private JPanel contentPane;
	
	private Login login;
	private JMenu mnSair;
	private JMenuItem mntmSairSistema;
	private JMenuItem mntmCliente;
	private JMenuItem mntmProdutos;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	
	public Menu(Login login) {
		this.login = login;
		initComponents();
	}
	
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 768, 443);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnArquivo = new JMenu("Arquivo");
		menuBar.add(mnArquivo);
		
		mntmProdutos = new JMenuItem("Produtos");
		
		mnArquivo.add(mntmProdutos);
		
		mntmCliente = new JMenuItem("Cliente");
		
		mnArquivo.add(mntmCliente);
		
		mntmUsuario = new JMenuItem("Usu\u00E1rio");
		
		mnArquivo.add(mntmUsuario);
		
		mntmLogout = new JMenuItem("Logout");
		
		mnArquivo.add(mntmLogout);
		
		mnSair = new JMenu("Sair");
		menuBar.add(mnSair);
		
		mntmSairSistema = new JMenuItem("Sair do sistema");
		
		mnSair.add(mntmSairSistema);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 742, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 394, Short.MAX_VALUE)
		);
		contentPane.setLayout(gl_contentPane);
		createEvents();
	}

	private void centralizaForm(JInternalFrame frame) {
		Dimension desktopSize = this.getSize();
		
		Dimension internalFrameSize = frame.getSize();
		
		frame.setLocation((desktopSize.width - internalFrameSize.width) / 2, (desktopSize.height - internalFrameSize.height) / 2 );
	}
	
	
	private void createEvents() {
		////////////ACTION LISTENER///////////////
		mntmUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TabelaCabeleireiro tabelaUsuario = new TabelaCabeleireiro();
				contentPane.add(tabelaUsuario);
				tabelaUsuario.setVisible(true);
	//			centralizaForm();
			}
		});
		
		mntmLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				login.setVisible(true);
				login.setLocationRelativeTo(null);
			}
		});
		
		mntmSairSistema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		mntmCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TabelaCliente tabelaCliente = new TabelaCliente();
				contentPane.add(tabelaCliente);
				tabelaCliente.setVisible(true);
			}
		});
		
		mntmProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TabelaProdutos tabelaProdutos = new TabelaProdutos();
				contentPane.add(tabelaProdutos);
				tabelaProdutos.setVisible(true);
			}
		});
		
	}
}
