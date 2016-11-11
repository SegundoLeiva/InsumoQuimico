package com.hochschild.insumoQuimico.dao;

import java.util.List;

import com.hochschild.insumoQuimico.domain.Almacen;

public interface AlmacenDAO {

	List<Almacen> listaAlmacen();
	public Almacen obtieneAlmacenPorId(String id);
}
