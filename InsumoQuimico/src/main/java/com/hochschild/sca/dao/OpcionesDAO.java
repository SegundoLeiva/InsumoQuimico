package com.hochschild.sca.dao;

import java.util.List;

import com.hochschild.sca.domain.OpcionAcciones;

public interface OpcionesDAO {
    public List<OpcionAcciones> getOpcionesAcciones(String idAplicacion, String idUsuario);
    public List<String> getOpciones(String idAplicacion, String idUsuario);   
}
