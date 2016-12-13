package com.hochschild.insumoQuimico.service;

import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.hochschild.insumoQuimico.dao.ConsumoDAO;
import com.hochschild.insumoQuimico.dao.ConsumoDetalleDAO;
import com.hochschild.insumoQuimico.domain.Consumo;
import com.hochschild.insumoQuimico.domain.ConsumoConsulta;
import com.hochschild.insumoQuimico.domain.ConsumoConsultaModel;
import com.hochschild.insumoQuimico.domain.ConsumoDetalle;
import com.hochschild.insumoQuimico.domain.ConsumoDetalle.IdConsumo;
import com.hochschild.insumoQuimico.domain.ConsumoParametrosEntrada;
import com.hochschild.insumoQuimico.domain.UnidadMinera;
import com.hochschild.insumoQuimico.domain.UnidadMineraAlmacen;
import com.hochschild.insumoQuimico.domain.UnidadMineraArea;
import com.hochschild.insumoQuimico.domain.UnidadMineraInsumo;
import com.hochschild.insumoQuimico.util.Constantes;

@Service
public class ConsumoServiceImpl implements ConsumoService {

	@Autowired
    public ConsumoDAO ConsumoDAO;
	@Autowired
    public ConsumoDetalleDAO ConsumoDetalleDAO;

	public void actualizarConsumo(Consumo Consumo) {
		ConsumoDAO.actualizarConsumo(Consumo);
	}
	
	public String guardarConsumo(ConsumoParametrosEntrada ConsumoParametrosEntrada) {
		Consumo Consumo = new Consumo();
		ConsumoDetalle ConsumoDetalle = new ConsumoDetalle();
		String idConsumo = ConsumoParametrosEntrada.getIdConsumo();
		try {
			if(StringUtils.isEmpty(idConsumo)){
				idConsumo = ConsumoDAO.obtenerCorrelativoConsumo(ConsumoParametrosEntrada.getIdUnidadMinera());
				insertarConsumo(ConsumoParametrosEntrada,idConsumo);		
			}else{
				Consumo = ConsumoDAO.obtieneConsumoPorId(idConsumo);
				UnidadMinera unidadMinera = new UnidadMinera();
				unidadMinera.setIdUnidadMinera(ConsumoParametrosEntrada.getIdUnidadMinera());
				Consumo.setUnidadMinera(unidadMinera);
							
				UnidadMineraAlmacen unidadMineraAlmacen = new UnidadMineraAlmacen();
				unidadMineraAlmacen.setIdUnidadMineraAlmacen(ConsumoParametrosEntrada.getIdUnidadMineraAlmacen());			
				Consumo.setUnidadMineraAlmacen(unidadMineraAlmacen);
				
				UnidadMineraArea unidadMineraArea = new UnidadMineraArea();
				unidadMineraArea.setIdUnidadMineraArea(ConsumoParametrosEntrada.getIdUnidadMineraArea());	
				Consumo.setUnidadMineraArea(unidadMineraArea);
				
				Consumo.setIdUsuarioModificacion(ConsumoParametrosEntrada.getNombreUsuario());		
				Consumo.setFechaModificacion(new Date());
				
				ConsumoDAO.actualizarConsumo(Consumo);
			}
			
			int index = Integer.parseInt(ConsumoParametrosEntrada.getIndex());
			JSONArray dataJson = ConsumoParametrosEntrada.getConsumoJSONArray();
			for (int i = 0; i < dataJson.length(); i++) {
				JSONObject jsonObj = dataJson.getJSONObject(i);
				String indicador = jsonObj.getString("indicadorBD");
				String idDetalle = jsonObj.getString("idDetalle");
				if(indicador.equals(Constantes.INDICADOR_NUEVO) && StringUtils.isEmpty(idDetalle)){//NUEVO
					IdConsumo id = new IdConsumo();
					id.setIdConsumo(idConsumo);
					id.setIdConsumoDetalle(new Long(index));
					ConsumoDetalle.setId(id);
					
					UnidadMineraInsumo unidadMineraInsumo = new UnidadMineraInsumo();
					unidadMineraInsumo.setIdUnidadMineraInsumo(jsonObj.getString("idUnidadMineraInsumo"));					
					ConsumoDetalle.setUnidadMineraInsumo(unidadMineraInsumo);
					
					ConsumoDetalle.setCantidad(jsonObj.getDouble("cantidad"));
					ConsumoDetalle.setUnidadMedida(jsonObj.getString("unidadMedida"));
					ConsumoDetalle.setIdUsuarioCreacion(ConsumoParametrosEntrada.getNombreUsuario());
					ConsumoDetalle.setFechaCreacion(new Date());
					ConsumoDetalleDAO.insertarConsumoDetalle(ConsumoDetalle);

					index++;
				}else if(indicador.equals(Constantes.INDICADOR_ELIMINADO) && !StringUtils.isEmpty(idDetalle)){//ELIMINA
					ConsumoDetalleDAO.eliminarConsumoDetalle(Integer.parseInt(idDetalle),ConsumoParametrosEntrada.getIdConsumo());

				}else if(indicador.equals(Constantes.INDICADOR_MODIFICADO) && !StringUtils.isEmpty(idDetalle)){//MODIFICA

					ConsumoDetalle = ConsumoDetalleDAO.obtenerConsumoDetalle(ConsumoParametrosEntrada.getIdConsumo(), jsonObj.get("idDetalle").toString());
					
					UnidadMineraInsumo unidadMineraInsumo = new UnidadMineraInsumo();
					unidadMineraInsumo.setIdUnidadMineraInsumo(jsonObj.getString("idUnidadMineraInsumo"));
					ConsumoDetalle.setCantidad(jsonObj.getDouble("cantidad"));
					ConsumoDetalle.setUnidadMedida(jsonObj.getString("unidadMedida"));
					ConsumoDetalle.setUnidadMineraInsumo(unidadMineraInsumo);
					ConsumoDetalle.setIdUsuarioModificacion(ConsumoParametrosEntrada.getNombreUsuario());
					ConsumoDetalle.setFechaModificacion(new Date());				
					ConsumoDetalleDAO.modificarConsumoDetalle(ConsumoDetalle);
					
				}
								
			}
			return idConsumo;
		} catch (Exception e) {
			return "";
		}
		
	}
	
