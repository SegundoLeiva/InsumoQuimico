package com.hochschild.insumoQuimico.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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
}