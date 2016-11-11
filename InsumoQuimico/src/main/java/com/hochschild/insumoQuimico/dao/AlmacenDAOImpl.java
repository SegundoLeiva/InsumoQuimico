package com.hochschild.insumoQuimico.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.hochschild.insumoQuimico.domain.Almacen;

@Repository(value="AlmacenDAO")
public class AlmacenDAOImpl implements AlmacenDAO {
    @Autowired
    @Qualifier(value="hibernateTemplateInsumoQuimico")
    private HibernateTemplate hibernateTemplate;

    @SuppressWarnings("unchecked")
	public List<Almacen> listaAlmacen() {
    	String query = "from Almacen";
    	List<Almacen> resultado = hibernateTemplate.find(query);
        return  resultado;
    }
   
	public Almacen obtieneAlmacenPorId(String id){
        return hibernateTemplate.get(Almacen.class, id);
    }
}


