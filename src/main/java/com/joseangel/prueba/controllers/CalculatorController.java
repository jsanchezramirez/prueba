package com.joseangel.prueba.controllers;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joseangel.prueba.services.CalcServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/calculator")
public class CalculatorController {

	@Autowired
	private CalcServiceImpl calcService;
	
	@GetMapping("/inValores/{val1}/{val2}")
	public Double inValores(@PathVariable String val1, @PathVariable String val2) {
		System.out.println(val1+"---"+val2);
		return 2.12345;
	}
	
	@GetMapping("/suma")
	public Double reqSuma(@PathParam(value = "val1") String val1, @PathParam(value = "val2") String val2) {
		return this.calcService.suma(val1, val2);
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
