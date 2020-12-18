package com.salaodebeleza.model.service;

import java.util.List;

import javax.persistence.EntityTransaction;

import com.salaodebeleza.estrutura.util.VariaveisProjeto;
import com.salaodebeleza.model.dao.ProcedimentoDao;
import com.salaodebeleza.model.modells.Procedimentos;

public class ProcedimentosService extends ConexaoBancoService{
	
	private ProcedimentoDao procedimentoDao;

	public ProcedimentosService() {
		this.procedimentoDao = new ProcedimentoDao(this.getEntityManager());
	}

	//salvar
	public Integer save(Procedimentos procedimento) {

		Integer toReturn = 0;

		EntityTransaction trx = this.getTransaction();
		
		toReturn = validarDigitacao(procedimento);

		if ( toReturn == VariaveisProjeto.DIGITACAO_OK) {

			try {

				trx.begin();
				this.getProcedimentoDao().save(procedimento);
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
	public Integer update(Procedimentos procedimento) {

		Integer toReturn = 0;

		EntityTransaction trx = this.getTransaction();
		
		toReturn = validarDigitacao(procedimento);

		if ( toReturn == VariaveisProjeto.DIGITACAO_OK) {

			try {

				trx.begin();
				this.getProcedimentoDao().update(procedimento);
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
	public Integer delete(Procedimentos procedimento) {
		Integer toReturn = 0;
		EntityTransaction trx = this.getTransaction();
		try {

			trx.begin();
			Procedimentos procedimentoEncontrado = this.getProcedimentoDao().findById(procedimento.getId());
			this.getProcedimentoDao().remove(procedimentoEncontrado);;
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
	public Procedimentos findById(Integer id) {
		return this.getProcedimentoDao().findById(id);
	}

	//listar todos
	public List<Procedimentos> findAll(){
		return this.getProcedimentoDao().findAll(Procedimentos.class);
	}



	public Integer validarDigitacao(Procedimentos procedimento) {

		if ( VariaveisProjeto.digitacaoCampo(procedimento.getNome())) {
			return VariaveisProjeto.PROCEDIMENTO_NOME;
		}
		return VariaveisProjeto.DIGITACAO_OK;
	}


	public ProcedimentoDao getProcedimentoDao() {
		return procedimentoDao;
	}
	
	public Integer countTotalRegister() {
		return procedimentoDao.countTotalRegister(Procedimentos.class);
	}

	public List<Procedimentos> listProcedimentosPaginacao(Integer numeroPagina, Integer defaultPagina) {
		
		return procedimentoDao.listProcedimentosPaginacao(numeroPagina,defaultPagina);
	}

}
