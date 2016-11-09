package com.hochschild.insumoQuimico.service;

import java.util.List;

import com.hochschild.insumoQuimico.domain.Insumo;

public interface InsumoService {

	List<Insumo> listaInsumo();
	public Insumo obtieneInsumoPorId(String id);
}
