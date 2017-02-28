package com.hochschild.insumoQuimico.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hochschild.insumoQuimico.dao.EstablecimientosDAO;
import com.hochschild.insumoQuimico.domain.Establecimientos;

@Service
public class EstablecimientosServiceImpl implements EstablecimientosService {
    @Autowired
    public EstablecimientosDAO establecimientosDAO;

	public Establecimientos obtieneEstablecimientosPorIdUnidadMinera(
			String idUnidadMinera) {
		// TODO Auto-generated method stub
		return establecimientosDAO.obtieneEstablecimientosPorIdUnidadMinera(idUnidadMinera);
	}


}

