package com.hochschild.insumoQuimico.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hochschild.insumoQuimico.dao.CalendarioGestionDAO;
import com.hochschild.insumoQuimico.domain.CalendarioGestion;

@Service
public class CalendarioGestionServiceImpl implements CalendarioGestionService {
    @Autowired
    public CalendarioGestionDAO calendarioGestionDAO;

	
    public CalendarioGestion obtieneCalendarioGestionPorIdUnidadMinera(String idUnidadMinera) {
        return calendarioGestionDAO.obtieneCalendarioGestionPorIdUnidadMinera(idUnidadMinera);
    }
}
