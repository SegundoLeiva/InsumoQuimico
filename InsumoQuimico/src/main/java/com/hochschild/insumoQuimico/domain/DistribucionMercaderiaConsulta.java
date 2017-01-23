package com.hochschild.insumoQuimico.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DistribucionMercaderiaConsulta {

	@Id
	private Long idDistribucionMercaderia;
    private String unidadMineraInsumoPresentacion;
    private String unidadMineraArea;
    private String cantidad;
    private String fechaCreacion;
	public Long getIdDistribucionMercaderia() {
		return idDistribucionMercaderia;
	}
	public void setIdDistribucionMercaderia(Long idDistribucionMercaderia) {
		this.idDistribucionMercaderia = idDistribucionMercaderia;
	}
	public String getUnidadMineraInsumoPresentacion() {
		return unidadMineraInsumoPresentacion;
	}
	public void setUnidadMineraInsumoPresentacion(
			String unidadMineraInsumoPresentacion) {
		this.unidadMineraInsumoPresentacion = unidadMineraInsumoPresentacion;
	}
	public String getUnidadMineraArea() {
		return unidadMineraArea;
	}
	public void setUnidadMineraArea(String unidadMineraArea) {
		this.unidadMineraArea = unidadMineraArea;
	}
	public String getCantidad() {
		return cantidad;
	}
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
	public String getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

}
