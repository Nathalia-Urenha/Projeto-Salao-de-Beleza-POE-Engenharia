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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TAB_USUARIO")
public class Usuario {

	private Integer id;
	private String  username; 
	private String  email;
	private String  password;
	private boolean ativo = true;
	
	//um para muitos
	private List<Produtos> produtos;
	private List<Cliente>  clientes;
	private List<Procedimentos> procedimentos;
	private List<Agendamento> agendamento;



	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USUARIO_ID")
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "USUARIO_USERNAME", length = 60, nullable = false )
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
    @Column(name = "USUARIO_EMAIL", length = 100, nullable = false )
	public String getEmail() {
		return email;
	}
    
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name = "USUARIO_PASSWORD", length = 100, nullable = false )
	public String getPassword() {
		return password;
	}
	
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(nullable = false )
	public boolean isAtivo() {
		return ativo;
	}
	
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
//////////////////////RELACIONAMENTOS///////////////////////////////
	
	//UM PARA MUITOS
	@OneToMany(mappedBy="usuario")
	public List<Produtos> getProdutos(){
		return produtos;
	}

	public void setProdutos(List<Produtos> produtos){
		this.produtos = produtos;
	}
	
	//UM PARA MUITOS
	@OneToMany(mappedBy="usuario")
	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	
	//UM PARA MUITOS
	@OneToMany(mappedBy="usuario")
	public List<Procedimentos> getProcedimentos() {
			return procedimentos;
	}
	
	public void setProcedimentos(List<Procedimentos> procedimentos) {
		this.procedimentos = procedimentos;
	}
	
	//UM PARA MUITOS
	@OneToMany(mappedBy="usuario")
	public List<Agendamento> getAgendamento() {
		return agendamento;
	}

	public void setAgendamento(List<Agendamento> agendamento) {
		this.agendamento = agendamento;
	}
	

/////////////////////////////////////////////////////////////////////

	


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
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", ativo=" + ativo + "]";
	}




}