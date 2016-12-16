package com.hochschild.insumoQuimico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hochschild.insumoQuimico.dao.FactorConversionMedidaDAO;
import com.hochschild.insumoQuimico.domain.FactorConversionMedida;

@Service
public class FactorConversionMedidaServiceImpl implements FactorConversionMedidaService {
    @Autowired
    public FactorConversionMedidaDAO factorConversionMedidaDAO;

	public List<FactorConversionMedida> listaFactorConversionMedida() {
		return factorConversionMedidaDAO.listaFactorConversionMedida();
	}

}
