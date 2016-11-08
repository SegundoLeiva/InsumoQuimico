package com.hochschild.sca.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;

/**
 *
 * @author Edson
 */

@NamedNativeQueries({
@NamedNativeQuery(name = "getOpciones",
    callable = true,
    query = "{call dbo.stpr_ObtenerOpcionesSeguridad(:idAplicacion, :idUsuario)}",
    readOnly = true,
    cacheable = false,
    resultClass = OpcionMenu.class)

})

@Entity
public class OpcionMenu implements Serializable {

    @Id
    @Column(name = "idOpcion")
    private Integer idOpcion;

    public Integer getIdOpcion() {
        return idOpcion;
    }

    public void setIdOpcion(Integer idOpcion) {
        this.idOpcion = idOpcion;
    }


}
