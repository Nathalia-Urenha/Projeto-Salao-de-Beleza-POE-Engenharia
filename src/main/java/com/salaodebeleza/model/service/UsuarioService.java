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
		
		toReturn = validarDigitacao(usuario);

		if ( toReturn == VariaveisProjeto.DIGITACAO_OK) {

			try {

				trx.begin();
				this.getUsuarioDao().save(usuario);
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
	public Integer update(Usuario usuario) {

		Integer toReturn = 0;

		EntityTransaction trx = this.getTransaction();
		
		toReturn = validarDigitacao(usuario);

		if ( toReturn == VariaveisProjeto.DIGITACAO_OK) {

			try {

				trx.begin();
				this.getUsuarioDao().update(usuario);
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
	public Integer delete(Usuario usuario) {
		Integer toReturn = 0;
		EntityTransaction trx = this.getTransaction();
		try {

			trx.begin();
			Usuario usuarioEncontrado = this.getUsuarioDao().findById(usuario.getId());
			this.getUsuarioDao().remove(usuarioEncontrado);;
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
	public Usuario findById(Integer id) {
		return this.getUsuarioDao().findById(id);
	}

	//listar todos
	public List<Usuario> findAll(){
		return this.getUsuarioDao().findAll(Usuario.class);
	}



	public Integer validarDigitacao(Usuario usuario) {

		if ( VariaveisProjeto.digitacaoCampo(usuario.getUsername())) {
			return VariaveisProjeto.USUARIO_USER_NAME;
		}
		if ( VariaveisProjeto.digitacaoCampo(usuario.getEmail())) {
			return VariaveisProjeto.USUARIO_EMAIL;
		}
		if ( VariaveisProjeto.digitacaoCampo(usuario.getPassword())) {
			return VariaveisProjeto.USUARIO_PASSWORD;
		}
		return VariaveisProjeto.DIGITACAO_OK;
	}


	public UsuarioDao getUsuarioDao() {
		return usuarioDao;
	}
	
	public Integer countTotalRegister() {
		return usuarioDao.countTotalRegister(Usuario.class);
	}

	public List<Usuario> listUsuarioPaginacao(Integer numeroPagina, Integer defaultPagina) {
		
		return usuarioDao.listUsuarioPaginacao(numeroPagina,defaultPagina);
	}
	

}
