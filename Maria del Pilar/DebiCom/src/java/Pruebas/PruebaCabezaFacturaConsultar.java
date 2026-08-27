/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pruebas;

import Controlador.CabezaFacturaDAO;
import Modelo.CabezaFacturas;
import java.util.Scanner;

/**
 * @author Jesus
 */
public class PruebaCabezaFacturaConsultar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CabezaFacturaDAO miFacturaDAO = new CabezaFacturaDAO();
        
        System.out.print("Ingrese el ID de la cabeza de factura que desea buscar: ");
        int busqueda = Integer.parseInt(sc.nextLine());
        
        CabezaFacturas miFactura = miFacturaDAO.consultarCabezaFactura(busqueda);
        
        if (miFactura != null) {
            System.out.println("ID Factura: " + miFactura.getIdCabezaFactura());
            System.out.println("Número de Factura: " + miFactura.getNumeroFactura());
            System.out.println("Documento: " + miFactura.getDocumentoFactura());
            System.out.println("Subtotal: " + miFactura.getSubTotal());
            System.out.println("Fecha Emisión: " + miFactura.getFechaEmision());
            System.out.println("Fecha Vencimiento: " + miFactura.getFechaVencimiento());
            System.out.println("ID Cliente: " + miFactura.getIdCliente());
            System.out.println("ID Pago: " + miFactura.getIdPago());
        } else {
            System.out.println("No se encontró la factura especificada.");
        }
        
        sc.close();
    }
}