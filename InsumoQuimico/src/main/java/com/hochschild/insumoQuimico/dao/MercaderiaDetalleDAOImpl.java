package com.hochschild.insumoQuimico.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hochschild.insumoQuimico.domain.MercaderiaDetalle;

@Repository(value="MercaderiaDetalleDAO")
public class MercaderiaDetalleDAOImpl implements MercaderiaDetalleDAO {
    @Autowired
    @Qualifier(value="hibernateTemplateInsumoQuimico")
    private HibernateTemplate hibernateTemplate;

	@Transactional
	public void insertarMercaderiaDetalle(MercaderiaDetalle data){

    	hibernateTemplate.persist(data);
    	
    }

    @Transactional
	public void eliminarMercaderiaDetalle(int idMercaderiaDetalle, String idMercaderia) {
		// TODO Auto-generated method stub
    	hibernateTemplate.bulkUpdate("DELETE MercaderiaDetalle where idMercaderiaDetalle=? and idMercaderia=?", idMercaderiaDetalle,idMercaderia);
   	}
    
    @Transactional
	public void modificarMercaderiaDetalle(MercaderiaDetalle data){
    	hibernateTemplate.update(data);   	
    }
	
	@SuppressWarnings("unchecked")
	public List<MercaderiaDetalle> obtenerMercaderiaDetallePorIdMercaderia(String id){
		 String sql = "from MercaderiaDetalle WHERE idMercaderia = '"+id+"'";
		 List<MercaderiaDetalle> resultado= hibernateTemplate.find(sql);
	      
	     return resultado;
	}
	
	@SuppressWarnings("unchecked")
	public MercaderiaDetalle obtenerMercaderiaDetalle(String idMercaderia,String idMercaderiaDetalle){
		String sql = "from MercaderiaDetalle WHERE idMercaderia = '"+idMercaderia+"' "
				+ "and idMercaderiaDetalle='"+idMercaderiaDetalle+"'";
		 List<MercaderiaDetalle> resultado= hibernateTemplate.find(sql);
	      
	     return resultado.get(0);
	}

	 
}



