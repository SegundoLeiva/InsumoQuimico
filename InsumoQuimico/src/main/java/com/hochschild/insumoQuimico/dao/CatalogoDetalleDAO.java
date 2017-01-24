package com.hochschild.insumoQuimico.dao;

import java.util.List;

import com.hochschild.insumoQuimico.domain.CatalogoDetalle;

public interface CatalogoDetalleDAO {

	public void insertarCatalogoDetalle(CatalogoDetalle data);
	List<CatalogoDetalle> listaCatalogoDetalle();
	List<CatalogoDetalle> listaCatalogoDetalleByIdCatalogo(Integer idCatalogo);
	CatalogoDetalle obtenerCatalogoDetalleById(int idCatalogo, String idCatalogoDetalle);
	
}
