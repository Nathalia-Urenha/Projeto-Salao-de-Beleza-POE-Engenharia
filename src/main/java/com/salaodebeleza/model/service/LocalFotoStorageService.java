package com.salaodebeleza.model.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import com.salaodebeleza.estrutura.util.VariaveisProjeto;
import com.salaodebeleza.model.modells.Foto;

public class LocalFotoStorageService {
	
	private Path diretorioFoto;
	
	public LocalFotoStorageService() {
		
		this.diretorioFoto = Paths.get(VariaveisProjeto.UPLOAD_DIR).toAbsolutePath().normalize();
	
		try {
			Files.createDirectories(diretorioFoto);
		}catch(Exception e) {
			throw new RuntimeException("Erro na leitura da foto", e);
		}
	}	
	
	

	public String armazenar(Foto foto) {
		InputStream is = null;
		OutputStream os = null;
		
		String nomeArquivo = gerarNomeArquivo(foto.getNomeArquivo());
		
		Path arquivoPath = getArquivoPath(nomeArquivo);
		
		try {
			is = new FileInputStream(foto.getFile());
			os = new FileOutputStream(arquivoPath.toString());
			
			byte[] buffer = new byte[1024];
			int length = 0;
			
			while((length = is.read(buffer)) > 0){
				os.write(buffer, 0, length);
			}
			is.close();
			os.close();
			return nomeArquivo;
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return null;
		
		
	}

	private Path getArquivoPath(String nomeArquivo) {
		
		return diretorioFoto.resolve(Paths.get(nomeArquivo));
	}
	
	private String gerarNomeArquivo(String nomeOriginal) {
		return UUID.randomUUID().toString()+"_"+nomeOriginal;
	}



	public void remover(String nomeFoto) {
		
		
		try {
			Path arquivoPath = getArquivoPath(nomeFoto);
			Files.deleteIfExists(arquivoPath);
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}



	public String recuperar(String nomeFoto) {
		
		Path arquivoPath = getArquivoPath(nomeFoto);
		return arquivoPath.toString();
		
	}

}
