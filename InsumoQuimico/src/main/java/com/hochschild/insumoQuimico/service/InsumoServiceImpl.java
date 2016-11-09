package com.hochschild.insumoQuimico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hochschild.insumoQuimico.dao.InsumoDAO;
import com.hochschild.insumoQuimico.domain.Insumo;

@Service
public class InsumoServiceImpl implements InsumoService {
    @Autowired
    public InsumoDAO InsumoDAO;

	public List<Insumo> listaInsumo() {
		return InsumoDAO.listaInsumo();
	}
	
    public Insumo obtieneInsumoPorId(String id) {
        return InsumoDAO.obtieneInsumoPorId(id);
    }
}
