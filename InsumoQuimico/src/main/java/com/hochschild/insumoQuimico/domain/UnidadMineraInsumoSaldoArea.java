package com.hochschild.insumoQuimico.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UnidadMineraInsumoSaldoArea")
public class UnidadMineraInsumoSaldoArea implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUnidadMineraInsumoSaldoArea;
	private String idUnidadMineraArea;
	private String idUnidadMineraInsumoPresentacion;
	private Double stock;
	private String unidadMedida;
	public Long getIdUnidadMineraInsumoSaldoArea() {
		return idUnidadMineraInsumoSaldoArea;
	}
	public void setIdUnidadMineraInsumoSaldoArea(Long idUnidadMineraInsumoSaldoArea) {
		this.idUnidadMineraInsumoSaldoArea = idUnidadMineraInsumoSaldoArea;
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
	public Double getStock() {
		return stock;
	}
	public void setStock(Double stock) {
		this.stock = stock;
	}
	public String getUnidadMedida() {
		return unidadMedida;
	}
	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}
}
