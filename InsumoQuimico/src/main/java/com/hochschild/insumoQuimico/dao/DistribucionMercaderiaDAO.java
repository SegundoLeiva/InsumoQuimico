package com.hochschild.insumoQuimico.dao;

import java.util.List;

import com.hochschild.insumoQuimico.domain.DistribucionMercaderia;
import com.hochschild.insumoQuimico.domain.DistribucionMercaderiaConsulta;
import com.hochschild.insumoQuimico.domain.DistribucionMercaderiaConsultaModel;

public interface DistribucionMercaderiaDAO {

	public DistribucionMercaderia obtieneDistribucionMercaderiaPorId(String id);
	public void actualizarDistribucionMercaderia(DistribucionMercaderia data);
	public void insertarDistribucionMercaderia(DistribucionMercaderia data);
	public void eliminarDistribucionMercaderia(String id);
	public List<DistribucionMercaderiaConsulta> listaDistribucionMercaderiaConsulta(DistribucionMercaderiaConsultaModel model);
}
