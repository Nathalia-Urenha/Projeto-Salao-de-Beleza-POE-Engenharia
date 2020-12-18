package com.salaodebeleza.model.service;

import java.util.List;

import javax.persistence.EntityTransaction;

import com.salaodebeleza.estrutura.util.VariaveisProjeto;

import com.salaodebeleza.model.dao.ProdutosDao;

import com.salaodebeleza.model.modells.Produtos;

public class ProdutosService extends ConexaoBancoService{
	
	private ProdutosDao produtosDao;

	public ProdutosService() {
		this.produtosDao = new ProdutosDao(this.getEntityManager());
	}

	//salvar
	public Integer save(Produtos produtos) {

		Integer toReturn = 0;

		EntityTransaction trx = this.getTransaction();
		
		toReturn = validarDigitacao(produtos);

		if ( toReturn == VariaveisProjeto.DIGITACAO_OK) {

			try {

				trx.begin();
				this.getProdutosDao().save(produtos);
				trx.commit();
				toReturn = VariaveisProjeto.INCLUSAO_REALIZADA;

			} catch (Exception ex) {
				ex.printStackTrace();
				if ( trx.isActive() ) {
					trx.rollback();
				}
				toReturn = VariaveisProjeto.ERRO_INCLUSAO;

			} finally {
				this.close();
			}
		} 
		return toReturn; 
	}

	//atualizar
	public Integer update(Produtos produtos) {

		Integer toReturn = 0;

		EntityTransaction trx = this.getTransaction();
		
		toReturn = validarDigitacao(produtos);

		if ( toReturn == VariaveisProjeto.DIGITACAO_OK) {

			try {

				trx.begin();
				this.getProdutosDao().update(produtos);
				trx.commit();
				toReturn = VariaveisProjeto.ALTERACAO_REALIZADA;

			} catch (Exception ex) {
				ex.printStackTrace();
				if ( trx.isActive() ) {
					trx.rollback();
				}
				toReturn = VariaveisProjeto.ERRO_ALTERACAO;

			} finally {
				this.close();
			}
		} 
		return toReturn; 
	}

	//deletar
	public Integer delete(Produtos produtos) {
		Integer toReturn = 0;
		EntityTransaction trx = this.getTransaction();
		try {

			trx.begin();
			Produtos produtoEncontrado = this.getProdutosDao().findById(produtos.getId());
			this.getProdutosDao().remove(produtoEncontrado);;
			trx.commit();
			toReturn = VariaveisProjeto.EXCLUSAO_REALIZADA;

		} catch (Exception ex) {
			ex.printStackTrace();
			if ( trx.isActive() ) {
				trx.rollback();
			}
			toReturn = VariaveisProjeto.ERRO_EXCLUSAO;

		} finally {
			this.close();
		}

		return toReturn; 
	}




	//buscar
	public Produtos findById(Integer id) {
		return this.getProdutosDao().findById(id);
	}

	//listar todos
	public List<Produtos> findAll(){
		return this.getProdutosDao().findAll(Produtos.class);
	}


	public Integer validarDigitacao(Produtos produtos) {

		if ( VariaveisProjeto.digitacaoCampo(produtos.getNome())) {
			return VariaveisProjeto.PRODUTO_NOME;
		}
		if(VariaveisProjeto.digitacaoCampo(produtos.getValor())) {
			return VariaveisProjeto.PRODUTO_VALOR;
		}
		if ( VariaveisProjeto.digitacaoCampo(produtos.getQtd())) {
			return VariaveisProjeto.PRODUTO_QTD;
		}
		
		
		return VariaveisProjeto.DIGITACAO_OK;
	}


	public ProdutosDao getProdutosDao() {
		return produtosDao;
	}
	
	public Integer countTotalRegister() {
		return produtosDao.countTotalRegister(Produtos.class);
	}

	public List<Produtos> listProdutosPaginacao(Integer numeroPagina, Integer defaultPagina) {
		
		return produtosDao.listProdutosPaginacao(numeroPagina,defaultPagina);
	}


}
