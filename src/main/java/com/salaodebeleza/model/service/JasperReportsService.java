package com.salaodebeleza.model.service;

import java.awt.GraphicsConfiguration;

import java.awt.HeadlessException;
import java.io.InputStream;

import javax.swing.JFrame;

import com.salaodebeleza.estrutura.util.VariaveisProjeto;
import com.salaodebeleza.model.modells.PrintJasperReport;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;

public class JasperReportsService extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4212968336045434074L;
	
	
	
	 private DataSource dataSource;
		
		public JasperReportsService() {
			dataSource = new DataSource();
		}

		
		public void generateSQLReports(PrintJasperReport printJasperReport) {
			
			try {

				InputStream fileIn = getClass().getClassLoader().getResourceAsStream(
						VariaveisProjeto.DIRETORIO_RELATORIO + printJasperReport.getFile() + VariaveisProjeto.SUFIXO_RELATORIO_COMPILADO);

				JasperPrint jasperPrint = JasperFillManager.fillReport(fileIn,
																	   printJasperReport.getParams(),
																	   dataSource.getConnection());
				
				viewReports(jasperPrint);
				
			} catch (JRException e) {
				e.printStackTrace();
			}
		}
		
		
		
		public void generateListReports(PrintJasperReport printJasperReport) {
			
			try {

				InputStream fileIn = getClass().getClassLoader().getResourceAsStream(
						VariaveisProjeto.DIRETORIO_RELATORIO + printJasperReport.getFile() + VariaveisProjeto.SUFIXO_RELATORIO_COMPILADO);

				JasperPrint jasperPrint = JasperFillManager.fillReport(fileIn,
																	   printJasperReport.getParams(),
																	   new JRBeanCollectionDataSource(printJasperReport.getCollection()));
				
				viewReports(jasperPrint);
				
			} catch (JRException e) {
				e.printStackTrace();
			}
		}


		private void viewReports(JasperPrint jasperPrint) {
			JRViewer viewer = new JRViewer(jasperPrint);
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			setExtendedState(MAXIMIZED_BOTH);
			setTitle("Visualização de Relatórios");
			getContentPane().add(viewer);
			setVisible(true);
		}

}
