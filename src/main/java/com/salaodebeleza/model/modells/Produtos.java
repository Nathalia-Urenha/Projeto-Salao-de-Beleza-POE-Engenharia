//RELACIONAMENTO UM PARA MUITOS

package com.salaodebeleza.model.modells;

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

import com.salaodebeleza.model.modells.Produtos;



@Entity
@Table(name="TAB_PRODUTOS")
public class Produtos {
	
	private Integer id;
	private String nome;
	private float valor;
	private Integer qtd;
	
	//muitos para um
	private Usuario usuario;
	
	//muitos para muitos
	private List<Agendamento> agendamento;
	
	
	public Produtos(Integer id, String nome, float valor, Integer qtd) {
		this.id = id;
		this.nome = nome;
		this.valor = valor;
		this.qtd = qtd;
	}	
	
	
	public Produtos() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PRODUTO_ID", nullable = false)
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "PRODUTO_NOME", nullable=false, length=50)
	public String getNome() {
		return nome;
	}
	

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Column(name = "VALOR_PRODUTO", nullable=false)
	public float getValor() {
		return valor;
	}


	public void setValor(float valor) {
		this.valor = valor;
	}

	
	@Column(name = "QUANTIDADE_ESTOQUE")
	public Integer getQtd() {
		return qtd;
	}


	public void setQtd(Integer qtd) {
		this.qtd = qtd;
	}
	
/////////////////////RELACIONAMENTOS//////////////////////////////////
	//MUITOS PARA UM
	@ManyToOne
	@JoinColumn(name="USUARIO_ID", nullable=false)
	public Usuario getusuario(){
		return usuario;
	}

	public void setusuario(Usuario usuario){
		this.usuario = usuario;
	}
	
	//MUITOS PARA MUITOS
	@ManyToMany
	@JoinTable(name = "TAB_PRODUTOS_AGENDAMENTO", joinColumns = @JoinColumn(name = "PRODUTOS_ID"),
	inverseJoinColumns = @JoinColumn(name="AGENDAMENTO_ID"))
	public List<Agendamento> getAgendamento() {
		return agendamento;
	}


	public void setAgendamento(List<Agendamento> agendamento) {
		this.agendamento = agendamento;
	}

//////////////////////////////////////////////////////////////////////////////////	
	
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
		Produtos other = (Produtos) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "produtos [id=" + id + ", nome=" + nome + "]";
	}

}
