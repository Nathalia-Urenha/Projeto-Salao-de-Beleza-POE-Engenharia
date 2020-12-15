package com.salaodebeleza.estrutura.util;

import java.util.Objects;

public class VariaveisProjeto {
	
	public static final String PERSISTENCE_UNIT_NAME = "salaodebeleza";
	
	public static final Integer INCLUSAO = 1;
	public static final Integer ALTERACAO = 2;
	public static final Integer EXCLUSAO = 3;
	public static final Integer CONSULTA = 4;
	
	public static final Integer ERRO_INCLUSAO = 10;
	public static final Integer ERRO_ALTERACAO = 20;
	public static final Integer ERRO_EXCLUSAO = 30;
	
	public static final Integer INCLUSAO_REALIZADA = 1;
	public static final Integer ALTERACAO_REALIZADA = 2;
	public static final Integer EXCLUSAO_REALIZADA = 3;
	

	public static final Integer DIGITACAO_OK = 100; 
	
	//classe usuario
	public static final Integer USUARIO_USER_NAME = 201;
	public static final Integer USUARIO_EMAIL = 202;
	public static final Integer USUARIO_PASSWORD = 203;
	
	//classe departamento
	public static final Integer DEPARTAMENTO_NOME = 300;
	

	public static final String LIMPA_CAMPO = "";

	public static boolean digitacaoCampo(Integer texto) {

		if ( Objects.isNull(texto)) {
			return true;
		}

		if ("".equals(String.valueOf(texto))){
			return true;
		}

		return false;
	}

	public static boolean digitacaoCampo(String texto) {

		if ( Objects.isNull(texto)) {
			return true;
		}

		if ("".equals(texto.trim())){
			return true;
		}
		return false;
	}

	public static Integer convertToInteger(String texto) {
		return Integer.parseInt(texto);
	}
	
	
}
