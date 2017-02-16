package com.hochschild.insumoQuimico.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.hochschild.insumoQuimico.domain.EnvioCorreo;

@Repository(value="EnvioCorreoDAO")
public class EnvioCorreoDAOImpl implements EnvioCorreoDAO {
    @Autowired
    @Qualifier(value="hibernateTemplateInsumoQuimico")
    private HibernateTemplate hibernateTemplate;

	public void insertarEnvioCorreo(EnvioCorreo data) {
		hibernateTemplate.persist(data);
		
	}

	@SuppressWarnings("unchecked")
	public int obtenerIdPorUnidadMinera(String idUnidadMinera) {
		// TODO Auto-generated method stub
		try {
			String query = "from EnvioCorreo where idUnidadMinera='"+idUnidadMinera+"' order by idEnvioCorreo desc";
	    	List<EnvioCorreo> resultado = hibernateTemplate.find(query);
	        return  resultado.get(0).getId().getIdEnvioCorreo()+1;
		} catch (Exception e) {
			// TODO: handle exception
			return 1;
		}
	}
}


