package com.hochschild.insumoQuimico.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "CatalogoDetalle")
public class CatalogoDetalle implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CatalogoDetalle(){
    }

    public CatalogoDetalle(String idCatalogo, String idCatalogoDetalle){
        this.id = new Id();
        this.id.setIdCatalogo(idCatalogo);
        this.id.setIdCatalogoDetalle(idCatalogoDetalle);
    }
	
    @Embeddable
	public static class Id implements Serializable {
    	
		private static final long serialVersionUID = 1L;
		
    	private String idCatalogoDetalle;
		private String idCatalogo;
		
		public String getIdCatalogoDetalle() {
			return idCatalogoDetalle;
		}
		public void setIdCatalogoDetalle(String idCatalogoDetalle) {
			this.idCatalogoDetalle = idCatalogoDetalle;
		}
		public String getIdCatalogo() {
			return idCatalogo;
		}
		public void setIdCatalogo(String idCatalogo) {
			this.idCatalogo = idCatalogo;
		}
	}
	
    @EmbeddedId
    private Id id = new Id();
    
    private String descripcion;
    private String abreviatura;
    
	public Id getId() {
		return id;
	}
	public void setId(Id id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getAbreviatura() {
		return abreviatura;
	}
	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}
}
