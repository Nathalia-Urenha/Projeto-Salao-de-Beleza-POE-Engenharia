package com.salaodebeleza.view.produtos;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.salaodebeleza.model.modells.Produtos;

public class TabelaProdutosModel extends AbstractTableModel {
/**
	 * 
	 */
	private static final long serialVersionUID = 4604609827465724287L;


private final String colunas[] = {"Código","Nome","Valor", "Quantidade"};
	
	
	private static final int CODIGO = 0;
	private static final int NOME = 1;
	private static final int VALOR = 2;
	private static final int QTD =3;
	
	private List<Produtos> listaProdutos;
	
		
	public List<Produtos> getListaProdutos() {
		return listaProdutos;
	}

	public void setListaProdutos(List<Produtos> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}
	
	
	public Produtos getProdutos(int rowIndex) {
		return getListaProdutos().get(rowIndex);
	}

	
	public void saveProdutos(Produtos produto) {
		getListaProdutos().add(produto);
		fireTableRowsInserted(getRowCount()-1, getColumnCount()-1);
	}
	
	public void updateProdutos(Produtos produto, int rowIndex) {
		getListaProdutos().set(rowIndex, produto);
		fireTableRowsInserted(rowIndex, rowIndex);
	}
	
	
	public void removeProdutos(int rowIndex) {
		getListaProdutos().remove(rowIndex);
		fireTableRowsInserted(rowIndex, rowIndex);
	}
	
	
	public void removeAll() {
		getListaProdutos().clear();
		fireTableDataChanged();
	}
	

	public int getRowCount() {
		return getListaProdutos().size();
	}

	public int getColumnCount() {
		return getColunas().length;
	}
	
	public String getColumnName(int columnIndex) {
		return colunas[columnIndex];
	}
	
	
	public Object getValueAt(int rowIndex, int columnIndex) {
		Produtos produto = getListaProdutos().get(rowIndex);
		switch(columnIndex) {
		case CODIGO:
			return  produto.getId();
		case NOME:
			return produto.getNome();
		case VALOR:
			return produto.getValor();
		case QTD:
			return produto.getQtd();
		default:
			return produto;
			
			
		}
	}
	
	
	public Class<?> getColumnClass(int columnIndex){
		switch(columnIndex) {
		case CODIGO:
			return  Integer.class;
		case NOME:
			return String.class;
		case VALOR:
			return Float.class;
		case QTD:
			return Integer.class;
		default:
			return null;
		}
		
	}
	

	public String[] getColunas() {
		return colunas;
	}

}
