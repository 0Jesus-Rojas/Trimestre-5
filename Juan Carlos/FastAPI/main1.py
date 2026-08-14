#python -m uvicorn main1:app --reload
from fastapi import FastAPI

app = FastAPI()

@app.get("/")
def inicio():
    return{"Mensaje": "aqui estamos en la raiz principal del proyecto '/'"}

@app.get("/cliente")
def cliente():
    return{
        "id": 1234,
        "nombre": "Jeimy",
        "Programa": "ADSO"
    }

@app.get("/TipoDocumento")
def TipoDocumento():
    return[
        {
            "id": 1,
            "TipoDocumento": "Cedula"
        },{
            "id": 2,
            "TipoDocumento": "Cedula de extranjeria"
        }
    ]

@app.get("/Usuarios")
def Usuarios():
    return[
        {
            "id_usuario": 1,
            "nombre_usuario": "Arley",
            "Apellidos_usuario": "Montanez",
            "Identificacion": "1594872630",
            "correo": "Arley@gmail.com",
            "Telefono": 1562394878,
            "direccion": "Por ahi",
            "Password": "contrasenia",
            "Id_tipo_identificacion": 1
        },{
            "id_usuario": 2,
            "nombre_usuario": "Jesus",
            "Apellidos_usuario": "Rojas",
            "Identificacion": 7894561266,
            "Correo": "Jesus@gmail.com",
            "Telefono": "1592634987",
            "direccion": "por alla",
            "Password": "password",
            "Id_tipo_identificacion": 2
        }
    ]

@app.get("/Perfiles")
def Perfiles():
    return[
        {
        "id_perfil": 1,
        "nombre_perfil": "Administrador",
        "id_usuario": "1"
        },
        {
        "id_perfil": 2,
        "nombre_perfil": "Supervisor",
        "id_usuario": "2"
        }
    ]