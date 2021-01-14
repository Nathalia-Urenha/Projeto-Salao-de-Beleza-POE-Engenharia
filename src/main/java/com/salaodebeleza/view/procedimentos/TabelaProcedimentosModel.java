package com.salaodebeleza.view.procedimentos;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.salaodebeleza.model.modells.Procedimentos;

public class TabelaProcedimentosModel extends AbstractTableModel {
	


/**
	 * 
	 */
	private static final long serialVersionUID = -3814095877030062624L;


private final String colunas[] = {"Código","Nome"};
	
	
	private static final int CODIGO = 0;
	private static final int NOME = 1;
	
	private List<Procedimentos> listaProcedimentos;
	
		
	public List<Procedimentos> getListaProcedimentos() {
		return listaProcedimentos;
	}

	public void setListaProcedimentos(List<Procedimentos> listaProcedimentos) {
		this.listaProcedimentos = listaProcedimentos;
	}
	
	
	public Procedimentos getProcedimentos(int rowIndex) {
		return getListaProcedimentos().get(rowIndex);
	}

	
	public void saveProcedimentos(Procedimentos procedimento) {
		getListaProcedimentos().add(procedimento);
		fireTableRowsInserted(getRowCount()-1, getColumnCount()-1);
	}
	
	public void updateProcedimentos(Procedimentos procedimento, int rowIndex) {
		getListaProcedimentos().set(rowIndex, procedimento);
		fireTableRowsInserted(rowIndex, rowIndex);
	}
	
	
	public void removeProcedimentos(int rowIndex) {
		getListaProcedimentos().remove(rowIndex);
		fireTableRowsInserted(rowIndex, rowIndex);
	}
	
	
	public void removeAll() {
		getListaProcedimentos().clear();
		fireTableDataChanged();
	}
	

	public int getRowCount() {
		return getListaProcedimentos().size();
	}

	public int getColumnCount() {
		return getColunas().length;
	}
	
	public String getColumnName(int columnIndex) {
		return colunas[columnIndex];
	}
	
	
	public Object getValueAt(int rowIndex, int columnIndex) {
		Procedimentos procedimento = getListaProcedimentos().get(rowIndex);
		switch(columnIndex) {
		case CODIGO:
			return  procedimento.getId();
		case NOME:
			return procedimento.getNome();
		default:
			return procedimento;
			
			
		}
	}
	
	
	public Class<?> getColumnClass(int columnIndex){
		switch(columnIndex) {
		case CODIGO:
			return  Integer.class;
		case NOME:
			return String.class;
		default:
			return null;
		}
		
	}
	

	public String[] getColunas() {
		return colunas;
	}

}
