package com.hochschild.insumoQuimico.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hochschild.insumoQuimico.domain.InsumoPresentacion;
import com.hochschild.insumoQuimico.domain.UnidadMineraInsumoPresentacion;
import com.hochschild.insumoQuimico.util.Constantes;


@Repository(value="UnidadMineraInsumoPresentacionDAO")
public class UnidadMineraInsumoPresentacionDAOImpl implements UnidadMineraInsumoPresentacionDAO {
    @Autowired
    @Qualifier(value="hibernateTemplateInsumoQuimico")
    private HibernateTemplate hibernateTemplate;
    
    @SuppressWarnings("unchecked")
	public List<UnidadMineraInsumoPresentacion> listaUnidadMineraInsumoPresentacion() {
    	String query = "from UnidadMineraInsumoPresentacion where vigencia!='E'";
    	List<UnidadMineraInsumoPresentacion> resultado = hibernateTemplate.find(query);
        return  resultado;
    }
   
	public UnidadMineraInsumoPresentacion obtieneUnidadMineraInsumoPresentacionPorId(String id){
		UnidadMineraInsumoPresentacion UnidadMineraInsumoPresentacion = hibernateTemplate.get(UnidadMineraInsumoPresentacion.class, id);
		if(UnidadMineraInsumoPresentacion==null)UnidadMineraInsumoPresentacion=new UnidadMineraInsumoPresentacion();
    	return UnidadMineraInsumoPresentacion;
    }
	
	@SuppressWarnings("unchecked")
	public List<UnidadMineraInsumoPresentacion> listaUnidadMineraInsumoPresentacionPorUnidadMinera(String idUnidadMinera){
		String query = "from UnidadMineraInsumoPresentacion uma "
				+ "where uma.idUnidadMinera='"+idUnidadMinera+"' order by uma.presentacionInsumo.insumo.insumo";
    	List<UnidadMineraInsumoPresentacion> resultado = hibernateTemplate.find(query);
        return  resultado;
	}
}
