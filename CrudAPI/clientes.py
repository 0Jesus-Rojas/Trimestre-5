from fastapi import FastAPI
from pydantic import BaseModel
#python -m uvicorn clientes:Cli --reload

Cli = FastAPI()
#Esta lista es para mostrar los datos extraidos de la clase pero de la clase vienen en tipo objeto y los convierto a diccionario dentro de la lista
clientes = []

class Cliente(BaseModel):
    id:int
    nombre:str
    apellido:str
    documento:int
    edad:int

@Cli.get("/clientes")
def listar():
    return clientes

@Cli.post("/clientes")
def insertar(cliente:Cliente):
    clientes.append(cliente.model_dump())
    return{"Mensaje": "Cliente insertado correctamente"}

@Cli.delete("clientes/{id}")
def eliminar(id:int):
    for cliente in clientes:
        if cliente["id"]==id:
            clientes.remove(cliente)
            return{"Mensaje": "El cliente se elimino"}
    return{"Mensaje": " El producto no existe"}