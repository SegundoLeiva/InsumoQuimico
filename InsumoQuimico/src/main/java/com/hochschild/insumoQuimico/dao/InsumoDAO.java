package com.hochschild.insumoQuimico.dao;

import java.util.List;

import com.hochschild.insumoQuimico.domain.Insumo;

public interface InsumoDAO {

	List<Insumo> listaInsumo();
	public Insumo obtieneInsumoPorId(String id);
	public void insertarInsumo(Insumo data);
	public void actualizarInsumo(Insumo data);
	public void eliminarInsumo(String idInsumo);
	public int obtenerId();
}
