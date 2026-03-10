☕ Lunar Owl API

Backend de una aplicación inspirada en Starbucks, diseñada para gestionar productos, pedidos y operaciones de una cafetería digital.

Este repositorio contiene solo la API REST, desarrollada con Spring Boot.
El frontend está en un repositorio separado.

🎯 Objetivo del proyecto

Construir una arquitectura tipo cliente-servidor, donde:

Backend (este repositorio)
gestiona lógica de negocio, base de datos y API.

Frontend (otro repositorio)
consume la API y muestra la interfaz al usuario.

La idea es recrear funcionalidades similares a aplicaciones de cafeterías como Starbucks.

🚀 Funcionalidades actuales

✔ Crear productos
✔ Subir imágenes de productos
✔ Filtrar productos por categoría
✔ Manejo de tamaños disponibles
✔ API REST para consumo desde frontend

🔜 Funcionalidades planeadas

🛒 Sistema de carrito de compras

📦 Generación de pedidos

👤 Gestión de usuarios

💳 Simulación de pagos

📜 Historial de pedidos

🔐 Autenticación con JWT

⭐ Sistema de favoritos

📦 Estructura del producto

Cada producto contiene:

name → nombre del producto

price → precio

description → descripción

imageUrl → ruta de la imagen

category → categoría

sizes → tamaños disponibles

available → disponibilidad
