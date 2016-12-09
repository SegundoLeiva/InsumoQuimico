package com.hochschild.insumoQuimico.domain;

import javax.servlet.http.HttpSession;

import com.hochschild.insumoQuimico.util.FechasUtil;

public class ConsumoConsultaModel {

	private String idConsumo;
	private String idUnidadMinera;
    private String idUnidadMineraAlmacen;
    private String idUnidadMineraArea;
    private String almacen;
    private String area;
    private String cantidad;
    private String fechaCreacion;
	private String idUsuarioCreacion;
	private String fechaInicio;
	private String fechaFin;
	
	public ConsumoConsultaModel(HttpSession sesion,String idUnidadMinera){
		Usuario usuarioSession = (Usuario) sesion.getAttribute("session_usuario");
		this.fechaInicio=FechasUtil.getFechaActual();
		this.fechaFin=FechasUtil.getFechaActual();
		this.idUsuarioCreacion=usuarioSession.getIdUsuario();
		this.idUnidadMinera=idUnidadMinera;
	}
	
	public ConsumoConsultaModel(){
		
	}
	
	public String getIdConsumo() {
		return idConsumo;
	}

	public void setIdConsumo(String idConsumo) {
		this.idConsumo = idConsumo;
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

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
}
