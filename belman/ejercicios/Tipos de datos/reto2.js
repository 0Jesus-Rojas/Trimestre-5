//Recibe un parámetro "valor". Retorna un objeto con:
//{ tipo: typeof valor, esString: true/false, esNumber: true/false }
function diferenciarStringNumber(valor) {
  return{
    Tipo: typeof valor,
    esString: typeof valor === 'string',
    esNumber: typeof valor === 'number'
  };
}