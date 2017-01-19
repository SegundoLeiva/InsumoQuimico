package com.hochschild.insumoQuimico.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.hochschild.insumoQuimico.domain.UnidadMineraAlmacen;

@Repository(value="UnidadMineraAlmacenDAO")
public class UnidadMineraAlmacenDAOImpl implements UnidadMineraAlmacenDAO {
    @Autowired
    @Qualifier(value="hibernateTemplateInsumoQuimico")
    private HibernateTemplate hibernateTemplate;

    @SuppressWarnings("unchecked")
	public List<UnidadMineraAlmacen> listaUnidadMineraAlmacen() {
    	String query = "from UnidadMineraAlmacen";
    	List<UnidadMineraAlmacen> resultado = hibernateTemplate.find(query);
        return  resultado;
    }
	
	@SuppressWarnings("unchecked")
	public List<UnidadMineraAlmacen> listaUnidadMineraAlmacenPorUnidadMinera(String idUnidadMinera){
		String query = "from UnidadMineraAlmacen uma "
				+ "where uma.idUnidadMinera='"+idUnidadMinera+"' order by uma.almacen.almacen";
    	List<UnidadMineraAlmacen> resultado = hibernateTemplate.find(query);
        return  resultado;
	}
}
