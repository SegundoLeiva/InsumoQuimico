package com.hochschild.insumoQuimico.util;

public class Constantes {
	
	public static final String ACCION = "accion";
	public static final String FLAG_TRANSACCION = "flagTransaccion";
    public static final String TRANSACCION_ERROR = "error";
    public static final String TRANSACCION_GUARDAR = "guardar";
    public static final String TRANSACCION_MODIFICAR = "modificar";
    public static final String TRANSACCION_ELIMINAR = "eliminar";
    public static final String TRANSACCION_CONSULTAR = "consultar";
    public static final String TRANSACCION_CAMBIAR_APERTURA = "apertura";
    
    //Constantes Indicadores BD
    public static final String INDICADOR_NUEVO = "0";
    public static final String INDICADOR_MODIFICADO = "2";
    public static final String INDICADOR_ELIMINADO = "3";
    
    //LOGIN CONTROLLER
    public static final String claveSeguridad = "bandejaunificada";
    public static final String ID_ROL_BASICO = "ID_ROL_BASICO";
    public static final Integer ID_OPCION_LOGISTICA = 4;
    
    //CODIGOS
    public static final String SOCIEDAD_PROVEEDOR = "1013";
    public static final String ALMACEN_CENTRAL = "1303-00001";
    
    //CONSTANTES DE ESTADO DE VIGENCIA
    public static final String ESTADO_VIGENTE = "S";
    public static final String ESTADO_NO_VIGENTE = "N";
    public static final String ESTADO_ELIMINADO = "E";
    
    //CONSTANTES DE REPORTE TXT
    public static final String TIPO_OPERACION_INGRESO = "1";
    public static final String TIPO_OPERACION_CONSUMO = "4";
    public static final String TIPO_TRANSACCION_INGRESO = "001";
    public static final String TIPO_TRANSACCION_CONSUMO = "031";
    public static final String TIPO_DOCUMENTO_TRANSACCION_INGRESO = "09";
    public static final String TIPO_DOCUMENTO_TRANSACCION_CONSUMO = "99";
    public static final String TIPO_DOCUMENTO_DESTINATARIO= "6";
    public static final String TIPO_DOCUMENTO_TRANSFERIR = "6";
    public static final String TIPO_DOCUMENTO_RELACIONADO_DEL_BIEN = "6";
    
    //Parametros Envio Correo
    public static final String MAIL_HOST = "10.36.2.49";
    public static final String MAIL_REMITENTE = "servicio.alerta@hocplc.com";
}
