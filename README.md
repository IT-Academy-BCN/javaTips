
# javaTips Project

Proyecto modular Gradle con algunos tips y demos ;)

#### Ejecución de los ejemplos

Ejecución global de todos los módulos (por línea de comandos o a través del IDE que utilices): invocación de la task <b>run</b> de Gradle. 
- Linux / macOS
``` 
 ./gradlew run
```
- Windows
```
gradlew.bat run
```

Ejecución de cada módulo:

- Linux / macOS
``` 
 ./gradlew :[nombreModulo]:run
```
- Windows
```
gradlew.bat :[nombreModulo]:run
```

#### Módulos

- <b>Callback Pattern</b>: Breve demo de patrón callback
- <b>Properties</b>: Carga de fichero externo con propiedades. Acceso a propiedades del sistema
- <b>Bubble</b>: Método de la burbuja (algoritmo de ordenación)
- <b>Streams</b>: Uso de Streams (introducido en Java8), y diferencias con Java8-
- <b>Lambdas</b>: Breve introducción al uso de lambda functions en Java
- <b>Reflection</b>: Demo de uso de API Reflection para acceso a propiedades internas de los objetos Java
- <b>Inner Classes</b>: Breve demo de utilización de clases internas en Java 
- <b>Enumerations</b>: Enum demo
- <b>Restaurant</b>: Demo de utilización de threads productor-consumidor
