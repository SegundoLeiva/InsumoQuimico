package com.hochschild.insumoQuimico.service;

import java.util.List;

import com.hochschild.insumoQuimico.domain.UnidadMineraInsumoParametrosEntrada;
import com.hochschild.insumoQuimico.domain.UnidadMineraInsumo;

public interface UnidadMineraInsumoService {

	List<UnidadMineraInsumo> listaUnidadMineraInsumo();
	public UnidadMineraInsumo obtieneUnidadMineraInsumoPorId(String id);
	public List<UnidadMineraInsumo> listaUnidadMineraInsumoPorUnidadMinera(String idUnidadMinera);
	public String insertarUnidadMineraInsumo(UnidadMineraInsumoParametrosEntrada data);
	public void eliminarUnidadMineraInsumo(String idUnidadMineraInsumo);
}
