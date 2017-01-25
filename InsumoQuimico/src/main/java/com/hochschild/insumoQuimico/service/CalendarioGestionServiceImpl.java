package com.hochschild.insumoQuimico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hochschild.insumoQuimico.dao.CalendarioGestionDAO;
import com.hochschild.insumoQuimico.domain.CalendarioGestion;
import com.hochschild.insumoQuimico.domain.CalendarioGestionModel;

@Service
public class CalendarioGestionServiceImpl implements CalendarioGestionService {
    @Autowired
    public CalendarioGestionDAO calendarioGestionDAO;

	
    public CalendarioGestion obtieneCalendarioGestionPorIdUnidadMinera(String idUnidadMinera) {
        return calendarioGestionDAO.obtieneCalendarioGestionPorIdUnidadMinera(idUnidadMinera);
    }


	public CalendarioGestion obtieneCalendarioGestion(
			CalendarioGestionModel data) {
		// TODO Auto-generated method stub
		return calendarioGestionDAO.obtieneCalendarioGestion(data);
	}


	public void actualizarCalendarioGestion(CalendarioGestion data) {
		// TODO Auto-generated method stub
		calendarioGestionDAO.actualizarCalendarioGestion(data);
	}


	public List<CalendarioGestion> listCalendarioGestionPorAnio(CalendarioGestionModel data) {
		// TODO Auto-generated method stub
		return calendarioGestionDAO.listCalendarioGestionPorAnio(data);
	}
}
