package com.hochschild.sca.local.domain;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.hochschild.insumoQuimico.domain.EntidadAuditable;


@Entity
@Table(name = "SistemaOpcionesMenu")
@AttributeOverrides({
    @AttributeOverride(name = "usuarioCreacion.usuario", column = @Column(name="idUsuarioCrea")),
    @AttributeOverride(name = "usuarioCreacion.fecha",  column =  @Column(name="fechaCreacion")),
    @AttributeOverride(name = "usuarioModifica.usuario", column = @Column(name="idUsuarioModifica")),
    @AttributeOverride(name = "usuarioModifica.fecha",  column =  @Column(name="fechaModifica"))
})
public class SistemaOpcionMenu extends EntidadAuditable {

	private static final long serialVersionUID = 1L;

    @EmbeddedId
    private Id id = new Id();
    
    public SistemaOpcionMenu(Integer idAplicacion,String idOpcionMenu){
    	id = new Id();
    	id.setIdAplicacion(idAplicacion);
    	id.setIdOpcionMenu(idOpcionMenu);
    }
    
    public SistemaOpcionMenu(){
    	id = new Id();
    }
    
	public Integer getIdAplicacion() {
		return id.getIdAplicacion();
	}
	public void setIdAplicacion(Integer idAplicacion) {
		id.setIdAplicacion(idAplicacion);
	}
	public String getIdOpcionMenu() {
		return id.getIdOpcionMenu();
	}
	public void setIdOpcionMenu(String idOpcionMenu) {
		id.setIdOpcionMenu(idOpcionMenu);
	}
	
    @Embeddable
	public static class Id implements Serializable {

		private static final long serialVersionUID = 1L;
		
		private Integer idAplicacion;
    	private String idOpcionMenu;
    	
		public Integer getIdAplicacion() {
			return idAplicacion;
		}
		public void setIdAplicacion(Integer idAplicacion) {
			this.idAplicacion = idAplicacion;
		}
		public String getIdOpcionMenu() {
			return idOpcionMenu;
		}
		public void setIdOpcionMenu(String idOpcionMenu) {
			this.idOpcionMenu = idOpcionMenu;
		}

	}

    private Integer idOpcion;

	public Id getId() {
		return id;
	}

	public void setId(Id id) {
		this.id = id;
	}

	public Integer getIdOpcion() {
		return idOpcion;
	}

	public void setIdOpcion(Integer idOpcion) {
		this.idOpcion = idOpcion;
	}
}
