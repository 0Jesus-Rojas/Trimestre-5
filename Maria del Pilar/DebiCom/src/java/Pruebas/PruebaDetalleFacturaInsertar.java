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
public class PruebaDetalleFacturaInsertar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DetalleFacturas miDetalle = new DetalleFacturas();
        DetalleFacturaDAO dao = new DetalleFacturaDAO();
        
        System.out.print("Ingrese la cantidad: ");
        miDetalle.setCantidad(sc.nextInt());
        
        System.out.print("Ingrese el precio final: ");
        miDetalle.setPrecioFinal(sc.nextFloat());
        
        System.out.print("Ingrese el ID de la cabeza de factura: ");
        miDetalle.setIdCabezaFactura(sc.nextInt());
        
        System.out.print("Ingrese el ID del producto: ");
        miDetalle.setIdProducto(sc.nextInt());
        
        boolean resultado = dao.insertarDetalleFactura(miDetalle);
        if(resultado){
            System.out.println("Se registro el detalle de la factura correctamente");
        }else{
            System.out.println("No se pudo registrar el detalle de la factura");
        }
    }
}