package com.hochschild.insumoQuimico.sap;

import java.io.File;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.sap.mw.jco.IFunctionTemplate;
import com.sap.mw.jco.IRepository;
import com.sap.mw.jco.JCO;

public class ConexionSAP{

	public static String esLoginSAPValido(String usuario, String password){
		
		String mensaje=null;
		com.sap.mw.jco.JCO.Client cliente = null;

        ResourceBundle bundle = ResourceBundle.getBundle("sap");
        String mandante = bundle.getString("sap.mandante").trim();
//        String usuario = bundle.getString("sap.usuario").trim();
//        String strPasswordSAP = bundle.getString("sap.password").trim();
        String idioma = bundle.getString("sap.idioma").trim();
        String ipSAP = bundle.getString("sap.host").trim();
        String numSistema = bundle.getString("sap.sistema").trim();

        try{
            cliente = JCO.createClient(mandante, usuario, password, idioma, ipSAP, numSistema);
            cliente.connect();
        }
        catch(Exception ex){
        	mensaje = ex.getMessage();
        }finally {
        	
        	if(cliente != null){
        		cliente.disconnect();
            	cliente=null;
        	}
		}
        
		return mensaje;
	}

    public static ConexionSAP getConexionSAPLogistica(String usuario, String password){
        ConexionSAP con = null;

        try{
            ResourceBundle bundle = ResourceBundle.getBundle("sap");                        
            String strMandanteSAP = bundle.getString("sap.mandante").trim();            
            String strUsuarioSAP = usuario;
            String strPasswordSAP = password;
            String strIdiomaSAP = bundle.getString("sap.idioma").trim();
            String strHostSAP = bundle.getString("sap.host").trim();
            String strSistemaSAP = bundle.getString("sap.sistema").trim();
            
            con = new ConexionSAP(strMandanteSAP,
                                 strUsuarioSAP,
                                 strPasswordSAP,
                                 strIdiomaSAP,
                                 strHostSAP,
                                 strSistemaSAP);
            
        }catch(Exception ex){
        }
        return con;
    }

    public static ConexionSAP getConexionSAP(){
        ConexionSAP con = null;

        try{
            ResourceBundle bundle = ResourceBundle.getBundle("sap");                        
            String strMandanteSAP = bundle.getString("sap.mandante").trim();            
            String strUsuarioSAP = bundle.getString("sap.usuario").trim();
            String strPasswordSAP = bundle.getString("sap.password").trim();
            String strIdiomaSAP = bundle.getString("sap.idioma").trim();
            String strHostSAP = bundle.getString("sap.host").trim();
            String strSistemaSAP = bundle.getString("sap.sistema").trim();
            
            con = new ConexionSAP(strMandanteSAP,
                                 strUsuarioSAP,
                                 strPasswordSAP,
                                 strIdiomaSAP,
                                 strHostSAP,
                                 strSistemaSAP);
            
        }catch(Exception ex){
        }
        return con;
    }


    public ConexionSAP(String mandante, String usuario, String contraseF1a, String idioma, String ipSAP, String numSistema){
        
        cliente = null;
        rFC = null;
        input = null;
        repos = null;
        rFCTemplate = null;
        tabla = null;
        datosTabla = null;
        fila = Integer.valueOf(-1);
        
        try{
            cliente = JCO.createClient(mandante, usuario, contraseF1a, idioma, ipSAP, numSistema);
            cliente.connect();
            repos = JCO.createRepository("_Proof", cliente);            
        }
        catch(Exception ex){
        	ex.getMessage();
        }
    }

    public ConexionSAP (){};

    public void RegistrarRFC(String nombreRFC)
        throws Exception
    {
        if(cliente != null && repos != null)
            try
            {
                rFCTemplate = repos.getFunctionTemplate(nombreRFC);
                rFC = rFCTemplate.getFunction();                
            }
            catch(Exception ex){                
                throw new Exception("No se ha registrado el RFC correctamente.");
            }
        else
            throw new Exception("No se ha establecido la conexi\363n con SAP");
    }

    public void IngresarDatosInput(String dato, String nombreCampo)
        throws Exception
    {
        if(rFC != null)
        {
            if(input == null)
                input = rFC.getImportParameterList();
            input.setValue(dato, nombreCampo);
        } else
        {
            throw new Exception("No se ha registrado el RFC con el que se trabajar\341");
        }
    }

    public void CreaTabla(String nombreTabla)
        throws Exception
    {
        if(rFC != null)
        {
            tabla = null;
            tabla = rFC.getTableParameterList().getTable(nombreTabla);
            fila = Integer.valueOf(-1);
        } else
        {
            throw new Exception("No se ha registrado el RFC con el que se trabajar\341");
        }
    }

    public void IngresarDatoTabla(String dato, String nombreColumna, int numfila)
        throws Exception
    {
        if(tabla != null)
        {
            if(fila.intValue() != numfila)
            {
                tabla.appendRows(1);
                fila = Integer.valueOf(numfila);
            }
            tabla.setValue(dato, nombreColumna);
        } else
        {
            throw new Exception("No se ha registrado la tabla con la que se trabajar\341");
        }
    }

    public ArrayList ObtenerDatosTabla() throws Exception{
        if(rFC != null){
            datosTabla = new ArrayList(tabla.getNumRows());
            for(int i = 0; i < tabla.getNumRows(); i++){
                String temp = "";
                for(int j = 0; j < tabla.getNumColumns(); j++)
                    temp = (new StringBuilder(String.valueOf(temp))).append("\254").append(tabla.getValue(tabla.getName(j))).toString();

                datosTabla.add(temp);
                tabla.nextRow();
            }
            return datosTabla;
        }else{
            throw new Exception("No se ha registrado el RFC con el que se trabajar\341");
        }
    }

    public ArrayList ObtenerDatosTabla(ArrayList nombresColumnas) throws Exception{
        if(rFC != null){
            datosTabla = new ArrayList();
            for(int i = 0; i < tabla.getNumRows(); i++){
                String temp = "";
                for(int j = 0; j < nombresColumnas.size(); j++)
                    temp = (new StringBuilder(String.valueOf(temp))).append("\254").append(tabla.getValue((String)nombresColumnas.get(j))).toString();
                datosTabla.add((new StringBuilder(String.valueOf(temp))).append("\254").toString());
                tabla.nextRow();
            }
            return datosTabla;
        }else{
            throw new Exception("No se ha registrado el RFC con el que se trabajar\341");
        }
    }

    public void EjecutarRFC(){
        try{
            cliente.execute(rFC);
        }
        catch(Exception ex){            
            excepcion = (new StringBuilder("")).append(ex.getMessage()).toString();            
        }
    }

    public void DesconectarSAP(){
        if(cliente != null){
            cliente.disconnect();
            cliente = null;
            rFC = null;
            input = null;
            repos = null;
            rFCTemplate = null;
            tabla = null;
            datosTabla = null;
        }
    }     

    private com.sap.mw.jco.JCO.Client cliente;
    public com.sap.mw.jco.JCO.Function rFC;
    public com.sap.mw.jco.JCO.ParameterList input;
    private IRepository repos;
    private IFunctionTemplate rFCTemplate;
    private com.sap.mw.jco.JCO.Table tabla;
    private ArrayList datosTabla;
    private Integer fila;
    public String excepcion;
    public static File archivoConfiguracion;
    public static File archivoWebService;
    public static File archivoJDBC;
}