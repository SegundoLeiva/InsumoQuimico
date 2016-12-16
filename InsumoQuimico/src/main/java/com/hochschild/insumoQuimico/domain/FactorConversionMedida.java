package com.hochschild.insumoQuimico.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "FactorConversionMedida")
public class FactorConversionMedida implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
    private IdFactor id = new IdFactor();
	
    @Embeddable
	public static class IdFactor implements Serializable {

		private static final long serialVersionUID = 1L;

    	private String idUnidadMedidaDe;
		private String idUnidadMedidaA;
		public String getIdUnidadMedidaDe() {
			return idUnidadMedidaDe;
		}
		public void setIdUnidadMedidaDe(String idUnidadMedidaDe) {
			this.idUnidadMedidaDe = idUnidadMedidaDe;
		}
		public String getIdUnidadMedidaA() {
			return idUnidadMedidaA;
		}
		public void setIdUnidadMedidaA(String idUnidadMedidaA) {
			this.idUnidadMedidaA = idUnidadMedidaA;
		}
	}
    
    private Double factorConversion;
	private String idUsuarioCreacion;
	private Date fechaCreacion;
	private String idUsuarioModificacion;
	private Date fechaModificacion;
	public IdFactor getId() {
		return id;
	}
	public void setId(IdFactor id) {
		this.id = id;
	}
	public Double getFactorConversion() {
		return factorConversion;
	}
	public void setFactorConversion(Double factorConversion) {
		this.factorConversion = factorConversion;
	}
	public String getIdUsuarioCreacion() {
		return idUsuarioCreacion;
	}
	public void setIdUsuarioCreacion(String idUsuarioCreacion) {
		this.idUsuarioCreacion = idUsuarioCreacion;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public String getIdUsuarioModificacion() {
		return idUsuarioModificacion;
	}
	public void setIdUsuarioModificacion(String idUsuarioModificacion) {
		this.idUsuarioModificacion = idUsuarioModificacion;
	}
	public Date getFechaModificacion() {
		return fechaModificacion;
	}
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	
}

