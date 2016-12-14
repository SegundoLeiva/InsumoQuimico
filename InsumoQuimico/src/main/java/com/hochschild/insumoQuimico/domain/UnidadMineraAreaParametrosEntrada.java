package com.hochschild.insumoQuimico.domain;

import java.io.Serializable;

public class UnidadMineraAreaParametrosEntrada implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String idUnidadMineraArea;
	private String idArea;
	private String idUnidadMinera;
	private String vigencia;

	public String getIdArea() {
		return idArea;
	}
	public void setIdArea(String idArea) {
		this.idArea = idArea;
	}
	public String getIdUnidadMinera() {
		return idUnidadMinera;
	}
	public void setIdUnidadMinera(String idUnidadMinera) {
		this.idUnidadMinera = idUnidadMinera;
	}
	public String getVigencia() {
		return vigencia;
	}
	public void setVigencia(String vigencia) {
		this.vigencia = vigencia;
	}
	public String getIdUnidadMineraArea() {
		return idUnidadMineraArea;
	}
	public void setIdUnidadMineraArea(String idUnidadMineraArea) {
		this.idUnidadMineraArea = idUnidadMineraArea;
	}
	
}
