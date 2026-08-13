from fastapi import FastAPI

app = FastAPI()

#=========================
#Lista de usuarios
#=========================

usuarios = [
    {
        "id": 1,
        "nombre": "Juan",
        "apellido": "Perez",
        "telefono": "3208529637",
        "edad": 40
    },
    {
        "id": 2,
        "nombre": "Maria",
        "apellido": "Gomez",
        "telefono": "3208529638",
        "edad": 35
    }
]

#=========================
#Lista de usuarios
#=========================
@app.get("/")
def inicio():
    return "Bienvenido al programa usuarios"

#=========================
#Listar todos los usuarios
#=========================

@app.get("/Listadeusuarios")
def obtener_usuarios():
    return usuarios

#=========================
#Agregar usuario
#=========================

@app.post("/agregarusuarios")
def agregar_usuarios(
    nombre: str,
    apellido: str,
    telefono: str,
    edad: int
):
    nuevo_id = len(usuarios) + 1

    nuevo_usuario = {
        "id": nuevo_id,
        "nombre": nombre,
        "apellido": apellido,
        "telefono":  telefono
    }

    usuarios.append(nuevo_usuario)

    return{
        "mensaje": "Usuario agregado correctamente",
        "usuario": nuevo_usuario
    }

#=========================
#Buscar usuario por ID
#=========================
@app.get("/listadeusuarios/{id}")
def obtener_usuario(id:int):
    for usuario in usuarios:
        if usuario["id"] == id:
            return usuario

    return{
        "Mensaje": "Usuario no encontrado"
    }

#=========================
#Buscar usuario por ID
#=========================

@app.delete("/eliminarusuario/{id}")
def eliminar_usuario(id:int):
    for usuario in usuarios:
        if usuario["id"] == id:
            usuarios.remove(usuario)

            return{
                "mensaje": "Usuario eliminado exitosamente",
                "usuario": usuario
            }
    return{
        "mensaje": "Usuario no encontrado"
    }

#uvicorn main:app --reload