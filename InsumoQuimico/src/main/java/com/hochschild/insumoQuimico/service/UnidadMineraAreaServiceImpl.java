package com.hochschild.insumoQuimico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.hochschild.insumoQuimico.dao.UnidadMineraAreaDAO;
import com.hochschild.insumoQuimico.domain.Area;
import com.hochschild.insumoQuimico.domain.UnidadMineraArea;
import com.hochschild.insumoQuimico.domain.UnidadMineraAreaParametrosEntrada;
import com.hochschild.insumoQuimico.util.Constantes;

@Service
public class UnidadMineraAreaServiceImpl implements UnidadMineraAreaService {
    @Autowired
    public UnidadMineraAreaDAO unidadMineraAreaDAO;

	public List<UnidadMineraArea> listaUnidadMineraArea() {
		return unidadMineraAreaDAO.listaUnidadMineraArea();
	}
	
    public UnidadMineraArea obtieneUnidadMineraAreaPorId(String id) {
        return unidadMineraAreaDAO.obtieneUnidadMineraAreaPorId(id);
    }
    
    public List<UnidadMineraArea> listaUnidadMineraAreaPorUnidadMinera(String idUnidadMinera){
    	return unidadMineraAreaDAO.listaUnidadMineraAreaPorUnidadMinera(idUnidadMinera);
    }

	public String insertarUnidadMineraArea(UnidadMineraAreaParametrosEntrada data) {
		String mensaje = Constantes.TRANSACCION_GUARDAR;
		try {
			if(StringUtils.isEmpty(data.getIdUnidadMineraArea())){
				String idUnidadMineraArea = data.getIdUnidadMinera()+"-"+data.getIdArea();
				String existeId = obtieneUnidadMineraAreaPorId(idUnidadMineraArea).getIdUnidadMineraArea();
				if(!StringUtils.isEmpty(existeId)){
					mensaje = "El registro ya existe";
				}else{
					UnidadMineraArea unidadMineraArea = new UnidadMineraArea();
					unidadMineraArea.setIdUnidadMineraArea(idUnidadMineraArea);
					unidadMineraArea.setIdUnidadMinera(data.getIdUnidadMinera());
					Area area = new Area();
					area.setIdArea(new Long(data.getIdArea()));
					unidadMineraArea.setArea(area);
					unidadMineraArea.setVigencia(data.getVigencia());
					unidadMineraAreaDAO.insertarUnidadMineraArea(unidadMineraArea);	
				}
			}else{
				UnidadMineraArea unidadMineraArea = unidadMineraAreaDAO.obtieneUnidadMineraAreaPorId(data.getIdUnidadMineraArea());
				Area area = new Area();
				area.setIdArea(new Long(data.getIdArea()));
				unidadMineraArea.setArea(area);
				unidadMineraArea.setVigencia(data.getVigencia());
				unidadMineraAreaDAO.actualizarUnidadMineraArea(unidadMineraArea);
				mensaje = Constantes.TRANSACCION_MODIFICAR;
			}		
		} catch (Exception e) {
			// TODO: handle exception
			 mensaje = Constantes.TRANSACCION_ERROR;
		}
		
		return mensaje;		
	}

	public void eliminarUnidadMineraArea(String idUnidadMineraArea) {
		// TODO Auto-generated method stub
		unidadMineraAreaDAO.eliminarUnidadMineraArea(idUnidadMineraArea);
	}
	
	public List<UnidadMineraArea> listaUnidadMineraAreaVigentes() {
		return unidadMineraAreaDAO.listaUnidadMineraAreaVigentes();
	}
}
