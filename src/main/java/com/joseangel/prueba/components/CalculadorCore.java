package com.joseangel.prueba.components;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Component;

import com.joseangel.prueba.pojo.Operators;
import com.joseangel.prueba.util.EventsUtils;

@Component
public class CalculadorCore {

	public BigDecimal solicitudOperacion(Operators operador, List<BigDecimal> numeros) {
		
		switch(operador) {
			case SUMA:
				return this.functionSum(numeros);
			case RESTA:
				return this.functionRes(numeros);
			default:
				return new BigDecimal(0.0);
		}
		
	}
	
	
	private BigDecimal functionSum(List<BigDecimal> nums) {
		BigDecimal resultado=nums.stream().reduce(new BigDecimal(0.0), (a,b) -> a.add(b));
		
		EventsUtils.eventOperationDone("suma", resultado, nums);
		
		return resultado;
	}
	
	private BigDecimal functionRes(List<BigDecimal> nums) {
		//BigDecimal resultado=nums.stream().(new BigDecimal(0.0), (BigDecimal a, BigDecimal b) -> a.subtract(b));
		BigDecimal resultado=new BigDecimal(0.0);
	
		for(int i=0; i<nums.size(); i++) {
			if(i==0) {
				resultado=nums.get(i);
			}
			else {
				resultado=resultado.subtract(nums.get(i));
			}
		}
		
		EventsUtils.eventOperationDone("resta", resultado, nums);
		
		return resultado;
	}
}
