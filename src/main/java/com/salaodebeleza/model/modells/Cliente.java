package com.salaodebeleza.model.modells;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TAB_CLIENTES")
public class Cliente {
	
	private Integer id;
	private String nome;
	private String telefone;
	private String anotacoes;
	private boolean ativo = true;
	
	//muitos para um
	private Usuario usuario;
	
	//um para muitos
	private List<Agendamento> agendamento;

	public Cliente() {
		
	}
	
	public Cliente(Integer id, String nome, String  telefone, String anotacoes) {
		this.id=id;
		this.nome=nome;
		this.telefone=telefone;
		this.anotacoes=anotacoes;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CLIENTE_ID", nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "CLIENTE_NOME", nullable=false, length=50)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "CLIENTE_TELEFONE", nullable=false)
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Column(name = "CLIENTE_ANOTACOES")
	public String getAnotacoes() {
		return anotacoes;
	}

	public void setAnotacoes(String anotacoes) {
		this.anotacoes = anotacoes;
	}
	
	@Column(nullable = false )
	public boolean isAtivo() {
		return ativo;
	}
	
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
////////////////////////////RELACIONAMENTOS///////////////////////////////////	
	//MUITOS PARA UM
	@ManyToOne
	@JoinColumn(name = "USUARIO_ID", nullable = false)
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	/*
	 * //UM PARA MUITOS - AGENDAMENTO
	 * 
	 * @OneToMany(mappedBy="cliente") public List<Agendamento> getAgendamento() {
	 * return agendamento; }
	 * 
	 * public void setAgendamento(List<Agendamento> agendamento) { this.agendamento
	 * = agendamento; }
	 */
	
/////////////////////////////////////////////////////////////////////////	

	

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
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", telefone=" + telefone + ", anotacoes=" + anotacoes
				+ ", ativo=" + ativo + ", usuario=" + usuario + ", agendamento=" + agendamento + "]";
	}

	

	
}
