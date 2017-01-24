package com.hochschild.insumoQuimico.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Catalogo")
public class Catalogo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String idCatalogo;
    private String descripcion;
    
	public String getIdCatalogo() {
		return idCatalogo;
	}
	public void setIdCatalogo(String idCatalogo) {
		this.idCatalogo = idCatalogo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
