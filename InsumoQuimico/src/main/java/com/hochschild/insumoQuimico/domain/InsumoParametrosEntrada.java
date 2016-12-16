package com.hochschild.insumoQuimico.domain;

import java.io.Serializable;

import org.json.JSONArray;

public class InsumoParametrosEntrada implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String idInsumo;
	private String insumo;
	private String vigencia;
	private String index;
	private JSONArray insumoJSONArray;
	
	public String getIdInsumo() {
		return idInsumo;
	}
	public void setIdInsumo(String idInsumo) {
		this.idInsumo = idInsumo;
	}
	public String getInsumo() {
		return insumo;
	}
	public void setInsumo(String insumo) {
		this.insumo = insumo;
	}

	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	public String getVigencia() {
		return vigencia;
	}
	public void setVigencia(String vigencia) {
		this.vigencia = vigencia;
	}
	public JSONArray getInsumoJSONArray() {
		return insumoJSONArray;
	}
	public void setInsumoJSONArray(JSONArray insumoJSONArray) {
		this.insumoJSONArray = insumoJSONArray;
	}
}
