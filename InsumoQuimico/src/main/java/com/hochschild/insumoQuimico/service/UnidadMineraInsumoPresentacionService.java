package com.hochschild.insumoQuimico.service;

import java.util.List;

import com.hochschild.insumoQuimico.domain.UnidadMineraInsumoPresentacion;
import com.hochschild.insumoQuimico.domain.ValorOrganizacionalSesion;

public interface UnidadMineraInsumoPresentacionService {

	List<UnidadMineraInsumoPresentacion> listaUnidadMineraInsumoPresentacion();
	List<UnidadMineraInsumoPresentacion> listaUnidadMineraInsumoPresentacionPorUnidadMinera(List<ValorOrganizacionalSesion> unidadesMineras);
	List<UnidadMineraInsumoPresentacion> listaUnidadMineraInsumoPresentacionPorUnidadMinera(String idUnidadMinera);
	public UnidadMineraInsumoPresentacion obtieneUnidadMineraInsumoPresentacionPorId(String id);
}
