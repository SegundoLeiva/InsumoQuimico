package com.hochschild.insumoQuimico.domain;

import java.io.Serializable;

public class DistribucionMercaderiaParametrosEntrada implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long idDistribucionMercaderia;
	private String idUnidadMineraArea;
	private String idUnidadMineraInsumo;	
	private String idPresentacionInsumo;
	private String cantidad;
	public Long getIdDistribucionMercaderia() {
		return idDistribucionMercaderia;
	}
	public void setIdDistribucionMercaderia(Long idDistribucionMercaderia) {
		this.idDistribucionMercaderia = idDistribucionMercaderia;
	}
	public String getIdUnidadMineraArea() {
		return idUnidadMineraArea;
	}
	public void setIdUnidadMineraArea(String idUnidadMineraArea) {
		this.idUnidadMineraArea = idUnidadMineraArea;
	}
	public String getIdUnidadMineraInsumo() {
		return idUnidadMineraInsumo;
	}
	public void setIdUnidadMineraInsumo(String idUnidadMineraInsumo) {
		this.idUnidadMineraInsumo = idUnidadMineraInsumo;
	}
	public String getCantidad() {
		return cantidad;
	}
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
	public String getIdPresentacionInsumo() {
		return idPresentacionInsumo;
	}
	public void setIdPresentacionInsumo(String idPresentacionInsumo) {
		this.idPresentacionInsumo = idPresentacionInsumo;
	}
	

}
