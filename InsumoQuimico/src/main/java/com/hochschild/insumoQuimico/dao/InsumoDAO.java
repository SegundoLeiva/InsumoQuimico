package com.hochschild.insumoQuimico.dao;

import java.util.List;

import com.hochschild.insumoQuimico.domain.Insumo;

public interface InsumoDAO {

	List<Insumo> listaInsumo();
	public Insumo obtieneInsumoPorId(String id);
}
