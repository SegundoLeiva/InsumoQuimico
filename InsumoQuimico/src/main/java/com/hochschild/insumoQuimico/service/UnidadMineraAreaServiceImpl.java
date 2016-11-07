package com.hochschild.insumoQuimico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hochschild.insumoQuimico.dao.UnidadMineraAreaDAO;
import com.hochschild.insumoQuimico.domain.UnidadMineraArea;

@Service
public class UnidadMineraAreaServiceImpl implements UnidadMineraAreaService {
    @Autowired
    public UnidadMineraAreaDAO unidadMineraAreaDAO;

	public List<UnidadMineraArea> listaUnidadMineraArea() {
		return unidadMineraAreaDAO.listaUnidadMineraArea();
	}
	
    public UnidadMineraArea obtieneUnidadMineraAreaPorId(String id) {
        return unidadMineraAreaDAO.obtieneUnidadMineraAreaPorId(id);
    }
    
    public List<UnidadMineraArea> listaUnidadMineraAreaPorUnidadMinera(String idUnidadMinera){
    	return unidadMineraAreaDAO.listaUnidadMineraAreaPorUnidadMinera(idUnidadMinera);
    }
}
