/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pruebas;

import Controlador.TipoPagoDAO;
import Modelo.TipoPago;
import java.util.Scanner;

public class PruebaTipoPagoActualizar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TipoPago miTipoPago = new TipoPago();
        TipoPagoDAO dao = new TipoPagoDAO();
        
        System.out.print("Ingrese el ID del tipo de pago que desea actualizar: ");
        int idActualizar = sc.nextInt();
        miTipoPago.setIdTipoPago(idActualizar);
        sc.nextLine(); // Limpiar el buffer del Scanner
        
        System.out.print("Ingrese el nuevo nombre del tipo de pago: ");
        miTipoPago.setNombrePago(sc.nextLine());
        
        boolean resultado = dao.actualizarTipoPago(miTipoPago);
        
        if (resultado) {
            System.out.println("Tipo de pago actualizado correctamente");
        } else {
            System.out.println("No se pudo actualizar el tipo de pago");
        }
    }
}