	public void eliminarConsumo(String idConsumo) {
		ConsumoDAO.eliminarConsumo(idConsumo);
	}
	
	public Consumo obtieneConsumoPorId(String id) {
		// TODO Auto-generated method stub
		return ConsumoDAO.obtieneConsumoPorId(id);
	}
	public void insertarConsumo(ConsumoParametrosEntrada data,String idConsumo){				
		Consumo Consumo = new Consumo();
		Consumo.setIdConsumo(idConsumo);

		UnidadMinera unidadMinera = new UnidadMinera();
		unidadMinera.setIdUnidadMinera(data.getIdUnidadMinera());
		Consumo.setUnidadMinera(unidadMinera);
					
		UnidadMineraAlmacen unidadMineraAlmacen = new UnidadMineraAlmacen();
		unidadMineraAlmacen.setIdUnidadMineraAlmacen(data.getIdUnidadMineraAlmacen());		
		Consumo.setUnidadMineraAlmacen(unidadMineraAlmacen);	
		
		UnidadMineraArea unidadMineraArea = new UnidadMineraArea();
		unidadMineraArea.setIdUnidadMineraArea(data.getIdUnidadMineraArea());	
		Consumo.setUnidadMineraArea(unidadMineraArea);

		Consumo.setIdUsuarioCreacion(data.getNombreUsuario());		
		Consumo.setFechaCreacion(new Date());
		ConsumoDAO.insertarConsumo(Consumo);
	}
	public List<ConsumoConsulta> listaConsumoConsulta(ConsumoConsultaModel ConsumoConsultaModel){
		return ConsumoDAO.listaConsumoConsulta(ConsumoConsultaModel);
	}
}

