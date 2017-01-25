package com.hochschild.insumoQuimico.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FechasUtil {
    
    public static String getFechaActual() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.format(new Date(System.currentTimeMillis()));
    }
    
    public static Date stringToDate(String fecha,String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        try {
			return formatter.parse(fecha);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			return null;
		}
    }
    
    public static String dateToString(Date fecha,String format) {
    	
        SimpleDateFormat formatter = new SimpleDateFormat(format);
		return formatter.format(fecha);

    }
    
    public static String getPrimerDiaDelMesActual(){
    	Calendar cal = Calendar.getInstance();
		cal.set(cal.get(Calendar.YEAR),cal.get(Calendar.MONTH),cal.getActualMinimum(Calendar.DAY_OF_MONTH));
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	        
		return formatter.format(cal.getTime());
    }
    
    public static String getUltimoDiaDelMesActual(){
    	Calendar cal = Calendar.getInstance();
		cal.set(cal.get(Calendar.YEAR),cal.get(Calendar.MONTH),cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	        
		return formatter.format(cal.getTime());
    }
    
    public static String getAnioActual(){
    	Calendar cal = Calendar.getInstance();
    	cal.setTime(new Date());
    	int year = cal.get(Calendar.YEAR);
		return String.valueOf(year);
    }
    
    public static String getMesActual(){
    	Calendar cal = Calendar.getInstance();
    	cal.setTime(new Date());
    	int month = cal.get(Calendar.MONTH);
		return String.valueOf(month);
    }
    
    public static String getPrimerDiaDelMesActualPorAnio(String anio, String mes, String formato){
    	Calendar cal = Calendar.getInstance();
		cal.set(Integer.parseInt(anio),Integer.parseInt(mes),cal.getActualMinimum(Calendar.DAY_OF_MONTH));
		
		SimpleDateFormat formatter = new SimpleDateFormat(formato);
	        
		return formatter.format(cal.getTime());
    }
    
    public static String getUltimoDiaDelMesActualPorAnio(String anio, String mes, String formato){
    	Calendar cal = Calendar.getInstance();
		cal.set(Integer.parseInt(anio),Integer.parseInt(mes),cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		
		SimpleDateFormat formatter = new SimpleDateFormat(formato);
	        
		return formatter.format(cal.getTime());
    }
    
    public static String obtenerMesDescripcion(String idMes){
    	String result = "";
    	switch(Integer.parseInt(idMes)){
    	  case 0:
    	    {
    	      result="Enero";
    	      break;
    	    }
    	  case 1:
    	    {
    	      result="Febrero";
    	      break;
    	    }
    	  case 2:
    	    {
    	      result="Marzo";
    	      break;
    	    }
    	  case 3:
    	    {
    	      result="Abril";
    	      break;
    	    }
    	  case 4:
    	    {
    	      result="Mayo";
    	      break;
    	    }
    	  case 5:
    	    {
    	      result="Junio";
    	      break;
    	    }
    	  case 6:
    	    {
    	      result="Julio";
    	      break;
    	    }
    	  case 7:
    	    {
    	      result="Agosto";
    	      break;
    	    }
    	  case 8:
    	    {
    	      result="Septiembre";
    	      break;
    	    }
    	  case 9:
    	    {
    	      result="Octubre";
    	      break;
    	    }
    	  case 10:
    	    {
    	      result="Noviembre";
    	      break;
    	    }
    	  case 11:
    	    {
    	      result="Diciembre";
    	      break;
    	    }
    	  default:
    	    {
    	      result="Error";
    	      break;
    	    }
    	}
    	return result;
    	
    }
}