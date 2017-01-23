package com.hochschild.insumoQuimico.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UnidadMineraInsumoSaldoAlmacen")
public class UnidadMineraInsumoSaldoAlmacen implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String idUnidadMineraInsumoPresentacion;

	private Double stock;

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

}
