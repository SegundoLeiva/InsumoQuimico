
package com.hochschild.insumoQuimico.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Transient;

import com.hochschild.sca.domain.OpcionAccionesSCA;
import com.hochschild.sca.local.domain.OpcionPantallaSistema;

public class Usuario {   

    private String idUsuario;
    private String correo;
    private String nombre;
    private String sociedadUsuario;
    private String divisionUsuario;
    private boolean esUsuarioLogistica;
    
    @Transient
    private String  idAmbienteUnidadMinera;
    
    private List<OpcionApp> lst_opciones = new ArrayList<OpcionApp>();
    private List<OpcionPantallaSistema> lst_opcionesSIOAutorizadas = new ArrayList<OpcionPantallaSistema>();

    private Map<Integer, OpcionAccionesSCA> lstOpcionesAutorizadas = new HashMap<Integer, OpcionAccionesSCA>();
    private List<ValorOrganizacionalSesion> lst_valoresOrganizacionales = new ArrayList<ValorOrganizacionalSesion>();
    private List<ValorOrganizacionalSesion> listaUnidadesMineras;
    private String idUnidadMineraPorDefecto;
    public String getDivisionUsuario() {
        return divisionUsuario;
    }

    public void setDivisionUsuario(String divisionUsuario) {
        this.divisionUsuario = divisionUsuario;
    }  
   
    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<OpcionApp> getLst_opciones() {
        return lst_opciones;
    }

    public void setLst_opciones(List<OpcionApp> lst_opciones) {
        this.lst_opciones = lst_opciones;
    }

    public List<ValorOrganizacionalSesion> getLst_valoresOrganizacionales() {
        return lst_valoresOrganizacionales;
    }

    public void setLst_valoresOrganizacionales(List<ValorOrganizacionalSesion> lst_valoresOrganizacionales) {
        this.lst_valoresOrganizacionales = lst_valoresOrganizacionales;
    }

    public List<OpcionPantallaSistema> getLst_opcionesSIOAutorizadas() {
        return lst_opcionesSIOAutorizadas;
    }

    public void setLst_opcionesSIOAutorizadas(List<OpcionPantallaSistema> lst_opcionesSIOAutorizadas) {
        this.lst_opcionesSIOAutorizadas = lst_opcionesSIOAutorizadas;
    }

    public Map<Integer, OpcionAccionesSCA> getLstOpcionesAutorizadas() {
        return lstOpcionesAutorizadas;
    }

    public void setLstOpcionesAutorizadas(Map<Integer, OpcionAccionesSCA> lstOpcionesAutorizadas) {
        this.lstOpcionesAutorizadas = lstOpcionesAutorizadas;
    }

    public void addOpcionAutorizada(OpcionAccionesSCA opcion){
        this.lstOpcionesAutorizadas.put(opcion.getIdOpcion(), opcion);
    }

    public OpcionAccionesSCA getOpcionAcciones(Integer idOpcion){
        return lstOpcionesAutorizadas.get(idOpcion);
    }

    public void setLstOpcionesAutorizadas(List<OpcionAccionesSCA> opcionesAutorizadas) {
        for (OpcionAccionesSCA opcion : opcionesAutorizadas){
           addOpcionAutorizada(opcion);
        }
    }

    public String getIdAmbienteUnidadMinera() {
        return idAmbienteUnidadMinera;
    }

    public void setIdAmbienteUnidadMinera(String idAmbienteUnidadMinera) {
        this.idAmbienteUnidadMinera = idAmbienteUnidadMinera;
    }

    public boolean getEsUsuarioLogistica() {
        return esUsuarioLogistica;
    }

    public void setEsUsuarioLogistica(boolean esUsuarioLogistica) {
        this.esUsuarioLogistica = esUsuarioLogistica;
    }

    public String getSociedadUsuario() {
        return sociedadUsuario;
    }

    public void setSociedadUsuario(String sociedadUsuario) {
        this.sociedadUsuario = sociedadUsuario;
    }

	public List<ValorOrganizacionalSesion> getListaUnidadesMineras() {
		return listaUnidadesMineras;
	}

	public void setListaUnidadesMineras(
			List<ValorOrganizacionalSesion> listaUnidadesMineras) {
		this.listaUnidadesMineras = listaUnidadesMineras;
	}

	public String getIdUnidadMineraPorDefecto() {
		return idUnidadMineraPorDefecto;
	}

	public void setIdUnidadMineraPorDefecto(String idUnidadMineraPorDefecto) {
		this.idUnidadMineraPorDefecto = idUnidadMineraPorDefecto;
	}
    
    
}
