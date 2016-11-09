package com.hochschild.insumoQuimico.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.hochschild.insumoQuimico.domain.Insumo;

@Repository(value="InsumoDAO")
public class InsumoDAOImpl implements InsumoDAO {
    @Autowired
    @Qualifier(value="hibernateTemplateInsumoQuimico")
    private HibernateTemplate hibernateTemplate;

    @SuppressWarnings("unchecked")
	public List<Insumo> listaInsumo() {
    	String query = "from Insumo";
    	List<Insumo> resultado = hibernateTemplate.find(query);
        return  resultado;
    }
   
	public Insumo obtieneInsumoPorId(String id){
        return hibernateTemplate.get(Insumo.class, id);
    }
}


