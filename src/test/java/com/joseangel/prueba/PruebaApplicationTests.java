package com.joseangel.prueba;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
		assertNotEquals(c1.inValores(new BigDecimal(0.5), new BigDecimal(2.66)), "");
		assertEquals(c1.inValores(new BigDecimal(1.2), new BigDecimal(4.77)).doubleValue(), 2.123456d);
	}
	
	@Test
	@DisplayName("Prueba Suma Parametros Entrada Exception Number")
	void testSumaEntradaExceptionNumber() {
		assertThrows(NumberFormatException.class, () -> {
			calcService.suma(new BigDecimal(""), new BigDecimal(""));
		});
	}
	
	@Test
	@DisplayName("Prueba Suma Tipo Resultado")
	void testSumaSalida() {
		BigDecimal resultado=calcService.suma(new BigDecimal(1.5),new BigDecimal(1.0));
		assertEquals(resultado, new BigDecimal(2.5));
	}
	
	@Test
	@DisplayName("Prueba Resta Parametros Entrada Exception Number")
	void testRestaEntradaExceptionNumber() {
		assertThrows(NumberFormatException.class, () -> {
			calcService.resta(new BigDecimal("ppp"), new BigDecimal(17.0));
		});
	}
	
	@Test
	@DisplayName("Prueba Resta Tipo Resultado")
	void testRestaSalida() {
		BigDecimal resultado=calcService.resta(new BigDecimal(25000.50),new BigDecimal(3000.75));
		assertEquals(resultado, new BigDecimal(21999.75));
	}

}
