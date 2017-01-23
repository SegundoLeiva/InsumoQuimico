package com.hochschild.insumoQuimico.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hochschild.insumoQuimico.domain.InsumoPresentacion;

@Repository(value="PresentacionInsumoDAO")
public class PresentacionInsumoDAOImpl implements PresentacionInsumoDAO {
    @Autowired
    @Qualifier(value="hibernateTemplateInsumoQuimico")
    private HibernateTemplate hibernateTemplate;

	@Transactional
	public void insertarPresentacionInsumo(InsumoPresentacion data){

    	hibernateTemplate.persist(data);
    	
    }

    @Transactional
	public void eliminarPresentacionInsumo(String idPresentacionInsumo) {
		// TODO Auto-generated method stub
    	hibernateTemplate.bulkUpdate("DELETE InsumoPresentacion where idPresentacionInsumo=? ", idPresentacionInsumo);
   	}
    
    @Transactional
	public void modificarPresentacionInsumo(InsumoPresentacion data){
    	hibernateTemplate.update(data);   	
    }
	
	@SuppressWarnings("unchecked")
	public List<InsumoPresentacion> listaPresentacionInsumoPorInsumo(int idInsumo){
		 String sql = "from InsumoPresentacion WHERE idInsumo = "+idInsumo;
		 List<InsumoPresentacion> resultado= hibernateTemplate.find(sql);
	      
	     return resultado;
	}
	
	@SuppressWarnings("unchecked")
	public InsumoPresentacion obtenerPresentacionInsumo(String idPresentacionInsumo){
		String sql = "from InsumoPresentacion WHERE idPresentacionInsumo = '"+idPresentacionInsumo+"'";
		 List<InsumoPresentacion> resultado= hibernateTemplate.find(sql);
	      
	     return resultado.get(0);
	}

	 
}



