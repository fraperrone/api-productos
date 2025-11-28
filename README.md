#  Backend - API Productos

Este proyecto corresponde al **backend** de la aplicación *E-Comerse*, desarrollado en **Java Spring Boot**.

##  Requisitos previos

- **Java 17** (o versión compatible con Spring Boot)
- **Maven** (para compilar y gestionar dependencias)
- **IntelliJ IDEA** (recomendado para abrir y ejecutar el proyecto)
- **MySQL** corriendo en `localhost:3306`

##  Ejecución del proyecto

1. Clonar el repositorio o descargar la carpeta `api-productos`.
2. Abrir el proyecto en **IntelliJ IDEA**.
3. Ejecutar la clase principal ubicada en:

    src/main/java/.../ApiApplication.java

(el archivo con el método `public static void main`).

Esto levantará el servidor en el puerto **8080** por defecto.

##  Configuración de la base de datos

 **IMPORTANTE:**  
La configuración de la conexión a la base de datos **solo se puede realizar en la clase `DatabaseConfig` dentro del paquete `configuration`**, ya que está definida como un **Bean de Spring**.  
No se debe modificar en otro archivo.


- **Host:** `localhost`
- **Puerto:** `3306`
- **Base de datos:** `e-comerse`
- **Usuario:** `root`
- **Password:** ``

### Ejemplo de conexión en `application.properties`

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/e-comerse
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update
