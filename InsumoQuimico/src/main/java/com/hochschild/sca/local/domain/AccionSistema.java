package com.hochschild.sca.local.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.Parent;

@Embeddable
public class AccionSistema implements Serializable{

	private static final long serialVersionUID = 2853931853564606369L;

	@Parent
    private OpcionPantallaSistema opcionContenedora;

    private String idAccion;
    private String descripcion;

    @ManyToOne
    @JoinColumn(name="idOpcionLink")
    private OpcionPantallaSistema opcionDisparada;

    private String vigente;

    public AccionSistema(){}

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public String getIdAccion() {
        return idAccion;
    }

    public void setIdAccion(String idAccion) {
        this.idAccion = idAccion;
    }

    public OpcionPantallaSistema getOpcionContenedora() {
        return opcionContenedora;
    }

    public void setOpcionContenedora(OpcionPantallaSistema opcionContenedora) {
        this.opcionContenedora = opcionContenedora;
    }

    public OpcionPantallaSistema getOpcionDisparada() {
        return opcionDisparada;
    }

    public void setOpcionDisparada(OpcionPantallaSistema opcionDisparada) {
        this.opcionDisparada = opcionDisparada;
    }

    public String getVigente() {
        return vigente;
    }

    public void setVigente(String vigente) {
        this.vigente = vigente;
    }
}
