/*Declara una constante precioBase con valor 100 Declara una variable descuento con let e inicialízala en 10.
Reasigna descuento a 25. calcula el total como: precioBase - descuento. Retorna un objeto: 
{ precioBase, descuento, total }*/

function calcularTotal() {
  const precioBase = 100;
  let descuento = 10;
  descuento = 25;
  const total = precioBase - descuento;
  return{precioBase, descuento, total}
}