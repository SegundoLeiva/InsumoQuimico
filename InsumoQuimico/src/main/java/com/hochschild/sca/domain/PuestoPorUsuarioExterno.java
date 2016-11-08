package com.hochschild.sca.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="PuestoPorUsuarioExterno")
public class PuestoPorUsuarioExterno implements Serializable {
    @Id
    private String idPuesto;
    private String idUsuario;
    private String nombre;
    @Transient
    private String sociedadUsuario;

    public String getIdPuesto() {
        return idPuesto;
    }

    public void setIdPuesto(String idPuesto) {
        this.idPuesto = idPuesto;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSociedadUsuario() {
        return sociedadUsuario;
    }

    public void setSociedadUsuario(String sociedadUsuario) {
        this.sociedadUsuario = sociedadUsuario;
    }
    
}
