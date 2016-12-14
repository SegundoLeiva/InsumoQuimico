package com.hochschild.insumoQuimico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hochschild.insumoQuimico.dao.AreaDAO;
import com.hochschild.insumoQuimico.domain.Area;
import com.hochschild.insumoQuimico.domain.AreaParametrosEntrada;

@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    public AreaDAO areaDAO;

	public List<Area> listaArea() {
		return areaDAO.listaArea();
	}
	
    public Area obtieneAreaPorId(String id) {
        return areaDAO.obtieneAreaPorId(id);
    }

	public void insertarArea(AreaParametrosEntrada data) {
		// TODO Auto-generated method stub
		Area area = new Area();
		area.setIdArea(String.valueOf(areaDAO.obtenerId()));
		area.setArea(data.getArea());
		area.setVigencia(data.getVigencia());
		areaDAO.insertarArea(area);
		
	}

	public void actualizarArea(AreaParametrosEntrada data) {
		// TODO Auto-generated method stub
		Area area = areaDAO.obtieneAreaPorId(data.getIdArea());
		area.setIdArea(data.getIdArea());
		area.setArea(data.getArea());
		areaDAO.actualizarArea(area);
		
	}

	public void eliminarArea(String idArea) {
		// TODO Auto-generated method stub
		areaDAO.eliminarArea(idArea);
	}
}
