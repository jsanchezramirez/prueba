package com.joseangel.prueba.services;

import java.math.BigDecimal;
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
	
	//Con la expresion lambda creo el list de BigDecimal excluyendo valores nulos
	@Override
	public BigDecimal suma(BigDecimal ... valores) {
		List<BigDecimal> nums=Arrays.asList(valores).stream().map(op -> 
		op==null?new BigDecimal(0.0):op).collect(Collectors.toList());
		return this.calculador.solicitudOperacion(Operators.SUMA, nums);
	}
	
	
	//Con la expresion lambda creo el list de BigDecimal excluyendo valores nulos
	@Override
	public BigDecimal resta(BigDecimal... valores) {
		List<BigDecimal> nums=Arrays.asList(valores).stream().map(op -> 
		op==null?new BigDecimal(0.0):op).collect(Collectors.toList());
		return this.calculador.solicitudOperacion(Operators.RESTA, nums);
	}

}