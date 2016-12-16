package com.hochschild.insumoQuimico.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.hochschild.insumoQuimico.domain.UnidadMedida;

@Repository(value="UnidadMedidaDAO")
public class UnidadMedidaDAOImpl implements UnidadMedidaDAO {
    @Autowired
    @Qualifier(value="hibernateTemplateInsumoQuimico")
    private HibernateTemplate hibernateTemplate;

    @SuppressWarnings("unchecked")
	public List<UnidadMedida> listaUnidadMedida() {
    	String query = "from UnidadMedida where unidadMedida not in ('-','\"\"\"') order by unidadMedida";
    	List<UnidadMedida> resultado = hibernateTemplate.find(query);
        return  resultado;
    }
   
	public UnidadMedida obtieneUnidadMedidaPorId(String id){
    	return hibernateTemplate.get(UnidadMedida.class, id);
    }
}



