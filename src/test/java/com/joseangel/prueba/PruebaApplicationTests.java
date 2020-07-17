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

import com.joseangel.prueba.controllers.CalculatorController;
import com.joseangel.prueba.controllers.Controller;
import com.joseangel.prueba.services.CalcServiceImpl;


public class PruebaApplicationTests {

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
			c1.suma("ppp", "1.2");
		});
	}
	
	@Test
	@DisplayName("Prueba Suma Tipo Resultado")
	void testSumaSalida() {
		CalcServiceImpl c1=new CalcServiceImpl();
		Double resultado=c1.suma("1.5","1.0");
		assertEquals(resultado.doubleValue(), 2.5d);
	}

}
