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
import com.hochschild.insumoQuimico.domain.PresentacionInsumo;
import com.hochschild.insumoQuimico.domain.UnidadMinera;
import com.hochschild.insumoQuimico.domain.UnidadMineraArea;
import com.hochschild.insumoQuimico.domain.UnidadMineraInsumo;
import com.hochschild.insumoQuimico.util.Constantes;
import com.hochschild.insumoQuimico.util.FechasUtil;

@Service
public class ConsumoServiceImpl implements ConsumoService {

	@Autowired
    public ConsumoDAO ConsumoDAO;
	@Autowired
    public ConsumoDetalleDAO ConsumoDetalleDAO;

	public void actualizarConsumo(Consumo Consumo) {
		ConsumoDAO.actualizarConsumo(Consumo);
	}
	
	public String guardarConsumo(ConsumoParametrosEntrada consumoParametrosEntrada) {
		Consumo consumo = new Consumo();
		ConsumoDetalle consumoDetalle = new ConsumoDetalle();
		String idConsumo = consumoParametrosEntrada.getIdConsumo();
		try {
			if(StringUtils.isEmpty(idConsumo)){
				idConsumo = ConsumoDAO.obtenerCorrelativoConsumo(consumoParametrosEntrada.getIdUnidadMinera());
				insertarConsumo(consumoParametrosEntrada,idConsumo);		
			}else{
				consumo = ConsumoDAO.obtieneConsumoPorId(idConsumo);
				UnidadMinera unidadMinera = new UnidadMinera();
				unidadMinera.setIdUnidadMinera(consumoParametrosEntrada.getIdUnidadMinera());
				consumo.setUnidadMinera(unidadMinera);
				
				UnidadMineraArea unidadMineraArea = new UnidadMineraArea();
				unidadMineraArea.setIdUnidadMineraArea(consumoParametrosEntrada.getIdUnidadMineraArea());	
				consumo.setUnidadMineraArea(unidadMineraArea);
				
				consumo.setIdUsuarioModificacion(consumoParametrosEntrada.getNombreUsuario());		
				consumo.setFechaModificacion(new Date());
				consumo.setFechaConsumo(FechasUtil.stringToDate(consumoParametrosEntrada.getFechaConsumo(), "dd/mm/yyyy"));
				ConsumoDAO.actualizarConsumo(consumo);
			}
			
			int index = Integer.parseInt(consumoParametrosEntrada.getIndex());
			JSONArray dataJson = consumoParametrosEntrada.getConsumoJSONArray();
			for (int i = 0; i < dataJson.length(); i++) {
				JSONObject jsonObj = dataJson.getJSONObject(i);
				String indicador = jsonObj.getString("indicadorBD");
				String idDetalle = jsonObj.getString("idDetalle");
				String idPresentacionInsumo = jsonObj.getString("idPresentacionInsumo");
				String idUnidadMineraInsumo = jsonObj.getString("idUnidadMineraInsumo");
				if(indicador.equals(Constantes.INDICADOR_NUEVO) && StringUtils.isEmpty(idDetalle)){//NUEVO
					IdConsumo id = new IdConsumo();
					id.setIdConsumo(idConsumo);
					id.setIdConsumoDetalle(new Long(index));
					consumoDetalle.setId(id);
					
					UnidadMineraInsumo unidadMineraInsumo = new UnidadMineraInsumo();
					unidadMineraInsumo.setIdUnidadMineraInsumo(idUnidadMineraInsumo);					
					consumoDetalle.setUnidadMineraInsumo(unidadMineraInsumo);
					
					PresentacionInsumo presentacionInsumo = new PresentacionInsumo();
					presentacionInsumo.setIdPresentacionInsumo(idPresentacionInsumo);				
					consumoDetalle.setPresentacionInsumo(presentacionInsumo);
					consumoDetalle.setIdUnidadMineraArea(consumoParametrosEntrada.getIdUnidadMineraArea());
					consumoDetalle.setCantidad(jsonObj.getDouble("cantidad"));
					consumoDetalle.setUnidadMedida(jsonObj.getString("unidadMedida"));
					consumoDetalle.setIdUsuarioCreacion(consumoParametrosEntrada.getNombreUsuario());
					consumoDetalle.setFechaCreacion(new Date());
					ConsumoDetalleDAO.insertarConsumoDetalle(consumoDetalle);

					index++;
				}else if(indicador.equals(Constantes.INDICADOR_ELIMINADO) && !StringUtils.isEmpty(idDetalle)){//ELIMINA
					ConsumoDetalleDAO.eliminarConsumoDetalle(Integer.parseInt(idDetalle),consumoParametrosEntrada.getIdConsumo());

				}else if(indicador.equals(Constantes.INDICADOR_MODIFICADO) && !StringUtils.isEmpty(idDetalle)){//MODIFICA

					consumoDetalle = ConsumoDetalleDAO.obtenerConsumoDetalle(consumoParametrosEntrada.getIdConsumo(), jsonObj.get("idDetalle").toString());
					UnidadMineraInsumo unidadMineraInsumo = new UnidadMineraInsumo();
					unidadMineraInsumo.setIdUnidadMineraInsumo(idUnidadMineraInsumo);
					consumoDetalle.setCantidad(jsonObj.getDouble("cantidad"));
					consumoDetalle.setUnidadMedida(jsonObj.getString("unidadMedida"));
					consumoDetalle.setUnidadMineraInsumo(unidadMineraInsumo);
					consumoDetalle.setIdUsuarioModificacion(consumoParametrosEntrada.getNombreUsuario());
					consumoDetalle.setFechaModificacion(new Date());	
					
					PresentacionInsumo presentacionInsumo = new PresentacionInsumo();
					presentacionInsumo.setIdPresentacionInsumo(idPresentacionInsumo);				
					consumoDetalle.setPresentacionInsumo(presentacionInsumo);
					
					ConsumoDetalleDAO.modificarConsumoDetalle(consumoDetalle);
					
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
		Consumo consumo = new Consumo();
		consumo.setIdConsumo(idConsumo);

		UnidadMinera unidadMinera = new UnidadMinera();
		unidadMinera.setIdUnidadMinera(data.getIdUnidadMinera());
		consumo.setUnidadMinera(unidadMinera);
		
		UnidadMineraArea unidadMineraArea = new UnidadMineraArea();
		unidadMineraArea.setIdUnidadMineraArea(data.getIdUnidadMineraArea());	
		consumo.setUnidadMineraArea(unidadMineraArea);

		consumo.setIdUsuarioCreacion(data.getNombreUsuario());		
		consumo.setFechaCreacion(new Date());
		consumo.setFechaConsumo(FechasUtil.stringToDate(data.getFechaConsumo(), "dd/mm/yyyy"));
		ConsumoDAO.insertarConsumo(consumo);
	}
	public List<ConsumoConsulta> listaConsumoConsulta(ConsumoConsultaModel consumoConsultaModel){
		return ConsumoDAO.listaConsumoConsulta(consumoConsultaModel);
	}
}

