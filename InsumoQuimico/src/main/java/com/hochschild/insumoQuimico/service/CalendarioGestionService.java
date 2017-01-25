package com.hochschild.insumoQuimico.service;

import java.util.List;

import com.hochschild.insumoQuimico.domain.CalendarioGestion;
import com.hochschild.insumoQuimico.domain.CalendarioGestionModel;

public interface CalendarioGestionService {

	public CalendarioGestion obtieneCalendarioGestionPorIdUnidadMinera(String idUnidadMinera);
	public CalendarioGestion obtieneCalendarioGestion(CalendarioGestionModel data);
	public void actualizarCalendarioGestion(CalendarioGestion data);
	public List<CalendarioGestion> listCalendarioGestionPorAnio(CalendarioGestionModel data);
}
