package com.hochschild.insumoQuimico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hochschild.insumoQuimico.dao.CatalogoDetalleDAO;
import com.hochschild.insumoQuimico.domain.CatalogoDetalle;

@Service
public class CatalogoDetalleServiceImpl implements CatalogoDetalleService {
    @Autowired
    public CatalogoDetalleDAO catalogoDetalleDAO;

	public void insertarCatalogoDetalle(CatalogoDetalle data) {
		catalogoDetalleDAO.insertarCatalogoDetalle(data);
	}

	public List<CatalogoDetalle> listaCatalogoDetalle() {
		return catalogoDetalleDAO.listaCatalogoDetalle();
	}

	public List<CatalogoDetalle> listaCatalogoDetalleByIdCatalogo(Integer idCatalogo) {
		return catalogoDetalleDAO.listaCatalogoDetalleByIdCatalogo(idCatalogo);
	}



	public CatalogoDetalle obtenerCatalogoDetalleById(int idCatalogo,
			String idCatalogoDetalle) {
		return catalogoDetalleDAO.obtenerCatalogoDetalleById(idCatalogo, idCatalogoDetalle);
	}
	
}

