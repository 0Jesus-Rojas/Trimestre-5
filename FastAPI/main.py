#pip install fastapi
#pip install uvicorn
#python -m pip install "uvicorn[standart]"
#python -m pip install uvicorn --verbose
#python -m uvicorn main:app -reload

#Generar la url para verificar la url
#uvicorn main app --reload

#Importar la clase fastAPI desde el paquete fastAPI
#Es el motor para crear las api WEB
from fastapi import FastAPI

#Me crea una instancia de la aplicacion
#y app es una variable que sera la que utiliza el servidor para ejecutar la API
app = FastAPI()

#Es un decorador, "programacion moderna", definimos la ruta
#definimos la url respondiendo a solicitudes get
@app.get("/")

#definimos la funcion que se ejecutara cuando alguien soicite la URL raiz

def inicio():
#la funcion inicio nos devuelve un diccionario
#la  API automaticamente
    return{"mensaje": "Hola esta es mi API att JR"}

#main.py es el archivo principal que contiene la fastapi
#  "/" Definidas las rutas o pat