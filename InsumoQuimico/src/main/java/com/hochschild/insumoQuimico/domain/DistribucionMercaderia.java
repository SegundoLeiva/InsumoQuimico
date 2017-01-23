package com.hochschild.insumoQuimico.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;

@NamedNativeQueries({
@NamedNativeQuery(name = "listaDistribucionMercaderia",
callable = true,
query = "{call dbo.stpr_ListaDistribucionMercaderia(:idUnidadMineraInsumoPresentacion,:idUnidadMineraArea,:fechaInicio,:fechaFin)}",
readOnly = true,
cacheable = false,
resultClass = DistribucionMercaderiaConsulta.class),

})

@Entity
@Table(name = "DistribucionMercaderia")
public class DistribucionMercaderia implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDistribucionMercaderia;

	@ManyToOne
	@JoinColumn(name = "idUnidadMineraArea")
	private UnidadMineraArea unidadMineraArea;

	@ManyToOne
	@JoinColumn(name = "idUnidadMineraInsumoPresentacion")
	private UnidadMineraInsumoPresentacion unidadMineraInsumoPresentacion;
	
	private Double cantidad;
	private String idUsuarioCreacion;	
	private Date fechaCreacion;	
	private String idUsuarioModificacion;	
	private Date fechaModificacion;
	public Long getIdDistribucionMercaderia() {
		return idDistribucionMercaderia;
	}
	public void setIdDistribucionMercaderia(Long idDistribucionMercaderia) {
		this.idDistribucionMercaderia = idDistribucionMercaderia;
	}
	public UnidadMineraArea getUnidadMineraArea() {
		return unidadMineraArea;
	}
	public void setUnidadMineraArea(UnidadMineraArea unidadMineraArea) {
		this.unidadMineraArea = unidadMineraArea;
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

}
