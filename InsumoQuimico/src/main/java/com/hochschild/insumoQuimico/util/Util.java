package com.hochschild.insumoQuimico.util;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hochschild.sca.domain.OpcionAccionesSCA;

public class Util {
	
    public static String agregarCerosIzqNumeroMaterialSap(String numeroMaterial) {
        String numeroMaterialRellenado = "";

        String totalCeros = "000000000000000000";
        numeroMaterialRellenado = totalCeros.substring(numeroMaterial.length()) + numeroMaterial;

        return numeroMaterialRellenado;
    }
    
    public static String concatenaOpcionesAccionesSCA(List<OpcionAccionesSCA> listaOpcionesAccionesSCA) {
        List<String> resultado = new ArrayList<String>();
        for (OpcionAccionesSCA opcion : listaOpcionesAccionesSCA) {
            resultado.add(String.valueOf(opcion.getIdOpcion()));
            resultado.add(opcion.getAcciones());
        }
        String strOpciones = "";
        String opcion = "";
        for (int i = 0; i < resultado.size(); i++) {
            if (i % 2 == 0) {
                opcion = resultado.get(i);
                strOpciones += opcion + ",";
            }
        }
        if(!strOpciones.equals("")){
            strOpciones = strOpciones.substring(0, strOpciones.length() - 1);
        }
        return strOpciones;
    }
    
	public static boolean validFlagTransaccion(HttpServletRequest req,String flag){
		if((String)req.getAttribute(Constantes.FLAG_TRANSACCION)!=null && req.getAttribute(Constantes.FLAG_TRANSACCION).toString().equals(flag)){
			return true;
		}else{
			return false;
		}
	}

}
