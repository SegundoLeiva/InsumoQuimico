package com.hochschild.insumoQuimico.service;

import java.util.List;

import com.hochschild.insumoQuimico.domain.UnidadMineraArea;

import controller.AreaParametrosEntrada;

public interface UnidadMineraAreaService {

	List<UnidadMineraArea> listaUnidadMineraArea();
	public UnidadMineraArea obtieneUnidadMineraAreaPorId(String id);
	public List<UnidadMineraArea> listaUnidadMineraAreaPorUnidadMinera(String idUnidadMinera);
	public void insertarUnidadMineraArea(AreaParametrosEntrada data);
	public void actualizarUnidadMineraArea(AreaParametrosEntrada data);
	public void eliminarUnidadMineraArea(String idUnidadMineraArea);
}
