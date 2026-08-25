// Recibe un parámetro "valor".
// Determina si es primitivo o complejo y retorna un objeto con:
//   { valor, tipo: typeof valor, clasificacion: "primitivo" | "complejo" }
// Reglas:
//   - Si es null, clasificación es "primitivo" (a pesar de typeof).
//   - Si typeof es "object" o "function", clasificación es "complejo".
//   - En cualquier otro caso, clasificación es "primitivo".
// Pista: primero verifica si es null, luego revisa typeof.
function clasificarTipo(valor) {
  // Tu código aquí
}