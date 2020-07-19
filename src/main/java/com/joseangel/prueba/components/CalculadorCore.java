package com.joseangel.prueba.components;

import java.util.List;

import org.springframework.stereotype.Component;

import com.joseangel.prueba.pojo.Operators;
import com.joseangel.prueba.util.EventsUtils;

@Component
public class CalculadorCore {

	public Double solicitudOperacion(Operators operador, List<Double> numeros) {
		
		switch(operador) {
			case SUMA:
				return this.functionSum(numeros);
			case RESTA:
				return this.functionRes(numeros);
			default:
				return 0.0;
		}
		
	}
	
	
	private Double functionSum(List<Double> nums) {
		Double resultado=nums.stream().reduce(0.0, (a,b) -> a+b);
		
		EventsUtils.eventOperationDone("suma", resultado, nums);
		
		return resultado;
	}
	
	private Double functionRes(List<Double> nums) {
		Double resultado=0.0;
	
		for(int i=0; i<nums.size(); i++) {
			if(i==0) {
				resultado=nums.get(i);
			}
			else {
				resultado-=nums.get(i);
			}
		}
		
		EventsUtils.eventOperationDone("resta", resultado, nums);
		
		return resultado;
	}
}
