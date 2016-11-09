package com.hochschild.insumoQuimico.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "DivisionesCIA")
public class DivisionesCIA implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private IdDivisiones id = new IdDivisiones();

	@Embeddable
	public static class IdDivisiones implements Serializable {

		private static final long serialVersionUID = 1L;

		private String idSociedad;
		private String idDivision;

		public String getIdSociedad() {
			return idSociedad;
		}

		public void setIdSociedad(String idSociedad) {
			this.idSociedad = idSociedad;
		}

		public String getIdDivision() {
			return idDivision;
		}

		public void setIdDivision(String idDivision) {
			this.idDivision = idDivision;
		}

	}
	
        private String idUnidadMinera;
        private String division;
	private String vigencia;
	private String idUsuarioCreacion;

	private Date fechaCreacion;

	private String idUsuarioModifica;

	private Date fechaModifica;

	public IdDivisiones getId() {
		return id;
	}

	public void setId(IdDivisiones id) {
		this.id = id;
	}

	public String getIdUnidadMinera() {
		return idUnidadMinera;
	}

	public void setUnidadMinera(String idUnidadMinera) {
		this.idUnidadMinera = idUnidadMinera;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getVigencia() {
		return vigencia;
	}

	public void setVigencia(String vigencia) {
		this.vigencia = vigencia;
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

	public String getIdUsuarioModifica() {
		return idUsuarioModifica;
	}

	public void setIdUsuarioModifica(String idUsuarioModifica) {
		this.idUsuarioModifica = idUsuarioModifica;
	}

	public Date getFechaModifica() {
		return fechaModifica;
	}

	public void setFechaModifica(Date fechaModifica) {
		this.fechaModifica = fechaModifica;
	}

}
