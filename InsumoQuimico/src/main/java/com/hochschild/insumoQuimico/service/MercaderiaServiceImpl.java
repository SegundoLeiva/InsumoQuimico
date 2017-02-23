package com.hochschild.insumoQuimico.service;

import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.hochschild.insumoQuimico.dao.MercaderiaDAO;
import com.hochschild.insumoQuimico.dao.MercaderiaDetalleDAO;
import com.hochschild.insumoQuimico.domain.Mercaderia;
import com.hochschild.insumoQuimico.domain.MercaderiaConsulta;
import com.hochschild.insumoQuimico.domain.MercaderiaConsultaModel;
import com.hochschild.insumoQuimico.domain.MercaderiaDetalle;
import com.hochschild.insumoQuimico.domain.MercaderiaDetalle.IdMercaderia;
import com.hochschild.insumoQuimico.domain.MercaderiaParametrosEntrada;
import com.hochschild.insumoQuimico.domain.InsumoPresentacion;
import com.hochschild.insumoQuimico.domain.UnidadMinera;
import com.hochschild.insumoQuimico.domain.UnidadMineraAlmacen;
import com.hochschild.insumoQuimico.domain.UnidadMineraInsumo;
import com.hochschild.insumoQuimico.domain.UnidadMineraInsumoPresentacion;
import com.hochschild.insumoQuimico.util.Constantes;
import com.hochschild.insumoQuimico.util.FechasUtil;

@Service
public class MercaderiaServiceImpl implements MercaderiaService {

	@Autowired
    public MercaderiaDAO mercaderiaDAO;
	@Autowired
    public MercaderiaDetalleDAO mercaderiaDetalleDAO;

	public void actualizarMercaderia(Mercaderia Mercaderia) {
		mercaderiaDAO.actualizarMercaderia(Mercaderia);
	}
	
	public String guardarMercaderia(MercaderiaParametrosEntrada mercaderiaParametrosEntrada) {
		Mercaderia mercaderia = new Mercaderia();
		MercaderiaDetalle mercaderiaDetalle = new MercaderiaDetalle();
		String idMercaderia = mercaderiaParametrosEntrada.getIdMercaderia();
		String idUnidadMinera = mercaderiaParametrosEntrada.getIdUnidadMinera();
		String idUsuarioCreacion = mercaderiaParametrosEntrada.getNombreUsuario();
		try {
			if(StringUtils.isEmpty(idMercaderia)){
				idMercaderia = mercaderiaDAO.obtenerCorrelativoMercaderia(idUnidadMinera);
				insertarMercaderia(mercaderiaParametrosEntrada,idMercaderia);		
			}else{
				mercaderia = mercaderiaDAO.obtieneMercaderiaPorId(idMercaderia);
				UnidadMinera unidadMinera = new UnidadMinera();
				unidadMinera.setIdUnidadMinera(idUnidadMinera);
				mercaderia.setUnidadMinera(unidadMinera);
							
				UnidadMineraAlmacen unidadMineraAlmacen = new UnidadMineraAlmacen();
				unidadMineraAlmacen.setIdUnidadMineraAlmacen(mercaderiaParametrosEntrada.getIdUnidadMineraAlmacen());			
				mercaderia.setUnidadMineraAlmacen(unidadMineraAlmacen);					
				mercaderia.setTransporte(mercaderiaParametrosEntrada.getTransporte());
				mercaderia.setGuiaRemision(mercaderiaParametrosEntrada.getGuiaRemision());
				mercaderia.setGuiaInterna(mercaderiaParametrosEntrada.getGuiaInterna());
				mercaderia.setRucProveedor(mercaderiaParametrosEntrada.getRucProveedor());
				mercaderia.setDescripcionProveedor(mercaderiaParametrosEntrada.getDescripcionProveedor());
				mercaderia.setIdUsuarioModificacion(idUsuarioCreacion);		
				mercaderia.setFechaModificacion(new Date());
				mercaderia.setFechaMercaderia(FechasUtil.stringToDate(mercaderiaParametrosEntrada.getFechaMercaderia(), "dd/MM/yyyy"));
				mercaderiaDAO.actualizarMercaderia(mercaderia);
			}
			
			int index = Integer.parseInt(mercaderiaParametrosEntrada.getIndex());
			JSONArray dataJson = mercaderiaParametrosEntrada.getMercaderiaJSONArray();
			for (int i = 0; i < dataJson.length(); i++) {
				JSONObject jsonObj = dataJson.getJSONObject(i);
				String indicador = jsonObj.getString("indicadorBD");
				String idDetalle = jsonObj.getString("idDetalle");
				if(indicador.equals(Constantes.INDICADOR_NUEVO) && StringUtils.isEmpty(idDetalle)){//NUEVO
					IdMercaderia id = new IdMercaderia();
					id.setIdMercaderia(idMercaderia);
					id.setIdMercaderiaDetalle(new Long(index));
					mercaderiaDetalle.setId(id);
					
					String idUnidadMineraInsumoPresentacion = jsonObj.getString("idUnidadMineraInsumoPresentacion");
					UnidadMineraInsumoPresentacion unidadMineraInsumoPresentacion = new UnidadMineraInsumoPresentacion();
					unidadMineraInsumoPresentacion.setIdUnidadMineraInsumoPresentacion(idUnidadMineraInsumoPresentacion);					
					mercaderiaDetalle.setUnidadMineraInsumoPresentacion(unidadMineraInsumoPresentacion);
					
					mercaderiaDetalle.setCantidad(jsonObj.getDouble("cantidad"));
					mercaderiaDetalle.setIdUsuarioCreacion(idUsuarioCreacion);
					mercaderiaDetalle.setFechaCreacion(new Date());
					mercaderiaDetalleDAO.insertarMercaderiaDetalle(mercaderiaDetalle);
					
					index++;
				}else if(indicador.equals(Constantes.INDICADOR_ELIMINADO) && !StringUtils.isEmpty(idDetalle)){//ELIMINA
					mercaderiaDetalleDAO.eliminarMercaderiaDetalle(mercaderiaParametrosEntrada.getIdMercaderia(),Integer.parseInt(idDetalle));

				}else if(indicador.equals(Constantes.INDICADOR_MODIFICADO) && !StringUtils.isEmpty(idDetalle)){//MODIFICA

					mercaderiaDetalle = mercaderiaDetalleDAO.obtenerMercaderiaDetalle(mercaderiaParametrosEntrada.getIdMercaderia(), jsonObj.get("idDetalle").toString());					
					mercaderiaDetalle.setCantidad(jsonObj.getDouble("cantidad"));
					
					String idUnidadMineraInsumoPresentacion = jsonObj.getString("idUnidadMineraInsumoPresentacion");
					UnidadMineraInsumoPresentacion unidadMineraInsumoPresentacion = new UnidadMineraInsumoPresentacion();
					unidadMineraInsumoPresentacion.setIdUnidadMineraInsumoPresentacion(idUnidadMineraInsumoPresentacion);					
					mercaderiaDetalle.setUnidadMineraInsumoPresentacion(unidadMineraInsumoPresentacion);
					
					mercaderiaDetalle.setIdUsuarioModificacion(mercaderiaParametrosEntrada.getNombreUsuario());
					mercaderiaDetalle.setFechaModificacion(new Date());		
					
					mercaderiaDetalleDAO.modificarMercaderiaDetalle(mercaderiaDetalle);
				}
								
			}
			return idMercaderia;
		} catch (Exception e) {
			return "";
		}
		
	}
	
