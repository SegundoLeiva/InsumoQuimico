package com.hochschild.insumoQuimico.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hochschild.insumoQuimico.dao.UnidadMineraInsumoSaldoDAO;
import com.hochschild.insumoQuimico.domain.UnidadMineraInsumoSaldoArea;

@Service
public class UnidadMineraInsumoSaldoServiceImpl implements UnidadMineraInsumoSaldoService {
    @Autowired
    public UnidadMineraInsumoSaldoDAO unidadMineraInsumoSaldoDAO;

    public UnidadMineraInsumoSaldoArea obtenerStockPorArea(String idUnidadMineraArea, String idUnidadMineraInsumo,String idPresentacionInsumo){
		return unidadMineraInsumoSaldoDAO.obtenerStockPorArea(idUnidadMineraArea,idUnidadMineraInsumo,idPresentacionInsumo);
	}

}
