package com.hochschild.insumoQuimico.service;

import java.util.List;

import com.hochschild.insumoQuimico.domain.Area;

public interface AreaService {

	List<Area> listaArea();
	public Area obtieneAreaPorId(String id);
}
