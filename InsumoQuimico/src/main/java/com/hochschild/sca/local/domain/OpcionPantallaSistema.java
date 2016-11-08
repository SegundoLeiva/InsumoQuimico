package com.hochschild.sca.local.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

@Entity
@Table(name = "SistemaOpciones")
public class OpcionPantallaSistema implements Serializable {

    @Id
    private Integer idOpcion;
    private Integer idPadre;
    @Column(name="Opcion")
    private String opcion;
    private String linkOpcion;
    private String orden;
    private Integer idAplicacion;
    private String esMenu;
    private String vigente;


//    @ElementCollection(fetch=FetchType.EAGER)
//    @JoinTable(name="SistemaOpcionesAcciones", joinColumns= @JoinColumn(name="idOpcion"))
//    private List<AccionSistema> acciones = new ArrayList<AccionSistema>();

    public OpcionPantallaSistema(){}

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

    public String getEsMenu() {
        return esMenu;
    }

    public void setEsMenu(String esMenu) {
        this.esMenu = esMenu;
    }

    public String getVigente() {
        return vigente;
    }

    public void setVigente(String vigente) {
        this.vigente = vigente;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OpcionPantallaSistema other = (OpcionPantallaSistema) obj;
        if (this.idOpcion != other.idOpcion && (this.idOpcion == null || !this.idOpcion.equals(other.idOpcion))) {
            return false;
        }
        return true;
    }



}
