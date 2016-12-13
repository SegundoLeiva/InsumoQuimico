package com.hochschild.insumoQuimico.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "ConsumoDetalle")
public class ConsumoDetalle implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
    private IdConsumo id = new IdConsumo();
	
    @Embeddable
	public static class IdConsumo implements Serializable {

		private static final long serialVersionUID = 1L;

    	private String idConsumo;
		private Long idConsumoDetalle;
		public String getIdConsumo() {
			return idConsumo;
		}
		public void setIdConsumo(String idConsumo) {
			this.idConsumo = idConsumo;
		}
		public Long getIdConsumoDetalle() {
			return idConsumoDetalle;
		}
		public void setIdConsumoDetalle(Long idConsumoDetalle) {
			this.idConsumoDetalle = idConsumoDetalle;
		}
	}
	
	@ManyToOne
	@JoinColumn(name = "idUnidadMineraInsumo")
	private UnidadMineraInsumo unidadMineraInsumo;
	
	private Double cantidad;
	
	private String unidadMedida;	
	
	private String idUsuarioCreacion;	
	private Date fechaCreacion;	
	private String idUsuarioModificacion;	
	private Date fechaModificacion;
	public IdConsumo getId() {
		return id;
	}
	public void setId(IdConsumo id) {
		this.id = id;
	}
	public UnidadMineraInsumo getUnidadMineraInsumo() {
		return unidadMineraInsumo;
	}
	public void setUnidadMineraInsumo(UnidadMineraInsumo unidadMineraInsumo) {
		this.unidadMineraInsumo = unidadMineraInsumo;
	}
	
	public Double getCantidad() {
		return cantidad;
	}
	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}
	public String getUnidadMedida() {
		return unidadMedida;
	}
	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
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
