from sqlalchemy import Column, Integer, String
from database import Base

# 1. HERRAMIENTAS Y MOLDE:
# Importamos los tipos de datos (Números enteros, Texto) y el "molde base" que preparamos en el archivo anterior para poder crear tablas.

class Usuario(Base):
    # 2. EL NOMBRE DE LA TABLA:
    # Le indicamos a la base de datos que esta tabla se llamará exactamente "usuarios".
    __tablename__ = "usuarios"

    # 3. IDENTIFICADOR ÚNICO (ID):
    # Es el número de documento o folio.
    # - Integer: Guarda números enteros (1, 2, 3...).
    # - primary_key=True: Es la clave principal única de cada persona (nunca se repite).
    # - index=True: Crea un "índice" para que buscar usuarios por ID sea súper rápido.
    id = Column(Integer, primary_key=True, index=True)

    # 4. NOMBRE:
    # - String(100): Solo acepta texto de máximo 100 caracteres.
    # - nullable=False: Es obligatorio (no se puede dejar en blanco).
    nombre = Column(String(100), nullable=False)

    # 5. APELLIDO:
    # Funciona igual que el nombre: texto de hasta 100 caracteres y obligatorio.
    apellido = Column(String(100), nullable=False)

    # 6. TELÉFONO:
    # Guardado como texto (hasta 20 caracteres) para permitir símbolos como +57 o espacios, y también es un campo obligatorio.
    telefono = Column(String(20), nullable=False)

    # 7. EDAD:
    # Guarda un número entero y tampoco permite dejarse en blanco.
    edad = Column(Integer, nullable=False)