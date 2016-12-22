package com.hochschild.insumoQuimico.service;

import java.util.List;

import com.hochschild.insumoQuimico.domain.DistribucionMercaderia;
import com.hochschild.insumoQuimico.domain.DistribucionMercaderiaConsulta;
import com.hochschild.insumoQuimico.domain.DistribucionMercaderiaConsultaModel;
import com.hochschild.insumoQuimico.domain.DistribucionMercaderiaParametrosEntrada;

public interface DistribucionMercaderiaService {

	public DistribucionMercaderia obtieneDistribucionMercaderiaPorId(String id);
	public void actualizarDistribucionMercaderia(DistribucionMercaderia data);
	public void insertarDistribucionMercaderia(DistribucionMercaderiaParametrosEntrada data);
	public void eliminarDistribucionMercaderia(String id);
	public List<DistribucionMercaderiaConsulta> listaDistribucionMercaderiaConsulta(DistribucionMercaderiaConsultaModel model);
}
