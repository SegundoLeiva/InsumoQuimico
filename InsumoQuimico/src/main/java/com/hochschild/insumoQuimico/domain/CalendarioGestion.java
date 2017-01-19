package com.hochschild.insumoQuimico.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "CalendarioGestion")
public class CalendarioGestion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
    private IdCalendario id = new IdCalendario();
	
    @Embeddable
	public static class IdCalendario implements Serializable {

		private static final long serialVersionUID = 1L;

    	private String idUnidadMinera;
		private String idAnioGestion;
		private String idMesGestion;
		
		public String getIdUnidadMinera() {
			return idUnidadMinera;
		}
		public void setIdUnidadMinera(String idUnidadMinera) {
			this.idUnidadMinera = idUnidadMinera;
		}
		public String getIdAnioGestion() {
			return idAnioGestion;
		}
		public void setIdAnioGestion(String idAnioGestion) {
			this.idAnioGestion = idAnioGestion;
		}
		public String getIdMesGestion() {
			return idMesGestion;
		}
		public void setIdMesGestion(String idMesGestion) {
			this.idMesGestion = idMesGestion;
		}
		
	}
    private Date fechaInicio;
    private Date fechaFin;
    private String aperturado;
	private String idUsuarioCreacion;	
	private Date fechaCreacion;	
	private String idUsuarioModificacion;	
	private Date fechaModificacion;
	private int diasTolerancia;
	public IdCalendario getId() {
		return id;
	}
	public void setId(IdCalendario id) {
		this.id = id;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public String getAperturado() {
		return aperturado;
	}
	public void setAperturado(String aperturado) {
		this.aperturado = aperturado;
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
	public int getDiasTolerancia() {
		return diasTolerancia;
	}
	public void setDiasTolerancia(int diasTolerancia) {
		this.diasTolerancia = diasTolerancia;
	}
	
}
