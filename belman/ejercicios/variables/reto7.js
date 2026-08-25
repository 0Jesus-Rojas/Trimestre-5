// Esta función simula el comportamiento del hoisting con var.
// Sin modificar el orden de las líneas, haz que la función retorne un objeto con:
//{ antes: undefined, despues: "Oscar" }
// Pista: declara "nombre" con var después del primer acceso.
function demostrarHoisting() {
  const antes = nombre;
  var nombre = `Oscar`;
  const despues = nombre;
  return(antes, despues)
}