package com.hochschild.insumoQuimico.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hochschild.insumoQuimico.domain.UnidadMineraInsumo;


@Repository(value="UnidadMineraInsumoDAO")
public class UnidadMineraInsumoDAOImpl implements UnidadMineraInsumoDAO {
    @Autowired
    @Qualifier(value="hibernateTemplateInsumoQuimico")
    private HibernateTemplate hibernateTemplate;

    @Transactional
	public void insertarUnidadMineraInsumo(UnidadMineraInsumo data){
    	hibernateTemplate.persist(data);   	
    }
    
    @Transactional
	public void actualizarUnidadMineraInsumo(UnidadMineraInsumo data){
		hibernateTemplate.update(data);
    }
    
    @Transactional
	public void eliminarUnidadMineraInsumo(String idUnidadMineraInsumo) {		
    	hibernateTemplate.bulkUpdate("DELETE UnidadMineraInsumo where "
    			+ "idUnidadMineraInsumo=? ", idUnidadMineraInsumo);
	}
    
    @SuppressWarnings("unchecked")
	public List<UnidadMineraInsumo> listaUnidadMineraInsumo() {
    	String query = "from UnidadMineraInsumo";
    	List<UnidadMineraInsumo> resultado = hibernateTemplate.find(query);
        return  resultado;
    }
   
	public UnidadMineraInsumo obtieneUnidadMineraInsumoPorId(String id){
    	return hibernateTemplate.get(UnidadMineraInsumo.class, id);
    }
	
	@SuppressWarnings("unchecked")
	public List<UnidadMineraInsumo> listaUnidadMineraInsumoPorUnidadMinera(String idUnidadMinera){
		String query = "from UnidadMineraInsumo uma "
				+ "where uma.idUnidadMinera='"+idUnidadMinera+"' order by uma.Insumo.Insumo";
    	List<UnidadMineraInsumo> resultado = hibernateTemplate.find(query);
        return  resultado;
	}
}
