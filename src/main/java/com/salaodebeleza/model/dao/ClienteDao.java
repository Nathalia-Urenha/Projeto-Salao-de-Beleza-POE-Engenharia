package com.salaodebeleza.model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.salaodebeleza.model.modells.Cliente;


public class ClienteDao extends GenericDao<Cliente, Integer> {
	
	public ClienteDao(EntityManager entityManager) {
		super(entityManager);
	}

	
	@SuppressWarnings("unchecked")
	public List<Cliente> listClientePaginacao(Integer numeroPagina, Integer defaultPagina) {
		
		List<Cliente> listaCliente = new ArrayList<Cliente>();
		
		boolean ativo = true;
		
		
		Query query = this.getEntityManager().createQuery("SELECT u FROM Cliente u WHERE u.ativo =:ativo")
											 .setParameter("ativo", ativo)
											 .setFirstResult(numeroPagina)
											 .setMaxResults(defaultPagina);
		listaCliente = query.getResultList();
		
		return listaCliente;
	}

}
