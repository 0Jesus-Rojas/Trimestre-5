/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pruebas;

import Controlador.TipoPagoDAO;
import Modelo.TipoPago;
import java.util.Scanner;

public class PruebaTipoPagoConsultar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TipoPagoDAO miTipoPagoDAO = new TipoPagoDAO();
        
        System.out.print("Ingrese el ID del tipo de pago que desea buscar: ");
        int busqueda = sc.nextInt();
        
        TipoPago miTipoPago = miTipoPagoDAO.consultarTipoPago(busqueda);
        
        if (miTipoPago != null) {
            System.out.println("ID Tipo Pago: " + busqueda);
            System.out.println("Nombre del Pago: " + miTipoPago.getNombrePago());
        } else {
            System.out.println("No se encontro el Tipo de Pago");
        }
    }
}