package com.salaodebeleza.estrutura.util;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.salaodebeleza.model.modells.Procedimentos;

public class VariaveisProjeto {
	
	public static final String PERSISTENCE_UNIT_NAME = "salaodebeleza";
	
	//configurações para geração de relatório
	public static final String DIRETORIO_RELATORIO = "reports/";
	public static final String SUFIXO_RELATORIO_COMPILADO = ".jasper";
	public static final String SUFIXO_RELARIO_FONTE = ".jrxml";
	public static final String UPLOAD_DIR="/poe/upload";
	
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
	
	
	//classe cliente
	public static final Integer CLIENTE_NOME = 204;
	public static final Integer CLIENTE_TELEFONE = 205;
	public static final Integer CLIENTE_ANOTACOES = 206;
	
	
	//classe procedimentos
	public static final Integer PROCEDIMENTO_NOME = 207;
	
	//classe produtos
	public static final Integer PRODUTO_NOME = 208;
	public static final Integer PRODUTO_VALOR = 209;
	public static final Integer PRODUTO_QTD = 210;
	
	//classe agendamento
	public static final Integer AGENDAMENTO_DATA = 211;
	public static final Integer AGENDAMENTO_HORA = 212;
	public static final Integer VALOR_PROCEDIMENTO = 213;
	public static final Integer VALOR_PRODUTO = 214;
	public static final Integer VALOR_TOTAL = 215;
	
	

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
	
	public static boolean digitacaoCampo(Float texto) {

		if ( Objects.isNull(texto)) {
			return true;
		}

		if ("".equals(String.valueOf(texto))){
			return true;
		}

		return false;
	}
	
	public static boolean digitacaoCampo(Date texto) {

		if ( Objects.isNull(texto)) {
			return true;
		}

		if ("".equals(String.valueOf(texto))){
			return true;
		}

		return false;
	}
	
	
	public static Integer convertToInteger(String texto) {
		return Integer.parseInt(texto);
	}

	
	
	
}
