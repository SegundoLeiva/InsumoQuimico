package com.hochschild.insumoQuimico.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "InsumoPresentacion")
public class InsumoPresentacion {
	
	@Id
    private String idPresentacionInsumo;

	@ManyToOne
    @JoinColumn(name="idInsumo")
    private Insumo insumo;
    
    private Long idPresentacion;
    private String descripcion;
    private Double valor;
    private String idUnidadMedidaPresentacion;
    private Double pesoBruto;
    private Double pesoNeto;
    private String idUnidadMedidaConversion;
    private String vigencia;
    private String codigoPresentacion;
	public String getIdPresentacionInsumo() {
		return idPresentacionInsumo;
	}
	public void setIdPresentacionInsumo(String idPresentacionInsumo) {
		this.idPresentacionInsumo = idPresentacionInsumo;
	}
	public Insumo getInsumo() {
		return insumo;
	}
	public void setInsumo(Insumo insumo) {
		this.insumo = insumo;
	}
	public Long getIdPresentacion() {
		return idPresentacion;
	}
	public void setIdPresentacion(Long idPresentacion) {
		this.idPresentacion = idPresentacion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public String getIdUnidadMedidaPresentacion() {
		return idUnidadMedidaPresentacion;
	}
	public void setIdUnidadMedidaPresentacion(String idUnidadMedidaPresentacion) {
		this.idUnidadMedidaPresentacion = idUnidadMedidaPresentacion;
	}
	public Double getPesoBruto() {
		return pesoBruto;
	}
	public void setPesoBruto(Double pesoBruto) {
		this.pesoBruto = pesoBruto;
	}
	public Double getPesoNeto() {
		return pesoNeto;
	}
	public void setPesoNeto(Double pesoNeto) {
		this.pesoNeto = pesoNeto;
	}
	public String getIdUnidadMedidaConversion() {
		return idUnidadMedidaConversion;
	}
	public void setIdUnidadMedidaConversion(String idUnidadMedidaConversion) {
		this.idUnidadMedidaConversion = idUnidadMedidaConversion;
	}
	public String getVigencia() {
		return vigencia;
	}
	public void setVigencia(String vigencia) {
		this.vigencia = vigencia;
	}
	public String getCodigoPresentacion() {
		return codigoPresentacion;
	}
	public void setCodigoPresentacion(String codigoPresentacion) {
		this.codigoPresentacion = codigoPresentacion;
	}
}
