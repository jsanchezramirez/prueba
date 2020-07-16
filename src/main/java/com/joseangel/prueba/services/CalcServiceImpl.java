package com.joseangel.prueba.services;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class CalcServiceImpl implements CalcService {

	@Override
	public Double suma(String ... valores) throws NumberFormatException {
		
		List<Double> nums=Arrays.asList(valores).stream().map(op -> 
			op==null?0.0:Double.parseDouble(op)).collect(Collectors.toList());
		
		return nums.stream().reduce(0.0, (a,b) -> a+b);
	}

}