package com.hochschild.insumoQuimico.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ConsumoConsulta {
	
	public ConsumoConsulta(String idUnidadMinera) {
        this.idUnidadMinera = idUnidadMinera;
		this.idMercaderia = "";
		this.idUnidadMineraAlmacen = "";
		this.idUnidadMineraArea = "";
	}
	
	public ConsumoConsulta() {
	}
	
	@Id
	private String idMercaderia;
	private String idUnidadMinera;
	private String transporte;
    private String guiaRemision;
    private String idUnidadMineraAlmacen;
    private String idUnidadMineraArea;
    private String almacen;
    private String area;
    private String fechaCreacion;
	private String idUsuarioCreacion;
	public String getIdMercaderia() {
		return idMercaderia;
	}

	public void setIdMercaderia(String idMercaderia) {
		this.idMercaderia = idMercaderia;
	}

	public String getIdUnidadMinera() {
		return idUnidadMinera;
	}

	public void setIdUnidadMinera(String idUnidadMinera) {
		this.idUnidadMinera = idUnidadMinera;
	}

	public String getTransporte() {
		return transporte;
	}

	public void setTransporte(String transporte) {
		this.transporte = transporte;
	}

	public String getGuiaRemision() {
		return guiaRemision;
	}

	public void setGuiaRemision(String guiaRemision) {
		this.guiaRemision = guiaRemision;
	}

	public String getIdUnidadMineraAlmacen() {
		return idUnidadMineraAlmacen;
	}

	public void setIdUnidadMineraAlmacen(String idUnidadMineraAlmacen) {
		this.idUnidadMineraAlmacen = idUnidadMineraAlmacen;
	}

	public String getIdUnidadMineraArea() {
		return idUnidadMineraArea;
	}

	public void setIdUnidadMineraArea(String idUnidadMineraArea) {
		this.idUnidadMineraArea = idUnidadMineraArea;
	}

	public String getAlmacen() {
		return almacen;
	}

	public void setAlmacen(String almacen) {
		this.almacen = almacen;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getIdUsuarioCreacion() {
		return idUsuarioCreacion;
	}

	public void setIdUsuarioCreacion(String idUsuarioCreacion) {
		this.idUsuarioCreacion = idUsuarioCreacion;
	}
}
