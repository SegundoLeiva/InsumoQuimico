
package com.hochschild.insumoQuimico.domain;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UnidadMinera")
@AttributeOverrides({
        @AttributeOverride(name = "usuarioCreacion.usuario", column = @Column(name="idUsuarioCreacion")),
        @AttributeOverride(name = "usuarioCreacion.fecha",  column =  @Column(name="fechaCreacion")),
        @AttributeOverride(name = "usuarioModifica.usuario", column = @Column(name="idUsuarioModifica")),
        @AttributeOverride(name = "usuarioModifica.fecha",  column =  @Column(name="fechaModifica"))
})
public class UnidadMinera implements Serializable {
    
    private static final long serialVersionUID = -4195341300206146727L;
    
    @Id
    private String idUnidadMinera;
    private String unidadMinera;
    private String abreviaturaUnidadMinera;
    private String vigencia;
    
    public UnidadMinera(){}

    public String getIdUnidadMinera() {
            return idUnidadMinera;
    }

    public void setIdUnidadMinera(String idUnidadMinera) {
            this.idUnidadMinera = idUnidadMinera;
    }

    public String getUnidadMinera() {
        return unidadMinera;
    }

    public void setUnidadMinera(String unidadMinera) {
        this.unidadMinera = unidadMinera;
    }

    public String getAbreviaturaUnidadMinera() {
        return abreviaturaUnidadMinera;
    }

    public void setAbreviaturaUnidadMinera(String abreviaturaUnidadMinera) {
        this.abreviaturaUnidadMinera = abreviaturaUnidadMinera;
    }

    /**
     * @return the vigencia
     */
    public String getVigencia() {
        return vigencia;
    }

    /**
     * @param vigencia the vigencia to set
     */
    public void setVigencia(String vigencia) {
        this.vigencia = vigencia;
    }
}
