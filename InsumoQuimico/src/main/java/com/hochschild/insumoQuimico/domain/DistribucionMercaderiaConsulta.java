package com.hochschild.insumoQuimico.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DistribucionMercaderiaConsulta {

	@Id
	private Long idDistribucionMercaderia;
    private String unidadMineraInsumo;
    private String unidadMineraArea;
    private String presentacionInsumo;
    private String cantidad;
    private String fechaCreacion;

    public Long getIdDistribucionMercaderia() {
		return idDistribucionMercaderia;
	}
	public void setIdDistribucionMercaderia(Long idDistribucionMercaderia) {
		this.idDistribucionMercaderia = idDistribucionMercaderia;
	}
	public String getUnidadMineraInsumo() {
		return unidadMineraInsumo;
	}
	public void setUnidadMineraInsumo(String unidadMineraInsumo) {
		this.unidadMineraInsumo = unidadMineraInsumo;
	}
	public String getUnidadMineraArea() {
		return unidadMineraArea;
	}
	public void setUnidadMineraArea(String unidadMineraArea) {
		this.unidadMineraArea = unidadMineraArea;
	}
	public String getPresentacionInsumo() {
		return presentacionInsumo;
	}
	public void setPresentacionInsumo(String presentacionInsumo) {
		this.presentacionInsumo = presentacionInsumo;
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
