package com.hochschild.insumoQuimico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hochschild.insumoQuimico.dao.InsumoDAO;
import com.hochschild.insumoQuimico.domain.Area;
import com.hochschild.insumoQuimico.domain.Insumo;
import com.hochschild.insumoQuimico.domain.InsumoParametrosEntrada;

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

	public void insertarInsumo(InsumoParametrosEntrada data) {
		// TODO Auto-generated method stub
		Insumo insumo = new Insumo();
		insumo.setIdInsumo(String.valueOf(InsumoDAO.obtenerId()));
		insumo.setInsumo(data.getInsumo());
		insumo.setUnidadMedida("Kg");
		insumo.setVigencia(data.getVigencia());
		InsumoDAO.insertarInsumo(insumo);
	}

	public void actualizarInsumo(InsumoParametrosEntrada data) {
		// TODO Auto-generated method stub
		Insumo insumo = InsumoDAO.obtieneInsumoPorId(data.getIdInsumo());
		insumo.setInsumo(data.getInsumo());
		insumo.setVigencia(data.getVigencia());
		InsumoDAO.actualizarInsumo(insumo);
		
	}

	public void eliminarInsumo(String idInsumo) {
		// TODO Auto-generated method stub
		InsumoDAO.eliminarInsumo(idInsumo);
	}
}
