package com.hochschild.insumoQuimico.domain;

import java.io.Serializable;

public class UnidadMineraInsumoParametrosEntrada implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String idUnidadMineraInsumo;
	private String idInsumo;
	private String idUnidadMinera;
	private String vigencia;

	public String getIdInsumo() {
		return idInsumo;
	}
	public void setIdInsumo(String idInsumo) {
		this.idInsumo = idInsumo;
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
	public String getIdUnidadMineraInsumo() {
		return idUnidadMineraInsumo;
	}
	public void setIdUnidadMineraInsumo(String idUnidadMineraInsumo) {
		this.idUnidadMineraInsumo = idUnidadMineraInsumo;
	}
	
}
