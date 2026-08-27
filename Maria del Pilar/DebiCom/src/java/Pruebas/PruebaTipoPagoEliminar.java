/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pruebas;

import Controlador.TipoPagoDAO;
import java.util.Scanner;

public class PruebaTipoPagoEliminar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TipoPagoDAO dao = new TipoPagoDAO();
        
        try {
            System.out.print("Ingrese el ID del tipo de pago que desea eliminar: ");
            int idTipoPago = sc.nextInt();
            
            if (dao.eliminarTipoPago(idTipoPago)) {
                System.out.println("Tipo de pago eliminado correctamente");
            } else {
                System.out.println("No se encontro el tipo de pago para eliminar");
            }
        } catch (Exception e) {
            System.out.println("No se pudo eliminar el tipo de pago");
        }
    }
}