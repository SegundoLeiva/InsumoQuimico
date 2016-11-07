package com.hochschild.insumoQuimico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hochschild.insumoQuimico.dao.AreaDAO;
import com.hochschild.insumoQuimico.domain.Area;

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
}
