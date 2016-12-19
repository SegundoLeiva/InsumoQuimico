package com.hochschild.insumoQuimico.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.hochschild.insumoQuimico.domain.Insumo;
import com.hochschild.insumoQuimico.util.Constantes;

@Repository(value="InsumoDAO")
public class InsumoDAOImpl implements InsumoDAO {
    @Autowired
    @Qualifier(value="hibernateTemplateInsumoQuimico")
    private HibernateTemplate hibernateTemplate;

    @SuppressWarnings("unchecked")
	public List<Insumo> listaInsumo() {
    	String query = "from Insumo where vigencia!='E'";
    	List<Insumo> resultado = hibernateTemplate.find(query);
        return  resultado;
    }
   
	public Insumo obtieneInsumoPorId(String id){
        return hibernateTemplate.get(Insumo.class, id);
    }

	public void insertarInsumo(Insumo data) {
		// TODO Auto-generated method stub
		hibernateTemplate.persist(data);
	}

	public void actualizarInsumo(Insumo data) {
		// TODO Auto-generated method stub
		hibernateTemplate.update(data);
	}

	public void eliminarInsumo(String idInsumo) {
		// TODO Auto-generated method stub
		Insumo insumo = new Insumo();
		insumo = hibernateTemplate.get(Insumo.class, idInsumo);
		insumo.setVigencia(Constantes.ESTADO_ELIMINADO);
		hibernateTemplate.update(insumo);
	}

	@SuppressWarnings("unchecked")
	public int obtenerId() {
		// TODO Auto-generated method stub
		try {
			String query = "from Insumo order by idInsumo desc";
	    	List<Insumo> resultado = hibernateTemplate.find(query);
	        return  Integer.parseInt(resultado.get(0).getIdInsumo())+1;
		} catch (Exception e) {
			// TODO: handle exception
			return 1;
		}
		
	}
}


