package com.hochschild.insumoQuimico.domain;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.hochschild.insumoQuimico.util.FechasUtil;


@Entity
@Table(name = "UnidadMineraMovimientosInsumos")
public class UnidadMineraMovimientosInsumos implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String idMovimiento;
	private String codigoSolicitud;
	private String idUnidadMineraInsumo;
	private String tipoMovimiento;
	private Double cantidad;
	private Date fechaMovimiento;
	private Date fechaCreacion;
	private String idUsuarioCreacion;
	
	public UnidadMineraMovimientosInsumos(String idUnidadMinera, String idUsuarioCreacion){
		DateFormat df = new SimpleDateFormat("ddMMyyyyHHmmssSSSSSS");
		String requiredDate = df.format(new Date()).toString();			
		
		this.idMovimiento = idUnidadMinera+requiredDate;
		this.fechaMovimiento=new Date();
		this.fechaCreacion=new Date();
		this.idUsuarioCreacion=idUsuarioCreacion;
	}
	
	public UnidadMineraMovimientosInsumos(){
		
	}
	
	public String getIdMovimiento() {
		return idMovimiento;
	}
	public void setIdMovimiento(String idMovimiento) {
		this.idMovimiento = idMovimiento;
	}
	public String getCodigoSolicitud() {
		return codigoSolicitud;
	}
	public void setCodigoSolicitud(String codigoSolicitud) {
		this.codigoSolicitud = codigoSolicitud;
	}
	public String getIdUnidadMineraInsumo() {
		return idUnidadMineraInsumo;
	}
	public void setIdUnidadMineraInsumo(String idUnidadMineraInsumo) {
		this.idUnidadMineraInsumo = idUnidadMineraInsumo;
	}
	public String getTipoMovimiento() {
		return tipoMovimiento;
	}
	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}
	public Double getCantidad() {
		return cantidad;
	}
	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}
	public Date getFechaMovimiento() {
		return fechaMovimiento;
	}
	public void setFechaMovimiento(Date fechaMovimiento) {
		this.fechaMovimiento = fechaMovimiento;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public String getIdUsuarioCreacion() {
		return idUsuarioCreacion;
	}
	public void setIdUsuarioCreacion(String idUsuarioCreacion) {
		this.idUsuarioCreacion = idUsuarioCreacion;
	}
}
