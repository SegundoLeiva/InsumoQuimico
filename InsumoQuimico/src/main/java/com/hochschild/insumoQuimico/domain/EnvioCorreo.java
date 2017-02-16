package com.hochschild.insumoQuimico.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "EnvioCorreo")
public class EnvioCorreo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
    private IdEnvioCorreo id = new IdEnvioCorreo();
	
    @Embeddable
	public static class IdEnvioCorreo implements Serializable {

		private static final long serialVersionUID = 1L;

		private int idEnvioCorreo;
		private String idUnidadMinera;
		public int getIdEnvioCorreo() {
			return idEnvioCorreo;
		}
		public void setIdEnvioCorreo(int idEnvioCorreo) {
			this.idEnvioCorreo = idEnvioCorreo;
		}
		public String getIdUnidadMinera() {
			return idUnidadMinera;
		}
		public void setIdUnidadMinera(String idUnidadMinera) {
			this.idUnidadMinera = idUnidadMinera;
		}
	}
    
    private String textoCorreo;
    private String toCorreo;
    private String ccCorreo;
    private String estadoCorreo;
    private Date fechaEnvioCorreo;
	public IdEnvioCorreo getId() {
		return id;
	}
	public void setId(IdEnvioCorreo id) {
		this.id = id;
	}
	public String getTextoCorreo() {
		return textoCorreo;
	}
	public void setTextoCorreo(String textoCorreo) {
		this.textoCorreo = textoCorreo;
	}
	public String getToCorreo() {
		return toCorreo;
	}
	public void setToCorreo(String toCorreo) {
		this.toCorreo = toCorreo;
	}
	public String getCcCorreo() {
		return ccCorreo;
	}
	public void setCcCorreo(String ccCorreo) {
		this.ccCorreo = ccCorreo;
	}
	public String getEstadoCorreo() {
		return estadoCorreo;
	}
	public void setEstadoCorreo(String estadoCorreo) {
		this.estadoCorreo = estadoCorreo;
	}
	public Date getFechaEnvioCorreo() {
		return fechaEnvioCorreo;
	}
	public void setFechaEnvioCorreo(Date fechaEnvioCorreo) {
		this.fechaEnvioCorreo = fechaEnvioCorreo;
	}

}
