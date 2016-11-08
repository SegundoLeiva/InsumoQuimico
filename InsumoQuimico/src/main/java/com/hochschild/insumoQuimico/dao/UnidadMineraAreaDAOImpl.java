package com.hochschild.insumoQuimico.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hochschild.insumoQuimico.domain.UnidadMineraArea;


@Repository(value="UnidadMineraAreaDAO")
public class UnidadMineraAreaDAOImpl implements UnidadMineraAreaDAO {
    @Autowired
    @Qualifier(value="hibernateTemplateInsumoQuimico")
    private HibernateTemplate hibernateTemplate;

    @Transactional
	public void insertarUnidadMineraArea(UnidadMineraArea data){
    	hibernateTemplate.persist(data);   	
    }
    
    @Transactional
	public void actualizarUnidadMineraArea(UnidadMineraArea data){
		hibernateTemplate.update(data);
    }
    
    @Transactional
	public void eliminarUnidadMineraArea(String idUnidadMineraArea) {		
    	hibernateTemplate.bulkUpdate("DELETE UnidadMineraArea where "
    			+ "idUnidadMineraArea=? ", idUnidadMineraArea);
	}
    
    @SuppressWarnings("unchecked")
	public List<UnidadMineraArea> listaUnidadMineraArea() {
    	String query = "from UnidadMineraArea";
    	List<UnidadMineraArea> resultado = hibernateTemplate.find(query);
        return  resultado;
    }
   
	public UnidadMineraArea obtieneUnidadMineraAreaPorId(String id){
    	return hibernateTemplate.get(UnidadMineraArea.class, id);
    }
	
	@SuppressWarnings("unchecked")
	public List<UnidadMineraArea> listaUnidadMineraAreaPorUnidadMinera(String idUnidadMinera){
		String query = "from UnidadMineraArea uma "
				+ "where uma.idUnidadMinera='"+idUnidadMinera+"' order by uma.Area.Area";
    	List<UnidadMineraArea> resultado = hibernateTemplate.find(query);
        return  resultado;
	}
}
