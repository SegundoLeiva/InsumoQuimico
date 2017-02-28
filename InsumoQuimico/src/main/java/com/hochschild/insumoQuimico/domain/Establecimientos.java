package com.hochschild.insumoQuimico.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Establecimientos")
public class Establecimientos implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String idEstablecimiento;
    private String descripcionEstablecimiento;
    private int condicionEstablecimiento;
    private String idUnidadMinera;
	public String getIdEstablecimiento() {
		return idEstablecimiento;
	}
	public void setIdEstablecimiento(String idEstablecimiento) {
		this.idEstablecimiento = idEstablecimiento;
	}
	public String getDescripcionEstablecimiento() {
		return descripcionEstablecimiento;
	}
	public void setDescripcionEstablecimiento(String descripcionEstablecimiento) {
		this.descripcionEstablecimiento = descripcionEstablecimiento;
	}
	public int getCondicionEstablecimiento() {
		return condicionEstablecimiento;
	}
	public void setCondicionEstablecimiento(int condicionEstablecimiento) {
		this.condicionEstablecimiento = condicionEstablecimiento;
	}
	public String getIdUnidadMinera() {
		return idUnidadMinera;
	}
	public void setIdUnidadMinera(String idUnidadMinera) {
		this.idUnidadMinera = idUnidadMinera;
	}
}
