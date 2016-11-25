package com.hochschild.insumoQuimico.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MercaderiaConsulta {
	
	public MercaderiaConsulta(String idUnidadMinera) {
//		super();
        this.idUnidadMinera = idUnidadMinera;
		this.idMercaderia = "";
		this.idUnidadMineraAlmacen = "";
		this.rucProveedor = "";
		this.guiaRemision = "";
	}
	
	public MercaderiaConsulta() {
	}
	
	@Id
	private String idMercaderia;
	private String idUnidadMinera;
	private String transporte;
    private String guiaRemision;
    private String idUnidadMineraAlmacen;
    private String almacen;
    private String comprobanteVenta;
    private String fechaCreacion;
	private String idUsuarioCreacion;
	private String rucProveedor;
	private String descripcionProveedor;
	public String getIdMercaderia() {
		return idMercaderia;
	}
	public void setIdMercaderia(String idMercaderia) {
		this.idMercaderia = idMercaderia;
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
	public String getAlmacen() {
		return almacen;
	}
	public void setAlmacen(String almacen) {
		this.almacen = almacen;
	}
	public String getRucProveedor() {
		return rucProveedor;
	}
	public void setRucProveedor(String rucProveedor) {
		this.rucProveedor = rucProveedor;
	}
	public String getDescripcionProveedor() {
		return descripcionProveedor;
	}
	public void setDescripcionProveedor(String descripcionProveedor) {
		this.descripcionProveedor = descripcionProveedor;
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
	public String getIdUnidadMinera() {
		return idUnidadMinera;
	}
	public void setIdUnidadMinera(String idUnidadMinera) {
		this.idUnidadMinera = idUnidadMinera;
	}
	public String getIdUnidadMineraAlmacen() {
		return idUnidadMineraAlmacen;
	}
	public void setIdUnidadMineraAlmacen(String idUnidadMineraAlmacen) {
		this.idUnidadMineraAlmacen = idUnidadMineraAlmacen;
	}
	public String getComprobanteVenta() {
		return comprobanteVenta;
	}
	public void setComprobanteVenta(String comprobanteVenta) {
		this.comprobanteVenta = comprobanteVenta;
	}
}
