package com.hochschild.insumoQuimico.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.hochschild.insumoQuimico.controller.MercaderiaParametrosEntrada;
import com.hochschild.insumoQuimico.dao.MercaderiaDAO;
import com.hochschild.insumoQuimico.domain.Mercaderia;
import com.hochschild.insumoQuimico.domain.UnidadMinera;
import com.hochschild.insumoQuimico.domain.UnidadMineraAlmacen;

@Service
public class MercaderiaServiceImpl implements MercaderiaService {

	@Autowired
    public MercaderiaDAO mercaderiaDAO;

	public void actualizarMercaderia(Mercaderia Mercaderia) {
		mercaderiaDAO.actualizarMercaderia(Mercaderia);
	}
	
	public String guardarMercaderia(MercaderiaParametrosEntrada data) {
		Mercaderia mercaderia = new Mercaderia();
		String idMercaderia = data.getIdMercaderia();
		if(StringUtils.isEmpty(idMercaderia)){
			idMercaderia = mercaderiaDAO.obtenerCorrelativoMercaderia(data.getIdUnidadMinera());				
			mercaderia = new Mercaderia();
			mercaderia.setIdMercaderia(idMercaderia);

			UnidadMinera unidadMinera = new UnidadMinera();
			unidadMinera.setIdUnidadMinera(data.getIdUnidadMinera());
			mercaderia.setUnidadMinera(unidadMinera);
						
			UnidadMineraAlmacen unidadMineraAlmacen = new UnidadMineraAlmacen();
			unidadMineraAlmacen.setIdUnidadMineraAlmacen(data.getIdUnidadMineraAlmacen());
			
			mercaderia.setUnidadMineraAlmacen(unidadMineraAlmacen);			
			mercaderia.setTransporte(data.getTransporte());
			mercaderia.setGuiaRemision(data.getGuiaRemision());
			mercaderia.setComprobanteVenta(data.getComprobanteVenta());
			mercaderia.setGuiaInterna(data.getGuiaInterna());
			mercaderia.setIdUsuarioCreacion(data.getNombreUsuario());		
			mercaderia.setFechaCreacion(new Date());
			mercaderiaDAO.insertarMercaderia(mercaderia);
		}
		return idMercaderia;
	}
	
	public void eliminarMercaderia(String idMercaderia) {
		mercaderiaDAO.eliminarMercaderia(idMercaderia);
	}

	public List<Mercaderia> listaMercaderia() {
		return mercaderiaDAO.listaMercaderia();
	}
	
	public Mercaderia obtieneMercaderiaPorId(String id) {
		// TODO Auto-generated method stub
		return mercaderiaDAO.obtieneMercaderiaPorId(id);
	}
}

