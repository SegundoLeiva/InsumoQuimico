package com.hochschild.insumoQuimico.domain;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
abstract public class EntidadAuditable implements Serializable{

    @Embedded
    private UsuarioAuditoria usuarioCreacion;
    @Embedded
    private UsuarioAuditoria usuarioModifica;
    
    public EntidadAuditable() {
        this.usuarioCreacion = new UsuarioAuditoria();
        this.usuarioModifica = new UsuarioAuditoria();
    }
    private static final long serialVersionUID = 1L;
    
    public UsuarioAuditoria getUsuarioCreacion() {
        return usuarioCreacion != null ? usuarioCreacion: (usuarioCreacion = new UsuarioAuditoria());
    }

    public void setUsuarioCreacion(UsuarioAuditoria usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public UsuarioAuditoria getUsuarioModifica() {
        return usuarioModifica != null ? usuarioModifica: (usuarioModifica = new UsuarioAuditoria());
    }

    public void setUsuarioModifica(UsuarioAuditoria usuarioEdicion) {
        this.usuarioModifica = usuarioEdicion;
    }
}