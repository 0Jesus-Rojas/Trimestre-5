#python -m uvicorn main2:app --reload
from fastapi import FastAPI
app = FastAPI()

#GET
@app.get("/")
def inicio():
    return {"Mensaje": "Pagina principal de pat o ruta raiz"}

#post
@app.post("/saludar")
def saludar(datos: dict):
    return{
        "mensaje": f"hola {datos['nombre']} , bienvenido a esta pagina"
    }