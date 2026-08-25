// Declara las siguientes constantes con los valores indicados:
//   texto = "hola"
//   numero = 42
//   booleano = true
//   nulo = null
//   indefinido = undefined
//   simbolo = Symbol("id")
//   grande = 123n
// Retorna un objeto con el typeof de cada una:
//   { texto, numero, booleano, nulo, indefinido, simbolo, grande }
// donde cada valor es el resultado de typeof sobre la variable.
function identificarPrimitivos() {
  let texto = `hola`;
  let numero = 42;
  let booleano = true;
  let nulo = null;
  let indefinido = undefined;
  let simbolo = Symbol("id");
  let grande = 123n;

  return{
    tipoTexto: typeof texto,
    tipoNumero: typeof numero,
    tipoBooleano: typeof booleano,
    tipoNulo: typeof nulo,
    tipoIndefinido: typeof indefinido,
    tipoSimbolo: typeof simbolo,
    tipoGrande: typeof grande
  }
}