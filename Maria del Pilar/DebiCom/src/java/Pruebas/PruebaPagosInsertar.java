/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pruebas;

import Controlador.PagosDAO;
import Modelo.Pagos;
import java.sql.Date;
import java.util.Scanner;

/**
 *
 * @author Jesus
 */
public class PruebaPagosInsertar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pagos miPago = new Pagos();
        PagosDAO dao = new PagosDAO();
        
        System.out.print("Ingrese el numero de referencia del pago: ");
        miPago.setNumeroReferenciaPago(sc.nextFloat());
        sc.nextLine();
        
        System.out.print("Ingrese la fecha del pago (En este formato YYYY-MM-DD): ");
        String fechaPagoTexto = sc.nextLine();
        Date fechaPagoSql = Date.valueOf(fechaPagoTexto);
        miPago.setFechaPago(fechaPagoSql);
        
        System.out.print("Ingrese el ID del tipo de pago: ");
        miPago.setIdTipoPago(sc.nextInt());
        
        boolean resultado = dao.insertarPago(miPago);
        if (resultado) {
            System.out.println("Se registro el pago correctamente");
        } else {
            System.out.println("No se pudo registrar el pago");
        }
    }
}