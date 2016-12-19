package com.hochschild.insumoQuimico.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hochschild.insumoQuimico.domain.Insumo;
import com.hochschild.insumoQuimico.domain.UnidadMineraInsumo;
import com.hochschild.insumoQuimico.domain.UnidadMineraInsumoSaldo;
import com.hochschild.insumoQuimico.domain.UnidadMineraInsumoSaldo.IdSaldo;
import com.hochschild.insumoQuimico.util.Constantes;


@Repository(value="UnidadMineraInsumoDAO")
public class UnidadMineraInsumoDAOImpl implements UnidadMineraInsumoDAO {
    @Autowired
    @Qualifier(value="hibernateTemplateInsumoQuimico")
    private HibernateTemplate hibernateTemplate;

    @Transactional
	public void insertarUnidadMineraInsumo(UnidadMineraInsumo data){
    	hibernateTemplate.persist(data);   	
    	
    	UnidadMineraInsumoSaldo unidadMineraInsumoSaldo = new UnidadMineraInsumoSaldo();
    	IdSaldo id = new IdSaldo();
    	id.setIdUnidadMineraInsumo(data.getIdUnidadMineraInsumo());
    	id.setIdUnidadMineraAlmacen(Constantes.ALMACEN_CENTRAL);
    	unidadMineraInsumoSaldo.setId(id);
    	unidadMineraInsumoSaldo.setStock(0.0);
    	unidadMineraInsumoSaldo.setUnidadMedida("KG");
    	
    	hibernateTemplate.persist(unidadMineraInsumoSaldo); 
    }
    
    @Transactional
	public void actualizarUnidadMineraInsumo(UnidadMineraInsumo data){
		hibernateTemplate.update(data);
    }
    
    @Transactional
	public void eliminarUnidadMineraInsumo(String idUnidadMineraInsumo) {	
    	UnidadMineraInsumo unidadMineraInsumo = new UnidadMineraInsumo();
    	unidadMineraInsumo = hibernateTemplate.get(UnidadMineraInsumo.class, idUnidadMineraInsumo);
    	unidadMineraInsumo.setVigencia(Constantes.ESTADO_ELIMINADO);
		hibernateTemplate.update(unidadMineraInsumo);
	}
    
    @SuppressWarnings("unchecked")
	public List<UnidadMineraInsumo> listaUnidadMineraInsumo() {
    	String query = "from UnidadMineraInsumo where vigencia!='E'";
    	List<UnidadMineraInsumo> resultado = hibernateTemplate.find(query);
        return  resultado;
    }
   
	public UnidadMineraInsumo obtieneUnidadMineraInsumoPorId(String id){
		UnidadMineraInsumo unidadMineraInsumo = hibernateTemplate.get(UnidadMineraInsumo.class, id);
		if(unidadMineraInsumo==null)unidadMineraInsumo=new UnidadMineraInsumo();
    	return unidadMineraInsumo;
    }
	
	@SuppressWarnings("unchecked")
	public List<UnidadMineraInsumo> listaUnidadMineraInsumoPorUnidadMinera(String idUnidadMinera){
		String query = "from UnidadMineraInsumo uma "
				+ "where uma.idUnidadMinera='"+idUnidadMinera+"' order by uma.Insumo.Insumo";
    	List<UnidadMineraInsumo> resultado = hibernateTemplate.find(query);
        return  resultado;
	}
}
