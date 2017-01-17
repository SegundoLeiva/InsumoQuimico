package com.hochschild.insumoQuimico.domain;

import java.io.Serializable;

import org.json.JSONArray;

public class ConsumoParametrosEntrada implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String idUnidadMinera;
	private String idUnidadMineraAlmacen;
	private String idUnidadMineraArea;
	private String idConsumo;
	private JSONArray consumoJSONArray;
	private String nombreUsuario;
	private String index;
	private String fechaConsumo;
	public String getIdUnidadMinera() {
		return idUnidadMinera;
	}
	public void setIdUnidadMinera(String idUnidadMinera) {
		this.idUnidadMinera = idUnidadMinera;
	}
	public String getIdUnidadMineraAlmacen() {
		return idUnidadMineraAlmacen;
	}
	public void setIdUnidadMineraAlmacen(String idUnidadMineraAlmacen) {
		this.idUnidadMineraAlmacen = idUnidadMineraAlmacen;
	}
	public String getIdUnidadMineraArea() {
		return idUnidadMineraArea;
	}
	public void setIdUnidadMineraArea(String idUnidadMineraArea) {
		this.idUnidadMineraArea = idUnidadMineraArea;
	}
	public String getIdConsumo() {
		return idConsumo;
	}
	public void setIdConsumo(String idConsumo) {
		this.idConsumo = idConsumo;
	}
	public JSONArray getConsumoJSONArray() {
		return consumoJSONArray;
	}
	public void setConsumoJSONArray(JSONArray consumoJSONArray) {
		this.consumoJSONArray = consumoJSONArray;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	public String getFechaConsumo() {
		return fechaConsumo;
	}
	public void setFechaConsumo(String fechaConsumo) {
		this.fechaConsumo = fechaConsumo;
	}
}
