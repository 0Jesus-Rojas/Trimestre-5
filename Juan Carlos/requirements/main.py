#python -m uvicorn main:app
from fastapi import FastAPI
from pydantic import BaseModel
from typing import List

#crear la aplicacion
app = FastAPI()

#Modelo de los datos
class Task(BaseModel):
    id: int
    name: str
    completed: bool = False

#Nuestra simulacion de la base de datos

db = [
        {"id": 1, "name": "Tarea 1", "completed": False},
        {"id": 2, "name": "Tarea 2", "completed": True}
      ]

#Creacion de la ruta principañ
@app.get("/")
def inicio():
    return{"mensaje": "Bienvenido al sistema"}

@app.get("/tasks", response_model=List[Task])
def get_task():
    return db

#crear una nueva tarea
@app.post("/tasks", response_model=Task)
def crear_task(task: Task):
    db.append(task.dict())
    return task