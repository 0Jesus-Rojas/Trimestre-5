/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pruebas;
import Modelo.Productos;
import Controlador.ProductoDAO;
import java.util.Scanner;
/**
 *
 * @author Jesus
 */
public class PruebaProductoActualizar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Productos miProducto = new Productos();
        ProductoDAO dao = new ProductoDAO();
        
        System.out.print("Ingrese el ID del producto que desea actualizar: ");
        int actualizar = sc.nextInt();
        miProducto.setIdProducto(actualizar);
        sc.nextLine();
        
        System.out.print("Ingrese el nuevo nombre del producto: ");
        miProducto.setNombre(sc.nextLine());
        
        System.out.print("Ingrese la nueva descripcion del producto: ");
        miProducto.setDescripcion(sc.nextLine());
        
        System.out.print("Ingrese el nuevo precio del producto: ");
        miProducto.setPrecioFinal(sc.nextFloat());
        
        boolean resultado = dao.actualizarProducto(miProducto);
        
        if(resultado){
            System.out.println("Producto actualizado");
        }else{
            System.out.println("No se pudo actualizar el producto");
        }
    }
}