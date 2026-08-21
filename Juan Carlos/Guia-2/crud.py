from sqlalchemy.orm import Session
from models import Usuario
from schemas import UsuarioCreate

# 1. HERRAMIENTAS:
# Traemos el conector de la base de datos (Session), la estructura de la tabla (Usuario) 
# y las reglas del formulario que llena el usuario (UsuarioCreate).


def obtener_usuarios(db: Session):
    return db.query(Usuario).all()

# 2. BUSCAR TODOS:
# Le dice al asistente: "Ve a la tabla de usuarios y tráeme una lista con TODOS los registros que encuentres".


def obtener_usuario(db: Session, usuario_id: int):
    return (
        db.query(Usuario)
        .filter(Usuario.id == usuario_id)
        .first()
    )

# 3. BUSCAR UNO ESPECÍFICO:
# Le dice al asistente: "Busca en la tabla de usuarios, filtra por el ID que te di 
# y entrégame el PRIMERO que coincida (o nada si no existe)".


def crear_usuario(db: Session, datos: UsuarioCreate):
    nuevo_usuario = Usuario(**datos.model_dump())
    
    db.add(nuevo_usuario)
    db.commit()
    db.refresh(nuevo_usuario)
    return nuevo_usuario

# 4. GUARDAR UN USUARIO NUEVO:
# A) datos.model_dump() toma los datos validados y los empaqueta para crear el registro.
# B) db.add(): Coloca al nuevo usuario en la "caja de salida" (aún no se ha guardado en el disco).
# C) db.commit(): ¡El paso clave! Confirma el cambio y lo guarda permanentemente en la base de datos.
# D) db.refresh(): Actualiza el objeto para traer el ID que la base de datos le asignó automáticamente.
# E) Devuelve el usuario completo recién creado.


def eliminar_usuario(db: Session, usuario_id: int):
    usuario = obtener_usuario(db, usuario_id)

    if usuario is None:
        return None

    db.delete(usuario)
    db.commit()
    
    return usuario

# 5. BORRAR UN USUARIO:
# A) Primero usa la función del punto 3 para ver si la persona realmente existe.
# B) Si no existe, no hace nada y devuelve "None" (vacío).
# C) Si sí existe, lo marca para eliminar (db.delete) y confirma la orden de borrado (db.commit).
# D) Devuelve la ficha del usuario que acaba de borrar para confirmar qué se eliminó.