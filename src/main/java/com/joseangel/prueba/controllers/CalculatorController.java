package com.joseangel.prueba.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/calculator")
public class CalculatorController {

	@GetMapping("/inValores/{val1}/{val2}")
	public Double inValores(@PathVariable String val1, @PathVariable String val2) {
		System.out.println(val1+"---"+val2);
		return 2.12345;
	}

}
