package com.hochschild.insumoQuimico.service;

import java.util.List;

import com.hochschild.insumoQuimico.domain.CatalogoDetalle;

public interface CatalogoDetalleService {

	public void insertarCatalogoDetalle(CatalogoDetalle data);
	public List<CatalogoDetalle> listaCatalogoDetalle();
	public List<CatalogoDetalle> listaCatalogoDetalleByIdCatalogo(Integer idCatalogo) ;
	public CatalogoDetalle obtenerCatalogoDetalleById(int idCatalogo,String idCatalogoDetalle);
}
