package com.hochschild.insumoQuimico.domain;

import com.hochschild.insumoQuimico.util.FechasUtil;



public class CalendarioGestionModel {

	private String idUnidadMinera;
    private String anio;
    private String mes;
    
    public CalendarioGestionModel(Usuario usuarioSession){
		this.idUnidadMinera=usuarioSession.getIdUnidadMineraPorDefecto();
		this.anio=FechasUtil.getAnioActual();
	}
	
	public CalendarioGestionModel(){
		
	}
	
	public String getIdUnidadMinera() {
		return idUnidadMinera;
	}
	public void setIdUnidadMinera(String idUnidadMinera) {
		this.idUnidadMinera = idUnidadMinera;
	}
	public String getAnio() {
		return anio;
	}
	public void setAnio(String anio) {
		this.anio = anio;
	}
	public String getMes() {
		return mes;
	}
	public void setMes(String mes) {
		this.mes = mes;
	}

}
