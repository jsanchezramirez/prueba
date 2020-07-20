package com.joseangel.prueba.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joseangel.prueba.util.EventsUtils;

@CrossOrigin
@RestController
@RequestMapping("/api/test")
public class Controller {

	//Metodo que recibe la petición de testeo principal. Simplemente recibe la llamada y devuelve la cadena "Hola mundo"
	@GetMapping("")
	public String getTest(){
		EventsUtils.eventComing(Controller.class);
		
		return "Hola mundo";
	}

	
	
}
