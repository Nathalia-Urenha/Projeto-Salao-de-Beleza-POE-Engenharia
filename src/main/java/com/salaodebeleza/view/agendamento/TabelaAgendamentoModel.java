package com.salaodebeleza.view.agendamento;
import java.util.Date;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.salaodebeleza.model.modells.Agendamento;

public class TabelaAgendamentoModel extends AbstractTableModel {
	
/**
	 * 
	 */
	private static final long serialVersionUID = 5396644703497325516L;


private final String colunas[] = {"Código","Data","Hora", "Cabeleireiro(a)", "Valor Procedimento", "Valor Produto", "Valor Total"};
	
	
	private static final int CODIGO = 0;
	private static final int DATA = 1;
	private static final int HORA = 2;
	private static final int USUARIO = 3;
	private static final int VALOR_PROCEDIMENTO = 4;
	private static final int VALOR_PRODUTO = 5;
	private static final int VALOR_TOTAL = 6;
	
	private List<Agendamento> listaAgendamento;
	
		
	public List<Agendamento> getListaAgendamento() {
		return listaAgendamento;
	}

	public void setListaAgendamento(List<Agendamento> listaAgendamento) {
		this.listaAgendamento = listaAgendamento;
	}
	
	
	public Agendamento getAgendamento(int rowIndex) {
		return getListaAgendamento().get(rowIndex);
	}

	
	public void saveAgendamento(Agendamento agendamento) {
		getListaAgendamento().add(agendamento);
		fireTableRowsInserted(getRowCount()-1, getColumnCount()-1);
	}
	
	public void updateAgendamento(Agendamento agendamento, int rowIndex) {
		getListaAgendamento().set(rowIndex, agendamento);
		fireTableRowsInserted(rowIndex, rowIndex);
	}
	
	
	public void removeAgendamento(int rowIndex) {
		getListaAgendamento().remove(rowIndex);
		fireTableRowsInserted(rowIndex, rowIndex);
	}
	
	
	public void removeAll() {
		getListaAgendamento().clear();
		fireTableDataChanged();
	}
	

	public int getRowCount() {
		return getListaAgendamento().size();
	}

	public int getColumnCount() {
		return getColunas().length;
	}
	
	public String getColumnName(int columnIndex) {
		return colunas[columnIndex];
	}
	
	
	public Object getValueAt(int rowIndex, int columnIndex) {
		Agendamento agendamento = getListaAgendamento().get(rowIndex);
		switch(columnIndex) {
		case CODIGO:
			return  agendamento.getId();
		case USUARIO:
			return agendamento.getUsuario().getUsername();
		case DATA:
			return agendamento.getData();
		case HORA:
			return agendamento.getHora();
		case VALOR_PROCEDIMENTO:
			return agendamento.getValorProcedimento();
		case VALOR_PRODUTO:
			return agendamento.getValorProduto();
		case VALOR_TOTAL:
			return agendamento.getValorTotal();
		default:
			return agendamento;
			
			
		}
	}
	
	
	public Class<?> getColumnClass(int columnIndex){
		switch(columnIndex) {
		case CODIGO:
			return  Integer.class;
		case USUARIO:
			return String.class;
		case DATA:
			return Date.class;
		case HORA:
			return String.class;
		case VALOR_PROCEDIMENTO:
			return Float.class;
		case VALOR_PRODUTO:
			return Float.class;
		case VALOR_TOTAL:
			return Float.class;
		default:
			return null;
		}
		
	}
	

	public String[] getColunas() {
		return colunas;
	}

}
