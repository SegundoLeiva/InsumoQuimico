package com.hochschild.insumoQuimico.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hochschild.insumoQuimico.dao.DivisionesCIADAO;
import com.hochschild.insumoQuimico.domain.DivisionesCIA;

@Service
public class DivisionesCIAServiceImpl implements DivisionesCIAService {

	@Autowired
	public DivisionesCIADAO divisionesCIADAO;

	public DivisionesCIA obtenerDivisionesCIAPorId(
			String idSociedad, String idDivision) {
		// TODO Auto-generated method stub
		return divisionesCIADAO.obtenerDivisionesCIAPorId(idSociedad, idDivision);
	}
	
	
}
