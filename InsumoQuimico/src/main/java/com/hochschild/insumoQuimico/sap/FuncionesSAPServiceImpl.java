package com.hochschild.insumoQuimico.sap;

import org.springframework.stereotype.Service;

import com.sap.mw.jco.JCO.ParameterList;

@Service
public class FuncionesSAPServiceImpl implements FuncionesSAPService {
	
    

    public String getProveedorDescripcion(String ruc, String sociedad) {
        
        String descripcion = "";
        ConexionSAP conSAP = ConexionSAP.getConexionSAP();        
        try {
            conSAP.RegistrarRFC("ZMM_RFCFN_LEER_DATOS_PROV_PP");
            conSAP.IngresarDatosInput(ruc, "I_STCD1");
            conSAP.IngresarDatosInput(sociedad, "I_BUKRS");
            conSAP.EjecutarRFC();
            descripcion = conSAP.rFC.getExportParameterList().getString("E_NAME1");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conSAP.DesconectarSAP();
        }
        return descripcion;
    }
    
}
