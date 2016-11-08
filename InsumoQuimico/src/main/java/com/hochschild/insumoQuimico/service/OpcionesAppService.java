package com.hochschild.insumoQuimico.service;

import java.util.List;

import com.hochschild.insumoQuimico.domain.OpcionApp;

public interface OpcionesAppService {
    //public List<OpcionApp> getOpciones(String opciones);
    
    public List<OpcionApp> listaOpcionesApp(String idAplicacion, String idUsuario);
}
