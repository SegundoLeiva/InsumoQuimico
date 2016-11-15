package com.hochschild.insumoQuimico.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Mercaderia")
public class Mercaderia implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String idMercaderia;

    @ManyToOne
    @JoinColumn(name="idUnidadMinera")
    private UnidadMinera unidadMinera;
    
    @ManyToOne
    @JoinColumn(name="idUnidadMineraAlmacen")
    private UnidadMineraAlmacen unidadMineraAlmacen;

    private String transporte;
    private String guiaRemision;
    private String comprobanteVenta;
    private String guiaInterna;
    private String idUsuarioCreacion;
	private Date fechaCreacion;
	private String idUsuarioModificacion;
	private Date fechaModificacion;
	
	public String getIdMercaderia() {
		return idMercaderia;
	}
	public void setIdMercaderia(String idMercaderia) {
		this.idMercaderia = idMercaderia;
	}
	public UnidadMinera getUnidadMinera() {
		return unidadMinera;
	}
	public void setUnidadMinera(UnidadMinera unidadMinera) {
		this.unidadMinera = unidadMinera;
	}
	public UnidadMineraAlmacen getUnidadMineraAlmacen() {
		return unidadMineraAlmacen;
	}
	public void setUnidadMineraAlmacen(UnidadMineraAlmacen unidadMineraAlmacen) {
		this.unidadMineraAlmacen = unidadMineraAlmacen;
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
	public String getComprobanteVenta() {
		return comprobanteVenta;
	}
	public void setComprobanteVenta(String comprobanteVenta) {
		this.comprobanteVenta = comprobanteVenta;
	}
	public String getGuiaInterna() {
		return guiaInterna;
	}
	public void setGuiaInterna(String guiaInterna) {
		this.guiaInterna = guiaInterna;
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
	public String getIdUsuarioModificacion() {
		return idUsuarioModificacion;
	}
	public void setIdUsuarioModificacion(String idUsuarioModificacion) {
		this.idUsuarioModificacion = idUsuarioModificacion;
	}
	public Date getFechaModificacion() {
		return fechaModificacion;
	}
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
}