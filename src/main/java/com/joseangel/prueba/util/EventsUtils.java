package com.joseangel.prueba.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import io.corp.calculator.TracerImpl;


public class EventsUtils {

	
	public static void eventComing(Class<? extends Object> cl) {
		TracerImpl tracer=new TracerImpl();
		
		Calendar c=Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
		String hora=(df.format(c.getTime()));
		tracer.trace("NUEVA PETICION A LAS "+hora+" AL CONTROLLER "+cl.toString());
	}
	
	public static void eventComing(Class<? extends Object> cl, String method, String... args) {
		TracerImpl tracer=new TracerImpl();
		
		Calendar c=Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
		String hora=(df.format(c.getTime()));
		tracer.trace("NUEVA PETICION A LAS "+hora+" AL CONTROLLER "+cl.toString()+" METHOD "+method+" Y PARAMETROS "+args);
	}
	
	public static void eventOuting(Class<? extends Object> cl, String method, String... args) {
		TracerImpl tracer=new TracerImpl();
		
		Calendar c=Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
		String hora=(df.format(c.getTime()));
		tracer.trace("SALIDA PETICION A LAS "+hora+" DESDE EL CONTROLLER "+cl.toString()+" METHOD "+method+" Y SALIDA "+args);
	}
	
	public static void traceException(RuntimeException e) {
		TracerImpl tracer=new TracerImpl();
		tracer.trace(e);
	}
	
	public static void eventOperationDone(String operacion, Double resultado, List<Double> parametros) {
		TracerImpl tracer=new TracerImpl();
		tracer.trace("DONE: "+operacion+" - RESULTADO: "+resultado+" - ARGUMENTOS: "+parametros);
	}
}