1. En primer lugar creo un nuevo proyecto desde Spring Tool Suite (entorno de desarrollo que usaré). Lo hago desde el asistente SpringStarterProject.

2. Diseño el modelo de paquete (estructura del proyecto): el paquete con el bean "principal" SpringBootApplication esta en el paquete base com.joseangel.prueba y, a partir de esta 
nomenclatura partiran el resto de paquetes (com.joseangel.prueba.controllers, com.joseangel.prueba.services, etc).

3. Una vez ya tengo el proyecto reviso y añado al pom.xml las dependencias que necesito y paso a ejecutar la aplicacion como SpringBootApp. En este paso añado un Controller de prueba
para comprobar que el server responde a peticiones (a modo de "hola mundo").

4. Hago uso de Postman (herramienta que usaré para hacer peticiones al servicio) y compruebo haciendo petición GET: localhost:8080/api/test/

5. Llegados a este punto me dispongo a formar el paquete controller añadiendo un nuevo controlador llamado CalculatorController. Este, será el controlador rest "principal" de la calculadora, 
se encargará de procesar las peticiones en funcion del tipo de operación solicitada para, posteriormente, hacer llamadas a servicios.

6. Creo el paquete "pojo" para alojar beans (clases) de cara a utilizarlas como parametros de llegada así como para usos futuros.

7. En el controlador creo el método "inValores" como prueba de que llegan correctamente los valores en la petición recibida.

8. En el controlador creo el método "reqSuma", será el encargado de procesar las peticiones de operaciones suma. Estará preparado para recibir dos valores por parámetros de URL.

9. Replico métodos según operaciones que veo basicas para una calculadora, de cara a una posible ampliación, para que se pueda apreciar la línea de desarrollo a seguir.

10. Creo el paquete "services" para alojar el/los servicios de negocio, es decir, la capa encargada de la comprobacion y procesamiento de los valores procedentes del controlador según los 
requerimientos deseados.

11. Creación del Service CalcServiceImpl que sera utilizado por la capa superior.

12. Creo el método suma en el servicio, este mismo, se encarga de realizar la operacion de suma contemplando la excepción ya que puede que alguno de los valores procedentes no sean
numéricos. Para este caso, y pensando en que en un futuro podremos tener más de dos valores, se implementa haciendo uso de expresiones lambda de Java8 de cara ha hacerlo lo más generico 
posible y además evitando extensas comprobaciones de multiples lineas de codigo.

13. Excepción propia. Para cuando se dé el tipo de excepción que comentaba anteriormente, así como alguna de la línea de parámetro de entrada invalido, 
me creo la excepción InvalidInputException.

14. Tracer. Añado al proyecto la librería tracer-1.0.0.jar.

15. Tracer. Utilizo la librería en el CalculatorController para: pintar excepciones, pintar llegada de peticion y respuesta de salida. Su uso lo encapsulo en en una clase de utilidad 
llamada EventsUtils contenida en el paquete utils.

16. JUnit5. Realizo pruebas de diversa índole para testear tanto controlador como servicio.