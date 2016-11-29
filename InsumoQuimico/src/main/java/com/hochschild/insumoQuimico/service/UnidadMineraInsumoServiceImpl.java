package com.hochschild.insumoQuimico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hochschild.insumoQuimico.dao.UnidadMineraInsumoDAO;
import com.hochschild.insumoQuimico.domain.Insumo;
import com.hochschild.insumoQuimico.domain.InsumoParametrosEntrada;
import com.hochschild.insumoQuimico.domain.UnidadMineraInsumo;

@Service
public class UnidadMineraInsumoServiceImpl implements UnidadMineraInsumoService {
    @Autowired
    public UnidadMineraInsumoDAO unidadMineraInsumoDAO;

	public List<UnidadMineraInsumo> listaUnidadMineraInsumo() {
		return unidadMineraInsumoDAO.listaUnidadMineraInsumo();
	}
	
    public UnidadMineraInsumo obtieneUnidadMineraInsumoPorId(String id) {
        return unidadMineraInsumoDAO.obtieneUnidadMineraInsumoPorId(id);
    }
    
    public List<UnidadMineraInsumo> listaUnidadMineraInsumoPorUnidadMinera(String idUnidadMinera){
    	return unidadMineraInsumoDAO.listaUnidadMineraInsumoPorUnidadMinera(idUnidadMinera);
    }

	public void insertarUnidadMineraInsumo(InsumoParametrosEntrada data) {
		// TODO Auto-generated method stub
		UnidadMineraInsumo unidadMineraInsumo = new UnidadMineraInsumo();
		unidadMineraInsumo.setIdUnidadMineraInsumo(data.getIdUnidadMinera()+"-"+data.getIdInsumo());
		unidadMineraInsumo.setIdUnidadMinera(data.getIdUnidadMinera());
		Insumo Insumo = new Insumo();
		Insumo.setIdInsumo(data.getIdInsumo());
		unidadMineraInsumo.setInsumo(Insumo);
		unidadMineraInsumo.setVigencia(data.getVigencia());
		unidadMineraInsumoDAO.insertarUnidadMineraInsumo(unidadMineraInsumo);		
	}

	public void actualizarUnidadMineraInsumo(InsumoParametrosEntrada data) {
		// TODO Auto-generated method stub
		UnidadMineraInsumo unidadMineraInsumo = unidadMineraInsumoDAO.obtieneUnidadMineraInsumoPorId(data.getIdUnidadMineraInsumo());
		Insumo Insumo = new Insumo();
		Insumo.setIdInsumo(data.getIdInsumo());
		unidadMineraInsumo.setInsumo(Insumo);
		unidadMineraInsumo.setVigencia(data.getVigencia());
		unidadMineraInsumoDAO.actualizarUnidadMineraInsumo(unidadMineraInsumo);
	}

	public void eliminarUnidadMineraInsumo(String idUnidadMineraInsumo) {
		// TODO Auto-generated method stub
		unidadMineraInsumoDAO.eliminarUnidadMineraInsumo(idUnidadMineraInsumo);
	}
}
