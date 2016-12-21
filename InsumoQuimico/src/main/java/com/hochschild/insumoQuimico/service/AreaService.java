package com.hochschild.insumoQuimico.service;

import java.util.List;

import com.hochschild.insumoQuimico.domain.Area;
import com.hochschild.insumoQuimico.domain.AreaParametrosEntrada;

public interface AreaService {

	List<Area> listaArea();
	public Area obtieneAreaPorId(String id);
	public void insertarArea(AreaParametrosEntrada data);
	public void eliminarArea(String idArea);
}
