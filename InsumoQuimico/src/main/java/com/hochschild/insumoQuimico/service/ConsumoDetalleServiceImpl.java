package com.hochschild.insumoQuimico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hochschild.insumoQuimico.dao.ConsumoDetalleDAO;
import com.hochschild.insumoQuimico.domain.ConsumoDetalle;

@Service
public class ConsumoDetalleServiceImpl implements ConsumoDetalleService {

	@Autowired
    public ConsumoDetalleDAO consumoDetalleDAO;

	public List<ConsumoDetalle> obtenerConsumoDetallePorIdConsumo(String id) {
		// TODO Auto-generated method stub
		return consumoDetalleDAO.obtenerConsumoDetallePorIdConsumo(id);
	}

	public List<ConsumoDetalle> obtenerConsumoDetalleReporte(String idUnidadMinera,String anio, String mes) {
		// TODO Auto-generated method stub
		return consumoDetalleDAO.obtenerConsumoDetalleReporte(idUnidadMinera, anio, mes);
	}

}

