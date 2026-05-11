# Eva2FullStack - API Figuras Warhammer 40k

Integrantes: Daniel Mora, Lucas Toledo, Javier Rodriguez
Docente: Byron Andres Aros Araya

---

## Descripcion del Proyecto

El desarrollo de este proyecto consiste en la creacion de una API RESTful orientada a la gestion y venta de figuras del universo Warhammer 40k. El sistema esta construido bajo la arquitectura CSR (Controller, Service, Repository) y utiliza buenas practicas de desarrollo moderno.

Tecnologias y herramientas integradas:
- JPA Hibernate: Para el modelado, normalizacion y persistencia de datos relacionales.
- Bean Validation: Para asegurar la integridad de los datos entrantes.
- Patron DTO: Para la transferencia segura de datos hacia y desde el cliente.
- Manejo de Excepciones: Respuestas HTTP estructuradas y controladas.
- Git y GitHub: Gestion de versiones y trabajo colaborativo fluido.

---

## Endpoints de la API (Guia para Postman)

A continuacion, se detallan las rutas disponibles divididas por entidad y metodo HTTP. Todas las rutas parten de la base http://localhost:8080.

### GET (Lectura y Busquedas)
Productos:
- GET /api/v1/productos : Mostrar todos los productos registrados.
- GET /api/v1/productos/{id} : Buscar un producto especifico por su ID.

Marcas:
- GET /api/v1/marcas : Mostrar todas las marcas.
- GET /api/v1/marcas/{id} : Buscar una marca por su ID.

Categorias:
- GET /api/v1/categoria : Mostrar todas las categorias.
- GET /api/v1/categoria/{id} : Buscar una categoria por ID.
- GET /api/v1/categoria/categorias-true : Filtrar y mostrar solo las categorias activas (status true).
- GET /api/v1/categoria/categorias-false : Filtrar y mostrar solo las categorias inactivas (status false).

Ediciones:
- GET /api/v1/edicion : Mostrar todas las ediciones.
- GET /api/v1/edicion/{id} : Buscar edicion por ID.

### POST (Creacion de Registros)
(Se debe enviar un body en formato JSON).
- POST /api/v1/productos : Agregar un producto nuevo al catalogo.
- POST /api/v1/marcas : Registrar una nueva marca.
- POST /api/v1/categoria : Crear una nueva categoria.
- POST /api/v1/edicion : Ingresar una nueva edicion.

### PUT (Actualizacion)
(Se debe indicar el ID en la URL y enviar un body JSON con los datos actualizados).
- PUT /api/v1/marcas/{id} : Editar los datos de una marca existente.
- PUT /api/v1/categoria/{id} : Actualizar la informacion de una categoria.
- PUT /api/v1/edicion/{id} : Modificar los datos de una edicion.

### DELETE (Eliminacion)
(Solo requiere el ID en la URL).
- DELETE /api/v1/productos/{id} : Eliminar un producto del sistema.
- DELETE /api/v1/marcas/{id} : Borrar una marca.
- DELETE /api/v1/categoria/{id} : Eliminar una categoria.
- DELETE /api/v1/edicion/{id} : Eliminar una edicion.

---

## Ejemplos de Cargas Utiles

1. Crear una Marca (POST /api/v1/marcas)

{
    "nombre": "Games Workshop",
    "descripcion": "Fabricante oficial de miniaturas de Warhammer 40k."
}

2. Crear una Edicion (POST /api/v1/edicion)

{
    "nombre": "10ma Edicion - Leviathan",
    "descripcion": "Caja de lanzamiento con Marines Espaciales vs Tiranidos."
}
3. Crear un Producto (POST /api/v1/productos)

Nota: Asegurate de que los IDs de marca y edicion existan en la BD antes de disparar este JSON

{
    "nombre": "Space Marine Captain",
    "descripcion": "Figura de Capitan de los Ultramarines armado con espada de energia.",
    "fechaCreacion": "2026-05-11",
    "id_marca": 1,
    "id_edicion": 1
}