package com.hochschild.insumoQuimico.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hochschild.insumoQuimico.domain.InsumoPresentacion;
import com.hochschild.insumoQuimico.domain.UnidadMineraInsumo;
import com.hochschild.insumoQuimico.domain.UnidadMineraInsumoPresentacion;
import com.hochschild.insumoQuimico.util.Constantes;


@Repository(value="UnidadMineraInsumoDAO")
public class UnidadMineraInsumoDAOImpl implements UnidadMineraInsumoDAO {
    @Autowired
    @Qualifier(value="hibernateTemplateInsumoQuimico")
    private HibernateTemplate hibernateTemplate;

    @SuppressWarnings("unchecked")
	@Transactional
	public void insertarUnidadMineraInsumo(UnidadMineraInsumo data){
    	hibernateTemplate.persist(data);  
    	
    	String query = "from InsumoPresentacion where idInsumo='"+data.getInsumo().getIdInsumo()+"'";
    	List<InsumoPresentacion> resultado = hibernateTemplate.find(query);
    	for (int i = 0; i < resultado.size(); i++) {
    		UnidadMineraInsumoPresentacion unidadMineraInsumoPresentacion = new UnidadMineraInsumoPresentacion();
    		unidadMineraInsumoPresentacion.setIdUnidadMineraInsumoPresentacion(data.getIdUnidadMinera()+"-"+resultado.get(i).getIdPresentacionInsumo());
    		unidadMineraInsumoPresentacion.setIdUnidadMinera(data.getIdUnidadMinera());
    		
    		InsumoPresentacion presentacionInsumo = new InsumoPresentacion();
    		presentacionInsumo.setIdPresentacionInsumo(resultado.get(i).getIdPresentacionInsumo());
    		unidadMineraInsumoPresentacion.setPresentacionInsumo(presentacionInsumo);
    		unidadMineraInsumoPresentacion.setVigencia(resultado.get(i).getVigencia());
    		
    		hibernateTemplate.persist(unidadMineraInsumoPresentacion);  
		}
    	
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
				+ "where uma.idUnidadMinera='"+idUnidadMinera+"' order by uma.insumo.insumo";
    	List<UnidadMineraInsumo> resultado = hibernateTemplate.find(query);
        return  resultado;
	}
}
