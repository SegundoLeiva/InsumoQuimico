package com.hochschild.insumoQuimico.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hochschild.insumoQuimico.dao.UnidadMineraInsumoSaldoDAO;
import com.hochschild.insumoQuimico.domain.UnidadMineraInsumoSaldo;

@Service
public class UnidadMineraInsumoSaldoServiceImpl implements UnidadMineraInsumoSaldoService {
    @Autowired
    public UnidadMineraInsumoSaldoDAO unidadMineraInsumoSaldoDAO;

    public UnidadMineraInsumoSaldo obtienerStock(String idUnidadMineraInsumo,String idUnidadMineraAlmacen){
		return unidadMineraInsumoSaldoDAO.obtienerStock(idUnidadMineraInsumo,idUnidadMineraAlmacen);
	}

}
