package com.salaodebeleza.model.service;

import java.util.List;


import javax.persistence.EntityTransaction;

import com.salaodebeleza.estrutura.util.VariaveisProjeto;
import com.salaodebeleza.model.dao.UsuarioDao;
import com.salaodebeleza.model.modells.Usuario;



public class UsuarioService extends ConexaoBancoService {

	private UsuarioDao usuarioDao;

	public UsuarioService() {
		this.usuarioDao = new UsuarioDao(this.getEntityManager());
	}

	//salvar
	public Integer save(Usuario usuario) {

		Integer toReturn = 0;

		EntityTransaction trx = this.getTransaction();

		if ( validarDigitacao(usuario) == VariaveisProjeto.DIGITACAO_OK) {

			try {

				trx.begin();
				this.getUsuarioDao().save(usuario);
				trx.commit();

			} catch (Exception ex) {
				ex.printStackTrace();
				if ( trx.isActive() ) {
					trx.rollback();
				}
				toReturn = VariaveisProjeto.ERRO_INCLUSAO;

			} finally {
				this.close();
			}
		} else {
			toReturn = VariaveisProjeto.CAMPO_VAZIO;
		}
		return toReturn; 
	}

	//atualizar
	public Integer update(Usuario usuario) {

		Integer toReturn = 0;

		EntityTransaction trx = this.getTransaction();

		if ( validarDigitacao(usuario) == VariaveisProjeto.DIGITACAO_OK) {

			try {

				trx.begin();
				this.getUsuarioDao().update(usuario);
				trx.commit();

			} catch (Exception ex) {
				ex.printStackTrace();
				if ( trx.isActive() ) {
					trx.rollback();
				}
				toReturn = VariaveisProjeto.ERRO_ALTERACAO;

			} finally {
				this.close();
			}
		} else {
			toReturn = VariaveisProjeto.CAMPO_VAZIO;
		}
		return toReturn; 
	}

	//deletar
	public Integer delete(Usuario usuario) {
		Integer toReturn = 0;
		EntityTransaction trx = this.getTransaction();
		try {

			trx.begin();
			Usuario usuarioEncontrado = this.getUsuarioDao().findById(usuario.getId());
			this.getUsuarioDao().remove(usuarioEncontrado);;
			trx.commit();

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
	public Usuario findById(Integer id) {
		return this.getUsuarioDao().findById(id);
	}

	//listar todos
	public List<Usuario> findAll(){
		return this.getUsuarioDao().findAll(Usuario.class);
	}



	public Integer validarDigitacao(Usuario usuario) {

		if ( VariaveisProjeto.digitacaoCampo(usuario.getUsername())) {
			return VariaveisProjeto.CAMPO_VAZIO;
		}
		return VariaveisProjeto.DIGITACAO_OK;
	}


	public UsuarioDao getUsuarioDao() {
		return usuarioDao;
	}

}

