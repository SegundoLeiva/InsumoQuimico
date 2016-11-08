package com.hochschild.insumoQuimico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hochschild.insumoQuimico.dao.UnidadMineraAreaDAO;
import com.hochschild.insumoQuimico.domain.Area;
import com.hochschild.insumoQuimico.domain.UnidadMineraArea;

import controller.AreaParametrosEntrada;

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

	public void insertarUnidadMineraArea(AreaParametrosEntrada data) {
		// TODO Auto-generated method stub
		UnidadMineraArea unidadMineraArea = new UnidadMineraArea();
		unidadMineraArea.setIdUnidadMineraArea(data.getIdUnidadMinera()+"-"+data.getIdArea());
		unidadMineraArea.setIdUnidadMinera(data.getIdUnidadMinera());
		Area area = new Area();
		area.setIdArea(data.getIdArea());
		unidadMineraArea.setArea(area);
		unidadMineraArea.setVigencia(data.getVigencia());
		unidadMineraAreaDAO.insertarUnidadMineraArea(unidadMineraArea);		
	}

	public void actualizarUnidadMineraArea(AreaParametrosEntrada data) {
		// TODO Auto-generated method stub
		UnidadMineraArea unidadMineraArea = unidadMineraAreaDAO.obtieneUnidadMineraAreaPorId(data.getIdUnidadMineraArea());
		Area area = new Area();
		area.setIdArea(data.getIdArea());
		unidadMineraArea.setArea(area);
		unidadMineraArea.setVigencia(data.getVigencia());
		unidadMineraAreaDAO.actualizarUnidadMineraArea(unidadMineraArea);
	}

	public void eliminarUnidadMineraArea(String idUnidadMineraArea) {
		// TODO Auto-generated method stub
		unidadMineraAreaDAO.eliminarUnidadMineraArea(idUnidadMineraArea);
	}
}
