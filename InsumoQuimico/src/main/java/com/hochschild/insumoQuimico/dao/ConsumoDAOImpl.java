package com.hochschild.insumoQuimico.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hochschild.insumoQuimico.domain.CorrelativoBD;
import com.hochschild.insumoQuimico.domain.Consumo;
import com.hochschild.insumoQuimico.domain.ConsumoConsulta;

@Repository(value="ConsumoDAO")
public class ConsumoDAOImpl implements ConsumoDAO {
    @Autowired
    @Qualifier(value="hibernateTemplateInsumoQuimico")
    private HibernateTemplate hibernateTemplate;
	
    @Transactional
	public void actualizarConsumo(Consumo data){
		hibernateTemplate.update(data);
    }

	public Consumo obtieneConsumoPorId(String id){
        return hibernateTemplate.get(Consumo.class, id);
    }
	
    @Transactional
	public void insertarConsumo(Consumo data){
		hibernateTemplate.persist(data);
    }

    @SuppressWarnings("unchecked")
	public List<ConsumoConsulta> listaConsumoConsulta(ConsumoConsulta ConsumoConsulta,String fechaInicio,String fechaFin){		
        String[] paramNames = {"idUnidadMinera","idConsumo","idUnidadMineraAlmacen","idUnidadMineraArea","fechaInicio","fechaFin","idUsuarioCreacion"};        
        String[] values = {ConsumoConsulta.getIdUnidadMinera(),ConsumoConsulta.getIdConsumo(),
        		ConsumoConsulta.getIdUnidadMineraAlmacen(),ConsumoConsulta.getIdUnidadMineraArea(),
        		fechaInicio,fechaFin, ConsumoConsulta.getIdUsuarioCreacion()};
        List<ConsumoConsulta> listaConsumoConsulta = hibernateTemplate.findByNamedQueryAndNamedParam("listaConsumo",paramNames,values);
        return listaConsumoConsulta;
    }
    
	
	@Transactional
	public void eliminarConsumo(String idConsumo) {
		// TODO Auto-generated method stub
    	
    	//EliminarDetalle
    	hibernateTemplate.bulkUpdate("DELETE ConsumoDetalle where "
    			+ "idConsumo=? ", idConsumo);
    	
    	//EliminarConsumo
    	hibernateTemplate.bulkUpdate("DELETE Consumo where "
    			+ "idConsumo=? ", idConsumo);
	}
	
	@SuppressWarnings("unchecked")
	public String obtenerCorrelativoConsumo(String idUnidadMinera) {
		String namedQuery = "correlativoConsumo";
        String[] nameParams = {"idUnidadMinera"};
        Object[] paramValues = {idUnidadMinera};

        List<CorrelativoBD> idGenerado = hibernateTemplate.findByNamedQueryAndNamedParam(namedQuery,nameParams,paramValues);

        if(idGenerado.isEmpty()){
            return "";
        }else{
            return idGenerado.get(0).getCorrelativo();
        }
	}
}



