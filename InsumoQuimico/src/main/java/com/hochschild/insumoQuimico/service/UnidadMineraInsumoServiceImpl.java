package com.hochschild.insumoQuimico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.hochschild.insumoQuimico.dao.UnidadMineraInsumoDAO;
import com.hochschild.insumoQuimico.domain.Insumo;
import com.hochschild.insumoQuimico.domain.UnidadMineraInsumo;
import com.hochschild.insumoQuimico.domain.UnidadMineraInsumoParametrosEntrada;
import com.hochschild.insumoQuimico.util.Constantes;

@Service
public class UnidadMineraInsumoServiceImpl implements UnidadMineraInsumoService {
    @Autowired
    public UnidadMineraInsumoDAO unidadMineraInsumoDAO;

	public List<UnidadMineraInsumo> listaUnidadMineraInsumo() {
		return unidadMineraInsumoDAO.listaUnidadMineraInsumo();
	}
	
    public UnidadMineraInsumo obtieneUnidadMineraInsumoPorId(String id) {
        return unidadMineraInsumoDAO.obtieneUnidadMineraInsumoPorId(id);
    }
    
    public List<UnidadMineraInsumo> listaUnidadMineraInsumoPorUnidadMinera(String idUnidadMinera){
    	return unidadMineraInsumoDAO.listaUnidadMineraInsumoPorUnidadMinera(idUnidadMinera);
    }

	public String insertarUnidadMineraInsumo(UnidadMineraInsumoParametrosEntrada data) {
		String mensaje = Constantes.TRANSACCION_GUARDAR;
		try {
			
			if(StringUtils.isEmpty(data.getIdUnidadMineraInsumo())){
				String idUnidadMineraInsumo = data.getIdUnidadMinera()+"-"+data.getIdInsumo();
				String existeId = obtieneUnidadMineraInsumoPorId(idUnidadMineraInsumo).getIdUnidadMineraInsumo();
				if(!StringUtils.isEmpty(existeId)){
					mensaje = "El registro ya existe";
				}else{
					UnidadMineraInsumo unidadMineraInsumo = new UnidadMineraInsumo();
					unidadMineraInsumo.setIdUnidadMineraInsumo(idUnidadMineraInsumo);
					unidadMineraInsumo.setIdUnidadMinera(data.getIdUnidadMinera());
					Insumo Insumo = new Insumo();
					Insumo.setIdInsumo(data.getIdInsumo());
					unidadMineraInsumo.setInsumo(Insumo);
					unidadMineraInsumo.setVigencia(data.getVigencia());
					unidadMineraInsumoDAO.insertarUnidadMineraInsumo(unidadMineraInsumo);		
				}
			}else{
				UnidadMineraInsumo unidadMineraInsumo = unidadMineraInsumoDAO.obtieneUnidadMineraInsumoPorId(data.getIdUnidadMineraInsumo());
				Insumo Insumo = new Insumo();
				Insumo.setIdInsumo(data.getIdInsumo());
				unidadMineraInsumo.setInsumo(Insumo);
				unidadMineraInsumo.setVigencia(data.getVigencia());
				unidadMineraInsumoDAO.actualizarUnidadMineraInsumo(unidadMineraInsumo);
				mensaje = Constantes.TRANSACCION_MODIFICAR;
			}
		} catch (Exception e) {
			mensaje = Constantes.TRANSACCION_ERROR;
		}		
		return mensaje;
		// TODO Auto-generated method stub
			
	}

	public void eliminarUnidadMineraInsumo(String idUnidadMineraInsumo) {
		// TODO Auto-generated method stub
		unidadMineraInsumoDAO.eliminarUnidadMineraInsumo(idUnidadMineraInsumo);
	}
}
