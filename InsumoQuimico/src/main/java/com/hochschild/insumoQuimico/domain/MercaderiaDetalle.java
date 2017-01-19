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
@Table(name = "MercaderiaDetalle")
public class MercaderiaDetalle implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
    private IdMercaderia id = new IdMercaderia();
	
    @Embeddable
	public static class IdMercaderia implements Serializable {

		private static final long serialVersionUID = 1L;

    	private String idMercaderia;
		private Long idMercaderiaDetalle;
		public String getIdMercaderia() {
			return idMercaderia;
		}
		public void setIdMercaderia(String idMercaderia) {
			this.idMercaderia = idMercaderia;
		}
		public Long getIdMercaderiaDetalle() {
			return idMercaderiaDetalle;
		}
		public void setIdMercaderiaDetalle(Long idMercaderiaDetalle) {
			this.idMercaderiaDetalle = idMercaderiaDetalle;
		}
	}
	
	@ManyToOne
	@JoinColumn(name = "idUnidadMineraInsumo")
	private UnidadMineraInsumo unidadMineraInsumo;
	
	@ManyToOne
	@JoinColumn(name = "idPresentacionInsumo")
	private PresentacionInsumo presentacionInsumo;
	
	private Double cantidad;
	private String unidadMedida;	
	private String idUsuarioCreacion;	
	private Date fechaCreacion;	
	private String idUsuarioModificacion;	
	private Date fechaModificacion;
	public IdMercaderia getId() {
		return id;
	}
	public void setId(IdMercaderia id) {
		this.id = id;
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
