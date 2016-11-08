/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hochschild.sca.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.annotations.NamedNativeQuery;

/**
 *
 * @author innovabs
 */

@NamedNativeQuery(name = "getOpcionesAcciones",
    callable = true,
    query = "{call dbo.stpr_ObtenerOpcionesAccionesSeguridad(:idAplicacion, :idUsuario)}",
    readOnly = true,
    cacheable = false,
    resultClass = OpcionAccionesSCA.class)

@Entity
public class OpcionAccionesSCA {

    @Id
    private Integer idOpcion;
    private String acciones;

    /**
     * @return the acciones
     */
    public String getAcciones() {
        return acciones;
    }

    /**
     * @param acciones the acciones to set
     */
    public void setAcciones(String acciones) {
        this.acciones = acciones;
    }

        public Integer getIdOpcion() {
        return idOpcion;
    }

    public void setIdOpcion(Integer idOpcion) {
        this.idOpcion = idOpcion;
    }


}
