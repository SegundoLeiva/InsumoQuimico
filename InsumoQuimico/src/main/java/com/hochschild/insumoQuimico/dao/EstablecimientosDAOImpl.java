package com.hochschild.insumoQuimico.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.hochschild.insumoQuimico.domain.Establecimientos;

@Repository(value="EstablecimientosDAO")
public class EstablecimientosDAOImpl implements EstablecimientosDAO {
    @Autowired
    @Qualifier(value="hibernateTemplateInsumoQuimico")
    private HibernateTemplate hibernateTemplate;

	public Establecimientos obtieneEstablecimientosPorIdUnidadMinera(
			String idUnidadMinera) {
		// TODO Auto-generated method stub
		 String sql = "from Establecimientos WHERE idUnidadMinera = '"+idUnidadMinera+"'";
		 List<Establecimientos> resultado= hibernateTemplate.find(sql);
	      
	     return resultado.get(0);
	}


   
}


