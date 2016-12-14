package com.hochschild.insumoQuimico.service;

import java.util.List;

import com.hochschild.insumoQuimico.domain.Insumo;
import com.hochschild.insumoQuimico.domain.InsumoParametrosEntrada;

public interface InsumoService {

	List<Insumo> listaInsumo();
	public Insumo obtieneInsumoPorId(String id);
	public void insertarInsumo(InsumoParametrosEntrada data);
	public void actualizarInsumo(InsumoParametrosEntrada data);
	public void eliminarInsumo(String idInsumo);
}
