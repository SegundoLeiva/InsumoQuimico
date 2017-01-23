package com.hochschild.insumoQuimico.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "UnidadMineraInsumoPresentacion")
public class UnidadMineraInsumoPresentacion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String idUnidadMineraInsumoPresentacion;
	private String idUnidadMinera;
	
    @ManyToOne
    @JoinColumn(name="idInsumoPresentacion")
    private InsumoPresentacion presentacionInsumo;
    
    private String vigencia;

	public String getIdUnidadMineraInsumoPresentacion() {
		return idUnidadMineraInsumoPresentacion;
	}

	public void setIdUnidadMineraInsumoPresentacion(
			String idUnidadMineraInsumoPresentacion) {
		this.idUnidadMineraInsumoPresentacion = idUnidadMineraInsumoPresentacion;
	}

	public String getIdUnidadMinera() {
		return idUnidadMinera;
	}

	public void setIdUnidadMinera(String idUnidadMinera) {
		this.idUnidadMinera = idUnidadMinera;
	}

	public InsumoPresentacion getPresentacionInsumo() {
		return presentacionInsumo;
	}

	public void setPresentacionInsumo(InsumoPresentacion presentacionInsumo) {
		this.presentacionInsumo = presentacionInsumo;
	}

	public String getVigencia() {
		return vigencia;
	}

	public void setVigencia(String vigencia) {
		this.vigencia = vigencia;
	}
}
