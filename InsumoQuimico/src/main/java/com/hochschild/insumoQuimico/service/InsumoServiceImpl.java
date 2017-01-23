package com.hochschild.insumoQuimico.service;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.hochschild.insumoQuimico.dao.InsumoDAO;
import com.hochschild.insumoQuimico.dao.PresentacionInsumoDAO;
import com.hochschild.insumoQuimico.domain.Insumo;
import com.hochschild.insumoQuimico.domain.InsumoParametrosEntrada;
import com.hochschild.insumoQuimico.domain.InsumoPresentacion;
import com.hochschild.insumoQuimico.util.Constantes;

@Service
public class InsumoServiceImpl implements InsumoService {
    @Autowired
    public InsumoDAO InsumoDAO;
    
    @Autowired
    public PresentacionInsumoDAO presentacionInsumoDAO;

	public List<Insumo> listaInsumo() {
		return InsumoDAO.listaInsumo();
	}
	
    public Insumo obtieneInsumoPorId(String id) {
        return InsumoDAO.obtieneInsumoPorId(id);
    }

	public void insertarInsumo(InsumoParametrosEntrada insumoParametrosEntrada) throws JSONException {
		// TODO Auto-generated method stub
		Insumo insumo = new Insumo();
		InsumoPresentacion presentacionInsumo = new InsumoPresentacion();
		int idInsumo;
		
		if(StringUtils.isEmpty(insumoParametrosEntrada.getIdInsumo())){
			insumo = new Insumo();
			idInsumo = InsumoDAO.obtenerId();
			insumo.setIdInsumo(String.valueOf(idInsumo));
			insumo.setInsumo(insumoParametrosEntrada.getInsumo());
			insumo.setVigencia(insumoParametrosEntrada.getVigencia());
			InsumoDAO.insertarInsumo(insumo);
		}else{
			insumo = InsumoDAO.obtieneInsumoPorId(insumoParametrosEntrada.getIdInsumo());
			idInsumo = Integer.parseInt(insumo.getIdInsumo());
			insumo.setInsumo(insumoParametrosEntrada.getInsumo());
			insumo.setVigencia(insumoParametrosEntrada.getVigencia());
			InsumoDAO.actualizarInsumo(insumo);
		}
		
		
		int index = Integer.parseInt(insumoParametrosEntrada.getIndex());
		JSONArray dataJson = insumoParametrosEntrada.getInsumoJSONArray();
		for (int i = 0; i < dataJson.length(); i++) {
			JSONObject jsonObj = dataJson.getJSONObject(i);
			String indicador = jsonObj.getString("indicadorBD");
			String idPresentacionInsumo= jsonObj.getString("idDetalle");
			if(indicador.equals(Constantes.INDICADOR_NUEVO) && StringUtils.isEmpty(idPresentacionInsumo)){//NUEVO
				presentacionInsumo = new InsumoPresentacion();
				presentacionInsumo.setIdPresentacionInsumo(idInsumo+"-"+String.valueOf(index));
				
				insumo = new Insumo();
				insumo.setIdInsumo(String.valueOf(idInsumo));
				presentacionInsumo.setInsumo(insumo);
				presentacionInsumo.setIdPresentacion(new Long(index));
				presentacionInsumo.setDescripcion(jsonObj.getString("descripcion"));
				presentacionInsumo.setValor(jsonObj.getDouble("valor"));
				presentacionInsumo.setPesoBruto(jsonObj.getDouble("pesoBruto"));
				presentacionInsumo.setPesoNeto(jsonObj.getDouble("pesoNeto"));
				presentacionInsumo.setVigencia(jsonObj.getString("vigenciaInsumo"));
				presentacionInsumo.setIdUnidadMedidaPresentacion(jsonObj.getString("unidadMedida"));
				presentacionInsumo.setIdUnidadMedidaConversion("KG");
				presentacionInsumoDAO.insertarPresentacionInsumo(presentacionInsumo);
				
				index++;
			}else if(indicador.equals(Constantes.INDICADOR_ELIMINADO) && !StringUtils.isEmpty(idPresentacionInsumo)){//ELIMINA
				presentacionInsumoDAO.eliminarPresentacionInsumo(idPresentacionInsumo);

			}else if(indicador.equals(Constantes.INDICADOR_MODIFICADO) && !StringUtils.isEmpty(idPresentacionInsumo)){//MODIFICA

				presentacionInsumo = presentacionInsumoDAO.obtenerPresentacionInsumo(idPresentacionInsumo);

				presentacionInsumo.setDescripcion(jsonObj.getString("descripcion"));
				presentacionInsumo.setValor(jsonObj.getDouble("valor"));
				presentacionInsumo.setPesoBruto(jsonObj.getDouble("pesoBruto"));
				presentacionInsumo.setPesoNeto(jsonObj.getDouble("pesoNeto"));
				presentacionInsumo.setVigencia(jsonObj.getString("vigenciaInsumo"));
				presentacionInsumo.setIdUnidadMedidaPresentacion(jsonObj.getString("unidadMedida"));
				presentacionInsumoDAO.modificarPresentacionInsumo(presentacionInsumo);

			}
							
		}
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
