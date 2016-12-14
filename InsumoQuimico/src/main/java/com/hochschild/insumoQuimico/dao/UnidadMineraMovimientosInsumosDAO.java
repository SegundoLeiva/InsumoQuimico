package com.hochschild.insumoQuimico.dao;

import com.hochschild.insumoQuimico.domain.UnidadMineraMovimientosInsumos;

public interface UnidadMineraMovimientosInsumosDAO {

	public UnidadMineraMovimientosInsumos obtienerUnidadMineraMovimientosInsumos(UnidadMineraMovimientosInsumos data);
	public void actualizarUnidadMineraMovimientosInsumos(UnidadMineraMovimientosInsumos data);
	public void insertarUnidadMineraMovimientosInsumos(UnidadMineraMovimientosInsumos data);
	public void eliminarUnidadMineraMovimientosInsumos(UnidadMineraMovimientosInsumos data);	
}
