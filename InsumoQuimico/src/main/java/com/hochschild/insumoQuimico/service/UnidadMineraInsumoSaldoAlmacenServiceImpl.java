package com.hochschild.insumoQuimico.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hochschild.insumoQuimico.dao.UnidadMineraInsumoSaldoAlmacenDAO;
import com.hochschild.insumoQuimico.domain.UnidadMineraInsumoSaldoAlmacen;

@Service
public class UnidadMineraInsumoSaldoAlmacenServiceImpl implements UnidadMineraInsumoSaldoAlmacenService {
    @Autowired
    public UnidadMineraInsumoSaldoAlmacenDAO unidadMineraInsumoSaldoAlmacenDAO;

    public UnidadMineraInsumoSaldoAlmacen obtienerStockAlmacen(String idUnidadMineraInsumoPresentacion){
		return unidadMineraInsumoSaldoAlmacenDAO.obtienerStockAlmacen(idUnidadMineraInsumoPresentacion);
	}

}
