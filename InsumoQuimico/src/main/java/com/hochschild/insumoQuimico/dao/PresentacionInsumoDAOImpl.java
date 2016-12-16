package com.hochschild.insumoQuimico.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hochschild.insumoQuimico.domain.PresentacionInsumo;

@Repository(value="PresentacionInsumoDAO")
public class PresentacionInsumoDAOImpl implements PresentacionInsumoDAO {
    @Autowired
    @Qualifier(value="hibernateTemplateInsumoQuimico")
    private HibernateTemplate hibernateTemplate;

	@Transactional
	public void insertarPresentacionInsumo(PresentacionInsumo data){

    	hibernateTemplate.persist(data);
    	
    }

    @Transactional
	public void eliminarPresentacionInsumo(String idPresentacionInsumo) {
		// TODO Auto-generated method stub
    	hibernateTemplate.bulkUpdate("DELETE PresentacionInsumo where idPresentacionInsumo=? ", idPresentacionInsumo);
   	}
    
    @Transactional
	public void modificarPresentacionInsumo(PresentacionInsumo data){
    	hibernateTemplate.update(data);   	
    }
	
	@SuppressWarnings("unchecked")
	public List<PresentacionInsumo> listaPresentacionInsumoPorInsumo(int idInsumo){
		 String sql = "from PresentacionInsumo WHERE idInsumo = "+idInsumo;
		 List<PresentacionInsumo> resultado= hibernateTemplate.find(sql);
	      
	     return resultado;
	}
	
	@SuppressWarnings("unchecked")
	public PresentacionInsumo obtenerPresentacionInsumo(String idPresentacionInsumo){
		String sql = "from PresentacionInsumo WHERE idPresentacionInsumo = '"+idPresentacionInsumo+"'";
		 List<PresentacionInsumo> resultado= hibernateTemplate.find(sql);
	      
	     return resultado.get(0);
	}

	 
}



