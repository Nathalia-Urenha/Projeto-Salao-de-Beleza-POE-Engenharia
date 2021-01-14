package com.salaodebeleza.model.modells;

import java.io.File;
import java.io.InputStream;

public class Foto {
	
	private String nomeArquivo;
	private InputStream inputStraeam;
	private String contentType;
	private String id;
	private File file;
	
	public String getNomeArquivo() {
		return nomeArquivo;
	}
	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}
	public InputStream getInputStraeam() {
		return inputStraeam;
	}
	public void setInputStraeam(InputStream inputStraeam) {
		this.inputStraeam = inputStraeam;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}

}
