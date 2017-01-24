package com.hochschild.insumoQuimico.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hochschild.insumoQuimico.domain.ConsumoDetalle;
import com.hochschild.insumoQuimico.util.FechasUtil;

@Repository(value="ConsumoDetalleDAO")
public class ConsumoDetalleDAOImpl implements ConsumoDetalleDAO {
    @Autowired
    @Qualifier(value="hibernateTemplateInsumoQuimico")
    private HibernateTemplate hibernateTemplate;

	@Transactional
	public void insertarConsumoDetalle(ConsumoDetalle data){

    	hibernateTemplate.persist(data);
    	
    }

    @Transactional
	public void eliminarConsumoDetalle(int idConsumoDetalle, String idConsumo) {
		// TODO Auto-generated method stub
    	hibernateTemplate.bulkUpdate("DELETE ConsumoDetalle where idConsumoDetalle=? and idConsumo=?", idConsumoDetalle,idConsumo);
   	}
    
	
	public void modificarConsumoDetalle(ConsumoDetalle data){
    	hibernateTemplate.update(data);   	
    }
	
	@SuppressWarnings("unchecked")
	public List<ConsumoDetalle> obtenerConsumoDetallePorIdConsumo(String id){
		 String sql = "from ConsumoDetalle WHERE idConsumo = '"+id+"'";
		 List<ConsumoDetalle> resultado= hibernateTemplate.find(sql);
	      
	     return resultado;
	}
	
	@SuppressWarnings("unchecked")
	public ConsumoDetalle obtenerConsumoDetalle(String idConsumo,String idConsumoDetalle){
		String sql = "from ConsumoDetalle WHERE idConsumo = '"+idConsumo+"' "
				+ "and idConsumoDetalle='"+idConsumoDetalle+"'";
		 List<ConsumoDetalle> resultado= hibernateTemplate.find(sql);
	      
	     return resultado.get(0);
	}
	
	@SuppressWarnings("unchecked")
	public List<ConsumoDetalle> obtenerConsumoDetalleReporte(String idUnidadMinera,String anio,String mes){
		
		String fechaIni = FechasUtil.getPrimerDiaDelMesActualPorAnio(anio, mes,"yyyy-MM-dd");
		String fechaFin = FechasUtil.getUltimoDiaDelMesActualPorAnio(anio, mes,"yyyy-MM-dd");

		String sql = "from ConsumoDetalle WHERE unidadMineraInsumoPresentacion.idUnidadMinera = '"+idUnidadMinera+"' "
		 		+ "and consumo.fechaConsumo Between '"+fechaIni+"' and '"+fechaFin+"'";
		List<ConsumoDetalle> resultado= hibernateTemplate.find(sql);
	      
	    return resultado;
	}

	 
}



