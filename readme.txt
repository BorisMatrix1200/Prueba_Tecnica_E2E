===================================================
INSTRUCCIONES DE EJECUCIÓN DEL PROYECTO
===================================================

1. PRERREQUISITOS
=================
- Java JDK 17 instalado y configurado en el PATH.
  - Adicional configurar el JAVA_HOME y el MAVEN_HOME
- Maven 3.8+ instalado y configurado en el PATH.
- Google Chrome instalado (última versión estable).
- ChromeDriver manejado automáticamente por WebDriverManager.
- Acceso a internet para descargar dependencias Maven en la primera ejecución.
- Instalar el IDE deseado (Para este caso Intellij IDEA)
- En el IDE instalar en la opción Settings - Plugins - Marketplace los plugins: 
  - Cucumber for Java
  - Gherkin
  - Git 
  - Maven 
  - SonarQube

2. CLONAR EL PROYECTO
===================
Ejecutar en consola:
    git clone <https://github.com/BorisMatrix1200/Prueba_Tecnica_E2E.git>
    cd <CARPETA_DEL_PROYECTO>
- Validar que todas las dependencias se descarguen correctamente 

3. ESTRUCTURA DEL PROYECTO
==========================
El proyecto sigue el patrón Screenplay con Serenity BDD:
- src/main/java: 
  - interactions = Acciones atómicas reutilizables que un actor puede realizar, más pequeñas que una Task. Ejemplo: hacer scroll, esperar a que un elemento sea      		   visible, presionar una tecla específica.
  - models       = Clases que representan datos o entidades del dominio de la prueba. Ejemplo: un Cliente, un Producto, credenciales de usuario. Se usan     		   	   para pasar datos entre pasos.
  - questions    = Consultas que realiza el actor para verificar el estado del sistema. Devuelven un valor que se usará en las aserciones. Ejemplo: obtener el 			   texto de un elemento, contar ítems en un carrito.
  - runners      = Clases que ejecutan las pruebas. Normalmente anotadas con @RunWith(CucumberWithSerenity.class) y configuran la ubicación de features y 			   stepdefinitions.
  - stepdefinitions = Implementación en Java de los pasos definidos en Gherkin (Given, When, Then). Aquí se llama a tasks, interactions y questions.
  - tasks        = Acciones de alto nivel que un actor realiza para cumplir un objetivo. Se construyen combinando interactions. Ejemplo: "Login" podría incluir 		   abrir la página, ingresar usuario y contraseña, y hacer clic en login.
  - ui           = Clases que contienen los selectores (Target) de la interfaz de usuario. Se mantienen separados para centralizar el mantenimiento de 				   localizadores.
  - utils        = Utilidades y funciones de ayuda que no dependen directamente de la lógica Screenplay. Ejemplo: leer archivos, formatear fechas, generar datos 		   aleatorios.
- src/main/resourses:
  - features
  - screenshots
- target
  - serenity-reports - index.html
- gitignore
- azure-pipelines.yml - Se utiliza para la integración continua en este caso con Azure Pipelines
- pom.xml
- serenity.conf
- serenity.properties 

Resumen visual de la lógica:

- ui = Dónde está el elemento.

- tasks / interactions = Qué hace el actor.

- questions = Qué verifica el actor.

- stepdefinitions = Conecta el lenguaje natural con el código.

- features = La historia escrita en Gherkin.

- runners = Ejecutan todo.

- target = Guarda reportes y resultados.


4. CONFIGURACIÓN DE EJECUCIÓN
=============================
En `serenity.conf`, asegurar que se incluyen las preferencias para desactivar
el gestor de contraseñas de Chrome y evitar popups nativos.

Ejemplo:
chrome {
  switches = ["--disable-save-password-bubble"]
  preferences {
    "credentials_enable_service" = false
    "profile.password_manager_enabled" = false
  }
}

5. EJECUCIÓN DE LAS PRUEBAS
===========================
Para ejecutar todas las pruebas:
    mvn clean verify

Para ejecutar un feature específico:
    mvn clean verify -Dcucumber.filter.tags="@NombreTag"

También se puede hacer 
    clic derecho sobre la clase LoginTestRunner en la opción Run'LoginTestRunner'

6. REPORTES
=======================
Para generar los reportes de forma manual, en la parte derecha del IDE existe una opción de Maven con la letra (M)
Abrir esta opción 
- Plugins
  - serenity 
Ejecutar:
- serenity:clear-history
- serenity:aggregate
- serenity:reports

Al finalizar la ejecución, abrir:
  - target
    - serenity-reports - index.html

El reporte incluye:
- Resumen de escenarios ejecutados.
- Capturas de pantalla paso a paso.
- Detalles de errores y tiempos de ejecución.

En la ruta
- resourses/screenshots
Se encuentran los screenshots de cada paso en la ejecución de las pruebas con sus respectivos nombres

========
7. NOTAS
========
- No es necesario instalar ChromeDriver manualmente, ya que este esta configurado para usar automáticamente la    versión mas reciente disponible
- Si aparece un popup del gestor de contraseñas de Chrome, verificar que las
  preferencias en `serenity.conf` están correctamente configuradas.
