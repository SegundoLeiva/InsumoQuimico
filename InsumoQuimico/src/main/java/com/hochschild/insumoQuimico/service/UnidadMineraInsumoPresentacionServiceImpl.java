package com.hochschild.insumoQuimico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hochschild.insumoQuimico.dao.UnidadMineraInsumoPresentacionDAO;
import com.hochschild.insumoQuimico.domain.UnidadMineraInsumoPresentacion;
import com.hochschild.insumoQuimico.domain.ValorOrganizacionalSesion;

@Service
public class UnidadMineraInsumoPresentacionServiceImpl implements UnidadMineraInsumoPresentacionService {

	 @Autowired
	 public UnidadMineraInsumoPresentacionDAO unidadMineraInsumoPresentacionDAO; 
	 
	public List<UnidadMineraInsumoPresentacion> listaUnidadMineraInsumoPresentacion() {
		// TODO Auto-generated method stub
		return unidadMineraInsumoPresentacionDAO.listaUnidadMineraInsumoPresentacion();
	}

	public List<UnidadMineraInsumoPresentacion> listaUnidadMineraInsumoPresentacionPorUnidadMinera(List<ValorOrganizacionalSesion> unidadesMineras) {
		// TODO Auto-generated method stub
		return unidadMineraInsumoPresentacionDAO.listaUnidadMineraInsumoPresentacionPorUnidadMinera(unidadesMineras);
	}

	public List<UnidadMineraInsumoPresentacion> listaUnidadMineraInsumoPresentacionPorUnidadMinera(String idUnidadMinera) {
		// TODO Auto-generated method stub
		return unidadMineraInsumoPresentacionDAO.listaUnidadMineraInsumoPresentacionPorUnidadMinera(idUnidadMinera);
	}
	
	public UnidadMineraInsumoPresentacion obtieneUnidadMineraInsumoPresentacionPorId(
			String id) {
		// TODO Auto-generated method stub
		return unidadMineraInsumoPresentacionDAO.obtieneUnidadMineraInsumoPresentacionPorId(id);
	}
    
}
