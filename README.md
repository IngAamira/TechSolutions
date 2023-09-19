# Proyecto de Comercio Electrónico para TechSolutions

Este es un proyecto de comercio electrónico desarrollado en Java utilizando Spring Boot. La aplicación implementa funcionalidades clave para gestionar productos, pedidos, usuarios y el proceso de compra en línea.

## Descripción

Este proyecto busca proporcionar una plataforma de comercio electrónico robusta y fácil de usar que permita a los usuarios explorar una variedad de productos, agregarlos a su carrito de compra, realizar pedidos y realizar un seguimiento de sus compras anteriores. Además, se incluye un panel de administración para gestionar productos y pedidos.

## Arquitectura

El proyecto sigue una arquitectura de aplicaciones web basada en el patrón Modelo-Vista-Controlador (MVC), junto con capas de servicio y persistencia de datos. Se enfoca en mantener una separación clara entre las distintas responsabilidades y utiliza mappers para convertir entre las entidades de la base de datos y los objetos del modelo de dominio.

## Características Principales

- Gestión de productos: Los administradores pueden crear, editar y eliminar productos con detalles como nombre, descripción, imagen y precio.

- Carrito de compra: Los usuarios pueden explorar productos y agregarlos a su carrito de compra. Pueden ajustar las cantidades y eliminar productos.

- Proceso de pedido: Los usuarios pueden revisar su carrito, generar un resumen detallado del pedido y realizar la compra en línea.

- Autenticación y registro de usuarios: Los usuarios pueden registrarse en la plataforma, lo que les permite guardar su información y acceder a sus pedidos anteriores.

- Panel de administración: Los administradores tienen acceso a un panel de administración donde pueden gestionar productos, ver pedidos y realizar un seguimiento del inventario.

## Uso

1. Clona este repositorio en tu máquina local.
2. Configura una base de datos compatible en el archivo `application.properties`.
3. Ejecuta la aplicación utilizando `mvn spring-boot:run` o importa el proyecto en tu IDE y ejecútalo desde allí.

## Requisitos

- Java 8 o superior.
- Maven.

## Contribuciones

Las contribuciones son bienvenidas. Si deseas colaborar, puedes realizar un fork del repositorio, crear una rama para tu funcionalidad/fix y luego enviar una solicitud de extracción.

## Licencia

Este proyecto está bajo la Licencia [MIT](LICENSE).