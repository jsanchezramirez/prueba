Requisitos previos (software necesario para desarrollo y posterior ejecución y uso de la app):

	- Instalación de JDK versión 8 
	- Instalación de Spring Tools Suite (por ejemplo la ultima version 4) (el Maven lo lleva embebido): basta con descomprimir el contenido una vez descargado y ejecutar el .exe
	- Postman

1. En primer lugar creo un nuevo proyecto desde Spring Tool Suite (entorno de desarrollo que usaré). Lo hago desde el asistente SpringStarterProject.

2. Una vez ya tengo el proyecto creado en el entorno, reviso y añado al pom.xml las dependencias que necesito: SpringWeb, SpringTest, JUnit5, SpringDevTools.

3. Diseño el modelo de paquetes (estructura del proyecto): el paquete con el bean "principal" SpringBootApplication es com.joseangel.prueba y, a partir de esta 
nomenclatura partiran el resto de paquetes (com.joseangel.prueba.controllers, com.joseangel.prueba.services, etc).

4. Paso a ejecutar la aplicacion como SpringBootApp. En este paso añado un Controller de prueba para comprobar que el server responde a peticiones (a modo de "hola mundo").

5. Hago uso de Postman (herramienta que usaré para hacer peticiones al servicio) y compruebo haciendo petición GET: localhost:8080/api/test/.

6. Llegados a este punto me dispongo a formar el paquete controller añadiendo un nuevo controlador llamado CalculatorController. Este, será el controlador rest "principal" de la 
calculadora, se encargará de procesar las peticiones en funcion del tipo de operación solicitada para, posteriormente, hacer llamadas a servicios.

7. Creo el paquete "pojo" para alojar beans (clases) de cara a utilizarlas para usos futuros.

8. En el controlador creo el método "inValores" como prueba de que llegan correctamente los valores en la petición recibida.

9. En el controlador creo el método "reqSuma", será el encargado de procesar las peticiones de operaciones suma. Estará preparado para recibir dos valores por parámetros de URL.
Creo el método "reqResta" para procesar las peticiones de resta. Igualmente preparado para recibir dos valores.

10. Replico métodos según operaciones que veo basicas para una calculadora, de cara a una posible ampliación, para que se pueda apreciar la línea de desarrollo a seguir.

11. Creo el paquete "services" para alojar el/los servicios de negocio, es decir, la capa encargada de la comprobacion y procesamiento de los valores procedentes del controlador según los 
requerimientos deseados.

12. Creación del Service CalcServiceImpl que sera utilizado por la capa superior.

13. Creo los métodos de suma y resta en el servicio. Aquí, me encargo de verificar los parametros de llegada, en este caso comprobando nulos 
y al mismo tiempo formando el List para hacer la solicitud de operación, haciendo uso de expresiones lambda de Java8. 
Para este caso, y pensando en que en un futuro podremos tener más de dos valores, se implementa haciendo uso de expresiones lambda de Java8 de cara ha hacerlo lo más generico 
posible y además evitando extensas comprobaciones de multiples lineas de codigo.

14. Componente CalculadorCore. El servicio, por un lado se encarga, como comentaba, de tener los numeros preparados para, posteriormente, hacer una solicitud operacional al componente 
que nos creamos. Para ello, y de cara a tener un método genérico publico, implemento solicitudOperacion() en el componente. Con el mismo, hacemos uso de un Enum, para indicar el tipo 
de operación que solicitamos (que además haciendolo de esta forma nos aseguramos de solicitar una operacion que se contemple en la lista de operaciones permitidas). Pensando en usos 
futuros, de que pueda haber no sólo dos valores a calcular sino más, este método solicitudOperacion() recibe un List<Double>, que puede ser de cualquier tamaño.

15. El @Component CalculadorCore, haciendo uso de métodos privados, se encarga de realizar las operaciones de suma y resta.

16. Excepción propia. Para cuando se dé el tipo de excepción de valor no numérico, así como alguna de la línea de parámetro de entrada invalido, 
me creo la excepción InvalidInputException. Si lo analizamos desde un punto de vista de robustez, creando nuestras propias excepciones, dotamos al controlador de un manejo y contemplación 
de excepciones muy interesante, sobre todo por la funcionalidad @ResponseStatus que nos ofrece el framework, que hace las respuestas a modo de error mucho más legibles y manejables 
para el cliente del microservicio. (Actualmente no hago uso de la misma, simplemente dejo en manos del framework que lance el error http 400 en caso de llegada de parámetros invalidos 
al controlador).

17. Además me creo la excepcion propia NotImplementationYet, para usarla en el controlador a modo de informar de que algunas peticiones no están implementadas.

18. Tracer. Añado al proyecto (workspace) la librería tracer-1.0.0.jar.

19. Tracer. Utilizo la librería en el CalculatorController para: pintar excepciones, pintar llegada de peticion, respuestas de salida y cuando se calcula resultado de alguna operación 
matemática. Su uso lo encapsulo en en una clase de utilidad llamada EventsUtils contenida en el paquete utils.

20. JUnit5. Realizo pruebas de diversa índole para testear tanto controlador como servicio.

21. Antes de hacer la construcción para generar el .jar de la app, añado la librería tracer de manera "oficial" con Maven. Para ello ejecuto el siguiente comando de maven. Yo lo 
ejecuto haciendo click en Run Configurations, Maven, New Configuration y en Goal pongo lo siguiente y por ultimo hago Run: 
install:install-file -Dfile="C:\ruta_personal\tracer-1.0.0.jar" -DgroupId=io.corp.calculator -DartifactId=tracer -Dversion=1.0
Posteriormente le hago referencia a través de un <dependency> de Maven en el pom.xml.

Ejecución:

- Al descargar de github como .zip, descomprimimos en un directorio workspace y renombramos la carpeta de "prueba-master" a "prueba", a modo de conservar el nombre original del project.

- Iniciamos Spring Tool Suite haciendo referencia a la ruta del workspace y hacemos click en File->Import->Existing Projects Into Workspace. En Browse seleccionamos nuestro proyecto 
llamado "prueba" y Finish.

- Realizar paso 21 para agregar la librería local de tracer. No sería necesario hacer la última parte de agregar la dependency al pom.xml porque ya está referenciada.

- Modo de ejecución 1: hacer click derecho en el project y hacer Run As "Spring Boot App".

- Modo de ejecución 2: ejecuto el comando Maven build package, el cual me genera el .jar del proyecto en el directorio \target y, una vez está listo el .jar, abro una 
consola en la ruta donde este se encuentra y ejecuto el siguiente comando: Java -jar prueba-0.0.1-SNAPSHOT.jar


Ejemplos de llamadas a la API (desde Postman):

GET http://localhost:8080/api/test

GET http://localhost:8080/calculator/inValores/2.0/7.2

GET http://localhost:8080/calculator/suma

GET http://localhost:8080/calculator/suma?val1=2.777&val2=2.0

GET http://localhost:8080/calculator/suma?val1=2.777ret

GET http://localhost:8080/calculator/resta

GET http://localhost:8080/calculator/resta?val1=1500.50&val2=3000

GET http://localhost:8080/calculator/resta?val1=9&val2=7.58letras

GET http://localhost:8080/calculator/division

