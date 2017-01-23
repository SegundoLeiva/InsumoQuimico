package com.hochschild.insumoQuimico.domain;

import java.io.Serializable;

public class DistribucionMercaderiaParametrosEntrada implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long idDistribucionMercaderia;
	private String idUnidadMineraArea;
	private String idUnidadMineraInsumoPresentacion;	
	private String cantidad;
	private String idUsuarioCreacion;
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
	public String getIdUnidadMineraInsumoPresentacion() {
		return idUnidadMineraInsumoPresentacion;
	}
	public void setIdUnidadMineraInsumoPresentacion(
			String idUnidadMineraInsumoPresentacion) {
		this.idUnidadMineraInsumoPresentacion = idUnidadMineraInsumoPresentacion;
	}
	public String getCantidad() {
		return cantidad;
	}
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
	public String getIdUsuarioCreacion() {
		return idUsuarioCreacion;
	}
	public void setIdUsuarioCreacion(String idUsuarioCreacion) {
		this.idUsuarioCreacion = idUsuarioCreacion;
	}

}
