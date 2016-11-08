/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hochschild.sca.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.annotations.NamedNativeQuery;

/**
 *
 * @author Edson
 */

@NamedNativeQuery(name = "getValoresOrganizacionales",
    callable = true,
    query = "{call dbo.stpr_ObtenerValoresOrganizacionalesSeguridad(:idAplicacion, :idUsuario, :idEstructura)}",
    readOnly = true,
    cacheable = false,
    resultClass = ValorOrganizacional.class)
@Entity
public class ValorOrganizacional implements Serializable {

    @Id
    private String valor;

    public String getValor() {
        return valor;
    }

    public void setValor(String valorOrganizacional) {
        this.valor = valorOrganizacional;
    }

    

}
