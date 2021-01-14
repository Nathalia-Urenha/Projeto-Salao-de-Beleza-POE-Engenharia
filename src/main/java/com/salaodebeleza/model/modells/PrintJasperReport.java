package com.salaodebeleza.model.modells;

import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import net.sf.jasperreports.engine.JRParameter;

public class PrintJasperReport {
	
	private String file;
	private Map<String, Object> params;
	private Collection<?> collection;
	
	
	
	
	public PrintJasperReport() {
		this.params = new HashMap<String, Object>();
		addParms(JRParameter.REPORT_LOCALE, new Locale("pt", "BR"));
	}
	
	
	private void addParms(String key, Object value) {
		getParams().put(key, value);
		
	}


	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public Map<String, Object> getParams() {
		return params;
	}
	public void setParams(Map<String, Object> params) {
		this.params = params;
	}
	public Collection<?> getCollection() {
		return collection;
	}
	public void setCollection(Collection<?> collection) {
		this.collection = collection;
	}
	
	

}
