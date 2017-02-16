package com.hochschild.insumoQuimico.dao;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.hochschild.insumoQuimico.domain.CalendarioGestion;
import com.hochschild.insumoQuimico.domain.CalendarioGestionModel;

@Repository(value="CalendarioGestionDAO")
public class CalendarioGestionDAOImpl implements CalendarioGestionDAO {
    @Autowired
    @Qualifier(value="hibernateTemplateInsumoQuimico")
    private HibernateTemplate hibernateTemplate;

   
	@SuppressWarnings("unchecked")
	public CalendarioGestion obtieneCalendarioGestionPorIdUnidadMinera(String idUnidadMinera){
		
		String anio =  String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
		String mes = String.format("%02d", Calendar.getInstance().get(Calendar.MONDAY)+1);
		
		String query = "from CalendarioGestion where idUnidadMinera='"+idUnidadMinera+"'"
				+ " and idAnioGestion='"+anio+"' and idMesgestion='"+mes+"'";
    	List<CalendarioGestion> resultado = hibernateTemplate.find(query);
        return  resultado.get(0);
    }


	@SuppressWarnings("unchecked")
	public CalendarioGestion obtieneCalendarioGestion(
			CalendarioGestionModel data) {
		// TODO Auto-generated method stub
		String query = "from CalendarioGestion where idUnidadMinera='"+data.getIdUnidadMinera()+"' "
				+ "and idAnioGestion='"+data.getAnio()+"' and idMesGestion='"+data.getMes()+"'";
    	List<CalendarioGestion> resultado = hibernateTemplate.find(query);
        return  resultado.get(0);
	}


	public void actualizarCalendarioGestion(CalendarioGestion data) {
		// TODO Auto-generated method stub
		hibernateTemplate.update(data);  
		
	}


	@SuppressWarnings("unchecked")
	public List<CalendarioGestion> listCalendarioGestionPorAnio(CalendarioGestionModel data) {
		// TODO Auto-generated method stub
		String query = "from CalendarioGestion where idUnidadMinera='"+data.getIdUnidadMinera()+"' "
				+ "and idAnioGestion='"+data.getAnio()+"' ";
    	List<CalendarioGestion> resultado = hibernateTemplate.find(query);
		return resultado;
	}
}


