## Getting Started

1) Instalar IntelliJ IDEA.
2) Instalar Docker
3) Abrir carpeta del proyecto.
4) Si no anda, preguntarle a iaka xd

## Cómo levantar la base de datos?

En la carpeta del proyecto, correr el comando `docker compose up`.
Esto levanta una base de MySQL con los datos definidos en el archivo `docker-compose.yml`.

## Qué se puede hacer por ahora?

Al darle play en el IDE, el proyecto levanta un web service en localhost:8080.

### Endpoints:

- `/` --> Responde "Hello!"
- `/hello` --> Responde "Hello <name>!" pasándole como parámetro un nombre. Ejemplo: `/hello?name=iaka`.