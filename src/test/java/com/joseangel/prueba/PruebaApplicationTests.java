package com.joseangel.prueba;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.joseangel.prueba.components.CalculadorCore;
import com.joseangel.prueba.controllers.CalculatorController;
import com.joseangel.prueba.controllers.Controller;
import com.joseangel.prueba.services.CalcServiceImpl;


@SpringBootTest
public class PruebaApplicationTests {

	@Autowired
	private CalcServiceImpl calcService;
	
	
	@Test
    @DisplayName("Prueba Status Service")
	@Disabled("este test no se ejecuta")
    void testHttpStatus() {
		// Given
		HttpURLConnection connection = null;
	    String uri="http://localhost:8080/";
	 
	    try {
            URL url = new URL(uri);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/xml");
            System.out.println(connection.getInputStream());
        }
	    catch (MalformedURLException e) {
            //LOGGER.error("internal error", e);
        }
	    catch (IOException e) {
            //LOGGER.error("internal error", e);
        }
	    finally {
            if (connection != null) {
                connection.disconnect();
            }
        }

    }
	
	@Test
	@DisplayName("Prueba Hello World")
	void testHelloWorld() {
		Controller c1=new Controller();
		assertNotNull(c1.getTest());
		assertNotEquals(c1.getTest(), "");
		assertEquals(c1.getTest(),"Hola mundo");
	}
	
	@Test
	@DisplayName("Prueba Parametros Resultado")
	void testParametros() {
		CalculatorController c1=new CalculatorController();
		assertNotEquals(c1.inValores("ppp", "12"), "");
		assertEquals(c1.inValores("1.2", "4,77").doubleValue(), 2.123456);
	}
	
	@Test
	@DisplayName("Prueba Suma Parametros Entrada Exception Number")
	void testSumaEntradaExceptionNumber() {
		CalcServiceImpl c1=new CalcServiceImpl();
		assertThrows(NumberFormatException.class, () -> {
			calcService.suma("ppp", "1.2");
		});
	}
	
	@Test
	@DisplayName("Prueba Suma Tipo Resultado")
	void testSumaSalida() {
		CalcServiceImpl c1=new CalcServiceImpl();
		Double resultado=calcService.suma("1.5","1.0");
		assertEquals(resultado.doubleValue(), 2.5d);
	}
	
	@Test
	@DisplayName("Prueba Resta Parametros Entrada Exception Number")
	void testRestaEntradaExceptionNumber() {
		CalcServiceImpl c1=new CalcServiceImpl();
		assertThrows(NumberFormatException.class, () -> {
			calcService.resta("ppp", "17.0");
		});
	}
	
	@Test
	@DisplayName("Prueba Resta Tipo Resultado")
	void testRestaSalida() {
		CalcServiceImpl c1=new CalcServiceImpl();
		Double resultado=calcService.resta("25000.0","17800.80");
		assertEquals(resultado.doubleValue(), 25000d-17800.80d);
	}

}
