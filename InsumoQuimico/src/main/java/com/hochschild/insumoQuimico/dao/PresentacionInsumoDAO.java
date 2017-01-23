package com.hochschild.insumoQuimico.dao;

import java.util.List;

import com.hochschild.insumoQuimico.domain.InsumoPresentacion;

public interface PresentacionInsumoDAO {

	public void insertarPresentacionInsumo(InsumoPresentacion data);
	public void eliminarPresentacionInsumo(String idPresentacionInsumo);
	public void modificarPresentacionInsumo(InsumoPresentacion data);
	public List<InsumoPresentacion> listaPresentacionInsumoPorInsumo(int idInsumo);
	public InsumoPresentacion obtenerPresentacionInsumo(String idPresentacionInsumo);
}
