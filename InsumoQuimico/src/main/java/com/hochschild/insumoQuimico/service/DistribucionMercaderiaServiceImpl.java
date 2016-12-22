package com.hochschild.insumoQuimico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hochschild.insumoQuimico.dao.DistribucionMercaderiaDAO;
import com.hochschild.insumoQuimico.domain.DistribucionMercaderia;
import com.hochschild.insumoQuimico.domain.DistribucionMercaderiaConsulta;
import com.hochschild.insumoQuimico.domain.DistribucionMercaderiaConsultaModel;
import com.hochschild.insumoQuimico.domain.DistribucionMercaderiaParametrosEntrada;
import com.hochschild.insumoQuimico.domain.PresentacionInsumo;
import com.hochschild.insumoQuimico.domain.UnidadMineraArea;
import com.hochschild.insumoQuimico.domain.UnidadMineraInsumo;

@Service
public class DistribucionMercaderiaServiceImpl implements DistribucionMercaderiaService {
    @Autowired
    public DistribucionMercaderiaDAO distribucionMercaderiaDAO;

	public DistribucionMercaderia obtieneDistribucionMercaderiaPorId(String id) {
		// TODO Auto-generated method stub
		return distribucionMercaderiaDAO.obtieneDistribucionMercaderiaPorId(id);
	}

	public void actualizarDistribucionMercaderia(DistribucionMercaderia data) {
		// TODO Auto-generated method stub
		distribucionMercaderiaDAO.actualizarDistribucionMercaderia(data);
	}

	public void insertarDistribucionMercaderia(DistribucionMercaderiaParametrosEntrada data) {
		// TODO Auto-generated method stub
		DistribucionMercaderia entity = new DistribucionMercaderia();
		
		UnidadMineraInsumo unidadMineraInsumo = new UnidadMineraInsumo();
		unidadMineraInsumo.setIdUnidadMineraInsumo(data.getIdUnidadMineraInsumo());					
		entity.setUnidadMineraInsumo(unidadMineraInsumo);
		
		PresentacionInsumo presentacionInsumo = new PresentacionInsumo();
		presentacionInsumo.setIdPresentacionInsumo(data.getIdPresentacionInsumo());				
		entity.setPresentacionInsumo(presentacionInsumo);
		
		UnidadMineraArea unidadMineraArea = new UnidadMineraArea();
		unidadMineraArea.setIdUnidadMineraArea(data.getIdUnidadMineraArea());	
		entity.setUnidadMineraArea(unidadMineraArea);
		
		entity.setCantidad(Double.parseDouble(data.getCantidad()));
		
		distribucionMercaderiaDAO.insertarDistribucionMercaderia(entity);
	}

	public void eliminarDistribucionMercaderia(String id) {
		// TODO Auto-generated method stub
		distribucionMercaderiaDAO.eliminarDistribucionMercaderia(id);
	}

	public List<DistribucionMercaderiaConsulta> listaDistribucionMercaderiaConsulta(
			DistribucionMercaderiaConsultaModel model) {
		// TODO Auto-generated method stub
		return distribucionMercaderiaDAO.listaDistribucionMercaderiaConsulta(model);
	}


}
