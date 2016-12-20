package com.hochschild.insumoQuimico.dao;

import java.util.List;

import com.hochschild.insumoQuimico.domain.Area;

public interface AreaDAO {

	List<Area> listaArea();
	public Area obtieneAreaPorId(String id);
	public void insertarArea(Area data);
	public void actualizarArea(Area data);
	public void eliminarArea(String idArea);
}
