package com.salaodebeleza.model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.salaodebeleza.model.modells.Produtos;

public class ProdutosDao extends GenericDao<Produtos, Integer> {
	
	public ProdutosDao(EntityManager entityManager) {
		super(entityManager);
	}

	
	@SuppressWarnings("unchecked")
	public List<Produtos> listProdutosPaginacao(Integer numeroPagina, Integer defaultPagina) {
		
		List<Produtos> listaProdutos = new ArrayList<Produtos>();
	
		Query query = this.getEntityManager().createQuery("SELECT u FROM Produtos u ")
											 .setFirstResult(numeroPagina)
											 .setMaxResults(defaultPagina);
		listaProdutos = query.getResultList();
		
		return listaProdutos;
	}

}
