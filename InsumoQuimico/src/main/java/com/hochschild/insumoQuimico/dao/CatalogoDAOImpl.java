package com.hochschild.insumoQuimico.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.hochschild.insumoQuimico.domain.Catalogo;

@Repository(value="CatalogoDAO")
public class CatalogoDAOImpl implements CatalogoDAO {
    @Autowired
    @Qualifier(value="hibernateTemplateInsumoQuimico")
    private HibernateTemplate hibernateTemplate;

	@SuppressWarnings("unchecked")
	public List<Catalogo> listaCatalogo() {
        List<Catalogo> resultado= hibernateTemplate.findByNamedQuery("listaCatalogo");
        return resultado;
	}
}



