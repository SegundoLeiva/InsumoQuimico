package com.hochschild.insumoQuimico.service;

import java.util.List;

import com.hochschild.insumoQuimico.domain.Almacen;

public interface AlmacenService {

	List<Almacen> listaAlmacen();
	public Almacen obtieneAlmacenPorId(String id);
}
