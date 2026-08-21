from pydantic import BaseModel

# 1. LA HERRAMIENTA DE VALIDACIÓN:
# 'BaseModel' es una plantilla de la librería Pydantic que comprueba automáticamente que los datos recibidos sean del tipo correcto.

class UsuarioBase(BaseModel):
    nombre: str     # Debe ser texto (String)
    apellido: str   # Debe ser texto
    telefono: str   # Debe ser texto
    edad: int       # Debe ser un número entero (Integer)
    
# 2. EL MOLDE GENERAL (LO BÁSICO DE UN USUARIO):
# Define los datos mínimos que caracterizan a un usuario en el sistema. Si alguien intenta enviar una edad como texto (ej. "veinte"), este molde da error.


class UsuarioCreate(UsuarioBase):
    pass
    
# 3. MOLDE PARA CREAR UN USUARIO:
# Hereda (copia) todo lo de UsuarioBase. Se usa cuando un cliente se registra. No pide el "id" porque cuando estás CREANDO un usuario, la base de datos 
# aún no le ha asignado ese número único. "pass" significa "usa las mismas reglas".


class UsuarioResponse(UsuarioBase):
    id: int  

    class Config:
        from_attributes = True

# 4. MOLDE PARA RESPONDER AL CLIENTE:
# Hereda lo de UsuarioBase, pero AQUÍ SÍ incluye el "id", porque al devolver los 
# datos del usuario a la pantalla, ya tenemos el número asignado por la base de datos.
#
# La sección 'Config':
# 'from_attributes = True' le enseña a este molde a leer directamente los datos 
# que vienen de la base de datos (SQLAlchemy) y convertirlos a este formato fácil de enviar.