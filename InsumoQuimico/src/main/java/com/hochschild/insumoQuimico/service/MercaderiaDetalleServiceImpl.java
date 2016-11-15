package com.hochschild.insumoQuimico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hochschild.insumoQuimico.dao.MercaderiaDetalleDAO;
import com.hochschild.insumoQuimico.domain.MercaderiaDetalle;

@Service
public class MercaderiaDetalleServiceImpl implements MercaderiaDetalleService {

	@Autowired
    public MercaderiaDetalleDAO mercaderiaDetalleDAO;

	public List<MercaderiaDetalle> obtenerMercaderiaDetallePorIdMercaderia(String id) {
		// TODO Auto-generated method stub
		return mercaderiaDetalleDAO.obtenerMercaderiaDetallePorIdMercaderia(id);
	}

}

