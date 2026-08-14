from fastapi import FastAPI
from pydantic import BaseModel
#python -m uvicorn main:sencillo --reload

sencillo = FastAPI()
productos = [] #Esta lista es para mostrar los datos extraidos de la 
#clase pero de la clase vienen en tipo objeto y los convierto a diccionario dentro de la lista

class Producto(BaseModel):
    id:int
    nombre:str
    precio:float
    cantidad:int

class Cliente(BaseModel):
    id:int
    nombre:str
    apellido:str
    documento:int
    edad:int

@sencillo.get("/productos")
def listar():
    return productos

@sencillo.post("/productos")
def insertar(producto:Producto):
    productos.append(producto.model_dump())
    return {"Mensaje": "Producto creado y agregado"}

@sencillo.delete("/productos/{id}")
def eliminar(id:int):
    for producto in productos:
        if producto["id"]==id:
            productos.remove(producto)
            return{"mensaje": "El producto se elimino"}

    return{"Mensaje": " El producto no existe"}

@sencillo.put("/productos/{id}")
def actualizar(id:int, producto:Producto):
    for i,p in enumerate(productos):
        if p["id"] == id:
            productos[i]=producto.model_dump()
            return{"Mensaje": "Producto actualizado"}