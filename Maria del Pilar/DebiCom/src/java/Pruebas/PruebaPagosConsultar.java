/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pruebas;

import Controlador.PagosDAO;
import Modelo.Pagos;
import java.util.Scanner;

/**
 *
 * @author Jesus
 */
public class PruebaPagosConsultar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PagosDAO miPagoDAO = new PagosDAO();
        
        System.out.print("Ingrese el ID del pago que desea buscar: ");
        int busqueda = sc.nextInt();
        Pagos miPago = miPagoDAO.consultarPago(busqueda);
        
        if (miPago != null) {
            System.out.println("ID Pago: " + miPago.getIdPago());
            System.out.println("Numero Referencia: " + miPago.getNumeroReferenciaPago());
            System.out.println("Fecha Pago: " + miPago.getFechaPago());
            System.out.println("ID Tipo Pago: " + miPago.getIdTipoPago());
        } else {
            System.out.println("No se encontro el Pago");
        }
    }
}