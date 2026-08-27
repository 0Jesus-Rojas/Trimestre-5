/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pruebas;

import Controlador.DetalleFacturaDAO;
import Modelo.DetalleFacturas;
import java.util.Scanner;

/**
 *
 * @author Jesus
 */
public class PruebaDetalleFacturaConsultar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DetalleFacturaDAO miDetalleDAO = new DetalleFacturaDAO();
        
        System.out.print("Ingrese el ID del detalle de factura que desea buscar: ");
        int busqueda = sc.nextInt();
        
        DetalleFacturas miDetalle = miDetalleDAO.consultarDetalleFactura(busqueda);
        
        if(miDetalle != null){
            System.out.println("ID Detalle Factura: " + miDetalle.getIdDetalleFactura());
            System.out.println("Cantidad: " + miDetalle.getCantidad());
            System.out.println("Precio Final: " + miDetalle.getPrecioFinal());
            System.out.println("ID Cabeza Factura: " + miDetalle.getIdCabezaFactura());
            System.out.println("ID Producto: " + miDetalle.getIdProducto());
        }else{
            System.out.println("No se encontro el detalle de la factura");
        }
    }
}