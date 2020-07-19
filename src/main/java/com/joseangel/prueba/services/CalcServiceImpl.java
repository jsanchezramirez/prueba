package com.joseangel.prueba.services;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joseangel.prueba.components.CalculadorCore;
import com.joseangel.prueba.pojo.Operators;
import com.joseangel.prueba.util.EventsUtils;

@Service
public class CalcServiceImpl implements CalcService {

	@Autowired
	CalculadorCore calculador;
	
	@Override
	public Double suma(String ... valores) throws NumberFormatException {
		List<Double> nums=Arrays.asList(valores).stream().map(op -> 
		op==null?0.0:Double.parseDouble(op)).collect(Collectors.toList());
		return this.calculador.solicitudOperacion(Operators.SUMA, nums);
	}
	
	

	@Override
	public Double resta(String... valores) throws NumberFormatException {
		List<Double> nums=Arrays.asList(valores).stream().map(op -> 
		op==null?0.0:Double.parseDouble(op)).collect(Collectors.toList());
		return this.calculador.solicitudOperacion(Operators.RESTA, nums);
	}

}