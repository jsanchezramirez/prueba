package com.joseangel.prueba.controllers;

import java.math.BigDecimal;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joseangel.prueba.exceptions.InvalidInputException;
import com.joseangel.prueba.exceptions.NotImplementationYet;
import com.joseangel.prueba.services.CalcServiceImpl;
import com.joseangel.prueba.util.EventsUtils;

@CrossOrigin
@RestController
@RequestMapping("/calculator")
public class CalculatorController {

	@Autowired
	private CalcServiceImpl calcService;
	
	//Este metodo es para recibir una peticion con dos valores y comprobar que los mismos se reciben correctamente (no como parametro sino como path)
	//Hace una llamada a la utilidad para informar de la llegada de la peticion
	//Hace una llamada a la utilidad para informar de la salida de respuesta
	//Devuelve un valor tipo Double
	@GetMapping("/inValores/{val1}/{val2}")
	public Double inValores(@PathVariable BigDecimal val1, @PathVariable BigDecimal val2) {
		EventsUtils.eventComing(CalculatorController.class, "inValores", val1, val2);
		
		String result=val1+"---"+val2;
		
		EventsUtils.eventOuting(CalculatorController.class, "inValores", result);
		
		return 2.123456;
	}
	
	//Metodo de peticion de suma. Recibe los valores como parametros tal que "/suma?val1=x&val2=y"
	//Hace una llamada a la utilidad para informar de la llegada de la peticion
	//Utiliza el servicio (capa inferior) para realizar la operacion
	@GetMapping("/suma")
	public BigDecimal reqSuma(@PathParam(value = "val1") BigDecimal val1, @PathParam(value = "val2") BigDecimal val2) {
		EventsUtils.eventComing(CalculatorController.class, "reqSuma", val1, val2);
		return this.calcService.suma(val1, val2);
	}

	//Metodo de peticion de resta. Recibe los valores como parametros tal que "/resta?val1=x&val2=y"
	//Hace una llamada a la utilidad para informar de la llegada de la peticion
	//Utiliza el servicio (capa inferior) para realizar la operacion
	@GetMapping("/resta")
	public BigDecimal reqResta(@PathParam(value = "val1") BigDecimal val1, @PathParam(value = "val2") BigDecimal val2) {
		EventsUtils.eventComing(CalculatorController.class, "reqSuma", val1, val2);
		return this.calcService.resta(val1, val2);
	}
	
	//Metodo de peticion de multiplicacion. Referenciado para usos futuros. Al no estar implementado lanza la excepcion pertinente
	@GetMapping("/multiplicacion")
	public BigDecimal reqMultiplicacion(@PathParam(value = "val1") BigDecimal val1, @PathParam(value = "val2") BigDecimal val2) {
		//return this.calcService.multiplicacion(val1,val2);
		throw new NotImplementationYet("/multiplicacion - no implementado");
	}
	
	//Metodo de peticion de division. Referenciado para usos futuros. Al no estar implementado lanza la excepcion pertinente
	@GetMapping("/division")
	public BigDecimal reqDivision(@PathParam(value = "val1") BigDecimal val1, @PathParam(value = "val2") BigDecimal val2) {
		//return this.calcService.division(val1,val2);
		throw new NotImplementationYet("/division - no implementado");
	}
	
	//Metodo de peticion de modulo (resto de la division entre un numero y otro). Referenciado para usos futuros. Al no estar implementado lanza la excepcion pertinente
	@GetMapping("/modulo")
	public BigDecimal reqModulo(@PathParam(value = "val1") BigDecimal val1, @PathParam(value = "val2") BigDecimal val2) {
		//return this.calcService.modulo(val1,val2);
		throw new NotImplementationYet("/modulo - no implementado");
	}
	
}
