package com.salaodebeleza.view.procedimentos;

import java.awt.BorderLayout;
import java.awt.EventQueue;
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
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.salaodebeleza.estrutura.util.VariaveisProjeto;
import com.salaodebeleza.model.modells.Procedimentos;
import com.salaodebeleza.model.modells.Usuario;
import com.salaodebeleza.model.service.ProcedimentosService;
import com.salaodebeleza.model.service.UsuarioService;
import com.salaodebeleza.view.procedimentos.ProcedimentosGUI;
import com.salaodebeleza.view.procedimentos.TabelaProcedimentosModel;
import com.salaodebeleza.view.usuario.BuscaCabeleireiro;

public class ProcedimentosGUI extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -835865286973400472L;
	private JPanel contentPane;
	private JTextField textFieldNome;
	private JButton btnIncluir;
	private JButton btnAlterar;
	private JButton btnExcluir;

	private JButton btnSair;
	private JLabel lblCodigo;
	private JTextField textFieldCodigo;
	private JLabel lblNome;

	private JLabel checkNome;

	private boolean status = true; 

	private JTable tabelaProcedimentos;
	private TabelaProcedimentosModel tabelaProcedimentosModel;
	
	private int linha =0;
	private int acao = 0;
	private JLabel lblCabeleireiro;
	private JTextField textFieldCabeleireiro;
	private JButton btnBuscarCabeleireiro;
	
	private Usuario cabeleireiro;
	
	/**
	 * Create the frame.
	 */
	public ProcedimentosGUI(JFrame frame, boolean modal, JTable tabelaProcedimentos, TabelaProcedimentosModel tabelaProcedimentosModel, int linha, int acao) {
		
		super(frame, modal);
		
		this.tabelaProcedimentos = tabelaProcedimentos;
		this.tabelaProcedimentosModel = tabelaProcedimentosModel;
		this.linha = linha;
		this.acao = acao;
	
		
		setTitle("Cadastro de Procedimentos");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 292);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		lblNome = new JLabel("Nome:");

		textFieldNome = new JTextField();


		textFieldNome.setColumns(10);



		btnIncluir = new JButton("Incluir");
		btnIncluir.setIcon(new ImageIcon(ProcedimentosGUI.class.getResource("/com/salaodebeleza/estrutura/imagens/application_add.png")));

		btnAlterar = new JButton("Alterar");
		btnAlterar.setIcon(new ImageIcon(ProcedimentosGUI.class.getResource("/com/salaodebeleza/estrutura/imagens/application_edit.png")));


		btnExcluir = new JButton("Excluir");
		btnExcluir.setIcon(new ImageIcon(ProcedimentosGUI.class.getResource("/com/salaodebeleza/estrutura/imagens/application_delete.png")));


		btnSair = new JButton("Sair");
		btnSair.setIcon(new ImageIcon(ProcedimentosGUI.class.getResource("/com/salaodebeleza/estrutura/imagens/sair.png")));

		lblCodigo = new JLabel("C\u00F3digo: ");

		textFieldCodigo = new JTextField();
		textFieldCodigo.setEditable(false);



		textFieldCodigo.setColumns(10);

		checkNome = new JLabel("");
		checkNome.setIcon(new ImageIcon(ProcedimentosGUI.class.getResource("/com/salaodebeleza/estrutura/imagens/ok.png")));
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setMnemonic(KeyEvent.VK_D);
		btnNewButton.setToolTipText("Buscar procedimentos");
		btnNewButton.setIcon(new ImageIcon(ProcedimentosGUI.class.getResource("/com/salaodebeleza/estrutura/imagens/search.png")));
		
		lblCabeleireiro = new JLabel("Cabeleireiro(a):");
		
		textFieldCabeleireiro = new JTextField();
		textFieldCabeleireiro.setColumns(10);
		textFieldCabeleireiro.setEditable(false);
		
		btnBuscarCabeleireiro = new JButton("");
		btnBuscarCabeleireiro.setIcon(new ImageIcon(ProcedimentosGUI.class.getResource("/com/salaodebeleza/estrutura/imagens/search.png")));
		
		btnBuscarCabeleireiro.setMnemonic(KeyEvent.VK_D);
		btnBuscarCabeleireiro.setToolTipText("Buscar Cabeleireiro");

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(112)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblCabeleireiro)
						.addComponent(lblCodigo)
						.addComponent(lblNome))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textFieldCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(textFieldCabeleireiro, Alignment.LEADING)
								.addComponent(textFieldNome, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(26)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
										.addComponent(checkNome)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(18)
									.addComponent(btnBuscarCabeleireiro, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(133, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(159, Short.MAX_VALUE)
					.addComponent(btnIncluir)
					.addGap(18)
					.addComponent(btnAlterar)
					.addGap(18)
					.addComponent(btnExcluir)
					.addGap(18)
					.addComponent(btnSair)
					.addGap(125))
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
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(textFieldCabeleireiro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblCabeleireiro))
						.addComponent(btnBuscarCabeleireiro))
					.addGap(23)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnIncluir)
						.addComponent(btnAlterar)
						.addComponent(btnExcluir)
						.addComponent(btnSair))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(107, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		createEvents();

		limpaTextoCampo();

		desabilitaCheckCampos();
		
		/*
		 * btnAlterar.setEnabled(false); btnIncluir.setEnabled(false);
		 * btnExcluir.setEnabled(false);
		 */
		
		configuraAcaoProcedimentos();
	}
	
	
	private void configuraAcaoProcedimentos() {
		
		if(this.acao == VariaveisProjeto.INCLUSAO) {
			btnIncluir.setEnabled(true);
			btnAlterar.setVisible(false);
			btnExcluir.setVisible(false);
		}
		
		if(this.acao == VariaveisProjeto.ALTERACAO) {
			btnAlterar.setEnabled(true);
			btnIncluir.setVisible(false);
			btnExcluir.setVisible(false);
			buscarProcedimentos();
		}
		
		if(this.acao == VariaveisProjeto.EXCLUSAO) {
			buscarProcedimentos();
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
	}


	//////////////////////////////////////////////////////////////////////////////
	private void mudaStatusCheckNome() {
		checkNome.setVisible(true);
		if (status == false ) {
			checkNome.setIcon(new ImageIcon(ProcedimentosGUI.class.getResource("/com/salaodebeleza/estrutura/imagens/iconFechar.png")));
		} else {
			checkNome.setIcon(new ImageIcon(ProcedimentosGUI.class.getResource("/com/salaodebeleza/estrutura/imagens/ok.png")));
		}
	}


	private void desabilitaCheckCampos() {
		checkNome.setVisible(false);
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

		////////////////KEY PRESSED///////////////////////////////
		
		  textFieldCodigo.addKeyListener(new KeyAdapter() {
		  
		  @Override 
		  public void keyPressed(KeyEvent e) { 
			  if ( e.getKeyCode() == KeyEvent.VK_ENTER) { 
				  buscarProcedimentos(); 
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
		
		Procedimentos procedimentos = pegarDadosProcedimentos();
		
		procedimentos.setUsuario(cabeleireiro);
		
		ProcedimentosService procedimentosService = new ProcedimentosService();
		
		toReturn = procedimentosService.save(procedimentos);
		
		erroDigitacao(toReturn);
		
		if ( toReturn == VariaveisProjeto.ERRO_INCLUSAO ) {
			showMensagem("Erro na Inclusão do Registro, verifique com seu administrador!",
					   	 "Erro",JOptionPane.ERROR_MESSAGE);
		}
		if ( toReturn == VariaveisProjeto.INCLUSAO_REALIZADA) {
			showMensagem("Inclusão do Registro realizada com sucesso!",
					     "OK",JOptionPane.OK_OPTION);
			limpaTextoCampo();
			tabelaProcedimentosModel.fireTableDataChanged();
			procedimentos = new Procedimentos();
		}

	}


	protected void excluir() {
		
		Integer toReturn = 0;
		
		Procedimentos procedimentos = pegarDadosProcedimentos();
		
		ProcedimentosService procedimentosService = new ProcedimentosService();
		
		toReturn = procedimentosService.delete(procedimentos);
		
		if ( toReturn == VariaveisProjeto.ERRO_EXCLUSAO ) {
			showMensagem("Erro na Exclusão do Registro, verifique com seu administrador!",
					   	 "Erro",JOptionPane.ERROR_MESSAGE);
		}
		if ( toReturn == VariaveisProjeto.EXCLUSAO_REALIZADA) {
			showMensagem("Exclusão do Registro realizada com sucesso!",
					     "OK",JOptionPane.OK_OPTION);
			limpaTextoCampo();
			procedimentos = new Procedimentos();
		}

	}

	protected void alterar() {
		
		Integer toReturn = 0;
		
	    Procedimentos procedimentos = pegarDadosProcedimentos();
	    
	    procedimentos.setUsuario(cabeleireiro);
	    
	    ProcedimentosService procedimentosService = new ProcedimentosService();
		
		toReturn = procedimentosService.update(procedimentos);
		
		erroDigitacao(toReturn);
		
		if ( toReturn == VariaveisProjeto.ERRO_ALTERACAO ) {
			showMensagem("Erro na Alteração do Registro, verifique com seu administrador!",
					   	 "Erro",JOptionPane.ERROR_MESSAGE);
		}
		if ( toReturn == VariaveisProjeto.ALTERACAO_REALIZADA) {
			showMensagem("Alteração do Registro realizada com sucesso!",
					     "OK",JOptionPane.OK_OPTION);
			
			tabelaProcedimentosModel.fireTableDataChanged();
			limpaTextoCampo();
			procedimentos = new Procedimentos();
		}
		
		
	}
	
	private void erroDigitacao(Integer toReturn) {
		if ( toReturn == VariaveisProjeto.PROCEDIMENTO_NOME) {
			 status = false;
			 mudaStatusCheckNome();
			 showMensagem("Erro na digitação do Nome, verifique!","Erro", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	private void showMensagem(String mensagem, String status, int option)
	{
		JOptionPane.showMessageDialog(null, mensagem, status, option);
	}

	@SuppressWarnings("deprecation")
	public Procedimentos pegarDadosProcedimentos() {
		
		Procedimentos procedimentos = new Procedimentos();
		
		
		if (VariaveisProjeto.digitacaoCampo(textFieldCodigo.getText())){
		 textFieldCodigo.requestFocus(); 
		}
		
	    if (VariaveisProjeto.digitacaoCampo(textFieldCodigo.getText()) == false ) {
	    	procedimentos.setId(Integer.valueOf(textFieldCodigo.getText()));
	    }
	    
		procedimentos.setNome(textFieldNome.getText());
		procedimentos.setUsuario(cabeleireiro);
		
		
		
		return procedimentos;

	}

	private void buscarProcedimentos() {

		
		  Procedimentos procedimentos = new Procedimentos();
		 
		/* if (VariaveisProjeto.digitacaoCampo(textFieldCodigo.getText())){
		 * textFieldCodigo.requestFocus(); return;
		 * 
		 * }
		 * 
		 * Integer id = Integer.valueOf(textFieldCodigo.getText());
		 */
		
		procedimentos = tabelaProcedimentosModel.getProcedimentos(this.linha); 
		
		
		textFieldCodigo.setText(String.valueOf(procedimentos.getId()));
		textFieldNome.setText(procedimentos.getNome());
		
		textFieldCabeleireiro.setText(procedimentos.getUsuario().getUsername());
		
	
	}

	private void limpaTextoCampo() {
		textFieldCodigo.setText(VariaveisProjeto.LIMPA_CAMPO);
		textFieldNome.setText(VariaveisProjeto.LIMPA_CAMPO);
		textFieldCabeleireiro.setText(VariaveisProjeto.LIMPA_CAMPO);
	}
}
