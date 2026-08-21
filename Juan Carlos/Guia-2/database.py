import os
from sqlalchemy import create_engine
from sqlalchemy.orm import sessionmaker, declarative_base
from dotenv import load_dotenv

# 1. HERRAMIENTAS: Importamos librerías (bloques de construcción ya hechos).
# 'os' ayuda a hablar con el sistema operativo.
# 'sqlalchemy' ayuda a hablar con bases de datos.
# 'dotenv' permite leer un archivo de configuraciones secretas.

# Cargar las variables de entorno desde el archivo .env
load_dotenv()
# 2. LECTOR DE SECRETOS: Lee un archivo oculto llamado ".env" donde guardas contraseñas o rutas privadas para no escribirlas directamente en el código.

# Obtener la URL de la base de datos leyendo la variable de entorno
DATABASE_URL = os.getenv("DATABASE_URL")
# 3. BUSCAR LA DIRECCIÓN: Busca en ese archivo secreto la dirección web o ruta de acceso a la base de datos y la guarda en una variable.

# Si no existe la variable de entorno, es buena práctica manejar el error
if not DATABASE_URL:
    raise ValueError("La variable de entorno DATABASE_URL no está configurada")
# 4. FRENO DE SEGURIDAD: Si se nos olvidó poner la dirección en el archivo secreto, el programa se detiene de inmediato y nos avisa del problema.

# Crear el motor de SQLAlchemy pasándole la cadena de texto con la URL
engine = create_engine(DATABASE_URL)
# 5. EL MOTOR (LA TUBERÍA): Crea el canal principal de comunicación o la "tubería" que conecta nuestro programa con la base de datos.

SessionLocal = sessionmaker(
    bind=engine,
    autoflush=False,
    autocommit=False,
)
# 6. FABRICA DE ATENDEDORES: Configura una "fábrica" para crear atendores
# individuales (sesiones). Cada vez que necesitemos hacer una consulta, esta fábrica nos dará un atendendor configurado para trabajar con el motor.

Base = declarative_base()
# 7. EL MOLDE BASE: Crea una plantilla que usaremos más adelante para diseñar las tablas de la base de datos como si fueran objetos de Python.

# Generador de sesiones para inyección de dependencias en FastAPI
def get_db():
    db = SessionLocal()  # A) Contrata/abre un atendedor para un usuario.
    try:
        yield db         # B) Se lo presta temporalmente a la app para trabajar.
    finally:
        db.close()       # C) Sin importar qué pase (error o éxito), se asegura
                         #    de despedir/cerrar la sesión para no gastar memoria.
# 8. EL PRESTAMISTA DE CONEXIONES: Una función inteligente que abre una sesión, te la presta mientras guardas o lees datos, y la cierra automáticamente al terminar.