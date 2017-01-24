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
	@JoinColumn(name = "idUnidadMineraInsumoPresentacion")
	private UnidadMineraInsumoPresentacion unidadMineraInsumoPresentacion;
	
	@ManyToOne
	@JoinColumn(name = "idMercaderia",referencedColumnName = "idMercaderia", insertable=false,updatable = false, nullable=false)
	private Mercaderia mercaderia;
	
	private Double cantidad;
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
	public UnidadMineraInsumoPresentacion getUnidadMineraInsumoPresentacion() {
		return unidadMineraInsumoPresentacion;
	}
	public void setUnidadMineraInsumoPresentacion(
			UnidadMineraInsumoPresentacion unidadMineraInsumoPresentacion) {
		this.unidadMineraInsumoPresentacion = unidadMineraInsumoPresentacion;
	}
	public Double getCantidad() {
		return cantidad;
	}
	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
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
	public Mercaderia getMercaderia() {
		return mercaderia;
	}
	public void setMercaderia(Mercaderia mercaderia) {
		this.mercaderia = mercaderia;
	}
	
}
