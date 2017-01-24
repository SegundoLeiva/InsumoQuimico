package com.hochschild.insumoQuimico.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hochschild.insumoQuimico.domain.CatalogoDetalle;
import com.hochschild.insumoQuimico.util.Constantes;

@Repository(value="CatalogoDetalleDAO")
public class CatalogoDetalleDAOImpl implements CatalogoDetalleDAO {
    @Autowired
    @Qualifier(value="hibernateTemplateInsumoQuimico")
    private HibernateTemplate hibernateTemplate;

    @Transactional
	public void insertarCatalogoDetalle(CatalogoDetalle data){
		hibernateTemplate.persist(data);
    }

	@SuppressWarnings("unchecked")
	public List<CatalogoDetalle> listaCatalogoDetalle() {
    	String query = "from CatalogoDetalle";
        List<CatalogoDetalle> resultado= hibernateTemplate.find(query);
        return resultado;
	}
	
	@SuppressWarnings("unchecked")
	public List<CatalogoDetalle> listaCatalogoDetalleByIdCatalogo(Integer idCatalogo) {
    	String query = "from CatalogoDetalle where id.idCatalogo ='"+idCatalogo+"'";
        List<CatalogoDetalle> resultado= hibernateTemplate.find(query);
        return resultado;
	}


	public CatalogoDetalle obtenerCatalogoDetalleById(int idCatalogo,
			String idCatalogoDetalle) {
		String query = "from CatalogoDetalle where idCatalogo ="+idCatalogo
				+ "and idCatalogoDetalle ='"+idCatalogoDetalle+"'";
        CatalogoDetalle resultado= (CatalogoDetalle) hibernateTemplate.find(query).get(0);
        return resultado;
	}
	
}



