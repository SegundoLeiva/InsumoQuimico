package com.hochschild.insumoQuimico.dao;

import java.util.List;

import com.hochschild.insumoQuimico.domain.UnidadMinera;

public interface UnidadMineraDao {

	List<UnidadMinera> getListaVigentesPorIds(List<String> idUnidadesMineras);

}
