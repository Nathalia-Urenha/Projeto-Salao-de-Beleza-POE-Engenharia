package com.salaodebeleza.model.dao;

import javax.persistence.EntityManager;

import com.salaodebeleza.model.modells.Usuario;


public class UsuarioDao extends GenericDao<Usuario, Integer >{

	public UsuarioDao(EntityManager entityManager) {
		super(entityManager);
	}

	
	

}