package com.hochschild.insumoQuimico.dao;

import java.util.List;

import com.hochschild.insumoQuimico.domain.UnidadMineraInsumo;

public interface UnidadMineraInsumoDAO {
	public void insertarUnidadMineraInsumo(UnidadMineraInsumo data);
	public void actualizarUnidadMineraInsumo(UnidadMineraInsumo data);
	public void eliminarUnidadMineraInsumo(String idUnidadMineraInsumo);
	List<UnidadMineraInsumo> listaUnidadMineraInsumo();
	List<UnidadMineraInsumo> listaUnidadMineraInsumoPorUnidadMinera(String idUnidadMinera);
	public UnidadMineraInsumo obtieneUnidadMineraInsumoPorId(String id);
}
