package com.hochschild.insumoQuimico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hochschild.insumoQuimico.dao.UnidadMineraAlmacenDAO;
import com.hochschild.insumoQuimico.domain.UnidadMineraAlmacen;

@Service
public class UnidadMineraAlmacenServiceImpl implements UnidadMineraAlmacenService {
    @Autowired
    public UnidadMineraAlmacenDAO unidadMineraAlmacenDAO;

	public List<UnidadMineraAlmacen> listaUnidadMineraAlmacen() {
		return unidadMineraAlmacenDAO.listaUnidadMineraAlmacen();
	}
    
    public List<UnidadMineraAlmacen> listaUnidadMineraAlmacenPorUnidadMinera(String idUnidadMinera){
    	return unidadMineraAlmacenDAO.listaUnidadMineraAlmacenPorUnidadMinera(idUnidadMinera);
    }
}
