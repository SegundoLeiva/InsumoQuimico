package com.hochschild.insumoQuimico.domain;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.persistence.Embeddable;

@Embeddable
public class UsuarioAuditoria implements Serializable {
    
	private static final long serialVersionUID = 5303443582269027400L;
	
	private String usuario;
	private String fecha;
//	@Temporal(TemporalType.TIMESTAMP)
//    private Date fecha;
    
    public UsuarioAuditoria() {}

//    public Date getFecha() {
//        return fecha;
//    }
//
//    public void setFecha(Date fecha) {
//        this.fecha = fecha;
//    }

    public String getUsuario() {
        return usuario;
    }

    public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    public String getFechaFormateado() {
        String fechaFormateado = "";
        
        if (this.fecha != null) {
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String fechaSap = dateFormat.format(this.fecha);
            return fechaSap;
        }
        
        return fechaFormateado;
    }
}
