package com.hochschild.insumoQuimico.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PresentacionInsumo")
public class PresentacionInsumo {
	
	@Id
    private String idPresentacionInsumo;
    private Long idInsumo;
    private Long idPresentacion;
    private String descripcion;
    private Double valor;
    private String idUnidadMedida;
    private String vigencia;
	public String getIdPresentacionInsumo() {
		return idPresentacionInsumo;
	}
	public void setIdPresentacionInsumo(String idPresentacionInsumo) {
		this.idPresentacionInsumo = idPresentacionInsumo;
	}
	public Long getIdInsumo() {
		return idInsumo;
	}
	public void setIdInsumo(Long idInsumo) {
		this.idInsumo = idInsumo;
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
	public String getIdUnidadMedida() {
		return idUnidadMedida;
	}
	public void setIdUnidadMedida(String idUnidadMedida) {
		this.idUnidadMedida = idUnidadMedida;
	}
	public String getVigencia() {
		return vigencia;
	}
	public void setVigencia(String vigencia) {
		this.vigencia = vigencia;
	}
	public Long getIdPresentacion() {
		return idPresentacion;
	}
	public void setIdPresentacion(Long idPresentacion) {
		this.idPresentacion = idPresentacion;
	}
	
}
