x# FROL


## Tabla de Contenidos

  - [Descripción del Proyecto](#descripción-del-proyecto)
  - [¿Cómo Surgió?](#cómo-surgió)
  - [Objetivos](#objetivos)
  - [Alcance](#alcance)
  - [Instalación](#instalación)
    - [Prerrequisitos](#prerrequisitos)
    - [Paso 1: Clonar el Repositorio](#paso-1-clonar-el-repositorio)
    - [Paso 2: Compilar el Proyecto](#paso-2-compilar-el-proyecto)
    - [Paso 3: Configurar el IDE](#paso-3-configurar-el-ide)
    - [Paso 4: Configurar la Base de Datos](#paso-4-configurar-la-base-de-datos)
  - [Diagramas](#diagramas)
    - [Bases de datos](#bases-de-datos)
    - [Clases](#clases)
    - [Arquitectura](#arquitectura)
  - [Integrantes](#integrantes)
  - [Enlaces](#enlaces)

## Descripción del Proyecto

Este proyecto consiste en brindar una herramienta organizacional donde las partes, por medio de nuestro sitio web, acuerden la ejecución de la acción. El prestador de servicios podrá brindar información detallada, como lo es: Nombre, ubicación, redes sociales, servicios, paquetes, promociones, disponibilidad, precios, entre otros. El cliente tendrá acceso a dicha información, beneficiando a ambas partes, ya que el tiempo es un bien no material que todos queremos aprovechar de la mejor manera, y qué mejor que tener un horario definido para cumplir.

## ¿Cómo Surgió?

Esta iniciativa surgió de la necesidad de evitar la obligación de ir hasta el lugar prestador del servicio o, en su defecto, llamar o escribir para hacer una reserva. Muchas veces, la poca disponibilidad impide acceder al servicio de inmediato, o se puede acceder pero un par de horas después. Además, la persona que presta el servicio debe detener su trabajo para agendar dichas reservas, perdiendo tiempo que podría ser empleado en otro cliente.

## Objetivos

- Dar visibilidad a las empresas prestadoras de servicios que estén a la altura y alcance del cliente para beneficio mutuo, pues en muchos casos necesitamos del servicio lo más pronto posible o incluso inmediatamente.
- Captar la gran mayoría de emprendimientos para implementar un tipo de membresía para brindar nuestros servicios.
- Ser el primer sitio web implementado para la organización en tiempo real de reservas y tiempos estimados para el servicio inmediatamente próximo.

## Alcance

Queremos llegar a ser un sitio web donde los prestadores de servicios de pequeñas y medianas empresas sean visibles para el mercado, optimizando y organizando su tiempo para cubrir las expectativas del cliente.


## Instalación

Sigue estos pasos para instalar y configurar el proyecto en Java:

### Prerrequisitos

Asegúrate de tener instalados los siguientes componentes:

- [JDK (Java Development Kit) 11+](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Apache Maven](https://maven.apache.org/install.html)
- Un IDE para Java como [IntelliJ IDEA](https://www.jetbrains.com/idea/download/) o [Eclipse](https://www.eclipse.org/downloads/)

### Paso 1: Clonar el Repositorio

Clona el repositorio del proyecto desde GitHub:


git clone https://github.com/tu_usuario/tu_proyecto.git
`
*cd tu_proyecto*
<br>

### Paso 2: Compilar el Proyecto

- Navega al directorio del proyecto y usa Maven para compilarlo:


mvn clean install

### Paso 3: Configurar el IDE
- IntelliJ IDEA:

Abre IntelliJ IDEA.
- Selecciona File > Open... y navega al directorio del proyecto.
IntelliJ IDEA detectará el proyecto Maven y lo importará automáticamente.

### Paso 4: Configurar la Base de Datos
- Configura tu base de datos en el archivo src/main/resources/application.properties.
-  Asegúrate de actualizar los valores correspondientes a tu *configuración de base de datos:*

#### properties

spring.datasource.url=jdbc:mysql://localhost:3306/tu_base_de_datos
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update


## Diagramas
### Bases de datos 
![Bases de datos](image.png)
### Clases
![Clases](image-1.png)
### Arquitectura
![Arquitectura](image-2.png)

## Integrantes

- Cristian Camilo Velásquez Cárdenas
- Estivenson Alejandro Estrada Naranjo
- Sebastian
- Thomas
- Luis Foronda

## Enlaces

- [Trello](https://trello.com/b/i2e412fs/frol)
- [Front](https://github.com/XtianCarde/FROL-FRONT.git)
- [Auth-NestJs](https://github.com/SebasRojasM1/API-Project)
- [Documentación Swagger](http://localhost:8080/api/v1/swagger-ui/index.html)
