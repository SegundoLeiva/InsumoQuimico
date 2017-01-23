package com.hochschild.insumoQuimico.domain;

import com.hochschild.insumoQuimico.util.FechasUtil;

public class DistribucionMercaderiaConsultaModel {

    private String idUnidadMineraInsumoPresentacion;
    private String idUnidadMineraArea;
	private String fechaInicio;
	private String fechaFin;
	private String idUnidadMinera;
	
	public DistribucionMercaderiaConsultaModel(){
		this.fechaInicio=FechasUtil.getFechaActual();
		this.fechaFin=FechasUtil.getFechaActual();
	}

	public String getIdUnidadMineraInsumoPresentacion() {
		return idUnidadMineraInsumoPresentacion;
	}

	public void setIdUnidadMineraInsumoPresentacion(
			String idUnidadMineraInsumoPresentacion) {
		this.idUnidadMineraInsumoPresentacion = idUnidadMineraInsumoPresentacion;
	}

	public String getIdUnidadMineraArea() {
		return idUnidadMineraArea;
	}

	public void setIdUnidadMineraArea(String idUnidadMineraArea) {
		this.idUnidadMineraArea = idUnidadMineraArea;
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

	public String getIdUnidadMinera() {
		return idUnidadMinera;
	}

	public void setIdUnidadMinera(String idUnidadMinera) {
		this.idUnidadMinera = idUnidadMinera;
	}

}
