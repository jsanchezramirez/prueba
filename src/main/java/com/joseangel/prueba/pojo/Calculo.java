package com.joseangel.prueba.pojo;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Calculo {
	
	private List<Double> valores;

	
	public Calculo() {
		super();
	}


	public Calculo(List<Double> valores) {
		super();
		this.valores = valores;
	}


	public List<Double> getValores() {
		return valores;
	}


	public void setValores(List<Double> valores) {
		this.valores = valores;
	}


	@Override
	public String toString() {
		return "Calculo [valores=" + valores + "]";
	}


	
	
}