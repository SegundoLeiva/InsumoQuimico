package com.hochschild.insumoQuimico.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.hochschild.insumoQuimico.domain.MercaderiaDetalle.IdMercaderia;

@Entity
@Table(name = "UnidadMineraInsumoSaldo")
public class UnidadMineraInsumoSaldo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
    private IdSaldo id = new IdSaldo();
	
    @Embeddable
	public static class IdSaldo implements Serializable {

		private static final long serialVersionUID = 1L;

    	private String idUnidadMineraInsumo;
		private String idUnidadMineraAlmacen;
		public String getIdUnidadMineraInsumo() {
			return idUnidadMineraInsumo;
		}
		public void setIdUnidadMineraInsumo(String idUnidadMineraInsumo) {
			this.idUnidadMineraInsumo = idUnidadMineraInsumo;
		}
		public String getIdUnidadMineraAlmacen() {
			return idUnidadMineraAlmacen;
		}
		public void setIdUnidadMineraAlmacen(String idUnidadMineraAlmacen) {
			this.idUnidadMineraAlmacen = idUnidadMineraAlmacen;
		}
	}
    
	private Double stock;
	private String unidadMedida;

	public IdSaldo getId() {
		return id;
	}
	public void setId(IdSaldo id) {
		this.id = id;
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
