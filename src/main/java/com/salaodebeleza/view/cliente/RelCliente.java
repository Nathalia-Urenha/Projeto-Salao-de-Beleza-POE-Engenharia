package com.salaodebeleza.view.cliente;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.salaodebeleza.model.modells.Cliente;
import com.salaodebeleza.model.modells.PrintJasperReport;
import com.salaodebeleza.model.service.ClienteService;
import com.salaodebeleza.model.service.JasperReportsService;


public class RelCliente extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8425182307593508877L;

	private final JPanel contentPanel = new JPanel();

	private JButton btnNewButton;

	
	public RelCliente(JFrame frame, boolean modal) {

		super(frame, modal);
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		btnNewButton = new JButton("Relatório SQL");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				imprimeRelatorioPorSQL();
			}
		});
		btnNewButton.setBounds(10, 194, 97, 23);
		btnNewButton.setActionCommand("");
		contentPanel.add(btnNewButton);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						imprimeRelatorioPorLista();
						
					}

					
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	protected void imprimeRelatorioPorSQL() {
		PrintJasperReport printJasperReport = new PrintJasperReport();
		JasperReportsService jasperReportsService = new JasperReportsService();
		printJasperReport.setFile("rel_cliente_sql");
		setVisible(false);
		jasperReportsService.generateSQLReports(printJasperReport);
	}

	private void imprimeRelatorioPorLista() {
		ClienteService clienteService = new ClienteService();
		PrintJasperReport printJasperReport = new PrintJasperReport();
		JasperReportsService jasperReportsService = new JasperReportsService();

	    List<Cliente> listaCliente = clienteService.findAll();
		
		printJasperReport.setFile("rel_cliente");
		printJasperReport.setCollection(listaCliente);
		setVisible(false);
		jasperReportsService.generateListReports(printJasperReport);
	}

}
