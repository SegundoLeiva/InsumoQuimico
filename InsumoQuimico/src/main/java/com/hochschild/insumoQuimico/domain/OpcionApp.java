package com.hochschild.insumoQuimico.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OpcionApp {
    @Id
    private Integer idOpcion;
    private Integer idPadre;
    private String opcion;
    private String linkOpcion;
    private String orden;
    private Integer idAplicacion;


    public Integer getIdAplicacion() {
        return idAplicacion;
    }

    public void setIdAplicacion(Integer idAplicacion) {
        this.idAplicacion = idAplicacion;
    }

    public Integer getIdOpcion() {
        return idOpcion;
    }

    public void setIdOpcion(Integer idOpcion) {
        this.idOpcion = idOpcion;
    }

    public Integer getIdPadre() {
        return idPadre;
    }

    public void setIdPadre(Integer idPadre) {
        this.idPadre = idPadre;
    }

    public String getLinkOpcion() {
        return linkOpcion;
    }

    public void setLinkOpcion(String linkOpcion) {
        this.linkOpcion = linkOpcion;
    }

    public String getOpcion() {
        return opcion;
    }

    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }

    public String getOrden() {
        return orden;
    }

    public void setOrden(String orden) {
        this.orden = orden;
    }
}
