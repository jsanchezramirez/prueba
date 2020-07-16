package com.joseangel.prueba.services;

import org.springframework.stereotype.Service;

@Service
public class CalcServiceImpl implements CalcService {

	@Override
	public Double suma(String ... valores) {
		
		System.err.println(valores);
		
		return null;
	}

}