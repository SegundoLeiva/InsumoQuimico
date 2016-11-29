package com.hochschild.insumoQuimico.service;

import java.util.List;

import com.hochschild.insumoQuimico.domain.InsumoParametrosEntrada;
import com.hochschild.insumoQuimico.domain.UnidadMineraInsumo;

public interface UnidadMineraInsumoService {

	List<UnidadMineraInsumo> listaUnidadMineraInsumo();
	public UnidadMineraInsumo obtieneUnidadMineraInsumoPorId(String id);
	public List<UnidadMineraInsumo> listaUnidadMineraInsumoPorUnidadMinera(String idUnidadMinera);
	public void insertarUnidadMineraInsumo(InsumoParametrosEntrada data);
	public void actualizarUnidadMineraInsumo(InsumoParametrosEntrada data);
	public void eliminarUnidadMineraInsumo(String idUnidadMineraInsumo);
}
