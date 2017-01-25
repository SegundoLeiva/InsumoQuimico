package com.hochschild.insumoQuimico.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;

@NamedNativeQueries({
@NamedNativeQuery(name = "listaConsumo",
callable = true,
query = "{call dbo.stpr_ListaConsumo(:idUnidadMinera,:idConsumo,:idUnidadMineraArea,:fechaInicio,:fechaFin,:idUsuarioCreacion)}",
readOnly = true,
cacheable = false,
resultClass = ConsumoConsulta.class),

@NamedNativeQuery(name = "listaConsumoReporte",
callable = true,
query = "{call dbo.stpr_ListaConsumoReporte(:idUnidadMinera,:anio,:mes)}",
readOnly = true,
cacheable = false,
resultClass = ConsumoConsulta.class)
})

@Entity
@Table(name = "Consumo")
public class Consumo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String idConsumo;

    @ManyToOne
    @JoinColumn(name="idUnidadMinera")
    private UnidadMinera unidadMinera;
    
    @ManyToOne
    @JoinColumn(name="idUnidadMineraArea")
    private UnidadMineraArea unidadMineraArea;

    private String idUsuarioCreacion;
	private Date fechaCreacion;
	private String idUsuarioModificacion;
	private Date fechaModificacion;
	private Date fechaConsumo;
	
	public String getIdConsumo() {
		return idConsumo;
	}
	public void setIdConsumo(String idConsumo) {
		this.idConsumo = idConsumo;
	}
	public UnidadMinera getUnidadMinera() {
		return unidadMinera;
	}
	public void setUnidadMinera(UnidadMinera unidadMinera) {
		this.unidadMinera = unidadMinera;
	}

	public UnidadMineraArea getUnidadMineraArea() {
		return unidadMineraArea;
	}
	public void setUnidadMineraArea(UnidadMineraArea unidadMineraArea) {
		this.unidadMineraArea = unidadMineraArea;
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
	public Date getFechaConsumo() {
		return fechaConsumo;
	}
	public void setFechaConsumo(Date fechaConsumo) {
		this.fechaConsumo = fechaConsumo;
	}
}
