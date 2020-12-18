package com.salaodebeleza.model.service;

import java.util.List;

import javax.persistence.EntityTransaction;

import com.salaodebeleza.estrutura.util.VariaveisProjeto;
import com.salaodebeleza.model.dao.ClienteDao;
import com.salaodebeleza.model.modells.Cliente;

public class ClienteService extends ConexaoBancoService {
	
	private ClienteDao clienteDao;

	public ClienteService() {
		this.clienteDao = new ClienteDao(this.getEntityManager());
	}

	//salvar
	public Integer save(Cliente cliente) {

		Integer toReturn = 0;

		EntityTransaction trx = this.getTransaction();
		
		toReturn = validarDigitacao(cliente);

		if ( toReturn == VariaveisProjeto.DIGITACAO_OK) {

			try {

				trx.begin();
				this.getClienteDao().save(cliente);
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
	public Integer update(Cliente cliente) {

		Integer toReturn = 0;

		EntityTransaction trx = this.getTransaction();
		
		toReturn = validarDigitacao(cliente);

		if ( toReturn == VariaveisProjeto.DIGITACAO_OK) {

			try {

				trx.begin();
				this.getClienteDao().update(cliente);
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
	public Integer delete(Cliente cliente) {
		Integer toReturn = 0;
		EntityTransaction trx = this.getTransaction();
		try {

			trx.begin();
			Cliente clienteEncontrado = this.getClienteDao().findById(cliente.getId());
			this.getClienteDao().remove(clienteEncontrado);;
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
	public Cliente findById(Integer id) {
		return this.getClienteDao().findById(id);
	}

	//listar todos
	public List<Cliente> findAll(){
		return this.getClienteDao().findAll(Cliente.class);
	}



	public Integer validarDigitacao(Cliente cliente) {

		if ( VariaveisProjeto.digitacaoCampo(cliente.getNome())) {
			return VariaveisProjeto.CLIENTE_NOME;
		}
		if ( VariaveisProjeto.digitacaoCampo(cliente.getTelefone())) {
			return VariaveisProjeto.CLIENTE_TELEFONE;
		}
		if ( VariaveisProjeto.digitacaoCampo(cliente.getAnotacoes())) {
			return VariaveisProjeto.CLIENTE_ANOTACOES;
		}
		return VariaveisProjeto.DIGITACAO_OK;
	}


	public ClienteDao getClienteDao() {
		return clienteDao;
	}
	
	public Integer countTotalRegister() {
		return clienteDao.countTotalRegister(Cliente.class);
	}

	public List<Cliente> listClientePaginacao(Integer numeroPagina, Integer defaultPagina) {
		
		return clienteDao.listClientePaginacao(numeroPagina,defaultPagina);
	}

}
