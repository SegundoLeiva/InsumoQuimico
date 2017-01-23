package com.hochschild.insumoQuimico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hochschild.insumoQuimico.dao.PresentacionInsumoDAO;
import com.hochschild.insumoQuimico.domain.InsumoPresentacion;

@Service
public class PresentacionInsumoServiceImpl implements PresentacionInsumoService {
    @Autowired
    public PresentacionInsumoDAO presentacionInsumoDAO;

	public List<InsumoPresentacion> listaPresentacionInsumoPorInsumo(int idInsumo) {
		// TODO Auto-generated method stub
		return presentacionInsumoDAO.listaPresentacionInsumoPorInsumo(idInsumo);
	}


}
