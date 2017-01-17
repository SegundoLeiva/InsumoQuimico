package com.hochschild.insumoQuimico.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "UnidadMineraInsumo")
public class UnidadMineraInsumo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String idUnidadMineraInsumo;
	private String idUnidadMinera;
	
    @ManyToOne
    @JoinColumn(name="idInsumo")
    private Insumo insumo;
    
    private String vigencia;

	public String getIdUnidadMineraInsumo() {
		return idUnidadMineraInsumo;
	}

	public void setIdUnidadMineraInsumo(String idUnidadMineraInsumo) {
		this.idUnidadMineraInsumo = idUnidadMineraInsumo;
	}

	public String getIdUnidadMinera() {
		return idUnidadMinera;
	}

	public void setIdUnidadMinera(String idUnidadMinera) {
		this.idUnidadMinera = idUnidadMinera;
	}

	public Insumo getInsumo() {
		return insumo;
	}

	public void setInsumo(Insumo insumo) {
		this.insumo = insumo;
	}

	public String getVigencia() {
		return vigencia;
	}

	public void setVigencia(String vigencia) {
		this.vigencia = vigencia;
	}

}
