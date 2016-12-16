package com.hochschild.insumoQuimico.dao;

import java.util.List;

import com.hochschild.insumoQuimico.domain.PresentacionInsumo;

public interface PresentacionInsumoDAO {

	public void insertarPresentacionInsumo(PresentacionInsumo data);
	public void eliminarPresentacionInsumo(String idPresentacionInsumo);
	public void modificarPresentacionInsumo(PresentacionInsumo data);
	public List<PresentacionInsumo> listaPresentacionInsumoPorInsumo(int idInsumo);
	public PresentacionInsumo obtenerPresentacionInsumo(String idPresentacionInsumo);
}
