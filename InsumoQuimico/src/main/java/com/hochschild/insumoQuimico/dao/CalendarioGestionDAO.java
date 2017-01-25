package com.hochschild.insumoQuimico.dao;

import java.util.List;

import com.hochschild.insumoQuimico.domain.CalendarioGestion;
import com.hochschild.insumoQuimico.domain.CalendarioGestionModel;

public interface CalendarioGestionDAO {

	public CalendarioGestion obtieneCalendarioGestionPorIdUnidadMinera(String idUnidadMinera);
	public CalendarioGestion obtieneCalendarioGestion(CalendarioGestionModel data);
	public void actualizarCalendarioGestion(CalendarioGestion data);
	public List<CalendarioGestion> listCalendarioGestionPorAnio(CalendarioGestionModel data);
}
