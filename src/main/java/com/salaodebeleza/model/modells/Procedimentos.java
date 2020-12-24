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

@Entity
@Table(name = "TAB_PROCEDIMENTOS")
public class Procedimentos {
	private Integer id;
	private String nome;
	
	//muitos para um
	private Usuario usuario;
	
	//muitos para muitos
	private List<Agendamento> agendamento;
	

	public Procedimentos() {
		
	}

	public Procedimentos(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PROCEDIMENTO_ID", nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="PROCEDIMENTO_NOME", nullable = false, length=50)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
//////////////////////RELACIONAMENTOS////////////////////////
	
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
	 * //MUITOS PARA MUITOS
	 * 
	 * @ManyToMany(mappedBy="procedimentos") public List<Agendamento>
	 * getAgendamento() { return agendamento; }
	 * 
	 * public void setAgendamento(List<Agendamento> agendamento) { this.agendamento
	 * = agendamento; }
	 */
	
///////////////////////////////////////////////////////////////////////////////////
		
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
		Procedimentos other = (Procedimentos) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Procedimentos [id=" + id + ", nome=" + nome + ", usuario=" + usuario + "]";
	}
	
	

}

