package com.salaodebeleza.model.modells;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TAB_DEPARTAMENTO")
public class Departamento {
	
	private Long id;
	private String nome;
	
	private List<Usuario> usuario;
	
	
	public Departamento(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}	
	
	
	public Departamento() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "departamento_nome", nullable=false, length=50)
	public String getNome() {
		return nome;
	}
	

	public void setNome(String nome) {
		this.nome = nome;
	}

// RELACIONAMENTO - UM PARA MUITOS
	@OneToMany(mappedBy="departamento")
	public List<Usuario> getUsuario() {
		return usuario;
	}


	public void setUsuario(List<Usuario> usuario) {
		this.usuario = usuario;
	}


	
	
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
		Departamento other = (Departamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Departamento [id=" + id + ", nome=" + nome + "]";
	}

}
