package com.hochschild.insumoQuimico.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "UnidadMineraInsumoSaldoAlmacen")
public class UnidadMineraInsumoSaldoAlmacen implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUnidadMineraInsumoSaldoAlmacen;
	
	@ManyToOne
	@JoinColumn(name = "idUnidadMineraInsumo")
	private UnidadMineraInsumo unidadMineraInsumo;

	@ManyToOne
	@JoinColumn(name = "idPresentacionInsumo")
	private PresentacionInsumo presentacionInsumo;
	
	private Double stock;

	public Long getIdUnidadMineraInsumoSaldoAlmacen() {
		return idUnidadMineraInsumoSaldoAlmacen;
	}

	public void setIdUnidadMineraInsumoSaldoAlmacen(
			Long idUnidadMineraInsumoSaldoAlmacen) {
		this.idUnidadMineraInsumoSaldoAlmacen = idUnidadMineraInsumoSaldoAlmacen;
	}

	public UnidadMineraInsumo getUnidadMineraInsumo() {
		return unidadMineraInsumo;
	}

	public void setUnidadMineraInsumo(UnidadMineraInsumo unidadMineraInsumo) {
		this.unidadMineraInsumo = unidadMineraInsumo;
	}

	public PresentacionInsumo getPresentacionInsumo() {
		return presentacionInsumo;
	}

	public void setPresentacionInsumo(PresentacionInsumo presentacionInsumo) {
		this.presentacionInsumo = presentacionInsumo;
	}

	public Double getStock() {
		return stock;
	}

	public void setStock(Double stock) {
		this.stock = stock;
	}

}
