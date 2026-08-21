from fastapi import FastAPI, Depends, HTTPException
from fastapi.middleware.cors import CORSMiddleware
from sqlalchemy.orm import Session

from database import Base, engine, get_db
from schemas import UsuarioCreate, UsuarioResponse
import crud

# 1. PREPARACIÓN INICIAL:
# Traemos la herramienta para crear la API (FastAPI), herramientas de seguridad y control, 
# y conectamos todos los archivos creados anteriormente (database, schemas y crud).

# Crear tablas (idealmente usar Alembic en producción)
Base.metadata.create_all(bind=engine)
# 2. CONSTRUCTOR AUTOMÁTICO:
# Revisa la base de datos y, si la tabla "usuarios" aún no existe, la crea de inmediato usando el motor.

app = FastAPI(
    title="Api usuarios universitaria",
    version="1.0.0"
)
# 3. CREAR LA APLICACIÓN:
# Inicia el sistema FastAPI asignándole un nombre y número de versión.

app.add_middleware(
    CORSMiddleware,
    allow_origins=[
        "http://localhost:5173",
        "http://127.0.0.1:5173"
    ],
    allow_credentials=True,
    allow_methods=["*"],
    allow_headers=["*"]
)
# 4. PERMISO DE ENTRADA (CORS):
# Es la lista de invitados. Por seguridad, los navegadores bloquean peticiones entre diferentes webs.
# Este bloque dice: "Permite que la aplicación web que corre en el puerto 5173 (ej. un proyecto con Vite/React)
# pueda hacerle consultas a este sistema".


# --- RUTAS DE ATENCIÓN (ENDPOINTS) ---

@app.get("/")
def inicio():
    return {"mensaje": "bienvenido al programa usuarios"}
# 5. RUTA DE BIENVENIDA:
# Cuando alguien entra a la dirección principal (la raíz "/"), responde con un saludo sencillo.


@app.get(
    "/listadeusuarios",
    response_model=list[UsuarioResponse]
)
def obtener_usuarios(db: Session = Depends(get_db)):
    return crud.obtener_usuarios(db)
# 6. RUTA PARA PEDIR LA LISTA COMPLETA:
# - @app.get: Escucha peticiones para "CONSULTAR".
# - Depends(get_db): Pide prestada una conexión ordenada a la base de datos.
# - Llama a crud.obtener_usuarios() y devuelve la lista de personas filtrada con la plantilla UsuarioResponse.


@app.post(
    "/agregarusuarios",
    response_model=UsuarioResponse,
    status_code=201
)
def agregar_usuario(
    datos: UsuarioCreate,
    db: Session = Depends(get_db)
):
    return crud.crear_usuario(db, datos)
# 7. RUTA PARA CREAR UN USUARIO:
# - @app.post: Escucha peticiones para "ENVIAR/GUARDAR" información.
# - status_code=201: Código estándar de internet que significa "Creado con éxito".
# - Valida los datos entrantes con UsuarioCreate, se los pasa a la base de datos y responde con el usuario creado.


@app.get(
    "/listadeusuarios/{id}",
    response_model=UsuarioResponse
)
def obtener_usuario(
    id: int,
    db: Session = Depends(get_db)
):
    usuario = crud.obtener_usuario(db, id)

    if usuario is None:
        raise HTTPException(
            status_code=404,
            detail="Usuario no encontrado"
        )

    return usuario
# 8. RUTA PARA BUSCAR UN USUARIO POR SU ID:
# - Recibe un ID numérico en la dirección (ej: /listadeusuarios/5).
# - Si no existe en la base de datos, lanza un error 404 ("No encontrado").
# - Si existe, entrega la ficha de esa persona.


@app.delete("/eliminarusuario/{id}")
def eliminar_usuario(
    id: int,
    db: Session = Depends(get_db)
):
    usuario = crud.eliminar_usuario(db, id)

    if usuario is None:
        raise HTTPException(
            status_code=404,
            detail="Usuario no encontrado"
        )

    return {
        "mensaje": "Usuario eliminado exitosamente"
    }
# 9. RUTA PARA BORRAR UN USUARIO:
# - @app.delete: Escucha órdenes de "ELIMINACIÓN".
# - Busca el ID especificado. Si no lo encuentra da error 404, y si lo encuentra lo borra y responde con una confirmación.