package com.hochschild.insumoQuimico.domain;

import com.hochschild.insumoQuimico.util.FechasUtil;

public class DistribucionMercaderiaConsultaModel {

    private String idUnidadMineraInsumo;
    private String idUnidadMineraArea;
    private String idPresentacionInsumo;
	private String fechaInicio;
	private String fechaFin;
	
	public DistribucionMercaderiaConsultaModel(){
		this.fechaInicio=FechasUtil.getFechaActual();
		this.fechaFin=FechasUtil.getFechaActual();
	}

	public String getIdUnidadMineraInsumo() {
		return idUnidadMineraInsumo;
	}

	public void setIdUnidadMineraInsumo(String idUnidadMineraInsumo) {
		this.idUnidadMineraInsumo = idUnidadMineraInsumo;
	}

	public String getIdUnidadMineraArea() {
		return idUnidadMineraArea;
	}

	public void setIdUnidadMineraArea(String idUnidadMineraArea) {
		this.idUnidadMineraArea = idUnidadMineraArea;
	}

	public String getIdPresentacionInsumo() {
		return idPresentacionInsumo;
	}

	public void setIdPresentacionInsumo(String idPresentacionInsumo) {
		this.idPresentacionInsumo = idPresentacionInsumo;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	
}
