# Restaurant Management API 🍝

## Descripción del Repositorio
Este repositorio contiene el proyecto **Restaurant Management API**, una solución RESTful desarrollada en **Java 17** utilizando el framework **Spring Boot**. La API gestiona operaciones relacionadas con la administración de un restaurante, abarcando clientes, menús, platos, pedidos y reglas de negocio avanzadas.

El objetivo principal es proporcionar un sistema robusto y flexible que cumpla con los principios de diseño RESTful y ofrezca un manejo eficiente de los recursos mediante operaciones CRUD completas, implementación de patrones de diseño y una arquitectura limpia y escalable.

---

## Características
- **Gestión de Clientes:** Crear, listar, actualizar y eliminar información de clientes.
- **Gestión de Menús:** Administración de los menús del restaurante, incluyendo la creación, actualización, eliminación y consulta.
- **Gestión de Platos:** Control sobre los platos, desde su creación hasta la actualización de su estado (plato popular).
- **Gestión de Pedidos:** Registro, consulta, modificación y eliminación de pedidos.
- **Reglas de Negocio:**
  - Clientes frecuentes reciben un 2.38% de descuento en pedidos.
  - Platos populares incrementan su costo en un 5.73%.
- **Patrones de Diseño:** Implementación de los patrones Observer y Chain of Responsibility, entre otros.

---

## Tecnologías y Herramientas
- **Lenguaje:** Java 17
- **Framework:** Spring Boot
- **Gestor de Dependencias:** Gradle
- **ORM:** JPA (Java Persistence API)
- **Base de Datos:** SQL (utilizando Docker para la gestión del contenedor de base de datos)
- **Cliente API:** Postman o Insomnia
- **Contenedores:** Docker

---

## Instalación
### Prerrequisitos
1. Tener instalado **Java 17**.
2. Tener instalado **Gradle**.
3. Tener instalado **Docker**.
4. Contar con Postman o Insomnia para realizar pruebas a los endpoints.

### Pasos
1. Clona este repositorio:
   ```bash
   https://github.com/sebastianbarrerah/restaurant-management


2. cd restaurant-management


3. Establece conexión con base de datos con tus credenciales
spring.datasource.url=jdbc:mysql://localhost:3306/restaurant_db
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update


4. Ejecuta el comando:
```docker-compose up -d
./gradlew bootRun
```

## Diagrama 
![DIAGRAMA_RESTAURANT](https://github.com/user-attachments/assets/6a321c8c-caae-489b-91a4-b233899a9d82)



