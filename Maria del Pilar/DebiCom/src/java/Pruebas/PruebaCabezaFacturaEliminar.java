/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pruebas;

import Controlador.CabezaFacturaDAO;
import java.util.Scanner;

/**
 * @author Jesus
 */
public class PruebaCabezaFacturaEliminar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CabezaFacturaDAO dao = new CabezaFacturaDAO();
        
        try {
            System.out.print("Ingrese el ID de la cabeza de factura que desea eliminar: ");
            int idCabezaFactura = sc.nextInt();
            
            if (dao.eliminarCabezaFactura(idCabezaFactura)) {
                System.out.println("Cabeza de factura eliminada correctamente");
            } else {
                System.out.println("No se encontró la cabeza de factura especificada");
            }
        } catch (Exception e) {
            System.out.println("Error al intentar eliminar la cabeza de factura: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}