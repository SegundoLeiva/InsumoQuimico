package com.hochschild.insumoQuimico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hochschild.insumoQuimico.dao.CatalogoDAO;
import com.hochschild.insumoQuimico.domain.Catalogo;

@Service
public class CatalogoServiceImpl implements CatalogoService {
    @Autowired
    public CatalogoDAO catalogoDAO;

	public List<Catalogo> listaCatalogo() {
		return catalogoDAO.listaCatalogo();
	}
}

