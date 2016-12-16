package com.hochschild.insumoQuimico.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Insumo")
public class Insumo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String idInsumo;
    private String insumo;
    private String vigencia;
	public String getIdInsumo() {
		return idInsumo;
	}
	public void setIdInsumo(String idInsumo) {
		this.idInsumo = idInsumo;
	}
	public String getInsumo() {
		return insumo;
	}
	public void setInsumo(String insumo) {
		this.insumo = insumo;
	}
	public String getVigencia() {
		return vigencia;
	}
	public void setVigencia(String vigencia) {
		this.vigencia = vigencia;
	}
    
}