	public void eliminarMercaderia(String idMercaderia) {
		mercaderiaDAO.eliminarMercaderia(idMercaderia);
	}
	
	public Mercaderia obtieneMercaderiaPorId(String id) {
		// TODO Auto-generated method stub
		return mercaderiaDAO.obtieneMercaderiaPorId(id);
	}
	public void insertarMercaderia(MercaderiaParametrosEntrada data,String idMercaderia){				
		Mercaderia mercaderia = new Mercaderia();
		mercaderia.setIdMercaderia(idMercaderia);

		UnidadMinera unidadMinera = new UnidadMinera();
		unidadMinera.setIdUnidadMinera(data.getIdUnidadMinera());
		mercaderia.setUnidadMinera(unidadMinera);
					
		UnidadMineraAlmacen unidadMineraAlmacen = new UnidadMineraAlmacen();
		unidadMineraAlmacen.setIdUnidadMineraAlmacen(data.getIdUnidadMineraAlmacen());
		
		mercaderia.setUnidadMineraAlmacen(unidadMineraAlmacen);			
		mercaderia.setTransporte(data.getTransporte());
		mercaderia.setGuiaRemision(data.getGuiaRemision());
		mercaderia.setGuiaInterna(data.getGuiaInterna());
		mercaderia.setRucProveedor(data.getRucProveedor());
		mercaderia.setDescripcionProveedor(data.getDescripcionProveedor());
		mercaderia.setIdUsuarioCreacion(data.getNombreUsuario());	
		mercaderia.setFechaMercaderia(FechasUtil.stringToDate(data.getFechaMercaderia(), "dd/MM/yyyy"));
		mercaderia.setFechaCreacion(new Date());
		mercaderiaDAO.insertarMercaderia(mercaderia);
	}
	public List<MercaderiaConsulta> listaMercaderiaConsulta(MercaderiaConsultaModel mercaderiaConsultaEntrada){
		return mercaderiaDAO.listaMercaderiaConsulta(mercaderiaConsultaEntrada);
	}
}

