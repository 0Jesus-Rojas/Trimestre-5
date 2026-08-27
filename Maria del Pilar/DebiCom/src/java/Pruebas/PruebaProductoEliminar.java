/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pruebas;
import Controlador.ProductoDAO;
import java.util.Scanner;
/**
 *
 * @author Jesus
 */
public class PruebaProductoEliminar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProductoDAO dao = new ProductoDAO();
        
        try {
            System.out.print("Ingrese el ID del producto que desea eliminar: ");
            int idProducto = sc.nextInt();
            
            if(dao.eliminarProducto(idProducto))
                System.out.println("Producto eliminado");
        } catch (Exception e) {
            System.out.println("No se pudo eliminar el producto");
        }
    }
}