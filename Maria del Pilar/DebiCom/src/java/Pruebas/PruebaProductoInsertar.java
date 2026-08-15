/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pruebas;
import Controlador.ProductoDAO;
import Modelo.Productos;
import java.util.Scanner;
/**
 *
 * @author Jesus
 */
public class PruebaProductoInsertar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Productos miProducto = new Productos();
        ProductoDAO dao = new ProductoDAO();
        
        System.out.print("Ingrese el nombre del producto: ");
        miProducto.setNombre(sc.nextLine());
        
        System.out.print("Ingrese la descripcion del producto: ");
        miProducto.setDescripcion(sc.nextLine());
        
        System.out.print("Ingrese el precio del producto: ");
        miProducto.setPrecioFinal(sc.nextFloat());
        
        System.out.print("Ingrese la unidad del producto: ");
        miProducto.setIdUnidades(sc.nextInt());
        
        boolean resultado = dao.InsertarProducto(miProducto);
        if(resultado){
            System.out.println("Se registro el producto correctamente");
        }else{
            System.out.println("No se pudo registrar el producto");
        }
    }
}
