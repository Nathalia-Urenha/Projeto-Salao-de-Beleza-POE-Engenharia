package com.salaodebeleza.model.service;

import java.util.List;

import javax.persistence.EntityTransaction;

import com.salaodebeleza.estrutura.util.VariaveisProjeto;
import com.salaodebeleza.model.dao.AgendamentoDao;
import com.salaodebeleza.model.modells.Agendamento;

public class AgendamentoService extends ConexaoBancoService {
	
	private AgendamentoDao agendamentoDao;

	public AgendamentoService() {
		this.agendamentoDao = new AgendamentoDao(this.getEntityManager());
	}

	//salvar
	public Integer save(Agendamento agendamento) {

		Integer toReturn = 0;

		EntityTransaction trx = this.getTransaction();
		
		toReturn = validarDigitacao(agendamento);

		if ( toReturn == VariaveisProjeto.DIGITACAO_OK) {

			try {

				trx.begin();
				this.getAgendamentoDao().save(agendamento);
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
	public Integer update(Agendamento agendamento) {

		Integer toReturn = 0;

		EntityTransaction trx = this.getTransaction();
		
		toReturn = validarDigitacao(agendamento);

		if ( toReturn == VariaveisProjeto.DIGITACAO_OK) {

			try {

				trx.begin();
				this.getAgendamentoDao().update(agendamento);
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
	public Integer delete(Agendamento agendamento) {
		Integer toReturn = 0;
		EntityTransaction trx = this.getTransaction();
		try {

			trx.begin();
			Agendamento agendamentoEncontrado = this.getAgendamentoDao().findById(agendamento.getId());
			this.getAgendamentoDao().remove(agendamentoEncontrado);;
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
	public Agendamento findById(Integer id) {
		return this.getAgendamentoDao().findById(id);
	}

	//listar todos
	public List<Agendamento> findAll(){
		return this.getAgendamentoDao().findAll(Agendamento.class);
	}


	public Integer validarDigitacao(Agendamento agendamento) {

		if ( VariaveisProjeto.digitacaoCampo(agendamento.getData())) {
			return VariaveisProjeto.AGENDAMENTO_DATA;
		}
		if(VariaveisProjeto.digitacaoCampo(agendamento.getHora())) {
			return VariaveisProjeto.AGENDAMENTO_HORA;
		}
		
		if ( VariaveisProjeto.digitacaoCampo(agendamento.getValorProcedimento())) {
			return VariaveisProjeto.VALOR_PROCEDIMENTO;
		}
		
		if ( VariaveisProjeto.digitacaoCampo(agendamento.getValorProduto())) {
			return VariaveisProjeto.VALOR_PRODUTO;
		}
		
		if ( VariaveisProjeto.digitacaoCampo(agendamento.getValorTotal())) {
			return VariaveisProjeto.VALOR_TOTAL;
		}
		
		
		return VariaveisProjeto.DIGITACAO_OK;
	}


	public AgendamentoDao getAgendamentoDao() {
		return agendamentoDao;
	}
	
	public Integer countTotalRegister() {
		return agendamentoDao.countTotalRegister(Agendamento.class);
	}

	public List<Agendamento> listAgendamentosPaginacao(Integer numeroPagina, Integer defaultPagina) {
		
		return agendamentoDao.listAgendamentosPaginacao(numeroPagina, defaultPagina);
	}

}
