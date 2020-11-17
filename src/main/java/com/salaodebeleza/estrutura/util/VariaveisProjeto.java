package com.salaodebeleza.estrutura.util;

import java.util.Objects;

public class VariaveisProjeto {
public static final String PERSISTENCE_UNIT_NAME = "salaodebeleza";
	
	public static final Integer ERRO_INCLUSAO = 10;
	public static final Integer ERRO_ALTERACAO = 20;
	public static final Integer ERRO_EXCLUSAO = 30;
	
	public static final Integer DIGITACAO_OK = 100;
	public static final Integer CAMPO_VAZIO = 200;
	
	
	
	
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
	
}
