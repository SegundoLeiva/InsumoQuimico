package com.hochschild.insumoQuimico.dao;

import java.util.List;

import com.hochschild.insumoQuimico.domain.UnidadMineraArea;

public interface UnidadMineraAreaDAO {
	public void insertarUnidadMineraArea(UnidadMineraArea data);
	public void actualizarUnidadMineraArea(UnidadMineraArea data);
	public void eliminarUnidadMineraArea(String idUnidadMineraArea);
	List<UnidadMineraArea> listaUnidadMineraArea();
	List<UnidadMineraArea> listaUnidadMineraAreaPorUnidadMinera(String idUnidadMinera);
	public UnidadMineraArea obtieneUnidadMineraAreaPorId(String id);
	public List<UnidadMineraArea> listaUnidadMineraAreaVigentes();
}
