package com.hochschild.insumoQuimico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.hochschild.insumoQuimico.dao.AreaDAO;
import com.hochschild.insumoQuimico.domain.Area;
import com.hochschild.insumoQuimico.domain.AreaParametrosEntrada;
import com.hochschild.insumoQuimico.util.Constantes;

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
			
			if(StringUtils.isEmpty(data.getIdArea())){
				Area area = new Area();
				area.setArea(data.getArea());
				area.setVigencia(data.getVigencia());
				areaDAO.insertarArea(area);
			}else{
				Area area = areaDAO.obtieneAreaPorId(data.getIdArea());
				area.setArea(data.getArea());
				area.setVigencia(data.getVigencia());
				areaDAO.actualizarArea(area);
			}

	}

	public void eliminarArea(String idArea) {
		// TODO Auto-generated method stub
		areaDAO.eliminarArea(idArea);
	}
}
