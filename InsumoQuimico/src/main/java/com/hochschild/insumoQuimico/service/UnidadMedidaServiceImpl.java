package com.hochschild.insumoQuimico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hochschild.insumoQuimico.dao.UnidadMedidaDAO;
import com.hochschild.insumoQuimico.domain.UnidadMedida;

@Service
public class UnidadMedidaServiceImpl implements UnidadMedidaService {
    @Autowired
    public UnidadMedidaDAO unidadMedidaDAO;

	public List<UnidadMedida> listaUnidadMedida() {
		return unidadMedidaDAO.listaUnidadMedida();
	}
	
    public UnidadMedida obtieneUnidadMedidaPorId(String id) {
        return unidadMedidaDAO.obtieneUnidadMedidaPorId(id);
    }
}
