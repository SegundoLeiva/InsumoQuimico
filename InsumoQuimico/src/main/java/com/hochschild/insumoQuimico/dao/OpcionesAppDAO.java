
package com.hochschild.insumoQuimico.dao;

import java.util.List;

import com.hochschild.insumoQuimico.domain.OpcionApp;

public interface OpcionesAppDAO {
    public List<OpcionApp> getOpcionesApp(String idAplicacion,String opciones);
}
