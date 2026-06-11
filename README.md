# MediTurn

Sistema de gestión de turnos médicos desarrollado en Java como proyecto de aprendizaje orientado al desarrollo backend.

## Funcionalidades actuales

* Gestión de pacientes, profesionales y especialidades.
* Reserva, confirmación, cancelación y reprogramación de turnos.
* Validación de reglas de negocio mediante excepciones personalizadas.
* Gestión de turnos utilizando Collections Framework (List y Map).
* Implementación de patrones de diseño Factory Method y Observer.
* Sistema básico de autenticación mediante interfaz Autenticable.
* Conexión a base de datos MySQL mediante JDBC.
* Base de datos relacional diseñada con MySQL (schema.sql incluido en el repositorio).

## Tecnologías utilizadas

* Java 21
* Maven
* MySQL
* JDBC
* Programación Orientada a Objetos
* Collections Framework
* Git y GitHub

## Conceptos aplicados

* Herencia
* Clases abstractas
* Interfaces
* Polimorfismo
* Encapsulamiento
* Excepciones personalizadas
* Factory Method
* Observer

## ⚙️ Configuración del entorno

Este proyecto requiere variables de entorno para conectarse a la base de datos.

Creá un archivo `.env` en la raíz del proyecto con el siguiente contenido:
DB_URL=jdbc:mysql://localhost:3306/mediturndb?serverTimezone=America/Argentina/Mendoza
DB_USER=usuario
DB_PASSWORD=contraseña

Si usás IntelliJ IDEA, podés cargar las variables manualmente en:
`Run > Edit Configurations > Environment Variables`

## Próximos pasos

* Implementación de repositorios con JDBC (base de datos ya creada).
* Transacciones.
* Testing con JUnit y Mockito.
* API REST con Spring Boot.
* Spring Security y JWT.

## Autor

Sabrina Massola
