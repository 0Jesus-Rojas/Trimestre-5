/*Declara una variable con let llamada "mensaje" e inicialízala con "hola" Luego reasígnala a "adiós"*/

function reasignarMensaje() {
  let mensaje = `hola`;
  const inicial = mensaje;
  mensaje = "adios";

  return{inicial, final:mensaje};
}