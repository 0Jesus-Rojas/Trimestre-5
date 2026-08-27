/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pruebas;

import Controlador.PagosDAO;
import java.util.Scanner;

/**
 *
 * @author Jesus
 */
public class PruebaPagosEliminar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PagosDAO dao = new PagosDAO();
        
        System.out.print("Ingrese el ID del pago que desea eliminar: ");
        int idEliminar = sc.nextInt();
        
        boolean resultado = dao.eliminarPago(idEliminar);
        
        if (resultado) {
            System.out.println("Pago eliminado correctamente");
        } else {
            System.out.println("No se pudo eliminar el pago");
        }
    }
}