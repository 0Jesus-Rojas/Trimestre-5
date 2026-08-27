/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pruebas;

import Controlador.CabezaFacturaDAO;
import Modelo.CabezaFacturas;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author Jesus
 */
public class PruebaCabezaFacturaActualizar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CabezaFacturas miFactura = new CabezaFacturas();
        CabezaFacturaDAO dao = new CabezaFacturaDAO();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");

        try {
            System.out.print("Ingrese el ID de la cabeza de factura que desea actualizar: ");
            int idActualizar = Integer.parseInt(sc.nextLine());
            miFactura.setIdCabezaFactura(idActualizar);

            System.out.print("Ingrese el nuevo número de factura: ");
            miFactura.setNumeroFactura(sc.nextLine());

            System.out.print("Ingrese el nuevo documento de la factura (número entero): ");
            miFactura.setDocumentoFactura(Integer.parseInt(sc.nextLine()));

            System.out.print("Ingrese el nuevo subtotal: ");
            miFactura.setSubTotal(Float.parseFloat(sc.nextLine()));

            System.out.print("Ingrese la nueva fecha de emisión (yyyy-MM-dd): ");
            String fechaEmisionStr = sc.nextLine();
            Date fechaEmision = formatoFecha.parse(fechaEmisionStr);
            miFactura.setFechaEmision(fechaEmision);

            System.out.print("Ingrese la nueva fecha de vencimiento (yyyy-MM-dd): ");
            String fechaVencimientoStr = sc.nextLine();
            Date fechaVencimiento = formatoFecha.parse(fechaVencimientoStr);
            miFactura.setFechaVencimiento(fechaVencimiento);

            System.out.print("Ingrese el nuevo ID del cliente: ");
            miFactura.setIdCliente(Integer.parseInt(sc.nextLine()));

            System.out.print("Ingrese el nuevo ID de pago: ");
            miFactura.setIdPago(Integer.parseInt(sc.nextLine()));

            boolean resultado = dao.actualizarCabezaFactura(miFactura);
            if (resultado) {
                System.out.println("Cabeza de factura actualizada correctamente.");
            } else {
                System.out.println("No se pudo actualizar la cabeza de factura.");
            }

        } catch (ParseException e) {
            System.out.println("Error: Formato de fecha inválido. Debe ser yyyy-MM-dd.");
        } catch (NumberFormatException e) {
            System.out.println("Error: Formato numérico inválido ingresado.");
        } finally {
            sc.close();
        }
    }
}