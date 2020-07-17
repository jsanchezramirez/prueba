package com.joseangel.prueba.controllers;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joseangel.prueba.exceptions.InvalidInputException;
import com.joseangel.prueba.services.CalcServiceImpl;
import com.joseangel.prueba.util.EventsUtils;

@CrossOrigin
@RestController
@RequestMapping("/calculator")
public class CalculatorController {

	@Autowired
	private CalcServiceImpl calcService;
	
	@GetMapping("/inValores/{val1}/{val2}")
	public Double inValores(@PathVariable String val1, @PathVariable String val2) {
		EventsUtils.eventComing(CalculatorController.class, "inValores", val1, val2);
		
		String result=val1+"---"+val2;
		
		EventsUtils.eventOuting(CalculatorController.class, "inValores", result);
		
		return 2.123456;
	}
	
	@GetMapping("/suma")
	public Double reqSuma(@PathParam(value = "val1") String val1, @PathParam(value = "val2") String val2) {
		EventsUtils.eventComing(CalculatorController.class, "reqSuma", val1, val2);
		
		try{
			return this.calcService.suma(val1, val2);
		}
		catch(NumberFormatException e) {
			EventsUtils.traceException(e);
			throw new InvalidInputException("Non-numeric or invalid input parameter");
		}
	}

	@GetMapping("/resta")
	public Double reqResta(@PathParam(value = "val1") String val1, @PathParam(value = "val2") String val2) {
		//return this.calcService.resta(val1,val2);
		return null;
	}
	
	@GetMapping("/multiplicacion")
	public Double reqMultiplicacion(@PathParam(value = "val1") String val1, @PathParam(value = "val2") String val2) {
		//return this.calcService.multiplicacion(val1,val2);
		return null;
	}
	
	@GetMapping("/division")
	public Double reqDivision(@PathParam(value = "val1") String val1, @PathParam(value = "val2") String val2) {
		//return this.calcService.division(val1,val2);
		return null;
	}
	@GetMapping("/modulo")
	public Double reqModulo(@PathParam(value = "val1") String val1, @PathParam(value = "val2") String val2) {
		//return this.calcService.modulo(val1,val2);
		return null;
	}
	
}
