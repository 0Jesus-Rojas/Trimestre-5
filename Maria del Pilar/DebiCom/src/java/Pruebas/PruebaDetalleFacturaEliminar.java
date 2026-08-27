/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pruebas;

import Controlador.DetalleFacturaDAO;
import java.util.Scanner;

/**
 *
 * @author Jesus
 */
public class PruebaDetalleFacturaEliminar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DetalleFacturaDAO dao = new DetalleFacturaDAO();
        
        try {
            System.out.print("Ingrese el ID del detalle de factura que desea eliminar: ");
            int idDetalleFactura = sc.nextInt();
            
            if(dao.eliminarDetalleFactura(idDetalleFactura))
                System.out.println("Detalle de factura eliminado");
        } catch (Exception e) {
            System.out.println("No se pudo eliminar el detalle de factura");
        }
    }
}