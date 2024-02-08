package com.vehiculo.service.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilitario {
	
	public static Date convertStringToDate(String fecha,String formato) {
		SimpleDateFormat sdf = new SimpleDateFormat(formato);
		Date fechaParseada=null;
		try {
			fechaParseada = sdf.parse(fecha);
		} catch (ParseException e) {
			System.out.println("Error al convertir String a fecha");
			e.printStackTrace();
		}
		return fechaParseada;
	}
	
	public static String convertDateToString(Date fecha,String formato) {
		SimpleDateFormat sdf = new SimpleDateFormat(formato);
		String fechaFormateada = sdf.format(fecha);
		return fechaFormateada;
	}

}
