/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pruebas;

import Modelo.DetalleFacturas;
import Controlador.DetalleFacturaDAO;
import java.util.Scanner;

/**
 *
 * @author Jesus
 */
public class PruebaDetalleFacturaActualizar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DetalleFacturas miDetalle = new DetalleFacturas();
        DetalleFacturaDAO dao = new DetalleFacturaDAO();
        
        System.out.print("Ingrese el ID del detalle de factura que desea actualizar: ");
        int actualizar = sc.nextInt();
        miDetalle.setIdDetalleFactura(actualizar);
        
        System.out.print("Ingrese la nueva cantidad: ");
        miDetalle.setCantidad(sc.nextInt());
        
        System.out.print("Ingrese el nuevo precio final: ");
        miDetalle.setPrecioFinal(sc.nextFloat());
        
        System.out.print("Ingrese el nuevo ID de la cabeza de factura: ");
        miDetalle.setIdCabezaFactura(sc.nextInt());
        
        System.out.print("Ingrese el nuevo ID del producto: ");
        miDetalle.setIdProducto(sc.nextInt());
        
        boolean resultado = dao.actualizarDetalleFactura(miDetalle);
        
        if(resultado){
            System.out.println("Detalle de factura actualizado");
        }else{
            System.out.println("No se pudo actualizar el detalle de la factura");
        }
    }
}