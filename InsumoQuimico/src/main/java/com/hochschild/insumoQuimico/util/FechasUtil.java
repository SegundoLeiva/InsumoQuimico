package com.hochschild.insumoQuimico.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
}