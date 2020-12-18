package com.salaodebeleza.model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;


import com.salaodebeleza.model.modells.Procedimentos;

public class ProcedimentoDao extends GenericDao<Procedimentos, Integer> {
	
	public ProcedimentoDao(EntityManager entityManager) {
		super(entityManager);
	}

	
	@SuppressWarnings("unchecked")
	public List<Procedimentos> listProcedimentosPaginacao(Integer numeroPagina, Integer defaultPagina) {
		
		List<Procedimentos> listaProcedimentos = new ArrayList<Procedimentos>();
		
		
		Query query = this.getEntityManager().createQuery("SELECT u FROM Procedimentos u ")
											 .setFirstResult(numeroPagina)
											 .setMaxResults(defaultPagina);
		listaProcedimentos = query.getResultList();
		
		return listaProcedimentos;
	}

}
