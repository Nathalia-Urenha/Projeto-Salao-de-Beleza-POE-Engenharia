package com.salaodebeleza.view.cliente;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.salaodebeleza.model.modells.Cliente;

public class TabelaClienteModel extends AbstractTableModel {
	


/**
	 * 
	 */
	private static final long serialVersionUID = -3732136059463446955L;



private final String colunas[] = {"Código","Nome","Telefone", "Anotacoes"};
	
	
	private static final int CODIGO = 0;
	private static final int NOME = 1;
	private static final int TELEFONE = 2;
	private static final int ANOTACOES =3;
	
	private List<Cliente> listaCliente;
	
		
	public List<Cliente> getListaCliente() {
		return listaCliente;
	}

	public void setListaCliente(List<Cliente> listaCliente) {
		this.listaCliente = listaCliente;
	}
	
	
	public Cliente getCliente(int rowIndex) {
		return getListaCliente().get(rowIndex);
	}

	
	public void saveCliente(Cliente usuario) {
		getListaCliente().add(usuario);
		fireTableRowsInserted(getRowCount()-1, getColumnCount()-1);
	}
	
	public void updateCliente(Cliente usuario, int rowIndex) {
		getListaCliente().set(rowIndex, usuario);
		fireTableRowsInserted(rowIndex, rowIndex);
	}
	
	
	public void removeCliente(int rowIndex) {
		getListaCliente().remove(rowIndex);
		fireTableRowsInserted(rowIndex, rowIndex);
	}
	
	
	public void removeAll() {
		getListaCliente().clear();
		fireTableDataChanged();
	}
	

	public int getRowCount() {
		return getListaCliente().size();
	}

	public int getColumnCount() {
		return getColunas().length;
	}
	
	public String getColumnName(int columnIndex) {
		return colunas[columnIndex];
	}
	
	
	public Object getValueAt(int rowIndex, int columnIndex) {
		Cliente usuario = getListaCliente().get(rowIndex);
		switch(columnIndex) {
		case CODIGO:
			return  usuario.getId();
		case NOME:
			return usuario.getNome();
		case TELEFONE:
			return usuario.getTelefone();
		case ANOTACOES:
			return usuario.getAnotacoes();
		default:
			return usuario;
			
			
		}
	}
	
	
	public Class<?> getColumnClass(int columnIndex){
		switch(columnIndex) {
		case CODIGO:
			return  Integer.class;
		case NOME:
			return String.class;
		case TELEFONE:
			return String.class;
		case ANOTACOES:
			return String.class;
		default:
			return null;
		}
		
	}
	

	public String[] getColunas() {
		return colunas;
	}

}
