package com.hochschild.insumoQuimico.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.hochschild.insumoQuimico.domain.DistribucionMercaderia;
import com.hochschild.insumoQuimico.domain.DistribucionMercaderiaConsulta;
import com.hochschild.insumoQuimico.domain.DistribucionMercaderiaConsultaModel;

@Repository(value="DistribucionMercaderiaDAO")
public class DistribucionMercaderiaDAOImpl implements DistribucionMercaderiaDAO {
    @Autowired
    @Qualifier(value="hibernateTemplateInsumoQuimico")
    private HibernateTemplate hibernateTemplate;
	
    @Transactional
	public void actualizarDistribucionMercaderia(DistribucionMercaderia data){
		hibernateTemplate.update(data);
    }

	public DistribucionMercaderia obtieneDistribucionMercaderiaPorId(String id){
        return hibernateTemplate.get(DistribucionMercaderia.class, new Long(id));
    }
	
    @Transactional
	public void insertarDistribucionMercaderia(DistribucionMercaderia data){
		hibernateTemplate.persist(data);
    }

    @SuppressWarnings("unchecked")
	public List<DistribucionMercaderiaConsulta> listaDistribucionMercaderiaConsulta(DistribucionMercaderiaConsultaModel model){	
    	List<DistribucionMercaderiaConsulta> listaConsulta =  new ArrayList<DistribucionMercaderiaConsulta>();
    	try {
    		DistribucionMercaderiaConsulta consulta = new DistribucionMercaderiaConsulta();
        	BeanUtils.copyProperties(consulta, model);
            String[] paramNames = {"idUnidadMineraInsumoPresentacion","idUnidadMineraArea","fechaInicio","fechaFin"};        
            String[] values = {model.getIdUnidadMineraInsumoPresentacion(),model.getIdUnidadMineraArea(),
            			model.getFechaInicio(),model.getFechaFin()};
            listaConsulta = hibernateTemplate.findByNamedQueryAndNamedParam("listaDistribucionMercaderia",paramNames,values);
		} catch (Exception e) {
			// TODO: handle exception
		}
    	return listaConsulta;
    }
    
	
	@Transactional
	public void eliminarDistribucionMercaderia(String id) {
		// TODO Auto-generated method stub
    	hibernateTemplate.bulkUpdate("DELETE DistribucionMercaderia where "
    			+ "idMercaderia=? ", new Long(id));
	}
	
}



