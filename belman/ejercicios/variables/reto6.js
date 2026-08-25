// Dentro de la función ya están declaradas tres variables.
// Completa el return usando typeof para cada una.
function identificarTipos() {
  const edad = 25;
  const nombre = "JavaScript";
  const activo = true;

  return {
    tipoEdad: typeof edad, // Reemplaza undefined por typeof de edad
    tipoNombre: typeof nombre, // Reemplaza undefined por typeof de nombre
    tipoActivo: typeof activo, // Reemplaza undefined por typeof de activo
  };
}