package com.salaodebeleza.model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.salaodebeleza.model.modells.Agendamento;

public class AgendamentoDao extends GenericDao<Agendamento, Integer> {
	
	public AgendamentoDao(EntityManager entityManager) {
		super(entityManager);
	}

	
	@SuppressWarnings("unchecked")
	public List<Agendamento> listAgendamentosPaginacao(Integer numeroPagina, Integer defaultPagina) {
		
		List<Agendamento> listaAgendamentos = new ArrayList<Agendamento>();
		
		
		Query query = this.getEntityManager().createQuery("SELECT u FROM Agendamento u ")
											 .setFirstResult(numeroPagina)
											 .setMaxResults(defaultPagina);
		listaAgendamentos = query.getResultList();
		
		return listaAgendamentos;
	}

}
