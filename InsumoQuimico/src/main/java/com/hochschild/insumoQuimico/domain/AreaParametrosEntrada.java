package com.hochschild.insumoQuimico.domain;

import java.io.Serializable;

public class AreaParametrosEntrada implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String idArea;
	private String area;
	private String vigencia;
	
	public String getIdArea() {
		return idArea;
	}
	public void setIdArea(String idArea) {
		this.idArea = idArea;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getVigencia() {
		return vigencia;
	}
	public void setVigencia(String vigencia) {
		this.vigencia = vigencia;
	}

}
