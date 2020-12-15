package com.salaodebeleza.model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.salaodebeleza.model.modells.Usuario;


public class UsuarioDao extends GenericDao<Usuario, Integer >{


	public UsuarioDao(EntityManager entityManager) {
		super(entityManager);
	}

	
	@SuppressWarnings("unchecked")
	public List<Usuario> listUsuarioPaginacao(Integer numeroPagina, Integer defaultPagina) {
		
		List<Usuario> listaUsuario = new ArrayList<Usuario>();
		
		boolean ativo = true;
		
		
		Query query = this.getEntityManager().createQuery("SELECT u FROM Usuario u WHERE u.ativo =:ativo")
											 .setParameter("ativo", ativo)
											 .setFirstResult(numeroPagina)
											 .setMaxResults(defaultPagina);
		listaUsuario = query.getResultList();
		
		return listaUsuario;
	}
	

}