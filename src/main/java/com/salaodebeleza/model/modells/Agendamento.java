package com.salaodebeleza.model.modells;

import java.util.Date;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TAB_AGENDAMENTO")
public class Agendamento {
	
	private Integer id;
	private Date data;
	private String hora;
	private float valorProcedimento;
	private float valorProduto;
	private float valorTotal;
	
	//muitos para um
	private Cliente cliente;
	private Usuario usuario;
	
	//muitos para muitos
	private List<Procedimentos> procedimentos;
	private List<Produtos> produtos;
	
	public Agendamento() {
		
	}

	public Agendamento(Integer id, Date data, String hora, float valorProcedimento, float valorProduto,
			float valorTotal) {
		super();
		this.id = id;
		this.data = data;
		this.hora = hora;
		this.valorProcedimento = valorProcedimento;
		this.valorProduto = valorProduto;
		this.valorTotal = valorTotal;
	}

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="AGENDAMENTO_ID",nullable=false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="AGENDAMENTO_DATA", nullable = false)
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	@Column(name="AGENDAMENTO_HORA", nullable = false)
	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	@Column(name="PROCEDIMENTO_VALOR")
	public float getValorProcedimento() {
		return valorProcedimento;
	}
	
	public void setValorProcedimento(float valorProcedimento) {
		this.valorProcedimento = valorProcedimento;
	}
	
	@Column(name="PRODUTO_VALOR")
	public float getValorProduto() {
		return valorProduto;
	}

	public void setValorProduto(float valorProduto) {
		this.valorProduto = valorProduto;
	}
	
	@Column(name="VALOR_TOTAL")
	public float getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}

///////////////////////RELACIONAMENTOS//////////////////////
	
	
	  //MUITOS PARA UM - CLIENTE
	  
		/*
		 * @ManyToOne
		 * 
		 * @JoinColumn(name = "CLIENTE_ID", nullable = false) public Cliente
		 * getCliente() { return cliente; }
		 * 
		 * public void setCliente(Cliente cliente) { this.cliente = cliente; }
		 */
	
	  //MUITOS PARA UM - USUARIO
	  
	  @ManyToOne
	  @JoinColumn(name = "USUARIO_ID", nullable = false) 
	  public Usuario getUsuario() { 
		  return usuario; 
		  }
	  
	  public void setUsuario(Usuario usuario) {
		  this.usuario = usuario; 
	
	  }
	  
	  //MUITOS PARA MUITOS - PROCEDIMENTOS
	  
		/*
		 * @ManyToMany
		 * 
		 * @JoinTable(name = "TAB_PROCEDIMENTOS_AGENDAMENTO", joinColumns
		 * = @JoinColumn(name = "AGENDAMENTO_ID"), inverseJoinColumns
		 * = @JoinColumn(name="PROCEDIMENTO_ID")) public List<Procedimentos>
		 * getProcedimentos() { return procedimentos; }
		 * 
		 * public void setProcedimentos(List<Procedimentos> procedimentos) {
		 * this.procedimentos = procedimentos; }
		 */
	 
	  //MUITOS PARA MUITOS - PRODUTOS
	  
		/*
		 * @ManyToMany
		 * 
		 * @JoinTable(name = "TAB_PRODUTOS_AGENDAMENTO", joinColumns = @JoinColumn(name
		 * = "AGENDAMENTO_ID"), inverseJoinColumns = @JoinColumn(name="PRODUTO_ID"))
		 * public List<Produtos> getProdutos() { return produtos; }
		 * 
		 * public void setProdutos(List<Produtos> produtos) { this.produtos = produtos;
		 * }
		 */
	 
///////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agendamento other = (Agendamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Agendamento [id=" + id + ", data=" + data + ", hora=" + hora + ", valorProcedimento="
				+ valorProcedimento + ", valorProduto=" + valorProduto + ", valorTotal=" + valorTotal + ", cliente="
				+ cliente + ", usuario=" + usuario + ", procedimentos=" + procedimentos + ", produtos=" + produtos
				+ "]";
	}
	

}
